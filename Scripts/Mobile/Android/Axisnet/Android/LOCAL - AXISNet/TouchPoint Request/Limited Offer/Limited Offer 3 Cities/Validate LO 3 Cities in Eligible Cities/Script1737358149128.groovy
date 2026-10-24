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
import customKeywords.MedalliaHandling as Medallia
import customKeywords.FindPackageKeywords as LimitedOffer
import com.kms.katalon.core.testobject.ConditionType as ConditionType

'Open App'
Login.openExistingApp('6283155495000', 'DT2022')

'Pop Up Handler'
Mobile.callTestCase(findTestCase('Test Cases/Mobile/LOCAL - AXISNet/Homepage handler/Press Back'), [:], FailureHandling.CONTINUE_ON_FAILURE)

'medallia handling'
Medallia.closeMedallia()

'Swipe below to Limited Offer'
Swipe.swipeHomepage()

'Tap Mendadak Diskon'
Mobile.tap(findTestObject('Mobile/MCCM/ObjBtn - Mendadak Diskon'), 0)
Mobile.delay(2)

//Define variables
'Find Limited Offer Package'
List<String> searchLoPckg = ['BOOSTR KUOTA UTAMA 3GB 7hr',
							'BRONET 24JAM 8GB 7HR',
							'BRONET 5GB 30hr Salatiga',
							'BRONET 24Jam 16GB 30hr',
							'Voucher Garena Shell 330'
							]

int swipeCount = 0

int maxSwipes = 6

Set<String> foundPackages = new HashSet()

while ((foundPackages.size() < searchLoPckg.size()) && (swipeCount < maxSwipes)) {
	for (String text : searchLoPckg) {
		if (!(foundPackages.contains(text))) {
			// Use XPath to search for elements based on the text they contain
			TestObject to = new TestObject()

			to.addProperty('xpath', ConditionType.EQUALS,
				"//android.widget.TextView[@resource-id='com.axis.net:id/titleTv' and translate(@text, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz')='" + text.toLowerCase() + "']")
			

			// Verify whether the element with the searched text exists
			if (Mobile.verifyElementVisible(to, 3, FailureHandling.OPTIONAL)) {
				// Tap element when found
				Screenshot.takeScreenshot('Limited Offer Onboarded - ' + text)

				foundPackages.add(text)
				// Take screenshot even if the element is not found
			} else {
				//Screenshot.takeScreenshot('Limited Offer Not Found - ' + text)
			}
		}
	}
	
	if (foundPackages.size() < searchLoPckg.size()) {
		// Swipe if not all texts are found
		Swipe.swipeCardHanyaUntukmu()

		swipeCount++
	}
}

if (foundPackages.size() < searchLoPckg.size()) {
	println('Not all packages were found within the maximum swipe limit.')
}