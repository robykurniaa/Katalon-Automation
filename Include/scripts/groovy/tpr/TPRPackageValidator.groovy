package tpr

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.model.FailureHandling

public class TPRPackageValidator {

	public static boolean verifyPackageExists(String packageName, String expectedPrice,
			TPRConstants.SearchType searchType) {

		boolean nameFound = false
		boolean priceFound = false
		boolean hasExpectedPrice = (expectedPrice != null && !expectedPrice.trim().isEmpty())

		switch (searchType) {
			case TPRConstants.SearchType.PACKAGE_NAME:
				return isPackageNameVisible(packageName)

			case TPRConstants.SearchType.PRICE:
				if (!hasExpectedPrice) {
					KeywordUtil.markWarning("SearchType is PRICE but expected price is empty for package: ${packageName}")
					return false
				}
				return isPriceVisible(expectedPrice)

			case TPRConstants.SearchType.ANY:
				nameFound = isPackageNameVisible(packageName)
				if (hasExpectedPrice) {
					priceFound = isPriceVisible(expectedPrice)
				}
				return nameFound || priceFound

			case TPRConstants.SearchType.BOTH:
			default:
				nameFound = isPackageNameVisible(packageName)
				if (hasExpectedPrice) {
					priceFound = isPriceVisible(expectedPrice)
				} else {
					priceFound = true
				}
				return nameFound && priceFound
		}
	}

	public static boolean isPackageNameVisible(String packageName) {
		try {
			TestObject nameObj = buildTestObject(packageName, 'name')
			return Mobile.waitForElementPresent(nameObj, 3, FailureHandling.OPTIONAL)
		} catch (Exception e) {
			KeywordUtil.logInfo("Error checking package name '${packageName}': ${e.message}")
			return false
		}
	}

	public static boolean isPriceVisible(String price) {
		try {
			TestObject priceObj = buildTestObject(price, 'price')
			return Mobile.waitForElementPresent(priceObj, 3, FailureHandling.OPTIONAL)
		} catch (Exception e) {
			KeywordUtil.logInfo("Error checking price '${price}': ${e.message}")
			return false
		}
	}

	public static void tapPackage(String packageName) {
		try {
			Mobile.scrollToText(packageName)
		} catch (Exception e) {
			KeywordUtil.logInfo('scrollToText threw: ' + e.getMessage() + ' — continuing to attempt tap')
		}

		TestObject to = buildTestObject(packageName, 'name')
		Mobile.waitForElementPresent(to, 5, FailureHandling.OPTIONAL)
		Mobile.tap(to, 5)
	}

	private static TestObject buildTestObject(String value, String type = 'name') {
		String xpath

		switch (type.toLowerCase()) {
			case 'price':
				xpath = String.format(
				"//android.widget.TextView[@resource-id='com.axis.net:id/discountedPriceTv' and @text='%s']",
				value
				)
				break

			case 'name':
			default:
				String lowerValue = value.toLowerCase().trim()

			// 1. BUANG KATA AWALAN (MULTIPLE WORDS)
				def prefixes = [
					"promo ",
					"kotamu ",
					"kuota "] 
				for (String prefix : prefixes) {
					if (lowerValue.startsWith(prefix)) {
						lowerValue = lowerValue.substring(prefix.length()).trim()
						break
					}
				}

			// 2. AMBIL INTI PAKET: Ambil 2 kata pertama saja.
				String[] words = lowerValue.split("\\s+")
				if (words.length >= 2) {
					lowerValue = words[0] + " " + words[1]
				} else if (words.length == 1) {
					lowerValue = words[0]
				}

				String safeValue = lowerValue.replace("'", "\\'")

			// 3. XPATH FLEKSIBEL
				xpath = String.format(
						"//android.widget.TextView[@resource-id='com.axis.net:id/productNameTv' and contains(translate(@text, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ\\n', 'abcdefghijklmnopqrstuvwxyz '), '%s')]",
						safeValue
						)
				break
		}

		TestObject to = new TestObject('TPR_' + type.toUpperCase() + '_' +
				value.replaceAll('\\s+', '_').replaceAll('[^a-zA-Z0-9_]', ''))
		to.addProperty('xpath', ConditionType.EQUALS, xpath)
		return to
	}
}