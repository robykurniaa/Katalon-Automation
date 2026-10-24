package tpr

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.util.KeywordUtil
import support.CommonUtils
import axisnet_support.LocatorPaths as Locator

public class TPRPackageSearcher {

	public static Set<String> searchAndHandlePackages(List<Map<String, String>> packageList,
			boolean tapIfFound,
			TPRConstants.SearchType searchType = TPRConstants.SearchType.BOTH) {
			
		Set<String> foundPackages = new LinkedHashSet<>()
		int swipeCount = 0

		if (packageList == null || packageList.isEmpty()) {
			KeywordUtil.logInfo('No packages provided to search.')
			return foundPackages
		}

		KeywordUtil.logInfo("Starting search for ${packageList.size()} packages with SearchType: ${searchType}")

		while (foundPackages.size() < packageList.size() && swipeCount < TPRConstants.MAX_SWIPE) {
			KeywordUtil.logInfo("=== Iteration ${swipeCount + 1} ===")
			KeywordUtil.logInfo("Already found: ${foundPackages.size()}/${packageList.size()}")

			for (Map<String, String> pkg : packageList) {
				String packageName = pkg['name']
				String expectedPrice = pkg['price']

				if (foundPackages.contains(packageName)) {
					KeywordUtil.logInfo("Skipping already found: ${packageName}")
					continue
				}

				// Melempar SearchType ke Validator (apapun enum-nya)
				boolean packageFound = TPRPackageValidator.verifyPackageExists(packageName, expectedPrice, searchType)

				if (packageFound) {
					KeywordUtil.logInfo("Found package on screen: ${packageName}")
					captureScreenshotSafe(packageName)

					if (tapIfFound) {
						TPRPackageValidator.tapPackage(packageName)
						KeywordUtil.logInfo("Found and tapped package on screen: ${packageName} (Price: ${expectedPrice})")
						return Collections.singleton(packageName)
					} else {
						foundPackages.add(packageName)
					}
				}
			}

			if (foundPackages.size() >= packageList.size()) {
				KeywordUtil.logInfo("All packages found!")
				break
			}

			if (swipeCount < TPRConstants.MAX_SWIPE - 1) {
				swipeCount++
				KeywordUtil.logInfo("Swiping left (${swipeCount}/${TPRConstants.MAX_SWIPE})")
				CommonUtils.swipe(Locator.PKG_SWIPE_KEY, 'left')
				Mobile.delay(2)
			} else {
				swipeCount++
				KeywordUtil.logInfo("Max swipe reached (${TPRConstants.MAX_SWIPE})")
				break
			}
		}

		KeywordUtil.logInfo("Search complete. Found ${foundPackages.size()} / ${packageList.size()}")
		return foundPackages
	}

	private static void captureScreenshotSafe(String name) {
		try {
			CommonUtils.captureScreenshot(name)
		} catch (Exception e) {
			KeywordUtil.logInfo("Failed to capture screenshot: ${e.message}")
		}
	}
}