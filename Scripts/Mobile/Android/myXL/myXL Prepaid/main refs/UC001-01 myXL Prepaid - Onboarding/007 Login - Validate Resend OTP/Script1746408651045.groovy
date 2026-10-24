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
		
'Screenshot Login Landing'
Mobile.takeScreenshot()
	
'Click Login to myXL Button'
Mobile.tap(findTestObject('null'), 0)

'Verify Consent Half Card Login'
Mobile.waitForElementPresent(findTestObject('null'), 0)

'Click on Agree on Consent Half Card Login'
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
Mobile.setText(findTestObject('null'), GlobalVariable.preNum, 0)

'Screenshot Success Input XL Prepaid MSISDN'
Mobile.takeScreenshot()

'Click Continue Button - Login'
Mobile.tap(findTestObject('null'), 0)

'Waiting Countdown Enable Resend Button'
Mobile.waitForElementPresent(findTestObject('null'), 70)

'Click Resend OTP'
Mobile.tap(findTestObject('null'), 0)

'Screenshot Success Click Resend OTP'
Mobile.takeScreenshot()

'Close App'
Mobile.closeApplication()
