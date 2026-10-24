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

'Verify CVP'
if (Mobile.waitForElementPresent(findTestObject('null'), 0, FailureHandling.OPTIONAL)) {
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
Mobile.setText(findTestObject('null'), GlobalVariable.preNum, 0)

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

'Screenshot Dashboard'
Mobile.takeScreenshot()

'Profile Menu'
Mobile.tap(findTestObject('null'), 0)

Mobile.takeScreenshot()

'Account Info'
Mobile.tap(findTestObject('null'), 0)

Mobile.delay(5)

'Screenshot Profile'
Mobile.takeScreenshot()

'Edit Account Info'
Mobile.tap(findTestObject('null'), 0)

Mobile.takeScreenshot()

'Edit Account Info - Clear Name'
Mobile.clearText(findTestObject('null'), 0)

Mobile.takeScreenshot()

'Edit Account Info - Set Name'
Mobile.setText(findTestObject('null'), 'Tes Automation', 0)

Mobile.takeScreenshot()

Mobile.hideKeyboard()

Mobile.tap(findTestObject('null'), 0)

'Edit Account Info - Clear Valid Email'
Mobile.clearText(findTestObject('null'), 0)

Mobile.takeScreenshot()

'Edit Account Info - Set Invalid Email'
Mobile.setText(findTestObject('null'), 'Testing', 0)

Mobile.takeScreenshot()

'Verify Valid Email'
Mobile.verifyElementText(findTestObject('null'), 'Please use valid email')

Mobile.takeScreenshot()

'Edit Account Info - Clear Invalid Email'
Mobile.clearText(findTestObject('null'), 0)

Mobile.takeScreenshot()

'Edit Account Info - Set Valid Email'
Mobile.setText(findTestObject('null'), 'Testingbigbang@gmail.com', 0)

Mobile.takeScreenshot()

Mobile.hideKeyboard()

'Save Account Info'
Mobile.tap(findTestObject('null'), 0)

Mobile.delay(5)

Mobile.takeScreenshot()

Mobile.pressBack()

'Trx History'
Mobile.tap(findTestObject('null'), 5)

Mobile.delay(10)

Mobile.takeScreenshot()

'Profile Menu'
Mobile.tap(findTestObject('null'), 0)

'myXL Wallet'
Mobile.tap(findTestObject('null'), 0)

Mobile.takeScreenshot()

Mobile.pressBack()

'Balance Control'
Mobile.tap(findTestObject('null'), 5)

Mobile.takeScreenshot()

'SMS Switch - Activate'
Mobile.tap(findTestObject('null'), 0)

'Check Activation'
if(Mobile.waitForElementPresent(findTestObject('null'), 5)) {
	Mobile.tap(findTestObject('null'), 0)
	Mobile.takeScreenshot()
} else {
	Mobile.verifyElementExist(findTestObject('null'), 0)
	Mobile.tap(findTestObject('null'), 0)
	Mobile.takeScreenshot()
	}

Mobile.delay(2)

Mobile.pressBack()

'PulsaLater Menu'
Mobile.tap(findTestObject('null'), 0)

'Interstitial Handling'
if(Mobile.verifyElementExist(findTestObject('null'), 0)) {
	'Click OK'
	Mobile.tap(findTestObject('null'), 0)
}

'Verify subs has PulsaLater Limit Available'
Mobile.tap(findTestObject('null'), 0)

'Get displayed denom'
def message_profile = Mobile.getText(findTestObject('null'),10)

'Verify if displayed denom has not changed'
Mobile.verifyEqual(message_profile, 'IDR 20,000')

'Verify PulsaLater denom is the same from every entry point'
Mobile.takeScreenshot()

Mobile.delay(3)

Mobile.pressBack()

'PUK Code'
Mobile.tap(findTestObject('null'), 0)

Mobile.takeScreenshot()

'Input ICCID'
Mobile.setText(findTestObject('null'), '8962116638410958236', 0)

Mobile.takeScreenshot()

'Check Button'
Mobile.tap(findTestObject('null'), 0)

Mobile.takeScreenshot()

'PUK Copy Code'
Mobile.tap(findTestObject('null'), 0)

Mobile.takeScreenshot()

Mobile.delay(3)

Mobile.pressBack()

'Roaming Service'
Mobile.tap(findTestObject('null'), 0)

Mobile.takeScreenshot()

'Check Destination Country'
Mobile.tap(findTestObject('null'), 0)

Mobile.takeScreenshot()

'Set Country'
Mobile.setText(findTestObject('null'), 'Afghanistan', 0)

Mobile.tap(findTestObject('null'), 0)

Mobile.takeScreenshot()

'View Indonesian Embassy Info'
Mobile.tap(findTestObject('null'), 0)

Mobile.takeScreenshot()

'Cross Button - Indonesia Embassy'
Mobile.tap(findTestObject('null'), 0)

Mobile.takeScreenshot()

'Roaming info - Umroh Plus'
Mobile.tap(findTestObject('null'), 0)

Mobile.takeScreenshot()

Mobile.scrollToText('Internet Umroh Plus')

Mobile.pressBack()

'Roaming info - XL Pass'
Mobile.tap(findTestObject('null'), 0)

Mobile.takeScreenshot()

'Roaming info - Basic Tariff'
Mobile.tap(findTestObject('null'), 0)

Mobile.takeScreenshot()

'Roaming info - Basic Tariff - SMS'
Mobile.scrollToText('SMS')

Mobile.takeScreenshot()

Mobile.pressBack()

'Search Destination Country - Delete'
Mobile.clearText(findTestObject('null'), 0)

Mobile.takeScreenshot()

Mobile.delay(2)

Mobile.pressBack()

Mobile.scrollToText('Language')

'Language Menu'
Mobile.tap(findTestObject('null'), 0)

Mobile.takeScreenshot()

'Bahasa'
Mobile.tap(findTestObject('null'), 0)

Mobile.takeScreenshot()

'Lang - Save'
Mobile.tap(findTestObject('null'), 0)

Mobile.takeScreenshot()

'Lang - Yes'
Mobile.tap(findTestObject('null'), 0)

Mobile.takeScreenshot()

Mobile.delay(3)

'Profile Menu'
Mobile.tap(findTestObject('null'), 0)

Mobile.scrollToText('Bahasa')

'Language Menu'
Mobile.tap(findTestObject('null'), 0)

'Lang - Eng'
Mobile.tap(findTestObject('null'), 0)

Mobile.takeScreenshot()

'Lang - Save'
Mobile.tap(findTestObject('null'), 0)

Mobile.takeScreenshot()

'Lang - Yes'
Mobile.tap(findTestObject('null'), 0)

Mobile.takeScreenshot()

Mobile.delay(2)

Mobile.pressBack()

'Logout Menu'
Mobile.scrollToText('Logout')

Mobile.takeScreenshot()

'Logout Button'
Mobile.tap(findTestObject('null'), 0)

Mobile.waitForElementPresent(findTestObject('null'), 0)

Mobile.takeScreenshot()

'Logout'
Mobile.tap(findTestObject('null'), 0)

Mobile.delay(2)

Mobile.takeScreenshot()

Mobile.closeApplication()