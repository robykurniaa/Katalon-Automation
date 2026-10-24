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
import customKeywords.ScreenshotKeywords as Screenshot
import customKeywords.ScreenshotKeywords as TestCase
import customKeywords.LoginKeywords as Login
import customKeywords.SwipeHelper

TestCase.setTestCaseName('Purchase Rabu Rawit using E-Wallet')

'Login Axis Net'
Login.openExistingApp('083827389321', 'ZXCV22')

'Pop Up Handler'
Mobile.callTestCase(findTestCase('Test Cases/Mobile/LOCAL - AXISNet/Homepage handler/Press Back'), [:], FailureHandling.CONTINUE_ON_FAILURE)

Screenshot.takeScreenshot('Purchase Rabu Rawit')

'medallia handling'
def myElement = findTestObject('Mobile/Notification/Medallia - Close Survey')

if (Mobile.verifyElementExist(myElement, 3, FailureHandling.OPTIONAL)) {
	// Element is present
	Mobile.tap(findTestObject('Mobile/Notification/Medallia - Close Survey'), 3)

	Mobile.comment('Element found and tapped') // Element is not present
} else {
	Mobile.delay(1)
}

'Tap Paket'
Screenshot.takeScreenshot('Rabu Rawit Multipayment - Homepage')
Mobile.tap(findTestObject('Mobile/TPR/Rabu Rawit/ObjBtn - Paket'), 0)
Screenshot.takeScreenshot('Tap Paket')

'get Text Kategori Paket'
Mobile.getText(findTestObject('Mobile/TPR/Rabu Rawit/ObjGetText - Pilih kategori paket'), 0)

'Tap Internet'
Mobile.tap(findTestObject('Mobile/TPR/Rabu Rawit/ObjBtnKtgri - Internet'), 0)
Screenshot.takeScreenshot('Tap Internet Tab')

'Get Text Rabu Rawit'
Mobile.waitForElementPresent(findTestObject('Mobile/TPR/Rabu Rawit/ObjGetText - Rabu Rawit'), 0)

'Choose Paket'
boolean rabuRawitObjectDetected = false

def rabuRawit30D = findTestObject('Mobile/TPR/Rabu Rawit/RabuRawitPaket - Rp30.500')

while (!(rabuRawitObjectDetected)) {
	try {
		// Detect the object
		rabuRawitObjectDetected = Mobile.verifyElementExist(rabuRawit30D, 3, FailureHandling.OPTIONAL)

		if (rabuRawitObjectDetected) {
			// Tap the object if detected
			Mobile.tap(rabuRawit30D, 3) // Swipe if the object is not detected
		} else {
			SwipeHelper.swipePaket()
		}
	}
	catch (Exception e) {
		// Handle any exceptions
		println('An error occurred: ' + e.message)
	}
}

Screenshot.takeScreenshot('Select Paket')


'Tap Aktifkan'
Mobile.tap(findTestObject('Mobile/Purchase Paket - Journey/ObjBtn - AKTIFKAN (PDP)'), 0)
Screenshot.takeScreenshot('Tap Aktifkan')

'Tap Lanjut'
Mobile.tap(findTestObject('Mobile/Purchase Paket - Journey/ObjBTN- LANJUT'), 0)
Screenshot.takeScreenshot('Tap Lanjut')

'Verify Confirm Page'
Mobile.waitForElementPresent(findTestObject('Mobile/Purchase Paket - Journey/ObjBtn - KONFIRMASI'), 0)

'Tap Payment Method'
Mobile.tap(findTestObject('Mobile/Purchase Paket - Journey/Paymen Method/ObjMethod - Payment Method'), 0)
Screenshot.takeScreenshot('Tap Payment Method')

'Select Payment Dana'
Mobile.scrollToText('DANA')
Mobile.tap(findTestObject('Mobile/Purchase Paket - Journey/Paymen Method/ObjPaymentMethod - DANA'), 0)
Screenshot.takeScreenshot('Select Payment Method')

'Tap Konfirmasi'
Mobile.tap(findTestObject('Mobile/Purchase Paket - Journey/ObjBtn - KONFIRMASI'), 0)
Mobile.delay(20)
Screenshot.takeScreenshot('Confirm')
