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

Mobile.callTestCase(findTestCase('Mobile/Android/myXL/myXL Satu/Satu Fiber/Login Satu Fiber'), [:], FailureHandling.STOP_ON_FAILURE)


'Wait for Quick Menu Displayed on Dashboard'
Mobile.waitForElementPresent(findTestObject('null'), 
	0, FailureHandling.OPTIONAL)

'Take Screenshot Dashboard'
Mobile.takeScreenshot()

//-- Buy Package

'Validate Quick Menu - Buy Package'
Mobile.verifyElementExist(findTestObject('null'), 0)

'Click on Quick Menu - Buy Package'
Mobile.tap(findTestObject('null'), 0)

'Validate Landing Page Quick Menu Buy Package'
Mobile.verifyElementExist(findTestObject('null'), 5)

'Take Screenshot'
Mobile.takeScreenshot()

'Back to Dashboard'
Mobile.pressBack()

//-- Kuota HP Sekeluarga 

'Validate Quick Menu - Kuota HP Sekeluarga'
Mobile.verifyElementExist(findTestObject('null'), 0)

'Click on Quick Menu - Kuota HP Sekeluarga'
Mobile.tap(findTestObject('null'), 0)

'Validate Landing Page Quick Menu Kuota HP Sekeluarga'
Mobile.verifyElementExist(findTestObject('null'), 5)

'Take Screenshot'
Mobile.takeScreenshot()

'Back to Dashboard'
Mobile.pressBack()


//-- Billing Info

'Validate Quick Menu - Billing Info'
Mobile.verifyElementExist(findTestObject('null'), 0)

'Click on Quick Menu - Billing Info'
Mobile.tap(findTestObject('null'), 0)

'Validate Landing Page Quick Menu Billing Info'
Mobile.verifyElementExist(findTestObject('null'), 5)

'Take Screenshot'
Mobile.takeScreenshot()

'Back to Dashboard'
Mobile.pressBack()

//-- Live Chat

'Validate Quick Menu - Live Chat'
Mobile.verifyElementExist(findTestObject('null'), 0)

'Click on Quick Menu - Live Chat'
Mobile.tap(findTestObject('null'), 0)

'Validate Landing Page Quick Menu Live Chat'
Mobile.verifyElementExist(findTestObject('null'), 5)

'Take Screenshot'
Mobile.takeScreenshot()

'Back to Dashboard'
Mobile.pressBack()

Mobile.closeApplication()