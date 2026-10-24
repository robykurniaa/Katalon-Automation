package limitedOffers

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import support.CommonUtils
import java.time.*
import com.kms.katalon.core.model.FailureHandling
import java.util.concurrent.TimeUnit

public abstract class LimitedOfferBasePage {

	// ================== CONSTANTS ==================
	protected static final int MAX_SWIPE = 8
	protected static final int DEFAULT_INDEX = 1

	// ================== ABSTRACT METHODS ==================
	protected abstract List<Map<String, String>> getPackages()
	protected abstract String getLogPrefix()

	// ================== PUBLIC METHODS ==================

	/**
	 * Validasi semua paket (nama + harga)
	 * @return Set<String> berisi nama-nama paket yang berhasil divalidasi
	 */
	/**
	 * Validasi semua paket (nama + harga)
	 * @return Set<String> berisi nama-nama paket yang berhasil divalidasi
	 */
	public Set<String> validateAllPackages() {
		List<Map<String, String>> packages = getPackages()

		if (packages.isEmpty()) {
			KeywordUtil.logInfo("${getLogPrefix()}: No packages available")
			return Collections.emptySet()
		}

		Set<String> foundPackages = searchAndHandlePackages(packages, false)

		// Membuat list baru untuk menggabungkan nama dan harga khusus untuk log
		List<String> foundDetails = new ArrayList<>()
		for (String packageName : foundPackages) {
			// Cari data paket asli berdasarkan namanya untuk mendapatkan harga
			Map<String, String> pkgData = packages.find { it['name'] == packageName }
			String price = pkgData != null ? pkgData['price'] : "Price Not Found"
			foundDetails.add("[${packageName} - ${price}]")
		}

		Collections.sort(foundDetails)

		// Print hasil akhir lengkap dengan nama dan harganya
		KeywordUtil.logInfo("${getLogPrefix()}: Found ${foundPackages.size()}/${packages.size()} packages: ${foundDetails}")

		return foundPackages
	}

	/**
	 * Tap paket berdasarkan index (1-based)
	 * @param index Index paket (default: 1)
	 * @return Set<String> berisi nama paket yang ditap
	 */
	public Set<String> tapPackageByIndex(int index = DEFAULT_INDEX) {
		List<Map<String, String>> packages = getPackages()

		if (packages.isEmpty()) {
			KeywordUtil.markWarning("${getLogPrefix()}: No packages available")
			return Collections.emptySet()
		}

		// Validasi index
		if (index < 1 || index > packages.size()) {
			KeywordUtil.markWarning("${getLogPrefix()}: Index ${index} out of range. Using default index ${DEFAULT_INDEX}")
			index = DEFAULT_INDEX
		}

		Map<String, String> selectedPackage = packages.get(index - 1)
		KeywordUtil.logInfo("${getLogPrefix()}: Selected package [${index}]: ${selectedPackage['name']} - ${selectedPackage['price']}")

		return searchAndHandlePackages([selectedPackage], true)
	}

	/**
	 * Tap paket berdasarkan nama
	 * @param packageName Nama paket (full atau partial)
	 * @return Set<String> berisi nama paket yang ditap
	 */
	public Set<String> tapPackageByName(String packageName) {
		List<Map<String, String>> packages = getPackages()

		if (packages.isEmpty()) {
			KeywordUtil.markWarning("${getLogPrefix()}: No packages available")
			return Collections.emptySet()
		}

		// Cari paket berdasarkan nama
		Map<String, String> selectedPackage = packages.find { it['name'] == packageName }
		if (selectedPackage == null) {
			// Coba partial match
			selectedPackage = packages.find { it['name']?.toLowerCase()?.contains(packageName.toLowerCase()) }
		}

		if (selectedPackage == null) {
			KeywordUtil.markWarning("${getLogPrefix()}: Package '${packageName}' not found. Using first package.")
			selectedPackage = packages.get(0)
		}

		KeywordUtil.logInfo("${getLogPrefix()}: Selected package by name: ${selectedPackage['name']} - ${selectedPackage['price']}")

		return searchAndHandlePackages([selectedPackage], true)
	}

