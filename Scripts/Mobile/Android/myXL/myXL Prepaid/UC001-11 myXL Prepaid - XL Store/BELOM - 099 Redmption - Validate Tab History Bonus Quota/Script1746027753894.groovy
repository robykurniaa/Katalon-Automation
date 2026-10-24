import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
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
Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid/XL Store/99 Redmption - Validate Tab History Bonus Quota/1 Splash Screen.png')

Mobile.delay(10, FailureHandling.CONTINUE_ON_FAILURE)

'Verify CVP'
if (Mobile.waitForElementPresent(findTestObject('null'), 0) == true) {
    'CVP Screenshot'
    Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid/XL Store/99 Redmption - Validate Tab History Bonus Quota/2 Lets Start Button screenshot.png')

    'Click Continue on CVP'
    Mobile.tap(findTestObject('null'), 0)

    'Verify Checkbox Login'
    Mobile.verifyElementVisible(findTestObject('null'), 0)

    'Tick Checkbox Login'
    Mobile.tap(findTestObject('null'), 0)

    'Tick Checkbox Login ScreenShot'
    Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid/XL Store/99 Redmption - Validate Tab History Bonus Quota/3 Check Box screenshot.png')
} else {
    'Verify Checkbox Login'
    Mobile.verifyElementVisible(findTestObject('null'), 0)

    'Tick Checkbox Login'
    Mobile.tap(findTestObject('null'), 0)

    'Tick Checkbox Login ScreenShot'
    Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid/XL Store/99 Redmption - Validate Tab History Bonus Quota/3 Check Box screenshot.png')
}

'Click Sign in to myXL Button'
Mobile.tap(findTestObject('null'), 0)

'Click Sign in to myXL Button ScreenShot'
Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid/XL Store/99 Redmption - Validate Tab History Bonus Quota/4 Sign in to myXL screenshot.png')

'Click XL Prepaid Segment Button'
Mobile.tap(findTestObject('null'), 0)

'Click XL Prepaid Segment Button ScreenShot'
Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid/XL Store/99 Redmption - Validate Tab History Bonus Quota/5 XL Prepaid Segment screenshot.png')

'Input XL MSISDN'
Mobile.setText(findTestObject('null'), '6287884076185', 
    0)

'Input XL MSISDN ScreenShot'
Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid/XL Store/99 Redmption - Validate Tab History Bonus Quota/6 Validate Login using Prepaid MSISDN.png')

'Click Continue Button - Login'
Mobile.tap(findTestObject('null'), 0)

'Input OTP'
Mobile.setText(findTestObject('null'), '190160', 0)

'Input OTP ScreenShot'
Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid/XL Store/99 Redmption - Validate Tab History Bonus Quota/7 OTP Input screenshot.png')

'Verify Medalia'
if (Mobile.verifyElementExist(findTestObject('null'), 0, FailureHandling.OPTIONAL)) {
    'Verify Medalia ScreenShot'
    Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid/XL Store/99 Redmption - Validate Tab History Bonus Quota/8 Validate Medalia Dashboard.png')

    'Close Medalia'
    Mobile.tap(findTestObject('null'), 0)
} else {
    'Verify Dashboard'
    Mobile.verifyElementVisible(findTestObject('null'), 0)

    'Dashboard ScreenShot'
    Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid/XL Store/99 Redmption - Validate Tab History Bonus Quota/9 Validate Dashboard.png')
}

Mobile.scrollToText('XL Poin')

'XL Store Navigate'
Mobile.tap(findTestObject('null'), 0)

Mobile.delay(5)

Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid/XL Store/99 Redmption - Validate Tab History Bonus Quota/XL Store Landing.png')

'Main Package'
Mobile.tap(findTestObject('null'), 0)

Mobile.delay(5)

Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid/XL Store/99 Redmption - Validate Tab History Bonus Quota/Main Package Button.png')

Mobile.pressBack()

'Add On'
Mobile.tap(findTestObject('null'), 0)

Mobile.delay(5)

Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid/XL Store/99 Redmption - Validate Tab History Bonus Quota/Add On.png')

Mobile.pressBack()

'Fun Button'
Mobile.tap(findTestObject('null'), 0)

Mobile.delay(5)

Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid/XL Store/99 Redmption - Validate Tab History Bonus Quota/Fun.png')

Mobile.pressBack()

'Starter Pack Button'
Mobile.tap(findTestObject('null'), 0)

Mobile.delay(5)

Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid/XL Store/99 Redmption - Validate Tab History Bonus Quota/Starter Pack.png')

Mobile.pressBack()

'SFY button'
Mobile.tap(findTestObject('null'), 0)

Mobile.delay(3)

Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid/XL Store/99 Redmption - Validate Tab History Bonus Quota/SFY.png')

Mobile.scrollToText('Main Package')

'Promo tab'
Mobile.tap(findTestObject('null'), 0)

Mobile.delay(3)

Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid/XL Store/99 Redmption - Validate Tab History Bonus Quota/Promo Tab.png')

'Ewallet Tab'
Mobile.tap(findTestObject('null'), 0)

Mobile.delay(3)

Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid/XL Store/99 Redmption - Validate Tab History Bonus Quota/Ewallet Tab.png')

