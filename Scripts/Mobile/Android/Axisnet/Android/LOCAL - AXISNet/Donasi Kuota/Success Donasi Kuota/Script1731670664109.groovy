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
import customKeywords.SwipeHelper
import customKeywords.LoginKeywords as Login
import customKeywords.MedalliaHandling as Medallia

TestCase.setTestCaseName('Do Donasi Kuota')

'Login Axis Net'
Login.openExistingApp('083869516739', 'DT2022')

'Pop Up Handler'
Mobile.callTestCase(findTestCase('Test Cases/Mobile/LOCAL - AXISNet/Homepage handler/Press Back'), [:], FailureHandling.CONTINUE_ON_FAILURE)

'medallia handling'
Medallia.closeMedallia()

Screenshot.takeScreenshot('Homepage')

'Find Quick Menu Donasi Kuota'
def ObjQuickMenu = findTestObject('Mobile/Donasi Kuota/ObjQuickMenu - Donasi Quota')
SwipeHelper.findQuickMenu(ObjQuickMenu)
Screenshot.takeScreenshot(' Page Donasi Kuota')

'Scroll Text'
Mobile.delay(2)
Mobile.scrollToText('Sekarang')
Screenshot.takeScreenshot('Swipe Down')

'Tap Donasi'
Mobile.tap(findTestObject('Mobile/Donasi Kuota/Btn - DONASI'), 3)
Screenshot.takeScreenshot('Donasi Information')

'Tap Donasi Sekarang'
Mobile.tap(findTestObject('Mobile/Donasi Kuota/ObjBtn - Donasi Sekarang'), 3)

'Choose Kuota'
Mobile.tap(findTestObject('Mobile/Donasi Kuota/ObjRadioButton V2 - Choose Kuota'), 3)
Screenshot.takeScreenshot(' Choose Kuota')

'Btn Pilih Nominal Donasi'
Mobile.tap(findTestObject('Mobile/Donasi Kuota/ObjBtn V2 - PILIH NOMINAL DONASI'), 3)
Screenshot.takeScreenshot('Choose Denom')

'Choose Denom'
Mobile.tap(findTestObject('Mobile/Donasi Kuota/ObjChooseDenom - 150MB Denom'), 0)

'Wait Element'
Mobile.waitForElementPresent(findTestObject('Object Repository/Mobile/Donasi Kuota/ObjGetText - Konfirmasi'), 0)
Screenshot.takeScreenshot(' Confirmation page')

'Konfirmasi'
Mobile.tap(findTestObject('Mobile/Donasi Kuota/ObjBtn - KONFIRMASI'), 0)
Mobile.delay(2)

'Success Donasi Kuota'
Mobile.waitForElementPresent(findTestObject('Mobile/Donasi Kuota/ObjGetText - Success Donasi Kuota'), 5)
Screenshot.takeScreenshot('success donasi kuota')


