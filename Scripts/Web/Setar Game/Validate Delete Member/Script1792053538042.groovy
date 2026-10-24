import support.CommonUtils

import setar_game_support.SetarGameLocatorPaths as Locator
import setar_game_support.WebManagement as Login
import setar_game_support.PaymentUtils as Payment

import internal.GlobalVariable
import setar_game_support.PinHandler as Pin

'Login'
Login.loginToDashboard("083110568390")

'Tap Profile'
CommonUtils.tap(Locator.ICON_USER_DASHBOARD)

'Click Daftar Nomor'
CommonUtils.tap(Locator.MENU_LIST_NUMBER)

'Click Button Tambah Nomor Telfon'
CommonUtils.tap(Locator.BUTTON_OPTION_NUMBER)

'Click Hapus'
CommonUtils.tap(Locator.DELETE_NUMBER)

'Click Ya'
CommonUtils.tap(Locator.BUTTON_YA)

'Check Toast'
//CommonUtils.verifyElementPresent(Locator.TOAST_MSG)
CommonUtils.captureScreenshot()