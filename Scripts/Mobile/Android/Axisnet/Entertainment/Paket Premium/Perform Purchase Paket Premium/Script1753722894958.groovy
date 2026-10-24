import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

import axisnet_support.AppManagement as Login
import support.CommonUtils
import axisnet_support.LocatorPaths as Locator
import pages.DashboardPage
import pages.MccmPage as Mccm
import pages.PurchaseJourney
import pages.BonusPage
import pages.TPRPage as TPR

Login.startApplication('083110568390', 'DT2022')

'Tap Menu Hiburan'
DashboardPage.handleAxisQuickMenu(Locator.HIBURAN_MENU)

'Tap Paket Nonton'
CommonUtils.tap(Locator.PAKET_PREMIUM_TAB)

'Choose Banner'
CommonUtils.tap(Locator.PAKET_PREMIUM_BANNER_2)

'Select Package'
CommonUtils.tap(Locator.PREMIUM_UDEMY_7HR)

'Tap Lanjut'
CommonUtils.tap(Locator.BUTTON_LANJUT)

'Purchase Journey'
PurchaseJourney.purchaseWithBalance()







