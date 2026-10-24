import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import axisnet_support.AppManagement as Login
import support.CommonUtils
import axisnet_support.LocatorPaths as Locator
import pages.DashboardPage
import pages.PurchaseJourney
import axisnet_support.SmsOTPHandler as Otp
import internal.GlobalVariable

Login.startApplication(GlobalVariable.Regression_Msisdn)

'Tap Quick Menu Transfer Pulsa'
DashboardPage.handleAxisQuickMenu(Locator.LIHAT_SEMUA_MENU)
CommonUtils.scrollToText("Transfer Quota")
CommonUtils.tap(Locator.TRANSFER_KUOTA_MENU)

'Axis Number destination'
CommonUtils.setText(Locator.TF_KUOTA_DEST_MSISDN, "083827388378")

'Check Box Kuota'
CommonUtils.tap(Locator.TF_KUOTA_CHECKBOX)

'Pulsa Amount'
CommonUtils.tap(Locator.TF_KUOTA_AMOUNT_300MB)

'Button Lanjut'
CommonUtils.tap(Locator.BUTTON_LANJUT)

'Button Konfirmasi'
CommonUtils.tap(Locator.BUTTON_KONFIRMASI)

'Input OTP'
Otp.handleTransactionOTP(
    Locator.TRANSACTION_OTP_FIELD,   
    Locator.BUTTON_LANJUT,           
    15                               
)

'Check receipt'
CommonUtils.handleOptionalElement(Locator.RECEIPT_SUCCESS, { 
    -> CommonUtils.tap(Locator.BUTTON_KE_HOME)
}, 10)