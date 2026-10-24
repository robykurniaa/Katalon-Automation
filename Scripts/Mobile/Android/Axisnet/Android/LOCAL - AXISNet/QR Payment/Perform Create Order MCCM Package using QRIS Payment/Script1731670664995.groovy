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
import customKeywords.SwipeHelper as Swipe
import customKeywords.LoginKeywords as Login
import customKeywords.MedalliaHandling as Medallia
import transactionKeywords.ReceiptHandling as Receipt

'Login Axis Net'
Login.openExistingApp('083827389321', 'ZXCV22')

'Pop Up Handler'
Mobile.callTestCase(findTestCase('Test Cases/Mobile/LOCAL - AXISNet/Homepage handler/Press Back'), [:], FailureHandling.CONTINUE_ON_FAILURE)

'medallia handling'
Medallia.closeMedallia()

Screenshot.takeScreenshot('Purchase Bronet 1Hr - Homepage')

'Tap Paket'
Mobile.tap(findTestObject('Mobile/Purchase Paket - Journey/ObjBtn - Paket'), 0)
Screenshot.takeScreenshot('Tap Paket')

'Verify Text Kategori Paket'
Mobile.getText(findTestObject('Mobile/Purchase Paket - Journey/ObjGetText - Pilih kategori paket'), 0)

'Tap Internet Promo'
Mobile.tap(findTestObject('Mobile/MCCM/Beli Paket/ObjBtn - Internet Promo'), 0)

Screenshot.takeScreenshotCheckpoint('Purchase MCCM - MCCM Tab')

'get Text Kuota Rekomendasi'
Mobile.waitForElementPresent(findTestObject('Mobile/MCCM/Beli Paket/ObjGetText - Kuota Rekomendasi'), 0)

// Define the list of texts to verify
'Find Paket MCCM'
def textsToVerify = ['Masa aktif 1 hari', 'Masa aktif 3 hari', 'Masa aktif 5 hari', 'Masa aktif 30 hari']

// Loop through options 1 to 6
for (int i = 1; i <= 6; i++) {
	// Construct the object path dynamically
	def objectPath = 'Mobile/MCCM/List Paket/MccmPaket - Option ' + i

	// Get the text of the current option
	def optionText = Mobile.getText(findTestObject(objectPath), 5, FailureHandling.OPTIONAL)

	// Check if the text matches any of the texts to verify
	if (textsToVerify.contains(optionText)) {
		// Tap the object if the text matches
		Mobile.tap(findTestObject(objectPath), 5, FailureHandling.OPTIONAL)

		textFound = true
		break
	}
}

'Tap Aktifkan'
Mobile.tap(findTestObject('Mobile/Purchase Paket - Journey/ObjBtn - AKTIFKAN (PDP)'), 0)
Screenshot.takeScreenshot('PDP')

'tap lanjut'
Mobile.tap(findTestObject('Mobile/Purchase Paket - Journey/ObjBTN- LANJUT'), 3)

'Tap Payment Method'
Mobile.tap(findTestObject('Mobile/Purchase Paket - Journey/Paymen Method/ObjMethod - Payment Method'), 0)

'Find Payment'
Mobile.scrollToText('QRIS')
Screenshot.takeScreenshot('Payment Method')

'Choose QR Payment'
Mobile.tap(findTestObject('Object Repository/Mobile/Qris Payment/ObjBtn- QRIS Payment'), 0)

'tap konfirmasi'
Mobile.waitForElementPresent(findTestObject('Mobile/Purchase Paket - Journey/ObjBtn - KONFIRMASI'), 0)
Mobile.tap(findTestObject('Mobile/Purchase Paket - Journey/ObjBtn - KONFIRMASI'), 0)

'Validate QR Code'
def validateMessg = findTestObject('Mobile/Qris Payment/ObjGetTextQrCode - Selesaikan Pembayaran')
def expected = 'Selesaikan Pembayaran'
Mobile.verifyElementText(validateMessg, expected)
Screenshot.takeScreenshot('Create Order QR Code')