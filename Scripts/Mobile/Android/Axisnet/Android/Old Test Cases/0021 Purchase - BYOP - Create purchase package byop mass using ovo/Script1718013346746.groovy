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

Mobile.takeScreenshot('/Users/barefputro/Documents/Katalon Studio/dt-automation-katalon/Screenshot/Android/Purchase/Purchase BYOP Mass/3. Purchase BYOP Mass Using Multipayment (OVO)/1.Login Page.png')

'Click Login'
Mobile.tap(findTestObject('Object Repository/AndroidObj/LoginAndLogout/objLoginAndLogoutLogin'), 0)

Mobile.waitForElementPresent(findTestObject('Object Repository/AndroidObj/LoginAndLogout/objLoginAndLogoutSetNum'), 30)

'Input Number'
Mobile.delay(1)

Mobile.setText(findTestObject('Object Repository/AndroidObj/LoginAndLogout/objLoginAndLogoutSetNum'), '083869516738', 0)

Mobile.takeScreenshot('/Users/barefputro/Documents/Katalon Studio/dt-automation-katalon/Screenshot/Android/Purchase/Purchase BYOP Mass/3. Purchase BYOP Mass Using Multipayment (OVO)/2.Input Number Page.png')

'Click Next'
Mobile.tap(findTestObject('Object Repository/AndroidObj/LoginAndLogout/objLoginAndLogoutNextLogin'), 0)

Mobile.waitForElementPresent(findTestObject('Object Repository/AndroidObj/LoginAndLogout/objLoginAndLogoutSetOtp'), 30)

'Input OTP'
Mobile.setText(findTestObject('Object Repository/AndroidObj/LoginAndLogout/objLoginAndLogoutSetOtp'), 'DT2022', 0)

Mobile.takeScreenshot('/Users/barefputro/Documents/Katalon Studio/dt-automation-katalon/Screenshot/Android/Purchase/Purchase BYOP Mass/3. Purchase BYOP Mass Using Multipayment (OVO)/3.Input OTP Page.png')

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

	Mobile.takeScreenshot('/Users/barefputro/Documents/Katalon Studio/dt-automation-katalon/Screenshot/Android/Purchase/Purchase BYOP Mass/3. Purchase BYOP Mass Using Multipayment (OVO)/4.Claim Bonus Page.png')

	Mobile.tap(findTestObject('Object Repository/AndroidObj/LoginAndLogout/objLoginAndLogoutBonusClose'), 10, FailureHandling.OPTIONAL)
} else {
	Mobile.takeScreenshot('/Users/barefputro/Documents/Katalon Studio/dt-automation-katalon/Screenshot/Android/Purchase/Purchase BYOP Mass/3. Purchase BYOP Mass Using Multipayment (OVO)/4.Claim Bonus Page.png')

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

	Mobile.takeScreenshot('/Users/barefputro/Documents/Katalon Studio/dt-automation-katalon/Screenshot/Android/Purchase/Purchase BYOP Mass/3. Purchase BYOP Mass Using Multipayment (OVO)/5.Dashboard Page.png')
} else {
	Mobile.verifyElementVisible(findTestObject('Object Repository/AndroidObj/LockUnlock/objMenuPulsaLainya'), 10, FailureHandling.OPTIONAL)
	
	Mobile.takeScreenshot('/Users/barefputro/Documents/Katalon Studio/dt-automation-katalon/Screenshot/Android/Purchase/Purchase BYOP Mass/3. Purchase BYOP Mass Using Multipayment (OVO)/5.Dashboard Page.png')
}

'Purchase BYOP Mass Using Multipayment (OVO)'
Mobile.tap(findTestObject('Object Repository/AndroidObj/PurchasePackageMass/objPurchasePackageMassPaketBtn'), 0)

Mobile.delay(10)

Mobile.takeScreenshot('/Users/barefputro/Documents/Katalon Studio/dt-automation-katalon/Screenshot/Android/Purchase/Purchase BYOP Mass/3. Purchase BYOP Mass Using Multipayment (OVO)/6.Axis Store Page.png')

