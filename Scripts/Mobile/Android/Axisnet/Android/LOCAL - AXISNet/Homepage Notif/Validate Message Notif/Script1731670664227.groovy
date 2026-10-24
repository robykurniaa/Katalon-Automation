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
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import customKeywords.SwipeHelper as SwipeHelper
import customKeywords.LoginKeywords as Login
import customKeywords.MedalliaHandling as Medallia

Login.openExistingApp('083110568297', 'DT2022')

'Pop Up Handler'
Mobile.callTestCase(findTestCase('Test Cases/Mobile/LOCAL - AXISNet/Homepage handler/Press Back'), [:], FailureHandling.CONTINUE_ON_FAILURE)

'Medallia Handling'
Medallia.closeMedallia()

'Tap Message Logo'
Mobile.tap(findTestObject('Mobile/Message Notification Homepage/ObjBtnMssge - Homepage Notif'), 0)

Mobile.waitForElementPresent(findTestObject('Mobile/Message Notification Homepage/android.widget.TextView - NOTIFIKASI'), 
    0)

Screenshot.takeScreenshot('Notifcation')

// Loop through index 1 to 5
for (int i = 1; i <= 5; i++) {
	// Construct the object path with the current index
	String objectPath = "Mobile/Message Notification Homepage/ObjDetailMssg - Index " + i
	
	// Verify if the object is present
	if (Mobile.verifyElementExist(findTestObject(objectPath), 5,FailureHandling.OPTIONAL )) {
		// Tap the object if it is present
		Mobile.tap(findTestObject(objectPath), 5)
		Screenshot.takeScreenshot('Detail Notifcation')
	} else {
		// Exit the loop if the object is not present
		break
	}
}

