import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

import axisnet_support.AppManagement as Login
import support.CommonUtils
import axisnet_support.LocatorPaths as Locator
import pages.DashboardPage
import pages.PurchaseJourney
import tpr.TPRPage as TPR

Login.startApplication('083825494555')

'Tap Menu Paket Paket'
DashboardPage.handleAxisQuickMenu(Locator.PAKET_MENU)

'Tap Paket'
CommonUtils.tap(Locator.PAKET_MENU)

'Tap Internet'
CommonUtils.tap(Locator.CATEGORY_INTERNET)
Login.quickDeviceTest()
'Choose Boostr Weekend Tab'
CommonUtils.tap(Locator.BOOSTR_WEEKEND_TAB)

'Handling Boostr Weeekend Package Onboarded'
TPR.handleBoostrWeekendOnboarded()
