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

'Open Axisnet app'
Mobile.startApplication(GlobalVariable.Application, true)

'Wait Axisnet app to fully open'
Mobile.waitForElementPresent(findTestObject('null'), 
    0)

'Screenshot login cvv page 1'
Mobile.takeScreenshot()

'Validate UI login cvv page 1'
Mobile.takeScreenshotAsCheckpoint('CVV Page 1')

'Swipe down'
Mobile.swipe(520, 1750, 520, 600)

'Wait screen to fully loaded'
Mobile.waitForElementPresent(findTestObject('null'), 
    0)

'Screenshot login cvv page 2'
Mobile.takeScreenshot()

'Validate UI login cvv page 2'
Mobile.takeScreenshotAsCheckpoint('CVV Page 2')

'Swipe down'
Mobile.swipe(520, 1750, 520, 600)

'Wait screen to fully loaded'
Mobile.waitForElementPresent(findTestObject('null'), 
    0)

'Screenshot login cvv page 3'
Mobile.takeScreenshot()

'Validate UI login cvv page 3'
Mobile.takeScreenshotAsCheckpoint('CVV Page 3')

'Click login button'
Mobile.tap(findTestObject('null'), 0)

'Wait input number page to fully loaded'
Mobile.waitForElementPresent(findTestObject('null'), 
    0)

'Screenshot input number page'
Mobile.takeScreenshot()

'Validate UI input number page'
Mobile.takeScreenshotAsCheckpoint('Login Page')

'Input number'
Mobile.setText(findTestObject('null'), GlobalVariable.withBalNum, 
    0)

'Screenshot success input number'
Mobile.takeScreenshot()

'Click login button after success input number'
Mobile.tap(findTestObject('null'), 0)

'Wait input otp page to fully loaded'
Mobile.waitForElementPresent(findTestObject('null'), 
    0)

'Screenshot input otp page'
Mobile.takeScreenshot()

'Input otp'
Mobile.setText(findTestObject('null'), GlobalVariable.validOTP, 
    0)

'Screenshot success input otp'
Mobile.takeScreenshot()

'Click continue button after success input number'
Mobile.tap(findTestObject('null'), 0)

'TnC handling'
if (Mobile.waitForElementPresent(findTestObject('null'), 5, 
    FailureHandling.OPTIONAL)) {
    Mobile.tap(findTestObject('null'), 0)
}

'Medalia handling on claim bonus page'
if (Mobile.waitForElementPresent(findTestObject('null'), 5, FailureHandling.OPTIONAL)) {
    Mobile.tap(findTestObject('null'), 0, FailureHandling.OPTIONAL)
}

'Moengage handling on claim bonus page'
if (Mobile.waitForElementPresent(findTestObject('null'), 
    5, FailureHandling.OPTIONAL)) {
    Mobile.tap(findTestObject('null'), 0, FailureHandling.OPTIONAL)
}

'Claim bonus handling'
if (Mobile.waitForElementPresent(findTestObject('null'), 
    5, FailureHandling.OPTIONAL)) {
    Mobile.tap(findTestObject('null'), 0, FailureHandling.OPTIONAL)
}

'Medalia handling on dashboard'
if (Mobile.waitForElementPresent(findTestObject('null'), 5, FailureHandling.OPTIONAL)) {
    Mobile.tap(findTestObject('null'), 0, FailureHandling.OPTIONAL)
}

'Moengage handling on dashboard'
if (Mobile.waitForElementPresent(findTestObject('null'), 
    5, FailureHandling.OPTIONAL)) {
    Mobile.tap(findTestObject('null'), 0, FailureHandling.OPTIONAL)
}

'Wait dashboard page to fully loaded'
Mobile.waitForElementPresent(findTestObject('null'), 
    0)

'Screenshot success login'
Mobile.takeScreenshot()

'Validate UI dashboard'
Mobile.takeScreenshotAsCheckpoint('Dashboard Page')
