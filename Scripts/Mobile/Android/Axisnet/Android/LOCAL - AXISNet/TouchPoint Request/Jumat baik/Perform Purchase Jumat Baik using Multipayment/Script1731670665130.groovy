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
import customKeywords.SwipeHelper as SwipeHelper
import customKeywords.Activation as gifting
import customKeywords.FindPackageKeywords as Find

String testCaseName = "Perform Purchase Jumat Baik when Insuff Balance"
TestCase.setTestCaseName(testCaseName)

'Login Axis Net'
Login.openExistingApp('083110568390', 'DT2022')

'Pop Up Handler'
Mobile.callTestCase(findTestCase('Test Cases/Mobile/LOCAL - AXISNet/Homepage handler/Press Back'), [:], FailureHandling.CONTINUE_ON_FAILURE)

'medallia handling'
def myElement = findTestObject('Mobile/Notification/Medallia - Close Survey')

if (Mobile.verifyElementExist(myElement, 3, FailureHandling.OPTIONAL)) {
    // Element is present
    Mobile.tap(findTestObject('Mobile/Notification/Medallia - Close Survey'), 3)

    Mobile.comment('Element found and tapped' // Element is not present
        )
}
Screenshot.takeScreenshot('Jumat Baik Multipayment - Homepage')

'Tap Paket'
Mobile.tap(findTestObject('Mobile/TPR/Rabu Rawit/ObjBtn - Paket'), 0)

Screenshot.takeScreenshot('Jumat Baik - Paket')

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

'Verify Confirm Page'

'Tap Payment Method'
Mobile.tap(findTestObject('Mobile/Purchase Paket - Journey/Paymen Method/ObjMethod - Payment Method'), 0)
Screenshot.takeScreenshot('Tap Payment Method')

'Select Payment'
Mobile.scrollToText('SHOPEEPAY')
Mobile.tap(findTestObject('Mobile/Purchase Paket - Journey/Paymen Method/ObjPaymentMethod - ShopeePay'), 0)
Screenshot.takeScreenshot('Select Payment Method')

'Tap Konfirmasi'
Mobile.tap(findTestObject('Mobile/Purchase Paket - Journey/ObjBtn - KONFIRMASI'), 0)
Mobile.delay(20)
Screenshot.takeScreenshot('Confirm')