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
import com.kms.katalon.core.util.KeywordUtil


'Verify Dashboard'
Mobile.waitForElementPresent(findTestObject('null'), 0)	

'Screenshot Dashboard'
Mobile.takeScreenshot()

Mobile.scrollToText('XL Poin')

'Validate XL Poin in Dashboard'
Mobile.verifyElementExist(findTestObject('null'), 0)

'Click XL Poin in Dashboard'
Mobile.tap(findTestObject('null'), 0)

'Wait for XL Poin Landing Page'
Mobile.waitForElementPresent(findTestObject('null'), 0)

Mobile.takeScreenshot()

try {
        if (Mobile.verifyElementExist(findTestObject('null'), 
			0, FailureHandling.STOP_ON_FAILURE)) {
            'Get the text of the tier object'
            String tier = Mobile.getText(findTestObject('null'), 0)
            KeywordUtil.logInfo(tier)
        } else {
            KeywordUtil.markWarning("Tier object not found!")
        }

        if (Mobile.verifyElementExist(findTestObject('null'), 
			0, FailureHandling.STOP_ON_FAILURE)) {
            String points = Mobile.getText(findTestObject('null'), 0)
            KeywordUtil.logInfo("Points amount : " + points)
        } else {
            KeywordUtil.markWarning("Points object not found!")
        }

		'Get Device Height and Store in to device_height variable'
		device_Height = Mobile.getDeviceHeight()
		
		'Get Width Height and Store in to device_Width variable'
		device_Width = Mobile.getDeviceWidth()
		
		'Storing the value in startY variable by dividing device height by 2 Because Y coordinates are constant'
		int startY = device_Height * 0.60
		
		'Here startY and endY values are equal for Horizontal Swiping for that assigning startX value to endX'
		int endY = device_Height * 0.30
		
		'Storing the value in startX variable'
		int startX = 531
		
		'Storing the value in endX variable'
		int endX = startX
		
		for (int i = 1; i <= 6; i++) {
			'Swipe SFY'
			Mobile.swipe(startX, startY, endX, endY)
			
			println("Swipe action ${i} completed.")
			
			Mobile.takeScreenshot()
		}
		
        KeywordUtil.logInfo("Swiped down successfully.")
		
    } catch (Exception e) {
        KeywordUtil.markFailed("An error occurred: " + e.message)
    }


Mobile.pressBack()


