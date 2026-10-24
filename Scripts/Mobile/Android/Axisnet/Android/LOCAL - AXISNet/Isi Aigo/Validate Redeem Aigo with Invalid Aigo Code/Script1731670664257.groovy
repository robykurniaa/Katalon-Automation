import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.mobile.keyword.builtin.TakeScreenshotKeyword as TakeScreenshotKeyword
import com.kms.katalon.core.mobile.keyword.internal.MobileAbstractKeyword as MobileAbstractKeyword
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
import customKeywords.SwipeHelper as Swipe

'Login Axis Net'
Login.openExistingApp('083125750052', 'DT2022')

'Pop Up Handler'
Mobile.callTestCase(findTestCase('Test Cases/Mobile/LOCAL - AXISNet/Homepage handler/Press Back'), [:], FailureHandling.CONTINUE_ON_FAILURE)

'medallia handling'
Medallia.closeMedallia()

Screenshot.takeScreenshot('Homepage')

Screenshot.takeScreenshot('redeem used aigo')

'Find Quick Menu Suka - Suka'
def ObjQuickMenu = findTestObject('Mobile/Quick Menu/ObjQuickMenu - Isi Aigo')
Swipe.findQuickMenu(ObjQuickMenu)

Screenshot.takeScreenshot('redeem used aigo')

// Tap the mobile object 'Mobile/Redeem Aigo/ObjBtnAktifVoucher'
Mobile.tap(findTestObject('Mobile/Redeem Aigo/ObjBtnAktifVoucher'), 5)

Screenshot.takeScreenshot('redeem used aigo')

'pop up handling'
def popUpElement = findTestObject('Object Repository/Mobile/Redeem Aigo/ObjPopUp - Promo Paylater')

if (Mobile.verifyElementExist(popUpElement, 3, FailureHandling.OPTIONAL)) {
    // Element is present
    Mobile.pressBack()

    Mobile.delay(5)
} else {
    Mobile.setText(findTestObject('Mobile/Redeem Aigo/ObjFillAigoNumber'), GlobalVariable.UsedAigo, 5)
}

'Input Used Aigo Code'
def aigoSn = '0202121254548785'

Mobile.setText(findTestObject('Mobile/Redeem Aigo/ObjFillAigoNumber'), aigoSn, 5)

Screenshot.takeScreenshot('redeem used aigo')

Mobile.hideKeyboard()

'Tap Lanjut'
Mobile.tap(findTestObject('Mobile/Redeem Aigo/ObjBtnAigoNext'), 5)

Screenshot.takeScreenshot('redeem used aigo')

'Error Messasge'
def dialogMssg = findTestObject('Mobile/Redeem Aigo/ObjGetText - Invalid Aigo')
def expectedTransactionNumb = 'Yah, kodenya ga valid'
Mobile.verifyElementText(dialogMssg, expectedTransactionNumb)
Screenshot.takeScreenshotCheckpoint('Invalid Aigo Code')