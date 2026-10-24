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

Mobile.startApplication(GlobalVariable.APK, true)

Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/Login, Store, Logout/1 Splash Screen.png')

'Verify CVP'
if (Mobile.waitForElementPresent(findTestObject('null'), 0) == true) {
    'CVP Screenshot'
	Mobile.takeScreenshot()

    'Click Continue on CVP'
    Mobile.tap(findTestObject('null'), 0)

    'Verify Checkbox Login'
    Mobile.verifyElementVisible(findTestObject('null'), 0)

    'Tick Checkbox Login'
    Mobile.tap(findTestObject('null'), 0)

    'Tick Checkbox Login ScreenShot'
    Mobile.takeScreenshot()
} else {
    'Verify Checkbox Login'
    Mobile.verifyElementVisible(findTestObject('null'), 0)

    'Tick Checkbox Login'
    Mobile.tap(findTestObject('null'), 0)

    'Tick Checkbox Login ScreenShot'
    Mobile.takeScreenshot()
}

/*'Tick Checkbox Login'
Mobile.tap(findTestObject('Object Repository/myXL - Login and Logout/Checkbox - Login'), 0)
Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/Login, Store, Logout/3 Check Box screenshot.png')
*/
'Click Sign in to myXL Button'
Mobile.tap(findTestObject('Object Repository/myXL - Login and Logout/Sign in to myXL Button - Login'), 0)
Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/Login, Store, Logout/4 Sign in to myXL screenshot.png')

'Click XL Prepaid Segment Button'
Mobile.tap(findTestObject('Object Repository/myXL - Login and Logout/XL Prepaid Segment Button - Login'), 0)
Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/Login, Store, Logout/5 XL Prepaid Segment screenshot.png')

'Input XL MSISDN'
Mobile.setText(findTestObject('Object Repository/myXL - Login and Logout/XL Prepaid Number Editable - Login'), '6287884076185', 0)
Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/Login, Store, Logout/6 Valid MSISDN screenshot.png')
Mobile.tap(findTestObject('Object Repository/myXL - Login and Logout/Continue Button - Login'), 0)

'Input Valid OTP'
Mobile.setText(findTestObject('Object Repository/myXL - Login and Logout/OTP Editable'), '190160', 0)
Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/Login, Store, Logout/7 Validate Valid OTP.png')

'Medalia'
if (Mobile.verifyElementVisible(findTestObject('Object Repository/myXL - Login and Logout/Medalia - Dashboard'),0) == true )
	
	{
	
	Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/Login, Store, Logout/8 Validate Medalia Dashboard.png')
		
	Mobile.tap(findTestObject('Object Repository/myXL - Login and Logout/Medalia - Dashboard'),0)
	
	
	}else {
		
'Dashboard'
		Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/Login, Store, Logout/9 Validate Dashboard.png')
	}

Mobile.delay(2)
	
Mobile.scrollToText('XL Poin')

Mobile.tap(findTestObject('null'), 0)

Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/Login, Store, Logout/10 XL Store Landing.png')

Mobile.tap(findTestObject('null'), 0)

Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/Login, Store, Logout/11 Main Package Button.png')

Mobile.tap(findTestObject('null'), 0)

Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/Login, Store, Logout/12 PFP Button - Star Project.png')

Mobile.tap(findTestObject('null'), 0)

Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/Login, Store, Logout/13 Yasmin Glam 7GB Card.png')

//Mobile.swipe(0, 1574, 137, 1559, FailureHandling.CONTINUE_ON_FAILURE)

//Mobile.tap(findTestObject('null'), 0)

Mobile.scrollToText('Terms & Condition')

Mobile.tap(findTestObject('null'), 0)

Mobile.tap(findTestObject('null'), 0)

Mobile.tap(findTestObject('null'), 0)

Mobile.tap(findTestObject('null'), 0)

Mobile.tap(findTestObject('Object Repository/myXL - XL Store - Star Project - Prepaid/Terms Condition PDP'), 0)

Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/Login, Store, Logout/14 Terms Condition PDP.png')

Mobile.tap(findTestObject('null'), 0)

Mobile.tap(findTestObject('null'), 0)

Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/Login, Store, Logout/15 Activate Button PDP.png')

Mobile.scrollToText('BRI Direct Debit')

Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/Login, Store, Logout/16 BRI Direct Debit Payment Method.png')

Mobile.tap(findTestObject('null'), 0)

Mobile.tap(findTestObject('null'), 1)

Mobile.tap(findTestObject('null'), 1)

Mobile.tap(findTestObject('null'), 1)

'Profile Menu'
Mobile.tap(findTestObject('Object Repository/myXL - Login and Logout/Profile Menu'), 0)
Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/Login, Store, Logout/17 Profile menu.png')

'Logout Menu'
Mobile.scrollToText('Logout')	
Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/Login, Store, Logout/18 Logout Menu screenshot.png')

'Logout Button'
Mobile.tap(findTestObject('Object Repository/myXL - Login and Logout/Logout Button'), 0)
Mobile.waitForElementPresent(findTestObject('Object Repository/myXL - Login, Store, Logout/Logout'), 0)
Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/Login, Store, Logout/19 Logout Option.png')

'Logout'
Mobile.tap(findTestObject('Object Repository/myXL - Login and Logout/Logout'), 0)
Mobile.delay(2)
Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/Login, Store, Logout/20 Logout Option.png')

Mobile.closeApplication()
