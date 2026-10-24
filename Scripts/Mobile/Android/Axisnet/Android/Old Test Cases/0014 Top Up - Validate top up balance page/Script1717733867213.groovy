import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

'Running test case login'
Mobile.callTestCase(findTestCase('Test Cases/Mobile/Android/Axisnet/Android/Old Test Cases/00000 Call Test Case - Login using number with balance'), [:], FailureHandling.STOP_ON_FAILURE)

'Swipe left'
Mobile.swipe(890, 1091, 390, 1091)

'Verify top up balance show on dashboard quick menu'
Mobile.verifyElementVisible(findTestObject('null'), 0)

'Click balance more menu chevron button on dashboard page'
Mobile.tap(findTestObject('null'), 0)

'Wait balance more menu page to fully loaded'
Mobile.waitForElementPresent(findTestObject('null'), 0)

'Screenshot balance more menu page'
Mobile.takeScreenshot()

'Click top up menu on balance more menu page'
Mobile.tap(findTestObject('null'), 0)

'Wait top up balance page to fully loaded'
Mobile.waitForElementPresent(findTestObject('null'), 0)

'Verify top up balance denom show'
Mobile.verifyElementVisible(findTestObject('null'), 0)

'Screenshot top up balance page'
Mobile.takeScreenshot()

'Clear session'
Mobile.closeApplication()
