package support

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory

import support.exceptions.ActionFailedException
import support.exceptions.ElementNotFoundException
import support.exceptions.TestActionException
import support.LocatorUtil
import support.MobileUtils
import support.WebUtils
import internal.GlobalVariable
import io.appium.java_client.AppiumDriver
import groovy.json.JsonSlurper

class CommonUtils {
	static final int DEFAULT_TIMEOUT = 30
	static boolean takeScreenshots = true
	static String objectPath = ''
	static String shortObjectName = ''
	static String platform = ''

	// Check if current platform is mobile
	private static boolean isMobile() {
		if (platform == '') {
			platform = LocatorUtil.detectPlatform().toLowerCase()
		}
		return platform == 'android' || platform == 'ios'
	}

	static void captureScreenshot(String action = '') {
		if (takeScreenshots) {
			if (isMobile()) {
				MobileUtils.captureScreenshot(action)
			} else {
				WebUtils.captureScreenshot(action)
			}
		}
	}

	static TestObject getObject(String objectKey) {
		String objectValue = ""

		// 1. From Katalon Object Repository
		if (objectKey?.startsWith("Object Repository")) {
			objectValue = objectKey
			String[] parts = objectKey.split("/")
			objectPath = parts[parts.length - 1].trim()

			TestObject object = findTestObject(objectValue)
			if (object == null) {
				throw new ElementNotFoundException(objectValue)
			}
			return object
		}
		// 2. From Dynamic XPath
		else if (objectKey?.startsWith("//") || objectKey?.startsWith("(.//") || objectKey?.startsWith("(")) {
			objectValue = objectKey

			def idMatch = objectKey =~ /@resource-id\s*=\s*['"]([^'"]+)['"]/
			if (idMatch.find()) {
				String idVal = idMatch.group(1)
				objectPath = idVal.substring(idVal.lastIndexOf("/") + 1).replaceAll("[^a-zA-Z0-9]", "_")
			} else {
				objectPath = "Dynamic_XPath"
			}

			TestObject customObject = new TestObject(objectPath)
			customObject.addProperty("xpath", ConditionType.EQUALS, objectValue)
			return customObject
		}
		// 3. From Custom Locator (JSON/Framework)
		else {
			if (objectKey.contains("/")) {
				String[] parts = objectKey.split("/")
				objectPath = parts[parts.length - 1].trim()
			} else {
				objectPath = objectKey
			}

			objectValue = LocatorUtil.getLocatorPath(objectKey)

			if (objectValue?.startsWith("Object Repository")) {
				TestObject object = findTestObject(objectValue)
				if (object == null) {
					throw new ElementNotFoundException(objectValue)
				}
				return object
			} else {
				TestObject customObject = new TestObject(objectPath)
				customObject.addProperty("xpath", ConditionType.EQUALS, objectValue)
				return customObject
			}
		}
	}

	// ================= BASIC ACTIONS =================

	static TestObject waitForElement(String objectKey, int timeout = DEFAULT_TIMEOUT, FailureHandling failureHandling = FailureHandling.CONTINUE_ON_FAILURE) {
		TestObject object = getObject(objectKey)
		if (isMobile()) {
			MobileUtils.waitForElement(object, timeout, failureHandling)
		} else {
			WebUtils.waitForElement(object, timeout)
		}
		return object
	}

	static boolean isElementNotPresent(String objectKey, int timeout = DEFAULT_TIMEOUT, FailureHandling failureHandling = FailureHandling.STOP_ON_FAILURE) {
		TestObject object = getObject(objectKey)
		if (isMobile()) {
			return MobileUtils.isElementNotPresent(object, timeout, failureHandling)
		} else {
			return !WebUtils.isElementPresent(object, timeout)
		}
	}

	static boolean isElementPresent(String objectKey, int timeout = DEFAULT_TIMEOUT, FailureHandling failureHandling = FailureHandling.OPTIONAL) {
		TestObject object = getObject(objectKey)
		if (isMobile()) {
			return MobileUtils.isElementPresent(object, timeout, failureHandling)
		} else {
			return WebUtils.isElementPresent(object, timeout)
		}
	}

