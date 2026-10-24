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
import com.kms.katalon.core.util.internal.PathUtil as PathUtil
import customKeywords.ScreenshotKeywords as Screenshot
import customKeywords.SwipeHelper
import customKeywords.LoginKeywords as Login

'Login Axis Net'
Login.openExistingApp('083110568390', 'DT2022')

'Pop Up Handling'
Mobile.callTestCase(findTestCase('Test Cases/Mobile/LOCAL - AXISNet/Homepage handler/Press Back'), [:], FailureHandling.CONTINUE_ON_FAILURE)

'medallia handling'
def myElement = findTestObject('Mobile/Notification/Medallia - Close Survey')
if (Mobile.verifyElementExist(myElement, 3, FailureHandling.OPTIONAL)) {
	// Element is present
	Mobile.tap(findTestObject('Mobile/Notification/Medallia - Close Survey'), 3)

	Mobile.comment('Element found and tapped')
} else {
}
Screenshot.takeScreenshot('Homepage')

'Find Quick Menu Transfer Kuota'
def ObjQuickMenu = findTestObject('Mobile/Quick Menu/ObjQuickMenu - Transfer Quota')
SwipeHelper.findQuickMenu(ObjQuickMenu)

Screenshot.takeScreenshot('Transfer Kuota')

'Verify Kuota'
//Mobile.verifyElementExist(findTestObject('Mobile/Transfer Kuota/ObjListKuota - Index 1'), 0)

'Tap Check Box'
Screenshot.takeScreenshot('Check Box')

'Choose Transfer Amount'
Mobile.tap(findTestObject('Mobile/Transfer Kuota/ObjTransferAmount - 300.00 MB'), 0)
Screenshot.takeScreenshot('TF Amount')

'Input MSISDN'
def msisdnForTransfer = '083125750052'
Mobile.setText(findTestObject('Mobile/Transfer Kuota/ObjSetText- Nomor Handphone'), msisdnForTransfer, 0)
Screenshot.takeScreenshot('Input MSISDN')

'Tap Lanjut'
Mobile.tap(findTestObject('Mobile/Transfer Kuota/ObjBtn - LANJUT'), 0)


'Verify Confirm Page'
Mobile.verifyElementExist(findTestObject('Mobile/Transfer Kuota/ObjBtn - KONFIRMASI'), 0)
Screenshot.takeScreenshot('Confirm Page')

'Tap Konfirmasi'
Mobile.tap(findTestObject('Mobile/Transfer Kuota/ObjBtn - KONFIRMASI'), 0)
Screenshot.takeScreenshot('Tap Konfirmasi')

'Input OTP'
Mobile.tap(findTestObject('Mobile/Transfer Kuota/ObjInputOtp'), 0)
Mobile.delay(15)
Screenshot.takeScreenshot('Input OTP')
Mobile.hideKeyboard()
Mobile.tap(findTestObject('Mobile/Transfer Kuota/ObjBtn - LANJUT (OTP)'), 0)

'Wait For Receipt Success Page'
def receiptSuccess = findTestObject('Object Repository/Mobile/Transfer Kuota/ObjGetText - Transaksi Berhasil')
Mobile.waitForElementPresent(receiptSuccess,0)
Screenshot.takeScreenshot('Success TF Kuota')
Mobile.delay(10)
