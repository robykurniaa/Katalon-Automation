import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

import axisnet_support.AppManagement as Login
import support.CommonUtils
import axisnet_support.LocatorPaths as Locator
import pages.DashboardPage
import pages.MccmPage as Mccm
import pages.PurchaseJourney
import pages.BonusPage
import tpr.TPRPage as TPR

Login.startApplication('083110568390')

'Tap Menu Paket Paket'
DashboardPage.handleAxisQuickMenu(Locator.PAKET_MENU)

'Tap Paket'
CommonUtils.tap(Locator.PAKET_MENU)

'Tap Internet'
CommonUtils.tap(Locator.CATEGORY_INTERNET)

'Choose Boostr Weekend Tab'
CommonUtils.tap(Locator.BOOSTR_WEEKEND_TAB)

'Handling Boostr Weeekend Package Onboarded'
TPR.handleBoostrWeekendPackage(4)

'Purchase Journey'
PurchaseJourney.createOrderWithGopay()