import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

import axisnet_support.AppManagement as Login
import support.CommonUtils
import axisnet_support.LocatorPaths as Locator
import pages.DashboardPage
import pages.ByopPage as Byop
import pages.PurchaseJourney

Login.startApplication('083125750052', 'DT2022')

'Tap Quick Menu Paket Suka-Suka'
DashboardPage.handleAxisQuickMenu(Locator.BYOP_MENU)

'Tap Custom Byop'
CommonUtils.tap(Locator.OPEN_BYOP_CUSTOM)

'Find Byop MCCM'
Byop.HandlingByopMccm()

'Tap Add Ons Tambahain'
CommonUtils.scrollToText('Tambahin')
CommonUtils.tap(Locator.BUTTON_ADD_ONS)

'Tap Conference Add On'
CommonUtils.scrollToText('Conference')
CommonUtils.tap(Locator.BUTTON_ADD_ON_CONFERENCE)

'Choose Add On Package'
CommonUtils.tap(Locator.ADD_ON_PKG_INDEX_1)

'Tap Tambah'
CommonUtils.tap(Locator.BUTTON_TAMBAH)

'Tap Lanjut'
CommonUtils.tap(Locator.BUTTON_LANJUT)
CommonUtils.tap(Locator.BUTTON_LANJUT)

'Handle cnfirmation page & check receipt'
PurchaseJourney.purchaseByopWithBalance()
