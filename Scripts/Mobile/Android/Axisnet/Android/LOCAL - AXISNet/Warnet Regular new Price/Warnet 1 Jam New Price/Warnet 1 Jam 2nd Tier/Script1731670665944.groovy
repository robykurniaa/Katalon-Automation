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
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.testobject.ConditionType
import customKeywords.ScreenshotKeywords as Screenshot
import customKeywords.LoginKeywords as Login
import customKeywords.SwipeHelper as Swipe
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import customKeywords.MedalliaHandling as Medallia
import customKeywords.MedalliaHandling as PopUp

'Login Axis Net'
Login.openExistingApp('083891411051', 'DT2022')

'Pop Up Handler'
Mobile.callTestCase(findTestCase('Test Cases/Mobile/LOCAL - AXISNet/Homepage handler/Press Back'), [:], FailureHandling.CONTINUE_ON_FAILURE)

'medallia handling'
Medallia.closeMedallia()

'Tap Paket'
Mobile.tap(findTestObject('Mobile/Purchase Paket - Journey/ObjBtn - Paket'), 0)

'get Text Kategori Paket'
Mobile.getText(findTestObject('Mobile/MCCM/Beli Paket/ObjGetText - Pilih kategori paket'), 0)

'Tap Internet'
Mobile.tap(findTestObject('Mobile/Purchase Paket - Journey/ObjBtnKtgri - Internet'), 0)


'Tap Warnet'
Mobile.tap(findTestObject('Mobile/Warnet/ObjBtn - Warnet Tab'), 0)

'Select Warnet Paket'
String warnetPrice = "Rp980"

// Create TestObject dynamically based on XPath
String xpath = "//android.widget.TextView[@resource-id='com.axis.net:id/discountedPriceTv' and @text='" + warnetPrice + "']"
TestObject warnetPkg = new TestObject()
warnetPkg.addProperty("xpath", ConditionType.EQUALS, xpath)

// Tap on the found element
Mobile.tap(warnetPkg, 10)

'Tap Aktifkan'
Mobile.tap(findTestObject('Mobile/Purchase Paket - Journey/ObjBtn - AKTIFKAN (PDP)'), 0)

'tap lanjut'
Mobile.tap(findTestObject('Mobile/Purchase Paket - Journey/ObjBTN- LANJUT'), 3)

'tap konfirmasi'
Mobile.waitForElementPresent(findTestObject('Mobile/Purchase Paket - Journey/ObjBtn - KONFIRMASI'), 0)
Mobile.tap(findTestObject('Mobile/Purchase Paket - Journey/ObjBtn - KONFIRMASI'), 0)

'Check Insufficient Balance'
def objInsufBalance = findTestObject('Mobile/Purchase Paket - Journey/ObjGetText - Insufficient Balance')

//Mobile.verifyElementNotExist(objInsufBalance, 3)

'verify redirect to sync page'
def successSyncPage = findTestObject('Mobile/Purchase Paket - Journey/ObjGetText- Transaksi kamu sedang diproses')

Mobile.waitForElementPresent(successSyncPage, 3, FailureHandling.OPTIONAL)
Screenshot.takeScreenshotCheckpoint('Purchase Lo Nasional - sync page')

'verify push notif'
def pushNotif = findTestObject('Mobile/Purchase Paket - Journey/ObjPushNotif - Callback Transaction')

if (Mobile.waitForElementPresent(pushNotif, 35, FailureHandling.OPTIONAL)) {
	// Element is present
	Screenshot.takeScreenshotCheckpoint('Purchase Lo Nasional - Push Notif')
} else {
}

'verify success receipt'
def successReceiptPage = findTestObject('Mobile/Purchase Paket - Journey/ObjGetText - Transaksi Berhasil')

if (Mobile.waitForElementPresent(successReceiptPage, 30, FailureHandling.OPTIONAL)) {
	// Element is present
	Screenshot.takeScreenshotCheckpoint('Purchase Lo Nasional - Receipt Success')

	Mobile.tap(findTestObject('Mobile/Purchase Paket - Journey/ObjBtn - KE HOME'), 3)
} else {
	Mobile.delay(1)
}