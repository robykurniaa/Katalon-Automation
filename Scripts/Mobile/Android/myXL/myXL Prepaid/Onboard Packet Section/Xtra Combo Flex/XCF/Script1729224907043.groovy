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

'Call TC from login to dashboard'
Mobile.callTestCase(findTestCase('Mobile/Android/myXL/myXL Prepaid/main refs/UC001-01 myXL Prepaid - Onboarding/010 Login - Validate Dashboard'), [:], FailureHandling.STOP_ON_FAILURE)

'Go to PFP'
Mobile.tap(findTestObject('null'), 0)

'Verify PFP'
Mobile.verifyElementVisible(findTestObject('null'), 0)

'Screenshot PFP'
Mobile.takeScreenshot()

'Function Scroll down to XCF'
device_Height = Mobile.getDeviceHeight()

device_Width = Mobile.getDeviceWidth()

int startY = 1800

int endY = 1000

int startX = device_Width * 0.95

int endX = startX

Mobile.swipe(startX, startY, endX, endY)

'Screenshot PFP'
Mobile.takeScreenshot()

'Go to XCF'
Mobile.tap(findTestObject('null'), 0)

'Verify PLP XCF'
Mobile.verifyElementVisible(findTestObject('null'), 0)

'Screenshot PFP'
Mobile.takeScreenshot()

//------- Call TC PLP
//WebUI.callTestCase(findTestCase('Mobile/Android/myXL/myXL Prepaid/Onboard Packet Section/Xtra Combo Flex/FLEX XXXL - 100GB - IDR 162.000'), [:], FailureHandling.STOP_ON_FAILURE)

