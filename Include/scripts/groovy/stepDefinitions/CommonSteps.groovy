package stepDefinitions
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable
import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import static org.junit.Assert.assertTrue
import static org.junit.Assert.assertFalse
import org.openqa.selenium.By
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty
import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.exception.WebElementNotFoundException
import support.BaseTest
import support.CommonUtils
import support.LocatorUtil
import support.exceptions.TestActionException
import io.cucumber.java.en.And
import io.cucumber.java.en.Given
import io.cucumber.java.en.Then
import io.cucumber.java.en.When
import pages.DashboardPage
import pages.LoginPage
import axisnet_support.AppManagement
import axisnet_support.PermissionHandling
import axisnet_support.AppManagement as Login
import axisnet_support.PackageValidator
import java.time.DayOfWeek
import java.time.LocalDate


class CommonSteps {

	@Given(/^user opens (?:.+) application$/)
	def openApplication() {
		BaseTest.setUp()
		//CommonUtils.takeScreenshot();
	}

	@Given(/^user opens (myxl|sidompul|axisnet) application test$/)
	def openApplication(String appName) {
		// Special handle for Axisnet
		if (appName.equalsIgnoreCase("axisnet")) {
			//Login.openApplication()
			Mobile.startExistingApplication('com.axis.net')
			// not execute BaseTest.setUp()
			return
		}

		String apkPath
		String ipaPath

		switch (appName.toLowerCase()) {
			case "myxl":
				apkPath = GlobalVariable.appMyXL
				ipaPath = GlobalVariable.ipaMyXL
				break
			case "sidompul":
				apkPath = GlobalVariable.appSiDompul
				ipaPath = GlobalVariable.ipaSiDompul
				break
			default:
				throw new IllegalArgumentException("Unsupported app name: ${appName}")
		}

		if (apkPath != null && !apkPath.trim().isEmpty()) {
			GlobalVariable.APK = apkPath
		} else if (ipaPath != null && !ipaPath.trim().isEmpty()) {
			GlobalVariable.IPA = ipaPath
		} else {
			throw new IllegalArgumentException("APK or IPA path not set for ${appName}")
		}

		BaseTest.setUp()
		CommonUtils.takeScreenshots()
	}