	static boolean isElementExist(String objectKey, int timeout = 5) {
		TestObject object = getObject(objectKey)
		if (isMobile()) {
			return MobileUtils.isElementExist(object, timeout)
		} else {
			return WebUtils.isElementExist(object, timeout)
		}
	}

	static void verifyElementPresent(String objectKey, int timeout = DEFAULT_TIMEOUT) {
		TestObject object = waitForElement(objectKey, timeout)
		if (isMobile()) {
			//MobileUtils.verifyElementPresent(object, timeout)
		} else {
			WebUtils.verifyElementPresent(object, timeout)
		}
	}
	static void tap(String objectKey, int timeout = DEFAULT_TIMEOUT) {
		TestObject object = waitForElement(objectKey, timeout)
		if (isMobile()) {
			MobileUtils.tap(object)
		} else {
			WebUtils.click(object)
		}
	}

	static void taps(String objectKey, int timeout = DEFAULT_TIMEOUT) {
		TestObject object = waitForElement(objectKey, timeout)
		if (isMobile()) {
			MobileUtils.taps(object) // Double tap for mobile
		} else {
			WebUtils.click(object)
		}
	}

	static void tapAndHold(String objectKey, int timeout = DEFAULT_TIMEOUT) {
		TestObject object = waitForElement(objectKey, timeout)
		if (isMobile()) {
			MobileUtils.tapAndHold(object)
		}
	}

	static void hit(String objectKey, int timeout = DEFAULT_TIMEOUT) {
		TestObject object = waitForElement(objectKey, timeout)
		if (isMobile()) {
			MobileUtils.hit(object)
		} else {
			WebUtils.click(object)
		}
	}

	static void setText(String objectKey, String text, int timeout = DEFAULT_TIMEOUT) {
		TestObject object = waitForElement(objectKey, timeout)
		if (isMobile()) {
			MobileUtils.setText(object, text)
		} else {
			WebUtils.setText(object, text)
		}
	}

	static void sendKeys(String objectKey, String keys, int timeout = DEFAULT_TIMEOUT) {
		TestObject object = waitForElement(objectKey, timeout)
		if (!isMobile()) {
			WebUtils.sendKeys(object, keys)
		} else {
			KeywordUtil.logInfo("sendKeys is not explicitly supported on mobile, using setText instead.")
			MobileUtils.setText(object, keys)
		}
	}

	static void clearText(String objectKey, int timeout = DEFAULT_TIMEOUT) {
		TestObject object = waitForElement(objectKey, timeout)
		if (isMobile()) {
			MobileUtils.clearText(object)
		} else {
			WebUtils.clearText(object)
		}
	}

	// ================= EXTENDED ACTIONS =================

	static String getAttribute(String objectKey, String attribute, int timeout = DEFAULT_TIMEOUT) {
		TestObject object = waitForElement(objectKey, timeout)
		if (isMobile()) {
			return MobileUtils.getAttribute(object, attribute)
		} else {
			return WebUtils.getAttribute(object, attribute)
		}
	}

	static void selectOptionByValue(String objectKey, String value, int timeout = DEFAULT_TIMEOUT) {
		TestObject object = waitForElement(objectKey, timeout)
		if (!isMobile()) {
			WebUtils.selectOptionByValue(object, value)
		} else {
			KeywordUtil.markFailed("selectOptionByValue is for Web only.")
		}
	}

	static void selectOptionByLabel(String objectKey, String label, int timeout = DEFAULT_TIMEOUT) {
		TestObject object = waitForElement(objectKey, timeout)
		if (!isMobile()) {
			WebUtils.selectOptionByLabel(object, label)
		} else {
			KeywordUtil.markFailed("selectOptionByLabel is for Web only.")
		}
	}

