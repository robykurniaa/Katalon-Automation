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
import com.kms.katalon.core.testobject.MobileTestObject.MobileLocatorStrategy
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys


'Open myXL'
Mobile.startApplication(GlobalVariable.APK, true)

'Verify CVP'
if (Mobile.waitForElementPresent(findTestObject('null'), 0)) {
	'Screenshot CVP'
	Mobile.takeScreenshot()
		
	'Click Continue on CVP'
	Mobile.tap(findTestObject('null'), 0)
}
			
'Verify Checkbox Login'
Mobile.waitForElementPresent(findTestObject('null'), 0)
	
'Screenshot Checkbox'
Mobile.takeScreenshot()
	
'Tick Checkbox Login'
Mobile.tap(findTestObject('null'), 0)
	
'Screenshot Success Tick Checkbox'
Mobile.takeScreenshot()
	
'Click Sign in to myXL Button'
Mobile.tap(findTestObject('null'), 0)

'Verify Choose Login Segment Page'
Mobile.waitForElementPresent(findTestObject('null'), 0)

'Screenshot Choose Login Segment Page'
Mobile.takeScreenshot()

'Click XL Prepaid Segment Button'
Mobile.tap(findTestObject('null'), 0)

'Verify Input Number Page'
Mobile.waitForElementPresent(findTestObject('null'), 0)

'Screenshot Input Number Page'
Mobile.takeScreenshot()

'Input XL Prepaid MSISDN'
Mobile.setText(findTestObject('null'), '087883021819', 0)

'Screenshot Success Input XL Prepaid MSISDN'
Mobile.takeScreenshot()

'Click Continue Button - Login'
Mobile.tap(findTestObject('null'), 0)

'Verify Input OTP Page'
Mobile.waitForElementPresent(findTestObject('null'), 0)

'Input OTP'
Mobile.setText(findTestObject('null'), GlobalVariable.validOTP, 0)

'Screenshot Success Input OTP'
Mobile.takeScreenshot()

'Handling Interstitial Page'
if (Mobile.waitForElementPresent(findTestObject('null'), 0, FailureHandling.OPTIONAL)) {
	'Close Interstitial Page'
	(Mobile.tap(findTestObject('null'), 0))
}

'Handling Medalia'
if (Mobile.waitForElementPresent(findTestObject('null'), 0, FailureHandling.OPTIONAL)) {
	'Close Medalia'
	Mobile.tap(findTestObject('null'),0)
}

'Verify Dashboard'
Mobile.waitForElementPresent(findTestObject('null'), 0)

'Define Balance on Balance Card'
def balanceBefore = Mobile.getText(findTestObject('null'), 0, FailureHandling.STOP_ON_FAILURE)

'Verify current balance is IDR IDR 120.248'
Mobile.verifyEqual(balanceBefore , 'IDR 120.248')

'Define Quota Summary'
def internetQuotaBefore = Mobile.getText(findTestObject('null'), 0)

'Verify current quota is 1.5 GB'
Mobile.verifyEqual(internetQuotaBefore , '1.5 GB')

'Define Poin Before Transaction'
def poinBefore = Mobile.getText(findTestObject('null'), 0)

'Verify XL Poin before transaction is 3.375'
Mobile.verifyEqual(poinBefore, '3.375')

'Screenshot Balance, Quota, and XL Poin before transaction'
Mobile.takeScreenshot()

'Click View My Package on Quota Summary Card'
Mobile.tap(findTestObject('null'), 0)

'Wait for Quota Detail Page fully displayed'
Mobile.waitForElementPresent(findTestObject('null'), 0)

'Screenshot Quota Detail before transaction (Domestic Quota)'
Mobile.takeScreenshot()

'Switch on Roaming Tab in Quota Detail'
Mobile.tap(findTestObject('null'), 0)

'Screenshot Quota Detail before transaction (Roaming Quota)'
Mobile.takeScreenshot()

'Back to Domestic tab'
Mobile.tap(findTestObject('null'), 0)

'Scroll to Add New Package Button'
Mobile.scrollToText('Add New Package')

'Click Button Add New Package'
Mobile.tap(findTestObject('null'), 0)

'Wait for Buy Package - Main Package PFP is fully displayed'
Mobile.waitForElementPresent(findTestObject('null'), 0)

'Screenshot Landing Store'
Mobile.takeScreenshot()

'Click on XCP on PFP'
Mobile.tap(findTestObject('null'), 0)

'Screenshot Landing XCP (XCP VIP PLP)'
Mobile.takeScreenshot()

'Click on About Tab'
Mobile.tap(findTestObject('null'), 0)

Mobile.delay(2)

'Screenshot About Tab XCP'
Mobile.takeScreenshot()

'Click Back to Produk tab'
Mobile.tap(findTestObject('null'), 0)

'Click on Regular Tab' 
Mobile.tap(findTestObject('null'), 0)

'Screenshot XCP Regular Tab Landing' 
Mobile.takeScreenshot()

//=========== Regular PLP

