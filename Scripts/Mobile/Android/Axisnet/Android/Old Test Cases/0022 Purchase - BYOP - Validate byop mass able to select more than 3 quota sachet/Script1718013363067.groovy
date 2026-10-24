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

Mobile.takeScreenshot('/Users/barefputro/Documents/Katalon Studio/dt-automation-katalon/Screenshot/Android/Purchase/Purchase BYOP Mass/4. Purchase BYOP Mass Select More Than 3 Quota Sachet/1.Login Page 1st Screen.png')

Mobile.swipe(521, 1152, 466, 373)

Mobile.waitForElementPresent(findTestObject('Object Repository/AndroidObj/LoginV1.1/LoginPage/eleLoginPageTitle2ndScreen'), 
    10)

Mobile.verifyElementVisible(findTestObject('Object Repository/AndroidObj/LoginV1.1/LoginPage/eleLoginPageDesc2ndScreen'), 
    10)

Mobile.takeScreenshot('/Users/barefputro/Documents/Katalon Studio/dt-automation-katalon/Screenshot/Android/Purchase/Purchase BYOP Mass/4. Purchase BYOP Mass Select More Than 3 Quota Sachet/2.Login Page 2nd Screen.png')

Mobile.swipe(521, 1152, 466, 373)

Mobile.waitForElementPresent(findTestObject('Object Repository/AndroidObj/LoginV1.1/LoginPage/eleLoginPageTitle3rdScreen'), 
    10)

Mobile.verifyElementVisible(findTestObject('Object Repository/AndroidObj/LoginV1.1/LoginPage/eleLoginPageDesc3rdScreen'), 
    10)

Mobile.takeScreenshot('/Users/barefputro/Documents/Katalon Studio/dt-automation-katalon/Screenshot/Android/Purchase/Purchase BYOP Mass/4. Purchase BYOP Mass Select More Than 3 Quota Sachet/3.Login Page 3rd Screen.png')

Mobile.tap(findTestObject('Object Repository/AndroidObj/LoginV1.1/LoginPage/objLoginPageLoginButton'), 0)

'Input Number Page'
Mobile.waitForElementPresent(findTestObject('Object Repository/AndroidObj/LoginV1.1/InputNumberPage/eleInputNumberPageTitle'), 
    10)

Mobile.verifyElementVisible(findTestObject('Object Repository/AndroidObj/LoginV1.1/InputNumberPage/eleInputNumberPageDesc1'), 
    10)

Mobile.verifyElementVisible(findTestObject('Object Repository/AndroidObj/LoginV1.1/InputNumberPage/eleInputNumberPageDesc2'), 
    10)

Mobile.takeScreenshot('/Users/barefputro/Documents/Katalon Studio/dt-automation-katalon/Screenshot/Android/Purchase/Purchase BYOP Mass/4. Purchase BYOP Mass Select More Than 3 Quota Sachet/4.Input Number Page.png')

'Input Number'
Mobile.setText(findTestObject('Object Repository/AndroidObj/LoginV1.1/InputNumberPage/objInputNumberPageNumberField'), '083869517232', 
    0)

Mobile.takeScreenshot('/Users/barefputro/Documents/Katalon Studio/dt-automation-katalon/Screenshot/Android/Purchase/Purchase BYOP Mass/4. Purchase BYOP Mass Select More Than 3 Quota Sachet/5.Success Input Number.png')

Mobile.tap(findTestObject('Object Repository/AndroidObj/LoginV1.1/InputNumberPage/objInputNumberPageLoginButton'), 0)

'Input OTP Page'
Mobile.waitForElementPresent(findTestObject('Object Repository/AndroidObj/LoginV1.1/InputOtpPage/eleInputOtpPageTitle'), 
    10)

Mobile.verifyElementVisible(findTestObject('Object Repository/AndroidObj/LoginV1.1/InputOtpPage/eleInputOtpPageDesc'), 10)

