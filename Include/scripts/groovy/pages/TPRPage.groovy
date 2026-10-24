package pages

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil

import support.CommonUtils
import java.time.*
import support.exceptions.TestActionException
import support.exceptions.*
import support.LocatorUtil
import axisnet_support.LocatorPaths as Locator
import com.kms.katalon.core.model.FailureHandling

import internal.GlobalVariable

public class TPRPage {

	private static final int MAX_SWIPE = 8

	// ============ MAIN ENTRY POINT ============

	public static void handlingJumatBaikOnboarded() {
		List<String> packages = [
			'PROMO BRONET 8GB 7HR',
			'BRONET 5GB 28HR',
			'BRONET 7GB 28HR',
			'BRONET 12GB 28HR',
			'BRONET 18GB 28HR'
		]
		searchAndHandlePackages(packages, false)
	}

	public static void handlingJumatBaikPackage() {
		List<String> packages = ['PROMO BRONET 8GB 7HR']
		searchAndHandlePackages(packages, true)
	}

	public static void handlingBoostrWeekendPackage() {
		List<String> packages = ['BOOSTR 1GB 1hr']
		searchAndHandlePackages(packages, true)
	}

	public static void handlingRabuRawitOnboarded() {
		List<String> packages = [
			'PROMO BRONET 16GB 60HR',
			'BRONET 24JAM 5GB 28HR',
			'BRONET 24JAM 8GB 28HR',
			'BRONET 24JAM 14GB 28HR',
			'BRONET 24JAM 21GB 28HR'
		]
		searchAndHandlePackages(packages, false)
	}

	public static void handlingRabuRawitPackage() {
		List<String> packages = ['BRONET 24JAM 6GB 28HR']
		searchAndHandlePackages(packages, true)
	}

	public static void handlingBoostrWeekendOnboarded() {
		DayOfWeek today = ZonedDateTime.now(ZoneId.of("Asia/Jakarta")).getDayOfWeek()
		List<String> packages = []

		switch (today) {
			case DayOfWeek.SATURDAY:
				KeywordUtil.logInfo("Saturday special package list")
				packages = [
					'BOOSTR 1GB 2hr',
					'BOOSTR 2GB 2hr',
					'BOOSTR 3GB 2hr',
					'BOOSTR 1GB 1hr',
					'BOOSTR 2GB 1hr',
					'BOOSTR 3GB 1hr',
					'Bronet Sosmed 9GB 3hr'
				]
				break
			case DayOfWeek.SUNDAY:
				KeywordUtil.logInfo("Sunday special package list")
				packages = [
					'BOOSTR 1GB 1hr',
					'BOOSTR 2GB 1hr',
					'BOOSTR 3GB 1hr',
					'PROMO BRONET 16GB 60hr',
					'OWSEM 16GB + Unli Games 30hr',
					'Bronet Sosmed 9GB 3hr'
				]
				break
			default:
				KeywordUtil.logInfo("There are no special packages for today: ${today}")
				return
		}

		if (packages.isEmpty()) {
			KeywordUtil.logInfo("The package list is empty.")
			return
		}

		Set<String> found = searchAndHandlePackages(packages, false)

		List<String> notFound = packages - found
		if (notFound.isEmpty()) {
			KeywordUtil.markPassed("All packages found.")
		} else {
			KeywordUtil.markWarning("Some packages were not found: ${notFound}")
		}
	}

	// ============ REUSABLE CORE METHOD ============

	private static Set<String> searchAndHandlePackages(List<String> packageList, boolean tapIfFound) {
		Set<String> foundPackages = new HashSet<>()
		int swipeCount = 0

		while (foundPackages.size() < packageList.size() && swipeCount < MAX_SWIPE) {
			for (String pkg : packageList) {
				if (!foundPackages.contains(pkg)) {
					TestObject nameObj = buildTestObject(pkg)

					if (Mobile.verifyElementExist(nameObj, 3, FailureHandling.OPTIONAL)) {
						CommonUtils.captureScreenshot(pkg)
						if (tapIfFound) Mobile.tap(nameObj, 5)
						foundPackages.add(pkg)
						KeywordUtil.logInfo("found package by name: ${pkg}")
					}

					break
				}
			}

			if (foundPackages.size() < packageList.size()) {
				CommonUtils.swipe(Locator.PKG_SWIPE_KEY, 'left')
				swipeCount++
			}
		}
		return foundPackages
	}

	// Build object form package name
	private static TestObject buildTestObject(String packageName) {
		String xpath = "//android.widget.TextView[@resource-id='com.axis.net:id/productNameTv' and translate(@text, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz')='${packageName.toLowerCase()}']"
		TestObject to = new TestObject()
		to.addProperty('xpath', ConditionType.EQUALS, xpath)
		return to
	}
}