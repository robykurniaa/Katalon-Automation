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

'Click Pay Now'
Mobile.tap(findTestObject('null'), 0)

Mobile.verifyElementVisible(findTestObject('null'), 0)

Mobile.takeScreenshot()

//'Click Dana Radio Button'
//Mobile.tap(findTestObject('null'), 0)
//Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prioritas Paylater/Dashboard/152 Billing - Validate Billing Amount/18 Dana Radio Button.png')
'Click Gopay Button'
Mobile.scrollToText('Gopay')

Mobile.tap(findTestObject('null'), 0)

Mobile.takeScreenshot()

'Click Pay'
Mobile.tap(findTestObject('null'), 0)

Mobile.takeScreenshot()

//'Put Dana Number'
//Mobile.setText(findTestObject('null'), '087777001266', 0)
//Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prioritas Paylater/Dashboard/152 Billing - Validate Billing Amount/20 Put DANA Number.png')
//
//'Click Next DANA'
//Mobile.tap(findTestObject('null'), 0)
//Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prioritas Paylater/Dashboard/152 Billing - Validate Billing Amount/21 Click Next DANA.png')
Mobile.verifyElementVisible(findTestObject('null'), 0)

Mobile.takeScreenshot()

