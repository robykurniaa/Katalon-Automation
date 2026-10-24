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
import customKeywords.SwipeHelper as Swipe
import customKeywords.ScreenshotKeywords as Screenshot
import customKeywords.ScreenshotKeywords as TestCase
import customKeywords.LoginKeywords as Login
import customKeywords.MedalliaHandling as Medallia

TestCase.setTestCaseName("Purchase Byop 3 Day")

'Login Axis Net'
Login.openExistingApp('083869516739', 'DT2022')

'Pop Up Handling'
Mobile.callTestCase(findTestCase('Test Cases/Mobile/LOCAL - AXISNet/Homepage handler/Press Back'), [:], FailureHandling.CONTINUE_ON_FAILURE)

'medallia handling'
Medallia.closeMedallia()

Screenshot.takeScreenshot('Byop 3Hr - Homepage')

'Find Quick Menu Suka - Suka'
def ObjQuickMenu = findTestObject('Mobile/Byop/Byop Mass/OnjQuickMenu - BYOP')
Swipe.findQuickMenu(ObjQuickMenu)

Screenshot.takeScreenshot('Byop 3Hr - Tap Suka-Suka')

'Choose Custom Byop'
Mobile.tap(findTestObject('Mobile/Byop/ObjByop - Custom Byop'), 0)
Screenshot.takeScreenshot('Byop 3Hr - Choose Byop 3 Hari')

'Choose Byop 3 Hari'
Mobile.tap(findTestObject('Object Repository/Mobile/Byop/Byop Mass/ObjBtn - 3 Hari'), 0)
Screenshot.takeScreenshot('Byop 3Hr - Choose Byop 3 Hari')

'Choose paket index 1'
Mobile.tap(findTestObject('Mobile/Byop/Byop Mass/ObjChoosePaket - Byop Index 1'), 5)
Screenshot.takeScreenshot('Byop 3Hr - Choose paket index 1')

'Scroll to Tambah'
Mobile.scrollToText('Tambah')
Screenshot.takeScreenshot('Byop 3Hr - Scroll to Tambah')

'Tap Tambah'
Mobile.tap(findTestObject('Mobile/Byop/Byop Mass/ObjBtn- Tambah Kuota Pelengkap'), 5)

'Tap Pilih'
Mobile.delay(2)
Mobile.tap(findTestObject('Mobile/Byop/Byop Mass/ObjBtnVideo - PILIH (3 hari) (1)'), 5)

'Choose Add on Index 1'
Mobile.tap(findTestObject('Mobile/Byop/Byop Mass/ObjChooseAddOn - Video 3hr 1Gb'), 5)
Screenshot.takeScreenshot('Byop 3Hr - Choose Add on ')

'Scroll tambah'
Mobile.scrollToText('Tambahkan')

'Tap Tambahkan'
Mobile.tap(findTestObject('Mobile/Byop/Byop Mass/ObjBtn - Tambahkan'), 5)
Screenshot.takeScreenshot('Byop 3Hr -  Tambahkan')

'Tap Lanjut'
Mobile.tap(findTestObject('Mobile/Byop/Byop Mass/ObjBtn - Lanjut'), 5)

'Check Confirm page'
Mobile.waitForElementPresent(findTestObject('Mobile/Byop/Byop Mass/ObjGetText - Konfirmasi (Process)'), 5)
Mobile.delay(3)
Screenshot.takeScreenshot('Byop 3Hr -  Confirm page')

'Scroll Aktivasi'
Mobile.scrollToText('SEKARANG')
Screenshot.takeScreenshot('Byop 3Hr -  Scroll Aktivasi')

'Tap Aktivasi'
Mobile.tap(findTestObject('Mobile/Byop/9.17/ObjBtn - Aktivasi Sekarang'), 0)
Screenshot.takeScreenshot('Edit Package Name')

'Reject Edit Package Name'
Mobile.tap(findTestObject('Mobile/Byop/9.17/ObjBtn - Lain Kali (Edit Package Name)'), 0)

'Tap Aktivasi'
Mobile.tap(findTestObject('Mobile/Byop/9.17/ObjBtn - Aktivasi Sekarang'), 0)

'Verify Receipt Page'
def successReceiptTrx = findTestObject('Mobile/Byop/ObjGetText - Success Transaction')
def progressReceiptTrx = findTestObject('Mobile/Byop/Byop Mass/ObjGetText - Receipt Page')

'Check Progress Receipt'
if(Mobile.waitForElementPresent(progressReceiptTrx , 5, FailureHandling.OPTIONAL || 
	Mobile.waitForElementPresent(successReceiptTrx, 5, FailureHandling.OPTIONAL)))
	{
		Screenshot.takeScreenshot('Receipt Page')
	}


