import support.CommonUtils

import setar_game_support.SetarGameLocatorPaths as Locator
import setar_game_support.WebManagement as Login
import setar_game_support.PaymentUtils as Payment



import internal.GlobalVariable

'Login'
Login.loginToDashboard("083110568390")

'Choose Borongan'
CommonUtils.tap(Locator.MODE_BORONGAN)

'select game'
CommonUtils.tap(Locator.G_PLAY)

'change first denom'
CommonUtils.tap(Locator.FIRST_DENOM)

'input user id'
CommonUtils.tap(Locator.BUTTON_BELI)
//CommonUtils.tap(Locator.BUTTON_PLUS)

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
CommonUtils.tap(Locator.MODE_BORONGAN)
CommonUtils.tap(Locator.FIRST_DETAIL_TRANSAKSI)
CommonUtils.verifyElementPresent(Locator.HEADER_DETAIL_ORDER)



