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
			
'Screenshot Welcome Page'
Mobile.takeScreenshot()

'Click Login to myXL Button'
Mobile.tap(findTestObject('null'), 0)

Mobile.takeScreenshot()

'Click Sign in to myXL Button'
Mobile.tap(findTestObject('null'), 0)

Mobile.takeScreenshot()

'Click XL Prioritas Segment Button'
Mobile.tap(findTestObject('null'), 0)

'Screenshot Choose Login Segment Page'
Mobile.takeScreenshot()

'Verify Input Number Page'
Mobile.waitForElementPresent(findTestObject('null'), 0)

'Screenshot Input Number Page'
Mobile.takeScreenshot()

'Input XL Prio Paylater MSISDN'
Mobile.setText(findTestObject('null'), GlobalVariable.prioPaylaterNum, 0)

'Screenshot Input Number Page'
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
	(Mobile.tap(findTestObject('null'), 0))
}

'Handling Medalia'
if (Mobile.waitForElementPresent(findTestObject('null'), 0, FailureHandling.OPTIONAL)) {
	'Close Medalia'
	Mobile.tap(findTestObject('null'),0)
}

'Screenshot Dashboard'
Mobile.takeScreenshot()

'Scroll Down'
Mobile.scrollToText('5 Last Usage')

'Wait for Element Present of Checkbox Dont Show this message again.\\r\\nif element present return true otherwise false.'
alert_Status = Mobile.waitForElementPresent(findTestObject('null'), 20)

'Wait for element Present of Heading API Demos'
Mobile.waitForElementPresent(findTestObject('null'), 30)

'Get Device Height and Store in to device_height variable'
device_Height = Mobile.getDeviceHeight()

'Get Width Height and Store in to device_Width variable'
device_Width = Mobile.getDeviceWidth()

'Storing the value in startY variable by dividing device height by 2 Because Y coordinates are constant'
int startY = 1300

'Here startY and endY values are equal for Horizontal Swiping for that assigning startX value to endX'
int endY = startY

'Storing the value in startX variable'
int startX = device_Width * 0.90

'Storing the value in endX variable'
int endX = device_Width * 0.10

'Here Y constant for Swipe Horizontal Left to Right'
Mobile.swipe(startX, startY, endX, endY)

'Verify Flex'
Mobile.verifyElementVisible(findTestObject('null'), 0)

Mobile.takeScreenshot()

'Go to Prio Flex'
Mobile.tap(findTestObject('null'), 0)

Mobile.takeScreenshot()

'Go Reload'
Mobile.tap(findTestObject('null'), 0)

Mobile.takeScreenshot()

'Click To Balance Button'
Mobile.tap(findTestObject('null'), 0)

Mobile.takeScreenshot()

'Click Change Number'
Mobile.tap(findTestObject('null'), 0)

Mobile.takeScreenshot()

'Input Number'
Mobile.setText(findTestObject('null'), '085964418295', 0)

Mobile.takeScreenshot()

'Click Continue'
Mobile.tap(findTestObject('null'), 0)

Mobile.takeScreenshot()


//Mobile.closeApplication()


