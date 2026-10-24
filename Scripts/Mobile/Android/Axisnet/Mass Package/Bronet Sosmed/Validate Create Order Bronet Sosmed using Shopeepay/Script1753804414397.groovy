import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

import axisnet_support.AppManagement as Login
import support.CommonUtils
import axisnet_support.LocatorPaths as Locator
import pages.DashboardPage
import pages.MccmPage as Mccm
import pages.PurchaseJourney
import pages.BonusPage

Login.startApplication('083827388378', 'DT2022')

'Tap Menu Paket Paket'
DashboardPage.handleAxisQuickMenu(Locator.PAKET_MENU)

'Tap Paket'
CommonUtils.tap(Locator.PAKET_MENU)

'Tap Internet'
CommonUtils.tap(Locator.CATEGORY_INTERNET)

'Choose Bronet Tab'
CommonUtils.tap(Locator.BRONET_TAB)

'Choose Bronet Package'
CommonUtils.tap(Locator.BRONET_SOSMED_5GB_3HR)

'Purchase Journey'
PurchaseJourney.purchaseWithGopay()
