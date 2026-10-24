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
import customKeywords.LoginKeywords as Login
import customKeywords.SwipeHelper as Swipe
import com.kms.katalon.core.util.KeywordUtil
import transactionKeywords.ReceiptHandling as Receipt

String testCaseName = "Perform Purchase Boostr Weekend"

'Login Axis Net'
Login.openExistingApp('083110568390', 'DT2022')

'Pop Up Handler'
Mobile.callTestCase(findTestCase('Test Cases/Mobile/LOCAL - AXISNet/Homepage handler/Press Back'), [:], FailureHandling.CONTINUE_ON_FAILURE)

'medallia handling'
def myElement = findTestObject('Mobile/Notification/Medallia - Close Survey')

if (Mobile.verifyElementExist(myElement, 3, FailureHandling.OPTIONAL)) {
    // Element is present
    Mobile.tap(findTestObject('Mobile/Notification/Medallia - Close Survey'), 3)

    Mobile.comment('Element found and tapped' // Element is not present
        )
} else {
}

Screenshot.takeScreenshot(testCaseName,'Homepage')

'Tap Paket'
Mobile.tap(findTestObject('Mobile/Purchase Paket - Journey/ObjBtn - Paket'), 0)

'get Text Kategori Paket'
Mobile.getText(findTestObject('Mobile/MCCM/Beli Paket/ObjGetText - Pilih kategori paket'), 0)

Screenshot.takeScreenshot(testCaseName,'Kategori Paket')

'Tap Internet'
Mobile.tap(findTestObject('Mobile/Purchase Paket - Journey/ObjBtnKtgri - Internet'), 0)

'Verify Boostr Weekend Tab'
Mobile.waitForElementPresent(findTestObject('Mobile/TPR/Boostr Weekend/ObjGetText- BOOSTR WEEKEND'), 0)

Screenshot.takeScreenshot(testCaseName,'Tab Boostr Weekend')

'Choose Paket'
def boostrPaket = findTestObject('Mobile/TPR/Boostr Weekend/BoostrWeeknPkt - BOOSTR 1GB 1hr')

boolean isObjectDetected = false
int maxSwipes = 3
int swipeCount = 0

while (!isObjectDetected && swipeCount < maxSwipes) {
    try {
        // Detect the object
        isObjectDetected = Mobile.verifyElementExist(boostrPaket, 3, FailureHandling.OPTIONAL)

        if (isObjectDetected) {
            // Tap the object if detected
            Mobile.tap(boostrPaket, 3) 

            Screenshot.takeScreenshot(testCaseName,'PDP Boostr Weekend')
        } else {
            Swipe.swipePaket() // Swipe if the object is not detected
			swipeCount++
        }
    }
    catch (Exception e) {
        // Handle any exceptions
        println('An error occurred: ' + e.message)
    } 
}

if (!isObjectDetected) {
	// Fail the test case if the object is not found after max swipes
	 KeywordUtil.markFailed("Element is not visible, test case failed.")
}


'Tap Aktifkan'
Mobile.tap(findTestObject('Mobile/Purchase Paket - Journey/ObjBtn - AKTIFKAN (PDP)'), 0)

Screenshot.takeScreenshot(testCaseName,'Konfirmasi')

'tap lanjut'
Mobile.tap(findTestObject('Mobile/Purchase Paket - Journey/ObjBTN- LANJUT'), 3)

'tap konfirmasi'
//Mobile.waitForElementPresent(findTestObject('Mobile/Purchase Paket - Journey/ObjBtn - KONFIRMASI'), 0)
Screenshot.takeScreenshot(testCaseName,'tap konfirmasi')
Mobile.tap(findTestObject('Mobile/Purchase Paket - Journey/ObjBtn - KONFIRMASI'), 0)

'Check Insufficient Balance'
def objInsufBalance = findTestObject('Mobile/Purchase Paket - Journey/ObjGetText - Insufficient Balance')
Mobile.verifyElementNotExist(objInsufBalance, 1)

'Check Receipt'
Receipt.validateReceipt(testCaseName)