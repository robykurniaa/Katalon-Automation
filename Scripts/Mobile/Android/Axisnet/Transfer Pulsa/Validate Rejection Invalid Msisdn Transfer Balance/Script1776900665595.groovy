import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import axisnet_support.AppManagement as Login
import support.CommonUtils as CommonUtils
import axisnet_support.LocatorPaths as Locator
import pages.DashboardPage as DashboardPage
import pages.PurchaseJourney as PurchaseJourney

Login.startApplication('083125750052', 'DT2022')

'Tap Quick Menu Transfer Pulsa'
DashboardPage.handleAxisQuickMenu(Locator.LIHAT_SEMUA_MENU)
CommonUtils.scrollToText('Transfer Pulsa')

CommonUtils.tap(Locator.TRANSFER_PULSA_MENU)

'Axis Number destination'
CommonUtils.setText(Locator.TF_PULSA_DEST_MSISDN, '085713519994')

'Pulsa Amount'
CommonUtils.tap(Locator.TF_PULSA_AMOUNT_5000)

'Button Lanjut'
CommonUtils.tap(Locator.BUTTON_LANJUT)

'Check Rejection'
CommonUtils.isElementExist(Locator.TF_PULSA_INVALID_MSISDN)