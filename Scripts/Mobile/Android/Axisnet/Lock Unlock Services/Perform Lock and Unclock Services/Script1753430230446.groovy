import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import axisnet_support.AppManagement as Login
import support.CommonUtils as CommonUtils
import axisnet_support.LocatorPaths as Locator
import pages.DashboardPage as DashboardPage
import pages.PurchaseJourney as PurchaseJourney
import internal.GlobalVariable

Login.startApplication('083827388378', 'DT2022', false)

'Tap Menu Pulsa Lainya'
CommonUtils.tap(Locator.BUTTON_MENU_PULSA_LAINNYA)

'Tap Image Button Lock'
CommonUtils.tap(Locator.IMG_BUTTON_LOCK_SERVICES)

'Tap Telepon'
CommonUtils.tap(Locator.CALL_SERVICE)

'Tap SMS'
CommonUtils.tap(Locator.SMS_SERVICE)

'Tap Internet'
CommonUtils.tap(Locator.INTERNET_SERVICE)

'Tap Button Simpan'
CommonUtils.tap(Locator.BUTTON_SIMPAN)

'Check Success Message'
CommonUtils.tap(Locator.MSG_SUCCESS_SETUP_SERVICES)

