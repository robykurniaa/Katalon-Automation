import org.apache.tools.ant.launch.Locator

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
for (int i = 0; i < 2; i++) {CommonUtils.swipe(Locator.SWIPE_KEY_PKG_TAB, "LEFT")}
CommonUtils.tap(Locator.WARNET_TAB)

'Choose Warnet 24 Jam Package'
CommonUtils.scrollToText('Warnet Unlimited 1 Jam')
CommonUtils.tap(Locator.WARNET_UNL_24JAM)

'Purchase Journey'
PurchaseJourney.successPurchaseWithShopeePay()


