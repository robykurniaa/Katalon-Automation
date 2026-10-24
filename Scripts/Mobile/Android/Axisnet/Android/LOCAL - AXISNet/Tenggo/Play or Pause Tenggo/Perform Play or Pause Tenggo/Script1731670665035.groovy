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
import customKeywords.LoginKeywords as Login
import com.kms.katalon.core.util.KeywordUtil
import customKeywords.MedalliaHandling as Medallia

'Login Axis Net'
Login.openExistingApp('083125750052', 'DT2022')

'Pop Up Handling'
Mobile.callTestCase(findTestCase('Test Cases/Mobile/LOCAL - AXISNet/Homepage handler/Press Back'), [:], FailureHandling.CONTINUE_ON_FAILURE)

'medallia handling'
Medallia.closeMedallia()

Screenshot.takeScreenshot('Homepage')

'Tap Detail Paket'
Mobile.tap(findTestObject('Mobile/Check Balance and Masa Aktif/ObjHomepage - Lihat Semua'), 0)
Screenshot.takeScreenshot('detail Paket')

'Scroll to Text Play'
Mobile.scrollToText('menyalakan')

'Tap play/pause tenggo'
def tenggoPlay = findTestObject('Mobile/Tenggo/Play Pause/ObjBtn - Play Tenggo')
def tenggoPause = findTestObject('Mobile/Tenggo/Play Pause/ObjBtn - Pause Tenggo')

if (Mobile.verifyElementExist(tenggoPlay, 0)) {
	// Element is present
	Screenshot.takeScreenshot('Play Tenggo')
	Mobile.tap(findTestObject('Mobile/Tenggo/Play Pause/ObjBtn - Play Tenggo'), 3)

} else {
	Screenshot.takeScreenshot('Pause Tenggo')
	Mobile.tap(findTestObject('Mobile/Tenggo/Play Pause/ObjBtn - Pause Tenggo'), 3)
}

'Validate success play pause'
if (findTestObject('Object Repository/Mobile/Tenggo/Play Pause/ObjSuccessPlayPauseTenggo')) {
	// Element is present
	Screenshot.takeScreenshot('detail Paket')
}