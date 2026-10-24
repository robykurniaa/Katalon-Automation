import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

import axisnet_support.AppManagement as Login
import support.CommonUtils
import axisnet_support.LocatorPaths as Locator
import pages.DashboardPage
import pages.PurchaseJourney

Login.startApplication('083169504236', 'DT2022')

'Tap Menu Paket Paket'
DashboardPage.handleAxisQuickMenu(Locator.PAKET_MENU)

'Tap Paket'
CommonUtils.tap(Locator.PAKET_MENU)

'Tap Internet'
CommonUtils.tap(Locator.CATEGORY_TENGGO)

'Choose Tenggo Package'
PurchaseJourney.packageSelected(Locator.TENGGO_TIKTOK_3_JAM, Locator.PKG_SWIPE_KEY)

'Tap Button OK, Ngerti'
CommonUtils.tap(Locator.TENGGO_BUTTON_OK)

'Purchase Journey'
PurchaseJourney.purchaseWithBalance()




