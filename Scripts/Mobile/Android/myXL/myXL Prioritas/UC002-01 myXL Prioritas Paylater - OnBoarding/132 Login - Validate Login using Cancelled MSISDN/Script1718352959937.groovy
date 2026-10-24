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

'Verify Choose Login Segment Page'
Mobile.waitForElementPresent(findTestObject('null'), 0)

'Screenshot Choose Login Segment Page'
Mobile.takeScreenshot()

'Click XL Prioritas Segment Button'
Mobile.tap(findTestObject('null'), 0)

'Verify Input Number Page'
Mobile.waitForElementPresent(findTestObject('null'), 0)

'Screenshot Input Number Page'
Mobile.takeScreenshot()

'Input Cancelled MSISDN'
Mobile.setText(findTestObject('null'), GlobalVariable.cancelNum, 0)

'Screenshot Success Input Cancelled MSISDN'
Mobile.takeScreenshot()

'Click Continue Button - Login'
Mobile.tap(findTestObject('null'), 0)

'Verify Error Message Cancelled MSISDN'
Mobile.waitForElementPresent(findTestObject('null'), 0)

'Screenshot Error Message Cancelled MSISDN'
Mobile.takeScreenshot()

'Close App'
Mobile.closeApplication()


/*
 * 'Open myXL' Mobile.startApplication(GlobalVariable.APK, true)
 * 
 * 'Splash Screen' Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi
 * Merdeka/Automation myXL/Screenshot/myXL Prioritas Paylater/Onboarding/132
 * Login - Validate Login using Cancelled MSISDN/1 Splash Screen.png')
 * 
 * Mobile.delay(10, FailureHandling.CONTINUE_ON_FAILURE)
 * 
 * 'Verify CVP' if (Mobile.waitForElementPresent(findTestObject('Object
 * Repository/myXL - Login And Logout/Lets Start Button'), 0) == true)
 * 
 * {
 * 
 * 'CVP Screenshot' Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi
 * Merdeka/Automation myXL/Screenshot/myXL Prioritas Paylater/Onboarding/132
 * Login - Validate Login using Cancelled MSISDN/2 Lets Start Button
 * screenshot.png')
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
 * myXL/Screenshot/myXL Prioritas Paylater/Onboarding/132 Login - Validate Login
 * using Cancelled MSISDN/3 Check Box screenshot.png')
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
 * myXL/Screenshot/myXL Prioritas Paylater/Onboarding/132 Login - Validate Login
 * using Cancelled MSISDN/3 Check Box screenshot.png') }
 * 
 * 'Click Sign in to myXL Button' Mobile.tap(findTestObject('Object
 * Repository/myXL - Login And Logout/Sign in to myXL Button - Login'), 0)
 * 
 * 'Click Sign in to myXL Button ScreenShot'
 * Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation
 * myXL/Screenshot/myXL Prioritas Paylater/Onboarding/132 Login - Validate Login
 * using Cancelled MSISDN/4 Sign in to myXL screenshot.png')
 * 
 * 'Click XL Prioritas Segment Button' Mobile.tap(findTestObject('Object
 * Repository/myXL - Login And Logout/XL PRIORITAS Segment Button - Login'), 0)
 * 
 * 'Click XL Prioritas Segment Button ScreenShot'
 * Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation
 * myXL/Screenshot/myXL Prioritas Paylater/Onboarding/132 Login - Validate Login
 * using Cancelled MSISDN/5 XL Prio Paylater Segment screenshot.png')
 * 
 * 'Input Cancelled MSISDN' Mobile.setText(findTestObject('Object
 * Repository/myXL - Login And Logout/XL Prio Number Editable - Login'),
 * '6285959458346', 0)
 * 
 * 'Click Continue Button - Login' Mobile.tap(findTestObject('Object
 * Repository/myXL - Login And Logout/Continue Button - Login'), 0)
 * 
 * 'Verify Login with Cancelled MSISDN'
 * Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation
 * myXL/Screenshot/myXL Prioritas Paylater/Onboarding/132 Login - Validate Login
 * using Cancelled MSISDN/6 Validate Login using Cancelled MSISDN.png')
 * 
 * Mobile.delay(2) Mobile.closeApplication()
 */