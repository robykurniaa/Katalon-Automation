import axisnet_support.AppManagement as Login
import support.CommonUtils
import axisnet_support.LocatorPaths as Locator
import internal.GlobalVariable
import pages.DashboardPage
import pages.MccmPage as Mccm
import pages.PurchaseJourney
import pages.BonusPage
import axisnet_support.PackageHandler

'Start App'
Login.startApplication('083110568390')

'Tap Menu Paket Paket'
DashboardPage.handleAxisQuickMenu(Locator.PAKET_MENU)

'Tap Paket'
CommonUtils.tap(Locator.PAKET_MENU)

'Choose Bronet Package'
PackageHandler.processPackageSelection("Internet", "Bronet 5G AF", "BRONET 65GB")

'Purchase Journey'
PurchaseJourney.purchaseWithBalance()