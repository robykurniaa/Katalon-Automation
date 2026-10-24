import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import axisnet_support.AppManagement as Login
import support.CommonUtils as CommonUtils
import axisnet_support.LocatorPaths as Locator
import pages.DashboardPage as DashboardPage
import pages.PurchaseJourney as PurchaseJourney
import internal.GlobalVariable

Login.startApplication('083110568390', 'DT2022', false)	

'Tap Detail Kuota'
CommonUtils.tap(Locator.CHEVRON_KUOTA)

'Check Detail Kuota Page'
CommonUtils.waitForElement(Locator.TEXT_VIEW_DETAIL_PAKET)
CommonUtils.captureScreenshot('success check detail kuota')