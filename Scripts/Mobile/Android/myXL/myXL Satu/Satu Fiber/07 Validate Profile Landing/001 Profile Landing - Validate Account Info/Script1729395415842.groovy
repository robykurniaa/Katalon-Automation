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

import java.text.SimpleDateFormat
import java.util.Date

Mobile.callTestCase(findTestCase('Mobile/Android/myXL/myXL Satu/Satu Fiber/Login Satu Fiber'), [:], FailureHandling.STOP_ON_FAILURE)


'Wait for Quick Menu Displayed on Dashboard'
Mobile.waitForElementPresent(findTestObject('null'), 
	0, FailureHandling.OPTIONAL)

'Take Screenshot Dashboard'
Mobile.takeScreenshot()

'Profile Menu'
Mobile.tap(findTestObject('null'), 0)

Mobile.takeScreenshot()

'Account Info'
Mobile.tap(findTestObject('null'), 
    0)

Mobile.delay(5)

'Screenshot Profile'
Mobile.takeScreenshot()

'Edit Account Info'
Mobile.tap(findTestObject('null'), 0)

Mobile.takeScreenshot()

'Edit Account Info - Clear Name'
Mobile.clearText(findTestObject('null'), 0)

Mobile.takeScreenshot()

SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy") // You can change the date format as needed
String todayDate = sdf.format(new Date())

'Edit Account Info - Set Name'
Mobile.setText(findTestObject('null'), 'SATU ' + todayDate, 0)

Mobile.takeScreenshot()

Mobile.hideKeyboard()

Mobile.tap(findTestObject('null'), 
    0)

'Edit Account Info - Clear Valid Email'
Mobile.clearText(findTestObject('null'), 
    0)

Mobile.takeScreenshot()

'Edit Account Info - Set Invalid Email'
Mobile.setText(findTestObject('null'), 'Testing', 0)

Mobile.takeScreenshot()

'Verify Valid Email'
Mobile.verifyElementText(findTestObject('null'), 'Please use valid email')

Mobile.takeScreenshot()

'Edit Account Info - Clear Invalid Email'
Mobile.clearText(findTestObject('null'), 
    0)

Mobile.takeScreenshot()

'Edit Account Info - Set Valid Email'
Mobile.setText(findTestObject('null'), 'myxltestpayment3@gmail.com', 
    0)

Mobile.takeScreenshot()

Mobile.hideKeyboard()

'Save Account Info'
Mobile.tap(findTestObject('null'), 0)

Mobile.delay(5)

Mobile.takeScreenshot()

Mobile.closeApplication()

