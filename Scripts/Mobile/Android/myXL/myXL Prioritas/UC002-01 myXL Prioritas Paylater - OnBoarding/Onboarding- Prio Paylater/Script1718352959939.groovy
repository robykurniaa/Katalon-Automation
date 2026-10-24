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
Mobile.startApplication(GlobalVariable.Application, true)

'Splash Screen'
Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid/Share Package/47 Share Package - Validate Share Package/1 Splash Screen.png')

Mobile.delay(10, FailureHandling.CONTINUE_ON_FAILURE)

'Verify CVP'
if (Mobile.waitForElementPresent(findTestObject('null'), 0) == true)
	
	{
	
'CVP Screenshot'
Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid/Share Package/47 Share Package - Validate Share Package/2 Lets Start Button screenshot.png')
	
'Click Continue on CVP'
Mobile.tap(findTestObject('null'), 0)

'Verify Checkbox Login'
Mobile.verifyElementVisible(findTestObject('null'), 0)

'Tick Checkbox Login'
Mobile.tap(findTestObject('null'), 0)

'Tick Checkbox Login ScreenShot'
Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid/Share Package/47 Share Package - Validate Share Package/3 Check Box screenshot.png')
	
	} else {
		
'Verify Checkbox Login'
Mobile.verifyElementVisible(findTestObject('null'), 0)

'Tick Checkbox Login'
Mobile.tap(findTestObject('null'), 0)

'Tick Checkbox Login ScreenShot'
Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid/Share Package/47 Share Package - Validate Share Package/3 Check Box screenshot.png')
	}

'Click Sign in to myXL Button'
Mobile.tap(findTestObject('null'), 0)

'Click Sign in to myXL Button ScreenShot'
Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid/Share Package/47 Share Package - Validate Share Package/4 Sign in to myXL screenshot.png')

'Click XL Prioritas Segment Button'
Mobile.tap(findTestObject('null'), 0)

'Click XL Prioritas Segment Button ScreenShot'
Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prioritas Paylater/Onboarding/XL Prepaid Segment screenshot.png')

'Input Invalid MSISDN'
Mobile.setText(findTestObject('null'), '6281323454342', 0)

'Invalid MSISDN ScreenShot'
Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prioritas Paylater/Onboarding/Invalid MSISDN screenshot.png')

'Verify Invalid MSISDN'
Mobile.verifyElementText(findTestObject('null'), 'The number You entered is not an XL number')

Mobile.clearText(findTestObject('null'), 0)

Mobile.setText(findTestObject('null'), '6283805278034', 0)

Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prioritas Paylater/Onboarding/Axis MSISDN screenshot.png')

Mobile.tap(findTestObject('null'), 0)

Mobile.tap(findTestObject('null'), 0)

Mobile.clearText(findTestObject('null'), 0)

Mobile.setText(findTestObject('null'), '6285959458346', 0)

Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prioritas Paylater/Onboarding/Cancelled MSISDN screenshot.png')

Mobile.tap(findTestObject('null'), 0)

Mobile.tap(findTestObject('null'), 0)

Mobile.clearText(findTestObject('null'), 0)

Mobile.setText(findTestObject('null'), '6287884076185', 0)

Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prioritas Paylater/Onboarding/Brand Porta MSISDN screenshot.png')

Mobile.tap(findTestObject('null'), 0)

Mobile.tap(findTestObject('null'), 0)

Mobile.setText(findTestObject('null'), '123456', 0)

Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prioritas Paylater/Onboarding/OTP Input screenshot.png')

Mobile.tap(findTestObject('null'), 0)
	
Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prioritas Paylater/Onboarding/Profile Menu screenshot.png')
	
Mobile.scrollToText('Logout')
	
Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prioritas Paylater/Onboarding/Logout Menu screenshot.png')
	
Mobile.tap(findTestObject('null'), 0)
	
Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prioritas Paylater/Onboarding/Logout screenshot.png')
	
Mobile.tap(findTestObject('null'), 0)

Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid/Onboarding/Logout.png')

Mobile.tap(findTestObject('null'), 0)

Mobile.tap(findTestObject('null'), 0)

Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prioritas Paylater/Onboarding/Sign in to myXL screenshot.png')

Mobile.tap(findTestObject('null'), 0)

Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prioritas Paylater/Onboarding/XL Prepaid Segment screenshot.png')

Mobile.setText(findTestObject('null'), '6281703790381', 0)

Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prioritas Paylater/Onboarding/Valid MSISDN screenshot.png')

Mobile.tap(findTestObject('null'), 0)

Mobile.setText(findTestObject('null'), '111111', 0)

Mobile.verifyElementVisible(findTestObject('null'), 0)

Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prioritas Paylater/Onboarding/Invalid OTP screenshot.png')

Mobile.tap(findTestObject('null'), 0)

Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prioritas Paylater/Onboarding/Resend OTP screenshot.png')

Mobile.setText(findTestObject('null'), '123456', 0)

Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prioritas Paylater/Onboarding/OTP Input screenshot.png')

Mobile.waitForElementNotPresent(findTestObject, 0)

Mobile.tap(findTestObject('null'), 0)

Mobile.tap(findTestObject('null'), 0)

Mobile.tap(findTestObject('null'), 0)

Mobile.tap(findTestObject('null'), 0)

Mobile.tap(findTestObject('null'), 0)

Mobile.tap(findTestObject('null'), 0)

Mobile.tap(findTestObject('null'), 0)

Mobile.tap(findTestObject('null'), 0)

Mobile.tap(findTestObject('null'), 0)

Mobile.tap(findTestObject('null'), 0)

Mobile.tap(findTestObject('null'), 0)

Mobile.tap(findTestObject('null'), 0)

Mobile.tap(findTestObject('null'), 0)

Mobile.tap(findTestObject('null'), 0)

Mobile.tap(findTestObject('null'), 0)

Mobile.tap(findTestObject('null'), 0)

Mobile.tap(findTestObject('null'), 0)

Mobile.tap(findTestObject('null'), 0)

Mobile.tap(findTestObject('null'), 0)
	
Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prioritas Paylater/Onboarding/Profile Menu screenshot.png')
	
Mobile.scrollToText('Logout')
	
Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prioritas Paylater/Onboarding/Logout Menu screenshot.png')
	
Mobile.tap(findTestObject('null'), 0)
	
Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prioritas Paylater/Onboarding/Logout screenshot.png')
	
Mobile.closeApplication()
