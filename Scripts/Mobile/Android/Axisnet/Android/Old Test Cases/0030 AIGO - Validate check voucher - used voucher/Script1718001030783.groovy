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

'Login Page'
Mobile.waitForElementPresent(findTestObject('Object Repository/AndroidObj/LoginV1.1/LoginPage/eleLoginPageTitle1stScreen'), 
    10)

Mobile.verifyElementVisible(findTestObject('Object Repository/AndroidObj/LoginV1.1/LoginPage/eleLoginPageDesc1stScreen'), 
    10)

Mobile.takeScreenshot('/Users/barefputro/Documents/Katalon Studio/dt-automation-katalon/Screenshot/Android/Voucher/Voucher AIGO/3. Check Voucher AIGO - Used Voucher/1.Login Page 1st Screen.png')

Mobile.swipe(521, 1152, 466, 373)

Mobile.waitForElementPresent(findTestObject('Object Repository/AndroidObj/LoginV1.1/LoginPage/eleLoginPageTitle2ndScreen'), 
    10)

Mobile.verifyElementVisible(findTestObject('Object Repository/AndroidObj/LoginV1.1/LoginPage/eleLoginPageDesc2ndScreen'), 
    10)

Mobile.takeScreenshot('/Users/barefputro/Documents/Katalon Studio/dt-automation-katalon/Screenshot/Android/Voucher/Voucher AIGO/3. Check Voucher AIGO - Used Voucher/2.Login Page 2nd Screen.png')

Mobile.swipe(521, 1152, 466, 373)

Mobile.waitForElementPresent(findTestObject('Object Repository/AndroidObj/LoginV1.1/LoginPage/eleLoginPageTitle3rdScreen'), 
    10)

Mobile.verifyElementVisible(findTestObject('Object Repository/AndroidObj/LoginV1.1/LoginPage/eleLoginPageDesc3rdScreen'), 
    10)

Mobile.takeScreenshot('/Users/barefputro/Documents/Katalon Studio/dt-automation-katalon/Screenshot/Android/Voucher/Voucher AIGO/3. Check Voucher AIGO - Used Voucher/3.Login Page 3rd Screen.png')

Mobile.tap(findTestObject('Object Repository/AndroidObj/LoginV1.1/LoginPage/objLoginPageLoginButton'), 0)

'Input Number Page'
Mobile.waitForElementPresent(findTestObject('Object Repository/AndroidObj/LoginV1.1/InputNumberPage/eleInputNumberPageTitle'), 
    10)

Mobile.verifyElementVisible(findTestObject('Object Repository/AndroidObj/LoginV1.1/InputNumberPage/eleInputNumberPageDesc1'), 
    10)

Mobile.verifyElementVisible(findTestObject('Object Repository/AndroidObj/LoginV1.1/InputNumberPage/eleInputNumberPageDesc2'), 
    10)

Mobile.takeScreenshot('/Users/barefputro/Documents/Katalon Studio/dt-automation-katalon/Screenshot/Android/Voucher/Voucher AIGO/3. Check Voucher AIGO - Used Voucher/4.Input Number Page.png')

'Input Number'
Mobile.setText(findTestObject('Object Repository/AndroidObj/LoginV1.1/InputNumberPage/objInputNumberPageNumberField'), '083869517232', 
    0)

Mobile.takeScreenshot('/Users/barefputro/Documents/Katalon Studio/dt-automation-katalon/Screenshot/Android/Voucher/Voucher AIGO/3. Check Voucher AIGO - Used Voucher/5.Success Input Number.png')

Mobile.tap(findTestObject('Object Repository/AndroidObj/LoginV1.1/InputNumberPage/objInputNumberPageLoginButton'), 0)

'Input OTP Page'
Mobile.waitForElementPresent(findTestObject('Object Repository/AndroidObj/LoginV1.1/InputOtpPage/eleInputOtpPageTitle'), 
    10)

Mobile.verifyElementVisible(findTestObject('Object Repository/AndroidObj/LoginV1.1/InputOtpPage/eleInputOtpPageDesc'), 
    10)

Mobile.verifyElementVisible(findTestObject('Object Repository/AndroidObj/LoginV1.1/InputOtpPage/eleInputOtpPageResend'), 
    10)

Mobile.takeScreenshot('/Users/barefputro/Documents/Katalon Studio/dt-automation-katalon/Screenshot/Android/Voucher/Voucher AIGO/3. Check Voucher AIGO - Used Voucher/6.Input OTP Page.png')

