import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

import axisnet_support.AppManagement as Login
import support.CommonUtils
import axisnet_support.LocatorPaths as Locator
import pages.DashboardPage
import pages.PurchaseJourney
import tpr.TPRPage as TPR

Login.startApplication('083110568390')

'Tap Menu Paket Paket'
DashboardPage.handleAxisQuickMenu(Locator.PAKET_MENU)

'Tap Paket'
CommonUtils.tap(Locator.PAKET_MENU)

'Tap Internet'
CommonUtils.tap(Locator.CATEGORY_INTERNET)

'Choose boostr weekend Tab'
CommonUtils.tap(Locator.BOOSTR_WEEKEND_TAB)

'Handling boostr weekend Package Onboarded'
TPR.handleBoostrWeekendPackage()

'Purchase Journey'
PurchaseJourney.purchaseWithBalance()
