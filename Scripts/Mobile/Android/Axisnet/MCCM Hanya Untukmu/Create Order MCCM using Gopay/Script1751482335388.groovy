import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

import axisnet_support.AppManagement as Login
import support.CommonUtils
import axisnet_support.LocatorPaths as Locator
import pages.DashboardPage
import pages.MccmPage as Mccm
import pages.PurchaseJourney

Login.startApplication('083125750052', 'DT2022')

'Tap Menu Paket Paket'
DashboardPage.handleAxisQuickMenu(Locator.PAKET_MENU)

'Tap Paket'
CommonUtils.tap(Locator.PAKET_MENU)

'Tap Internet Promo'
CommonUtils.tap(Locator.CATEGORY_INTERNET_PROMO)

'Choose MCCM Package'
Mccm.mccmPackageHandling()

'Journey Purchase package PDP -> Receipt'
PurchaseJourney.purchaseWithGopay()
