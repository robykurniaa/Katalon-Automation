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

'Open myXL'
Mobile.startApplication(GlobalVariable.APK, true)

'Verify CVP'
if (Mobile.waitForElementPresent(findTestObject('null'), 0)) {
	'Screenshot CVP'
	Mobile.takeScreenshot()

	'Click Continue on CVP'
	Mobile.tap(findTestObject('null'), 0)
}

'Wait for Login to myXL Button'
Mobile.waitForElementPresent(findTestObject('null'), 0)

'Click Login to myXL Button'
Mobile.tap(findTestObject('null'), 0)

'Verify Consent Half Card Login'
Mobile.waitForElementPresent(findTestObject('null'), 0)

'Click on Agree on Consent Half Card Login'
Mobile.tap(findTestObject('null'), 0)

'Verify Choose Login Segment Page'
Mobile.waitForElementPresent(findTestObject('null'),
	0)

'Screenshot Choose Login Segment Page'
Mobile.takeScreenshot()

'Click XL Prepaid Segment Button'
Mobile.tap(findTestObject('null'), 0)

'Verify Input Number Page'
Mobile.waitForElementPresent(findTestObject('null'),
	0)

'Screenshot Input Number Page'
Mobile.takeScreenshot()

'Input XL Prepaid MSISDN'
Mobile.setText(findTestObject('null'), GlobalVariable.preNum,
	0)

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
	Mobile.tap(findTestObject('null'), 0)
}

'Handling Medalia'
if (Mobile.waitForElementPresent(findTestObject('null'), 0, FailureHandling.OPTIONAL)) {
	'Close Medalia'
	Mobile.tap(findTestObject('null'), 0)
}

'Verify Dashboard'
Mobile.waitForElementPresent(findTestObject('null'), 0)

'Screenshot Dashboard'
Mobile.takeScreenshot()

Mobile.delay(2)

'Validate Balance Before Transaction'
def balanceBefore = Mobile.getText(findTestObject('null'), 
	0, FailureHandling.STOP_ON_FAILURE)

println(balanceBefore)

'Validate Balance Number'
Mobile.verifyEqual(balanceBefore, 'IDR 64.712', FailureHandling.STOP_ON_FAILURE)

'Screenshot'
Mobile.takeScreenshot()

'Click XL Store Landing'
Mobile.tap(findTestObject('null'), 0)

Mobile.delay(2)

Mobile.waitForElementPresent(findTestObject('null'), 0)

'Click XL Store Landing ScreenShot'
Mobile.takeScreenshot()

'Main Package'
Mobile.tap(findTestObject('null'), 0)

Mobile.delay(5)

'PFP'
Mobile.takeScreenshot()

'Scroll to Akrab Card PFP'
Mobile.scrollToText('Large quota for family')

'Click Akrab Package'
Mobile.tap(findTestObject('null'), 0)

Mobile.scrollToText('13GB for 2 Members')

Mobile.waitForElementPresent(findTestObject('null'), 0)

'PLP'
Mobile.takeScreenshot()

'Define variable for Akrab 13GB price'
def akrab13GB = Mobile.getText(findTestObject('null'), 
	0, FailureHandling.STOP_ON_FAILURE)

'Validate Akrab Price'
Mobile.verifyEqual(akrab13GB, 'IDR 47.200')

'Click 13GB for 2 Members Package'
Mobile.tap(findTestObject('null'), 0)

Mobile.waitForElementPresent(findTestObject('null'), 0)

'PDP'
Mobile.takeScreenshot()

/*
 * 'Click on Total Amount Arrow' Mobile.tap(findTestObject('Object
 * Repository/myXL Prepaid - Buy Packages/Total Amount Arrow Up'), 0)
 * 
 * 'Take Screeenshot' Mobile.takeScreenshot()
 */

'Scroll down'
Mobile.scrollToText('XL Poin')

'Take Screeenshot'
Mobile.takeScreenshot()

'Click Activate'
Mobile.tap(findTestObject('null'), 0)

'Take Screeenshot'
Mobile.takeScreenshot()

'Wait for Confirmation Page'
Mobile.waitForElementPresent(findTestObject('null'), 0)

'Take Screenshot'
Mobile.takeScreenshot()

'Click on Balance'
Mobile.tap(findTestObject('null'), 0)

'Take Screenshot'
Mobile.takeScreenshot()

'Wait for Pay Button'
Mobile.waitForElementPresent(findTestObject('null'), 0)

'Click Pay Button'
Mobile.tap(findTestObject('null'), 0)

Mobile.delay(5)

'Handling Loading Page'
if(Mobile.waitForElementPresent(findTestObject('null'), 0,FailureHandling.OPTIONAL)) {
	'Screenshot Loading bar'
	Mobile.takeScreenshot()
	
	'Click Back to Dashboard'
	Mobile.waitForElementPresent(findTestObject('null'), 0,)
}

'Handle Waiting Transaction Page'
if(Mobile.waitForElementPresent(findTestObject('null'), 0, FailureHandling.OPTIONAL)) {
	'Screenshot Waiting Transaction Page'
	Mobile.takeScreenshot()
	
	'Click on See My Package Button'
	Mobile.tap(findTestObject('null'), 0)
}

'Back to Dashboard'
Mobile.pressBack()

Mobile.takeScreenshot()

Mobile.closeApplication()



