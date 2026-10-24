import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

import axisnet_support.AppManagement as Login
import support.CommonUtils
import axisnet_support.LocatorPaths as Locator
import pages.DashboardPage
import pages.PurchaseJourney

Login.startApplication('083110568390', 'DT2022')

'Tap Quick Menu Donasi Kuota'
DashboardPage.handleAxisQuickMenu(Locator.DONASI_KUOTA_MENU)

'Scroll Down'
CommonUtils.scrollToText('Router')

'Tap Button Donasi'
CommonUtils.tap(Locator.BUTTON_DONASI)

'Tap Donasi Sekarang'
CommonUtils.tap(Locator.BUTTON_DONASI_SEKARANG)

'CheckBox Kuota'
CommonUtils.tap(Locator.CHECKBOX_KUOTA_DONASI)

'Tap Pilih Nominal Donasi'
CommonUtils.tap(Locator.BUTTON_PILIH_NOMINAL_DONASI)

'Choose Denom Kuota'
CommonUtils.tap(Locator.LIST_NOMINAL_DONASI_100)

'Tap Button Konfirmasi'
CommonUtils.tap(Locator.BUTTON_KONFIRMASI)

'Success Donasi Kuota'
CommonUtils.tap(Locator.BUTTON_KEMBALI_KE_HOME)

