import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

import axisnet_support.AppManagement as Login
import support.CommonUtils
import axisnet_support.LocatorPaths as Locator
import pages.DashboardPage
import pages.PurchaseJourney

Login.startApplication('083110568390', 'DT2022')

'Tap Quick Menu Paket Suka-Suka'
DashboardPage.handleAxisQuickMenu(Locator.BYOP_MENU)

'Tap Custom Byop'
CommonUtils.tap(Locator.OPEN_BYOP_CUSTOM)

'Select Validity 28 Hari'
CommonUtils.tap(Locator.BYOP_VALIDITY_28D)

'Choose Package with Ribon Tervidio'
CommonUtils.tap(Locator.RIBBON_TERVIDIO)

'Tap Add Ons Tambahain'
CommonUtils.scrollToText('Tambahin')
CommonUtils.tap(Locator.BUTTON_ADD_ONS)

'Tap Add On'
CommonUtils.tap(Locator.FIRST_BUTTON_ADD_ONS)

'Choose Add On Package'
CommonUtils.tap(Locator.FIRST_ADD_ONS_PKG)

'Tap Tambah'
CommonUtils.tap(Locator.BUTTON_TAMBAH)

'Tap Lanjut'
CommonUtils.tap(Locator.BUTTON_LANJUT)
CommonUtils.tap(Locator.BUTTON_LANJUT)

'Handle cnfirmation page & check receipt'
PurchaseJourney.purchaseByopWithBalance()