import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

import axisnet_support.AppManagement as Login
import support.CommonUtils
import axisnet_support.LocatorPaths as Locator
import pages.DashboardPage
import pages.PurchaseJourney

Login.startApplication('083827388378', 'DT2022')

'Tap Quick Menu Donasi Kuota'
DashboardPage.handleAxisQuickMenu(Locator.TENGGO_MENU)

'Choose Tenggo Validity'
CommonUtils.tap(Locator.TENGGO_TAB_3_JAM)

'Choose Tenggo Package'
PurchaseJourney.packageSelected(Locator.TENGGO_UTAMA_3_JAM, Locator.PKG_SWIPE_KEY)

'Tap Button OK, Ngerti'
CommonUtils.tap(Locator.TENGGO_BUTTON_OK)

'Purchase Journey'
PurchaseJourney.purchaseWithQris()




