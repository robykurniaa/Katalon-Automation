import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

import axisnet_support.AppManagement as Login
import support.CommonUtils
import axisnet_support.LocatorPaths as Locator
import pages.DashboardPage
import pages.PurchaseJourney
import pages.AxisIOUPage as IOU

Login.startApplication('083139842347', 'DT2022')

'Tap Quick Menu Isi Pulsa'
DashboardPage.handleAxisQuickMenu(Locator.ISI_PULSA_MENU)

'Choose Denom'
CommonUtils.tap(Locator.TOP_UP_25K)

'Tap Lanjut'
CommonUtils.tap(Locator.BUTTON_LANJUT)

'Purchase Journey'
PurchaseJourney.topUpBalanceWithGopay()