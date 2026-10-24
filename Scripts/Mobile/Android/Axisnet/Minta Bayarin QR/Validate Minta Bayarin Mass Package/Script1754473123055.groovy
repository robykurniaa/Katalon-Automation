import axisnet_support.AppManagement as Login
import support.CommonUtils
import axisnet_support.LocatorPaths as Locator
import pages.DashboardPage
import pages.MccmPage as Mccm
import pages.PurchaseJourney

Login.startApplication('083869517082', 'DT2022')

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

'Handling Journey Purchase package PDP -> Receipt'
PurchaseJourney.requestAskToPayQR()
