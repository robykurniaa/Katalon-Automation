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
			
'Screenshot Welcome Page'
Mobile.takeScreenshot()

'Click Login to myXL Button'
Mobile.tap(findTestObject('null'), 0)

Mobile.takeScreenshot()

'Click Sign in to myXL Button'
Mobile.tap(findTestObject('null'), 0)

Mobile.takeScreenshot()

'Verify Choose Login Segment Page'
Mobile.waitForElementPresent(findTestObject('null'), 0)

'Screenshot Choose Login Segment Page'
Mobile.takeScreenshot()

'Click XL Prioritas Segment Button'
Mobile.tap(findTestObject('null'), 0)

'Click XL Prioritas Segment Button ScreenShot'
Mobile.takeScreenshot()

'Input XL Prio Paylater MSISDN'
Mobile.setText(findTestObject('null'), GlobalVariable.prioPaylaterNum, 0)

'Input XL MSISDN ScreenShot'
Mobile.takeScreenshot()

'Screenshot Success Input XL Paylater MSISDN'
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

Mobile.delay(5)

'Tap Profile'
Mobile.tap(findTestObject('null'), 0)

Mobile.delay(4)

'Profile SS'
Mobile.takeScreenshot()

'Tap Wallet'
Mobile.tap(findTestObject('null'), 0)

Mobile.delay(4)

'Wallet SS'
Mobile.takeScreenshot()

'Tap Wallet Balance'
Mobile.tap(findTestObject('null'), 0)

Mobile.delay(4)

'Wallet Balance SS'
Mobile.takeScreenshot()

Mobile.pressBack()

'Tap Wallet CC'
Mobile.tap(findTestObject('null'), 0)

Mobile.delay(4)

'Wallet CC SS'
Mobile.takeScreenshot()

'Add Credit Card'
Mobile.tap(findTestObject('null'), 0)

'Verify Half card'
Mobile.verifyElementExist(findTestObject('null'), 0)

'Wallet CC SS'
Mobile.takeScreenshot()

Mobile.tap(findTestObject('null'), 0)

'Wallet CC SS'
Mobile.takeScreenshot()

//'Tick Consent using CC'
//Mobile.tap(findTestObject('null'), 0)
//
//Mobile.tap(findTestObject('null'), 0)
//
//Mobile.delay(3)

//'Wallet CC SS'
//Mobile.takeScreenshot()

Mobile.pressBack()

Mobile.pressBack()

Mobile.delay(4)

'Tap Wallet OVO'
Mobile.scrollToText('OVO')

Mobile.tap(findTestObject('null'), 0)

Mobile.delay(4)

'Wallet OVO SS'
Mobile.takeScreenshot()

Mobile.pressBack()

Mobile.scrollToText('DANA')

Mobile.tap(findTestObject('null'), 0)

Mobile.delay(4)

'Wallet DANA SS'
Mobile.takeScreenshot()

Mobile.pressBack()

'Wallet Gopay'
Mobile.tap(findTestObject('null'), 0)

Mobile.delay(4)

'Wallet Gopay SS'
Mobile.takeScreenshot()

Mobile.pressBack()

'Wallet ShopeePay'
Mobile.tap(findTestObject('null'), 0)

Mobile.delay(4)

'Wallet ShopeePay SS'
Mobile.takeScreenshot()

Mobile.pressBack()

Mobile.closeApplication()