Mobile.verifyElementVisible(findTestObject('Object Repository/AndroidObj/LoginV1.1/InputOtpPage/eleInputOtpPageResend'), 
    10)

Mobile.takeScreenshot('/Users/barefputro/Documents/Katalon Studio/dt-automation-katalon/Screenshot/Android/Purchase/Purchase BYOP Mass/4. Purchase BYOP Mass Select More Than 3 Quota Sachet/6.Input OTP Page.png')

'Input OTP'
Mobile.setText(findTestObject('Object Repository/AndroidObj/LoginV1.1/InputOtpPage/objInputOtpPageOtpField'), 'DT2022', 
    0)

Mobile.takeScreenshot('/Users/barefputro/Documents/Katalon Studio/dt-automation-katalon/Screenshot/Android/Purchase/Purchase BYOP Mass/4. Purchase BYOP Mass Select More Than 3 Quota Sachet/7.Success Input OTP.png')

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

    Mobile.tap(findTestObject('Object Repository/AndroidObj/PlaygroundV1.1/objBonusNonstopPageCloseButton'), 10, FailureHandling.OPTIONAL)
} else {
    Mobile.tap(findTestObject('Object Repository/AndroidObj/PlaygroundV1.1/objBonusNonstopPageCloseButton'), 10, FailureHandling.OPTIONAL)
}

'Dashboard Page'
if (Mobile.verifyElementVisible(findTestObject('Object Repository/AndroidObj/LoginAndLogout/objLoginAndLogoutCloseBtnEsim'), 
    10, FailureHandling.OPTIONAL)) {
    Mobile.tap(findTestObject('Object Repository/AndroidObj/DashboardV1.1/objDashboardPageMoengPopUpCloseButton'), 10, FailureHandling.OPTIONAL)

    Mobile.verifyElementVisible(findTestObject('Object Repository/AndroidObj/DashboardV1.1/objDashboardPageBalanceMoreMenu'), 
        10, FailureHandling.OPTIONAL)
} else {
    Mobile.verifyElementVisible(findTestObject('Object Repository/AndroidObj/DashboardV1.1/objDashboardPageBalanceMoreMenu'), 
        10, FailureHandling.OPTIONAL)
}

if (Mobile.verifyElementVisible(findTestObject('Object Repository/AndroidObj/MedaliaSurveyV1.1/eleMedaliaTitle'), 10, FailureHandling.OPTIONAL)) {
    Mobile.tap(findTestObject('Object Repository/AndroidObj/MedaliaSurveyV1.1/objMedaliaCloseButton'), 10, FailureHandling.OPTIONAL)

    Mobile.verifyElementVisible(findTestObject('Object Repository/AndroidObj/DashboardV1.1/objDashboardPageBalanceMoreMenu'), 
        10, FailureHandling.OPTIONAL)
} else {
    Mobile.verifyElementVisible(findTestObject('Object Repository/AndroidObj/DashboardV1.1/objDashboardPageBalanceMoreMenu'), 
        10, FailureHandling.OPTIONAL)
}

Mobile.waitForElementPresent(findTestObject('Object Repository/AndroidObj/DashboardV1.1/eleDashboardPageTitleHanyaUntukmu'), 
    30)

Mobile.takeScreenshot('/Users/barefputro/Documents/Katalon Studio/dt-automation-katalon/Screenshot/Android/Purchase/Purchase BYOP Mass/4. Purchase BYOP Mass Select More Than 3 Quota Sachet/8.Success Login.png')

'Purchase BYOP Mass Select More Than 3 Quota Sachet'
Mobile.tap(findTestObject('Object Repository/AndroidObj/DashboardV1.1/objDashboardPageAxisStoreFooterMenu'), 0)

Mobile.waitForElementPresent(findTestObject('Object Repository/AndroidObj/AxisStoreV1.1/objAxisStorePageHanyaUntukmuTab'), 
    30)

