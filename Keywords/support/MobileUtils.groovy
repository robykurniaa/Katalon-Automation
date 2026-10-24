package support

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import io.appium.java_client.AppiumDriver

import support.exceptions.ActionFailedException
import support.exceptions.ElementNotFoundException
import support.exceptions.TestActionException
import internal.GlobalVariable
import java.text.SimpleDateFormat

class MobileUtils {

	static final int DEFAULT_TIMEOUT = CommonUtils.DEFAULT_TIMEOUT
	static boolean takeScreenshots = CommonUtils.takeScreenshots

	// Cache for test case name
	static String cachedTestCaseName = null
	static String lastTestCaseFileContent = null

	static void captureScreenshot(String action = '') {
		if (!takeScreenshots) return

			try {
				String sanitizedAction = sanitizeForFilename(action)
				String screenshotPath  = getScreenshotPath(sanitizedAction)

				File file = new File(screenshotPath)
				file.getParentFile().mkdirs()

				if (isLocalExecution()) {
					// Mobile.takeScreenshot(screenshotPath)
					// KeywordUtil.logInfo("Screenshot saved: ${screenshotPath}")
				}
			} catch (Exception e) {
				KeywordUtil.logInfo("Failed to capture screenshot: ${e.message}")
			}
	}

	private static String sanitizeForFilename(String input) {
		return input.replaceAll("[\\\\/:*?\"<>|]", "_")
	}

	private static String getScreenshotPath(String action) {
		String timestamp       = new SimpleDateFormat("HHmmss").format(new Date())
		String sanitizedAction = sanitizeForFilename(action ?: "UnknownAction")
		String baseFolder      = resolveBaseFolder()
		return "${baseFolder}/${sanitizedAction}_${timestamp}.png"
	}

	private static String resolveBaseFolder() {
		String todayDate = new Date().format("yyyy-MM-dd")
		String type      = getExecutionType()

		if (type == "TEST_SUITE") {
			String suiteName = sanitizeForFilename(RunConfiguration.getExecutionSourceName() ?: "UnknownSuite")
			String testCaseName = getCurrentTestCaseName()
			return "./Screenshots/TestSuite/${todayDate}/${suiteName}/${testCaseName}"
		}

		if (type == "TEST_CASE") {
			String testCaseName = getCurrentTestCaseName()
			return "./Screenshots/TestCase/${todayDate}/${testCaseName}"
		}

		return "./Screenshots/Other/${todayDate}/Unknown"
	}

	private static String getCurrentTestCaseName() {
		try {
			String projectDir = RunConfiguration.getProjectDir()
			File tempFile = new File(projectDir, "temp/current_testcase.txt")

			if (tempFile.exists()) {
				String fileContent = tempFile.text.trim()

				// Reset cache if content changed
				if (lastTestCaseFileContent != fileContent) {
					lastTestCaseFileContent = fileContent
					cachedTestCaseName = null
				}

				if (cachedTestCaseName != null) {
					return cachedTestCaseName
				}

				if (!fileContent.isEmpty()) {
					cachedTestCaseName = sanitizeForFilename(fileContent)
					return cachedTestCaseName
				}
			}
		} catch (Exception e) {
			KeywordUtil.logInfo("Cannot read temp file: ${e.message}")
		}

		// Fallback name
		String fallback = "Unknown_TestCase_" + new Date().format("HH-mm-ss")
		cachedTestCaseName = fallback
		return cachedTestCaseName
	}

	private static String getExecutionType() {
		String id = RunConfiguration.getExecutionSourceId() ?: ""
		if (id.startsWith("Test Suites/")) return "TEST_SUITE"
		if (id.startsWith("Test Cases/")) return "TEST_CASE"
		return "OTHER"
	}

	private static boolean isLocalExecution() {
		String remoteAgent = System.getenv("KATALON_AGENT_NAME") ?: ""
		return !remoteAgent?.trim()
	}

	// Reset cache manually if needed
	static void resetTestCaseCache() {
		cachedTestCaseName = null
		lastTestCaseFileContent = null
	}

	static void waitForElement(TestObject object, int timeout = DEFAULT_TIMEOUT, FailureHandling failureHandling = FailureHandling.CONTINUE_ON_FAILURE) {
		try {
			if (!Mobile.waitForElementPresent(object, timeout, failureHandling)) {
				throw new ElementNotFoundException(CommonUtils.objectPath)
			}
		} catch (Exception e) {
			if (failureHandling == FailureHandling.STOP_ON_FAILURE) {
				throw new ActionFailedException("wait", CommonUtils.objectPath, e)
			} else {
				println "Warning: Element not found, continuing: ${CommonUtils.objectPath}"
			}
		}
	}