	@Given(/^user opens (?:.+) website on url "([^"]*)?"$/)
	def openApplicationUrl(String url){
		GlobalVariable.applicationURL=url
		println("application url is : ${GlobalVariable.applicationURL}")
		BaseTest.setUp()

		CommonUtils.takeScreenshot();
	}

	@Given(/^user closes myXL application$/)
	def closeApplication() {
		BaseTest.tearDown()

		CommonUtils.takeScreenshot();
	}

	@When(/^user perform login into the app(?: with number "([^"]*)?" and otp "([^"]*)?")?$/)
	def userLogsIntoApplication(String number, String otp) {

		if(number !=null && number.containsIgnoreCase("GlobalVariable.")) {
			// Use reflection to get the GlobalVariable value dynamically
			String globalVarName = number.split("\\.")[1]
			println("---> "+globalVarName);
			number = GlobalVariable."$globalVarName"
			println("---> "+number);
			if (number == null || number.toString().trim().isEmpty()) {
				throw new Exception("GlobalVariable.${globalVarName} is empty or not defined")
			}
		}

		if(otp !=null && otp.containsIgnoreCase("GlobalVariable.")) {
			// Use reflection to get the GlobalVariable value dynamically
			String globalVarName = otp.split("\\.")[1]
			println("---> "+globalVarName);
			otp = GlobalVariable."$globalVarName"
			println("---> "+otp);
			if (otp == null || otp.toString().trim().isEmpty()) {
				throw new Exception("GlobalVariable.${globalVarName} is empty or not defined")
			}
		}

		LoginPage.performLogin(number ?: GlobalVariable.preNum, otp ?: GlobalVariable.validOTP)
		DashboardPage.handlePostLoginPopups()
		DashboardPage.verifyAxisDashboardLoaded()

	}


	@When(/^user perform login into the axis app(?: with number "([^"]*)?" and otp "([^"]*)?")?$/)
	def userLogsIntoAxisApplication(String number, String otp) {

		if(number !=null && number.contains("GlobalVariable.")) {
			// Use reflection to get the GlobalVariable value dynamically
			String globalVarName = number.split("\\.")[1]
			println("---> "+globalVarName);
			number = GlobalVariable."$globalVarName"
			println("---> "+number);
			if (number == null || number.toString().trim().isEmpty()) {
				throw new Exception("GlobalVariable.${globalVarName} is empty or not defined")
			}
		}

		if(otp !=null && otp.contains("GlobalVariable.")) {
			// Use reflection to get the GlobalVariable value dynamically
			String globalVarName = otp.split("\\.")[1]
			println("---> "+globalVarName);
			otp = GlobalVariable."$globalVarName"
			println("---> "+otp);
			if (otp == null || otp.toString().trim().isEmpty()) {
				throw new Exception("GlobalVariable.${globalVarName} is empty or not defined")
			}
		}

		LoginPage.performLoginAxisnet(number ?: GlobalVariable.preNum, otp ?: GlobalVariable.validOTP)
		DashboardPage.acceptTnCIfVisible()
		DashboardPage.handlePostLoginAxisPopups()
		DashboardPage.verifyAxisDashboardLoaded()
	}

	@When(/^user check tnc/)
	def checktnc() {
		DashboardPage.acceptTnCIfVisible()

	}

	@When(/^user "([^"]*)?" on the optional element "([^"]*)?"$/)
	def interactWithOptionalElement(String action, String object) {

		// Check element if exist
		switch (action.toLowerCase()) {
			case "click":
				CommonUtils.handleOptionalElement(object, {
					-> CommonUtils.tap(object)
				})
				break
			case "clear text":
				CommonUtils.handleOptionalElement(object, {
					-> CommonUtils.clearText(object)
				})
				break
			default:
				KeywordUtil.markWarning("Unsupported action: " + action)
		}

		CommonUtils.takeScreenshot();
	}


	@When(/^user "([^"]*)?" on the optional element "([^"]*)?" with timeout as (\d+) seconds$/)
	def interactWithOptionalElementWithTimeout(String action, String object, int timeout) {
		switch (action.toLowerCase()) {
			case "click":
				CommonUtils.handleOptionalElement(object, {
					-> CommonUtils.tap(object)
				}, timeout)
				break

			case "clear text":
				CommonUtils.handleOptionalElement(object, {
					-> CommonUtils.clearText(object)
				})
				break

			default:
				KeywordUtil.markWarning("Unsupported action: " + action)
		}
		CommonUtils.takeScreenshot();
	}


	@When(/^user click on(?: (?:.*?))? element "([^"]*)"$/)
	def clickOnElement(String object) {
		CommonUtils.tap(object)
		CommonUtils.takeScreenshot();
	}

	@When(/^user enter(?: (?:.*?))? on element "([^"]*)" as "([^"]*)"$/)
	def enterValueFromGlobalVariable(String object, String value) {
		if(value.containsIgnoreCase("GlobalVariable.")) {
			// Use reflection to get the GlobalVariable value dynamically
			String globalVarName = value.split("\\.")[1]
			println("---> "+globalVarName);
			value = GlobalVariable."$globalVarName"
			println("---> "+value);
			if (value == null || value.toString().trim().isEmpty()) {
				throw new Exception("GlobalVariable.${globalVarName} is empty or not defined")
			}
		}
		CommonUtils.setText(object, value);
		CommonUtils.takeScreenshot();
	}

	@When(/^user wait for(?: .*?)? element "([^"]*)" for (\d+) second(?:s?) to be (clickable|visible|present)$/)
	def waitForTheElement(String object, int timeoutInSeconds, String condition) {
		CommonUtils.waitForElement(object, timeoutInSeconds);

		CommonUtils.takeScreenshot();
	}

	@Then(/^user expect to see the(?: .*?)? element "([^"]*)"$/)
	def isElementPresent(String object) {
		assertTrue(CommonUtils.isElementPresent(object));

		CommonUtils.takeScreenshot();
	}

	@Then(/^user expect the element "([^"]*)" to not exist$/)
	def isElementNotPresent(String object) {
		assertFalse(CommonUtils.isElementPresent(object));

		CommonUtils.takeScreenshot();
	}

	@When(/^user opens "([^"]*)" via Quick Menu, landing on "([^"]*)" or using Others "([^"]*)"$/)
	def userOpensQuickMenu(String quickMenuObject, String landingMenu, String menuObject) {
		String quickMenuPath = LocatorUtil.getLocatorPath(quickMenuObject)
		String landingMenuPath = LocatorUtil.getLocatorPath(landingMenu)
		String menuPath = LocatorUtil.getLocatorPath(menuObject)

		DashboardPage.handleQuickMenu(quickMenuPath, landingMenuPath, menuPath)
		CommonUtils.takeScreenshot();
	}

	@When(/^user opens(?: (?:.*?))? via (bottom navigation menu|quick menu) element "([^"]*)"$/)
	def userOpensAxisMenu(String menuType, String menuObject) {
		DashboardPage.handleAxisQuickMenu(menuObject, menuType)
	}



	@When(/^user scrolls to "([^"]*)"$/)
	def userScrollsToText(String text) {
		CommonUtils.scrollToText(text)
		CommonUtils.takeScreenshot();
	}

	@When(/^user swipes "([^"]*)" on element "([^"]*)" (\d+) times$/)
	def userSwipes(String direction, String object, int times) {
		//		String objectPath = CommonUtils.getTestObject(object);
		for (int i = 0; i < times; i++) {
			println "Swipe attempt ${i + 1} on ${object} towards ${direction}"
			CommonUtils.swipe(object, direction)
		}

		CommonUtils.takeScreenshot();
	}

	@When(/^user gets text from "([^"]*)" and stores it$/)
	def getTextAndStore(String object) {
		String text = CommonUtils.getTextFromElement(object)
		GlobalVariable.extractedText = text
		println "Stored text: ${GlobalVariable.extractedText}"
		CommonUtils.takeScreenshot();
	}

	@When(/^user gets numeric value from "([^"]*)" and stores it$/)
	def getNumericAndStore(String object) {
		int number = CommonUtils.getNumericFromElement(object)

		GlobalVariable.extractedNumber = number
		println "Stored numeric value: ${GlobalVariable.extractedNumber}"

		CommonUtils.takeScreenshot();
	}

	@Then(/^user compares value "([^"]*)" with "([^"]*)" using "(equal|less or equal|more or equal|less than|more than)"$/)
	def compareUserValues(String value1, String value2, String comparisonType) {
		CommonUtils.compareValues(value1, value2, comparisonType)
		CommonUtils.takeScreenshot();
	}


	@Then(/^user takes the screenshot name "([^"]*)"$/)
	def takeScreenshot(String screenshotName) {
		CommonUtils.captureScreenshot(screenshotName)
	}

	@When(/^user get otp from email "([^"]*)"$/)
	def getOTP() {
		CommonUtils.getOTPFromEmail()
	}

	@And("system detects current day and selects matching packages:")
	def detectDayAndSelectPackages(List<Map<String, String>> dataTable) {
		// dataTable sudah otomatis terisi dari feature file
		dataTable.each { row ->
			println("Day: " + row['day'] + ", Package: " + row['packageName'])
		}
	}
	
	@Then("all configured packages should be found on the screen")
	def validateAllPackages() {
	}
}