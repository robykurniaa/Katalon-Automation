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

Mobile.startApplication(GlobalVariable.Application, true)

Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid Enterprise/Onboarding/Splash Screen.png')

Mobile.tap(findTestObject('null'), 0)

Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid Enterprise/Onboarding/Lets Start Button screenshot.png')

Mobile.tap(findTestObject('null'), 0)

Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid Enterprise/Onboarding/Check Box screenshot.png')

Mobile.tap(findTestObject('null'), 0)

Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid Enterprise/Onboarding/Sign in to myXL screenshot.png')

Mobile.scrollToText('Business Solutions')

Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid Enterprise/Onboarding/Business Solutions Card screenshot.png')

Mobile.tap(findTestObject('null'), 10)

Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid Enterprise/Onboarding/XL Enterprise Segment screenshot.png')

Mobile.tap(findTestObject('null'), 0)

Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid Enterprise/Onboarding/XL Enterprise Number Segment screenshot.png')

Mobile.setText(findTestObject('null'), '6281323454342', 0)

Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid Enterprise/Onboarding/Invalid MSISDN screenshot.png')

Mobile.verifyElementText(findTestObject('null'), 'The number You entered is not an XL number')

Mobile.clearText(findTestObject('null'), 0)

Mobile.setText(findTestObject('null'), '6283805278034', 0)

Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid Enterprise/Onboarding/Axis MSISDN screenshot.png')

Mobile.tap(findTestObject('null'), 0)

Mobile.tap(findTestObject('null'), 0)

Mobile.clearText(findTestObject('null'), 0)

Mobile.setText(findTestObject('null'), '6285959458346', 0)

Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid Enterprise/Onboarding/Cancelled MSISDN screenshot.png')

Mobile.tap(findTestObject('null'), 0)

Mobile.tap(findTestObject('null'), 0)

Mobile.clearText(findTestObject('null'), 0)

Mobile.setText(findTestObject('null'), '6287884076185', 0)

Mobile.tap(findTestObject('null'), 0)

Mobile.tap(findTestObject('null'), 0)

Mobile.setText(findTestObject('null'), '123456', 0)

Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid Enterprise/Onboarding/OTP Input screenshot.png')

//if (Mobile.verifyElementVisible(findTestObject('null'),0) == true )
//	
//	{
//	
//	Mobile.tap(findTestObject('null'),0)
//	
//	}else {
//		
//		Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid/Onboarding/Dashboard.png')
//	}

Mobile.tap(findTestObject('null'), 0)
	
Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid Enterprise/Onboarding/Profile Menu screenshot.png')
	
Mobile.scrollToText('Logout')
	
Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid Enterprise/Onboarding/Logout Menu screenshot.png')
	
Mobile.tap(findTestObject('null'), 0)
	
Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid Enterprise/Onboarding/Logout screenshot.png')
	
Mobile.tap(findTestObject('null'), 0)

Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid/Onboarding/Logout.png')

Mobile.tap(findTestObject('null'), 0)

Mobile.tap(findTestObject('null'), 0)

Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid Enterprise/Onboarding/Sign in to myXL screenshot.png')

Mobile.scrollToText('Business Solutions')

Mobile.tap(findTestObject('null'), 0)

Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid Enterprise/Onboarding/XL Prepaid Segment screenshot.png')

Mobile.tap(findTestObject('null'), 5)

Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prioritas Enterprise/Onboarding/XL Enterprise Number Segment screenshot.png')

Mobile.setText(findTestObject('null'), '6281996532478', 0)

Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid Enterprise/Onboarding/Valid MSISDN screenshot.png')

Mobile.tap(findTestObject('null'), 0)

Mobile.setText(findTestObject('null'), '111111', 0)

Mobile.verifyElementVisible(findTestObject('null'), 0)

Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid Enterprise/Onboarding/Invalid OTP screenshot.png')

Mobile.tap(findTestObject('null'), 0)

Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid Enterprise/Onboarding/Resend OTP screenshot.png')

Mobile.setText(findTestObject('null'), '123456', 0)

Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid Enterprise/Onboarding/OTP Input screenshot.png')

//if (Mobile.verifyElementVisible(findTestObject('null'),0) == true )
//	
//	{
//	
//	Mobile.tap(findTestObject('null'),0)
//	
//	}else {
//		
//		Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid/Onboarding/Dashboard.png')
//	}

Mobile.tap(findTestObject('null'), 0)
	
Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid Enterprise/Onboarding/Profile Menu screenshot.png')
	
Mobile.scrollToText('Logout')
	
Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid Enterprise/Onboarding/Logout Menu screenshot.png')
	
Mobile.tap(findTestObject('null'), 0)
	
Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid Enterprise/Onboarding/Logout screenshot.png')
	
Mobile.closeApplication()