Mobile.tap(findTestObject('Object Repository/AndroidObj/PurchaseByop/objBYOPStoreCard'), 0)

Mobile.delay(5)

Mobile.takeScreenshot('/Users/barefputro/Documents/Katalon Studio/dt-automation-katalon/Screenshot/Android/Purchase/Purchase BYOP Mass/3. Purchase BYOP Mass Using Multipayment (OVO)/7.BYOP Page.png')

Mobile.verifyElementVisible(findTestObject('Object Repository/AndroidObj/PurchaseByop/eleBYOPMasaAktifSection'), 30,)

Mobile.verifyElementVisible(findTestObject('Object Repository/AndroidObj/PurchaseByop/eleBYOPMasaAktif3Hari'), 30,)

Mobile.tap(findTestObject('Object Repository/AndroidObj/PurchaseByop/objBYOPMasaAktif3HariCard'), 0)

Mobile.takeScreenshot('/Users/barefputro/Documents/Katalon Studio/dt-automation-katalon/Screenshot/Android/Purchase/Purchase BYOP Mass/3. Purchase BYOP Mass Using Multipayment (OVO)/8.Select Masa Aktif.png')

Mobile.verifyElementVisible(findTestObject('Object Repository/AndroidObj/PurchaseByop/eleBYOPKuotaUtamaSection'), 30,)

Mobile.verifyElementVisible(findTestObject('Object Repository/AndroidObj/PurchaseByop/eleBYOPKuotaUtama1GB'), 30,)

Mobile.tap(findTestObject('Object Repository/AndroidObj/PurchaseByop/objBYOPKuotaUtama1GBCard'), 0)

Mobile.takeScreenshot('/Users/barefputro/Documents/Katalon Studio/dt-automation-katalon/Screenshot/Android/Purchase/Purchase BYOP Mass/3. Purchase BYOP Mass Using Multipayment (OVO)/9.Kuota Utama Section.png')

Mobile.swipe(150, 1500, 400, 1100)

Mobile.swipe(150, 1500, 400, 1100)

Mobile.swipe(150, 1500, 400, 1100)

Mobile.verifyElementVisible(findTestObject('Object Repository/AndroidObj/PurchaseByop/eleBYOPKuotaPelengkapSection'), 30,)

Mobile.tap(findTestObject('Object Repository/AndroidObj/PurchaseByop/objBYOPKuotaPelengkapCard'), 0)

Mobile.delay(5)

Mobile.takeScreenshot('/Users/barefputro/Documents/Katalon Studio/dt-automation-katalon/Screenshot/Android/Purchase/Purchase BYOP Mass/3. Purchase BYOP Mass Using Multipayment (OVO)/10.Kuota Pelengkap Page.png')

Mobile.verifyElementVisible(findTestObject('Object Repository/AndroidObj/PurchaseByop/eleBYOPKuotaPelengkapVideo3HariSection'), 30,)

Mobile.tap(findTestObject('Object Repository/AndroidObj/PurchaseByop/objBYOPKuotaPelengkapVideo3HariPilihButton'), 0)

Mobile.takeScreenshot('/Users/barefputro/Documents/Katalon Studio/dt-automation-katalon/Screenshot/Android/Purchase/Purchase BYOP Mass/3. Purchase BYOP Mass Using Multipayment (OVO)/11.Video 3Hari Section.png')

Mobile.verifyElementVisible(findTestObject('Object Repository/AndroidObj/PurchaseByop/eleBYOPKuotaPelengkapVideo3Hari1GB'), 30,)

Mobile.tap(findTestObject('Object Repository/AndroidObj/PurchaseByop/objBYOPKuotaPelengkapVideo3Hari1GBCard'), 0)

Mobile.takeScreenshot('/Users/barefputro/Documents/Katalon Studio/dt-automation-katalon/Screenshot/Android/Purchase/Purchase BYOP Mass/3. Purchase BYOP Mass Using Multipayment (OVO)/12.Video 3Hari 1GB Selected.png')

