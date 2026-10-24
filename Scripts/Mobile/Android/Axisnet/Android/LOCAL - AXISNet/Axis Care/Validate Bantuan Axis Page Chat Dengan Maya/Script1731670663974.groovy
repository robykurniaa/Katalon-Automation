import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import java.awt.PopupMenu

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
import customKeywords.SwipeHelper as SwipeHelper
import customKeywords.LoginKeywords as Login
import customKeywords.MedalliaHandling as Medallia
import customKeywords.MedalliaHandling as PopUp

'Login Axis Net'
Login.openExistingApp('083827388378', 'DT2022')

'Pop Up Handler'
Mobile.callTestCase(findTestCase('Test Cases/Mobile/LOCAL - AXISNet/Homepage handler/Press Back'), [:], FailureHandling.CONTINUE_ON_FAILURE)

'medallia handling'
Medallia.closeMedallia()

Screenshot.takeScreenshot('Chat dengan maya - Homepage')

'Tap Alifetime'
Mobile.tap(findTestObject('Mobile/Alifetime/Objbtn - Alifetime'), 3)

Screenshot.takeScreenshot('Alifetime')

'press back alifetime page information'
Mobile.delay(2)
Mobile.pressBack()

'pop up handling'
PopUp.closePopUp()

'Tap Axis Care'
Mobile.tap(findTestObject('Mobile/Axis Care/Tentang Axis/ObjBtn- CARE'), 0)
PopUp.closePopUp()

Screenshot.takeScreenshot('Axis Care')

'Tap Bantuan'
Mobile.tap(findTestObject('Mobile/Axis Care/Bantuan/ObjAxisCare - Bantuan'), 0)
PopUp.closePopUp()

Screenshot.takeScreenshot('Axis care - bantuan')

'Tap Chat Dengan Maya'
Mobile.tap(findTestObject('Mobile/Axis Care/Bantuan/ObjBtn - Chat dengan maya'), 0)

'Validate Page Chat dengan Maya'
Mobile.waitForElementPresent(findTestObject('Mobile/Axis Care/Bantuan/Maya/ObjGetObject - Maya'), 0)
Screenshot.takeScreenshot('Chat dengan Maya')

'Validate Information Maya'
def infoMaya =findTestObject('Mobile/Axis Care/Bantuan/Maya/ObjGetObject - Info Maya')

if(Mobile.verifyElementExist(infoMaya, 3,FailureHandling.OPTIONAL ))
{
	Mobile.tap(findTestObject('Mobile/Axis Care/Bantuan/Maya/ObjBtn - Close'), 0)
	
}

'Sent Message Maya'
Mobile.setText(findTestObject('Mobile/Axis Care/Bantuan/Maya/ObjSetText - Chat dengan Maya'), 'info paket', 0)
Screenshot.takeScreenshot('Sent Message')

'Submit Message'
Mobile.tap(findTestObject('Mobile/Axis Care/Bantuan/Maya/ObjBtn - Send Chat'), 0)

'waiting for reply from maya'
def mayaReplyMssg =findTestObject('Mobile/Axis Care/Bantuan/Maya/ObjBtnMaya - Info Paket Suka-Suka')

if(Mobile.verifyElementExist(mayaReplyMssg, 0,FailureHandling.OPTIONAL ))
{
	Mobile.tap(findTestObject('Mobile/Axis Care/Bantuan/Maya/ObjBtnMaya - Info Paket Suka-Suka'), 0)
	Screenshot.takeScreenshot('reply Message from Maya')
	
}