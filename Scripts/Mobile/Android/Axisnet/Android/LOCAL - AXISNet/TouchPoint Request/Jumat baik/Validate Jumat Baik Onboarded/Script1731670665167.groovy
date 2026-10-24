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
import customKeywords.LoginKeywords as Login
import customKeywords.SwipeHelper as Swipe
import customKeywords.FindPackageKeywords as Find
import customKeywords.MedalliaHandling as Medallia

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.testobject.ConditionType

String testCaseName = "Validate Jumat Baik Onboarded"
TestCase.setTestCaseName(testCaseName)

Login.openExistingApp('083827388378', 'DT2022')

'Pop Up Handling'
Mobile.callTestCase(findTestCase('Test Cases/Mobile/LOCAL - AXISNet/Homepage handler/Press Back'), [:], FailureHandling.CONTINUE_ON_FAILURE)

'medallia handling'
Medallia.closeMedallia()

Screenshot.takeScreenshot('Jumat Baik Onboarded - Homepage')

'Tap Paket'
Mobile.tap(findTestObject('Mobile/TPR/Rabu Rawit/ObjBtn - Paket'), 0)

'Tap Internet'
Mobile.tap(findTestObject('Mobile/Purchase Paket - Journey/ObjBtnKtgri - Internet'), 0)

Screenshot.takeScreenshot('Jumat Baik - Jumat Baik Section')

'Jumat Baik Tab'
def objJumbaTab = findTestObject('Mobile/TPR/Jumat Baik/ObjBtn - Jumat Baik Tab')
Find.findTab(objJumbaTab)

'Validate Package'
List<String> searchLoPckg = ['PROMO BRONET 5GB 7HR',
							'PROMO BRONET 16GB 60HR',
							'PROMO BRONET 5GB 30HR',
							'PROMO BRONET 3GB 30HR',
							'OWSEM 16GB + Unli Games 30Hr'
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

