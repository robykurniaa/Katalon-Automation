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

String testCaseName = "Validate Boostr Weekend Onboarded"

'Login Axis Net'
Login.openExistingApp('083139842347', 'DT2022')

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
Screenshot.takeScreenshot(testCaseName,'Onboard Boostr Weekend Paket')
	
'Swipe'
for (int i = 0; i < 3; i++) {
	Swipe.swipeTenggoPaket()
	Screenshot.takeScreenshot(testCaseName,'Swipe Paket Boostr Weekend')
}