Mobile.takeScreenshot('/Users/barefputro/Documents/Katalon Studio/dt-automation-katalon/Screenshot/Android/Purchase/Purchase BYOP Mass/4. Purchase BYOP Mass Select More Than 3 Quota Sachet/9.Axis Store Page.png')

Mobile.tap(findTestObject('Object Repository/AndroidObj/AxisStoreV1.1/objAxisStorePageBYOPCard'), 0)

Mobile.waitForElementPresent(findTestObject('Object Repository/AndroidObj/BYOPV1.1/objByopPageMasaAktifPaket3HariCard'), 
    30)

Mobile.takeScreenshot('/Users/barefputro/Documents/Katalon Studio/dt-automation-katalon/Screenshot/Android/Purchase/Purchase BYOP Mass/4. Purchase BYOP Mass Select More Than 3 Quota Sachet/10.BYOP Page.png')

Mobile.tap(findTestObject('Object Repository/AndroidObj/PurchaseByop/objBYOPMasaAktif3HariCard'), 0)

Mobile.scrollToText('Masa Aktif Paketmu')

Mobile.takeScreenshot('/Users/barefputro/Documents/Katalon Studio/dt-automation-katalon/Screenshot/Android/Purchase/Purchase BYOP Mass/4. Purchase BYOP Mass Select More Than 3 Quota Sachet/11.Selected Masa Aktif.png')

Mobile.scrollToText('Berapa banyak kuota utama yang diperlukan?')

Mobile.waitForElementPresent(findTestObject('Object Repository/AndroidObj/BYOPV1.1/eleByopPageKuotaUtamaTitle'), 30)

Mobile.tap(findTestObject('Object Repository/AndroidObj/BYOPV1.1/objByopPageKuotaUtama1GbCard'), 0)

Mobile.takeScreenshot('/Users/barefputro/Documents/Katalon Studio/dt-automation-katalon/Screenshot/Android/Purchase/Purchase BYOP Mass/4. Purchase BYOP Mass Select More Than 3 Quota Sachet/12.Selected Kuota Utama.png')

Mobile.scrollToText('Tambah Kuota Pelengkap')

Mobile.waitForElementPresent(findTestObject('Object Repository/AndroidObj/BYOPV1.1/objByopPageTambahKuotaPelengkapButton'), 
    30)

Mobile.tap(findTestObject('Object Repository/AndroidObj/BYOPV1.1/objByopPageTambahKuotaPelengkapButton'), 0)

Mobile.waitForElementPresent(findTestObject('Object Repository/AndroidObj/BYOPV1.1/eleByopPageVideo3HariTitle'), 30)

Mobile.verifyElementVisible(findTestObject('Object Repository/AndroidObj/BYOPV1.1/eleByopPageKuotaAplikasiSatuanCardTitle'), 
    30)

Mobile.verifyElementVisible(findTestObject('Object Repository/AndroidObj/BYOPV1.1/eleByopPageKuotaAplikasiSatuanCardDesc'), 
    30)

Mobile.takeScreenshot('/Users/barefputro/Documents/Katalon Studio/dt-automation-katalon/Screenshot/Android/Purchase/Purchase BYOP Mass/4. Purchase BYOP Mass Select More Than 3 Quota Sachet/13.Tambah Kuota Pelengkap Page.png')

Mobile.tap(findTestObject('Object Repository/AndroidObj/BYOPV1.1/objByopPageKuotaAplikasiSatuanCardPilihButton'), 0)

Mobile.waitForElementPresent(findTestObject('Object Repository/AndroidObj/BYOPV1.1/eleByopPageKuotaAplikasiSatuanPageSosmedSection'), 
    30)

Mobile.verifyElementVisible(findTestObject('Object Repository/AndroidObj/BYOPV1.1/objByopPageKuotaAplikasiSatuanPageBackButton'), 
    30)

Mobile.verifyElementVisible(findTestObject('Object Repository/AndroidObj/BYOPV1.1/eleByopPageKuotaAplikasiSatuanPageTitle'), 
    30)

