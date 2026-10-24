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
import customKeywords.SwipeHelper as SwipeHelper
import customKeywords.LoginKeywords as Login
import customKeywords.MedalliaHandling as Medallia

String testCaseName = "Check Aigo using SN Code"

'Login Axis Net'
Login.openExistingApp('083110568390', 'DT2022')

'Pop Up Handler'
Mobile.callTestCase(findTestCase('Test Cases/Mobile/LOCAL - AXISNet/Homepage handler/Press Back'), [:], FailureHandling.CONTINUE_ON_FAILURE)

'medallia handling'
Medallia.closeMedallia()

Screenshot.takeScreenshot('Homepage')


'Find Quick Menu Cek Aigo'
def ObjQuickMenu = findTestObject('Object Repository/Mobile/Cek Aigo/ObjQuickMenu - Cek AIGO')

SwipeHelper.findQuickMenu(ObjQuickMenu)

'wait element'
Mobile.waitForElementPresent(findTestObject('Mobile/Cek Aigo/ObjGetText - fresh cek kuota'), 5)

Screenshot.takeScreenshot('Cek Aigo Information')

'tap aktifkan voucher'
Mobile.tap(findTestObject('Object Repository/Mobile/Cek Aigo/ObjBtn - Aktifkan Voucher'), 3)

Screenshot.takeScreenshot('tap aktifkan voucher')

'pop up handling'
def popUpElement = findTestObject('Object Repository/Mobile/Redeem Aigo/ObjPopUp - Promo Paylater')

if (Mobile.verifyElementExist(popUpElement, 3, FailureHandling.OPTIONAL)) {
    // Element is present
    Mobile.pressBack()

    Mobile.delay(2)
}

'input SN Aigo'
def SnCode = '1086500000462657'
Mobile.setText(findTestObject('Object Repository/Mobile/Cek Aigo/ObjSetText - Fill SN Code'), SnCode, 0)

Screenshot.takeScreenshot('input SN Aigo')

'tap lanjut'
Mobile.tap(findTestObject('Object Repository/Mobile/Cek Aigo/ObjBtn - Lanjut (after input SN)'), 0)

'verify element'
Mobile.waitForElementPresent(findTestObject('Mobile/Cek Aigo/ObjBtnOk - pop up cek aigo'), 5)

Screenshot.takeScreenshot('tap aktifkan voucher')

