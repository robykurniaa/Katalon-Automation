import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

import axisnet_support.AppManagement as Login
import support.CommonUtils
import axisnet_support.LocatorPaths as Locator
import internal.GlobalVariable
import pages.DashboardPage
import pages.PurchaseJourney

Login.startApplication(GlobalVariable.Regression_Msisdn)

'Tap Quick Menu Paket Suka-Suka'
DashboardPage.handleAxisQuickMenu(Locator.LIHAT_SEMUA_MENU)
CommonUtils.tap(Locator.BYOP_MENU)

'Tap Recommendation Byop'
CommonUtils.tap(Locator.OPEN_BYOP_RECOMMEDATION)

'Choose Persona'
CommonUtils.tap(Locator.BYOP_PERSONA_SOSMEDHOLIC)

'Select Validity'
CommonUtils.tap(Locator.BYOP_RECOMM_VALIDITY_3D)

'Tap Button Aktivasi'
CommonUtils.scrollToText('EDIT SEDIKIT')
CommonUtils.tap(Locator.BUTTON_AKTIVASI)

'Handle confirmation page & check receipt'
PurchaseJourney.purchaseByopWithBalance()
