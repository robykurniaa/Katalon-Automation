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
Mobile.callTestCase(findTestCase('Test Cases/Mobile/Android/Axisnet/Android/Old Test Cases/00000 Call Test Case - Login using number with balance'), 
    [:], FailureHandling.STOP_ON_FAILURE)

'Click store menu'
Mobile.tap(findTestObject('null'), 0)

'Wait store page to fully loaded'
Mobile.waitForElementPresent(findTestObject('null'), 
    0)

'Screenshot store page'
Mobile.takeScreenshot()

'Click byop banner'
Mobile.tap(findTestObject('null'), 0)

'Wait byop page to fully loaded'
Mobile.waitForElementPresent(findTestObject('null'), 40)

'Screenshot byop page'
Mobile.takeScreenshot()

'Click masa aktif 3 hari card'
Mobile.tap(findTestObject('null'), 0)

'Swipe up'
Mobile.swipe(520, 600, 520, 1750)

'Secreenshot success select byop masa aktif 3 hari card'
Mobile.takeScreenshot()

'Click 3 hari masa aktif card'
Mobile.tap(findTestObject('null'), 0)

'Validate kuota utama section show'
Mobile.verifyElementVisible(findTestObject('null'), 0)

'Click kuota 1 GB card'
Mobile.tap(findTestObject('null'), 0)

'Secreenshot success select byop kuota 1 GB card'
Mobile.takeScreenshot()

'Swipe down'
Mobile.swipe(520, 1750, 520, 600)

'Validate tambah kuota pelengkap section show'
Mobile.verifyElementVisible(findTestObject('null'), 30)

'Click tambah kuota pelengkap'
Mobile.tap(findTestObject('null'), 0)

Mobile.delay(5)

Mobile.takeScreenshot('/Users/barefputro/Documents/Katalon Studio/dt-automation-katalon/Screenshot/Android/Purchase/Purchase BYOP Mass/1. Purchase BYOP Mass Using Sufficient Balance/10.Kuota Pelengkap Page.png')

Mobile.verifyElementVisible(findTestObject('Object Repository/AndroidObj/PurchaseByop/eleBYOPKuotaPelengkapVideo3HariSection'), 
    30)

Mobile.tap(findTestObject('Object Repository/AndroidObj/PurchaseByop/objBYOPKuotaPelengkapVideo3HariPilihButton'), 0)

Mobile.takeScreenshot('/Users/barefputro/Documents/Katalon Studio/dt-automation-katalon/Screenshot/Android/Purchase/Purchase BYOP Mass/1. Purchase BYOP Mass Using Sufficient Balance/11.Video 3Hari Section.png')

Mobile.verifyElementVisible(findTestObject('Object Repository/AndroidObj/PurchaseByop/eleBYOPKuotaPelengkapVideo3Hari1GB'), 
    30)

Mobile.tap(findTestObject('Object Repository/AndroidObj/PurchaseByop/objBYOPKuotaPelengkapVideo3Hari1GBCard'), 0)

Mobile.takeScreenshot('/Users/barefputro/Documents/Katalon Studio/dt-automation-katalon/Screenshot/Android/Purchase/Purchase BYOP Mass/1. Purchase BYOP Mass Using Sufficient Balance/12.Video 3Hari 1GB Selected.png')

Mobile.tap(findTestObject('Object Repository/AndroidObj/PurchaseByop/objBYOPKuotaPelengkapTambahkanButton'), 0)

Mobile.swipe(150, 1500, 400, 1100)

Mobile.swipe(150, 1500, 400, 1100)

Mobile.tap(findTestObject('Object Repository/AndroidObj/PurchaseByop/objBYOPLanjutButton'), 0)

Mobile.verifyElementVisible(findTestObject('Object Repository/AndroidObj/PurchaseByop/eleBYOPKonfirmasiPage'), 30)

Mobile.takeScreenshot('/Users/barefputro/Documents/Katalon Studio/dt-automation-katalon/Screenshot/Android/Purchase/Purchase BYOP Mass/1. Purchase BYOP Mass Using Sufficient Balance/13.Konfirmasi Page.png')

Mobile.swipe(150, 1500, 400, 1100)

Mobile.swipe(150, 1500, 400, 1100)

Mobile.takeScreenshot('/Users/barefputro/Documents/Katalon Studio/dt-automation-katalon/Screenshot/Android/Purchase/Purchase BYOP Mass/1. Purchase BYOP Mass Using Sufficient Balance/14.Purchase With Sufficient Balance.png')

Mobile.tap(findTestObject('Object Repository/AndroidObj/PurchaseByop/objBYOPKonfirmasiPageAktivasiSekarangButton'), 0)

if (Mobile.verifyElementVisible(findTestObject('Object Repository/AndroidObj/MedaliaSurveyV1.1/eleMedaliaTitle'), 10, FailureHandling.OPTIONAL)) {
    Mobile.tap(findTestObject('Object Repository/AndroidObj/MedaliaSurveyV1.1/objMedaliaCloseButton'), 10, FailureHandling.OPTIONAL)

    Mobile.verifyElementVisible(findTestObject('Object Repository/AndroidObj/PurchaseByop/eleBYOPReceipt'), 30)

    Mobile.takeScreenshot('/Users/barefputro/Documents/Katalon Studio/dt-automation-katalon/Screenshot/Android/Purchase/Purchase BYOP Mass/1. Purchase BYOP Mass Using Sufficient Balance/15.Receipt BYOP.png')
} else {
    Mobile.verifyElementVisible(findTestObject('Object Repository/AndroidObj/PurchaseByop/eleBYOPReceipt'), 10, FailureHandling.OPTIONAL)

    Mobile.takeScreenshot('/Users/barefputro/Documents/Katalon Studio/dt-automation-katalon/Screenshot/Android/Purchase/Purchase BYOP Mass/1. Purchase BYOP Mass Using Sufficient Balance/15.Receipt BYOP.png')
}

'Clear session'
Mobile.closeApplication()

