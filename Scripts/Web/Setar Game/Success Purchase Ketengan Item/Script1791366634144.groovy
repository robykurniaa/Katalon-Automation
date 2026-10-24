import support.CommonUtils

import setar_game_support.SetarGameLocatorPaths as Locator
import setar_game_support.WebManagement as Login
import setar_game_support.PaymentUtils as Payment

import internal.GlobalVariable
import setar_game_support.PinHandler as Pin

'Login'
Login.loginToDashboard("083110568390")

'Search game'
CommonUtils.setText(Locator.SEARCH_BAR, "Free Fire")

'select game'
CommonUtils.tap(Locator.FREE_FIRE)

'input user id'
CommonUtils.setText(Locator.USER_ID, "6710588672")

'change first denom'
CommonUtils.tap(Locator.FIRST_DENOM)

'tap button'
CommonUtils.tap(Locator.BUTTON_LANJUTKAN)

'handling payment and number'
Payment.processPaymentSelection()

'input pin'
CommonUtils.setText(Locator.INPUT_PIN, GlobalVariable.SetarGameProdPin)

'tap button'
CommonUtils.tap(Locator.BUTTON_KONFIRMASI)

'tap history'
CommonUtils.tap(Locator.MENU_HISTORY)

'Cek detail Trx'
CommonUtils.tap(Locator.FIRST_DETAIL_TRANSAKSI)
CommonUtils.verifyElementPresent(Locator.HEADER_DETAIL_ORDER)



