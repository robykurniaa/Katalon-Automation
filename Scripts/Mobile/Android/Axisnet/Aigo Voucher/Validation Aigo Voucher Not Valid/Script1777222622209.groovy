import axisnet_support.AppManagement as Login
import support.CommonUtils
import axisnet_support.LocatorPaths as Locator
import pages.DashboardPage
import pages.PurchaseJourney

Login.startApplication('083110568297', 'DT2022')

'Tap Quick Menu Donasi Kuota'
DashboardPage.handleAxisQuickMenu(Locator.ISI_AIGO_MENU)

'Tap Aktifkan Voucher'
CommonUtils.handleOptionalElement(Locator.BUTTON_AKTIFKAN_VOUCHER, { CommonUtils.tap(Locator.BUTTON_AKTIFKAN_VOUCHER) }, 5)

'Fill Aigo Code'
CommonUtils.setText(Locator.AIGO_FIELD, '0000231464126274')

'Tap Lanjut'
CommonUtils.tap(Locator.BUTTON_LANJUT)

'Validate Aigo'
CommonUtils.isElementPresent(Locator.AIGO_NOT_VALID)
