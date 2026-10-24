import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import axisnet_support.AppManagement as Login
import support.CommonUtils as CommonUtils
import axisnet_support.LocatorPaths as Locator
import pages.DashboardPage as DashboardPage
import pages.PurchaseJourney as PurchaseJourney
import internal.GlobalVariable

//GlobalVariable.DEVICE_UDID = "RZ8N91D4LDE" 
Login.startApplication('083125750052', 'DT2022')

'Tap Profile'
CommonUtils.tap(Locator.BUTTON_PROFILE)

'Edit data'
CommonUtils.tap(Locator.IMG_EDIT_PROFILE)

'Tap Button Simpan'
CommonUtils.tap(Locator.BUTTON_SIMPAN)

'Check Toast'
CommonUtils.isElementExist(Locator.TOAST_SUCCESS_EDIT_PROFLE)
