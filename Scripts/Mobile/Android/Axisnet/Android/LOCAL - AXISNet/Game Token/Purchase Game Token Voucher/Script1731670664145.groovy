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
import com.kms.katalon.core.util.KeywordUtil
import customKeywords.ScreenshotKeywords as Screenshot
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import customKeywords.SwipeHelper as SwipeHelper
import customKeywords.LoginKeywords as Login
import customKeywords.MedalliaHandling as Medallia

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.testobject.ConditionType

String testCaseName = "Purchase Game Token Voucher"
'Login Axis Net'
Login.openExistingApp('083110568390', 'DT2022')

'Pop Up Handler'
Mobile.callTestCase(findTestCase('Test Cases/Mobile/LOCAL - AXISNet/Homepage handler/Press Back'), [:], FailureHandling.CONTINUE_ON_FAILURE)

'medallia handling'
Medallia.closeMedallia()

Screenshot.takeScreenshot(testCaseName,'Homepage')

Mobile.tap(findTestObject('Object Repository/Mobile/Unlimited Gaming/ObjFooter- Hiburan'), 3)

'Verify Element Hiburan Page'
Mobile.waitForElementPresent(findTestObject('Mobile/Game Token/ObjGetText - Hiburan'), 5)
Screenshot.takeScreenshot(testCaseName,'Game token voucher - Hiburan Page')

'Scroll Down'
SwipeHelper.swipeDown()

Screenshot.takeScreenshot(testCaseName,'List game token')

// Function to verify and tap on the GameToken option
List<String> searchLoPckg = ['GARENA SHELL', 'POINT BLANK']
boolean textFound = false

while (!textFound) {
	for (String text : searchLoPckg) {
		TestObject testObject = new TestObject()
		testObject.addProperty('xpath', ConditionType.EQUALS,
				"//android.widget.TextView[@resource-id='com.axis.net:id/txt_name' and @text='" + text + "']")
		if (Mobile.verifyElementExist(testObject, 3, FailureHandling.OPTIONAL)) {
			Screenshot.takeScreenshot(testCaseName,'Select Game Token' + text)
			Mobile.tap(testObject, 5)
			textFound = true
			break
		}
	}
}
if (!textFound) {
	KeywordUtil.markFailed("Text not found")
}

'Choose Denom'
Mobile.tap(findTestObject('Mobile/Game Token/ChooseDenomPB - Index 1'), 3)

Screenshot.takeScreenshot(testCaseName,'Choose Denom')

'Tap lanjut'
Mobile.tap(findTestObject('Mobile/Game Token/ObjBtn - Lanjut'), 3)


'wait element for confirm section'
def confirm = findTestObject('Mobile/Game Token/ObjGetText - Konfirmasi')

Mobile.waitForElementPresent(confirm, 5)
Screenshot.takeScreenshot(testCaseName,'Confirmation Page')

'Tap Aktifkan'
Mobile.tap(findTestObject('Mobile/Game Token/ObjBtn - Aktifkan'), 3)

'Input OTP'
Mobile.tap(findTestObject('Object Repository/Mobile/Game Token/ObjInputOtp'), 0)

Mobile.delay(15)

Mobile.hideKeyboard()

Screenshot.takeScreenshot(testCaseName,'Input OTP')

'Tap Lanjut'
Mobile.tap(findTestObject('Mobile/Game Token/ObjBtn - Lanjut (OTP)'), 0, FailureHandling.OPTIONAL)

'Verify Succes Purchase Game Token (Sync Page)'
def syncPage = findTestObject('Mobile/Sync Purchase Paket/ObjGetText- Transaksi kamu sedang diproses')

Mobile.waitForElementPresent(syncPage, 10)

Screenshot.takeScreenshot(testCaseName,'Sync Page')

'Verify Get Succes Receipt Purchase Game Token'
def successPage = findTestObject('Mobile/Sync Purchase Paket/ObjGetText - Transaksi Berhasil')

if (Mobile.waitForElementPresent(successPage, 15, FailureHandling.OPTIONAL)) {
    // Element is present
    Screenshot.takeScreenshot(testCaseName,'Succes Receipt')

    Mobile.delay(3)

    'Tap Button Home if Success get Success Receipt Page'
    Mobile.tap(findTestObject('Mobile/Sync Purchase Paket/ObjBtn - KE HOME'), 3)

    Screenshot.takeScreenshot(testCaseName,'Homepage after purchase')

    Mobile.comment('Element found and tapped')
} else {
    Mobile.delay(2)
}