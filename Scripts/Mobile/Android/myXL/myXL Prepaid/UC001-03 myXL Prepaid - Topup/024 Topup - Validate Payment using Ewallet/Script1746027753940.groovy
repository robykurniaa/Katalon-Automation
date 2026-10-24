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

'Click Radio Button'
Mobile.tap(findTestObject('null'), 0)

Mobile.delay(2)

'Click Radio Button'
Mobile.tap(findTestObject('null'), 0)

Mobile.takeScreenshot()

Mobile.delay(4)

'Click Pay Button'
Mobile.tap(findTestObject('null'), 0)

'Verify Consent Checkbox'
if (Mobile.verifyElementExist(findTestObject('null'), 0, FailureHandling.OPTIONAL)) {
    'Click Consent Checkbox'
    Mobile.tap(findTestObject('null'), 0)

    Mobile.takeScreenshot()

    'Click Consent Continue'
    Mobile.tap(findTestObject('null'), 0)

    Mobile.takeScreenshot()
}

Mobile.delay(5)

Mobile.takeScreenshot()


'Click X Button'
Mobile.tap(findTestObject('null'), 0)

if(Mobile.verifyElementExist(findTestObject('null')
	, 0, FailureHandling.OPTIONAL)) {
	
	Mobile.takeScreenshot()
	
	if(Mobile.tap(findTestObject('null'), 0)) {
		
		Mobile.verifyElementExist(findTestObject('null'), 0)
		
		Mobile.takeScreenshot()
		
		Mobile.tap(findTestObject('null'), 0)
	}
}

Mobile.takeScreenshot()

Mobile.delay(2)


