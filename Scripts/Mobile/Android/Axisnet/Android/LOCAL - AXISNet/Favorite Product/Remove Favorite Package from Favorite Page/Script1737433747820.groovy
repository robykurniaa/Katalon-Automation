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
import com.kms.katalon.core.testobject.ObjectRepository as OR

TestCase.setTestCaseName('Remove Favorite Packgae')

'Login Axis Net'
Login.openExistingApp('083125750052', 'DT2022')

'Pop Up Handling'
Mobile.callTestCase(findTestCase('Test Cases/Mobile/LOCAL - AXISNet/Homepage handler/Press Back'), [:], FailureHandling.CONTINUE_ON_FAILURE)

'medallia handling'
Medallia.closeMedallia()

Screenshot.takeScreenshot('Homepage')

'Tap Favorite Page'
Mobile.tap(findTestObject('Mobile/Favorite Product/ObjBtn - Favorite List Page'), 0)

'Validate Favorite Page List'
def dltList = findTestObject('Mobile/Favorite Product/ObjBtn - Hapus Favorit')
def dtlList = findTestObject('Mobile/Favorite Product/ObjBtn - Lihat Detail')

if(Mobile.verifyElementExist(dltList, 5, FailureHandling.OPTIONAL) || Mobile.verifyElementExist(dtlList, 5, FailureHandling.OPTIONAL))
{
	Screenshot.takeScreenshot('Favorite Page')
}

// Check if the Button exists
if (Mobile.verifyElementExist(OR.findTestObject('Mobile/Favorite Product/ObjBtn - Remove Product (Img Trash)'), 5,FailureHandling.OPTIONAL )) {
	Mobile.tap(OR.findTestObject('Mobile/Favorite Product/ObjBtn - Remove Product (Img Trash)'), 5)
}
// Check if the objek 'Hapus Favorit' exists
else if (Mobile.verifyElementExist(OR.findTestObject('Mobile/Favorite Product/ObjBtn - Hapus Favorit'), 5)) {
	Mobile.tap(OR.findTestObject('Mobile/Favorite Product/ObjBtn - Hapus Favorit'), 5)
} else {
	Mobile.comment('No Detection Object.')
}

'Validate Success Remove Favorite'
if(Mobile.verifyElementExist(findTestObject('Mobile/Favorite Product/ObjGetToast - Success Delete Favorite'), 0)) {
	Screenshot.takeScreenshot('Success Remove Product from Favorite')
}

