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

'Scroll Up'
Mobile.scrollToText('See Feature in My Balance')

'Verify Dashboard'
Mobile.waitForElementPresent(findTestObject('null'), 0)	

'Screenshot Dashboard'
Mobile.takeScreenshot()

'1. Validate Quick Menu - Buy Package'
TestObject object1 = findTestObject('null')
TestObject object2 = findTestObject('null')
TestObject object3 = findTestObject('null')

CustomKeywords.'MobileUtils.QuickMenu'(object1, object2, object3)

'2. Validate Quick Menu - Redeem Bonus'
object1 = findTestObject('null')
object2 = findTestObject('null')

CustomKeywords.'MobileUtils.QuickMenu'(object1, object2, object3)

'3. Validate Quick Menu - Scan Voucher'
object1 = findTestObject('null')
object2 = findTestObject('null')

CustomKeywords.'MobileUtils.QuickMenu'(object1, object2, object3)

'4. Validate Quick Menu - Sharing'
object1 = findTestObject('null')
object2 = findTestObject('null')

CustomKeywords.'MobileUtils.QuickMenu'(object1, object2, object3)

