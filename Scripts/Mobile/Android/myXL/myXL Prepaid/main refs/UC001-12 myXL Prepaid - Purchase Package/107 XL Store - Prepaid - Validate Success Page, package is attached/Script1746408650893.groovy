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

'Splash Screen'
Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid/XL Store/107 Purchase Package - Validate Success Page, package is attached/1 Splash Screen.png')

Mobile.delay(10, FailureHandling.CONTINUE_ON_FAILURE)

'Verify CVP'
if (Mobile.waitForElementPresent(findTestObject('null'), 0) == true) {
    'CVP Screenshot'
    Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid/XL Store/107 Purchase Package - Validate Success Page, package is attached/2 Lets Start Button screenshot.png')

    'Click Continue on CVP'
    Mobile.tap(findTestObject('null'), 0)

    'Verify Checkbox Login'
    Mobile.verifyElementVisible(findTestObject('null'), 0)

    'Tick Checkbox Login'
    Mobile.tap(findTestObject('null'), 0)

    'Tick Checkbox Login ScreenShot'
    Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid/XL Store/107 Purchase Package - Validate Success Page, package is attached/3 Check Box screenshot.png')
} else {
    'Verify Checkbox Login'
    Mobile.verifyElementVisible(findTestObject('null'), 0)

    'Tick Checkbox Login'
    Mobile.tap(findTestObject('null'), 0)

    'Tick Checkbox Login ScreenShot'
    Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid/XL Store/107 Purchase Package - Validate Success Page, package is attached/3 Check Box screenshot.png')
}

'Click Sign in to myXL Button'
Mobile.tap(findTestObject('null'), 0)

'Click Sign in to myXL Button ScreenShot'
Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid/XL Store/107 Purchase Package - Validate Success Page, package is attached/4 Sign in to myXL screenshot.png')

Mobile.waitForElementVisible(findTestObject('null'), 
    0)

'Click XL Prepaid Segment Button'
Mobile.tap(findTestObject('null'), 0)

'Click XL Prepaid Segment Button ScreenShot'
Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid/XL Store/107 Purchase Package - Validate Success Page, package is attached/5 XL Prepaid Segment screenshot.png')

Mobile.waitForElementVisible(findTestObject('null'), 
    0)

'Input XL MSISDN'
Mobile.setText(findTestObject('null'), '6287884076185', 
    0)

'Input XL MSISDN ScreenShot'
Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid/XL Store/107 Purchase Package - Validate Success Page, package is attached/6 Validate Login using Prepaid MSISDN.png')

'Click Continue Button - Login'
Mobile.tap(findTestObject('null'), 0)

'Input OTP'
Mobile.setText(findTestObject('null'), '190160', 0)

'Input OTP ScreenShot'
Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid/XL Store/107 Purchase Package - Validate Success Page, package is attached/7 OTP Input screenshot.png')

'Verify Medalia'
if (Mobile.verifyElementExist(findTestObject('null'), 0, FailureHandling.OPTIONAL)) {
    'Verify Medalia ScreenShot'
    Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid/XL Store/107 Purchase Package - Validate Success Page, package is attached/8 Validate Medalia Dashboard.png')

    'Close Medalia'
    Mobile.tap(findTestObject('null'), 0)
} else {
    'Verify Dashboard'
    Mobile.verifyElementVisible(findTestObject('null'), 0)

    'Dashboard ScreenShot'
    Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid/XL Store/107 Purchase Package - Validate Success Page, package is attached/9 Validate Dashboard.png')
}

'VerifyBalance'
Mobile.verifyElementVisible(findTestObject('null'), 0)

Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid/XL Store/107 Purchase Package - Validate Success Page, package is attached/10 Validate Balance.png')

Mobile.scrollToText('View My Package')

'Verify Quota Summary'
Mobile.verifyElementVisible(findTestObject('null'), 0)

Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid/myXL Prepaid/XL Store/107 Purchase Package - Validate Success Page, package is attached/11 Quota Summary screenshot.png')

'Click View My Package'
Mobile.tap(findTestObject('null'), 0)

'Scroll to Youtube 1GB'
Mobile.scrollToText('Youtube 1GB')

'Youtube 1GB - Quota Detail'
Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid/myXL Prepaid/XL Store/107 Purchase Package - Validate Success Page, package is attached/12 Youtube 1GB - Quota Detail.png')

//'Verify Text and Quota'
//Mobile.verifyElementVisible(findTestObject('null'), 0)
//Mobile.verifyElementVisible(findTestObject('null'), 0)
//Mobile.verifyElementVisible(findTestObject('null'), 0)
//Mobile.verifyElementVisible(findTestObject('null'), 0)
//Mobile.verifyElementVisible(findTestObject('null'), 0)
//Mobile.verifyElementVisible(findTestObject('null'), 0)
//Mobile.verifyElementVisible(findTestObject('null'), 0)
//Mobile.verifyElementVisible(findTestObject('null'), 0)
//
//'Quota Detail ScreenShot'
//Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid/XL Store/107 Purchase Package - Validate Success Page, package is attached/22 Quota Detail.png')
//
//'Click Unreg'
//Mobile.tap(findTestObject('null'), 0)
//
//'Unreg ScreenShot'
//Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid/XL Store/107 Purchase Package - Validate Success Page, package is attached/23 Unreg.png')
//
//'Click Stop Package Button'
//Mobile.tap(findTestObject('null'), 0)
//
//'Waiting'
//Mobile.waitForElementPresent(findTestObject('null'), 0)
//
//'Stop Package Succes ScreenShot'
//Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid/XL Store/107 Purchase Package - Validate Success Page, package is attached/24 Stop Package Success.png')
//
//'Click Back my Package'
//Mobile.tap(findTestObject('null'), 0)
//
//'Waiting'
//Mobile.waitForElementPresent(findTestObject('null'), 0)
//
//'Quota Detail is Empty ScreenShot'
//Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid/XL Store/107 Purchase Package - Validate Success Page, package is attached/25 Quota Detail is Empty.png')
Mobile.closeApplication()