	static boolean isElementPresent(TestObject object, int timeout = DEFAULT_TIMEOUT, FailureHandling failureHandling = FailureHandling.CONTINUE_ON_FAILURE) {
		try {
			boolean isExist = Mobile.verifyElementExist(object, timeout, failureHandling)
			if (!isExist && failureHandling == FailureHandling.STOP_ON_FAILURE) {
				throw new ElementNotFoundException(CommonUtils.objectPath)
			}
			return isExist
		} catch (Exception e) {
			if (failureHandling == FailureHandling.STOP_ON_FAILURE) {
				throw new ActionFailedException("verify", CommonUtils.objectPath, e)
			}
			return false
		}
	}

	static void tap(TestObject object, int timeout = DEFAULT_TIMEOUT) {
		try {
			captureScreenshot("${CommonUtils.objectPath}")
			Mobile.tap(object, 1)
		} catch (Exception e) {
			throw new ActionFailedException("tap", CommonUtils.objectPath, e)
		}
	}

	static void taps(TestObject object, int timeout = DEFAULT_TIMEOUT) {
		try {
			Mobile.doubleTap(object, 1, FailureHandling.STOP_ON_FAILURE)
		} catch (Exception e) {
			throw new ActionFailedException("taps", CommonUtils.objectPath, e)
		}
	}

	static void tapAndHold(TestObject object, int timeout = DEFAULT_TIMEOUT) {
		try {
			captureScreenshot("${CommonUtils.objectPath}")
			Mobile.tapAndHold(object, 5, 1)
		} catch (Exception e) {
			throw new ActionFailedException("tapAndHold", CommonUtils.objectPath, e)
		}
	}

	static void hit(TestObject object, int timeout = DEFAULT_TIMEOUT) {
		try {
			captureScreenshot("Before_Hit_${CommonUtils.objectPath}")
			Mobile.tap(object, 1)
		} catch (Exception e) {
			throw new ActionFailedException("hit", CommonUtils.objectPath, e)
		}
	}

	static void setText(TestObject object, String text, int timeout = DEFAULT_TIMEOUT) {
		try {
			Mobile.clearText(object, 5)
			captureScreenshot("${CommonUtils.objectPath}")
			Mobile.tap(object, 5)
			Mobile.setText(object, text, 5)
			Mobile.hideKeyboard(FailureHandling.OPTIONAL)
		} catch (Exception e) {
			throw new ActionFailedException("setText", CommonUtils.objectPath, e)
		}
	}

	static void clearText(TestObject object, int timeout = DEFAULT_TIMEOUT) {
		try {
			captureScreenshot("Before_ClearText_${CommonUtils.objectPath}")
			Mobile.clearText(object, 1)
		} catch (Exception e) {
			throw new ActionFailedException("clearText", CommonUtils.objectPath, e)
		}
	}

	static String getAttribute(TestObject object, String attribute) {
		try {
			return Mobile.getAttribute(object, attribute, 5)
		} catch (Exception e) {
			throw new ActionFailedException("getAttribute", CommonUtils.objectPath, e)
		}
	}

	static void check(TestObject object) {
		try {
			Mobile.checkElement(object, 5)
		} catch (Exception e) {
			throw new ActionFailedException("check", CommonUtils.objectPath, e)
		}
	}

	static void uncheck(TestObject object) {
		try {
			Mobile.uncheckElement(object, 5)
		} catch (Exception e) {
			throw new ActionFailedException("uncheck", CommonUtils.objectPath, e)
		}
	}

	static boolean handleOptionalElement(TestObject object, Closure action, int timeout = DEFAULT_TIMEOUT) {
		try {
			if (Mobile.waitForElementPresent(object, timeout, FailureHandling.OPTIONAL)) {
				action()
				return true
			}
			return false
		} catch (Exception e) {
			println "Warning: Optional element failed for ${CommonUtils.objectPath}: ${e.message}"
			return false
		}
	}

	static boolean isElementExist(TestObject object, int timeout = 5) {
		try {
			return Mobile.verifyElementExist(object, timeout, FailureHandling.OPTIONAL)
		} catch (Exception e) {
			return false
		}
	}

