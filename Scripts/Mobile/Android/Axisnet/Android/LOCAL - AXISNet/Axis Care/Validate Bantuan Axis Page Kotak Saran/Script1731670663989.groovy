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
import customKeywords.MedalliaHandling as Medallia
import customKeywords.SwipeHelper as Swipe

//'Login Axis Net'
//Login.openExistingApp('083827389321', 'ZXCV22')
//
//'Pop Up Handler'
//Mobile.callTestCase(findTestCase('Test Cases/Mobile/LOCAL - AXISNet/Homepage handler/Press Back'), [:], FailureHandling.CONTINUE_ON_FAILURE)
//
//'medallia handling'
//Medallia.closeMedallia()
//
//Screenshot.takeScreenshot('Homepage')
//
//'Tap Alifetime'
//Mobile.tap(findTestObject('Mobile/Alifetime/Objbtn - Alifetime'), 3)
//Screenshot.takeScreenshot('Alifetime')
//
//'press back alifetime page information'
//Mobile.delay(2)
//Mobile.pressBack()
//
//'pop up handling'
//def popUpElement = findTestObject('Object Repository/Mobile/Redeem Aigo/ObjPopUp - Promo Paylater')
//
//if (Mobile.verifyElementExist(popUpElement, 5, FailureHandling.OPTIONAL)) {
//	// Element is present
//	Mobile.pressBack()
//} else {
//	
//}

Mobile.startExistingApplication('com.axis.net')
'Tap Axis Care'
Mobile.tap(findTestObject('Mobile/Axis Care/Tentang Axis/ObjBtn- CARE'), 0)
Screenshot.takeScreenshot('Axis Care')

'Tap Bantuan'
Mobile.tap(findTestObject('Mobile/Axis Care/Bantuan/ObjAxisCare - Bantuan'), 0)
Screenshot.takeScreenshot('Axis care - bantuan')

'Tab Button Berikan Saran'
Swipe.swipeDown()
Mobile.tap(findTestObject('Mobile/Axis Care/Bantuan/ObjBtn- Berikan Saran'), 0)

'Validate Kotak Saran Page'
Mobile.waitForElementPresent(findTestObject('Mobile/Axis Care/Bantuan/ObjGetText - KOTAK SARAN'),0)
Screenshot.takeScreenshot('Kotak Saran')

'Tap Subjek'
Mobile.tap(findTestObject('Mobile/Axis Care/Bantuan/ObjKotakSaran- Pilih subjek'), 0)

'Choose Subjek'
def subjek =findTestObject('Mobile/Axis Care/Bantuan/ObjSubjk - Saran Sinyal')

Mobile.tap(subjek, 0)

Screenshot.takeScreenshot('Choose Subjek Category')

'Fill Text Box Message'
Mobile.setText(findTestObject('Mobile/Axis Care/Bantuan/ObjTextBox - Tulis Pesan'), 'Sinyal nya mantap', 0)
Screenshot.takeScreenshot('Fill feedback message ')

'Tap Button Kirim'
Mobile.tap(findTestObject('Mobile/Axis Care/Bantuan/ObjBtn - Kirim Saran'), 0)

'Validate success submitted feedback'
def successSubmit =findTestObject('Mobile/Axis Care/Bantuan/ObjGetText - Success Submit Feedback')

if(Mobile.verifyElementExist(successSubmit, 0))
{
	Screenshot.takeScreenshot('success submit')
	
}
else {
	
}	