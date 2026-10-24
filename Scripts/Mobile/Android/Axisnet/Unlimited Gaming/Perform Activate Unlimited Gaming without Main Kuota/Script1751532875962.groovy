import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

import axisnet_support.AppManagement as Login
import support.CommonUtils
import axisnet_support.LocatorPaths as Locator
import pages.DashboardPage
import pages.MccmPage as Mccm
import pages.PurchaseJourney
import pages.BonusPage
import pages.TPRPage as TPR

Login.startApplication('083827389321', 'DT2022')

'Tap Menu Hiburan'
DashboardPage.handleAxisQuickMenu(Locator.LIFESTYLE_MENU)

'Switch Toggle'
CommonUtils.tap(Locator.TOGGLE_SWITCH)

'Check Pop Up'
CommonUtils.isElementExist(Locator.FAILED_ACTIVATE_UNL_GAMING)







