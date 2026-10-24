import support.CommonUtils
import setar_game_support.SetarGameLocatorPaths as Locator
import setar_game_support.WebManagement as Login
import setar_game_support.PaymentUtils as Payment

import internal.GlobalVariable

import support.CommonUtils

import setar_game_support.SetarGameLocatorPaths as Locator
import setar_game_support.WebManagement as Login
import setar_game_support.PaymentUtils as Payment

import internal.GlobalVariable
int targetQuantity = 500
'Login'
Login.loginToDashboard("083110568390")

'Choose Borongan'
CommonUtils.tap(Locator.MODE_BORONGAN)

'select game'
CommonUtils.tap(Locator.G_PLAY)

'change first denom'
CommonUtils.tap(Locator.FIRST_DENOM)

'Set Quantity'
CommonUtils.tap(Locator.BUTTON_BELI)
CommonUtils.setText(Locator.INPUT_QUANTITY, targetQuantity.toString())
CommonUtils.tap(Locator.BUTTON_LANJUTKAN)

'Verify Transaction Quantity on Details Page'
Payment.verifyTransactionQuantity(targetQuantity)

'handling payment and number'
CommonUtils.verifyElementPresent(Locator.WARNING_INSUFF_BALANCE)


