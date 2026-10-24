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
Login.openExistingApp('083891411050', 'DT2022')

'Pop Up Handling'
Mobile.callTestCase(findTestCase('Test Cases/Mobile/LOCAL - AXISNet/Homepage handler/Press Back'), [:], FailureHandling.CONTINUE_ON_FAILURE)

'medallia handling'
def myElement = findTestObject('Mobile/Notification/Medallia - Close Survey')

if (Mobile.verifyElementExist(myElement, 3, FailureHandling.OPTIONAL)) {
    // Element is present
    Mobile.tap(findTestObject('Mobile/Notification/Medallia - Close Survey'), 3)

    Mobile.comment('Element found and tapped') // Element is not present
} else {
    Mobile.delay(1)
}

Screenshot.takeScreenshot('tenggo utama 3hr')

'Find Quick Menu Tenggo'
def ObjQuickMenu = findTestObject('Mobile/Tenggo/ObjQuickMenu- Teng-Go')
SwipeHelper.findQuickMenu(ObjQuickMenu)

Screenshot.takeScreenshot('tenggo utama 3hr')

'Waiting to Tenggo Section'
Mobile.waitForElementPresent(findTestObject('Mobile/Tenggo/ObjGetText - Kuota TENG-GO'), 0)
Screenshot.takeScreenshot('tenggo utama 3hr')

'Find Tenggo Kuota Utama 3 Jam'
boolean tenggoObjectDetected = false

def tnggoUtama3Hrs = findTestObject('Mobile/Tenggo/ObjPackage- TENG-GO Kuota Utama 3 Jam')

while (!(tenggoObjectDetected)) {
    try {
        // Detect the object
        tenggoObjectDetected = Mobile.verifyElementExist(tnggoUtama3Hrs, 3, FailureHandling.OPTIONAL)

        if (tenggoObjectDetected) {
            // Tap the object if detected
            Mobile.tap(tnggoUtama3Hrs, 3) // Swipe if the object is not detected
        } else {
           SwipeHelper.swipeTenggoPaket()
        }
    }
    catch (Exception e) {
        // Handle any exceptions
        println('An error occurred: ' + e.message)
    } 
}

Mobile.delay(1)
Screenshot.takeScreenshot('tenggo utama 3hr')
Mobile.delay(1)

'Tenggo Information Handling'
def tenggoInformation = findTestObject('Mobile/Tenggo/ObjGetText - Tenggo Informartion')

if (Mobile.waitForElementPresent(tenggoInformation, 3, FailureHandling.OPTIONAL)) {
    // Element is present
    Mobile.delay(1)

    Mobile.tap(findTestObject('Mobile/Tenggo/ObjBtn- OK, NGERTI'), 3)

    Mobile.comment('Element found and tapped') // Element is not present
} else {
    Mobile.delay(1)
}
Screenshot.takeScreenshot('Tenggo PDP')

'Tap Aktifkan'
Mobile.tap(findTestObject('Mobile/Tenggo/ObjBtn - AKTIFKAN'), 0)

Screenshot.takeScreenshot('Tap Aktifkan')

'tap lanjut'
Mobile.tap(findTestObject('Mobile/Purchase Paket - Journey/ObjBtn - Lanjut (Activation)'), 0)

Screenshot.takeScreenshot('Tenggo Ig 3hr - Confirmation page')

'tap konfirmasi'
Mobile.tap(findTestObject('Mobile/Purchase Paket - Journey/ObjBtn - KONFIRMASI'), 0)

'Check Insufficient Balance'
def objInsufBalance = findTestObject('Mobile/Purchase Paket - Journey/ObjGetText - Insufficient Balance')

Mobile.verifyElementNotExist(objInsufBalance, 2)

'verify redirect to sync page'
def successSyncPage = findTestObject('Mobile/Purchase Paket - Journey/ObjGetText- Transaksi kamu sedang diproses')

Mobile.waitForElementPresent(successSyncPage, 3, FailureHandling.OPTIONAL)

Screenshot.takeScreenshot('Tenggo ig 3hr - sync page')

'verify push notif'
def pushNotif = findTestObject('Mobile/Purchase Paket - Journey/ObjPushNotif - Callback Transaction')

if (Mobile.waitForElementPresent(pushNotif, 35, FailureHandling.OPTIONAL)) {
	// Element is present
	Screenshot.takeScreenshot('Tenggo ig 3hr - Push Notif')
} else {
}

'Pop up Handling'
def popUpSuccess = findTestObject('Mobile/Tenggo/ObjGetText - Yuk, langsung play kuota kamu')

if (Mobile.verifyElementExist(popUpSuccess, 20, FailureHandling.OPTIONAL)) {
	// Element is present
	Mobile.tap(findTestObject('Mobile/Tenggo/ObjBtn - OKE, MENGERTI'), 3)

	Mobile.delay(2)

	Screenshot.takeScreenshot('pop up tenggo')

	Mobile.comment('Element found and tapped')
} else {
	Mobile.delay(2)
}

'verify success receipt'
def successReceiptPage = findTestObject('Mobile/Purchase Paket - Journey/ObjGetText - Transaksi Berhasil')

if (Mobile.waitForElementPresent(successReceiptPage, 20, FailureHandling.OPTIONAL)) {
	// Element is present
	Screenshot.takeScreenshot('Tenggo ig 3hr - success receipt')

	Mobile.tap(findTestObject('Mobile/MCCM/ObjBtn - KE HOME'), 3)

	'Tap Home Button in receipt page'
	Screenshot.takeScreenshot('Tenggo utama 3hr - Homepage after purchase tenggo')

	Mobile.comment('Element found and tapped')
} else {
	Mobile.delay(2)
}