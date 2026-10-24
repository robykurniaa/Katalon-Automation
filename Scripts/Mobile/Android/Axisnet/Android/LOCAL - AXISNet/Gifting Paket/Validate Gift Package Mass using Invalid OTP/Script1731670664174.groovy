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


'Tap Internet'
Mobile.tap(findTestObject('Mobile/Purchase Paket - Journey/ObjBtnKtgri - Internet'), 0)
Screenshot.takeScreenshot('Bronet 1hr - Kategori paket')

'Tap Bronet Tab'
Mobile.tap(findTestObject('Mobile/Bronet Mass/ObjInternetTab- Bronet'), 0)

'Verify Text Kuota Internet'
Mobile.waitForElementPresent(findTestObject('Mobile/Purchase Paket - Journey/ObjGetText - Kuota Internet'), 0)
Screenshot.takeScreenshot('Bronet 1hr - Bronet Tab')

'choose paket'
def verifyObject = findTestObject('Mobile/Bronet Mass/ObjGetText - Bronet 1 Hari')
def tapObject = findTestObject('Mobile/Bronet Mass/ObjBronet1D - Option 1')
Swipe.verifyPackage(verifyObject, tapObject)

Screenshot.takeScreenshot('Choose Paket')

'Tap Aktifkan'
Mobile.tap(findTestObject('Mobile/Purchase Paket - Journey/ObjBtn - AKTIFKAN (PDP)'), 0)
Screenshot.takeScreenshot('PDP')

'Select for Gift'
Mobile.tap(findTestObject('Object Repository/Mobile/Gifting/ObjBtn - Orang Lain'), 0, FailureHandling.OPTIONAL)

'Input Msisdn for Gifting'
def textBoxMsisdn = findTestObject('Mobile/Gifting/SetMsisdnGifting - Xpath')

// Get the text from the text box
String textBoxValue = Mobile.getText(textBoxMsisdn, 2)

// Check if the text box contains text or is empty
if ((textBoxValue != null) && !(textBoxValue.isEmpty())) {
    // If the text box contains text, clear the text
    Mobile.clearText(textBoxMsisdn, 5)

    Mobile.setText(textBoxMsisdn, '083827388378', 2) // If the text box is empty, set new text
} else {
    Mobile.setText(textBoxMsisdn, '083827388378', 2)
}

Screenshot.takeScreenshot('Send Gift')

'tap lanjut'
Mobile.tap(findTestObject('Mobile/Purchase Paket - Journey/ObjBTN- LANJUT'), 3)

'tap konfirmasi'
Mobile.waitForElementPresent(findTestObject('Mobile/Purchase Paket - Journey/ObjBtn - KONFIRMASI'), 0)
Screenshot.takeScreenshot('tap konfirmasi')
Mobile.tap(findTestObject('Mobile/Purchase Paket - Journey/ObjBtn - KONFIRMASI'), 0)

'Check Insufficient Balance'
def objInsufBalance = findTestObject('Mobile/Purchase Paket - Journey/ObjGetText - Insufficient Balance')
Mobile.verifyElementNotExist(objInsufBalance, 1)

'Input OTP'
Mobile.setText(findTestObject('Mobile/Gifting/ObjInput - OTP'), 'mantap', 10)
Screenshot.takeScreenshot('Input OTP')

'Tap Lanjut'
Mobile.tap(findTestObject('Mobile/Gifting/ObjBtn - Lanjut (input OTP)'), 0)

'Check Message Invalid OTP'
def validateMessg = findTestObject('Mobile/Gifting/ObjGetText - Invalid OTP (Gifting)')
def expected = 'OTP Code not Matched'
Mobile.verifyElementText(validateMessg, expected)
Screenshot.takeScreenshot('Failed Gift Package - Invalid OTP')
