import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

import axisnet_support.AppManagement as Login
import support.CommonUtils
import axisnet_support.LocatorPaths as Locator
import pages.DashboardPage
import pages.MccmPage as Mccm
import pages.PurchaseJourney
import pages.BonusPage

Login.startApplication('083891411051', 'DT2022')

'Tap Playground'
CommonUtils.tap(Locator.PLAYGROUND_MENU)

'Tap Top Up Sureprize'
CommonUtils.tap(Locator.PLAYGROUND_TOP_UP_SUREPRIZE)

'Tap Klaim'
CommonUtils.tap(Locator.CLAIM_BUTTON_TOP_UP_SUREPRIZE)

'Swipe'
for (int i = 0; i < 2; i++) {
    CommonUtils.swipe(Locator.SWIPE_KEY_TOP_UP_SUREPRIZE, 'left')
}

'Tap Ambil Bonus'
CommonUtils.tap(Locator.BUTTON_AMBIL_BONUS)

'Tap Button Home if Success Claim Bonus'
CommonUtils.tap(Locator.BUTTON_HOME_SUCCESS_CLAIM_PLAYGROUND)