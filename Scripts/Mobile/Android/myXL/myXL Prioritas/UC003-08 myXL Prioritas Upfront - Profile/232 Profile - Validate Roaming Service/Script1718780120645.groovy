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

'Open myXL'
Mobile.startApplication(GlobalVariable.APK, true)

'Verify CVP'
if (Mobile.waitForElementPresent(findTestObject('null'), 0)) {
	'Screenshot CVP'
	Mobile.takeScreenshot()
		
	'Click Continue on CVP'
	Mobile.tap(findTestObject('null'), 0)
}
			
'Screenshot Welcome Page'
Mobile.takeScreenshot()

'Click Login to myXL Button'
Mobile.tap(findTestObject('null'), 0)

Mobile.takeScreenshot()

'Click Sign in to myXL Button'
Mobile.tap(findTestObject('null'), 0)

Mobile.takeScreenshot()

'Click XL Prioritas Segment Button'
Mobile.tap(findTestObject('null'), 0)

'Screenshot Choose Login Segment Page'
Mobile.takeScreenshot()

'Verify Input Number Page'
Mobile.waitForElementPresent(findTestObject('null'), 0)

'Screenshot Input Number Page'
Mobile.takeScreenshot()

'Input XL Prio Paylater MSISDN'
Mobile.setText(findTestObject('null'), GlobalVariable.prioUpfrontNum, 0)

'Screenshot Input Number Page'
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

'Screenshot Dashboard'
Mobile.takeScreenshot()

'Tap Profile'
Mobile.tap(findTestObject('null'), 0)

Mobile.delay(4)

'Profile SS'
Mobile.takeScreenshot()

'Tap Roaming Service'
Mobile.tap(findTestObject('null'), 0)

Mobile.delay(4)

'Roaming Service SS'
Mobile.takeScreenshot()

//'Tap Switch'
//Mobile.tap(findTestObject('null'), 0)
//
//if(Mobile.waitForElementPresent(findTestObject('null'), 0)) {
//	'Switch is On, Turning Off'
//	Mobile.takeScreenshot()
//	
//	'Tap Yes Confirm'
//	Mobile.tap(findTestObject('null'), 0)
//	
//	'Yes Confirm SS'
//	Mobile.takeScreenshot()
//	
//	} else {
//		'Tap Switch On'
//		Mobile.tap(findTestObject('null'), 0)
//		
//		Mobile.delay(1)
//		
//		'Switch On SS'
//		Mobile.takeScreenshot()
//	}	

'Tap Booster International'
Mobile.tap(findTestObject('null'), 0)

Mobile.delay(4)

'Booster International SS'
Mobile.takeScreenshot()

'Tap Internasional Package'
Mobile.tap(findTestObject('null'), 0)

Mobile.delay(3)

'Internasional Package SS'
Mobile.takeScreenshot()

'Tap Prio Pass Package'
Mobile.tap(findTestObject('null'), 0)

Mobile.delay(1)

Mobile.takeScreenshot()

Mobile.scrollToText('PRIO PASS 1 Day')

Mobile.takeScreenshot()

Mobile.pressBack()

'Tap Internasional Package'
Mobile.tap(findTestObject('null'), 0)

Mobile.delay(2)

Mobile.takeScreenshot()

'Tap Umrah and Hajj Package'
Mobile.tap(findTestObject('null'), 0)

Mobile.delay(4)

Mobile.takeScreenshot()

Mobile.scrollToText('50 Minutes & 10 SMS')

'Umrah and Hajj Package SS'
Mobile.takeScreenshot()

Mobile.pressBack()
Mobile.pressBack()

'Tap Check Destination Country'
Mobile.tap(findTestObject('null'), 0)

Mobile.delay(2)

'Check Destination Country SS'
Mobile.takeScreenshot()

'Input Country'
Mobile.setText(findTestObject('null'), 'Swedia', 0)

Mobile.delay(3)

'Input Country ScreenShot'
Mobile.takeScreenshot()

'Tap Swedia'
Mobile.tap(findTestObject('null'), 0)

'Swedia ScreenShot'
Mobile.takeScreenshot()

'Tap PRIO PASS Tab'
Mobile.tap(findTestObject('null'), 0)

Mobile.delay(4)

'PRIO PASS Tab ScreenShot'
Mobile.takeScreenshot()

'Tap Basic Tariff Tab'
Mobile.tap(findTestObject('null'), 0)

Mobile.delay(2)

'Basic Tariff Tab ScreenShot'
Mobile.takeScreenshot()

Mobile.scrollToText('View Indonesian Embassy Info')

Mobile.takeScreenshot()

'Tap Embassy Info'
Mobile.tap(findTestObject('null'), 0)

Mobile.delay(2)

'Embassy Info ScreenShot'
Mobile.takeScreenshot()

//Mobile.closeApplication()
