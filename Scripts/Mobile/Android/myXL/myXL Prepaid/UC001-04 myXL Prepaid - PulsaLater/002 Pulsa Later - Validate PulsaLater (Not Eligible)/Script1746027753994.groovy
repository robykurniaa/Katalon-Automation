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

'Verify Balance Card in Dashboard'
Mobile.waitForElementPresent(findTestObject('null'), 0)

'Click on See Feature in My Balance'
Mobile.tap(findTestObject('null'), 0)

'Validate redirected page'
Mobile.verifyElementExist(findTestObject('null'), 0)

'Screenshot My Balance'
Mobile.takeScreenshot()

'Validate Pulsa Later on Other Features'
Mobile.verifyElementExist(findTestObject('null'), 0)

'Click on Pulsa Later'
Mobile.tap(findTestObject('null'), 0)

'Interstitial Handling'
if(Mobile.verifyElementExist(findTestObject('null'), 0, FailureHandling.OPTIONAL)) {
	
	'Take Screenshot'
	Mobile.takeScreenshot()
	
	'Click OK'
	Mobile.tap(findTestObject('null'), 0)
}

'Check if user is Eligible with PulsaLater'
if(Mobile.verifyElementExist(findTestObject('null'),
	0, FailureHandling.OPTIONAL)) {
		
	'Take Screenshot'
	Mobile.takeScreenshot()
	
	'Press Back'
	Mobile.pressBack()
	
	'Press Back'
	Mobile.pressBack()
}

