import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import axisnet_support.AppManagement as Login
import support.CommonUtils as CommonUtils
import axisnet_support.LocatorPaths as Locator
import pages.DashboardPage as DashboardPage
import pages.PurchaseJourney as PurchaseJourney
import internal.GlobalVariable

Mobile.startExistingApplication('com.axis.net')

	'Tap Detail Kuota'
	CommonUtils.tap(Locator.BUTTON_PROFILE)
	CommonUtils.scrollToText("Keluar")
	CommonUtils.tap(Locator.BUTTON_KELUAR)
	Mobile.closeApplication()
