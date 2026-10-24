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
			
'Click Login to myXL Button'
Mobile.tap(findTestObject('null'), 0)

Mobile.takeScreenshot()

'Click Sign in to myXL Button'
Mobile.tap(findTestObject('null'), 0)

Mobile.takeScreenshot()

'Click XL Prioritas Segment Button'
Mobile.tap(findTestObject('null'), 0)

'Screenshot Choose Login Segment Page'
Mobile.takeScreenshot()

'Verify Input Number Page'
Mobile.waitForElementPresent(findTestObject('null'), 0)

'Screenshot Input Number Page'
Mobile.takeScreenshot()

'Input XL Prio Paylater MSISDN'
Mobile.setText(findTestObject('null'), GlobalVariable.prioPaylaterNum, 0)

'Screenshot Success Input XL Prio Paylater MSISDN'
Mobile.takeScreenshot()

'Click Continue Button - Login'
Mobile.tap(findTestObject('null'), 0)

'Waiting Countdown Enable Resend Button'
Mobile.waitForElementPresent(findTestObject('null'), 70)

'Click Resend OTP'
Mobile.tap(findTestObject('null'), 0)

'Screenshot Success Click Resend OTP'
Mobile.takeScreenshot()

'Close App'
Mobile.closeApplication()


/*
 * 'Open myXL' Mobile.startApplication(GlobalVariable.APK, true)
 * 
 * 'Splash Screen' Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi
 * Merdeka/Automation myXL/Screenshot/myXL Prioritas Paylater/Onboarding/135
 * Login - Validate Resend OTP/1 Splash Screen.png')
 * 
 * Mobile.delay(10, FailureHandling.CONTINUE_ON_FAILURE)
 * 
 * 'Verify CVP' if (Mobile.waitForElementPresent(findTestObject('Object
 * Repository/myXL - Login And Logout/Lets Start Button'), 0) == true)
 * 
 * {
 * 
 * 'CVP Screenshot' Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi
 * Merdeka/Automation myXL/Screenshot/myXL Prioritas Paylater/Onboarding/135
 * Login - Validate Resend OTP/2 Lets Start Button screenshot.png')
 * 
 * 'Click Continue on CVP' Mobile.tap(findTestObject('Object Repository/myXL -
 * Login And Logout/Lets Start Button'), 0)
 * 
 * 'Verify Checkbox Login' Mobile.verifyElementVisible(findTestObject('Object
 * Repository/myXL - Login And Logout/Checkbox - Login'), 0)
 * 
 * 'Tick Checkbox Login' Mobile.tap(findTestObject('Object Repository/myXL -
 * Login And Logout/Checkbox - Login'), 0)
 * 
 * 'Tick Checkbox Login ScreenShot'
 * Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation
 * myXL/Screenshot/myXL Prioritas Paylater/Onboarding/135 Login - Validate
 * Resend OTP/3 Check Box screenshot.png')
 * 
 * } else {
 * 
 * 'Verify Checkbox Login' Mobile.verifyElementVisible(findTestObject('Object
 * Repository/myXL - Login And Logout/Checkbox - Login'), 0)
 * 
 * 'Tick Checkbox Login' Mobile.tap(findTestObject('Object Repository/myXL -
 * Login And Logout/Checkbox - Login'), 0)
 * 
 * 'Tick Checkbox Login ScreenShot'
 * Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation
 * myXL/Screenshot/myXL Prioritas Paylater/Onboarding/135 Login - Validate
 * Resend OTP/3 Check Box screenshot.png') }
 * 
 * 'Click Sign in to myXL Button' Mobile.tap(findTestObject('Object
 * Repository/myXL - Login And Logout/Sign in to myXL Button - Login'), 0)
 * 
 * 'Click Sign in to myXL Button ScreenShot'
 * Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation
 * myXL/Screenshot/myXL Prioritas Paylater/Onboarding/135 Login - Validate
 * Resend OTP/4 Sign in to myXL screenshot.png')
 * 
 * 'Click XL Prioritas Segment Button' Mobile.tap(findTestObject('Object
 * Repository/myXL - Login And Logout/XL PRIORITAS Segment Button - Login'), 0)
 * 
 * 'Click XL Prioritas Segment Button ScreenShot'
 * Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation
 * myXL/Screenshot/myXL Prioritas Paylater/Onboarding/135 Login - Validate
 * Resend OTP/5 XL Prio Paylater Segment screenshot.png')
 * 
 * 'Input XL MSISDN' Mobile.setText(findTestObject('Object Repository/myXL -
 * Login And Logout/XL Prio Number Editable - Login'), '6281703790381', 0)
 * 
 * 'Input XL MSISDN ScreenShot'
 * Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation
 * myXL/Screenshot/myXL Prioritas Paylater/Onboarding/135 Login - Validate
 * Resend OTP/6 Validate Login using Prepaid MSISDN.png')
 * 
 * 'Click Continue Button - Login' Mobile.tap(findTestObject('Object
 * Repository/myXL - Login And Logout/Continue Button - Login'), 0)
 * 
 * 'Input Invalid OTP' Mobile.setText(findTestObject('Object Repository/myXL -
 * Login And Logout/OTP Editable'), '111111', 0)
 * 
 * //'Verify Invalid OTP' //Mobile.verifyElementVisible(findTestObject('Object
 * Repository/myXL - Login with Invalid OTP/OTP Invalid - Text'), 0)
 * 
 * 'Verify Invalid OTP ScreenShot'
 * Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation
 * myXL/Screenshot/myXL Prioritas Paylater/Onboarding/135 Login - Validate
 * Resend OTP/7 Validate Invalid OTP.png')
 * 
 * 'Waiting 60s' Mobile.waitForElementPresent(findTestObject('Object
 * Repository/myXL - Login with Invalid OTP/Resend OTP Button - Login'), 60)
 * 
 * 'Click Resend OTP' Mobile.tap(findTestObject('Object Repository/myXL - Login
 * with Invalid OTP/Resend OTP Button - Login'), 0)
 * 
 * 'Click Resend OTP ScreenShot'
 * Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation
 * myXL/Screenshot/myXL Prioritas Paylater/Onboarding/135 Login - Validate
 * Resend OTP/8 Validate Resend OTP.png')
 * 
 * Mobile.delay(2) Mobile.closeApplication()
 */