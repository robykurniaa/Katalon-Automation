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


'Scroll Up'
Mobile.scrollToText('See Feature in My Balance')

'Verify Dashboard'
Mobile.waitForElementPresent(findTestObject('null'), 0)	

'Screenshot Dashboard'
Mobile.takeScreenshot()

if(Mobile.scrollToText('View My Package', FailureHandling.OPTIONAL)) {
	'Verify Quota Summary Card'
	Mobile.verifyElementExist(findTestObject('null'), 0)
	
	'Screenshot Quota Summary Card'
	Mobile.takeScreenshot()
	
	'Click on Quota Summary Card'
	Mobile.tap(findTestObject('null'), 0)
	
	'Scroll to Add New Package Button'
	Mobile.scrollToText('Add New Package')
	
	Mobile.delay(3)
	
	'Validate Add New Package Button shown'
	Mobile.verifyElementExist(findTestObject('null'), 
		0, FailureHandling.STOP_ON_FAILURE)
	
	'Verify Landing Page - Add New Package Button'
	Mobile.waitForElementPresent(findTestObject('null'), 
		0, FailureHandling.STOP_ON_FAILURE)
	
	'Screenshot Buy Package landing page'
	Mobile.takeScreenshot()	
	
	Mobile.pressBack()
	
	Mobile.pressBack()
	
	'Verify Dashboard'
	Mobile.waitForElementPresent(findTestObject('null'), 0)
	
} else {
	'Validate subs has no package active'
	Mobile.verifyElementExist(findTestObject('null'),
		0,  FailureHandling.OPTIONAL)
	
	'Take Screenshot'
	Mobile.takeScreenshot()
}


