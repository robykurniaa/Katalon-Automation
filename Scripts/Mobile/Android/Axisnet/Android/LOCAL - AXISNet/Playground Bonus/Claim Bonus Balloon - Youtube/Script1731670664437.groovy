import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import javax.security.auth.login.LoginContext

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
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import customKeywords.ScreenshotKeywords as Screenshot
import customKeywords.LoginKeywords as Login
import customKeywords.SwipeHelper
import customKeywords.MedalliaHandling as Medallia

'Login Axis Net'
Login.openExistingApp('083891411050', 'DT2022')

'Pop Up Handler'
Mobile.callTestCase(findTestCase('Test Cases/Mobile/LOCAL - AXISNet/Homepage handler/Press Back'), [:], FailureHandling.CONTINUE_ON_FAILURE)

'medallia handling'
Medallia.closeMedallia()

'Homepage'
Screenshot.takeScreenshot('Homepage')

'Find Quick Menu Bonus Balloon'
def ObjQuickMenu = findTestObject('Mobile/Quick Menu/ObjQuickMenu - Bonus Nonstop')
SwipeHelper.findQuickMenu(ObjQuickMenu)
Screenshot.takeScreenshot('Bonus Balloon Page')

// Define the objects
def yt4Jam = findTestObject('Mobile/Playground/Bonus Balloon - Youtube/ObjGetText - Unlimited YouTube Shorts 4 Jam')
def yt1Jam = findTestObject('Mobile/Playground/Bonus Balloon - Youtube/ObjGetText- Unlimited YouTube Shorts 1 Jam')
def objButton = findTestObject('Mobile/Playground/Bonus Balloon - Youtube/ObjBtnBonusYt - Ambil')

// Verify if either object is present
if (Mobile.verifyElementExist(yt4Jam, 10, FailureHandling.OPTIONAL) || Mobile.verifyElementExist(yt1Jam, 10, FailureHandling.OPTIONAL)) {
    // Tap the button if one of the objects is detected
    Mobile.tap(objButton, 10)
}

Screenshot.takeScreenshot('Bonus Balloon - Select Bonus Balloon')

'Scroll to AMBIL BONUS'
Mobile.scrollToText('Setuju')

'Checkist TnC'
Mobile.tap(findTestObject('Mobile/Playground/Bonus Balloon - Youtube/ObjBtn - Check Box'), 0)
Screenshot.takeScreenshot('Bonus Balloon - Checklist TnC')

'Tap Ambil Bonus'
Mobile.tap(findTestObject('Mobile/Playground/Bonus Balloon - Youtube/ObjBtn - AMBIL BONUS'), 0)
Screenshot.takeScreenshot('Bonus Balloon - Choose Bonus')

'Claim Bonus'
Mobile.tap(findTestObject('Mobile/Playground/Bonus Balloon - Youtube/ObjBtnAmbil- Claim'), 0)

'Verify Success Claim Bonus'
Mobile.waitForElementPresent(findTestObject('Mobile/Playground/Bonus Balloon - Youtube/ObjGetText - Bonus kamu dapat dicek'), 
    10)

Screenshot.takeScreenshot('Bonus Balloon - Success Claim Bonus')
//Mobile.tap(findTestObject('Object Repository/Mobile/Playground/Bonus Balloon - Youtube/ObjBtn - OKE'), 0)



