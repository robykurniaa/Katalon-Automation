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
import customKeywords.SwipeHelper
import customKeywords.LoginKeywords as Login
import customKeywords.MedalliaHandling as Medallia

'Login Axis Net'
Login.openExistingApp('083125750052', 'DT2022')

'Pop Up Handling'
Mobile.callTestCase(findTestCase('Test Cases/Mobile/LOCAL - AXISNet/Homepage handler/Press Back'), [:], FailureHandling.CONTINUE_ON_FAILURE)

'medallia handling'
Medallia.closeMedallia()

Screenshot.takeScreenshot('TF Pulsa - Homepage')

'Find Quick Menu Transfer Pulsa'
def ObjQuickMenu = findTestObject('Mobile/Quick Menu/ObjQuickMenu - Transfer Pulsa')
SwipeHelper.findQuickMenu(ObjQuickMenu)

Screenshot.takeScreenshot('Transfer Pulsa')

'Input MSISDN'
def destinationMsisdn = '085713519994'
Mobile.setText(findTestObject('Mobile/Transfer Pulsa/ObjTfDestination - Nomor AXIS'), destinationMsisdn,0)
Screenshot.takeScreenshot('TF Pulsa - Input MSISDN')

'Input Amount'
def transferAmount = '5000'
Mobile.setText(findTestObject('Mobile/Transfer Pulsa/ObjSetAmount - Jumlah Pulsa'), transferAmount, 0)
Screenshot.takeScreenshot('TF Pulsa - Input Amount')

'Tap Lanjut'
Mobile.tap(findTestObject('Mobile/Transfer Pulsa/ObjBtnLanjut'), 0)

'Validate Pop Up Notif'
Mobile.verifyElementExist(findTestObject('Mobile/Transfer Pulsa/ObjGetObject - Invalid Msisdn'),0)
Screenshot.takeScreenshot('TF Pulsa - Invalid MSISDN')