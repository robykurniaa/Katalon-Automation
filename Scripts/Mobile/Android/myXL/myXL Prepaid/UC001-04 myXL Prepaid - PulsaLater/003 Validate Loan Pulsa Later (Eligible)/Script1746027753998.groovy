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

import com.kms.katalon.core.util.KeywordUtil

'Verify Total Fee'
Mobile.verifyElementExist(findTestObject('null'), 
	0, FailureHandling.OPTIONAL)

'Screenshot'
Mobile.takeScreenshot()

'Click on arrow up details'
Mobile.tap(findTestObject('null'), 0)

'Screenshot Details Fee'
Mobile.takeScreenshot()

'Close Details half card'
Mobile.pressBack()

'Click on Use Now Button'
try {
	Mobile.tap(findTestObject('null'), 0)
} catch (Exception e) {
	KeywordUtil.markFailed("An error occurred: " + e.message)
}
Mobile.delay(4)

'Click on Confirm Use PulsaLater'
try {
	if(Mobile.verifyElementExist(findTestObject('null'), 0, FailureHandling.STOP_ON_FAILURE)) {
		
		Mobile.takeScreenshot()
		
		Mobile.tap(findTestObject('null'), 
			0, FailureHandling.STOP_ON_FAILURE)
	}
} catch (Exception e) {
	KeywordUtil.markFailed("An error occurred: " + e.message)
}

'Screenshot'
Mobile.takeScreenshot()

