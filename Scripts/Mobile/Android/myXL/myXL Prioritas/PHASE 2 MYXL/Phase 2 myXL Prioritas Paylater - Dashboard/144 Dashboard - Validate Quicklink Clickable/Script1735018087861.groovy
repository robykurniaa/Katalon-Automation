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

if (Mobile.waitForElementPresent(findTestObject('null'), 0, FailureHandling.OPTIONAL)) {
	
	'Click Billing Menu'
	Mobile.tap(findTestObject('null'), 0)
	
	
	if (Mobile.waitForElementPresent(findTestObject('null'), 0, FailureHandling.OPTIONAL)) {
		
		Mobile.takeScreenshot()
		
		Mobile.tap(findTestObject('null'), 0)
		
		Mobile.verifyElementVisible(findTestObject('null'),0)
		
		Mobile.takeScreenshot()
		
		Mobile.pressBack()
		
	}
}

if (Mobile.waitForElementPresent(findTestObject('null'), 0, FailureHandling.OPTIONAL)) {
	
	'Click Plan and Booster'
	Mobile.tap(findTestObject('null'), 0)
	
	Mobile.delay(5)
	
	//Mobile.verifyElementVisible(findTestObject('null'), 0)
		
	Mobile.takeScreenshot()
		
	Mobile.pressBack()
		
}


if (Mobile.waitForElementPresent(findTestObject('null'), 0, FailureHandling.OPTIONAL)) {
	
	'Click Dompet myXL'
	Mobile.tap(findTestObject('null'), 0)
	
	Mobile.verifyElementVisible(findTestObject('null'), 0)
		
	Mobile.takeScreenshot()
		
	Mobile.pressBack()
		
}

if (Mobile.waitForElementPresent(findTestObject('null'), 0, FailureHandling.OPTIONAL)) {
	
	'Click Prio Club'
	Mobile.tap(findTestObject('null'), 0)
	
	Mobile.verifyElementVisible(findTestObject('null'), 0)
		
	Mobile.takeScreenshot()
		
	Mobile.pressBack()
		
}



'Click All Menu'
Mobile.tap(findTestObject('null'), 0)

Mobile.verifyElementVisible(findTestObject('null'), 0)

Mobile.takeScreenshot()

'Click Promo Menu'
Mobile.verifyElementVisible(findTestObject('null'), 0)

Mobile.tap(findTestObject('null'), 0)

Mobile.verifyElementVisible(findTestObject('null'), 0)

Mobile.takeScreenshot()

Mobile.pressBack()

Mobile.delay(5)

//'Click My Mission Menu'
//Mobile.verifyElementVisible(findTestObject('null'), 0)
//
//Mobile.tap(findTestObject('null'), 0)
//
//Mobile.verifyElementVisible(findTestObject('null'), 
//    0)
//
//Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prioritas Paylater/Dashboard/141 Dashboard - Validate PPS Balance, Flex Balance, Credit Limit/22 Validate My Mission.png')
//
//Mobile.pressBack()
//
//Mobile.delay(5)

'Click Chat Maya Menu'
Mobile.verifyElementVisible(findTestObject('null'), 0)

Mobile.tap(findTestObject('null'), 0)

Mobile.waitForElementPresent(findTestObject('null'), 10)

Mobile.takeScreenshot()

Mobile.tap(findTestObject('null'), 0)

'Click Spend Limit Menu'
Mobile.verifyElementVisible(findTestObject('null'), 0)

Mobile.tap(findTestObject('null'), 0)

Mobile.verifyElementVisible(findTestObject('null'), 0)

Mobile.takeScreenshot()

Mobile.pressBack()

Mobile.delay(5)

'Click Prio Flex Menu'
Mobile.verifyElementVisible(findTestObject('null'), 0)

Mobile.tap(findTestObject('null'), 0)

Mobile.verifyElementVisible(findTestObject('null'), 0)

Mobile.takeScreenshot()

Mobile.pressBack()

Mobile.delay(5)

'Click Trx Menu'
Mobile.verifyElementVisible(findTestObject('null'), 0)

Mobile.tap(findTestObject('null'), 0)

Mobile.tap(findTestObject('null'), 0)
Mobile.tap(findTestObject('null'), 0)
Mobile.tap(findTestObject('null'), 0)

Mobile.verifyElementVisible(findTestObject('null'), 0)

Mobile.takeScreenshot()

Mobile.pressBack()

Mobile.delay(5)

'Click Usage Protection Menu'
Mobile.verifyElementVisible(findTestObject('null'), 0)

Mobile.tap(findTestObject('null'), 0)

Mobile.verifyElementVisible(findTestObject('null'), 0)

Mobile.takeScreenshot()

Mobile.delay(5)

Mobile.pressBack()

Mobile.pressBack()
