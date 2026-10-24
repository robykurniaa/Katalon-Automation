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
Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prioritas Upfront/Onboarding/190 Login - Validate Login using Brand Porta MSISDN/1 Splash Screen.png')

Mobile.delay(10, FailureHandling.CONTINUE_ON_FAILURE)

'Verify CVP'
if (Mobile.waitForElementPresent(findTestObject('null'), 0) == true)
	
	{
	
'CVP Screenshot'
Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prioritas Upfront/Onboarding/190 Login - Validate Login using Brand Porta MSISDN/2 Lets Start Button screenshot.png')
	
'Click Continue on CVP'
Mobile.tap(findTestObject('null'), 0)

'Verify Checkbox Login'
Mobile.verifyElementVisible(findTestObject('null'), 0)

'Tick Checkbox Login'
Mobile.tap(findTestObject('null'), 0)

'Tick Checkbox Login ScreenShot'
Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prioritas Upfront/Onboarding/190 Login - Validate Login using Brand Porta MSISDN/3 Check Box screenshot.png')
	
	} else {
		
'Verify Checkbox Login'
Mobile.verifyElementVisible(findTestObject('null'), 0)

'Tick Checkbox Login'
Mobile.tap(findTestObject('null'), 0)

'Tick Checkbox Login ScreenShot'
Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prioritas Upfront/Onboarding/190 Login - Validate Login using Brand Porta MSISDN/3 Check Box screenshot.png')
	}
	
'Click Sign in to myXL Button'
Mobile.tap(findTestObject('null'), 0)

'Click Sign in to myXL Button ScreenShot'
Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prioritas Upfront/Onboarding/190 Login - Validate Login using Brand Porta MSISDN/4 Sign in to myXL screenshot.png')

'Click XL Prioritas Segment Button'
Mobile.tap(findTestObject('null'), 0)

'Click XL Prioritas Segment Button ScreenShot'
Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prioritas Upfront/Onboarding/190 Login - Validate Login using Brand Porta MSISDN/5 XL Prio Upfront Segment screenshot.png')

'Input Brand Porta MSISDN'
Mobile.setText(findTestObject('null'), '6283869516475', 0)

'Input Brand Porta MSISDN ScreenShot'
Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prioritas Upfront/Onboarding/190 Login - Validate Login using Brand Porta MSISDN/6 Validate Login using Brand Porta MSISDN.png')

'Click Continue Button - Login'
Mobile.tap(findTestObject('null'), 0)

'Click Continue Login with XL Prepaid'
Mobile.tap(findTestObject('null'), 0)

'Input OTP'
Mobile.setText(findTestObject('null'), 'PCX160', 0)

'Input OTP ScreenShot'
Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prioritas Upfront/Onboarding/190 Login - Validate Login using Brand Porta MSISDN/7 OTP Input screenshot.png')

'Verify Medalia'
if (Mobile.verifyElementExist(findTestObject('null'), 0, FailureHandling.OPTIONAL))
	
//	Medalia == Mobile.getText(findTestObject('null'),0))
		
	{
	
'Verify Medalia ScreenShot'
Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prioritas Upfront/Onboarding/190 Login - Validate Login using Brand Porta MSISDN/8 Validate Medalia Dashboard.png')
		
'Close Medalia'
	Mobile.tap(findTestObject('null'),0)
	
	
	}else {

'Verify Dashboard'
Mobile.verifyElementVisible(findTestObject('null'), 0)	

'Dashboard ScreenShot'
Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prioritas Upfront/Onboarding/190 Login - Validate Login using Brand Porta MSISDN/9 Validate Dashboard.png')
	}

Mobile.delay(2)
	
Mobile.closeApplication()