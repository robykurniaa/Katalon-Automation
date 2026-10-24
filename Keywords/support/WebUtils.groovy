package support

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testobject.TestObject
import support.exceptions.ActionFailedException
import support.exceptions.ElementNotFoundException
import support.exceptions.TestActionException
import internal.GlobalVariable
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.configuration.RunConfiguration
import java.text.SimpleDateFormat
import java.io.File

class WebUtils {
	static final int DEFAULT_TIMEOUT = CommonUtils.DEFAULT_TIMEOUT
	static boolean takeScreenshots = CommonUtils.takeScreenshots

	static String cachedTestCaseName = null
	static String lastTestCaseFileContent = null

	static void captureScreenshot(String action = '') {
		if (!takeScreenshots) return

			try {
				String rawActionName = action?.trim() ? action : (CommonUtils.objectPath ?: "UnknownAction")
				String sanitizedAction = sanitizeForFilename(rawActionName)
				String screenshotPath  = getScreenshotPath(sanitizedAction)

				File file = new File(screenshotPath)
				file.getParentFile().mkdirs()

				WebUI.takeScreenshot(screenshotPath)
				KeywordUtil.logInfo("Screenshot saved: ${screenshotPath}")
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
		// Ambil path absolut direktori project
		String projectDir = RunConfiguration.getProjectDir()

		if (type == "TEST_SUITE") {
			String suiteName = sanitizeForFilename(RunConfiguration.getExecutionSourceName() ?: "UnknownSuite")
			String testCaseName = getCurrentTestCaseName()
			return "${projectDir}/Screenshots/Web/TestSuite/${todayDate}/${suiteName}/${testCaseName}"
		}

		if (type == "TEST_CASE") {
			String testCaseName = getCurrentTestCaseName()
			return "${projectDir}/Screenshots/Web/TestCase/${todayDate}/${testCaseName}"
		}

		return "${projectDir}/Screenshots/Web/Other/${todayDate}/Unknown"
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

	// Reset cache manually if needed
	static void resetTestCaseCache() {
		cachedTestCaseName = null
		lastTestCaseFileContent = null
	}

	static void waitForElement(TestObject object, int timeout = DEFAULT_TIMEOUT) {
		try {
			if (!WebUI.waitForElementPresent(object, timeout)) {
				throw new ElementNotFoundException(CommonUtils.objectPath)
			}
		} catch (Exception e) {
			throw new ActionFailedException("wait", CommonUtils.objectPath, e)
		}
	}

	static boolean isElementPresent(TestObject object, int timeout = DEFAULT_TIMEOUT) {
		return WebUI.waitForElementPresent(object, timeout, FailureHandling.OPTIONAL)
	}

	static void click(TestObject object, int timeout = DEFAULT_TIMEOUT) {
		try {
			waitForElement(object, timeout)
			captureScreenshot("Before_Click_${CommonUtils.objectPath}")
			WebUI.click(object)
		} catch (Exception e) {
			throw new ActionFailedException("click", CommonUtils.objectPath, e)
		}
	}

	static void setText(TestObject object, String text, int timeout = DEFAULT_TIMEOUT) {
		try {
			waitForElement(object, timeout)
			captureScreenshot("Before_SetText_${CommonUtils.objectPath}")
			WebUI.setText(object, text)
		} catch (Exception e) {
			throw new ActionFailedException("setText", CommonUtils.objectPath, e)
		}
	}

	static void sendKeys(TestObject object, String keys) {
		try {
			WebUI.sendKeys(object, keys)
		} catch (Exception e) {
			throw new ActionFailedException("sendKeys", CommonUtils.objectPath, e)
		}
	}

	static void clearText(TestObject object, int timeout = DEFAULT_TIMEOUT) {
		try {
			waitForElement(object, timeout)
			captureScreenshot("Before_ClearText_${CommonUtils.objectPath}")
			WebUI.clearText(object)
		} catch (Exception e) {
			throw new ActionFailedException("clearText", CommonUtils.objectPath, e)
		}
	}

	static String getAttribute(TestObject object, String attribute) {
		try {
			return WebUI.getAttribute(object, attribute)
		} catch (Exception e) {
			throw new ActionFailedException("getAttribute", CommonUtils.objectPath, e)
		}
	}

	static void selectOptionByValue(TestObject object, String value) {
		try {
			WebUI.selectOptionByValue(object, value, false)
		} catch (Exception e) {
			throw new ActionFailedException("selectOptionByValue", CommonUtils.objectPath, e)
		}
	}

	static void selectOptionByLabel(TestObject object, String label) {
		try {
			WebUI.selectOptionByLabel(object, label, false)
		} catch (Exception e) {
			throw new ActionFailedException("selectOptionByLabel", CommonUtils.objectPath, e)
		}
	}

	static void check(TestObject object) {
		try {
			WebUI.check(object)
		} catch (Exception e) {
			throw new ActionFailedException("check", CommonUtils.objectPath, e)
		}
	}

	static void uncheck(TestObject object) {
		try {
			WebUI.uncheck(object)
		} catch (Exception e) {
			throw new ActionFailedException("uncheck", CommonUtils.objectPath, e)
		}
	}

	static boolean handleOptionalElement(TestObject object, Closure action, int timeout = DEFAULT_TIMEOUT) {
		try {
			if (WebUI.waitForElementPresent(object, timeout, FailureHandling.OPTIONAL)) {
				captureScreenshot("Before_HandleOptionalElement_${CommonUtils.objectPath}")
				action()
				return true
			}
			return false
		} catch (Exception e) {
			println "Warning: Optional element failed for ${CommonUtils.objectPath}"
			return false
		}
	}

	static boolean isElementExist(TestObject object, int timeout = 5) {
		try {
			return WebUI.verifyElementPresent(object, timeout, FailureHandling.OPTIONAL)
		} catch (Exception e) {
			return false
		}
	}
	
	/**
	 * Gunakan ini HANYA untuk "Expected Result" di akhir step.
	 * Akan mengambil screenshot sebagai bukti Passed atau Failed.
	 */
	static void verifyElementPresent(TestObject object, int timeout = DEFAULT_TIMEOUT) {
		boolean isPresent = WebUI.verifyElementPresent(object, timeout, FailureHandling.OPTIONAL)
		
		if (isPresent) {
			KeywordUtil.logInfo("EXPECTED MATCH: Element ${CommonUtils.objectPath} is displayed.")
			captureScreenshot("Expected_Match_${CommonUtils.objectPath}")
		} else {
			KeywordUtil.logInfo("EXPECTED MISMATCH: Element ${CommonUtils.objectPath} is NOT displayed.")
			captureScreenshot("Expected_Mismatch_${CommonUtils.objectPath}")
			KeywordUtil.markFailedAndStop("Assertion Failed: Expected element ${CommonUtils.objectPath} to be present.")
		}
	}

	static void scrollToElement(TestObject object, int timeout = DEFAULT_TIMEOUT) {
		try {
			WebUI.scrollToElement(object, DEFAULT_TIMEOUT)
		} catch (Exception e) {
			throw new ActionFailedException("Failed to scroll to element: ${CommonUtils.objectPath}", e)
		}
	}

	static String getTextFromElement(TestObject object) {
		try {
			return WebUI.getText(object)
		} catch (Exception e) {
			throw new ActionFailedException("Failed to get text: ${CommonUtils.objectPath}", e)
		}
	}

	static int getNumericFromElement(TestObject object) {
		try {
			String text = WebUI.getText(object)
			String numericText = text.replaceAll("[^0-9]", "")
			return Integer.parseInt(numericText)
		} catch (NumberFormatException e) {
			return 0
		} catch (Exception e) {
			throw new ActionFailedException("Failed to get numeric value: ${CommonUtils.objectPath}", e)
		}
	}

	static void compareValues(Number value1, Number value2, String comparisonType) {
		switch (comparisonType.toLowerCase()) {
			case "equal":
				WebUI.verifyEqual(value1, value2, FailureHandling.STOP_ON_FAILURE)
				break
			case "less or equal":
				WebUI.verifyLessThanOrEqual(value1, value2, FailureHandling.STOP_ON_FAILURE)
				break
			case "more or equal":
				WebUI.verifyGreaterThanOrEqual(value1, value2, FailureHandling.STOP_ON_FAILURE)
				break
			case "less than":
				WebUI.verifyLessThan(value1, value2, FailureHandling.STOP_ON_FAILURE)
				break
			case "more than":
				WebUI.verifyGreaterThan(value1, value2, FailureHandling.STOP_ON_FAILURE)
				break
			default:
				throw new IllegalArgumentException("Invalid comparison type: ${comparisonType}")
		}
	}

	static void acceptAlert() {
		try {
			WebUI.waitForAlert(5)
			WebUI.acceptAlert()
		} catch (Exception e) {
			KeywordUtil.markWarning("No alert present to accept.")
		}
	}
}