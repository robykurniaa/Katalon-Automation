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
import customKeywords.MedalliaHandling as Medallia
import customKeywords.FindPackageKeywords as Find

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.testobject.ConditionType

String testCaseName = "Validate Rabu Rawit Onboarded"

'Login Axis Net'
Login.openExistingApp('083110568390', 'DT2022')

'Pop Up Handler'
Mobile.callTestCase(findTestCase('Test Cases/Mobile/LOCAL - AXISNet/Homepage handler/Press Back'), [:], FailureHandling.CONTINUE_ON_FAILURE)

'medallia handling'
Medallia.closeMedallia()

'Tap Paket'
Screenshot.takeScreenshot('Rabu Rawit Onboarded - Homepage')
Mobile.tap(findTestObject('Mobile/TPR/Rabu Rawit/ObjBtn - Paket'), 0)
Screenshot.takeScreenshot('Tap Paket')

'get Text Kategori Paket'
Mobile.getText(findTestObject('Mobile/TPR/Rabu Rawit/ObjGetText - Pilih kategori paket'), 0)

'Tap Internet'
Mobile.tap(findTestObject('Mobile/TPR/Rabu Rawit/ObjBtnKtgri - Internet'), 0)
Screenshot.takeScreenshot('Tap Internet')

'Get Text Rabu Rawit'
Mobile.waitForElementPresent(findTestObject('Mobile/TPR/Rabu Rawit/ObjGetText - Rabu Rawit'), 0)
Screenshot.takeScreenshot('Rabu Rawit Paket')

'Rabu Rawit Baik Tab'
def objRabuRwtTab = findTestObject('Mobile/TPR/Rabu Rawit/ObjGetText - Rabu Rawit')
Find.findTab(objRabuRwtTab)

'Validate Package'
List<String> searchLoPckg = ['PROMO BRONET 16GB 60HR',
							'PROMO BRONET 10GB 30HR',
							'PROMO BRONET 8GB 30HR',
							'PROMO BRONET 5GB 30HR',
							'PROMO BRONET 3GB 30HR'
							]

int swipeCount = 0

int maxSwipes = 6

Set<String> foundPackages = new HashSet()

while ((foundPackages.size() < searchLoPckg.size()) && (swipeCount < maxSwipes)) {
	for (String text : searchLoPckg) {
		if (!(foundPackages.contains(text))) {
			'Use XPath to search for elements based on the text they contain'
			TestObject to = new TestObject()

			to.addProperty('xpath', ConditionType.EQUALS,
				"//android.widget.TextView[@resource-id='com.axis.net:id/productNameTv' and translate(@text, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz')='" + text.toLowerCase() + "']")
			
			'Verify whether the element with the searched text exists'
			if (Mobile.verifyElementExist(to, 3, FailureHandling.OPTIONAL)) {
				'Tap element when found'
				Screenshot.takeScreenshot('Onboard Jumat Baik - ' + text)

				foundPackages.add(text)
				'Take screenshot even if the element is not found'
			} else {
				//Screenshot.takeScreenshot('Limited Offer Not Found - ' + text)
			}
		}
	}
	
	if (foundPackages.size() < searchLoPckg.size()) {
		// Swipe if not all texts are found
		Swipe.swipeJumbaPkg()

		swipeCount++
	}
}
