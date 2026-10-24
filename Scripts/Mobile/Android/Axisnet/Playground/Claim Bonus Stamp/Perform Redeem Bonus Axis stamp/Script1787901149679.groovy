import axisnet_support.AppManagement as Login
import support.BaseTest
import support.CommonUtils
import support.LocatorUtil
import axisnet_support.LocatorPaths as Locator
import internal.GlobalVariable

Login.startApplication(GlobalVariable.Regression_Msisdn)

'Tap Playground'
CommonUtils.tap(Locator.PLAYGROUND_MENU)

'Tap Sureprize'
CommonUtils.tap(Locator.PLAYGROUND_SUREPRIZE)

'Tap Button Ambil'
CommonUtils.tap(Locator.BUTTON_SUREPRIZE_CLAIM)

'Tap Button Home'
CommonUtils.tap(Locator.BUTTON_HOME_SUCCESS_CLAIM_PLAYGROUND)


