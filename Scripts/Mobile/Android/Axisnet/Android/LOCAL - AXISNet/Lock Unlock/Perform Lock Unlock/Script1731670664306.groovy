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

String testCaseName = "Perform Lock Unlock"

'Login Axis Net'
Login.openExistingApp('083891411050', 'DT2022')

'Pop Up Handler'
Mobile.callTestCase(findTestCase('Test Cases/Mobile/LOCAL - AXISNet/Homepage handler/Press Back'), [:], FailureHandling.CONTINUE_ON_FAILURE)

'medallia handling'
def myElement = findTestObject('Mobile/Notification/Medallia - Close Survey')

if (Mobile.verifyElementExist(myElement, 3,FailureHandling.OPTIONAL)) {
	// Element is present
	Mobile.tap(findTestObject('Mobile/Notification/Medallia - Close Survey'), 3)
	Mobile.comment('Element found and tapped')
} else {
	// Element is not present
}

'Tap Lock Unlock Page'
Mobile.tap(findTestObject('Mobile/Lock Unlock/LockUnlck'), 0)
Screenshot.takeScreenshot('Tap Lock Unlock Page')

'Verify the object "BtnSimpan" and wait for 2 seconds'
Mobile.waitForElementPresent(findTestObject('Mobile/Lock Unlock/BtnSimpan'), 2, FailureHandling.STOP_ON_FAILURE)
Mobile.delay(2)

'Tap the mobile object CheckBoxTelepon'
Mobile.tap(findTestObject('Mobile/Lock Unlock/ObjCheckBoxTelepon'), 0)
Screenshot.takeScreenshot('Telepon')

'Tap the mobile object CheckBoxSMS'
Mobile.tap(findTestObject('Mobile/Lock Unlock/ObjCheckBoxSms'), 0)
Screenshot.takeScreenshot('SMS')

'Tap the mobile object CheckBoxInet'
Mobile.tap(findTestObject('Mobile/Lock Unlock/ObjCheckBoxInet'), 0)
Screenshot.takeScreenshot('Internet')

'Tap the button BtnSimpan'
Mobile.tap(findTestObject('Mobile/Lock Unlock/ObjBtn - SIMPAN'), 0)

'Verify success Lock Unlock'
def MsgsuccessLockUnlock = findTestObject('Object Repository/Mobile/Lock Unlock/ObjMessage - Success Lock Unlock')
Mobile.waitForElementPresent(MsgsuccessLockUnlock, 0)
Screenshot.takeScreenshot('Success Lock Unlock')

