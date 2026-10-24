package limitedOffers

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import support.CommonUtils
import support.LocatorUtil
import axisnet_support.LocatorPaths as Locator
import com.kms.katalon.core.model.FailureHandling
import internal.GlobalVariable

public class LimitedOfferNationalPage {

	private static final int MAX_SWIPE = 8
	private static final int DEFAULT_INDEX = 1

	// ================== DATA HELPER ==================
	/**
	 * Helper untuk mempermudah input nama dan harga paket.
	 * Cukup panggil pkg('Nama Paket', 'Rp10.000')
	 */
	private static Map<String, String> pkg(String name, String price) {
		return ['name': name, 'price': price]
	}

	// ================== PACKAGE SCHEDULE ==================
	private static final Map<Integer, List<Map<String, String>>> PACKAGE_SCHEDULE = [
		27: [
			pkg('BOOSTR SOSMED 3GB 7hr', 'Rp7.500'),
			pkg('BRONET 8.5GB 3hr', 'Rp13.400'),
			pkg('BOOSTR KUOTA UTAMA 5GB 7hr', 'Rp10.500'),
			pkg('BRONET GO 11GB 14hr', 'Rp30.000'),
			pkg('BRONET 6GB + Free Whatsapp 3hr', 'Rp11.400')
		],
		28: [
			pkg('BOOSTR KUOTA UTAMA 3GB 7hr', 'Rp7.500'),
			pkg('BRONET 8.5GB 3hr', 'Rp13.400'),
			pkg('BRONET 10GB + Free Whatsapp 5hr', 'Rp18.050'),
			pkg('BRONET GO 7.5GB 14hr', 'Rp25.000'),
			pkg('BRONET 30GB + TikTok 2GB 28hr', 'Rp70.000'),
		],
		29: [
			pkg('BRONET 6GB + Free Whatsapp 3hr', 'Rp7.500'),
			pkg('BRONET GO 120GB 14hr', 'Rp100.000'),
			pkg('BRONET 14GB 60hr + Kuota di Kotamu', 'Rp75.000'),
			pkg('BOOSTR KUOTA UTAMA 5GB 7hr', 'Rp10.500')
		]
	]

	// ================== UTILITIES ==================
	private static List<Map<String, String>> getTodayPackages() {
		int today = new Date().format('d') as Integer
		def packages = PACKAGE_SCHEDULE.getOrDefault(today, [])
		KeywordUtil.logInfo("Today's packages (day ${today}): ${packages.size()} packages")
		return packages
	}

	// ================== PUBLIC METHODS ==================

	public static Set<String> handlingLoNasOnboarded() {
		def packages = getTodayPackages()
		if (packages.isEmpty()) return [] as Set

		Set<String> foundPackages = searchAndHandlePackages(packages, false)
		KeywordUtil.logInfo("Found ${foundPackages.size()}/${packages.size()} packages for LO Nasional Onboarded")
		return foundPackages
	}

	public static Set<String> handlingLoNasPackage(int index = DEFAULT_INDEX) {
		def packages = getTodayPackages()
		if (packages.isEmpty()) {
			KeywordUtil.markWarning("No packages available for today")
			return [] as Set
		}

		int validIndex = (index in 1..packages.size()) ? index : DEFAULT_INDEX
		def selectedPackage = packages[validIndex - 1]

		KeywordUtil.logInfo("Selected package [${validIndex}]: ${selectedPackage.name} - ${selectedPackage.price}")
		return searchAndHandlePackages([selectedPackage], true)
	}

	public static Set<String> handlingLoNasPackage(String packageName) {
		def packages = getTodayPackages()
		if (packages.isEmpty()) {
			KeywordUtil.markWarning("No packages available for today")
			return [] as Set
		}

		def selectedPackage = packages.find { it.name.equalsIgnoreCase(packageName) } ?:
		packages.find { it.name.toLowerCase().contains(packageName.toLowerCase()) } ?:
		packages.first()

		KeywordUtil.logInfo("Selected package by name: ${selectedPackage.name} - ${selectedPackage.price}")
		return searchAndHandlePackages([selectedPackage], true)
	}

	// ============ CORE ENGINE ============

