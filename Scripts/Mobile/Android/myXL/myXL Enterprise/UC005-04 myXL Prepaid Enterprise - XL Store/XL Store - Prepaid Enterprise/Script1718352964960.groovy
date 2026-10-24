import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

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

Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid/XL Store/Open App screenshot.png')

Mobile.tap(findTestObject('null'), 0)

Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid/XL Store/Lets Start Button screenshot.png')

Mobile.tap(findTestObject('null'), 0)

Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid/XL Store/Check Box screenshot.png')

Mobile.tap(findTestObject('null'), 0)

Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/ScreenshotmyXL Prepaid/XL Store/Sign in to myXL screenshot.png')

Mobile.tap(findTestObject('null'), 5)

Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid/XL Store/XL Prepaid Segment screenshot.png')

Mobile.setText(findTestObject('null'), '6287884076185', 
    0)

Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid/XL Store/MSISDN Input screenshot.png')

Mobile.tap(findTestObject('null'), 0)

Mobile.setText(findTestObject('null'), '123456', 0)

Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid/XL Store/OTP Input screenshot.png')

if (Mobile.verifyElementVisible(findTestObject('null'),0) == true )
	
	{
	
	Mobile.tap(findTestObject('null'),0)
	
	}else {
		
		Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid/XL Store/Dashboard.png')
	}

Mobile.scrollToText('myXL Poin')

Mobile.tap(findTestObject('null'), 0)

Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid/XL Store/XL Store Landing.png')

Mobile.tap(findTestObject('null'), 5)

Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid/XL Store/Main Package Button.png')

Mobile.pressBack()

Mobile.tap(findTestObject('null'), 0)

Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid/XL Store/Add On.png')

Mobile.pressBack()

Mobile.tap(findTestObject('null'), 0)

Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid/XL Store/Fun.png')

Mobile.pressBack()

Mobile.tap(findTestObject('null'), 0)

Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid/XL Store/Starter Pack.png')

//Mobile.scrollToText('Buy from Bukalapak')

//Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid/XL Store/Bukalapak Card.png')

Mobile.pressBack()

Mobile.tap(findTestObject('null'), 0)

Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid/XL Store/SFY.png')

Mobile.scrollToText('Main Package')

Mobile.tap(findTestObject('null'), 0)

Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid/XL Store/Promo Tab.png')

Mobile.tap(findTestObject('null'), 0)

Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid/XL Store/Ewallet Tab.png')

Mobile.tap(findTestObject('null'), 0)

Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid/XL Store/Bonus isi Tab.png')

Mobile.tap(findTestObject('null'), 0)

Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid/XL Store/Bonus Tab.png')

Mobile.swipe(599, 392, 18, 409)

Mobile.delay(10)

Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid/XL Store/Bonus Tab2.png')

Mobile.tap(findTestObject('null'), 0)

Mobile.delay(30)

//Mobile.waitForElementPresent(findTestObject('null'), 10)

Mobile.tap(findTestObject('null'), 0)

Mobile.tap(findTestObject('null'), 0)

Mobile.delay(10)

Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid/XL Store/History Tab.png')

//Mobile.tap(findTestObject('null'), 0)
//
//Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid/XL Store/Waiting for payment Tab.png')
//
//Mobile.tap(findTestObject('Object Repository/XL Store - Prepaid/Transaction in Progress Tab'), 0)
//
//Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid/XL Store/In Progress Tab.png')
//
//Mobile.swipe(69, 337, 841, 337, FailureHandling.CONTINUE_ON_FAILURE)
//
//Mobile.tap(findTestObject('null'), 0)
//
//Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid/XL Store/Expired Tab.png')
//
//Mobile.tap(findTestObject('null'), 0)
//
//Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid/XL Store/Success Tab.png')
//
//Mobile.tap(findTestObject('Object Repository/XL Store - Prepaid/Failed Tab'), 0)
//
//Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid/XL Store/Failed Tab.png')

Mobile.tap(findTestObject('null'), 0)

Mobile.tap(findTestObject('null'), 0)

Mobile.waitForElementPresent(findTestObject('null'), 0)

Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid/XL Store/XCM Card.png')

Mobile.scrollToText('+49 myXL Poin from level Platinum')

Mobile.pressBack()

Mobile.tap(findTestObject('null'), 0)

Mobile.waitForElementPresent(findTestObject('null'), 0)

Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid/XL Store/XCP Card.png')

Mobile.scrollToText('+1.251 myXL Poin from level Platinum')

Mobile.pressBack()

Mobile.tap(findTestObject('null'), 0)

Mobile.waitForElementPresent(findTestObject('null'), 0)

Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid/XL Store/Akrab Card.png')

Mobile.scrollToText('+805 myXL Poin from level Platinum')

Mobile.pressBack()

Mobile.tap(findTestObject('null'), 0)

Mobile.waitForElementPresent(findTestObject('null'), 0)

Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid/XL Store/XL Pass Card.png')

Mobile.scrollToText('+390 myXL Poin from level Platinum')

Mobile.pressBack()

Mobile.tap(findTestObject('null'), 0)

Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid/XL Store/Main Package Button.png')

Mobile.tap(findTestObject('null'), 0)

Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid/XL Store/PFP Button - Star Project.png')

Mobile.tap(findTestObject('null'), 0)

Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid/XL Store/Yasmin Glam 7GB Card.png')

Mobile.tap(findTestObject('null'), 0)

Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid/XL Store/Activate Button PDP.png')

Mobile.scrollToText('BRI Direct Debit')

Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid/XL Store/BRI Direct Debit Payment Method.png')

Mobile.pressBack()

Mobile.pressBack()

Mobile.pressBack()

Mobile.tap(findTestObject('null'), 0)

Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid/XL Store/Add On Button (1).png')

Mobile.tap(findTestObject('null'), 0)

Mobile.waitForElementPresent(findTestObject('Object Repository/myXL - XL Store - Prepaid/android.widget.TextView - 30 myXL Poin from level Platinum'), 0)

Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid/XL Store/Xtra Main Quota Card.png')

Mobile.scrollToText('12 Hour')

Mobile.tap(findTestObject('Object Repository/XL Store - Prepaid/Xtra Main Quota Card 2GB Card'), 0)

Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid/XL Store/Xtra Main Quota Card 2GB Card.png')

Mobile.tap(findTestObject('null'), 0)

Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid/XL Store/Activate Button - Xtra Main Quota.png')

Mobile.tap(findTestObject('null'), 0)

Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid/XL Store/Pay Button.png')

Mobile.delay(60)

Mobile.pressBack()

Mobile.verifyElementVisible(findTestObject('null'), 0)

Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid/XL Store/Balance Check.png')

Mobile.scrollToText('View My Package Button')

Mobile.verifyElementVisible(findTestObject('null'), 0)

Mobile.verifyElementVisible(findTestObject('null'), 0)

Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid/XL Store/Quota, Call Check.png')

Mobile.tap(findTestObject('null'), 0)

Mobile.scrollToText('Add New Package')

Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid/XL Store/Add New Package.png')

Mobile.tap(findTestObject('null'), 0)

Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid/XL Store/Add New Package Button.png')

Mobile.pressBack()

Mobile.pressBack()

Mobile.tap(findTestObject('null'), 0)

Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid/XL Store/Profile Menu screenshot.png')

Mobile.scrollToText('Logout')

Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid/XL Store/Logout Menu screenshot.png')

Mobile.tap(findTestObject('null'), 0)

Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid/XL Store/Logout screenshot.png')

Mobile.closeApplication()