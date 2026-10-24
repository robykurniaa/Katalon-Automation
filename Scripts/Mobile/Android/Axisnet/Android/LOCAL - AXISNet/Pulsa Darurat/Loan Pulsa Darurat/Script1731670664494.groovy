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
import customKeywords.SwipeHelper as Swipe
import customKeywords.LoginKeywords as Login
import customKeywords.MedalliaHandling as Medallia

Login.openExistingApp('083891411051', 'DT2022')

'Pop Up Handler'
Mobile.callTestCase(findTestCase('Test Cases/Mobile/LOCAL - AXISNet/Homepage handler/Press Back'), [:], FailureHandling.CONTINUE_ON_FAILURE)

'medallia handling'
Medallia.closeMedallia()

Screenshot.takeScreenshot('Loan Pulsa - Homepage')

'Find Quick Menu Pulsa Darurat'
def ObjQuickMenu = findTestObject('Mobile/Pulsa Darurat/ObjQuickMenu - Pulsa Darurat')
Swipe.findQuickMenu(ObjQuickMenu)

'Swipe'
Swipe.swipeQuickMenu()

Screenshot.takeScreenshot('Loan Pulsa - Landing Page ')
Mobile.delay(2)

Swipe.swipeQuickMenu()


'Tap button Gunakan Pulsa Darurat'
Mobile.tap(findTestObject('Object Repository/Mobile/Pulsa Darurat/ObjBtn - GUNAKAN PULSA DARURAT'), 0)
Screenshot.takeScreenshot('Loan Pulsa - Pulsa darurat information')

'Tap Button Pinjam'
Mobile.tap(findTestObject('Object Repository/Mobile/Pulsa Darurat/ObjBtn - PINJAM'), 5)
Screenshot.takeScreenshot('Loan Pulsa - List Pinjaman')
Mobile.swipe(443, 1253, 443, 1050)

'Select Pinjaman'
// Define the object paths
String baseObjectPath = 'Object Repository/Mobile/Pulsa Darurat/Pinjam - '

// Loop through the steps
for (int i = 1000; i <= 10000; i += 1000) {
    // Construct the full object path
    String objectPath = baseObjectPath + i
    
    // Check if the object exists
    if (Mobile.verifyElementExist(findTestObject(objectPath), 10,FailureHandling.OPTIONAL )) {
        // Get the text from the object
        String text = Mobile.getText(findTestObject(objectPath), 10)
        
        // Tap the object if it exists
        Mobile.tap(findTestObject(objectPath), 10)
        break
    } else {
        // Log the current step
        Mobile.comment("object not found")
    }
}


Screenshot.takeScreenshot('Loan Pulsa - Nominal')

'Tap lanjut'
Mobile.tap(findTestObject('Object Repository/Mobile/Pulsa Darurat/ObjBtn - LANJUT'), 3)

'Get Text'
Mobile.getText(findTestObject('Object Repository/Mobile/Pulsa Darurat/ObjGetText - Konfirmasi transaksi'), 5)
Screenshot.takeScreenshot('Loan Pulsa - Confirmation')

'Check Box in Cofirm page'
Mobile.tap(findTestObject('Object Repository/Mobile/Pulsa Darurat/ObjCheckBox'), 5)
Screenshot.takeScreenshot('Loan Pulsa - Check TnC')

'Tap Konfirmasi'
Mobile.tap(findTestObject('Object Repository/Mobile/Pulsa Darurat/ObjBtn - KONFIRMASI'), 0)


'verify redirect to progress page'
def progressPage = findTestObject('Mobile/Pulsa Darurat/ObjGetText- Terima Kasih')
Mobile.waitForElementPresent(progressPage, 0, FailureHandling.STOP_ON_FAILURE)
Screenshot.takeScreenshot('Loan Pulsa - Sucess Loan Pulsa')

Mobile.tap(findTestObject('Object Repository/Mobile/Pulsa Darurat/ObjBtn - KE HOME'), 0)
Mobile.delay(5)
Screenshot.takeScreenshot('Loan Pulsa - Homepage after loan')




