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
import customKeywords.SwipeHelper as SwipeHelper
import customKeywords.ScreenshotKeywords as Screenshot
import customKeywords.ScreenshotKeywords as TestCase
import customKeywords.LoginKeywords as Login
import com.kms.katalon.core.util.KeywordUtil
import customKeywords.MedalliaHandling as Medallia

TestCase.setTestCaseName('Add Favorite Package to Product')

'Login Axis Net'
Login.openExistingApp('083125750052', 'DT2022')

'Pop Up Handling'
Mobile.callTestCase(findTestCase('Test Cases/Mobile/LOCAL - AXISNet/Homepage handler/Press Back'), [:], FailureHandling.CONTINUE_ON_FAILURE)

'medallia handling'
Medallia.closeMedallia()

Screenshot.takeScreenshot('Homepage')

'Find Quick Menu Tenggo'
def ObjQuickMenu = findTestObject('Mobile/Tenggo/ObjQuickMenu- Teng-Go')

SwipeHelper.findQuickMenu(ObjQuickMenu)

'Waiting to Tenggo Section'
Mobile.waitForElementPresent(findTestObject('Mobile/Tenggo/ObjGetText - Kuota TENG-GO'), 0)

Screenshot.takeScreenshot('Tenggo Tab')

'Find Tenggo Instagram'
boolean tenggoObjectDetected = false
int maxSwipes = 3
int swipeCount = 0
def tnggoIg3Hrs = findTestObject('Mobile/Tenggo/ObjPackage - TENG-GO Instagram 3 Jam')

while (!tenggoObjectDetected && swipeCount < maxSwipes) {
	try {
		// Detect the object
		tenggoObjectDetected = Mobile.verifyElementExist(tnggoIg3Hrs, 3, FailureHandling.OPTIONAL)

		if (tenggoObjectDetected) {
			// Tap the object if detected
			Mobile.tap(tnggoIg3Hrs, 3 // Swipe if the object is not detected
				)
		} else {
			SwipeHelper.swipeTenggoPaket()
			swipeCount++
		}
	}
	catch (Exception e) {
		// Handle any exceptions
		println('An error occurred: ' + e.message)
	}
}

if (!tenggoObjectDetected) {
	// Fail the test case if the object is not found after max swipes
	KeywordUtil.markFailed("Element is not visible, test case failed.")
}


Screenshot.takeScreenshot('Tenggo Instagram')

'Tenggo Information Handling'
def tenggoInformation = findTestObject('Mobile/Tenggo/ObjGetText - Tenggo Informartion')

if (Mobile.waitForElementPresent(tenggoInformation, 10, FailureHandling.OPTIONAL)) {
	// Element is present
	Mobile.delay(2)

	Mobile.tap(findTestObject('Mobile/Tenggo/ObjBtn- OK, NGERTI'), 3)

	Mobile.comment('Element found and tapped' // Element is not present
		)
} else {
	Mobile.delay(2)
}

Screenshot.takeScreenshot('Tenggo PDP')

'Tap Favorite'
Mobile.tap(findTestObject('Mobile/Favorite Product/ObjBtn - Add Favorite'), 0)

'Validate pop up success add to favorite'
Mobile.verifyElementVisible(findTestObject('Mobile/Favorite Product/ObjGetText - Pop Up Success Add Favorite Product'), 3,FailureHandling.OPTIONAL )
Screenshot.takeScreenshot('Pop Up Add Favorite')