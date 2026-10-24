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
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import customKeywords.SwipeHelper
import customKeywords.ScreenshotKeywords as Screenshot
import customKeywords.ScreenshotKeywords as TestCaseName
import customKeywords.LoginKeywords as Login
import customKeywords.FindPackageKeywords as Swipe
import customKeywords.MedalliaHandling as Medallia

String testCaseName = "Success Logout"
TestCaseName.setTestCaseName(testCaseName)

Login.openExistingApp('083110568297', 'DT2022')

'Pop Up Handler'
Mobile.callTestCase(findTestCase('Test Cases/Mobile/LOCAL - AXISNet/Homepage handler/Press Back'), [:], FailureHandling.CONTINUE_ON_FAILURE)

'medallia handling'
Medallia.closeMedallia()

Screenshot.takeScreenshot('Homepage')

'Tap ALifetime'
Mobile.tap(findTestObject('Mobile/Alifetime/Objbtn - Alifetime'), 0)
Screenshot.takeScreenshot('Alifetime Page')

'Check Alifetime Information'
def alifetimeInformation = findTestObject('Mobile/Alifetime/ObjGetText - Alifetime Information')

if (Mobile.verifyElementExist(alifetimeInformation, 2,FailureHandling.OPTIONAL)) {
	// Element is present
	Mobile.pressBack()
	Mobile.delay(3)
} else {
	// Element is not present
	
}

'Check Pop Up'
def popUpElement = findTestObject('Mobile/Redeem Aigo/ObjPopUp - Promo Paylater')

if (Mobile.verifyElementExist(popUpElement, 3, FailureHandling.OPTIONAL)) {
	// Element is present
	Mobile.pressBack()
	Mobile.delay(5)
	
} else {
}

// Tap the mobile object "BtnSetting"
Mobile.tap(findTestObject('Mobile/Login/Logout/BtnSetting'), 0)

Mobile.delay(2)
Screenshot.takeScreenshot('Settings')

// Scroll down to the mobile object "BtnKeluar"
SwipeHelper.swipeDown()

Mobile.delay(1)


// Tap the mobile object "BtnKeluar"
Mobile.waitForElementPresent(findTestObject("Mobile/Login/Logout/ObjBtn - KELUAR"), 0)
Mobile.tap(findTestObject('Mobile/Login/Logout/ObjBtn - KELUAR'), 0)
Screenshot.takeScreenshot('Keluar')
Mobile.delay(1)

// Tap the mobile object with the locator "Object Repository/Mobile/Login/Logout/BtnTidak - Keluar"
Mobile.tap(findTestObject('Mobile/Login/Logout/BtnYa - Keluar'), 0)
Screenshot.takeScreenshot('Proceed')