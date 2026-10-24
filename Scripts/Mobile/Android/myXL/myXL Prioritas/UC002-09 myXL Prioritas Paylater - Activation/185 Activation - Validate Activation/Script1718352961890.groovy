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
Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prioritas Paylater/Dashboard/141 Dashboard - Validate PPS Balance, Flex Balance, Credit Limit/1 Splash Screen.png')

Mobile.delay(10, FailureHandling.CONTINUE_ON_FAILURE)

'Verify CVP'
if (Mobile.waitForElementPresent(findTestObject('null'), 0) == true)
	
	{
	
'CVP Screenshot'
Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prioritas Paylater/Dashboard/141 Dashboard - Validate PPS Balance, Flex Balance, Credit Limit/2 Lets Start Button screenshot.png')
	
'Click Continue on CVP'
Mobile.tap(findTestObject('null'), 0)

'Verify Checkbox Login'
Mobile.verifyElementVisible(findTestObject('null'), 0)

'Tick Checkbox Login'
Mobile.tap(findTestObject('null'), 0)

'Tick Checkbox Login ScreenShot'
Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prioritas Paylater/Dashboard/141 Dashboard - Validate PPS Balance, Flex Balance, Credit Limit/3 Check Box screenshot.png')
	
	} else {
		
'Verify Checkbox Login'
Mobile.verifyElementVisible(findTestObject('null'), 0)

'Tick Checkbox Login'
Mobile.tap(findTestObject('null'), 0)

'Tick Checkbox Login ScreenShot'
Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prioritas Paylater/Dashboard/141 Dashboard - Validate PPS Balance, Flex Balance, Credit Limit/3 Check Box screenshot.png')
	}
	
'Click Sign in to myXL Button'
Mobile.tap(findTestObject('null'), 0)

'Click Sign in to myXL Button ScreenShot'
Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prioritas Paylater/Dashboard/141 Dashboard - Validate PPS Balance, Flex Balance, Credit Limit/4 Sign in to myXL screenshot.png')

'Click XL Prioritas Segment Button'
Mobile.tap(findTestObject('null'), 0)

'Click XL Prioritas Segment Button ScreenShot'
Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prioritas Paylater/Dashboard/141 Dashboard - Validate PPS Balance, Flex Balance, Credit Limit/5 XL Prio Paylater Segment screenshot.png')


'Input XL MSISDN'
Mobile.setText(findTestObject('null'), '087734910051', 0)

'Input XL MSISDN ScreenShot'
Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prioritas Paylater/Dashboard/141 Dashboard - Validate PPS Balance, Flex Balance, Credit Limit/6 Validate Login using Prepaid MSISDN.png')

'Click Continue Button - Login'
Mobile.tap(findTestObject('null'), 0)

'Input Valid OTP'
Mobile.setText(findTestObject('null'), '123456', 0)

'Input OTP ScreenShot'
Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prioritas Paylater/Dashboard/141 Dashboard - Validate PPS Balance, Flex Balance, Credit Limit/7 OTP Input screenshot.png')

//def Medalia = 'Mohon luangkan 1 menit'

'Close Coachmark 1'
Mobile.tap(findTestObject('null'), 0)
Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prioritas Paylater/Dashboard/141 Dashboard - Validate PPS Balance, Flex Balance, Credit Limit/8 Click X Coachmark.png')

'Click Ok Intersitial'
Mobile.tap(findTestObject('null'), 0)
Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prioritas Paylater/Dashboard/141 Dashboard - Validate PPS Balance, Flex Balance, Credit Limit/9 Click Ok Intersitial.png')

'Close Coachmark 2'
Mobile.tap(findTestObject('null'), 0)
Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prioritas Paylater/Dashboard/141 Dashboard - Validate PPS Balance, Flex Balance, Credit Limit/10 Click X Coachmark 2.png')

'Close Coachmark 3'
Mobile.tap(findTestObject('null'), 0)
Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prioritas Paylater/Dashboard/141 Dashboard - Validate PPS Balance, Flex Balance, Credit Limit/11 Click X Coachmark 3.png')

'Click X Birthday'
Mobile.tap(findTestObject('null'), 0)
Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prioritas Paylater/Dashboard/141 Dashboard - Validate PPS Balance, Flex Balance, Credit Limit/12 Click X Birthday.png')

'Click Exit Birthday'
Mobile.tap(findTestObject('null'), 0)
Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prioritas Paylater/Dashboard/141 Dashboard - Validate PPS Balance, Flex Balance, Credit Limit/13 Exit Button.png')

Mobile.delay(2)

'Verify Medalia'
if (Mobile.verifyElementExist(findTestObject('null'), 0, FailureHandling.OPTIONAL))

//	Medalia == Mobile.getText(findTestObject('null'),0))

	{

'Verify Medalia ScreenShot'
Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prioritas Paylater/Dashboard/141 Dashboard - Validate PPS Balance, Flex Balance, Credit Limit/14 Validate Medalia Dashboard.png')

'Close Medalia'
	Mobile.tap(findTestObject('null'),0)

	}else {

'Validate Billing Present'
Mobile.verifyElementVisible(findTestObject('null'), 0)

'Dashboard ScreenShot'
Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prioritas Paylater/Dashboard/141 Dashboard - Validate PPS Balance, Flex Balance, Credit Limit/15 Validate Dashboard.png')
	}

Mobile.scrollToText('View Balance Feature')

'Verify PPS Balance'
Mobile.verifyElementVisible(findTestObject('null'), 0)

'Verify Flex'
Mobile.verifyElementVisible(findTestObject('null'), 0)

'Verify CL'
Mobile.verifyElementVisible(findTestObject('null'), 0)

Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prioritas Paylater/Dashboard/141 Dashboard - Validate PPS Balance, Flex Balance, Credit Limit/16 Validate PPS Balance, Flex Balance, Credit Limit.png')

Mobile.delay(5)
Mobile.closeApplication()