'Verify XCP Regular PLP - 100GB'
Mobile.verifyElementExist(findTestObject('null'), 0)

'Define XCP Regular 100GB Price'
def xcpReg100GB = Mobile.getText(findTestObject('null'), 0)

'Verify XCP Regular 100GB Price'
Mobile.verifyEqual(xcpReg100GB, 'IDR 159.185')

'Screenshot XCP Regular 100GB'
Mobile.takeScreenshot()

//--------

'Verify XCP Regular PLP - 66GB'
Mobile.verifyElementExist(findTestObject('null'), 0)

'Define XCP Regular 66GB Price'
def xcpReg66GB = Mobile.getText(findTestObject('null'), 0)

'Verify XCP Regular 66GB Price'
Mobile.verifyEqual(xcpReg66GB, 'IDR 128.030')

'Screenshot XCP Regular 66GB'
Mobile.takeScreenshot()

'Scroll Down Regular PLP'
Mobile.scrollToText('13.5GB')

//--------

'Verify XCP Regular PLP - 42GB'
Mobile.verifyElementExist(findTestObject('null'), 0)

'Define XCP Regular 42GB Price'
def xcpReg42GB = Mobile.getText(findTestObject('null'), 0)

'Verify XCP Regular 42GB Price'
Mobile.verifyEqual(xcpReg42GB, 'IDR 100.500')

'Screenshot XCP Regular 42GB'
Mobile.takeScreenshot()

//--------

'Verify XCP Regular PLP - 26GB'
Mobile.verifyElementExist(findTestObject('null'), 0)

'Define XCP Regular 26GB Price'
def xcpReg26GB = Mobile.getText(findTestObject('null'), 0)

'Verify XCP Regular 26GB Price'
Mobile.verifyEqual(xcpReg26GB, 'IDR 71.920')

'Screenshot XCP Regular 26GB'
Mobile.takeScreenshot()

//--------

'Verify XCP Regular PLP - 13.5GB'
Mobile.verifyElementExist(findTestObject('null'), 0)

'Define XCP Regular 13.5GB Price'
def xcpReg13_5GB = Mobile.getText(findTestObject('null'), 0)

'Verify XCP Regular 13.5GB Price'
Mobile.verifyEqual(xcpReg13_5GB, 'IDR 50.915')

'Screenshot XCP Regular 13.5GB'
Mobile.takeScreenshot()

//=========== VIP PLP

'Scroll Up to view VIP Tab'
Mobile.scrollToText('66GB')

'Back to VIP PLP' 
Mobile.tap(findTestObject('null'), 0)

'Verify XCP VIP PLP - 100GB'
Mobile.verifyElementExist(findTestObject('null'), 0)

'Define XCP VIP 100GB Price'
def xcpVIP100GB = Mobile.getText(findTestObject('null'), 0)

'Verify XCP VIP 100GB Price'
Mobile.verifyEqual(xcpVIP100GB, 'IDR 164.775')

'Screenshot XCP VIP 100GB'
Mobile.takeScreenshot()

//--------

'Verify XCP VIP PLP - 66GB'
Mobile.verifyElementExist(findTestObject('null'), 0)

'Define XCP VIP 66GB Price'
def xcpVIP66GB = Mobile.getText(findTestObject('null'), 0)

'Verify XCP VIP 100GB Price'
Mobile.verifyEqual(xcpVIP66GB, 'IDR 135.300')

'Screenshot XCP VIP 66GB'
Mobile.takeScreenshot()

'Scroll Down VIP PLP'
Mobile.scrollToText('13.5GB')
//--------

'Verify XCP VIP PLP - 42GB'
Mobile.verifyElementExist(findTestObject('null'), 0)

'Define XCP VIP 100GB Price'
def xcpVIP42GB = Mobile.getText(findTestObject('null'), 0)

'Verify XCP VIP 100GB Price'
Mobile.verifyEqual(xcpVIP42GB, 'IDR 105.750')

'Screenshot XCP VIP 42GB'
Mobile.takeScreenshot()

//--------

'Verify XCP VIP PLP - 26GB'
Mobile.verifyElementExist(findTestObject('null'), 0)

'Define XCP VIP 26GB Price'
def xcpVIP26GB = Mobile.getText(findTestObject('null'), 0)

'Verify XCP VIP 26GB Price'
Mobile.verifyEqual(xcpVIP26GB, 'IDR 79.840')

'Screenshot XCP VIP GB'
Mobile.takeScreenshot()

//--------

'Verify XCP VIP PLP - 13.5GB'
Mobile.verifyElementExist(findTestObject('null'), 0)

'Define XCP VIP 13.5GB Price'
def xcpVIP13_5GB = Mobile.getText(findTestObject('null'), 0)

'Verify XCP VIP 13.5GB Price'
Mobile.verifyEqual(xcpVIP13_5GB, 'IDR 60.775')

'Screenshot XCP VIP 13.5GB'
Mobile.takeScreenshot()

'Click on variant VIP 13.5GB'
Mobile.tap(findTestObject('null'), 0)

