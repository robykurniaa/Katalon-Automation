package axisnet_support

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.util.KeywordUtil
import support.CommonUtils // Menggunakan CommonUtils bawaan kamu
import axisnet_support.NotificationHelper

public class SmsOTPHandler {

	@Keyword
	static void handleTransactionOTP(String otpFieldLocator, String submitButtonLocator, int manualWaitSeconds = 15, String otpType = "ALL") {
		KeywordUtil.logInfo("========== SMART OTP HANDLER ==========")

		CommonUtils.tap(otpFieldLocator)
		Mobile.delay(3) // Wait For Autofill OTP

		try {
			// passing string from JSON
			String currentText = CommonUtils.getTextFromElement(otpFieldLocator, 3)

			if (currentText != null) {
				String cleanText = currentText.replaceAll("[\\s\\-]", "")

				if (cleanText.matches("\\d{6}")) {
					KeywordUtil.logInfo("OS Auto-fill detected! OTP field is already filled with: ${cleanText}")
					Mobile.hideKeyboard()
					Mobile.delay(1)
					CommonUtils.tap(submitButtonLocator)
					KeywordUtil.logInfo("========== SMART OTP HANDLER DONE (VIA AUTO-FILL) ==========")
					return 
				}
			}
		} catch (Exception e) {
			// throw ActionFailedException
			KeywordUtil.logInfo("Field OTP not found, reading the notification")
		}

		KeywordUtil.logInfo("using ADB for read sms notif...")

		// =========================================================================
		// IF NULL / FAILED GET TEXT, NEXT READ VIA ADB
		// =========================================================================
		String otpCode = NotificationHelper.waitForOTPNotification(8, otpType)

		if (otpCode) {
			KeywordUtil.logInfo("${otpType} OTP auto-detected via ADB: ${otpCode}")
			CommonUtils.setText(otpFieldLocator, otpCode)
			Mobile.hideKeyboard()
			Mobile.delay(1)
			CommonUtils.tap(submitButtonLocator)
			KeywordUtil.logInfo("OTP auto-filled and submitted")
		} else {
			KeywordUtil.logInfo("No ${otpType} OTP notification detected. Waiting for manual OTP input (${manualWaitSeconds}s)...")
			Mobile.delay(manualWaitSeconds)
			CommonUtils.tap(submitButtonLocator)
			KeywordUtil.logInfo("Manual OTP input completed")
		}

		KeywordUtil.logInfo("========== OTP HANDLER DONE ==========")
	}
}