	// ================== PROTECTED CORE METHODS ==================

	protected Set<String> searchAndHandlePackages(List<Map<String, String>> packageList, boolean tapIfFound) {
		Set<String> foundPackages = new LinkedHashSet<>()
		int swipeCount = 0

		if (packageList.isEmpty()) {
			KeywordUtil.logInfo("${getLogPrefix()}: No packages to search")
			return foundPackages
		}

		KeywordUtil.logInfo("${getLogPrefix()}: Starting search for ${packageList.size()} packages")

		// Loop sampai semua paket ditemukan atau sudah swipe maksimal
		while (foundPackages.size() < packageList.size() && swipeCount < MAX_SWIPE) {
			KeywordUtil.logInfo("${getLogPrefix()}: === Iteration ${swipeCount + 1} ===")
			KeywordUtil.logInfo("${getLogPrefix()}: Already found: ${foundPackages.size()}/${packageList.size()}")

			// Cari semua paket yang belum ditemukan
			for (Map<String, String> pkg : packageList) {
				String packageName = pkg['name']
				String expectedPrice = pkg['price']

				if (foundPackages.contains(packageName)) {
					KeywordUtil.logInfo("${getLogPrefix()}: Skipping already found: ${packageName}")
					continue
				}

				// Validasi nama dan harga
				boolean packageFound = verifyPackageExists(packageName, expectedPrice)

				if (packageFound) {
					KeywordUtil.logInfo("${getLogPrefix()}: Found: ${packageName} (Price: ${expectedPrice})")
					CommonUtils.captureScreenshot("${getLogPrefix()}_Found_${packageName}")

					if (tapIfFound) {
						tapPackage(packageName)
						return Collections.singleton(packageName) as Set
					}

					foundPackages.add(packageName)
				} else {
					//KeywordUtil.logInfo("Not found: ${packageName}")
				}
			}

			// Cek apakah sudah ditemukan semua
			if (foundPackages.size() >= packageList.size()) {
				KeywordUtil.logInfo("${getLogPrefix()}: All packages found!")
				break
			}

			// Jika belum semua ditemukan dan masih bisa swipe, SWIPE
			if (swipeCount < MAX_SWIPE - 1) {
				swipeCount++
				KeywordUtil.logInfo("${getLogPrefix()}: Swiping left (attempt ${swipeCount}/${MAX_SWIPE})")
				swipeLeft()
				Mobile.delay(2) // Tunggu sebentar setelah swipe
			} else {
				swipeCount++
				KeywordUtil.logInfo("${getLogPrefix()}: Max swipe reached (${MAX_SWIPE})")
				break
			}
		}

		KeywordUtil.logInfo("${getLogPrefix()}: Search complete. Found ${foundPackages.size()}/${packageList.size()} packages")
		return foundPackages
	}

	protected boolean verifyPackageExists(String packageName, String expectedPrice) {
		// Validasi package name
		TestObject nameObj = buildTestObject(packageName, 'name')
		boolean nameFound = Mobile.verifyElementExist(nameObj, 3, FailureHandling.OPTIONAL)

		// Validasi price (jika ada)
		boolean priceFound = true
		if (expectedPrice != null && !expectedPrice.trim().isEmpty()) {
			TestObject priceObj = buildTestObject(expectedPrice, 'price')
			priceFound = Mobile.verifyElementExist(priceObj, 3, FailureHandling.OPTIONAL)
		}

		return nameFound && priceFound
	}

	protected void tapPackage(String packageName) {
		try {
			Mobile.scrollToText(packageName)
			KeywordUtil.logInfo("${getLogPrefix()}: Scrolled to: ${packageName}")
		} catch (Exception e) {
			KeywordUtil.logInfo("${getLogPrefix()}: Scroll failed: ${e.message} - continuing...")
		}

		TestObject nameObj = buildTestObject(packageName, 'name')
		Mobile.waitForElementPresent(nameObj, 5, FailureHandling.OPTIONAL)
		Mobile.tap(nameObj, 5)
		KeywordUtil.logInfo("${getLogPrefix()}: Tapped: ${packageName}")
		CommonUtils.captureScreenshot("${getLogPrefix()}_Tapped_${packageName}")
	}