'Input OTP'
Mobile.setText(findTestObject('Object Repository/AndroidObj/LoginV1.1/InputOtpPage/objInputOtpPageOtpField'), 'DT2022', 
    0)

Mobile.takeScreenshot('/Users/barefputro/Documents/Katalon Studio/dt-automation-katalon/Screenshot/Android/Voucher/Voucher AIGO/3. Check Voucher AIGO - Used Voucher/7.Success Input OTP.png')

Mobile.tap(findTestObject('Object Repository/AndroidObj/LoginV1.1/InputOtpPage/objInputOtpPageContinueButton'), 0)

'TnC Handling'
if (Mobile.waitForElementPresent(findTestObject('Object Repository/AndroidObj/LoginV1.1/TermsAndConditionPage/eleTnCPageTitle'), 
    10, FailureHandling.OPTIONAL)) {
    Mobile.tap(findTestObject('Object Repository/AndroidObj/LoginV1.1/TermsAndConditionPage/eleTnCPageAgreeButton'), 0)
} else {
    Mobile.waitForElementPresent(findTestObject('Object Repository/AndroidObj/LoginV1.1/MedaliaSurveyPopUp/eleMedaliaTitle'), 
        10, FailureHandling.OPTIONAL)
}

'Medalia Handling'
if (Mobile.verifyElementVisible(findTestObject('Object Repository/AndroidObj/MedaliaSurveyV1.1/eleMedaliaTitle'), 10, FailureHandling.OPTIONAL)) {
    Mobile.tap(findTestObject('Object Repository/AndroidObj/MedaliaSurveyV1.1/objMedaliaCloseButton'), 10, FailureHandling.OPTIONAL)

    Mobile.takeScreenshot('/Users/barefputro/Documents/Katalon Studio/dt-automation-katalon/Screenshot/Android/Voucher/Voucher AIGO/3. Check Voucher AIGO - Used Voucher/8.Claim Bonus Page.png')

    Mobile.tap(findTestObject('Object Repository/AndroidObj/LoginAndLogout/objLoginAndLogoutBonusClose'), 10, FailureHandling.OPTIONAL)
} else {
    Mobile.takeScreenshot('/Users/barefputro/Documents/Katalon Studio/dt-automation-katalon/Screenshot/Android/Voucher/Voucher AIGO/3. Check Voucher AIGO - Used Voucher/8.Claim Bonus Page.png')

    Mobile.tap(findTestObject('Object Repository/AndroidObj/LoginAndLogout/objLoginAndLogoutBonusClose'), 10, FailureHandling.OPTIONAL)
}

'Dashboard Page'
if (Mobile.verifyElementVisible(findTestObject('Object Repository/AndroidObj/LoginAndLogout/objLoginAndLogoutCloseBtnEsim'), 
    10, FailureHandling.OPTIONAL)) {
    Mobile.tap(findTestObject('Object Repository/AndroidObj/LoginAndLogout/objLoginAndLogoutCloseBtnEsim'), 10, FailureHandling.OPTIONAL)

    Mobile.verifyElementVisible(findTestObject('Object Repository/AndroidObj/LockUnlock/objMenuPulsaLainya'), 10, FailureHandling.OPTIONAL)
} else {
    Mobile.verifyElementVisible(findTestObject('Object Repository/AndroidObj/LockUnlock/objMenuPulsaLainya'), 10, FailureHandling.OPTIONAL)
}

if (Mobile.verifyElementVisible(findTestObject('Object Repository/AndroidObj/MedaliaSurveyV1.1/eleMedaliaTitle'), 10, FailureHandling.OPTIONAL)) {
    Mobile.tap(findTestObject('Object Repository/AndroidObj/MedaliaSurveyV1.1/objMedaliaCloseButton'), 10, FailureHandling.OPTIONAL)

    Mobile.verifyElementVisible(findTestObject('Object Repository/AndroidObj/LockUnlock/objMenuPulsaLainya'), 10, FailureHandling.OPTIONAL)
} else {
    Mobile.verifyElementVisible(findTestObject('Object Repository/AndroidObj/LockUnlock/objMenuPulsaLainya'), 10, FailureHandling.OPTIONAL)
}

Mobile.verifyElementVisible(findTestObject('Object Repository/AndroidObj/LockUnlock/objMenuPulsaLainya'), 30)

