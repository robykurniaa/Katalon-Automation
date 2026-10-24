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
import customKeywords.SwipeHelper
import customKeywords.LoginKeywords as Login

'Login Axis Net'
Login.openExistingApp('083110568297', 'DT2022')

'Pop Up Handler'
Mobile.callTestCase(findTestCase('Test Cases/Mobile/LOCAL - AXISNet/Homepage handler/Press Back'), [:], FailureHandling.CONTINUE_ON_FAILURE)

'medallia handling'
def myElement = findTestObject('Mobile/Notification/Medallia - Close Survey')

if (Mobile.verifyElementExist(myElement, 3,FailureHandling.OPTIONAL)) {
    // Element is present
    Mobile.tap(findTestObject('Mobile/Notification/Medallia - Close Survey'), 3)

    Mobile.comment('Element found and tapped')
} else {
}

Screenshot.takeScreenshot('Isi Aigo - Homepage')

'Find Quick Menu Isi Aigo'
boolean isObjectDetected = false
def isiAigo = findTestObject('Mobile/Quick Menu/ObjQuickMenu - Isi Aigo')

while (!isObjectDetected) {
   try {
	   // Detect the object
	   isObjectDetected = Mobile.verifyElementExist(isiAigo, 3,FailureHandling.OPTIONAL )
	   
	   if (isObjectDetected) {
		   // Tap the object if detected
		   Mobile.tap(isiAigo, 3)
	   } else {
		   // Swipe if the object is not detected
		   SwipeHelper.swipeQuickMenu()
	   }
   } catch (Exception e) {
	   // Handle any exceptions
	   println("An error occurred: " + e.message)
   }
}

Screenshot.takeScreenshot('isi Aigo page')

// Tap the mobile object 'Mobile/Redeem Aigo/ObjBtnAktifVoucher'
Mobile.tap(findTestObject('Mobile/Redeem Aigo/ObjBtnAktifVoucher'), 5)
Screenshot.takeScreenshot('Isi Aigo - Aktifkan voucher')

'pop up handling'
def popUpElement = findTestObject('Mobile/Redeem Aigo/ObjPopUp - Promo Paylater')

if (Mobile.verifyElementExist(popUpElement, 3, FailureHandling.OPTIONAL)) {
	// Element is present
	Mobile.pressBack()
	Mobile.delay(2)
	
}

'Input Aigo HRN'
def aigoHrn = '3470282587809333'
Mobile.setText(findTestObject('Mobile/Redeem Aigo/ObjFillAigoNumber'), aigoHrn, 0)
Screenshot.takeScreenshot('Isi Aigo - Input HRN')

'Tap button Lanjut'
Mobile.tap(findTestObject('Mobile/Redeem Aigo/ObjBtnAigoNext'), 0)
Screenshot.takeScreenshot('Isi Aigo - Confirmation')

'Tap button redeem aigo'
Mobile.tap(findTestObject('Mobile/Redeem Aigo/ObjBtnConfirmRedeem'), 0)

'check receipt'
Mobile.delay(5)
Screenshot.takeScreenshot('Check receipt')