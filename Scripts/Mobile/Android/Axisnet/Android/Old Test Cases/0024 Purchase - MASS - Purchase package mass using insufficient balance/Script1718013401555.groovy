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

'Open Axisnet App'
Mobile.startApplication(GlobalVariable.Application, true)

Mobile.waitForElementPresent(findTestObject('Object Repository/AndroidObj/LoginAndLogout/objLoginAndLogoutLogin'), 30)

Mobile.takeScreenshot('/Users/barefputro/Documents/Katalon Studio/dt-automation-katalon/Screenshot/Android/Purchase/Purchase Package Mass/2. Purchase Package Mass Using Insufficient Balance/1.Login Page.png')

'Click Login'
Mobile.tap(findTestObject('Object Repository/AndroidObj/LoginAndLogout/objLoginAndLogoutLogin'), 0)

Mobile.waitForElementPresent(findTestObject('Object Repository/AndroidObj/LoginAndLogout/objLoginAndLogoutSetNum'), 30)

'Input Number'
Mobile.delay(1)

Mobile.setText(findTestObject('Object Repository/AndroidObj/LoginAndLogout/objLoginAndLogoutSetNum'), '083869517232', 0)

Mobile.takeScreenshot('/Users/barefputro/Documents/Katalon Studio/dt-automation-katalon/Screenshot/Android/Purchase/Purchase Package Mass/2. Purchase Package Mass Using Insufficient Balance/2.Input Number Page.png')

'Click Next'
Mobile.tap(findTestObject('Object Repository/AndroidObj/LoginAndLogout/objLoginAndLogoutNextLogin'), 0)

Mobile.waitForElementPresent(findTestObject('Object Repository/AndroidObj/LoginAndLogout/objLoginAndLogoutSetOtp'), 30)

'Input OTP'
Mobile.setText(findTestObject('Object Repository/AndroidObj/LoginAndLogout/objLoginAndLogoutSetOtp'), 'DT2022', 0)

Mobile.takeScreenshot('/Users/barefputro/Documents/Katalon Studio/dt-automation-katalon/Screenshot/Android/Purchase/Purchase Package Mass/2. Purchase Package Mass Using Insufficient Balance/3.Input OTP Page.png')

'Continue Login'
Mobile.tap(findTestObject('Object Repository/AndroidObj/LoginAndLogout/objLoginAndLogoutLanjut'), 0)

'SnK Handling'
if (Mobile.verifyElementVisible(findTestObject('Object Repository/AndroidObj/LoginAndLogout/eleLoginAndLogoutSyaratDanKetentuanPage'), 10, FailureHandling.OPTIONAL)) {
	Mobile.tap(findTestObject('Object Repository/AndroidObj/LoginAndLogout/objLoginAndLogoutSyaratDanKetentuanSetujuButton'), 0)
	
} else {
'Medalia Handling'
	Mobile.verifyElementVisible(findTestObject('Object Repository/AndroidObj/LoginAndLogout/objLoginAndLogoutBonusClose'), 10, FailureHandling.OPTIONAL)
}

if (Mobile.verifyElementVisible(findTestObject('Object Repository/AndroidObj/MedaliaSurveyV1.1/eleMedaliaTitle'), 10, FailureHandling.OPTIONAL)) {
	Mobile.tap(findTestObject('Object Repository/AndroidObj/MedaliaSurveyV1.1/objMedaliaCloseButton'), 10, FailureHandling.OPTIONAL)

	Mobile.takeScreenshot('/Users/barefputro/Documents/Katalon Studio/dt-automation-katalon/Screenshot/Android/Purchase/Purchase Package Mass/2. Purchase Package Mass Using Insufficient Balance/4.Claim Bonus Page.png')

	Mobile.tap(findTestObject('Object Repository/AndroidObj/LoginAndLogout/objLoginAndLogoutBonusClose'), 10, FailureHandling.OPTIONAL)
} else {
	Mobile.takeScreenshot('/Users/barefputro/Documents/Katalon Studio/dt-automation-katalon/Screenshot/Android/Purchase/Purchase Package Mass/2. Purchase Package Mass Using Insufficient Balance/4.Claim Bonus Page.png')

	Mobile.tap(findTestObject('Object Repository/AndroidObj/LoginAndLogout/objLoginAndLogoutBonusClose'), 10, FailureHandling.OPTIONAL)
}

'Dashboard Page'
if (Mobile.verifyElementVisible(findTestObject('Object Repository/AndroidObj/LoginAndLogout/objLoginAndLogoutCloseBtnEsim'), 10, FailureHandling.OPTIONAL)) {
	Mobile.tap(findTestObject('Object Repository/AndroidObj/LoginAndLogout/objLoginAndLogoutCloseBtnEsim'), 10, FailureHandling.OPTIONAL)
	
	Mobile.verifyElementVisible(findTestObject('Object Repository/AndroidObj/LockUnlock/objMenuPulsaLainya'), 10, FailureHandling.OPTIONAL)
} else {
	Mobile.verifyElementVisible(findTestObject('Object Repository/AndroidObj/LockUnlock/objMenuPulsaLainya'), 10, FailureHandling.OPTIONAL)
}

