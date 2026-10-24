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

Mobile.startExistingApplication('com.axis.net')

/*
'Login Axis Net'
Login.loginToAxisNetApp('083827389321', 'ZXCV22')




'Pop Up Handler'
Mobile.callTestCase(findTestCase('Test Cases/Mobile/LOCAL - AXISNet/Homepage handler/Press Back'), [:], FailureHandling.CONTINUE_ON_FAILURE)

Screenshot.takeDynamicScreenshot('Purchase MCCM')
'medallia handling'
def myElement = findTestObject('Mobile/Notification/Medallia - Close Survey')

if (Mobile.verifyElementExist(myElement, 3, FailureHandling.OPTIONAL)) {
	// Element is present
	Mobile.tap(findTestObject('Mobile/Notification/Medallia - Close Survey'), 3)

	Mobile.comment('Element found and tapped') // Element is not present
} else {
	Mobile.delay(1)
}

'Tap Paket'
Mobile.tap(findTestObject('Mobile/MCCM/Beli Paket/ObjBtn - Paket'), 0)
Mobile.delay(1)
Screenshot.takeDynamicScreenshot('Purchase MCCM')
Mobile.delay(1)
*/
'Get Text Kategori Paket'
Mobile.waitForElementPresent(findTestObject('Mobile/MCCM/Beli Paket/ObjGetText - Pilih kategori paket'), 0)

'Tap Lifestyle'
Mobile.tap(findTestObject('Mobile/Purchase Paket - Journey/ObjBtnKtgri - Internet'), 0)

Mobile.delay(3)

'Swipe Paket'
TestObject startObject = findTestObject('Mobile/Bronet Mass/ObjInternetTab- Bronet')

// Perform the swipe using the custom keyword
Swipe.swipeTabPaket(startObject, 200, 300)

Mobile.selectListItemByIndex(findTestObject(null), 0, 0)

Mobile.verifyElementAttributeValue(findTestObject(null), '', '', 0)

