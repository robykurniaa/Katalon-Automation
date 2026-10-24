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
import customKeywords.MedalliaHandling as Medallia
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import transactionKeywords.ReceiptHandling as Receipt

'Login Axis Net'
Login.openExistingApp('083827389321', 'ZXCV22')

'Pop Up Handler'
Mobile.callTestCase(findTestCase('Test Cases/Mobile/LOCAL - AXISNet/Homepage handler/Press Back'), [:], FailureHandling.CONTINUE_ON_FAILURE)

'medallia handling'
Medallia.closeMedallia()

Screenshot.takeDynamicScreenshot('MCCM Forever Online - Homepage')

'Tap Paket'
Mobile.tap(findTestObject('Mobile/Purchase Paket - Journey/ObjBtn - Paket'), 0)
Screenshot.takeScreenshot('MCCM FOrever Online - Kategori paket')

'get Text Kategori Paket'
Mobile.getText(findTestObject('Mobile/MCCM/Beli Paket/ObjGetText - Pilih kategori paket'), 0)

'Tap Internet Promo'
Mobile.tap(findTestObject('Mobile/MCCM/Beli Paket/ObjBtn - Internet Promo'), 0)

'get Text Kuota Rekomendasi'
Mobile.waitForElementPresent(findTestObject('Mobile/MCCM/Beli Paket/ObjGetText - Kuota Rekomendasi'), 0)

'Forever Online Tab'
Mobile.tap(findTestObject('Mobile/MCCM/Forever Online/ObjBtn - Forever Online Tab'), 0)
Screenshot.takeScreenshot('Forever Online Tab')

'Find Paket MCCM'
Mobile.tap(findTestObject('Mobile/MCCM/Forever Online/ForeverOnlinepaket - Index 1'), 0)

'Tap Aktifkan'
Mobile.tap(findTestObject('Mobile/MCCM/ObjBtn - AKTIFKAN'), 0)
Screenshot.takeScreenshot('Forever Online - PDP')

'tap lanjut'
Mobile.tap(findTestObject('Mobile/MCCM/ObjBTN- LANJUT'), 3)
Screenshot.takeScreenshot('Forever Online - Confirmation page')

'tap konfirmasi'
Mobile.waitForElementPresent(findTestObject('Mobile/MCCM/ObjGetText - Konfirmasi'), 0)

Mobile.tap(findTestObject('Object Repository/Mobile/MCCM/ObjBtn - KONFIRMASI'), 0)

'Check Insufficient Balance'
def objInsufBalance = findTestObject('Mobile/Purchase Paket - Journey/ObjGetText - Insufficient Balance')
Mobile.verifyElementNotExist(objInsufBalance, 1)

Receipt.getReceipt()