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
import customKeywords.ScreenshotKeywords as TestCase
import customKeywords.SwipeHelper
import customKeywords.LoginKeywords as Login
import customKeywords.MedalliaHandling as Medallia

TestCase.setTestCaseName('Validate History Coin Alifetime')

'Login Axis Net'
Login.openExistingApp('083110568297', 'DT2022')

'Pop Up Handler'
Mobile.callTestCase(findTestCase('Test Cases/Mobile/LOCAL - AXISNet/Homepage handler/Press Back'), [:], FailureHandling.CONTINUE_ON_FAILURE)

'medallia handling'
Medallia.closeMedallia()

Screenshot.takeScreenshot('Homepage')

'Tap Alifetime'
Mobile.tap(findTestObject('Mobile/Alifetime/Objbtn - Alifetime'), 3)
Screenshot.takeScreenshot('Alifetime')

'press back alifetime page information'
Mobile.delay(3)
Mobile.pressBack()
Mobile.delay(3)

'pop up handling'
def popUpElement = findTestObject('Object Repository/Mobile/Redeem Aigo/ObjPopUp - Promo Paylater')

if (Mobile.verifyElementExist(popUpElement, 3, FailureHandling.OPTIONAL)) {
	// Element is present
	Mobile.pressBack()
	Mobile.delay(5)
} else {
	
}

'Verify Element Alifetime Page'
Mobile.waitForElementPresent(findTestObject('Mobile/Alifetime/ObjGetText - Alifetime Page'), 0)
Screenshot.takeScreenshot('Emergency - Alifetime Page')

'Tap Detail History Coin'
Mobile.tap(findTestObject('Mobile/History Coin Alifetime/ObjBtnDetail - History Coin Btn'), 0)

'Verify Element Alifetime History Coin Page'
Mobile.waitForElementPresent(findTestObject('Mobile/History Coin Alifetime/ObjGetText - History Coin Page'), 0)
Screenshot.takeScreenshot('Alifetime Page History Coin')