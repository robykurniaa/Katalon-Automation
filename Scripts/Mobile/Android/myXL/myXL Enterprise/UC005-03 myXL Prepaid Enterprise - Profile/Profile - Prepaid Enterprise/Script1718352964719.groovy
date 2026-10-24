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

Mobile.startApplication('/Users/rizqimerdeka/Downloads/com.apps.MyXL-5.8.8-production-debug (2).apk', true)

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

if (Mobile.verifyElementVisible(findTestObject('null'),0) == true )
	
	{
	
	Mobile.tap(findTestObject('null'),0)
	
	}else {
		
		Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid/Onboarding/Dashboard.png')
	}

Mobile.scrollToText('View Membership')

Mobile.tap(findTestObject('null'), 0)

Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid Enterprise/Profile/Profile menu.png')

Mobile.tap(findTestObject('Object Repository/myXL - Profile/Account Info'), 0)

Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid Enterprise/Profile/Account Info.png')

Mobile.tap(findTestObject('null'), 0)

Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid Enterprise/Profile/Edit Account Info.png')

Mobile.clearText(findTestObject('null'), 0)

Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid Enterprise/Profile/Edit Information.png')

Mobile.setText(findTestObject('null'), 'Tes Automation', 0)

Mobile.clearText(findTestObject('null'), 0)

Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid Enterprise/Profile/Edit Information.png')

Mobile.setText(findTestObject('null'), 'Testing', 0)

Mobile.verifyElementText(findTestObject('null'), 'Please use valid email')

Mobile.clearText(findTestObject('null'), 0)

Mobile.setText(findTestObject('null'), 'Testingbigbang@gmail.com', 0)

Mobile.tap(findTestObject('null'), 0)

Mobile.pressBack()

Mobile.tap(findTestObject('null'), 5)

Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid Enterprise/Profile/Trx History.png')

Mobile.tap(findTestObject('null'), 0)

Mobile.tap(findTestObject('null'), 5)

Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid Enterprise/Profile/Balance Control.png')

//if (Mobile.verifyElementVisible(findTestObject('null'), 0) == true )
//	
//	{
//	
//	Mobile.tap(findTestObject('null'), 0)
//		
//	Mobile.tap(findTestObject('null'), 5)
//	
//	Mobile.tap(findTestObject('null'), 0)
//	
//	Mobile.tap(findTestObject('null'), 0)
//	
//	Mobile.pressBack()
//	
//	} else {
//		
//		Mobile.tap(findTestObject('null'), 0)
//	}
	
	
Mobile.tap(findTestObject('null'), 0)
	
Mobile.tap(findTestObject('null'), 0)

Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid Enterprise/Profile/Activate Button - Balance Control.png')

Mobile.tap(findTestObject('null'), 0)

Mobile.tap(findTestObject('null'), 0)

Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid Enterprise/Profile/Disable Button - Balance Control.png')

Mobile.tap(findTestObject('null'), 0)

Mobile.tap(findTestObject('null'), 0)

Mobile.tap(findTestObject('null'), 0)

Mobile.tap(findTestObject('null'), 0)
	
Mobile.tap(findTestObject('null'), 0)

Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid Enterprise/Profile/PulsaLater.png')

Mobile.tap(findTestObject('null'), 0)

Mobile.delay(3)

Mobile.tap(findTestObject('null'), 0)

Mobile.tap(findTestObject('null'), 0)

Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid Enterprise/Profile/Top Up - 25.000.png')

Mobile.tap(findTestObject('null'), 0)

Mobile.scrollToText('Kredivo')

Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid Enterprise/Profile/Payment Confirmation.png')

Mobile.tap(findTestObject('null'), 0)

Mobile.tap(findTestObject('null'), 0)

Mobile.tap(findTestObject('null'), 0)

Mobile.tap(findTestObject('null'), 0)

Mobile.tap(findTestObject('null'), 0)

Mobile.tap(findTestObject('null'), 0)

Mobile.tap(findTestObject('null'), 0)

Mobile.setText(findTestObject('null'), '8962116638410958236', 0)

Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid Enterprise/Profile/PUK Code.png')

Mobile.tap(findTestObject('null'), 0)

Mobile.tap(findTestObject('null'), 0)

Mobile.pressBack()

Mobile.tap(findTestObject('null'), 0)

Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid Enterprise/Profile/myXL Wallet.png')

Mobile.scrollToText('DANA')

Mobile.pressBack()

Mobile.tap(findTestObject('null'), 0)

Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid Enterprise/Profile/Roaming Service.png')

Mobile.tap(findTestObject('null'), 0)

Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid Enterprise/Profile/Check Destination Country.png')

Mobile.setText(findTestObject('null'), 'Afghanistan', 0)

Mobile.tap(findTestObject('null'), 0)

Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid Enterprise/Profile/Afghanistan.png')

Mobile.tap(findTestObject('null'), 0)

Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid Enterprise/Profile/View Indonesian Embassy Info.png')

Mobile.tap(findTestObject('null'), 0)

Mobile.tap(findTestObject('null'), 0)

Mobile.scrollToText('Internet Umroh Plus 5GB')

Mobile.pressBack()

Mobile.tap(findTestObject('null'), 0)

Mobile.tap(findTestObject('null'), 0)

Mobile.scrollToText('SMS')

Mobile.pressBack()

Mobile.clearText(findTestObject('null'), 0)

Mobile.pressBack()

Mobile.pressBack()

Mobile.scrollToText('Referral')

Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid Enterprise/Profile/Referral menu.png')

Mobile.tap(findTestObject('null'), 0)

Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid Enterprise/Profile/Referral Detail.png')

Mobile.pressBack()

Mobile.tap(findTestObject('null'), 0)

Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid Enterprise/Profile/Language.png')

Mobile.tap(findTestObject('null'), 0)

Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid Enterprise/Profile/Lang - Bahasa.png')

Mobile.tap(findTestObject('null'), 0)

Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid Enterprise/Profile/Lang - Save.png')

Mobile.tap(findTestObject('null'), 0)

Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid Enterprise/Profile/Lang - Yes.png')

Mobile.tap(findTestObject('null'), 0)

Mobile.scrollToText('Bahasa')

Mobile.tap(findTestObject('null'), 0)

Mobile.tap(findTestObject('null'), 0)

Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid Enterprise/Profile/Lang - Eng.png')

Mobile.tap(findTestObject('null'), 0)

Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid Enterprise/Profile/Lang - Save.png')

Mobile.tap(findTestObject('null'), 0)

Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid Enterprise/Profile/Lang - Yes.png')
