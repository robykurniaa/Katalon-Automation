import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import axisnet_support.AppManagement as Login
import support.CommonUtils as CommonUtils
import axisnet_support.LocatorPaths as Locator
import pages.DashboardPage as DashboardPage
import pages.PurchaseJourney as PurchaseJourney
import internal.GlobalVariable

Login.startApplication('083125750052', 'DT2022')

'Tap Detail Kuota'
CommonUtils.tap(Locator.BUTTON_LIHAT_SEMUA)

'Check Detail Kuota Page'
CommonUtils.tap(Locator.BUTTON_BONUS_PASTI)

'Check Bonus Pasti'
CommonUtils.isElementExist(Locator.DETAIL_BONUS_PASTI)