'Bonus isi ulang Tab'
Mobile.tap(findTestObject('null'), 0)

Mobile.delay(3)

Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid/XL Store/99 Redmption - Validate Tab History Bonus Quota/Bonus isi Tab.png')

'Bonus Tab'
Mobile.tap(findTestObject('null'), 0)

Mobile.delay(3)

Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid/XL Store/99 Redmption - Validate Tab History Bonus Quota/Bonus Tab.png')

Mobile.delay(5)

Mobile.swipe(599, 392, 18, 409)

Mobile.delay(5)

Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid/XL Store/99 Redmption - Validate Tab History Bonus Quota/Bonus Tab2.png')

'History Tab'
Mobile.tap(findTestObject('null'), 0)

Mobile.delay(5)

Mobile.tap(findTestObject('null'), 0)

Mobile.delay(5)

Mobile.tap(findTestObject('null'), 0)

Mobile.delay(5)

Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid/XL Store/99 Redmption - Validate Tab History Bonus Quota/History Tab.png')

'Store Tab'
Mobile.tap(findTestObject('null'), 0)

'XCM card'
Mobile.tap(findTestObject('null'), 0)

Mobile.waitForElementPresent(findTestObject('null'), 
    0)

Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid/XL Store/99 Redmption - Validate Tab History Bonus Quota/XCM Card.png')

Mobile.scrollToText('+49 myXL Poin from level Platinum')

Mobile.pressBack()

'XCP card'
Mobile.tap(findTestObject('null'), 0)

Mobile.waitForElementPresent(findTestObject('null'), 
    0)

Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid/XL Store/99 Redmption - Validate Tab History Bonus Quota/XCP Card.png')

Mobile.scrollToText('+1.251 myXL Poin from level Platinum')

Mobile.pressBack()

'Akrab card'
Mobile.tap(findTestObject('null'), 0)

Mobile.waitForElementPresent(findTestObject('null'), 
    0)

Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid/XL Store/99 Redmption - Validate Tab History Bonus Quota/Akrab Card.png')

Mobile.scrollToText('+805 myXL Poin from level Platinum')

Mobile.pressBack()

'XL Pass card'
Mobile.tap(findTestObject('null'), 0)

Mobile.waitForElementPresent(findTestObject('null'), 
    0)

Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid/XL Store/99 Redmption - Validate Tab History Bonus Quota/XL Pass Card.png')

Mobile.scrollToText('+390 myXL Poin from level Platinum')

Mobile.pressBack()

'Main Package'
Mobile.tap(findTestObject('null'), 0)

Mobile.delay(2)

Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid/XL Store/99 Redmption - Validate Tab History Bonus Quota/Main Package Button.png')

Mobile.tap(findTestObject('null'), 0)

Mobile.delay(2)

Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid/XL Store/99 Redmption - Validate Tab History Bonus Quota/PFP Button - Star Project.png')

Mobile.tap(findTestObject('null'), 0)

Mobile.delay(2)

Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid/XL Store/99 Redmption - Validate Tab History Bonus Quota/Yasmin Glam 7GB Card.png')

//'Get Device Height and Store in device_height variable'
//
//device_Height = Mobile.getDeviceHeight()
//
//
//
//'Get Width Height and Store in device_Width variable'
//
//device_Width = Mobile.getDeviceWidth()
//
//
//
//'Storing the startX value by dividing device width by 2. Because x coordinates are constant for Vertical Swiping'
//
//int startX = device_Width / 2
//
//
//
//'Here startX and endX values are equal for vertical Swiping for that assigning startX value to endX'
//
//int endX = startX
//
//
//
//'Storing the startY value'
//
//int startY = device_Height * 0.30
//
//
//
//'Storing the endY value'
//
//int endY = device_Height * 0.70
//
//
//
//'Swipe Vertical from top to bottom'
//
//Mobile.swipe(startX, endY, endX, startY)
'Activate Button'
Mobile.tap(findTestObject('null'), 0)

Mobile.delay(2)

Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid/XL Store/Activate Button PDP.png')

Mobile.scrollToText('BRI Direct Debit')

Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid/XL Store/BRI Direct Debit Payment Method.png')

Mobile.pressBack()

Mobile.pressBack()

Mobile.pressBack()

'Add on Button'
Mobile.tap(findTestObject('null'), 0)

Mobile.delay(2)

Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid/XL Store/Add On Button (1).png')

Mobile.tap(findTestObject('null'), 0)

Mobile.waitForElementPresent(findTestObject('Object Repository/myXL - XL Store - Prepaid/android.widget.TextView - 30 myXL Poin from level Platinum'), 
    0)

Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid/XL Store/Xtra Main Quota Card.png')

Mobile.scrollToText('12 Hour')

Mobile.tap(findTestObject('Object Repository/XL Store - Prepaid/Xtra Main Quota Card 2GB Card'), 0)

Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid/XL Store/Xtra Main Quota Card 2GB Card.png')

'Activate Button'
Mobile.tap(findTestObject('null'), 0)

Mobile.delay(2)

Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid/XL Store/Activate Button - Xtra Main Quota.png')

Mobile.tap(findTestObject('null'), 0)

Mobile.delay(2)

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

Mobile.closeApplication()

