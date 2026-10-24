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

'Running test case login'
Mobile.callTestCase(findTestCase('Test Cases/Mobile/Android/Axisnet/Android/Old Test Cases/00000 Call Test Case - Login using number with balance'), [:], FailureHandling.STOP_ON_FAILURE)

'Running test case validate top up balance page'
Mobile.callTestCase(findTestCase('Test Cases/Mobile/Android/Axisnet/Android/Old Test Cases/00000 Call Test Case - Top Up - Validate top up balance page'), [:], FailureHandling.STOP_ON_FAILURE)

'Click denom 25K'
Mobile.tap(findTestObject('null'), 0)

'Screenshot success select 25K denom'
Mobile.takeScreenshot()

'Click continue'
Mobile.tap(findTestObject('null'), 0)

'Wait payment method page to fully loaded'
Mobile.waitForElementPresent(findTestObject('null'), 0)

'Click pilih metode pembayaran'
Mobile.tap(findTestObject('null'), 0)

'Wait payment method page to fully loaded'
Mobile.verifyElementVisible(findTestObject('null'), 0)

'Screenshot payment method page'
Mobile.takeScreenshot()

'Click ovo'
Mobile.tap(findTestObject('null'), 0)

'Screenshot success select payment method ovo'
Mobile.takeScreenshot()

'Wait ovo input number page to fully loaded'
Mobile.waitForElementPresent(findTestObject('null'), 0)

'Input ovo number'
Mobile.setText(findTestObject('null'), GlobalVariable.noBalNum, 0)

'Click continue'
Mobile.tap(findTestObject('null'), 0)

'Screenshot success input ovo number'
Mobile.takeScreenshot()

'Wait confirmation page to fully loaded'
Mobile.waitForElementPresent(findTestObject('null'), 0)

'Screenshot confirmation page'
Mobile.takeScreenshot()

'Click confirm'
Mobile.tap(findTestObject('null'), 0)

'Wait waiting payment page to fully loaded'
Mobile.waitForElementPresent(findTestObject('null'), 30)

'Scroll down'
Mobile.swipe(520, 1150, 520, 370)

'Screenshot waiting payment page'
Mobile.takeScreenshot()

'Clear session'
Mobile.closeApplication()
