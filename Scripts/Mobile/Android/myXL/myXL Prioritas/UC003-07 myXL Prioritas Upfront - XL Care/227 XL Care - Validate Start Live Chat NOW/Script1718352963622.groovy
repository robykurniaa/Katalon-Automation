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

'Tap XL Care Menu'
Mobile.tap(findTestObject('null'), 0)

'XL Care Menu SS'
Mobile.takeScreenshot()

'Tap Chat Maya'
Mobile.tap(findTestObject('null'), 0)

Mobile.delay(5)

'Chat Maya SS'
Mobile.takeScreenshot()

Mobile.delay(10)

//'Tap Informasi Paket'
//Mobile.tap(findTestObject('null'), 0)
//
//Mobile.delay(5)
//
//'Informasi Paket SS'
//Mobile.takeScreenshot()
//
//'Tap Cek Paket Saya'
//Mobile.tap(findTestObject('null'), 0)
//
//Mobile.delay(5)
//
//'Cek Paket Saya SS'
//Mobile.takeScreenshot()
//
//'Tap Lihat Plan'
//Mobile.tap(findTestObject('null'), 0)
//
//Mobile.delay(5)
//
//'Lihat Plan SS'
//Mobile.takeScreenshot()
//
//'Tap Domestik'
//Mobile.tap(findTestObject('null'), 0)
//
//Mobile.delay(5)
//
//'Domestik SS'
//Mobile.takeScreenshot()

//'Tap myXL'
//Mobile.tap(findTestObject('null'), 0)
//
//Mobile.delay(5)
//
//'myXL SS'
//Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prioritas Upfront/XL Care/227 XL Care - Validate Start Live Chat NOW/16 Validate myXL.png')
//
//'Tap Just Once'
//Mobile.tap(findTestObject('Object Repository/myXL Prio Upfront/XL Care/Just Once'), 0)
//
//Mobile.delay(10)
//
//'Quota Detail SS'
//Mobile.takeScreenshot()
//
//Mobile.delay(3)

Mobile.closeApplication()

//'Tap Isi Survey'
//Mobile.tap(findTestObject('null'), 0)
//
//'Selesai  Isi Survey SS'
//Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prioritas Upfront/XL Care/227 XL Care - Validate Start Live Chat NOW/17 Validate Selesai  Isi Survey.png')
//
//'Tap Ya'
//Mobile.tap(findTestObject('null'), 0)
//
//Mobile.delay(5)
//
//'Ya SS'
//Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prioritas Upfront/XL Care/227 XL Care - Validate Start Live Chat NOW/18 Validate Ya.png')
//
//'Tap 10 - Sangat mungkin'
//Mobile.tap(findTestObject('null'), 0)
//
//Mobile.delay(5)
//
//'10 - Sangat mungkin SS'
//Mobile.takeScreenshot('/Users/rizqimerdeka/Documents/Rizqi Merdeka/Automation myXL/Screenshot/myXL Prioritas Upfront/XL Care/227 XL Care - Validate Start Live Chat NOW/19 Validate 10 - Sangat mungkin.png')

