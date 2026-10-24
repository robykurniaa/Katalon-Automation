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
import customKeywords.FindPackageKeywords as Scroll

String testCaseName = "Create Order Byop MCCM"

'Login Axis Net'
Login.openExistingApp('083827388378', 'DT2022')

'Pop Up Handling'
Mobile.callTestCase(findTestCase('Test Cases/Mobile/LOCAL - AXISNet/Homepage handler/Press Back'), [:], FailureHandling.CONTINUE_ON_FAILURE)

'medallia handling'
Medallia.closeMedallia()

Screenshot.takeScreenshot(testCaseName,'Homepage')

'Find Quick Menu Suka - Suka'
def ObjQuickMenu = findTestObject('Mobile/Byop/Byop Mass/OnjQuickMenu - BYOP')
SwipeHelper.findQuickMenu(ObjQuickMenu)
Screenshot.takeScreenshot(testCaseName,'Byop Information')

'Choose Custom Byop'
Mobile.tap(findTestObject('Mobile/Byop/ObjByop - Custom Byop'), 0)
Screenshot.takeScreenshot(testCaseName,'Byop 3Hr - Choose Byop 3 Hari')

'Find Byop MCCM'
def ribbonMccm = findTestObject('Mobile/Byop/Byop MCCM/ObjRibbonByop - Ribbon Terhemat')
for (int i = 1; i <= 4; i++) {
    // Tap on the option
    Mobile.tap(findTestObject('Mobile/Byop/Byop MCCM/ObjValidity - Option ' + i), 5)
    
    // Verify the element
    if (Mobile.verifyElementExist(ribbonMccm, 5, FailureHandling.OPTIONAL)) {
        // Tap on the element if it exists
        Mobile.tap(ribbonMccm, 5)
		Screenshot.takeScreenshot(testCaseName,'Byop MCCM - Select Byop MCCM')
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
Mobile.delay(2)
Mobile.tap(findTestObject('Mobile/Byop/Byop Mass/ObjBtnVideo - PILIH (3 hari) (1)'), 5)

'Choose Add on Index 1'
Mobile.tap(findTestObject('Mobile/Byop/Byop Mass/ObjChooseAddOn - Video 3hr 1Gb'), 5)
Screenshot.takeScreenshot(testCaseName,'Byop 3Hr - Choose Add on ')

Mobile.scrollToText('Tambahkan')
Screenshot.takeScreenshot(testCaseName,'Byop MCCM - Scroll down')

'Tap Tambahkan'
Mobile.tap(findTestObject('Mobile/Byop/Byop Mass/ObjBtn - Tambahkan'), 5)

'Tap Lanjut'
Mobile.tap(findTestObject('Mobile/Byop/Byop Mass/ObjBtn - Lanjut'), 5)
Screenshot.takeScreenshot(testCaseName,'Confirm page')

'Scroll Aktivasi'
Mobile.scrollToText('SEKARANG')
Screenshot.takeScreenshot(testCaseName,'Scroll Aktivasi')

'Tap Payment Method'
Mobile.tap(findTestObject('Mobile/Byop/ObjBtn - Byop Payment Method'), 0)
Screenshot.takeScreenshot(testCaseName,'Payment Method')

'Choose Payment'
def paymentMethod = findTestObject('Mobile/Purchase Paket - Journey/Paymen Method/ObjPaymentMethod - ShopeePay')

	// Verify object
	boolean isPaymentDetected = Mobile.verifyElementExist(paymentMethod, 3, FailureHandling.OPTIONAL)

	if (isPaymentDetected) {
		// if object is detected tap it
		Mobile.tap(paymentMethod, 3)
	} else {
		// if object not verify, swipe down
		Scroll.swipeDown()

		// Looping
		while (!isPaymentDetected) {
			isPaymentDetected = Mobile.verifyElementExist(paymentMethod, 3, FailureHandling.OPTIONAL)
			if (isPaymentDetected) {
				Mobile.tap(paymentMethod, 3)
				break
			} else {
				Scroll.swipeDown()
			}
		}
	}

Screenshot.takeScreenshot(testCaseName, 'Select Payment Method')

'Scroll Aktivasi'
Scroll.swipeDown()

'Tap Aktivasi'
Mobile.tap(findTestObject('Mobile/Byop/9.17/ObjBtn - Aktivasi Sekarang'), 0)
Screenshot.takeScreenshot(testCaseName,'Edit Package Name')

'Reject Edit Package Name'
Mobile.tap(findTestObject('Mobile/Byop/9.17/ObjBtn - Lain Kali (Edit Package Name)'), 0)

'Tap Aktivasi'
Mobile.tap(findTestObject('Mobile/Byop/9.17/ObjBtn - Aktivasi Sekarang'), 0)

'Validate Redirect to Multipayment'
Mobile.delay(15)
Screenshot.takeScreenshot(testCaseName,'Create Order Multipayment')