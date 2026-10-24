import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

import axisnet_support.AppManagement as Login
import support.CommonUtils
import axisnet_support.LocatorPaths as Locator
import pages.DashboardPage
import pages.MccmPage as Mccm
import pages.PurchaseJourney
import pages.BonusPage

Login.startApplication('083125750052', 'DT2022')

'Tap Menu Paket Paket'
DashboardPage.handleAxisQuickMenu(Locator.PAKET_MENU)

'Tap Paket'
CommonUtils.tap(Locator.PAKET_MENU)

'Tap Internet'
CommonUtils.tap(Locator.CATEGORY_INTERNET)

'Choose Warnet Tab'
CommonUtils.tap(Locator.WARNET_TAB)

'Choose Warnet 24 Jam Package'
CommonUtils.scrollToText('Warnet Unlimited 1 Jam')
CommonUtils.tap(Locator.WARNET_UNL_1JAM)

'Purchase Journey'
PurchaseJourney.purchaseWithBalance()
