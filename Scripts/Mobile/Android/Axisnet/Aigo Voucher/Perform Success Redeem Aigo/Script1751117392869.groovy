import axisnet_support.AppManagement as Login
import support.CommonUtils
import axisnet_support.LocatorPaths as Locator
import internal.GlobalVariable
import pages.DashboardPage
import pages.PurchaseJourney

Login.startApplication('083125750052')

'Tap Quick Menu Donasi Kuota'
DashboardPage.handleAxisQuickMenu(Locator.ISI_AIGO_MENU)

'Tap Aktifkan Voucher'
CommonUtils.handleOptionalElement(Locator.BUTTON_AKTIFKAN_VOUCHER, { CommonUtils.tap(Locator.BUTTON_AKTIFKAN_VOUCHER) }, 5)

'Fill Aigo Code'
CommonUtils.setText(Locator.AIGO_FIELD, '374874837838378437')

'Tap Lanjut'
CommonUtils.tap(Locator.BUTTON_LANJUT)

'Tap Konfirmasi'
CommonUtils.tap(Locator.BUTTON_KONFIRMASI)

'Tap Homepage'
CommonUtils.tap(Locator.BUTTON_KE_HOME)