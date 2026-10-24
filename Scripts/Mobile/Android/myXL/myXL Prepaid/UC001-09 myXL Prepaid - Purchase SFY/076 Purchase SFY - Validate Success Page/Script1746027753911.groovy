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
Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid/Purchase SFY/76 Purchase SFY - Validate Success Page/1 Splash Screen.png')

Mobile.delay(10, FailureHandling.CONTINUE_ON_FAILURE)

'Verify CVP'
if (Mobile.waitForElementPresent(findTestObject('null'), 0) == true) {
    'CVP Screenshot'
    Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid/Purchase SFY/76 Purchase SFY - Validate Success Page/2 Lets Start Button screenshot.png')

    'Click Continue on CVP'
    Mobile.tap(findTestObject('null'), 0)

    'Verify Checkbox Login'
    Mobile.verifyElementVisible(findTestObject('null'), 0)

    'Tick Checkbox Login'
    Mobile.tap(findTestObject('null'), 0)

    'Tick Checkbox Login ScreenShot'
    Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid/Purchase SFY/76 Purchase SFY - Validate Success Page/3 Check Box screenshot.png')
} else {
    'Verify Checkbox Login'
    Mobile.verifyElementVisible(findTestObject('null'), 0)

    'Tick Checkbox Login'
    Mobile.tap(findTestObject('null'), 0)

    'Tick Checkbox Login ScreenShot'
    Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid/Purchase SFY/76 Purchase SFY - Validate Success Page/3 Check Box screenshot.png')
}

'Click Sign in to myXL Button'
Mobile.tap(findTestObject('null'), 0)

'Click Sign in to myXL Button ScreenShot'
Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid/Purchase SFY/76 Purchase SFY - Validate Success Page/4 Sign in to myXL screenshot.png')

'Click XL Prepaid Segment Button'
Mobile.tap(findTestObject('null'), 0)

'Click XL Prepaid Segment Button ScreenShot'
Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid/Purchase SFY/76 Purchase SFY - Validate Success Page/5 XL Prepaid Segment screenshot.png')

'Input XL MSISDN'
Mobile.setText(findTestObject('null'), '6287883021778', 
    0)

'Input XL MSISDN ScreenShot'
Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid/Purchase SFY/76 Purchase SFY - Validate Success Page/6 Validate Login using Prepaid MSISDN.png')

'Click Continue Button - Login'
Mobile.tap(findTestObject('null'), 0)

'Input OTP'
Mobile.setText(findTestObject('null'), '190160', 0)

'Input OTP ScreenShot'
Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid/Purchase SFY/76 Purchase SFY - Validate Success Page/7 OTP Input screenshot.png')

'Verify Medalia'
if (Mobile.verifyElementExist(findTestObject('null'), 0, FailureHandling.OPTIONAL)) {
    'Verify Medalia ScreenShot'
    Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid/Purchase SFY/76 Purchase SFY - Validate Success Page/8 Validate Medalia Dashboard.png')

    'Close Medalia'
    Mobile.tap(findTestObject('null'), 0)
} else {
    'Verify Dashboard'
    Mobile.verifyElementVisible(findTestObject('null'), 0)

    'Dashboard ScreenShot'
    Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid/Purchase SFY/76 Purchase SFY - Validate Success Page/9 Validate Dashboard.png')
}

'VerifyBalance'
Mobile.verifyElementVisible(findTestObject('null'), 
    0)

Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid/Purchase SFY/76 Purchase SFY - Validate Success Page/10 Validate Balance.png')

//Mobile.scrollToText('+1.267 XL Poin')
//
//Mobile.swipe(904, 654, 368, 654)
//
//Mobile.delay(2)
//
//Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid/Purchase SFY/74 Purchase SFY - Validate SFY Showing/11 Purchase SFY - SFY Card.png')
//
//Mobile.tap(findTestObject('null'), 0)
//
//Mobile.waitForElementPresent(findTestObject('Object Repository/myXL Prepaid - SFY/Purchase SFY - Click Special bonus'), 0)
//
//Mobile.tap(findTestObject('Object Repository/myXL Prepaid - SFY/Purchase SFY - Click Special bonus'), 0)
//
//Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid/Purchase SFY/74 Purchase SFY - Validate SFY Showing/12 PDP.png')
//
//Mobile.waitForElementPresent(findTestObject('null'), 0)
'XL Store Navigate'
Mobile.tap(findTestObject('null'), 0)

Mobile.delay(5)

Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid/Purchase SFY/76 Purchase SFY - Validate Success Page/11 XL Store Landing.png')

'SFY button'
Mobile.tap(findTestObject('null'), 0)

Mobile.delay(3)

Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid/Purchase SFY/Purchase SFY/76 Purchase SFY - Validate Success Page/12 SFY.png')

'Click XCM Mini card'
Mobile.tap(findTestObject('null'), 0)

Mobile.waitForElementPresent(findTestObject('null'), 0)

Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid/Purchase SFY/Purchase SFY/75 Purchase SFY - Validate Purchase SFY using balance/13 SFY PDP.png')

'Click Activate XCM Mini card'
Mobile.tap(findTestObject('null'), 0)

Mobile.delay(5)

'/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid/Purchase SFY/Purchase SFY/75 Purchase SFY - Validate Purchase SFY using balance/14 Payment Confirmation.png'

'Click Pay XCM Mini card'
Mobile.tap(findTestObject('null'), 0)

Mobile.delay(120)

Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid/Purchase SFY/Purchase SFY/75 Purchase SFY - Validate Purchase SFY using balance/15 Success.png')

Mobile.closeApplication()

