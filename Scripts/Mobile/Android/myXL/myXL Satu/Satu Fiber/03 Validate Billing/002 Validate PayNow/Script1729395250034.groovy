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

'wait for Billing Info in Quick Menu'
Mobile.waitForElementPresent(findTestObject('null'),
	0, FailureHandling.STOP_ON_FAILURE)


'Take Screenshot'
Mobile.takeScreenshot()

'Click on Billing Info'
Mobile.tap(findTestObject('null'), 0)

'Wait for Billing Outstanding Amount'
Mobile.waitForElementPresent(findTestObject('null'), 0)

'Take Screenshot'
Mobile.takeScreenshot()

'Validate button Pay Now'
Mobile.verifyElementExist(findTestObject('null'), 0)

'Click button Pay Now'
Mobile.tap(findTestObject('null'), 0)

'Wait for Confirmation Page'
Mobile.waitForElementPresent(findTestObject('null'), 0)

'Take Screenshot'
Mobile.takeScreenshot()

'Validate Payment Methods E-Wallet Available'
if(Mobile.verifyElementExist(findTestObject('null'), 
	0, FailureHandling.OPTIONAL)) {
	
	'Click on DANA'
	Mobile.tap(findTestObject('null'), 0)
}
else if(Mobile.verifyElementExist(findTestObject('null'), 
	0, FailureHandling.OPTIONAL)) {

	'Click on Gopay'
	Mobile.tap(findTestObject('null'), 0)
}
else if(Mobile.verifyElementExist(findTestObject('null'),
	0, FailureHandling.OPTIONAL)) {

	'Click on OVO'
	Mobile.tap(findTestObject('null'), 0)
}
else if(Mobile.verifyElementExist(findTestObject('null'),
	0, FailureHandling.OPTIONAL)) {

	'Click on ShopeePay'
	Mobile.tap(findTestObject('null'), 0)
}
else {
	
	print('E-Wallet Not Available as Payment Method')
}

Mobile.takeScreenshot()

Mobile.closeApplication()