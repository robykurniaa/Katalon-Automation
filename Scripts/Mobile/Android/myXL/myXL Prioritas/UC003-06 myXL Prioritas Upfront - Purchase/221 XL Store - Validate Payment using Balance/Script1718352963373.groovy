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
Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prioritas Upfront/Purchase Package/221 XL Store - Validate Payment using Balance/1 Splash Screen.png')

Mobile.delay(10, FailureHandling.CONTINUE_ON_FAILURE)

'Verify CVP'
if (Mobile.waitForElementPresent(findTestObject('null'), 0) == true) {
    'CVP Screenshot'
    Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prioritas Upfront/Purchase Package/221 XL Store - Validate Payment using Balance/2 Lets Start Button screenshot.png')

    'Click Continue on CVP'
    Mobile.tap(findTestObject('null'), 0)

    'Verify Checkbox Login'
    Mobile.verifyElementVisible(findTestObject('null'), 0)

    'Tick Checkbox Login'
    Mobile.tap(findTestObject('null'), 0)

    'Tick Checkbox Login ScreenShot'
    Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prioritas Upfront/Purchase Package/221 XL Store - Validate Payment using Balance/3 Check Box screenshot.png')
} else {
    'Verify Checkbox Login'
    Mobile.verifyElementVisible(findTestObject('null'), 0)

    'Tick Checkbox Login'
    Mobile.tap(findTestObject('null'), 0)

    'Tick Checkbox Login ScreenShot'
    Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prioritas Upfront/Purchase Package/221 XL Store - Validate Payment using Balance/3 Check Box screenshot.png')
}

'Click Sign in to myXL Button'
Mobile.tap(findTestObject('null'), 0)

'Click Sign in to myXL Button ScreenShot'
Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prioritas Upfront/Purchase Package/221 XL Store - Validate Payment using Balance/4 Sign in to myXL screenshot.png')

'Click XL Prioritas Segment Button'
Mobile.tap(findTestObject('null'), 0)

'Click XL Prioritas Segment Button ScreenShot'
Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prioritas Upfront/Purchase Package/221 XL Store - Validate Payment using Balance/5 XL Prio Upfront Segment screenshot.png')

'Input XL MSISDN'
Mobile.setText(findTestObject('null'), '628175474347', 
    0)

'Input XL MSISDN ScreenShot'
Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prioritas Upfront/Purchase Package/221 XL Store - Validate Payment using Balance/6 Validate Login using Upfront MSISDN.png')

'Click Continue Button - Login'
Mobile.tap(findTestObject('null'), 0)

'Input OTP'
Mobile.setText(findTestObject('null'), '190160', 0)

'Input OTP ScreenShot'
Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prioritas Upfront/Purchase Package/221 XL Store - Validate Payment using Balance/7 OTP Input screenshot.png')

'Verify Medalia'
if (Mobile.verifyElementExist(findTestObject('null'), 0, FailureHandling.OPTIONAL)) {
    'Verify Medalia ScreenShot'
    Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prioritas Upfront/Purchase Package/221 XL Store - Validate Payment using Balance/8 Validate Medalia Dashboard.png')

    'Close Medalia'
    Mobile.tap(findTestObject('null'), 0) //'Verify Dashboard'
    //Mobile.verifyElementVisible(findTestObject('null'), 0)	
} else {
    'Dashboard ScreenShot'
    Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prioritas Upfront/Purchase Package/221 XL Store - Validate Payment using Balance/9 Validate Dashboard.png')
}

Mobile.delay(2)

'Tap Quickmenu Booster Menu'
Mobile.tap(findTestObject('null'), 0)

Mobile.delay(5)

'Quickmenu Booster Menu ScreenShot'
Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prioritas Upfront/Purchase Package/221 XL Store - Validate Payment using Balance/10 Validate Quickmenu Booster Menu.png')

'Tap Entertainment'
Mobile.tap(findTestObject('null'), 0)

Mobile.scrollToText('2.5GB + Viu Premium')

'PLP ScreenShot'
Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prioritas Upfront/Purchase Package/221 XL Store - Validate Payment using Balance/11 Validate PLP Menu.png')

'Tap PDP'
Mobile.tap(findTestObject('null'), 0)

Mobile.delay(5)

'PDP Screenshot'
Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prioritas Upfront/Purchase Package/221 XL Store - Validate Payment using Balance/12 Validate PDP Menu.png')

'Tap Activate'
Mobile.tap(findTestObject('null'), 0)

//'Activate ScreenShot'
//Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prioritas Upfront/Purchase Package/221 XL Store - Validate Payment using Balance/13 Validate Activate.png')

Mobile.delay(2)

'Payment Confirmation ScreenShot'
Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prioritas Upfront/Purchase Package/221 XL Store - Validate Payment using Balance/14 Validate Payment Confirmation.png')

'Tap Pay'
Mobile.tap(findTestObject('null'), 0)

Mobile.delay(5)

'Pay ScreenShot'
Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prioritas Upfront/Purchase Package/222 XL Store - Validate Success Page/15 Validate Pay Button.png')

Mobile.closeApplication()