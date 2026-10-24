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
CommonUtils.tap(Locator.ADD_PHONE_NUMBER)

'Add Number'
CommonUtils.setText(Locator.SET_NUMBER, '083827388378')

'Set OTP'
Login.handleManualRecaptcha()
Login.handleManualOtp()

'Check Toast'
CommonUtils.verifyElementPresent(Locator.TOAST_MSG)