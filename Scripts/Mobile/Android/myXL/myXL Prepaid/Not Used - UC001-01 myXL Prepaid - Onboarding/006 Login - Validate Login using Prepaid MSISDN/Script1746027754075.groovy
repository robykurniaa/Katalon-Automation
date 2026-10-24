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

'Clear Text Input Field'
Mobile.clearText(findTestObject('null'), 0)

'Verify Input Number Page'
Mobile.waitForElementPresent(findTestObject('null'), 0)

'Screenshot Input Number Page'
Mobile.takeScreenshot()

'Input XL Prepaid MSISDN'
Mobile.setText(findTestObject('null'), GlobalVariable.preNum, 0)

'Screenshot Success Input XL Prepaid MSISDN'
Mobile.takeScreenshot()

    'Click on Continue Button'
    if (Mobile.verifyElementVisible(findTestObject('null'), 5, FailureHandling.STOP_ON_FAILURE)) {
        Mobile.tap(findTestObject('null'), 0)
        
        'Wait for OTP Page'
        Mobile.waitForElementPresent(findTestObject('null'), 0, FailureHandling.STOP_ON_FAILURE)
        
        'Take Screenshot'
        Mobile.takeScreenshot()
    } else {
        throw new Exception("Continue Button is not visible or enabled.")
		
		'Close App'
		Mobile.closeApplication()
		
		'Reopen App'
		Mobile.startExistingApplication("com.apps.MyXL", FailureHandling.STOP_ON_FAILURE)	
    }