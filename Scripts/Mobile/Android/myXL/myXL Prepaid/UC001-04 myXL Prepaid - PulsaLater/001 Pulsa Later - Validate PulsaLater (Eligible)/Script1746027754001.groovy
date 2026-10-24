import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.appium.exception.MobileDriverInitializeException
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

'Scroll to text Special For You'
Mobile.scrollToText('Special For You')

'Verify PulsaLater on dashboard'
Mobile.verifyElementExist(findTestObject('null'), 0)

'Screenshot PulsaLater button'
Mobile.takeScreenshot()

'Click on PulsaLater Button'
Mobile.tap(findTestObject('null'), 0)

'Interstitial Handling'
if(Mobile.verifyElementExist(findTestObject('null'), 0, FailureHandling.OPTIONAL)) {
	'Click OK'
	Mobile.tap(findTestObject('null'), 0)
}

'Delay to let page fully displayed'
Mobile.delay(3)

'Verify subs has PulsaLater Limit Available'
Mobile.waitForElementPresent(findTestObject('null'), 0)

'Screenshot PulsaLater Landing Page'
Mobile.takeScreenshot()

'Back to dashboard'
Mobile.pressBack()

'Click Profile Menu'
Mobile.tap(findTestObject('null'), 0)

'Screenshot'
Mobile.takeScreenshot()

'PulsaLater Menu'
Mobile.tap(findTestObject('null'), 0)

'Verify subs has PulsaLater Limit Available'
Mobile.waitForElementPresent(findTestObject('null'), 0)

'Verify PulsaLater denom is the same from every entry point'
Mobile.takeScreenshot()

Mobile.delay(3)

'Verify subs has PulsaLater Limit Available'
Mobile.tap(findTestObject('null'), 0)

'Verify Landing Page Use PulsaLater'
Mobile.verifyElementExist(findTestObject('null'), 0)

'Validate denom available'
if(Mobile.verifyElementExist(findTestObject('null'),
	0, FailureHandling.CONTINUE_ON_FAILURE)) {
	
	'Click on Denom 10.000'
	Mobile.tap(findTestObject('null'),
	0, FailureHandling.CONTINUE_ON_FAILURE)
}

'Validate denom available'
if(Mobile.verifyElementExist(findTestObject('null'), 
	0, FailureHandling.CONTINUE_ON_FAILURE)) {
	
	'Click on Denom 7.000'
	Mobile.tap(findTestObject('null'),
	0, FailureHandling.CONTINUE_ON_FAILURE)
}

'Validate denom available'
if(Mobile.verifyElementExist(findTestObject('null'),
	0, FailureHandling.CONTINUE_ON_FAILURE)) {
	
	'Click on Denom 5.000'
	Mobile.tap(findTestObject('null'),
	0, FailureHandling.CONTINUE_ON_FAILURE)
}

'Validate denom available'
if(Mobile.verifyElementExist(findTestObject('null'),
	0, FailureHandling.CONTINUE_ON_FAILURE)) {
	
	'Click on Denom 2.000'
	Mobile.tap(findTestObject('null'),
	0, FailureHandling.CONTINUE_ON_FAILURE)
}

'Validate denom available'
if(Mobile.verifyElementExist(findTestObject('null'),
	0, FailureHandling.CONTINUE_ON_FAILURE)) {
	
	'Click on Denom 3.000'
	Mobile.tap(findTestObject('null'),
	0, FailureHandling.CONTINUE_ON_FAILURE)
	
	def totalFee = Mobile.getText(findTestObject('null'), 0)
	
	'Verify if displayed denom has not changed'
	Mobile.verifyEqual(totalFee, 'IDR 3.750')
}
