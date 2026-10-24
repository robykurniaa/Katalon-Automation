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

CommonUtils.tap(Locator.TRANSFER_KUOTA_MENU)

'Axis Number destination'
CommonUtils.setText(Locator.TF_KUOTA_DEST_MSISDN, '085813519994')

'Check Box Kuota'
CommonUtils.tap(Locator.TF_KUOTA_CHECKBOX)

'Pulsa Amount'
CommonUtils.tap(Locator.TF_KUOTA_AMOUNT_300MB)

'Button Lanjut'
CommonUtils.tap(Locator.BUTTON_LANJUT)

'Check Rejection'
CommonUtils.isElementExist(Locator.TF_KUOTA_INVALID_MSISDN)