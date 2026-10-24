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

Mobile.delay(10)

Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid/Onboarding/Splash Screen.png')

Mobile.tap(findTestObject('null'), 0)

Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid/Onboarding/Lets Start Button screenshot.png')

Mobile.tap(findTestObject('null'), 0)

Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid/Onboarding/Check Box screenshot.png')

Mobile.tap(findTestObject('null'), 0)

Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid/Onboarding/Sign in to myXL screenshot.png')

Mobile.tap(findTestObject('null'), 0)

Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid/Onboarding/XL Prepaid Segment screenshot.png')

Mobile.setText(findTestObject('null'), '6281323454342', 0)

Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid/Onboarding/Invalid MSISDN screenshot.png')

Mobile.verifyElementVisible(findTestObject('null'), 0)

Mobile.clearText(findTestObject('null'), 0)

Mobile.setText(findTestObject('null'), '6283805278034', 0)

Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid/Onboarding/Axis MSISDN screenshot.png')

Mobile.tap(findTestObject('null'), 0)

Mobile.tap(findTestObject('null'), 0)

Mobile.clearText(findTestObject('null'), 0)

Mobile.setText(findTestObject('null'), '6285959458346', 0)

Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid/Onboarding/Cancelled MSISDN screenshot.png')

Mobile.tap(findTestObject('null'), 0)

Mobile.tap(findTestObject('null'), 0)

Mobile.clearText(findTestObject('null'), 0)

Mobile.setText(findTestObject('null'), '6283869516475', 0)

Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid/Onboarding/Brand Porta MSISDN screenshot.png')

Mobile.tap(findTestObject('null'), 0)

Mobile.setText(findTestObject('null'), '123456', 0)

Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid/Onboarding/OTP Input screenshot.png')

//Mobile.tap(findTestObject('null'), 0)

if (Mobile.verifyElementVisible(findTestObject('null'),0) == true )
	
	{
	
	Mobile.tap(findTestObject('null'),0)
	
	}else {
		
		Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid/Onboarding/Dashboard.png')
	}

//Mobile.tap(findTestObject('Object Repository/myXL - Login And Logout/Medalia Cross Button'), 0)

Mobile.tap(findTestObject('null'), 0)
	
Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid/Onboarding/Profile Menu screenshot.png')
	
Mobile.scrollToText('Logout')
	
Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid/Onboarding/Logout Menu screenshot.png')
	
Mobile.tap(findTestObject('null'), 0)
	
Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid/Onboarding/Logout screenshot.png')

Mobile.tap(findTestObject('null'), 0)

Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid/Onboarding/Logout.png')

Mobile.tap(findTestObject('null'), 0)

Mobile.tap(findTestObject('null'), 0)

Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid/Onboarding/Sign in to myXL screenshot.png')

Mobile.tap(findTestObject('null'), 0)

Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid/Onboarding/XL Prepaid Segment screenshot.png')

Mobile.setText(findTestObject('null'), '6287884076185', 0)

Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid/Onboarding/Valid MSISDN screenshot.png')

Mobile.tap(findTestObject('null'), 0)

Mobile.setText(findTestObject('null'), '111111', 0)

Mobile.verifyElementVisible(findTestObject('null'), 0)

Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid/Onboarding/Invalid OTP screenshot.png')

Mobile.waitForElementPresent(findTestObject('null'), 0)

Mobile.tap(findTestObject('null'), 0)

Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid/Onboarding/Resend OTP screenshot.png')

Mobile.setText(findTestObject('null'), '123456', 0)

Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid/Onboarding/OTP Input screenshot.png')

//Mobile.tap(findTestObject('null'), 0)

if (Mobile.verifyElementVisible(findTestObject('null'),0) == true )
	
	{
	
	Mobile.tap(findTestObject('null'),0)
	
	}else {
		
		Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid/Onboarding/Dashboard.png')
	}

//Mobile.tap(findTestObject('Object Repository/myXL - Login And Logout/Medalia Cross Button'), 0)

Mobile.tap(findTestObject('null'), 0)
	
Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid/Onboarding/Profile Menu screenshot.png')
	
Mobile.scrollToText('Logout')
	
Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid/Onboarding/Logout Menu screenshot.png')
	
Mobile.tap(findTestObject('null'), 0)
	
Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid/Onboarding/Logout screenshot.png')

Mobile.tap(findTestObject('null'), 0)

Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid/Onboarding/Logout opsi.png')
	
Mobile.closeApplication()