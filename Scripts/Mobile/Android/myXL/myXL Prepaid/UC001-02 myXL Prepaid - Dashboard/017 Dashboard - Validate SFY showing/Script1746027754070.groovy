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
Mobile.startExistingApplication('com.apps.MyXL')

'Verify Dashboard'
Mobile.waitForElementPresent(findTestObject('null'), 0)	

'Screenshot Dashboard'
Mobile.takeScreenshot()

'Scroll to SFY'
Mobile.scrollToText('Special For You')

'Get Device Height and Store in to device_height variable'
device_Height = Mobile.getDeviceHeight()

'Get Width Height and Store in to device_Width variable'
device_Width = Mobile.getDeviceWidth()

'Storing the value in startY variable by dividing device height by 2 Because Y coordinates are constant'
int startY = 1

'Here startY and endY values are equal for Horizontal Swiping for that assigning startX value to endX'
int endY = startY

'Storing the value in startX variable'
int startX = device_Width * 0.90

'Storing the value in endX variable'
int endX = device_Width * 0.10

'Here Y constant for Swipe Horizontal Left to Right'
for (int i = 1; i <= 3; i++) {
    'Swipe SFY'
    Mobile.swipe(startX, startY, endX, endY)
    println("Swipe action ${i} completed.")
}

'Screenshot SFY Swiped'
Mobile.takeScreenshot()

'Click on SFY'
Mobile.tap(findTestObject('null'), 0)

'Validate SFY Landing Page'
Mobile.verifyElementExist(findTestObject('null'), 0)

Mobile.delay(2)

Mobile.takeScreenshot()

Mobile.delay(2)

Mobile.pressBack()

'Verify Dashboard'
Mobile.waitForElementPresent(findTestObject('null'), 0)

