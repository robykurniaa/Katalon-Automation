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
import pages.LimitedOfferNationalPage as LimitedOffer
import com.kms.katalon.core.model.FailureHandling


import internal.GlobalVariable


class LimitedOfferSelectedCitiesPage {

	private static final int MAX_SWIPE = 8

	// ====== DATA SOURCE ======
	private static List<String> getLO77CitiesPackages() {
		return Arrays.asList(
				'BOOSTR KUOTA UTAMA 3GB 7hr',
				'BRONET SOSMED 9GB 3hr',
				'BRONET 24JAM 8GB 7HR',
				'BRONET 24Jam 16GB 28hr'
				)
	}

	// ====== PUBLIC ENTRY POINTS ======

	public static void handlingLO77Cities() {
		List<String> packages = getLO77CitiesPackages()
		searchAndHandlePackages(packages, false)
	}

	public static void handlingLO77CitiesPackage(String packageName) {
		List<String> packages = getLO77CitiesPackages()

		String selectedPackage = (packageName == null || packageName.trim().isEmpty())
				? packages.get(0)
				: packageName

		searchAndHandlePackages(Collections.singletonList(selectedPackage), true)
	}

	// ====== CORE SEARCH ======

	private static Set<String> searchAndHandlePackages(List<String> packageList, boolean tapIfFound) {
		Set<String> foundPackages = new HashSet<>()
		int swipeCount = 0

		while (foundPackages.size() < packageList.size() && swipeCount < MAX_SWIPE) {
			for (String pkg : packageList) {
				if (!foundPackages.contains(pkg)) {
					TestObject to = buildTestObject(pkg)

					if (Mobile.verifyElementExist(to, 3, FailureHandling.OPTIONAL)) {
						KeywordUtil.logInfo("Found " + pkg)

						if (tapIfFound) {
							KeywordUtil.logInfo("Tap flag is TRUE for: " + pkg)
							Mobile.scrollToText(pkg)
							Mobile.waitForElementPresent(to, 5, FailureHandling.OPTIONAL)
							Mobile.tap(to, 5)
							KeywordUtil.logInfo("Tapped " + pkg)
							// langsung return kalau tujuannya cuma satu paket
							return Collections.singleton(pkg)
						}

						foundPackages.add(pkg)
					}
				}
			}

			if (foundPackages.size() < packageList.size()) {
				LimitedOffer.swipeLeft("left")
				swipeCount++
			}
		}
		return foundPackages
	}

	// ====== HELPER ======

	private static TestObject buildTestObject(String packageName) {
		String lowerPkg = packageName.toLowerCase()
		String xpath = String.format(
				"//android.widget.TextView[@resource-id='com.axis.net:id/titleTv' " +
				"and contains(translate(@text, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), '%s')]",
				lowerPkg
				)

		TestObject to = new TestObject(packageName)
		to.addProperty('xpath', ConditionType.EQUALS, xpath)
		return to
	}
}