Mobile.verifyElementVisible(findTestObject('Object Repository/AndroidObj/BYOPV1.1/eleByopPageKuotaAplikasiSatuanPageVideoSection'), 
    30)

Mobile.scrollToText('LAINNYA')

Mobile.verifyElementVisible(findTestObject('Object Repository/AndroidObj/BYOPV1.1/eleByopPageKuotaAplikasiSatuanPageChatSection'), 
    30)

Mobile.verifyElementVisible(findTestObject('Object Repository/AndroidObj/BYOPV1.1/eleByopPageKuotaAplikasiSatuanPageGameSection'), 
    30)

Mobile.verifyElementVisible(findTestObject('Object Repository/AndroidObj/BYOPV1.1/eleByopPageKuotaAplikasiSatuanPageConferenceSection'), 
    30)

Mobile.verifyElementVisible(findTestObject('Object Repository/AndroidObj/BYOPV1.1/eleByopPageKuotaAplikasiSatuanPageKomikSection'), 
    30)

Mobile.verifyElementVisible(findTestObject('Object Repository/AndroidObj/BYOPV1.1/eleByopPageKuotaAplikasiSatuanPageMusicSection'), 
    30)

Mobile.verifyElementVisible(findTestObject('Object Repository/AndroidObj/BYOPV1.1/eleByopPageKuotaAplikasiSatuanPageLainyaSection'), 
    30)

Mobile.scrollToText('VIDEO')

Mobile.takeScreenshot('/Users/barefputro/Documents/Katalon Studio/dt-automation-katalon/Screenshot/Android/Purchase/Purchase BYOP Mass/4. Purchase BYOP Mass Select More Than 3 Quota Sachet/14.Tambah Kuota Aplikasi Satuan Page.png')

'Select Youtube - Video Section'
Mobile.tapAtPosition(964, 645)

Mobile.tap(findTestObject('Object Repository/AndroidObj/BYOPV1.1/objByopPageKuotaAplikasiSatuanPage1GbQuota'), 0)

Mobile.takeScreenshot('/Users/barefputro/Documents/Katalon Studio/dt-automation-katalon/Screenshot/Android/Purchase/Purchase BYOP Mass/4. Purchase BYOP Mass Select More Than 3 Quota Sachet/15.Select Youtube as Kuota Aplikasi Satuan.png')

'Select Instagram - Sosmed Section'
Mobile.tapAtPosition(964, 1539)

Mobile.tap(findTestObject('Object Repository/AndroidObj/BYOPV1.1/objByopPageKuotaAplikasiSatuanPage1GbQuota'), 0)

Mobile.takeScreenshot('/Users/barefputro/Documents/Katalon Studio/dt-automation-katalon/Screenshot/Android/Purchase/Purchase BYOP Mass/4. Purchase BYOP Mass Select More Than 3 Quota Sachet/16.Select Instagram as Kuota Aplikasi Satuan.png')

Mobile.swipe(507, 1379, 507, 842)

'Select Whatsapp - Chat Section'
Mobile.tapAtPosition(964, 1514)

Mobile.tap(findTestObject('Object Repository/AndroidObj/BYOPV1.1/objByopPageKuotaAplikasiSatuanPage1GbQuota'), 0)

Mobile.takeScreenshot('/Users/barefputro/Documents/Katalon Studio/dt-automation-katalon/Screenshot/Android/Purchase/Purchase BYOP Mass/4. Purchase BYOP Mass Select More Than 3 Quota Sachet/17.Select Whatsapp as Kuota Aplikasi Satuan.png')

Mobile.swipe(507, 1288, 507, 537)

Mobile.takeScreenshot('/Users/barefputro/Documents/Katalon Studio/dt-automation-katalon/Screenshot/Android/Purchase/Purchase BYOP Mass/4. Purchase BYOP Mass Select More Than 3 Quota Sachet/18.Failed Select Zoom as Kuota Aplikasi Satuan - Disabled Dropdown.png')

Mobile.closeApplication()

