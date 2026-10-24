import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

import axisnet_support.AppManagement as Login
import support.CommonUtils
import axisnet_support.LocatorPaths as Locator
import internal.GlobalVariable
import pages.DashboardPage
import pages.PurchaseJourney
import pages.AxisIOUPage as IOU

Login.startApplication(GlobalVariable.Regression_Msisdn, 'DT2022', false)	

'Tap Quick Menu Pulsa Darurat'
DashboardPage.handleAxisQuickMenu(Locator.LIHAT_SEMUA_MENU)
CommonUtils.scrollToText("Darurat")
CommonUtils.tap(Locator.IOU_MENU)

'Swipe Landing Page'
IOU.handlingIouLandingPage()

'Tap Button Gunakan Pulsa Darurat'
CommonUtils.tap(Locator.BUTTON_GUNAKAN_IOU)

'Tap Button Pinjam'
CommonUtils.tap(Locator.BUTTON_PINJAM)

'Choose Nominal'
IOU.HandlingIouAmount()

'Tap Button Lanjut'
CommonUtils.tap(Locator.BUTTON_LANJUT_IOU)

'Check Box TnC'
CommonUtils.tap(Locator.CHECKBOX_IOU)

'Tap Konfirmasi'
CommonUtils.tap(Locator.BUTTON_KONFIRMASI)

'Check Receipt'
CommonUtils.isElementExist(Locator.BUTTON_KE_HOME)