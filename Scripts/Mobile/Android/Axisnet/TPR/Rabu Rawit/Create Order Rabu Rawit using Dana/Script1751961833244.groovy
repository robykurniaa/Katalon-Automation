import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

import axisnet_support.AppManagement as Login
import support.CommonUtils
import axisnet_support.LocatorPaths as Locator
import pages.DashboardPage
import pages.PurchaseJourney
import tpr.TPRPage as TPR

Login.startApplication('083110568297')

'Tap Menu Paket Paket'
DashboardPage.handleAxisQuickMenu(Locator.PAKET_MENU)

'Tap Paket'
CommonUtils.tap(Locator.PAKET_MENU)

'Tap Internet'
CommonUtils.tap(Locator.CATEGORY_INTERNET)

'Choose Rabu Rawit Tab'
CommonUtils.tap(Locator.RABU_RAWIT_TAB)

'Handling Rabu Rawit Package Onboarded'
TPR.handleRabuRawitPackage()

'Purchase Journey'
PurchaseJourney.purchaseWithDana()
