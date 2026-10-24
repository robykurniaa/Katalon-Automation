package pages

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject

import support.CommonUtils
import support.LocatorUtil
import axisnet_support.LocatorPaths as Locator
import internal.GlobalVariable

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import org.openqa.selenium.WebElement
import org.openqa.selenium.By

public class MccmPage {

	public static void mccmPackageHandling() {
		// 1. Coba cari dan pilih paket termurah (Maks Rp20.000)
		boolean isCheapestFound = trySelectCheapestPackage(20000)

		// 2. Jika paket murah tidak ketemu ke forever online
		if (!isCheapestFound) {
			CommonUtils.tap(Locator.FOREVER_ONLINE_TAB)
			if (!trySelectPackage(["1", "2", "3", "5"])) {
				trySelectPackage(["7"])
			}
		}
	}

	private static boolean trySelectCheapestPackage(int maxPrice) {
		def driver = MobileDriverFactory.getDriver()
		String priceXpath = "//android.widget.TextView[@resource-id='com.axis.net:id/discountedPriceTv']"

		List<WebElement> priceElements = driver.findElements(By.xpath(priceXpath))

		int lowestPriceFound = Integer.MAX_VALUE
		String targetPriceText = ""

		for (WebElement element : priceElements) {
			String priceText = element.getText() // Contoh hasil: "Rp13.500"

			if (priceText != null && priceText.contains("Rp")) {
				String numericString = priceText.replaceAll("[^0-9]", "")

				if (numericString.isInteger()) {
					int currentPrice = numericString.toInteger()

					if (currentPrice <= maxPrice && currentPrice < lowestPriceFound) {
						lowestPriceFound = currentPrice
						targetPriceText = priceText
					}
				}
			}
		}

		if (lowestPriceFound != Integer.MAX_VALUE && targetPriceText != "") {
			String targetXpath = "//android.widget.TextView[@resource-id='com.axis.net:id/discountedPriceTv' and @text='${targetPriceText}']"

			TestObject cheapPackageObject = new TestObject("cheapestPackage")
			cheapPackageObject.addProperty("xpath", ConditionType.EQUALS, targetXpath)

			Mobile.tap(cheapPackageObject, 3)
			return true
		}

		return false
	}

	private static boolean trySelectPackage(List<String> days) {
		for (String day : days) {
			TestObject expiryObject = createExpiryObject(day)

			if (Mobile.waitForElementPresent(expiryObject, 3)) {
				Mobile.tap(expiryObject, 3)
				return true
			}
		}
		return false
	}

	private static TestObject createExpiryObject(String day) {
		String xpath = "//android.widget.TextView[@resource-id='com.axis.net:id/expiryTv' and @text='Masa aktif ${day} hari']"

		TestObject expiryObject = new TestObject("expiryTv-${day}")
		expiryObject.addProperty("xpath", ConditionType.EQUALS, xpath)
		return expiryObject
	}
}