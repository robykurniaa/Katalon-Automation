import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

import axisnet_support.AppManagement as Login
import support.CommonUtils
import axisnet_support.LocatorPaths as Locator
import internal.GlobalVariable
import pages.DashboardPage
import pages.MccmPage as Mccm
import pages.PurchaseJourney
import pages.BonusPage

Login.startApplication('083891411051')

'Tap Menu Paket Paket'
DashboardPage.handleAxisQuickMenu(Locator.PAKET_MENU)

'Tap Paket'
CommonUtils.tap(Locator.PAKET_MENU)

'Tap Internet'
CommonUtils.tap(Locator.CATEGORY_INTERNET)

'Choose Warnet Tab'
CommonUtils.tap(Locator.WARNET_TAB)

'Choose Warnet Regular Package'
CommonUtils.tap(Locator.WARNET_REG_1JAM)

'Purchase Journey'
PurchaseJourney.purchaseWithBalance()
