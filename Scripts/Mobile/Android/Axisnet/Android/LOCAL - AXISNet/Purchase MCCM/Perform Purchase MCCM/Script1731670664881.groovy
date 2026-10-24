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
import customKeywords.MedalliaHandling as Medallia
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository

String testCaseName = "Perform Purchase MCCM"
TestCase.setTestCaseName(testCaseName)

'Login Axis Net'
Login.openExistingApp('083110568297', 'DT2022')

'Pop Up Handler'
Mobile.callTestCase(findTestCase('Test Cases/Mobile/LOCAL - AXISNet/Homepage handler/Press Back'), [:], FailureHandling.CONTINUE_ON_FAILURE)

'medallia handling'
Medallia.closeMedallia()

Screenshot.takeScreenshot('Purchase MCCM - Homepage')

'Tap Paket'
Mobile.tap(findTestObject('Mobile/Purchase Paket - Journey/ObjBtn - Paket'), 0)

Screenshot.takeScreenshot('Kategori paket')

'get Text Kategori Paket'
Mobile.getText(findTestObject('Mobile/MCCM/Beli Paket/ObjGetText - Pilih kategori paket'), 0)

'Tap Internet Promo'
Mobile.tap(findTestObject('Mobile/MCCM/9.17/ObjBtn -  Internet Promo (MCCM)'), 0, FailureHandling.OPTIONAL)

Screenshot.takeScreenshot('MCCM Tab')

'get Text Kuota Rekomendasi'
Mobile.waitForElementPresent(findTestObject('Mobile/MCCM/Beli Paket/ObjGetText - Kuota Rekomendasi'), 0)

// Define the list of texts to verify
'Find Paket MCCM'
def textsToVerify = ['Masa aktif 1 hari','Masa aktif 2 hari', 
					 'Masa aktif 3 hari', 'Masa aktif 5 hari'
					 ]

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
/*
 * if (Mobile.verifyElementExist(findTestObject('Mobile/MCCM/Beli Paket/MccmPaket - Tercucok'), 10, FailureHandling.OPTIONAL)) {
	Mobile.tap(findTestObject('Mobile/MCCM/Beli Paket/MccmPaket - Tercucok'), 10) // Loop through options 1 to 6
	// Tap optional object if no valid option found
} else {
	boolean found = false

	for (int i = 1; i <= 6; i++) {
		TestObject option = findTestObject('Mobile/MCCM/Beli Paket/MccmPaket - Option ' + i)

		if (Mobile.verifyElementExist(option, 3, FailureHandling.OPTIONAL)) {
			String text = Mobile.getText(option, 3)

			if ((text.contains('Masa aktif 1 hari') || text.contains('Masa aktif 2 hari')) || text.contains('Masa aktif 3 hari')) {
				Mobile.tap(option, 3)

				found = true

				break
			}
		}
	}
	
	if (!(found)) {
		for (int i = 1; i <= 6; i++) {
			TestObject option = findTestObject('Mobile/MCCM/Beli Paket/MccmPaket - Option ' + i)

			if (Mobile.verifyElementExist(option, 2, FailureHandling.OPTIONAL)) {
				String text = Mobile.getText(option, 2)

				if (text.contains('Masa aktif 7 hari')) {
					Mobile.tap(option, 3)

					found = true

					break
				}
			}
		}
	}
	
	if (!(found)) {
		Mobile.tap(findTestObject('Mobile/MCCM/Beli Paket/ObjBtn - Bronet 1 Hr Tab'), 10)

		Mobile.tap(findTestObject('Mobile/MCCM/Beli Paket/MccmPaket - Bronet 1Hr (Opsional)'), 10)
	}
}
*/
'Tap Aktifkan'
Mobile.tap(findTestObject('Mobile/MCCM/ObjBtn - AKTIFKAN'), 0)

Screenshot.takeScreenshot('PDP')

'tap lanjut'
Mobile.tap(findTestObject('Mobile/MCCM/ObjBTN- LANJUT'), 3)

'tap konfirmasi'
//Mobile.waitForElementPresent(findTestObject('Mobile/MCCM/ObjGetText - Konfirmasi'), 0)

Screenshot.takeScreenshot('Confirmation page')

Mobile.tap(findTestObject('Object Repository/Mobile/MCCM/ObjBtn - KONFIRMASI'), 0)

'Check Insufficient Balance'
def objInsufBalance = findTestObject('Mobile/Purchase Paket - Journey/ObjGetText - Insufficient Balance')

Mobile.verifyElementNotExist(objInsufBalance, 1)

'verify redirect to sync page'
def successSyncPage = findTestObject('Mobile/Purchase Paket - Journey/ObjGetText- Transaksi kamu sedang diproses')

Mobile.waitForElementPresent(successSyncPage, 3, FailureHandling.OPTIONAL)

Screenshot.takeScreenshot('sync page')

'verify push notif'
def pushNotif = findTestObject('Mobile/Purchase Paket - Journey/ObjPushNotif - Callback Transaction')

if (Mobile.waitForElementPresent(pushNotif, 35, FailureHandling.OPTIONAL)) {
    // Element is present
    Screenshot.takeScreenshot('Push Notif')
} else {
}

'verify success receipt'
def successReceiptPage = findTestObject('Mobile/Purchase Paket - Journey/ObjGetText - Transaksi Berhasil')

if (Mobile.waitForElementPresent(successReceiptPage, 30, FailureHandling.OPTIONAL)) {
    // Element is present
    Screenshot.takeScreenshot('Receipt Success')

    Mobile.tap(findTestObject('Mobile/Purchase Paket - Journey/ObjBtn - KE HOME'), 3)

    Mobile.comment('Element found and tapped')
}