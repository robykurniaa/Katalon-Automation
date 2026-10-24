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
import customKeywords.LoginKeywords as Login
import customKeywords.SwipeHelper as SwipeHelper
import customKeywords.Activation as gifting
import customKeywords.FindPackageKeywords as Find

'Login Axis Net'
Login.openExistingApp('083110568390', 'DT2022')

'Pop Up Handler'
Mobile.callTestCase(findTestCase('Test Cases/Mobile/LOCAL - AXISNet/Homepage handler/Press Back'), [:], FailureHandling.CONTINUE_ON_FAILURE)

Screenshot.takeScreenshot('Purchase Jumat Baik')

'medallia handling'
def myElement = findTestObject('Mobile/Notification/Medallia - Close Survey')

if (Mobile.verifyElementExist(myElement, 3, FailureHandling.OPTIONAL)) {
    // Element is present
    Mobile.tap(findTestObject('Mobile/Notification/Medallia - Close Survey'), 3)

    Mobile.comment('Element found and tapped' // Element is not present
        )
} else {
}

Screenshot.takeScreenshot('Purchase Jumat Baik - Homepage')

'Tap Paket'
Mobile.tap(findTestObject('Mobile/TPR/Rabu Rawit/ObjBtn - Paket'), 0)
Screenshot.takeScreenshot('Jumat Baik - Paket')

'get Text Kategori Paket'
Mobile.getText(findTestObject('Mobile/TPR/Rabu Rawit/ObjGetText - Pilih kategori paket'), 0)

'Tap Internet'
Mobile.tap(findTestObject('Mobile/Purchase Paket - Journey/ObjBtnKtgri - Internet'), 0)

'Jumat Baik Tab'
def objJumbaTab = findTestObject('Mobile/TPR/Jumat Baik/ObjBtn - Jumat Baik Tab')
Find.findTab(objJumbaTab)
Screenshot.takeScreenshot('Jumat Baik - Jumat Baik Section')

'Choose Paket'
Mobile.tap(findTestObject('Mobile/TPR/Jumat Baik/ObjJumatBaikPaket - 7 Day'), 0)
Screenshot.takeScreenshot('Jumat Baik - PDP Jumat Baik')

'Tap Aktifkan'
Mobile.tap(findTestObject('Mobile/Purchase Paket - Journey/ObjBtn - AKTIFKAN (PDP)'), 0)
Screenshot.takeScreenshot('Jumat Baik - Tap Lanjut')

'Tap Lanjut'
gifting.isEligibleGifting()

'Tap Konfirmasi'
Mobile.tap(findTestObject('Mobile/Purchase Paket - Journey/ObjBtn - KONFIRMASI'), 0)

'verify redirect to sync page'
def successSyncPage = findTestObject('Mobile/Purchase Paket - Journey/ObjGetText- Transaksi kamu sedang diproses')

Mobile.delay(5)

Mobile.waitForElementPresent(successSyncPage, 3, FailureHandling.OPTIONAL)
Screenshot.takeScreenshot('Jumat Baik - Sync Page')

Mobile.delay(20)

'verify success receipt'
def successReceiptPage = findTestObject('Mobile/Purchase Paket - Journey/ObjGetText - Transaksi Berhasil')

if (Mobile.waitForElementPresent(successReceiptPage, 30, FailureHandling.OPTIONAL)) {
    // Element is present
	Screenshot.takeScreenshot('Jumat Baik - Receipt Success')
	
    Mobile.tap(findTestObject('Mobile/MCCM/ObjBtn - KE HOME'), 3)

	Screenshot.takeScreenshot('Jumat Baik - Hompepage after Purchase Jumat Baik')
} else {
}