	static void check(String objectKey, int timeout = DEFAULT_TIMEOUT) {
		TestObject object = waitForElement(objectKey, timeout)
		if (isMobile()) {
			MobileUtils.check(object)
		} else {
			WebUtils.check(object)
		}
	}

	static void uncheck(String objectKey, int timeout = DEFAULT_TIMEOUT) {
		TestObject object = waitForElement(objectKey, timeout)
		if (isMobile()) {
			MobileUtils.uncheck(object)
		} else {
			WebUtils.uncheck(object)
		}
	}

	// ================= UTILITIES =================

	static boolean handleOptionalElement(String objectKey, Closure action, int timeout = DEFAULT_TIMEOUT) {
		TestObject object = getObject(objectKey)
		if (isMobile()) {
			return MobileUtils.handleOptionalElement(object, action, timeout)
		} else {
			return WebUtils.handleOptionalElement(object, action, timeout)
		}
	}

	static void handleMultipleOptionalElements(List<String> locators, Closure action, int timeout = 5) {
		for (def locator : locators) {
			try {
				if (CommonUtils.handleOptionalElement(locator, action, timeout)) {
					break
				}
			} catch (Exception ignored) {
				// Ignore and proceed to next locator
			}
		}
	}

	static void scrollToText(String text) {
		if (isMobile()) {
			MobileUtils.scrollToText(text)
		}
	}

	static void scrollToElement(String objectKey, int timeout = DEFAULT_TIMEOUT) {
		TestObject object = waitForElement(objectKey, timeout)
		if (!isMobile()) {
			WebUtils.scrollToElement(object, timeout)
		}
	}

	static void swipe(String objectKey, String direction, int timeout = DEFAULT_TIMEOUT) {
		TestObject object = waitForElement(objectKey, timeout)
		if (isMobile()) {
			MobileUtils.swipe(object, direction, timeout)
		}
	}

	static String getTextFromElement(String objectKey, int timeout = DEFAULT_TIMEOUT) {
		TestObject object = waitForElement(objectKey, timeout)
		if (isMobile()) {
			return MobileUtils.getTextFromElement(object)
		} else {
			return WebUtils.getTextFromElement(object)
		}
	}

	static int getNumericFromElement(String objectKey, int timeout = DEFAULT_TIMEOUT) {
		TestObject object = waitForElement(objectKey, timeout)
		if (isMobile()) {
			return MobileUtils.getNumericFromElement(object)
		} else {
			return WebUtils.getNumericFromElement(object)
		}
	}

	static void compareValues(Object value1, Object value2, String comparisonType) {
		if (isMobile()) {
			MobileUtils.compareValues(value1, value2, comparisonType)
		} else {
			WebUtils.compareValues(value1, value2, comparisonType)
		}
	}

	public static void openDeepLink(String deeplinkUrl) {
		try {
			KeywordUtil.logInfo("Trying to open deeplink: " + deeplinkUrl)
			def driver = MobileDriverFactory.getDriver()
			driver.executeScript("mobile: deepLink", [
				"url": deeplinkUrl,
				"package": "com.axis.net"
			])
			KeywordUtil.logInfo("Successfully opened deeplink: " + deeplinkUrl)
		} catch (Exception e) {
			KeywordUtil.markFailed("Failed to open deeplink: " + e.getMessage())
		}
	}

	static void pressBack() {
		if (isMobile()) {
			MobileUtils.pressBack()
		} else {
			KeywordUtil.logInfo("pressBack is not supported on Web.")
		}
	}

	// ================= CONTEXT SWITCHING & ALERTS =================

	static void switchToWebView() {
		if (isMobile()) {
			MobileUtils.switchToWebView()
		}
	}

	static void switchToNative() {
		if (isMobile()) {
			MobileUtils.switchToNative()
		}
	}

	static void acceptAlert() {
		if (!isMobile()) {
			WebUtils.acceptAlert()
		}
	}

	static void getOTPFromEmail() {
		// TODO: Implement OTP retrieval logic
		KeywordUtil.logInfo("getOTPFromEmail is not yet implemented.")
	}
}