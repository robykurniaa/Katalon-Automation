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

Mobile.takeScreenshot()

'Click on Agree on Consent Half Card Login'
Mobile.tap(findTestObject('null'), 0)

'Click XL Prepaid Segment Button'
Mobile.tap(findTestObject('null'), 0)

'Click XL Prepaid Segment Button ScreenShot'
Mobile.takeScreenshot()

'Input XL MSISDN'
Mobile.setText(findTestObject('null'), GlobalVariable.prepaidAkrabNumA, 
    0)

'Input XL MSISDN ScreenShot'
Mobile.takeScreenshot()

'Click Continue Button - Login'
Mobile.tap(findTestObject('null'), 0)

'Input OTP'
Mobile.setText(findTestObject('null'), '190160', 0)

'Input OTP ScreenShot'
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
Mobile.verifyElementVisible(findTestObject('null'), 0)

Mobile.delay(2)

Mobile.tap(findTestObject('null'), 0)

'Verify'
Mobile.verifyElementVisible(findTestObject('null'), 0)

'Tap on Akrab'
Mobile.tap(findTestObject('null'), 0)

'Validate Akrab Landing Page'
Mobile.verifyElementVisible(findTestObject('null'), 0)

Mobile.takeScreenshot()

Mobile.verifyElementExist(findTestObject('null'), 0)

'Click Add Member'
Mobile.tap(findTestObject('null'), 0)
	
Mobile.takeScreenshot()
	
Mobile.waitForElementPresent(findTestObject('null'), 0)
	
Mobile.tap(findTestObject('null'), 0)

Mobile.takeScreenshot()

'Click Organizer name input Box'
Mobile.tap(findTestObject('null'), 0)

'Input Organizer name'
Mobile.setText(findTestObject('null'), 'DT Automation', 0)

Mobile.hideKeyboard()

'Click on Input Box Member Number'
Mobile.tap(findTestObject('null'), 0)

'Input Invalid Number'
Mobile.setText(findTestObject('null'), '085964418296', 0)

Mobile.takeScreenshot()

Mobile.setText(findTestObject('null'), 'Prepaid Num', 0)

Mobile.takeScreenshot()

'Click Continue'
Mobile.tap(findTestObject('null'), 0)

Mobile.takeScreenshot()

'Click Yes'
Mobile.tap(findTestObject('Object Repository/Akrab/Add Member - Yes'), 0)

Mobile.delay(60)

Mobile.closeApplication()

