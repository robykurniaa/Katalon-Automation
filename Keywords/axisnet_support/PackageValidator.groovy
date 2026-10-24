package axisnet_support

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil

import internal.GlobalVariable
import java.time.DayOfWeek
import java.time.LocalDate

import support.CommonUtils
import axisnet_support.LocatorPaths as Locator

public class PackageValidator {

	@Keyword
	static void handlingMccmPackage() {

		// Daftar hari yang ingin dicek
		List<String> validDays = ["1", "2", "3", "5"]

		boolean isTapped = false
		// Loop untuk tiap hari yang valid
		for (String day : validDays) {
			String xpath = "//android.widget.TextView[@resource-id='com.axis.net:id/expiryTv' and @text='Masa aktif ${day} hari']"

			TestObject expiryObject = new TestObject("expiryTv-${day}")
			expiryObject.addProperty("xpath", ConditionType.EQUALS, xpath)

			if (Mobile.waitForElementPresent(expiryObject, 5)) {
				CommonUtils.captureScreenshot()
				Mobile.tap(expiryObject,5)
				isTapped = true
				break
			}
		}

		// Jika tidak ada yang cocok, tap FOREVER_ONLINE_TAB
		if (!isTapped) {
			CommonUtils.tap(Locator.BUTTON_AKTIFKAN)
		}
	}
	
	@Keyword
	static void handlingSwipePkgTab() {
		
	}
}