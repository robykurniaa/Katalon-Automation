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

String testCaseName = "Create Order Paket Nonton using OVO"

//'Login Axis Net'
//Login.openExistingApp('083869517082', 'DT2022')
//
//'Pop Up Handler'
//Mobile.callTestCase(findTestCase('Test Cases/Mobile/LOCAL - AXISNet/Homepage handler/Press Back'), [:], FailureHandling.CONTINUE_ON_FAILURE)
//
//'medallia handling'
//Medallia.closeMedallia()
//
//Screenshot.takeScreenshot(testCaseName,'Paket Nonton - Homepage')
//
//'Tap Hiburan'
//Mobile.tap(findTestObject('Mobile/Entertainment/ObjBtn - Hiburan'), 0)
//
//'Verify Element Hiburan Page'
//Mobile.waitForElementPresent(findTestObject('Mobile/Game Token/ObjGetText - Hiburan'), 0)
//
//'Tap Paket Nonton'
//Mobile.tap(findTestObject('Mobile/Entertainment/Nonton/ObjBtn - Paket Nonton'), 0)
//Screenshot.takeScreenshot(testCaseName,'List Paket Nonton')
//
//'Swipe Down'
//Swipe.swipeDown()
//
//'Select Kategori Paket Nonton'
//def verifyObject = findTestObject('Mobile/Entertainment/Nonton/OjbBanner - Paket Nonton')
//
//def tapObject = findTestObject('Mobile/Entertainment/Nonton/OjbBanner - Paket Nonton')
//
//Swipe.verifyPackage(verifyObject, tapObject)
//
//Screenshot.takeScreenshot(testCaseName,'List kuota paket nonton')
//
//'Choose Paket'
//Mobile.tap(findTestObject('Mobile/Entertainment/Nonton/ObjPackage - Entertainmentr Package - Index 1'), 0)
//
//'Tap Lanjut'
//Mobile.tap(findTestObject('Object Repository/Mobile/Entertainment/Nonton/ObjBtn- LANJUT'), 0)
//
//'Tap Aktifkan'
//Screenshot.takeScreenshot(testCaseName,'Paket Nonton - PDP')
//Mobile.tap(findTestObject('Mobile/Purchase Paket - Journey/ObjBtn - AKTIFKAN (PDP)'), 0)
//
//'Check Eligible Gifting'
//gifting.isEligibleGifting()
//
//'Tap Payment Method'
//Mobile.tap(findTestObject('Mobile/Purchase Paket - Journey/Paymen Method/ObjMethod - Payment Method'), 0)
//
//Screenshot.takeScreenshot(testCaseName,'Payment Method')
//
//'Select Payment Dana'
//Mobile.scrollToText('OVO')
//
//Mobile.tap(findTestObject('Mobile/Purchase Paket - Journey/Paymen Method/ObjPaymentMethod - OVO'), 0)
//
//Screenshot.takeScreenshot(testCaseName,'Choose Multipayment')
//
//'Input OVO Number'
//Mobile.setText(findTestObject('Mobile/Purchase Paket - Journey/Paymen Method/ObjSetText - Fill Msisdn OVO'), '083125750052', 0)
//Screenshot.takeScreenshot(testCaseName,'Input OVO Number')

Mobile.startExistingApplication('com.axis.net')

'Tap Lanjut'
Mobile.tap(findTestObject('Mobile/Purchase Paket - Journey/Paymen Method/ObjBtn - Lanjut (OVO)'), 0)

'tap konfirmasi'
Mobile.waitForElementPresent(findTestObject('Mobile/Purchase Paket - Journey/ObjBtn - KONFIRMASI'), 0)

Mobile.tap(findTestObject('Mobile/Purchase Paket - Journey/ObjBtn - KONFIRMASI'), 0)
Mobile.delay(10)
Screenshot.takeScreenshot(testCaseName,'Redirect OVO')