import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import axisnet_support.AppManagement as Login
import support.CommonUtils as CommonUtils
import axisnet_support.LocatorPaths as Locator
import pages.DashboardPage as DashboardPage
import pages.PurchaseJourney as PurchaseJourney
import axisnet_support.SmsOTPHandler as Otp
import axisnet_support.NotificationHelper
String Bnumber = '083827388378'

Login.startApplication('083125750052', 'DT2022')

'Tap Quick Menu Transfer Pulsa'
DashboardPage.handleAxisQuickMenu(Locator.LIHAT_SEMUA_MENU)

CommonUtils.scrollToText('Transfer Pulsa')

CommonUtils.tap(Locator.TRANSFER_PULSA_MENU)

'Axis Number destination'
CommonUtils.setText(Locator.TF_PULSA_DEST_MSISDN, Bnumber)

'Pulsa Amount'
CommonUtils.tap(Locator.TF_PULSA_AMOUNT_5000)

'Button Lanjut'
CommonUtils.tap(Locator.BUTTON_LANJUT)

'Button Konfirmasi'
NotificationHelper.clearNotification()
CommonUtils.tap(Locator.BUTTON_KONFIRMASI)

'Input OTP'
Otp.handleTransactionOTP(Locator.TRANSACTION_OTP_FIELD // OTP field
    , Locator.BUTTON_LANJUT // Submit button
    , 15 // Manual wait (optional, default 15)
    )

'Check receipt'
CommonUtils.handleOptionalElement(Locator.RECEIPT_SUCCESS, { 
        CommonUtils.tap(Locator.BUTTON_KE_HOME)
    }, 10)

Login.startApplication(Bnumber, 'DT2022')