Mobile.takeScreenshot('/Users/barefputro/Documents/Katalon Studio/dt-automation-katalon/Screenshot/Android/Voucher/Voucher AIGO/3. Check Voucher AIGO - Used Voucher/9.Success Login.png')

'Click Isi Voucher Aigo Quick Menu'
Mobile.verifyElementVisible(findTestObject('Object Repository/AndroidObj/DashboardV1.1/objDashboardPageVoucherAigoQuickMenu'), 
    30)

Mobile.tap(findTestObject('Object Repository/AndroidObj/DashboardV1.1/objDashboardPageVoucherAigoQuickMenu'), 0)

Mobile.waitForElementPresent(findTestObject('Object Repository/AndroidObj/VoucherV1.1/eleAigoPageTncTitle'), 30)

Mobile.verifyElementVisible(findTestObject('Object Repository/AndroidObj/VoucherV1.1/eleAigoPageTncDesc1'), 30)

Mobile.verifyElementVisible(findTestObject('Object Repository/AndroidObj/VoucherV1.1/eleAigoPageTncDesc2'), 30)

Mobile.verifyElementVisible(findTestObject('Object Repository/AndroidObj/VoucherV1.1/eleAigoPageTncDesc3'), 30)

Mobile.swipe(521, 1152, 466, 373)

Mobile.verifyElementVisible(findTestObject('Object Repository/AndroidObj/VoucherV1.1/eleAigoPageTncDesc4'), 30)

Mobile.takeScreenshot('/Users/barefputro/Documents/Katalon Studio/dt-automation-katalon/Screenshot/Android/Voucher/Voucher AIGO/3. Check Voucher AIGO - Used Voucher/10.AIGO TnC Page.png')

Mobile.tap(findTestObject('Object Repository/AndroidObj/VoucherV1.1/objAigoPageTncActivateVoucherButton'), 0)

Mobile.waitForElementPresent(findTestObject('Object Repository/AndroidObj/VoucherV1.1/eleAigoPageTitle'), 30)

Mobile.verifyElementVisible(findTestObject('Object Repository/AndroidObj/VoucherV1.1/eleAigoPageDesc1'), 30)

Mobile.verifyElementVisible(findTestObject('Object Repository/AndroidObj/VoucherV1.1/eleAigoPageDesc2'), 30)

Mobile.verifyElementVisible(findTestObject('Object Repository/AndroidObj/VoucherV1.1/eleAigoPageDesc3'), 30)

Mobile.verifyElementVisible(findTestObject('Object Repository/AndroidObj/VoucherV1.1/eleAigoPageDesc4'), 30)

Mobile.swipe(521, 1152, 466, 373)

Mobile.verifyElementVisible(findTestObject('Object Repository/AndroidObj/VoucherV1.1/eleAigoPageBannerTitle'), 30)

Mobile.takeScreenshot('/Users/barefputro/Documents/Katalon Studio/dt-automation-katalon/Screenshot/Android/Voucher/Voucher AIGO/3. Check Voucher AIGO - Used Voucher/11.Voucher Aigo Page Banner.png')

'Check Voucher AIGO - User Voucher'
Mobile.swipe(466, 373, 521, 1152)

Mobile.takeScreenshot('/Users/barefputro/Documents/Katalon Studio/dt-automation-katalon/Screenshot/Android/Voucher/Voucher AIGO/3. Check Voucher AIGO - Used Voucher/12.Voucher Aigo Page Input Voucher Code.png')

Mobile.setText(findTestObject('Object Repository/AndroidObj/VoucherV1.1/objAigoPageInputCodeField'), '3087851320763795', 0)

Mobile.takeScreenshot('/Users/barefputro/Documents/Katalon Studio/dt-automation-katalon/Screenshot/Android/Voucher/Voucher AIGO/3. Check Voucher AIGO - Used Voucher/13.Success Input Code Voucher Aigo.png')

Mobile.tap(findTestObject('Object Repository/AndroidObj/VoucherV1.1/objAigoPageContinueButton'), 0)

Mobile.waitForElementPresent(findTestObject('Object Repository/AndroidObj/VoucherV1.1/eleAigoPagePopUpErrorTitle'), 30)

Mobile.takeScreenshot('/Users/barefputro/Documents/Katalon Studio/dt-automation-katalon/Screenshot/Android/Voucher/Voucher AIGO/3. Check Voucher AIGO - Used Voucher/14.Error Response Used Code Voucher Aigo.png')

Mobile.closeApplication()