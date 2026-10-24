import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

import axisnet_support.AppManagement as Login
import support.CommonUtils
import axisnet_support.LocatorPaths as Locator
import pages.DashboardPage
import pages.MccmPage as Mccm
import pages.PurchaseJourney
import pages.BonusPage
import pages.TPRPage as TPR

Login.startApplication('6283825494586')

'Tap Menu Hiburan'
DashboardPage.handleAxisQuickMenu(Locator.LIFESTYLE_MENU)

'Switch Toggle'
CommonUtils.tap(Locator.TOGGLE_SWITCH)
CommonUtils.captureScreenshot('success activate unl gaming')







