import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import axisnet_support.AppManagement as Login
import support.CommonUtils as CommonUtils
import axisnet_support.LocatorPaths as Locator
import pages.DashboardPage as DashboardPage
import pages.PurchaseJourney as PurchaseJourney

Login.startApplication('083125750052', 'DT2022')

'Tap Menu Hiburan'
CommonUtils.tap(Locator.LIFESTYLE_MENU)

'Tap RekreAXIS Menu'
CommonUtils.tap(Locator.REKREAXIS_MENU)

'Tap Ke Rekreaxis'
CommonUtils.tap(Locator.BUTTON_KE_REKREAXIS)

'Check Rekreaxis page'
CommonUtils.isElementExist(Locator.REKREAXIS_PAGE)