	private static Set<String> searchAndHandlePackages(List<Map<String, String>> targetPackages, boolean tapIfFound) {
		Set<String> foundPackages = []
		int swipeCount = 0

		while (foundPackages.size() < targetPackages.size() && swipeCount < MAX_SWIPE) {
			KeywordUtil.logInfo("=== Iteration ${swipeCount + 1} | Found: ${foundPackages.size()}/${targetPackages.size()} ===")

			targetPackages.findAll { !foundPackages.contains(it.name) }.each { pkg ->
				if (verifyPackageExists(pkg.name, pkg.price)) {
					KeywordUtil.logInfo("Found: ${pkg.name} (Price: ${pkg.price})")
					CommonUtils.captureScreenshot("Found_${pkg.name}")

					foundPackages << pkg.name

					if (tapIfFound) {
						tapPackage(pkg.name)
						return [pkg.name] as Set // Langsung return jika mode tap
					}
				}
			}

			if (foundPackages.size() >= targetPackages.size()) break

				swipeLeft()
			Mobile.delay(2)
			swipeCount++
		}

		if (swipeCount >= MAX_SWIPE) KeywordUtil.logInfo("Max swipe reached (${MAX_SWIPE})")
		return foundPackages
	}

	private static boolean verifyPackageExists(String packageName, String expectedPrice) {
		boolean nameFound = Mobile.verifyElementExist(buildTestObject(packageName, 'name'), 2, FailureHandling.OPTIONAL)

		if (!nameFound) {
			KeywordUtil.logInfo("[-] NOT FOUND (NAME): Package '${packageName}' not found on screen.")
			return false
		}

		boolean priceFound = !expectedPrice ? true :
				Mobile.verifyElementExist(buildTestObject(expectedPrice, 'price'), 2, FailureHandling.OPTIONAL)

		if (!priceFound) {
			KeywordUtil.logInfo("[-] NOT FOUND (PRICE): Package '${packageName}' Found, BUT price '${expectedPrice}' not match.")
			return false
		}

		return true
	}

	private static void tapPackage(String packageName) {
		try {
			Mobile.scrollToText(packageName, FailureHandling.OPTIONAL)
		} catch (Exception e) {
			KeywordUtil.logInfo("Scroll to text ignored: ${e.message}")
		}

		def nameObj = buildTestObject(packageName, 'name')
		Mobile.waitForElementPresent(nameObj, 5, FailureHandling.OPTIONAL)
		Mobile.tap(nameObj, 5)
		KeywordUtil.logInfo("Tapped: ${packageName}")
		CommonUtils.captureScreenshot("Tapped_${packageName}")
	}

	// ============ HELPER & SWIPE ============

	private static TestObject buildTestObject(String value, String type = 'name') {
		String xpath = type.equalsIgnoreCase('price')
				? "//android.widget.TextView[@resource-id='com.axis.net:id/discountedPriceTv' and @text='${value}']"
				: "//android.widget.TextView[@resource-id='com.axis.net:id/titleTv' and contains(translate(@text, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), '${value.toLowerCase().replace("'", "\\'")}')]"

		String objId = "${type}_${value.replaceAll('\\W+', '_')}"
		def to = new TestObject(objId)
		to.addProperty('xpath', ConditionType.EQUALS, xpath)
		return to
	}

	public static void swipeLeft() {
		swipe("left")
	}
	public static void swipeRight() {
		swipe("right")
	}

	private static void swipe(String direction) {
		def container = findTestObject('Object Repository/Mobile/Android/AXISNet New Object/Limited Offer/LO Swipe Pkg')
		try {
			int x = Mobile.getAttribute(container, "x", 10) as Integer
			int y = Mobile.getAttribute(container, "y", 10) as Integer
			int w = Mobile.getAttribute(container, "width", 10) as Integer
			int h = Mobile.getAttribute(container, "height", 10) as Integer

			int startX = direction == "left" ? x + (int)(w * 0.8) : x + (int)(w * 0.2)
			int endX = direction == "left" ? x + (int)(w * 0.2) : x + (int)(w * 0.8)
			int midY = y + (h / 2)

			Mobile.swipe(startX, midY, endX, midY)
			KeywordUtil.logInfo("Swiped ${direction}")
		} catch (Exception e) {
			KeywordUtil.markWarning("Swipe failed: ${e.message}")
		}
	}

	// ============ MANAGEMENT METHODS ============

	public static void setPackageSchedule(int day, List<Map<String, String>> packages) {
		if (!(day in 1..31)) throw new IllegalArgumentException("Day must be 1-31")
		PACKAGE_SCHEDULE[day] = new ArrayList<>(packages)
	}

	public static void setPackageScheduleLegacy(int day, List<String> packageNames) {
		setPackageSchedule(day, packageNames.collect { pkg(it, '') })
	}

	public static int getTodayPackageCount() {
		return getTodayPackages().size()
	}
	public static Set<Integer> getScheduledDays() {
		return new TreeSet<>(PACKAGE_SCHEDULE.keySet())
	}
}