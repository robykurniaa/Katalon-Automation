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
Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid/XL Store/102 Purchase Package - Validate Tab Store Main Package XCM/1 Splash Screen.png')

Mobile.delay(10, FailureHandling.CONTINUE_ON_FAILURE)

'Verify CVP'
if (Mobile.waitForElementPresent(findTestObject('null'), 0) == true) {
    'CVP Screenshot'
    Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid/XL Store/102 Purchase Package - Validate Tab Store Main Package XCM/2 Lets Start Button screenshot.png')

    'Click Continue on CVP'
    Mobile.tap(findTestObject('null'), 0)

    'Verify Checkbox Login'
    Mobile.verifyElementVisible(findTestObject('null'), 0)

    'Tick Checkbox Login'
    Mobile.tap(findTestObject('null'), 0)

    'Tick Checkbox Login ScreenShot'
    Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid/XL Store/102 Purchase Package - Validate Tab Store Main Package XCM/3 Check Box screenshot.png')
} else {
    'Verify Checkbox Login'
    Mobile.verifyElementVisible(findTestObject('null'), 0)

    'Tick Checkbox Login'
    Mobile.tap(findTestObject('null'), 0)

    'Tick Checkbox Login ScreenShot'
    Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid/XL Store/102 Purchase Package - Validate Tab Store Main Package XCM/3 Check Box screenshot.png')
}

'Click Sign in to myXL Button'
Mobile.tap(findTestObject('null'), 0)

'Click Sign in to myXL Button ScreenShot'
Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid/XL Store/102 Purchase Package - Validate Tab Store Main Package XCM/4 Sign in to myXL screenshot.png')

'Click XL Prepaid Segment Button'
Mobile.tap(findTestObject('null'), 0)

'Click XL Prepaid Segment Button ScreenShot'
Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid/XL Store/102 Purchase Package - Validate Tab Store Main Package XCM/5 XL Prepaid Segment screenshot.png')

'Input XL MSISDN'
Mobile.setText(findTestObject('null'), '6287884076185', 
    0)

'Input XL MSISDN ScreenShot'
Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid/XL Store/102 Purchase Package - Validate Tab Store Main Package XCM/6 Validate Login using Prepaid MSISDN.png')

'Click Continue Button - Login'
Mobile.tap(findTestObject('null'), 0)

'Input OTP'
Mobile.setText(findTestObject('null'), '190160', 0)

'Input OTP ScreenShot'
Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid/XL Store/102 Purchase Package - Validate Tab Store Main Package XCM/7 OTP Input screenshot.png')

'Verify Medalia'
if (Mobile.verifyElementExist(findTestObject('null'), 0, FailureHandling.OPTIONAL)) {
    'Verify Medalia ScreenShot'
    Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid/XL Store/102 Purchase Package - Validate Tab Store Main Package XCM/8 Validate Medalia Dashboard.png')

    'Close Medalia'
    Mobile.tap(findTestObject('null'), 0)
} else {
    'Verify Dashboard'
    Mobile.verifyElementVisible(findTestObject('null'), 0)

    'Dashboard ScreenShot'
    Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid/XL Store/102 Purchase Package - Validate Tab Store Main Package XCM/9 Validate Dashboard.png')
}

'Click XL Store Landing'
Mobile.tap(findTestObject('null'), 0)

Mobile.delay(5)

'Click XL Store Landing ScreenShot'
Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid/XL Store/102 Purchase Package - Validate Tab Store Main Package XCM/10 XL Store Landing.png')

'Main Package'
Mobile.tap(findTestObject('null'), 0)

Mobile.delay(5)

'PFP'
Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid/XL Store/102 Purchase Package - Validate Tab Store Main Package XCM/11 PFP.png')

'Click XCM Package'
Mobile.tap(findTestObject('null'), 0)

Mobile.scrollToText('2GB')

Mobile.waitForElementPresent(findTestObject('null'), 0)

'PLP'
Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid/XL Store/102 Purchase Package - Validate Tab Store Main Package XCM/12 PLP.png')

'Click XCM 2GB Package'
Mobile.tap(findTestObject('null'), 0)

Mobile.waitForElementPresent(findTestObject('null'), 0)

'PDP'
Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid/XL Store/102 Purchase Package - Validate Tab Store Main Package XCM/13 Youtube 1GB PDP.png')

'Click Activate'
Mobile.tap(findTestObject('null'), 0)

Mobile.waitForElementPresent(findTestObject('null'), 0)

Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid/XL Store/102 Purchase Package - Validate Tab Store Main Package XCM/14 Payment Confirmation.png')

Mobile.closeApplication()

