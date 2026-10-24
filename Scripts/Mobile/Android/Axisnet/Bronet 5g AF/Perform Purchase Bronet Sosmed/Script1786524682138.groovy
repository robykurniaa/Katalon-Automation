import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

import axisnet_support.AppManagement as Login
import support.CommonUtils
import axisnet_support.LocatorPaths as Locator
import internal.GlobalVariable
import pages.DashboardPage
import pages.MccmPage as Mccm
import pages.PurchaseJourney
import pages.BonusPage

Login.startApplication('083110568390')

'Tap Menu Paket Paket'
DashboardPage.handleAxisQuickMenu(Locator.PAKET_MENU)

'Tap Paket'
CommonUtils.tap(Locator.PAKET_MENU)
	
'Tap Internet'
CommonUtils.tap(Locator.CATEGORY_BRONET)

'Choose Bronet Package'
CommonUtils.scrollToText("Bronet Sosmed")
CommonUtils.tap(Locator.BRONET_SOSMED_5GB_3HR)

'Purchase Journey'
PurchaseJourney.purchaseWithBalance()
