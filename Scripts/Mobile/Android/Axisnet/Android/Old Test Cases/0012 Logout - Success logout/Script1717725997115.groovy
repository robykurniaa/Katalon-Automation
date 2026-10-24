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
Mobile.callTestCase(findTestCase('Test Cases/Mobile/Android/Axisnet/Android/Old Test Cases/00000 Call Test Case - Login using number no balance'), [:], FailureHandling.STOP_ON_FAILURE)

'Click alifetime page'
Mobile.tap(findTestObject('null'), 0)

'Wait TnC page to fully loaded'
Mobile.waitForElementPresent(findTestObject('null'), 0)
 
'Verify TnC page 1'
Mobile.verifyElementVisible(findTestObject('null'), 0)

'Screenshot TnC page 1'
Mobile.takeScreenshot()

'Swipe left'
Mobile.swipe(933, 1000, 135, 1000)

'Verify TnC page 2'
Mobile.verifyElementVisible(findTestObject('null'), 0)

'Screenshot TnC page 2'
Mobile.takeScreenshot()

'Swipe left'
Mobile.swipe(933, 1000, 135, 1000)

'Verify TnC page 3'
Mobile.verifyElementVisible(findTestObject('null'), 0)

'Screenshot TnC page 3'
Mobile.takeScreenshot()

'Click close button on TnC page'
Mobile.tap(findTestObject('null'), 0)

'Wait alifetime page to fully loaded'
Mobile.waitForElementPresent(findTestObject('null'), 0)

'Screenshot alifetime page'
Mobile.takeScreenshot()

'Click tab setting on alifetime page'
Mobile.tap(findTestObject('null'), 0)

'Wait setting page to fully loaded'
Mobile.waitForElementPresent(findTestObject('null'), 0)

'Screenshot setting page'
Mobile.takeScreenshot()

'Scroll To Logout'
Mobile.swipe(521, 1150, 521, 370)

'Verify logout menu show on screen'
Mobile.verifyElementVisible(findTestObject('null'), 0)

'Screenshot logout menu'
Mobile.takeScreenshot()

'Click logout'
Mobile.tap(findTestObject('null'), 0)

'Wait logout confirmation screen to show'
Mobile.waitForElementPresent(findTestObject('null'), 0)

'Screenshot logout confirmation screen'
Mobile.takeScreenshot()

'Click confirm logout on logout confirmation screen'
Mobile.tap(findTestObject('null'), 0)

'Wait input number page to fully loaded'
Mobile.waitForElementPresent(findTestObject('null'), 0)

'Screenshot success logout'
Mobile.takeScreenshot()

'Clear session'
Mobile.closeApplication()
