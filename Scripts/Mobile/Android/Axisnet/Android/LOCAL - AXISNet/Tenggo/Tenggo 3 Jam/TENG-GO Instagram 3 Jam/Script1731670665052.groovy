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
import customKeywords.SwipeHelper as SwipeHelper
import customKeywords.ScreenshotKeywords as Screenshot
import customKeywords.LoginKeywords as Login
import com.kms.katalon.core.util.KeywordUtil
import customKeywords.MedalliaHandling as Medallia

String testCaseName = "Purchase Tenggo Instagram 3 Jam"
'Login Axis Net'
Login.openExistingApp('083110568297', 'DT2022')

'Pop Up Handling'
Mobile.callTestCase(findTestCase('Test Cases/Mobile/LOCAL - AXISNet/Homepage handler/Press Back'), [:], FailureHandling.CONTINUE_ON_FAILURE)

'medallia handling'
Medallia.closeMedallia()

Screenshot.takeScreenshot('Homepage')

'Find Quick Menu Tenggo'
def ObjQuickMenu = findTestObject('Mobile/Tenggo/ObjQuickMenu- Teng-Go')

SwipeHelper.findQuickMenu(ObjQuickMenu)

'Waiting to Tenggo Section'
Mobile.waitForElementPresent(findTestObject('Mobile/Tenggo/ObjGetText - Kuota TENG-GO'), 0)

Screenshot.takeScreenshot('Tenggo Tab')

'Find Tenggo Instagram'
boolean tenggoObjectDetected = false
int maxSwipes = 3
int swipeCount = 0
def tnggoIg3Hrs = findTestObject('Mobile/Tenggo/ObjPackage - TENG-GO Instagram 3 Jam')

while (!tenggoObjectDetected && swipeCount < maxSwipes) {
    try {
        // Detect the object
        tenggoObjectDetected = Mobile.verifyElementExist(tnggoIg3Hrs, 3, FailureHandling.OPTIONAL)

        if (tenggoObjectDetected) {
            // Tap the object if detected
            Mobile.tap(tnggoIg3Hrs, 3 // Swipe if the object is not detected
                )
        } else {
            SwipeHelper.swipeTenggoPaket()
			swipeCount++
        }
    }
    catch (Exception e) {
        // Handle any exceptions
        println('An error occurred: ' + e.message)
    } 
}

if (!tenggoObjectDetected) {
	// Fail the test case if the object is not found after max swipes
	KeywordUtil.markFailed("Element is not visible, test case failed.")
}


Screenshot.takeScreenshot('Tenggo Instagram')

'Tenggo Information Handling'
def tenggoInformation = findTestObject('Mobile/Tenggo/ObjGetText - Tenggo Informartion')

if (Mobile.waitForElementPresent(tenggoInformation, 10, FailureHandling.OPTIONAL)) {
    // Element is present
    Mobile.delay(2)

    Mobile.tap(findTestObject('Mobile/Tenggo/ObjBtn- OK, NGERTI'), 3)

    Mobile.comment('Element found and tapped' // Element is not present
        )
} else {
    Mobile.delay(2)
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
    Screenshot.takeScreenshot('Tenggo ig 3hr - Homepage after purchase tenggo')

    Mobile.comment('Element found and tapped')
} else {
    Mobile.delay(2)
}