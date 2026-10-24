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

'Verify Checkbox Login'
Mobile.waitForElementPresent(findTestObject('null'), 0)

'Screenshot Checkbox'
Mobile.takeScreenshot()

'Tick Checkbox Login'
Mobile.tap(findTestObject('null'), 0)

'Screenshot Success Tick Checkbox'
Mobile.takeScreenshot()

'Click Sign in to myXL Button'
Mobile.tap(findTestObject('null'), 0)

'Verify Choose Login Segment Page'
Mobile.waitForElementPresent(findTestObject('null'),
	0)

'Screenshot Choose Login Segment Page'
Mobile.takeScreenshot()

'Click XL Prepaid Segment Button'
Mobile.tap(findTestObject('null'), 0)

'Verify Input Number Page'
Mobile.waitForElementPresent(findTestObject('null'),
	0)

'Screenshot Input Number Page'
Mobile.takeScreenshot()

'Input XL Prepaid MSISDN'
Mobile.setText(findTestObject('null'), GlobalVariable.preNum,
	0)

'Screenshot Success Input XL Prepaid MSISDN'
Mobile.takeScreenshot()

'Click Continue Button - Login'
Mobile.tap(findTestObject('null'), 0)

'Verify Input OTP Page'
Mobile.waitForElementPresent(findTestObject('null'), 0)

'Input OTP'
Mobile.setText(findTestObject('null'), GlobalVariable.validOTP, 0)

'Screenshot Success Input OTP'
Mobile.takeScreenshot()

'Handling Interstitial Page'
if (Mobile.waitForElementPresent(findTestObject('null'), 0, FailureHandling.OPTIONAL)) {
	'Close Interstitial Page'
	Mobile.tap(findTestObject('null'), 0)
}

'Handling Medalia'
if (Mobile.waitForElementPresent(findTestObject('null'), 0, FailureHandling.OPTIONAL)) {
	'Close Medalia'
	Mobile.tap(findTestObject('null'), 0)
}

'Verify Dashboard'
Mobile.waitForElementPresent(findTestObject('null'), 0)

'Screenshot Dashboard'
Mobile.takeScreenshot()

Mobile.delay(2)

Mobile.scrollToText('Special For You')

Mobile.waitForElementPresent(findTestObject('null'), 0)

'Get Device Height and Store in to device_height variable'
device_Height = Mobile.getDeviceHeight()

'Get Width Height and Store in to device_Width variable'
device_Width = Mobile.getDeviceWidth()

'Storing the value in startY variable by dividing device height by 2 Because Y coordinates are constant'
int startY = device_Height * 0.80

'Here startY and endY values are equal for Horizontal Swiping for that assigning startX value to endX'
int endY = startY

'Storing the value in startX variable'
int startX = device_Width * 0.30

'Storing the value in endX variable'
int endX = device_Width * 0.85

'Loop to swipe three times'
for (int i = 0; i < 3; i++) {
	
    'Swipe from (startX, startY) to (endX, endY)'
	Mobile.swipe(endX, endY, startX, startY)
    
	Mobile.delay(2)
}

Mobile.waitForElementPresent(findTestObject('null'), 0)

Mobile.takeScreenshot()

Mobile.tap(findTestObject('null'), 0)

Mobile.waitForElementPresent(findTestObject('null'), 0)

Mobile.takeScreenshot()

Mobile.tap(findTestObject('null'), 0)

Mobile.delay(4)

Mobile.takeScreenshot()

Mobile.waitForElementPresent(findTestObject('null'), 0)

Mobile.tap(findTestObject('null'), 0)

Mobile.delay(5)

Mobile.takeScreenshot()

Mobile.closeApplication()


//Mobile.scrollToText('+1.267 XL Poin')
//
//Mobile.swipe(904, 654, 368, 654)
//
//Mobile.delay(2)
//
//Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid/Purchase SFY/74 Purchase SFY - Validate SFY Showing/11 Purchase SFY - SFY Card.png')
//
//Mobile.tap(findTestObject('null'), 0)
//
//Mobile.waitForElementPresent(findTestObject('Object Repository/myXL Prepaid - SFY/Purchase SFY - Click Special bonus'), 0)
//
//Mobile.tap(findTestObject('Object Repository/myXL Prepaid - SFY/Purchase SFY - Click Special bonus'), 0)
//
//Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prepaid/Purchase SFY/74 Purchase SFY - Validate SFY Showing/12 PDP.png')
//
//Mobile.waitForElementPresent(findTestObject('null'), 0)
/*
 * 'XL Store Navigate' Mobile.tap(findTestObject('Object Repository/myXL - XL
 * Store - Star Project - Prepaid/XL Store Landing'), 0)
 * 
 * Mobile.delay(5)
 * 
 * Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation
 * myXL/Screenshot/myXL Prepaid/Purchase SFY/75 Purchase SFY - Validate Purchase
 * SFY using balance/10 XL Store Landing.png')
 * 
 * //'SFY button' //Mobile.tap(findTestObject('Object Repository/XL Store -
 * Prepaid/SFY Button'), 0) //Mobile.delay(3)
 * //Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi
 * Merdeka/Automation myXL/Screenshot/myXL Prepaid/Purchase SFY/Purchase SFY/75
 * Purchase SFY - Validate Purchase SFY using balance/11 SFY.png')
 * Mobile.scrollToText('XC Mini - YouTube IG 6GB, 7hr')
 * 
 * Mobile.delay(2)
 * 
 * Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation
 * myXL/Screenshot/myXL Prepaid/Purchase SFY/75 Purchase SFY - Validate Purchase
 * SFY using balance/12 SFY PLP.png')
 * 
 * 'Click XCM Mini card' Mobile.tap(findTestObject('Object Repository/myXL
 * Prepaid - SFY/XCM Package Card'), 0)
 * 
 * Mobile.waitForElementPresent(findTestObject('Object Repository/myXL Prepaid -
 * SFY/Purchase SFY - Activate'), 0)
 * 
 * Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation
 * myXL/Screenshot/myXL Prepaid/Purchase SFY/75 Purchase SFY - Validate Purchase
 * SFY using balance/13 SFY PDP.png')
 * 
 * 'Click Activate XCM Mini card' Mobile.tap(findTestObject('Object
 * Repository/myXL Prepaid - SFY/Purchase SFY - Activate'), 0)
 * 
 * Mobile.delay(5)
 * 
 * Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation
 * myXL/Screenshot/myXL Prepaid/Purchase SFY/75 Purchase SFY - Validate Purchase
 * SFY using balance/14 Payment Confirmation.png')
 */