if (Mobile.verifyElementVisible(findTestObject('Object Repository/AndroidObj/MedaliaSurveyV1.1/eleMedaliaTitle'), 10, FailureHandling.OPTIONAL)) {
	Mobile.tap(findTestObject('Object Repository/AndroidObj/MedaliaSurveyV1.1/objMedaliaCloseButton'), 10, FailureHandling.OPTIONAL)
	
	Mobile.verifyElementVisible(findTestObject('Object Repository/AndroidObj/LockUnlock/objMenuPulsaLainya'), 10, FailureHandling.OPTIONAL)

	Mobile.takeScreenshot('/Users/barefputro/Documents/Katalon Studio/dt-automation-katalon/Screenshot/Android/Purchase/Purchase Package Mass/2. Purchase Package Mass Using Insufficient Balance/5.Dashboard Page.png')
} else {
	Mobile.verifyElementVisible(findTestObject('Object Repository/AndroidObj/LockUnlock/objMenuPulsaLainya'), 10, FailureHandling.OPTIONAL)
	
	Mobile.takeScreenshot('/Users/barefputro/Documents/Katalon Studio/dt-automation-katalon/Screenshot/Android/Purchase/Purchase Package Mass/2. Purchase Package Mass Using Insufficient Balance/5.Dashboard Page.png')
}

'Purchase Package Mass Using Insufficient Balance'
Mobile.tap(findTestObject('Object Repository/AndroidObj/PurchasePackageMass/objPurchasePackageMassPaketBtn'), 0)

Mobile.delay(7)

Mobile.takeScreenshot('/Users/barefputro/Documents/Katalon Studio/dt-automation-katalon/Screenshot/Android/Purchase/Purchase Package Mass/2. Purchase Package Mass Using Insufficient Balance/6.Axis Store Page.png')

Mobile.tap(findTestObject('Object Repository/AndroidObj/PurchasePackageMass/objPurchasePackageMassInternetTab'), 0)

Mobile.verifyElementVisible(findTestObject('Object Repository/AndroidObj/PurchasePackageMass/elePurchasePackageMassWarnetUnlimited'), 5, FailureHandling.OPTIONAL)

Mobile.swipe(150, 1500, 400, 1100)

Mobile.swipe(150, 1500, 400, 1100)

Mobile.swipe(150, 1500, 400, 1100)

Mobile.swipe(150, 1500, 400, 1100)

Mobile.swipe(150, 1500, 400, 1100)

Mobile.swipe(150, 1500, 400, 1100)

Mobile.swipe(150, 1500, 400, 1100)

Mobile.swipe(150, 1500, 400, 1100)

Mobile.swipe(150, 1500, 400, 1100)

Mobile.verifyElementVisible(findTestObject('Object Repository/AndroidObj/PurchasePackageMass/elePurchasePackageMassWarnetUnlimited'), 5, FailureHandling.OPTIONAL)

Mobile.takeScreenshot('/Users/barefputro/Documents/Katalon Studio/dt-automation-katalon/Screenshot/Android/Purchase/Purchase Package Mass/2. Purchase Package Mass Using Insufficient Balance/7.Internet Tab - Warnet Unlimited Section.png')

Mobile.tap(findTestObject('Object Repository/AndroidObj/PurchasePackageMass/objPurchasePackageMassWarnetUnlimited1Jam'), 0)

Mobile.verifyElementVisible(findTestObject('Object Repository/AndroidObj/PurchasePackageMass/elePurchasePackageMassWarnetUnlimited1JamPDP'), 30)

Mobile.takeScreenshot('/Users/barefputro/Documents/Katalon Studio/dt-automation-katalon/Screenshot/Android/Purchase/Purchase Package Mass/2. Purchase Package Mass Using Insufficient Balance/8.Warnet Unlimited 1 Jam PDP.png')

Mobile.tap(findTestObject('Object Repository/AndroidObj/PurchasePackageMass/objPurchasePackageMassBeliLangsungBtn'), 0)

Mobile.verifyElementVisible(findTestObject('Object Repository/AndroidObj/PurchasePackageMass/elePurchasePackageMassNomorTujuan'), 30)

Mobile.takeScreenshot('/Users/barefputro/Documents/Katalon Studio/dt-automation-katalon/Screenshot/Android/Purchase/Purchase Package Mass/2. Purchase Package Mass Using Insufficient Balance/9.Warnet Unlimited 1 Jam Pop Up Continue Purchase.png')

Mobile.tap(findTestObject('Object Repository/AndroidObj/PurchasePackagePremium/objPurchasePackagePremiumLanjutBtnPopUp'), 0)

Mobile.verifyElementVisible(findTestObject('Object Repository/AndroidObj/PurchasePackageMass/elePurchasePackageMassKonfirmasiPage'), 30)

Mobile.takeScreenshot('/Users/barefputro/Documents/Katalon Studio/dt-automation-katalon/Screenshot/Android/Purchase/Purchase Package Mass/2. Purchase Package Mass Using Insufficient Balance/10.Warnet Unlimited 1 Jam Konfirmasi Page.png')

Mobile.tap(findTestObject('Object Repository/AndroidObj/PurchasePackageMass/objPurchasePackageMassKonfirmasiBtn'), 0)

Mobile.verifyElementVisible(findTestObject('Object Repository/AndroidObj/PurchasePackageMass/elePurchasePackageMassPopUpInsufficientBalance'), 30)

Mobile.takeScreenshot('/Users/barefputro/Documents/Katalon Studio/dt-automation-katalon/Screenshot/Android/Purchase/Purchase Package Mass/2. Purchase Package Mass Using Insufficient Balance/11.Failed Purchase Warnet Unlimited 1 Jam Insufficient Balance Pop Up Screen.png')

Mobile.closeApplication()