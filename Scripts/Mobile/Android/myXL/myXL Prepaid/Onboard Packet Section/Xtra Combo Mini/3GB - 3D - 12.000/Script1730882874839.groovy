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

'Verify XCM 3GB'
Mobile.verifyElementExist(findTestObject('null'), 0)

'Define XCM 3GB'
def xcm3GB = Mobile.getText(findTestObject('null'), 0)

'Verify XCM 3GB'
Mobile.verifyEqual(xcm3GB, 'IDR 12.000')

//'Define Harga Coret XCM 6GB'
//def xcm6GBmccm = Mobile.getText(findTestObject('null'), 0)
//
//'Verify XCM 6GB'
//Mobile.verifyEqual(xcm6GBmccm, 'IDR 24.900')

'Screenshot XCM 3GB'
Mobile.takeScreenshot()