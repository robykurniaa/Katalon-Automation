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
import com.kms.katalon.core.testobject.MobileTestObject.MobileLocatorStrategy
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys


'Open myXL'
Mobile.startApplication(GlobalVariable.APK, true)

'Verify CVP'
if (Mobile.waitForElementPresent(findTestObject('null'), 0)) {
	'Screenshot CVP'
	Mobile.takeScreenshot()
		
	'Click Continue on CVP'
	Mobile.tap(findTestObject('null'), 0)
}
			
'Verify Checkbox Login'
Mobile.waitForElementPresent(findTestObject('null'), 0)
	
'Screenshot Checkbox'
Mobile.takeScreenshot()
	
'Tick Checkbox Login'
Mobile.tap(findTestObject('null'), 0)
	
'Screenshot Success Tick Checkbox'
Mobile.takeScreenshot()
	
'Click Sign in to myXL Button'
Mobile.tap(findTestObject('null'), 0)

'Verify Choose Login Segment Page'
Mobile.waitForElementPresent(findTestObject('null'), 0)

'Screenshot Choose Login Segment Page'
Mobile.takeScreenshot()

'Click XL Prepaid Segment Button'
Mobile.tap(findTestObject('null'), 0)

'Verify Input Number Page'
Mobile.waitForElementPresent(findTestObject('null'), 0)

'Screenshot Input Number Page'
Mobile.takeScreenshot()

'Input XL Prepaid MSISDN'
Mobile.setText(findTestObject('null'), '087883021819', 0)

'Screenshot Success Input XL Prepaid MSISDN'
Mobile.takeScreenshot()

'Click Continue Button - Login'
Mobile.tap(findTestObject('null'), 0)

'Verify Input OTP Page'
Mobile.waitForElementPresent(findTestObject('null'), 0)

'Input OTP'
Mobile.setText(findTestObject('null'), GlobalVariable.validOTP, 0)

'Screenshot Success Input OTP'
Mobile.takeScreenshot()

'Handling Interstitial Page'
if (Mobile.waitForElementPresent(findTestObject('null'), 0, FailureHandling.OPTIONAL)) {
	'Close Interstitial Page'
	(Mobile.tap(findTestObject('null'), 0))
}

'Handling Medalia'
if (Mobile.waitForElementPresent(findTestObject('null'), 0, FailureHandling.OPTIONAL)) {
	'Close Medalia'
	Mobile.tap(findTestObject('null'),0)
}

'Verify Dashboard'
Mobile.waitForElementPresent(findTestObject('null'), 0)

'Define Balance on Balance Card'
def balanceAfter = Mobile.getText(findTestObject('null'), 0, FailureHandling.STOP_ON_FAILURE)

'Verify balance after transaction is IDR 59.473'
Mobile.verifyEqual(balanceAfter, 'IDR 59.473')

'Define Quota Summary'
def internetQuotaAfter = Mobile.getText(findTestObject('null'), 0)

'Verify quota after transaction'
Mobile.verifyEqual(internetQuotaAfter , '13.2 GB')

'Define Call Quota After Transaction'
def callQuotaAfter = Mobile.getText(findTestObject('null'), 0)

Mobile.verifyEqual(callQuotaAfter, '20 Minutes')

'Define Poin After Transaction'
def poinAfter = Mobile.getText(findTestObject('null'), 0)

'Verify XL Poin After transaction is 3.982'
Mobile.verifyEqual(poinAfter, '3.982')

'Screenshot Balance, Quota, and XL Poin after transaction'
Mobile.takeScreenshot()

'Click View My Package on Quota Summary Card'
Mobile.tap(findTestObject('null'), 0)

'Wait for Quota Detail Page fully displayed'
Mobile.waitForElementPresent(findTestObject('null'), 0)

'Verify XCP VIP 13.5 GB in Quota Detail Page'
Mobile.verifyElementExist(findTestObject('null'), 0)

'Verify Main Quota 10 GB'
Mobile.verifyElementExist(findTestObject('null'), 0)

'Verify Daily Quota 200 MB'
Mobile.verifyElementExist(findTestObject('null'), 0)

'Verify Call Quota 20 Minutes'
Mobile.verifyElementExist(findTestObject('null'), 0)

'Verify Bonus Quota 1.5 GB'
Mobile.verifyElementExist(findTestObject('null'), 0)

'Screenshot Quota detail Page'
Mobile.takeScreenshot()

Mobile.closeApplication()