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
import customKeywords.MedalliaHandling as Medallia

String testCaseName = "Perform Claim Mistery Box"
TestCase.setTestCaseName(testCaseName)

'Login Axis Net'
Login.openExistingApp('083110568297', 'DT2022')

'Pop Up Handler'
Mobile.callTestCase(findTestCase('Test Cases/Mobile/LOCAL - AXISNet/Homepage handler/Press Back'), [:], FailureHandling.CONTINUE_ON_FAILURE)

'medallia handling'
Medallia.closeMedallia()

Screenshot.takeScreenshot('Homepage')

'Tap Playground'
Mobile.tap(findTestObject('Mobile/Homepage/Footer/Playground Tab - V2'), 0)
Screenshot.takeScreenshot('Playground')

'Tap Mystery Box'
Mobile.tap(findTestObject('Mobile/Playground/Mystery Box/MysteryBoxPage'), 0)
Screenshot.takeScreenshot('Mystery Box')


'Tap Lanjut'
Mobile.tap(findTestObject('Mobile/Playground/Mystery Box/BtnLanjut - Mystery Box'), 0)
Screenshot.takeScreenshot('Information')

'Tap Main Sekarang'
Mobile.tap(findTestObject('Mobile/Playground/Mystery Box/BtnNext - Main Sekarang'), 0)

'Claim Bonus'
Mobile.tap(findTestObject('Mobile/Playground/Mystery Box/ClaimMysteryBox'), 0)
Screenshot.takeScreenshot('Success Claim Bonus')
Mobile.delay(5)