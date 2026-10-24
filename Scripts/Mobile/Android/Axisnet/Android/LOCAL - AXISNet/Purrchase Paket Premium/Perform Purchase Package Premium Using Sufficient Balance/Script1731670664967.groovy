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
import customKeywords.Activation as gifting

'Login Axis Net'
Login.openExistingApp('083110568390', 'DT2022')

'Pop Up Handler'
Mobile.callTestCase(findTestCase('Test Cases/Mobile/LOCAL - AXISNet/Homepage handler/Press Back'), [:], FailureHandling.CONTINUE_ON_FAILURE)

'medallia handling'
Medallia.closeMedallia()

Screenshot.takeScreenshot('Paket Premium - Homepage')

'Tap Hiburan'
Mobile.tap(findTestObject('Mobile/Entertainment/ObjBtn - Hiburan'), 0)

'Verify Element Hiburan Page'
Mobile.waitForElementPresent(findTestObject('Mobile/Game Token/ObjGetText - Hiburan'), 0)

'Tap Paket Premium'
Mobile.tap(findTestObject('Mobile/Entertainment/Premium/ObjBtn - Paket Premium'), 0)

Screenshot.takeScreenshot('List paket premium')

'Select Kategori Paket Premium'
def verifyObject = findTestObject('Mobile/Entertainment/Premium/ObjBannerPkgPremium - Muslim Pro')

def tapObject = findTestObject('Mobile/Entertainment/Premium/ObjBannerPkgPremium - Muslim Pro')

Swipe.verifyPackage(verifyObject, tapObject)

Screenshot.takeScreenshot('List kuota paket premium')

'Choose Paket'
Mobile.tap(findTestObject('Mobile/Entertainment/Nonton/ObjSushirollPkg - Index 1'), 0)

'Tap Lanjut'
Mobile.tap(findTestObject('Object Repository/Mobile/Entertainment/Nonton/ObjBtn- LANJUT'), 0)

'Tap Aktifkan'
Screenshot.takeScreenshot('Paket Nonton - PDP')
Mobile.tap(findTestObject('Mobile/Purchase Paket - Journey/ObjBtn - AKTIFKAN (PDP)'), 0)

'Check Eligible Gifting'
gifting.isEligibleGifting()

'tap konfirmasi'
Mobile.waitForElementPresent(findTestObject('Mobile/Purchase Paket - Journey/ObjBtn - KONFIRMASI'), 0)

Mobile.tap(findTestObject('Mobile/Purchase Paket - Journey/ObjBtn - KONFIRMASI'), 0)

'Check Insufficient Balance'
def objInsufBalance = findTestObject('Mobile/Purchase Paket - Journey/ObjGetText - Insufficient Balance')

//Mobile.verifyElementNotExist(objInsufBalance, 3)

'verify redirect to sync page'
def successSyncPage = findTestObject('Mobile/Purchase Paket - Journey/ObjGetText- Transaksi kamu sedang diproses')

Mobile.waitForElementPresent(successSyncPage, 3, FailureHandling.OPTIONAL)
Screenshot.takeScreenshot('Paket Nonton - sync page')

'verify push notif'
def pushNotif = findTestObject('Mobile/Purchase Paket - Journey/ObjPushNotif - Callback Transaction')

if (Mobile.waitForElementPresent(pushNotif, 35, FailureHandling.OPTIONAL)) {
	// Element is present
	Screenshot.takeScreenshot('Paket Nonton - Push Notif')
} else {
}

'verify success receipt'
def successReceiptPage = findTestObject('Mobile/Purchase Paket - Journey/ObjGetText - Transaksi Berhasil')

if (Mobile.waitForElementPresent(successReceiptPage, 30, FailureHandling.OPTIONAL)) {
	// Element is present
	Screenshot.takeScreenshot('Paket Nonton - Receipt Success')

	Mobile.tap(findTestObject('Mobile/Purchase Paket - Journey/ObjBtn - KE HOME'), 3)

	Mobile.comment('Element found and tapped')
} else {
	Mobile.delay(1)
}