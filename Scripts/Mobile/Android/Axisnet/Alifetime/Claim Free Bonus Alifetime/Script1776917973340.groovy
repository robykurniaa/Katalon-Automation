import axisnet_support.AppManagement as Login
import support.BaseTest
import support.CommonUtils
import support.LocatorUtil
import axisnet_support.LocatorPaths as Locator

Login.startApplication('083827388378')

'Tap Alifetime Menu'
CommonUtils.tap(Locator.ALIFETIME_MENU)

'Choose Bonus'
CommonUtils.swipe(Locator.RANDOM_FREE_BONUS, "left")
CommonUtils.tap(Locator.RANDOM_FREE_BONUS)

'Success Claim Bonus'
2.times {CommonUtils.tap(Locator.BUTTON_TUKAR_SEKARANG)}

CommonUtils.tap(Locator.BUTTON_KE_ALIFETIME)