'Wait for PDP fully displayed'
Mobile.waitForElementPresent(findTestObject('null'), 0)

'Screenshot PDP Main Benefit'
Mobile.takeScreenshot()

'Click on Bonus Tab'
Mobile.tap(findTestObject('null'), 0)

'Click Activate with empty Mandatory Bonus'
Mobile.tap(findTestObject('null'), 0)

Mobile.delay(3)

'Coachmark handling'
if(Mobile.verifyElementExist(findTestObject('null'), 0)) {
	
	'Screenshot Coachmark'
	Mobile.takeScreenshot()
	
	'Click close X button'
	Mobile.tap(findTestObject('null'), 0)
	
	'Screenshot Coachmark Closed, Bonus empty still'
	Mobile.takeScreenshot()
	
	'Verify bluebox free bonus variant Tiktok 1.5GB'
	Mobile.verifyElementExist(findTestObject('null'), 0)

	Mobile.tap(findTestObject('null'), 0)
	
	'Screenshot Bonus Choosen'
	Mobile.takeScreenshot()
	
	'Verify bluebox free bonus variant Youtube 1.5GB'
	Mobile.verifyElementExist(findTestObject('null'), 0)
	
	Mobile.tap(findTestObject('null'), 0)
	
	'Screenshot Bonus Choosen'
	Mobile.takeScreenshot()
	
	'Verify bluebox free bonus variant Facebook 1.5GB'
	Mobile.verifyElementExist(findTestObject('null'), 0)
	
	Mobile.tap(findTestObject('null'), 0)
	
	'Screenshot Bonus Choosen'
	Mobile.takeScreenshot()
	
	'Click on See More Bonuses'
	Mobile.tap(findTestObject('null'), 0)
	
	'Screenshot Bonus Choosen (See More Bonuses)'
	Mobile.takeScreenshot()
	
	'Verify bluebox paid bonus variant Tiktok 3GB'
	Mobile.verifyElementExist(findTestObject('null'), 0)

	Mobile.tap(findTestObject('null'), 0)
	
	'Screenshot Bonus Choosen'
	Mobile.takeScreenshot()
	
	'Verify bluebox paid bonus variant Youtube 3GB'
	Mobile.verifyElementExist(findTestObject('null'), 0)
	
	Mobile.tap(findTestObject('null'), 0)
	
	'Screenshot Bonus Choosen'
	Mobile.takeScreenshot()
	
	'Verify bluebox paid bonus variant Facebook 3GB'
	Mobile.verifyElementExist(findTestObject('null'), 0)
	
	Mobile.tap(findTestObject('null'), 0)
	
	'Screenshot Bonus Choosen'
	Mobile.takeScreenshot()
	
	'Choose Free Bonus Tiktok 1.5GB'
	Mobile.tap(findTestObject('null'), 0)
	
	Mobile.pressBack()
	
	}

'Click Activate with Mandatory Bonus'
Mobile.tap(findTestObject('null'), 0)

'Wait PCP Loaded'
Mobile.waitForElementPresent(findTestObject('null'), 0)

'Screenshot Confirmation Page'
Mobile.takeScreenshot()

'Click on Arrow up to check Total Amount Detail'
Mobile.tap(findTestObject('null'), 0)

'Screenshot Detail half card'
Mobile.takeScreenshot()

'Click back'
Mobile.pressBack()

'Click on Pay Button'
Mobile.tap(findTestObject('null'), 0)

'Handling Loading Page'
if(Mobile.waitForElementPresent(findTestObject('null'), 0,FailureHandling.OPTIONAL)) {
	'Screenshot Loading bar'
	Mobile.takeScreenshot()
	
	'Click Back to Dashboard'
	Mobile.waitForElementPresent(findTestObject('null'), 0,)
}

'Handle Waiting Transaction Page'
if(Mobile.waitForElementPresent(findTestObject('null'), 0, FailureHandling.OPTIONAL)) {
	'Screenshot Waiting Transaction Page'
	Mobile.takeScreenshot()
	
	'Click on See My Package Button'
	Mobile.tap(findTestObject('null'), 0)
}

'Back to Dashboard'
Mobile.pressBack()

'Verify Dashboard'
Mobile.waitForElementPresent(findTestObject('null'), 0)

'Close App'
Mobile.pressBack()

'Open App'
Mobile.startExistingApplication("com.apps.MyXL")

'Wait Dashboard to Reload'
Mobile.waitForElementPresent(findTestObject('null'), 0)

'Handling Medalia'
if (Mobile.waitForElementPresent(findTestObject('null'), 0, FailureHandling.OPTIONAL)) {
	'Close Medalia'
	Mobile.tap(findTestObject('null'),0)
}


'Define Balance on Balance Card'
def balanceAfter = Mobile.getText(findTestObject('null'), 0, FailureHandling.STOP_ON_FAILURE)

'Verify current balance is IDR 59.473'
Mobile.verifyEqual(balanceAfter, 'IDR 59.473')

Mobile.closeApplication()