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
import customKeywords.MedalliaHandling as Medallia

'Login Axis Net'
Login.openExistingApp('083891411050', 'DT2022')

'Pop Up Handling'
Mobile.callTestCase(findTestCase('Test Cases/Mobile/LOCAL - AXISNet/Homepage handler/Press Back'), [:], FailureHandling.CONTINUE_ON_FAILURE)

'medallia handling'
Medallia.closeMedallia()

Screenshot.takeScreenshotCheckpoint('Byop MCCM -  Homepage')

'Find Quick Menu Suka - Suka'
def ObjQuickMenu = findTestObject('Mobile/Byop/Byop Mass/OnjQuickMenu - BYOP')
SwipeHelper.findQuickMenu(ObjQuickMenu)
Screenshot.takeScreenshotCheckpoint('Byop MCCM - Byop Information')

'Tap Buat Paket'
Mobile.tap(findTestObject('Mobile/Byop/Byop Mass/ObjBtn - Coba Buat paket'), 5)

'Tap Lewati'
Mobile.tap(findTestObject('Mobile/Byop/Byop Mass/ObjBtn - Lewati'), 5)

'Check Byop page'
Screenshot.takeScreenshotCheckpoint('Byop MCCM - Byop Page')

'Find Byop MCCM'
def ribbonMccm = findTestObject('Mobile/Byop/Byop MCCM/ObjRibbonByop - Ribbon Terhemat')
for (int i = 1; i <= 4; i++) {
	// Tap on the option
	Mobile.tap(findTestObject('Mobile/Byop/Byop MCCM/ObjValidity - Option ' + i), 10)
	
	// Verify the element
	if (Mobile.verifyElementExist(ribbonMccm, 10, FailureHandling.OPTIONAL)) {
		// Tap on the element if it exists
		Mobile.tap(ribbonMccm, 10)
		Screenshot.takeScreenshotCheckpoint('Byop MCCM - Select Byop MCCM')
		Mobile.scrollToText('Tambah')
		break
	} else {
		// Scroll to text if the element does not exist
		Mobile.scrollToText('sendiri')
	}
}

'Tap Tambah'
Mobile.tap(findTestObject('Mobile/Byop/Byop Mass/ObjBtn- Tambah Kuota Pelengkap'), 5)

'Tap Pilih'
Mobile.tap(findTestObject('Object Repository/Mobile/Byop/Byop Mass/ObjBtnVideo - PILIH (3 hari)'), 5)


'Choose Add on Index 1'
Mobile.tap(findTestObject('null'), 5)
Screenshot.takeScreenshotCheckpoint('Byop MCCM - Choose add on')

Mobile.scrollToText('Tambahkan')
Screenshot.takeScreenshotCheckpoint('Byop MCCM - Scroll down')

'Tap Tambahkan'
Mobile.tap(findTestObject('Mobile/Byop/Byop Mass/ObjBtn - Tambahkan'), 5)

'Tap Lanjut'
Mobile.tap(findTestObject('Mobile/Byop/Byop Mass/ObjBtn - Lanjut'), 5)

'Check Confirm page'
Mobile.waitForElementPresent(findTestObject('Mobile/Byop/Byop Mass/ObjGetText - Konfirmasi (Process)'), 5)
//Mobile.verifyElementExist('Mobile/Byop/ObjGetText - Byop Page')
Screenshot.takeScreenshotCheckpoint('Byop MCCM - Confirm page')

'Scroll Aktivasi'
Mobile.scrollToText('SEKARANG')
Screenshot.takeScreenshotCheckpoint('Byop MCCM - Scroll to aktivasi')

'Verify Insufficient Balance'
def validateBalance = findTestObject('Mobile/Byop/Byop Mass/ObjGetText - Saldo Tidak Mencukupi')
def expected = 'Saldo Tidak Mencukupi'
Mobile.verifyElementText(validateBalance, expected)
