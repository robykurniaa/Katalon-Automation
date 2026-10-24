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

'Login Axis Net'
Login.openExistingApp('083827389321', 'ZXCV22')

'Pop Up Handler'
Mobile.callTestCase(findTestCase('Test Cases/Mobile/LOCAL - AXISNet/Homepage handler/Press Back'), [:], FailureHandling.CONTINUE_ON_FAILURE)

'medallia handling'
Medallia.closeMedallia()

Screenshot.takeScreenshot('Homepage')

Mobile.startExistingApplication('com.axis.net')

'Tap Alifetime'
Mobile.tap(findTestObject('Mobile/Alifetime/Objbtn - Alifetime'), 3)
Screenshot.takeScreenshot('Alifetime')

'press back alifetime page information'
Mobile.delay(2)
Mobile.pressBack()

'pop up handling'
def popUpElement = findTestObject('Object Repository/Mobile/Redeem Aigo/ObjPopUp - Promo Paylater')

if (Mobile.verifyElementExist(popUpElement, 5, FailureHandling.OPTIONAL)) {
	// Element is present
	Mobile.pressBack()
} else {
	
}

'Tap Axis Care'
Mobile.tap(findTestObject('Mobile/Axis Care/Tentang Axis/ObjBtn- CARE'), 0)
Screenshot.takeScreenshot('Axis Care')


'Tap Tentang Axis'
Mobile.tap(findTestObject('Mobile/Axis Care/Tentang Axis/ObjBtn - Tentang AXIS'), 0)

'Validate Tentang Axis Page'
Mobile.waitForElementPresent(findTestObject('Mobile/Axis Care/Tentang Axis/ObjGetText - Tentang Axis Page'),
	0)
Screenshot.takeScreenshot('Tentang Axis Page')

'Tap Instagram'
Mobile.tap(findTestObject('Mobile/Axis Care/Tentang Axis/ObjBtnSosmed - Youtube'), 0)

'Redirect to Social Media'
Mobile.delay(15)
Screenshot.takeScreenshot('Redirect to Youtube Axis')
