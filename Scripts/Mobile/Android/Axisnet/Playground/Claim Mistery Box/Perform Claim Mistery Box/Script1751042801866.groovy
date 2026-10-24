import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

import axisnet_support.AppManagement as Login
import support.CommonUtils
import axisnet_support.LocatorPaths as Locator
import pages.DashboardPage
import pages.MccmPage as Mccm
import pages.PurchaseJourney

Login.startApplication('083169504236', 'DT2022')

'Tap Playground'
CommonUtils.tap(Locator.PLAYGROUND_MENU)

'Tap Mistery Box'
CommonUtils.tap(Locator.PLAYGROUND_MISTERY_BOX)

'Tap Open Box'
CommonUtils.tap(Locator.OPEN_BOX)

'Tap Pop Up Klaim Sekarang'
CommonUtils.tap(Locator.CLAIM_BUTTON_MISTERY_BOX)

'Tap Button Home if Success Claim Bonus'
CommonUtils.tap(Locator.BUTTON_HOME_SUCCESS_CLAIM_PLAYGROUND)