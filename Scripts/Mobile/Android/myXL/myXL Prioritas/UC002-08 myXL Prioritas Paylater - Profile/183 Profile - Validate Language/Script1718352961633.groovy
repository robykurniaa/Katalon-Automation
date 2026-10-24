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
Mobile.waitForElementPresent(findTestObject('null'), 
    0)

'Screenshot Choose Login Segment Page'
Mobile.takeScreenshot()

'Click XL Prioritas Segment Button'
Mobile.tap(findTestObject('null'), 0)

'Click XL Prioritas Segment Button ScreenShot'
Mobile.takeScreenshot()

'Input XL Prio Paylater MSISDN'
Mobile.setText(findTestObject('null'), GlobalVariable.prioPaylaterNum, 
    0)

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
    Mobile.tap(findTestObject('null'), 0)
}

'Handling Medalia'
if (Mobile.waitForElementPresent(findTestObject('null'), 0, FailureHandling.OPTIONAL)) {
    'Close Medalia'
    Mobile.tap(findTestObject('null'), 0)
}

'Tap Profile'
Mobile.tap(findTestObject('null'), 0)

Mobile.delay(4)

'Profile SS'
Mobile.takeScreenshot()

Mobile.scrollToText('7.10.0')

if (Mobile.waitForElementPresent(findTestObject('null'), 0, FailureHandling.OPTIONAL)) {
    'Click Bahasa'
    Mobile.tap(findTestObject('null'), 0)

    'Click English'
    Mobile.tap(findTestObject('null'), 0)

    Mobile.takeScreenshot()

    Mobile.tap(findTestObject('null'), 0)

    Mobile.takeScreenshot()

    Mobile.tap(findTestObject('null'), 0)

    Mobile.takeScreenshot()
}

if (Mobile.waitForElementPresent(findTestObject('null'), 0, FailureHandling.OPTIONAL)) {
    'Click Language'
    Mobile.tap(findTestObject('null'), 0)

    Mobile.takeScreenshot()

    'Click English'
    Mobile.tap(findTestObject('null'), 0)

    Mobile.tap(findTestObject('null'), 0)

    Mobile.takeScreenshot()

    Mobile.tap(findTestObject('null'), 0)

    Mobile.takeScreenshot()
}

//'Click Language'
//Mobile.tap(findTestObject('null'), 0)
//
//Mobile.delay(5)
//
//Mobile.takeScreenshot()
//
//'Click Bahasa'
//Mobile.tap(findTestObject('null'), 0)
//
//Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prioritas Paylater/Profile/183 Profile - Validate Language/18 Bahasa.png')
//
//Mobile.tap(findTestObject('null'), 0)
//
//Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prioritas Paylater/Profile/183 Profile - Validate Language/19 Save.png')
//
//Mobile.tap(findTestObject('null'), 0)
//
//Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prioritas Paylater/Profile/183 Profile - Validate Language/20 Yes.png')
//
//Mobile.delay(10)
//
//Mobile.tap(findTestObject('null'), 0)
//
//Mobile.scrollToText('Language 2')
//
//'Click Bahasa'
//Mobile.tap(findTestObject('null'), 0)
//
//Mobile.delay(5)
//
//Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prioritas Paylater/Profile/183 Profile - Validate Language/21 Language 2.png')
//
//'Click English'
//Mobile.tap(findTestObject('null'), 0)
//
//Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prioritas Paylater/Profile/183 Profile - Validate Language/22 English.png')
//
//Mobile.tap(findTestObject('null'), 0)
//
//Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prioritas Paylater/Profile/183 Profile - Validate Language/23 Simpan.png')
//
//Mobile.tap(findTestObject('null'), 0)
//
//Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prioritas Paylater/Profile/183 Profile - Validate Language/24 Ya.png')
Mobile.delay(10)

'Tap Profile'
Mobile.tap(findTestObject('null'), 0)

Mobile.takeScreenshot()

Mobile.closeApplication()

