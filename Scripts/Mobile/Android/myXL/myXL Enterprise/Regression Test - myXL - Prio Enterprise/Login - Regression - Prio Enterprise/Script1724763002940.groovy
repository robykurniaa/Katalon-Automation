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

'Click Prioritas Enterprise Segment Button'
Mobile.tap(findTestObject('null'), 0)

'Click Prioritas Enterprise Segment 1 Button ScreenShot'
Mobile.takeScreenshot()

'Click Prioritas Enterprise Segment Button ScreenShot'
Mobile.tap(findTestObject('null'), 0)

'Click Prioritas Enterprise Segment 2 Button ScreenShot'
Mobile.takeScreenshot()

'Input Invalid MSISDN'
Mobile.setText(findTestObject('null'), GlobalVariable.invalidNum, 0)

'Screenshot Success Input Invalid MSISDN'
Mobile.takeScreenshot()

'Click Continue Button - Login'
Mobile.tap(findTestObject('null'), 0)

'Verify Error Message Input Invalid MSISDN'
Mobile.waitForElementPresent(findTestObject('null'), 0)

'Screenshot Error Message Input Invalid MSISDN'
Mobile.takeScreenshot()

'Go Back'
Mobile.tap(findTestObject('null'), 0)

Mobile.pressBack()

'Click Prioritas Enterprise Segment Button ScreenShot'
Mobile.tap(findTestObject('null'), 0)

'Screenshot Choose Login Segment Page'
Mobile.takeScreenshot()

'Verify Input Number Page'
Mobile.waitForElementPresent(findTestObject('null'), 0)

'Screenshot Input Number Page'
Mobile.takeScreenshot()

'Input Axis MSISDN'
Mobile.setText(findTestObject('null'), GlobalVariable.axisNum, 0)

'Screenshot Success Input Axis MSISDN'
Mobile.takeScreenshot()

'Click Continue Button - Login'
Mobile.tap(findTestObject('null'), 0)

'Verify Error Page'
Mobile.waitForElementPresent(findTestObject('null'), 0)

'Screenshot Failed Login using Axis MSISDN'
Mobile.takeScreenshot()

'Go Back From Axisnet Handling Page Login'
Mobile.tap(findTestObject('null'), 0)

Mobile.pressBack()

'Click Prioritas Enterprise Segment Button ScreenShot'
Mobile.tap(findTestObject('null'), 0)

'Verify Input Number Page'
Mobile.waitForElementPresent(findTestObject('null'), 0)

'Screenshot Input Number Page'
Mobile.takeScreenshot()

'Input Cancelled MSISDN'
Mobile.setText(findTestObject('null'), GlobalVariable.cancelNum, 0)

'Screenshot Success Input Cancelled MSISDN'
Mobile.takeScreenshot()

'Click Continue Button - Login'
Mobile.tap(findTestObject('null'), 0)

'Verify Error Message Cancelled MSISDN'
Mobile.waitForElementPresent(findTestObject('null'), 0)

'Screenshot Error Message Cancelled MSISDN'
Mobile.takeScreenshot()

Mobile.tap(findTestObject('null'), 0)

Mobile.clearText(findTestObject('null'), 0)

'Input XL Prio Enterprise MSISDN'
Mobile.setText(findTestObject('null'), GlobalVariable.prioEntNum, 0)

'Screenshot Success Input XL Prio Paylater MSISDN'
Mobile.takeScreenshot()

'Click Continue Button - Login'
Mobile.tap(findTestObject('null'), 0)

Mobile.tap(findTestObject('null'), 0)

'Waiting Countdown Enable Resend Button'
Mobile.waitForElementPresent(findTestObject('null'), 70)

'Click Resend OTP'
Mobile.tap(findTestObject('null'), 0)

'Screenshot Success Click Resend OTP'
Mobile.takeScreenshot()

'Verify Input OTP Page'
Mobile.waitForElementPresent(findTestObject('null'), 0)

'Input OTP'
Mobile.setText(findTestObject('null'), GlobalVariable.invalidOTP, 0)

'Screenshot Success Input Invalid OTP'
Mobile.takeScreenshot()

Mobile.clearText(findTestObject('null'), 0)

'Input OTP'
Mobile.setText(findTestObject('null'), GlobalVariable.validOTP, 0)

'Screenshot Success Input Valid OTP'
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

Mobile.delay(10)

'Screenshot Dashboard'
Mobile.takeScreenshot()

'Click Profile Menu'
Mobile.tap(findTestObject('null'), 0)

'Screenshot Profile Menu'
Mobile.takeScreenshot()

'Scroll to Logout'
Mobile.scrollToText('Logout')

'Screenshot Logout Button'
Mobile.takeScreenshot()

'Click Logout Button'
Mobile.tap(findTestObject('null'), 0)

'Verify Logout Option'
Mobile.waitForElementPresent(findTestObject('null'), 0)

'Screenshot Logout Option'
Mobile.takeScreenshot()

'Click Continue Logout'
Mobile.tap(findTestObject('null'), 0)

'Verify Login Page'
Mobile.waitForElementPresent(findTestObject('null'), 0)

'Close App'
Mobile.closeApplication()