Mobile.tap(findTestObject('Object Repository/AndroidObj/PurchaseByop/objBYOPKuotaPelengkapTambahkanButton'), 0)

Mobile.swipe(150, 1500, 400, 1100)

Mobile.swipe(150, 1500, 400, 1100)

Mobile.tap(findTestObject('Object Repository/AndroidObj/PurchaseByop/objBYOPLanjutButton'), 0)

Mobile.verifyElementVisible(findTestObject('Object Repository/AndroidObj/PurchaseByop/eleBYOPKonfirmasiPage'), 30,)

Mobile.takeScreenshot('/Users/barefputro/Documents/Katalon Studio/dt-automation-katalon/Screenshot/Android/Purchase/Purchase BYOP Mass/3. Purchase BYOP Mass Using Multipayment (OVO)/13.Konfirmasi Page.png')

Mobile.swipe(150, 1500, 400, 1100)

Mobile.swipe(150, 1500, 400, 1100)

Mobile.tap(findTestObject('Object Repository/AndroidObj/PurchaseByop/objBYOPKonfirmasiChangePaymentMethodButton'), 0)

Mobile.verifyElementVisible(findTestObject('Object Repository/AndroidObj/PurchaseByop/eleBYOPPaymentMethodPage'), 30,)

Mobile.verifyElementVisible(findTestObject('Object Repository/AndroidObj/PurchaseByop/eleBYOPPaymentMethodOvo'), 30,)

Mobile.takeScreenshot('/Users/barefputro/Documents/Katalon Studio/dt-automation-katalon/Screenshot/Android/Purchase/Purchase BYOP Mass/3. Purchase BYOP Mass Using Multipayment (OVO)/14.Payment Method Page.png')

Mobile.tap(findTestObject('Object Repository/AndroidObj/PurchaseByop/objBYOPPaymentMethodOvoChevronButton'), 0)

Mobile.verifyElementVisible(findTestObject('Object Repository/AndroidObj/PurchaseByop/eleBYOPPaymentMethodOvoHalfModalPage'), 30,)

Mobile.setText(findTestObject('Object Repository/AndroidObj/PurchaseByop/objBYOPPaymentMethodOvoInputOvoNumber'), '081806783421', 0)

Mobile.tap(findTestObject('Object Repository/AndroidObj/PurchaseByop/objBYOPPaymentMethodOvoLanjutButton'), 0)

Mobile.swipe(150, 1500, 400, 1100)

Mobile.swipe(150, 1500, 400, 1100)

Mobile.swipe(150, 1500, 400, 1100)

Mobile.verifyElementVisible(findTestObject('Object Repository/AndroidObj/PurchaseByop/objBYOPKonfirmasiChangePaymentMethodButton'), 30,)

Mobile.tap(findTestObject('Object Repository/AndroidObj/PurchaseByop/objBYOPKonfirmasiPageAktivasiSekarangButton'), 0)

Mobile.delay(3)

Mobile.verifyElementVisible(findTestObject('Object Repository/AndroidObj/PurchaseByop/eleBYOPPaymentMethodOvoWaitingPaymentPage'), 30,)

Mobile.takeScreenshot('/Users/barefputro/Documents/Katalon Studio/dt-automation-katalon/Screenshot/Android/Purchase/Purchase BYOP Mass/3. Purchase BYOP Mass Using Multipayment (OVO)/15.Waiting OVO Payment Page.png')

Mobile.tap(findTestObject('Object Repository/AndroidObj/PurchaseByop/objBYOPPaymentMethodOvoCheckPaymentStatusButton'), 0)

Mobile.delay(2)

Mobile.takeScreenshot('/Users/barefputro/Documents/Katalon Studio/dt-automation-katalon/Screenshot/Android/Purchase/Purchase BYOP Mass/3. Purchase BYOP Mass Using Multipayment (OVO)/16.In Progress Receipt Page.png')

Mobile.closeApplication()