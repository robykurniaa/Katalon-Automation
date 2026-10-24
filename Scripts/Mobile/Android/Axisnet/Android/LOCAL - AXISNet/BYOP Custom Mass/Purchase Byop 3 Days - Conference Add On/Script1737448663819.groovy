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
import customKeywords.SwipeHelper
import customKeywords.ScreenshotKeywords as Screenshot
import customKeywords.LoginKeywords as Login

'Login Axis Net'
Login.openExistingApp('083110568390', 'DT2022')

'Pop Up Handler'
Mobile.callTestCase(findTestCase('Test Cases/Mobile/LOCAL - AXISNet/Homepage handler/Press Back'), [:], FailureHandling.CONTINUE_ON_FAILURE)

'medallia handling'
def myElement = findTestObject('Mobile/Notification/Medallia - Close Survey')

if (Mobile.verifyElementExist(myElement, 3,FailureHandling.OPTIONAL)) {
	// Element is present
	Mobile.tap(findTestObject('Mobile/Notification/Medallia - Close Survey'), 3)
	Mobile.comment('Element found and tapped')
} else {
	// Element is not present
	Mobile.delay(1)
}

Mobile.delay(1)
Screenshot.takeDynamicScreenshot('Byop')
Mobile.delay(1)

'Find Quick Menu Suka - Suka'
def ObjQuickMenu = findTestObject('Mobile/Byop/Byop Mass/OnjQuickMenu - BYOP')
SwipeHelper.findQuickMenu(ObjQuickMenu)

Mobile.delay(3)
Screenshot.takeDynamicScreenshot('Byop')
Mobile.delay(1)

'Tap Buat Paket'
Mobile.tap(findTestObject('Object Repository/Mobile/Byop/Byop Mass/ObjBtn - Coba Buat paket'), 5)
Mobile.delay(1)
Screenshot.takeDynamicScreenshot('Byop')
Mobile.delay(1)

'Tap Lewati'
Mobile.tap(findTestObject('Object Repository/Mobile/Byop/Byop Mass/ObjBtn - Lewati'), 5)
Mobile.delay(1)
Screenshot.takeDynamicScreenshot('Byop')
Mobile.delay(1)

'Check Byop page'
Mobile.waitForElementPresent(findTestObject('Mobile/Byop/Byop Mass/ObjGetText - Byop Page'), 0)
//Mobile.verifyElementExist('Mobile/Byop/ObjGetText - Byop Page')
Mobile.delay(3)
Screenshot.takeDynamicScreenshot('Byop')
Mobile.delay(1)

'Choose Byop 3 Hari'
Mobile.tap(findTestObject('Object Repository/Mobile/Byop/Byop Mass/ObjBtn - 3 Hari'), 5)

'Choose paket index 1'
Mobile.tap(findTestObject('Mobile/Byop/Byop Mass/ObjChoosePaket - Byop Index 1'), 5)
Mobile.delay(1)
Screenshot.takeDynamicScreenshot('Byop')
Mobile.delay(1)

'Scroll to Tambah'
Mobile.scrollToText('Tambah')
Mobile.delay(1)
Screenshot.takeDynamicScreenshot('Byop')
Mobile.delay(1)

'Tap Tambah'
Mobile.tap(findTestObject('Mobile/Byop/Byop Mass/ObjBtn- Tambah Kuota Pelengkap'), 5)

'Scroll to Conference'
Mobile.scrollToText('Conference')
Mobile.delay(1)
Screenshot.takeDynamicScreenshot('Byop')
Mobile.delay(1)

'tap pilih conference'
Mobile.tap(findTestObject('Object Repository/Mobile/Byop/Byop Mass/ObjBtn - PILIH Conference'), 4)

'choose add on'
Mobile.tap(findTestObject('Object Repository/Mobile/Byop/Byop Mass/ObjSelectAddon - Conference index 1'), 4)
Mobile.delay(1)
Screenshot.takeDynamicScreenshot('Byop')
Mobile.delay(1)

Mobile.scrollToText('Tambahkan')
Mobile.delay(1)
Screenshot.takeDynamicScreenshot('Byop')
Mobile.delay(1)

'Tap Tambahkan'
Mobile.tap(findTestObject('Mobile/Byop/Byop Mass/ObjBtn - Tambahkan'), 5)
Mobile.delay(1)
Screenshot.takeDynamicScreenshot('Byop')
Mobile.delay(1)

'Tap Lanjut'
Mobile.tap(findTestObject('Mobile/Byop/Byop Mass/ObjBtn - Lanjut'), 5)

'Check Confirm page'
Mobile.waitForElementPresent(findTestObject('Mobile/Byop/Byop Mass/ObjGetText - Konfirmasi (Process)'), 5)
//Mobile.verifyElementExist('Mobile/Byop/ObjGetText - Byop Page')
Mobile.delay(5)
Screenshot.takeDynamicScreenshot('Byop')
Mobile.delay(1)

'Scroll Aktivasi'
Mobile.scrollToText('SEKARANG')

'Tap Aktivasi'
Mobile.tap(findTestObject('Object Repository/Mobile/Byop/Byop Mass/ObjBtn - AKTIVASI SEKARANG'), 0)
Mobile.delay(5)

'Verify Receipt Page'
Mobile.waitForElementPresent(findTestObject('Mobile/Byop/Byop Mass/ObjGetText - Receipt Page'), 0)
Mobile.delay(1)
Screenshot.takeDynamicScreenshot('Byop')
Mobile.delay(1)

'Tap Home'
Mobile.tap(findTestObject('Mobile/Byop/Byop Mass/ObjBtn- KE HOME'), 0)
Mobile.delay(1)
Screenshot.takeDynamicScreenshot('Byop')
Mobile.delay(1)