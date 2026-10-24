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
Mobile.setText(findTestObject('null'), GlobalVariable.prepaidAkrabNumA,
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

'Sharing Menu'
if (Mobile.verifyElementVisible(findTestObject('null'), 0, FailureHandling.OPTIONAL)) {
	Mobile.tap(findTestObject('null'), 0)
} else {
	'Click on Others Menu'
	Mobile.tap(findTestObject('null'), 0)

	Mobile.takeScreenshot()

	Mobile.tap(findTestObject('null'), 0)

	Mobile.takeScreenshot()
}

//Mobile.takeScreenshot()
Mobile.delay(2)

'Share Balance Menu'
Mobile.tap(findTestObject('null'), 0)
'Input XL Prepaid Number'
Mobile.setText(findTestObject('null'), '6287884074017', 0)

Mobile.tap(findTestObject('null'), 0)

Mobile.takeScreenshot()

Mobile.delay(2)

'Error Page Handling'
if(Mobile.verifyElementExist(findTestObject('null'), 0, FailureHandling.OPTIONAL)) {

	Mobile.takeScreenshot()
	
	Mobile.tap(findTestObject('null'), 0)
}
else {
	'Edit Balance with insuff balance'
	Mobile.setText(findTestObject('null'), '50000', 0)
	
	Mobile.takeScreenshot()
}



Mobile.closeApplication()