	static boolean isElementNotPresent(TestObject object, int timeout = DEFAULT_TIMEOUT, FailureHandling failureHandling = FailureHandling.STOP_ON_FAILURE) {
		try {
			if (Mobile.verifyElementNotExist(object, timeout, failureHandling)) {
				return true
			} else {
				throw new ElementNotFoundException("Element was unexpectedly visible: ${CommonUtils.objectPath}")
			}
		} catch (Exception e) {
			if (failureHandling == FailureHandling.STOP_ON_FAILURE) {
				throw new ActionFailedException("isElementNotPresent", CommonUtils.objectPath, e)
			}
			return false
		}
	}

	static void scrollToText(String text) {
		try {
			Mobile.scrollToText(text)
			println "Scrolled to text: ${text}"
		} catch (Exception e) {
			throw new ActionFailedException("Failed to scroll to text: ${text}", e)
		}
	}

	static void swipe(TestObject object, String direction, int timeout = DEFAULT_TIMEOUT) {
		try {
			captureScreenshot("Before_Swipe_${CommonUtils.objectPath}")

			int x = Mobile.getElementLeftPosition(object, timeout)
			int y = Mobile.getElementTopPosition(object, timeout)
			int width = Mobile.getElementWidth(object, timeout)
			int height = Mobile.getElementHeight(object, timeout)

			int startX, startY, endX, endY

			switch (direction.toLowerCase()) {
				case "left":
					startX = x + (width * 0.80)
					endX = x + (width * 0.05)
					startY = y + (height / 2)
					endY = startY
					break
				case "right":
					startX = x + 10
					endX = x + width - 10
					startY = y + (height / 2)
					endY = startY
					break
				case "up":
					startX = x + (width / 2)
					endX = startX
					startY = y + height + 100
					endY = 100
					break
				case "down":
					startX = x + (width / 2)
					endX = startX
					startY = y + 10
					endY = y + height - 10
					break
				default:
					throw new IllegalArgumentException("Invalid swipe direction: ${direction}")
			}
			Mobile.swipe(startX, startY, endX, endY)
		} catch (Exception e) {
			throw new ActionFailedException("Swipe action failed", e)
		}
	}

	static String getTextFromElement(TestObject object) {
		try {
			return Mobile.getText(object, 5)
		} catch (Exception e) {
			throw new ActionFailedException("Failed to get text: ${CommonUtils.objectPath}", e)
		}
	}

	static int getNumericFromElement(TestObject object) {
		try {
			String text = Mobile.getText(object, 5)
			String numericText = text.replaceAll("[^0-9]", "")
			return Integer.parseInt(numericText)
		} catch (NumberFormatException e) {
			return 0
		} catch (Exception e) {
			throw new ActionFailedException("Failed to get numeric value: ${CommonUtils.objectPath}", e)
		}
	}

	static void compareValues(Object value1, Object value2, String comparisonType) {
		switch (comparisonType.toLowerCase()) {
			case "equal":
				Mobile.verifyEqual(value1, value2, FailureHandling.STOP_ON_FAILURE)
				break
			case "less or equal":
				Mobile.verifyLessThanOrEqual(value1, value2, FailureHandling.STOP_ON_FAILURE)
				break
			case "more or equal":
				Mobile.verifyGreaterThanOrEqual(value1, value2, FailureHandling.STOP_ON_FAILURE)
				break
			case "less than":
				Mobile.verifyLessThan(value1, value2, FailureHandling.STOP_ON_FAILURE)
				break
			case "more than":
				Mobile.verifyGreaterThan(value1, value2, FailureHandling.STOP_ON_FAILURE)
				break
			default:
				throw new IllegalArgumentException("Invalid comparison type: ${comparisonType}")
		}
	}

	static void pressBack() {
		try {
			captureScreenshot("Before_PressBack")
			Mobile.pressBack()
		} catch (Exception e) {
			throw new ActionFailedException("Failed to press back", e)
		}
	}

	static void switchToWebView() {
		try {
			Mobile.switchToWebView()
		} catch (Exception e) {
			KeywordUtil.markWarning("Failed to switch to WebView: " + e.getMessage())
		}
	}

	static void switchToNative() {
		try {
			Mobile.switchToNative()
		} catch (Exception e) {
			KeywordUtil.markWarning("Failed to switch to Native: " + e.getMessage())
		}
	}
}