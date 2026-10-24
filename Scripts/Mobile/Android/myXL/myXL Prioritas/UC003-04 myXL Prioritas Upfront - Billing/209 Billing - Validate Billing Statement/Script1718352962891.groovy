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
Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prioritas Upfront/Billing/209 Billing - Validate Billing Statement/1 Splash Screen.png')

Mobile.delay(10, FailureHandling.CONTINUE_ON_FAILURE)

'Verify CVP'
if (Mobile.waitForElementPresent(findTestObject('null'), 0) == true) {
    'CVP Screenshot'
    Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prioritas Upfront/Billing/209 Billing - Validate Billing Statement/2 Lets Start Button screenshot.png')

    'Click Continue on CVP'
    Mobile.tap(findTestObject('null'), 0)

    'Verify Checkbox Login'
    Mobile.verifyElementVisible(findTestObject('null'), 0)

    'Tick Checkbox Login'
    Mobile.tap(findTestObject('null'), 0)

    'Tick Checkbox Login ScreenShot'
    Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prioritas Upfront/Billing/209 Billing - Validate Billing Statement/3 Check Box screenshot.png')
} else {
    'Verify Checkbox Login'
    Mobile.verifyElementVisible(findTestObject('null'), 0)

    'Tick Checkbox Login'
    Mobile.tap(findTestObject('null'), 0)

    'Tick Checkbox Login ScreenShot'
    Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prioritas Upfront/Billing/209 Billing - Validate Billing Statement/3 Check Box screenshot.png')
}

'Click Sign in to myXL Button'
Mobile.tap(findTestObject('null'), 0)

'Click Sign in to myXL Button ScreenShot'
Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prioritas Upfront/Billing/209 Billing - Validate Billing Statement/4 Sign in to myXL screenshot.png')

'Click XL Prioritas Segment Button'
Mobile.tap(findTestObject('null'), 0)

'Click XL Prioritas Segment Button ScreenShot'
Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prioritas Upfront/Billing/209 Billing - Validate Billing Statement/5 XL Prio Upfront Segment screenshot.png')

'Input XL MSISDN'
Mobile.setText(findTestObject('null'), '628175474347', 
    0)

'Input XL MSISDN ScreenShot'
Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prioritas Upfront/Billing/209 Billing - Validate Billing Statement/6 Validate Login using Upfront MSISDN.png')

'Click Continue Button - Login'
Mobile.tap(findTestObject('null'), 0)

'Input OTP'
Mobile.setText(findTestObject('null'), '190160', 0)

'Input OTP ScreenShot'
Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prioritas Upfront/Billing/209 Billing - Validate Billing Statement/7 OTP Input screenshot.png')

'Verify Medalia'
if (Mobile.verifyElementExist(findTestObject('null'), 0, FailureHandling.OPTIONAL)) {
    'Verify Medalia ScreenShot'
    Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prioritas Upfront/Billing/209 Billing - Validate Billing Statement/8 Validate Medalia Dashboard.png')

    'Close Medalia'
    Mobile.tap(findTestObject('null'), 0) //'Verify Dashboard'
    //Mobile.verifyElementVisible(findTestObject('null'), 0)	
} else {
    'Dashboard ScreenShot'
    Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prioritas Upfront/Billing/209 Billing - Validate Billing Statement/9 Validate Dashboard.png')
}

Mobile.delay(2)

'Tap Quickmenu Estatement'
Mobile.tap(findTestObject('null'), 0)

Mobile.delay(3)

'E-Statement Menu ScreenShot'
Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prioritas Upfront/Billing/209 Billing - Validate Billing Statement/10 Validate E-Statement Menu ScreenShot.png')

'Tap Trx History'
Mobile.tap(findTestObject('null'), 0)

Mobile.delay(3)

'Trx History Menu ScreenShot'
Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prioritas Upfront/Billing/209 Billing - Validate Billing Statement/11 Validate Trx History ScreenShot.png')

Mobile.pressBack()

'Tap View Previous E-Statements'
Mobile.tap(findTestObject('null'), 0)

Mobile.delay(3)

'View Previous E-Statements ScreenShot'
Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prioritas Upfront/Billing/209 Billing - Validate Billing Statement/12 Validate Billing ScreenShot.png')

'Tap Download Invoice'
Mobile.tap(findTestObject('null'), 0)

Mobile.delay(15)

'Download Invoice ScreenShot'
Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prioritas Upfront/Billing/209 Billing - Validate Billing Statement/13 Validate Download Invoice ScreenShot.png')

Mobile.closeApplication()

