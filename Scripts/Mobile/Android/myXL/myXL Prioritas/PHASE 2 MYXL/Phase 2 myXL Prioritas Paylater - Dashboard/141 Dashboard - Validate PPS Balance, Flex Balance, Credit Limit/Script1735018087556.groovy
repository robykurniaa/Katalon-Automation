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

'Scroll Down'
Mobile.scrollToText('5 Last Usage')

Mobile.delay(2)

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

//Mobile.swipe(900, 1300, 100, 1300)

'Verify PPS Balance'
Mobile.verifyElementVisible(findTestObject('null'),0)

'Verify Flex'
Mobile.verifyElementVisible(findTestObject('null'),0)

Mobile.takeScreenshot()

Mobile.delay(5)

//Mobile.closeApplication()