	// ================== SWIPE METHODS ==================

	public void swipeLeft() {
		swipe("left")
	}

	public void swipeRight() {
		swipe("right")
	}

	protected void swipe(String direction) {
		TestObject container = findTestObject('Object Repository/Mobile/Android/AXISNet New Object/Limited Offer/LO Swipe Pkg')

		try {
			int x = Mobile.getAttribute(container, "x", 10) as Integer
			int y = Mobile.getAttribute(container, "y", 10) as Integer
			int width = Mobile.getAttribute(container, "width", 10) as Integer
			int height = Mobile.getAttribute(container, "height", 10) as Integer

			int startX, endX, startY, endY

			if (direction.equalsIgnoreCase("left")) {
				startX = x + (int)(width * 0.8)
				endX = x + (int)(width * 0.2)
				startY = y + (height / 2)
				endY = startY
			} else {
				startX = x + (int)(width * 0.2)
				endX = x + (int)(width * 0.8)
				startY = y + (height / 2)
				endY = startY
			}

			Mobile.swipe(startX, startY, endX, endY)
			KeywordUtil.logInfo("${getLogPrefix()}: Swiped ${direction}")
		} catch (Exception e) {
			KeywordUtil.markWarning("${getLogPrefix()}: Failed to swipe ${direction}: ${e.message}")
		}
	}

	// ================== HELPER METHODS ==================

	protected TestObject buildTestObject(String value, String type = 'name') {
		String xpath

		switch (type.toLowerCase()) {
			case 'price':
			// XPath untuk price
				xpath = String.format(
				"//android.widget.TextView[@resource-id='com.axis.net:id/discountedPriceTv' and @text='%s']",
				value
				)
				break

			case 'pattern':
			// XPath untuk pattern matching (kata pertama saja)
				String firstWord = value.toLowerCase().replace("'", "\\'")
				xpath = String.format(
						"//android.widget.TextView[contains(translate(@text, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), '%s')]",
						firstWord
						)
				break

			case 'name':
			default:
			// XPath untuk package name
				String lowerValue = value.toLowerCase()
				String safeValue = lowerValue.replace("'", "\\'")
				xpath = String.format(
						"//android.widget.TextView[@resource-id='com.axis.net:id/titleTv' and contains(translate(@text, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), '%s')]",
						safeValue
						)
				break
		}

		TestObject to = new TestObject('TO_' + type.toLowerCase() + '_' + value.replaceAll('\\s+', '_').replaceAll('[^a-zA-Z0-9_]', ''))
		to.addProperty('xpath', ConditionType.EQUALS, xpath)
		return to
	}

	// ================== UTILITY METHODS ==================

	/**
	 * Get paket berdasarkan index (1-based)
	 * @param index Index paket (1-based)
	 * @return Map berisi name dan price, atau null jika tidak ditemukan
	 */
	public Map<String, String> getPackageByIndex(int index) {
		List<Map<String, String>> packages = getPackages()
		if (packages.isEmpty() || index < 1 || index > packages.size()) {
			return null
		}
		return new LinkedHashMap<>(packages.get(index - 1))
	}

	/**
	 * Print semua paket
	 */
	public void printPackages() {
		List<Map<String, String>> packages = getPackages()
		if (packages.isEmpty()) {
			KeywordUtil.logInfo("${getLogPrefix()}: No packages available")
			return
		}

		KeywordUtil.logInfo("${getLogPrefix()}: Packages:")
		for (int i = 0; i < packages.size(); i++) {
			Map<String, String> pkg = packages.get(i)
			KeywordUtil.logInfo("  ${i + 1}. ${pkg['name']} - ${pkg['price']}")
		}
	}

	/**
	 * Get jumlah paket
	 * @return Jumlah paket
	 */
	public int getPackageCount() {
		return getPackages().size()
	}
}