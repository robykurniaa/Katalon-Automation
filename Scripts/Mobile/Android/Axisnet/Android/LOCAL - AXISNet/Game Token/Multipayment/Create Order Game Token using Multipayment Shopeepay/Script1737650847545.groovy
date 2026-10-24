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
import customKeywords.SwipeHelper as Swipe
import customKeywords.LoginKeywords as Login
import customKeywords.MedalliaHandling as Medallia
import customKeywords.ScreenshotKeywords as TestCase

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.testobject.ConditionType
import customKeywords.FindPackageKeywords as ScrollElement

TestCase.setTestCaseName("Create Order Flash Top Up Game Token using Shopeepay")

'Login Axis Net'
Login.openExistingApp('083125750052', 'DT2022')

'Pop Up Handler'
Mobile.callTestCase(findTestCase('Test Cases/Mobile/LOCAL - AXISNet/Homepage handler/Press Back'), [:], FailureHandling.CONTINUE_ON_FAILURE)

'medallia handling'
Medallia.closeMedallia()

Screenshot.takeScreenshot(' Homepage')

'Tap Hiburan'
Mobile.tap(findTestObject('Mobile/Unlimited Gaming/ObjFooter- Hiburan'), 3)

'Verify Element Hiburan Page'
Mobile.waitForElementPresent(findTestObject('Mobile/Game Token/ObjGetText - Hiburan'), 5)

Screenshot.takeScreenshot(' Hiburan')

'Scroll Down'
Mobile.scrollToText("FREE FIRE")

// Function to verify and tap on the GameToken option
List<String> searchGameToken = ['FREE FIRE', 'MOBILE LEGENDS']
boolean textFound = false

while (!textFound) {
	for (String text : searchGameToken) {
		TestObject testObject = new TestObject()
		testObject.addProperty('xpath', ConditionType.EQUALS,
				"//android.widget.TextView[@resource-id='com.axis.net:id/txt_name' and @text='" + text + "']")
		if (Mobile.verifyElementExist(testObject, 3, FailureHandling.OPTIONAL)) {
			Screenshot.takeScreenshot('Select Game Token ' + text)
			Mobile.tap(testObject, 5)
			textFound = true
			break
		}
	}
}
if (!textFound) {
	KeywordUtil.markFailed("Text not found")
}


// Verify the text on the object Mobile/Game Token/ObjGetText - FREE FIRE
'Choose Denom'
String freeFireText = Mobile.getText(findTestObject('Mobile/Game Token/ObjGetText - FREE FIRE'), 10)

if (freeFireText.contains('FREE FIRE')) {
	// If the text FREE FIRE is found, set text on Object Repository/Mobile/Game Token/ObjSetText - Enter User ID FF
	Mobile.setText(findTestObject('Mobile/Game Token/ObjSetText - Masukan User ID FF'), '6710588672', 10)

	// Choose Denom
	Mobile.tap(findTestObject('Mobile/Game Token/ChooseDenomFF - Index 1'), 3 // Verify the text on the object Mobile/Game Token/ObjGetText - MOBILE LEGENDS
		) // If the text MOBILE LEGENDS is found, set text on Object Repository/Mobile/Game Token/ObjSetText - Enter User ID ML
} else {
	String mobileLegendsText = Mobile.getText(findTestObject('Mobile/Game Token/ObjGetText - MOBILE LEGENDS'), 10)

	if (mobileLegendsText.contains('MOBILE LEGENDS')) {
		Mobile.setText(findTestObject('Mobile/Game Token/ObjSetText - Masukkan User ID ML'), '1610340778', 10)

		Mobile.setText(findTestObject('Mobile/Game Token/ObjSetText - Masukan Zone ID'), '16791', 10)

		Mobile.tap(findTestObject('Mobile/Game Token/ChooseDenomML - Index 1'), 3)
	}
}

Screenshot.takeScreenshot('Input id')

'Tap lanjut'
Mobile.tap(findTestObject('Mobile/Game Token/ObjBtn - Lanjut'), 3)

'Tap Payment Method'
Mobile.tap(findTestObject('Mobile/Purchase Paket - Journey/Paymen Method/ObjMethod - Payment Method'), 0)

Screenshot.takeScreenshot('Payment Method')

'Choose Payment'
def paymentMethod = findTestObject('Mobile/Purchase Paket - Journey/Paymen Method/ObjPaymentMethod - ShopeePay')

	// Verify object
	boolean isObjectDetected = Mobile.verifyElementExist(paymentMethod, 3, FailureHandling.OPTIONAL)

	if (isObjectDetected) {
		// if object is detected tap it
		Mobile.tap(paymentMethod, 3)
	} else {
		// if object not verify, swipe down
		ScrollElement.swipeDown()

		// Looping
		while (!isObjectDetected) {
			isObjectDetected = Mobile.verifyElementExist(paymentMethod, 3, FailureHandling.OPTIONAL)
			if (isObjectDetected) {
				Mobile.tap(paymentMethod, 3)
				break
			} else {
				ScrollElement.swipeDown()
			}
		}
	}
Screenshot.takeScreenshot('Choose Multipayment')

'Tap Aktifkan'
Mobile.tap(findTestObject('Mobile/Game Token/ObjBtn - Aktifkan'), 3)

'Verify Succes Create Order Game Token'
Mobile.delay(15)
Screenshot.takeScreenshot('Redirect Shopeepay')


