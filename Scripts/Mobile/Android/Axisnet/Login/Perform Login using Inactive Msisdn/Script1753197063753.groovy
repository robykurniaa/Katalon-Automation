import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import axisnet_support.AppManagement as Login
import support.CommonUtils as CommonUtils
import axisnet_support.LocatorPaths as Locator
import pages.DashboardPage as DashboardPage
import pages.PurchaseJourney as PurchaseJourney
import axisnet_support.AppManagement

AppManagement.openApplication()

'Tap Start'
CommonUtils.handleOptionalElement(Locator.AXIS_LETS_START_BUTTON, { CommonUtils.hit(Locator.AXIS_LETS_START_BUTTON) }, 15)

'Check Pop Up Permission'
CommonUtils.handleOptionalElement(Locator.AXIS_AGREE_PERMISSION_BUTTON, {CommonUtils.hit(Locator.AXIS_AGREE_PERMISSION_BUTTON) }, 5)

'Fill Msisdn'
CommonUtils.setText(Locator.MSISDN_FIELD, '083171002989')

'Tap Login'
CommonUtils.tap(Locator.AXIS_LOGIN_BUTTON)

'Check Reactivation Page'
CommonUtils.waitForElement(Locator.TEXT_VIEW_INACTIVE_MSISDN)
CommonUtils.captureScreenshot()
