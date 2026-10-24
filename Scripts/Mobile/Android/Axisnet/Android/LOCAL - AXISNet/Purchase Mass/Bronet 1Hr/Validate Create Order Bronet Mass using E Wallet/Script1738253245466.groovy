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
import customKeywords.SwipeHelper as Swipe
import customKeywords.LoginKeywords as Login
import customKeywords.MedalliaHandling as Medallia
import customKeywords.Activation as gifting

String testCaseName = "Create Order Bronet Mass using Dana"
TestCase.setTestCaseName(testCaseName)

'Login Axis Net'
Login.openExistingApp('083827388378', 'DT2022')

'Pop Up Handler'
Mobile.callTestCase(findTestCase('Test Cases/Mobile/LOCAL - AXISNet/Homepage handler/Press Back'), [:], FailureHandling.CONTINUE_ON_FAILURE)

'medallia handling'
Medallia.closeMedallia()

Screenshot.takeScreenshot('Homepage')

'Tap Paket'
Mobile.tap(findTestObject('Mobile/Purchase Paket - Journey/ObjBtn - Paket'), 0)

'Verify Text Kategori Paket'
Mobile.getText(findTestObject('Mobile/Purchase Paket - Journey/ObjGetText - Pilih kategori paket'), 0)
Screenshot.takeScreenshot('Kategori Paket')

'Tap Internet'
Mobile.tap(findTestObject('Mobile/Purchase Paket - Journey/ObjBtnKtgri - Internet'), 0)

'Verify Text Kuota Internet'
Mobile.waitForElementPresent(findTestObject('Mobile/Purchase Paket - Journey/ObjGetText - Kuota Internet'), 0)

'Tap Bronet Tab'
Mobile.tap(findTestObject('Mobile/Bronet Mass/ObjInternetTab- Bronet'), 0)
Screenshot.takeScreenshot('Bronet Tab')

'choose paket'
def verifyObject = findTestObject('Mobile/Bronet Mass/ObjGetText - Bronet 1 Hari')

def tapObject = findTestObject('Mobile/Bronet Mass/ObjBronet1D - Option 1')

Swipe.verifyPackage(verifyObject, tapObject)

Screenshot.takeScreenshot('PDP')

'Tap Aktifkan'
Mobile.tap(findTestObject('Mobile/Purchase Paket - Journey/ObjBtn - AKTIFKAN (PDP)'), 0)

'Check Eligible Gifting'
gifting.isEligibleGifting()

'Tap Payment Method'
Mobile.tap(findTestObject('Mobile/Purchase Paket - Journey/Paymen Method/ObjMethod - Payment Method'), 0)

Screenshot.takeScreenshot('Jumat Baik - Payment Method')

'Select Payment Dana'
Mobile.scrollToText('Gopay')

Mobile.tap(findTestObject('Mobile/Purchase Paket - Journey/Paymen Method/ObjPaymentMethod- GOPAY'), 0)

Screenshot.takeScreenshot('Choose Multipayment')

'Tap Konfirmasi'
Mobile.tap(findTestObject('Mobile/Purchase Paket - Journey/ObjBtn - KONFIRMASI'), 0)

Mobile.delay(20)

Screenshot.takeScreenshot('Create Order')