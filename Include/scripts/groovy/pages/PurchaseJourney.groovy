package pages

import support.CommonUtils
import support.exceptions.TestActionException
import axisnet_support.LocatorPaths as Locator
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.util.KeywordUtil
import axisnet_support.NotificationHelper
import axisnet_support.PaymentProcessor

public class PurchaseJourney {

	private static final int DELAY_AFTER_PAYMENT = 5
	private static final String TEXT_AKTIVASI = "Sekarang"

	// --- Normal Purchase ---
	public static void purchaseWithBalance()       {
		executePurchase(null, "Balance", false)
	}
	public static void createOrderWithDana()       {
		executePurchase(Locator.PAYMENT_METHOD_DANA, "Dana", false)
	}
	public static void createOrderWithShopeePay()  {
		executePurchase(Locator.PAYMENT_METHOD_SHOPEEPAY, "ShopeePay", false)
	}
	public static void createOrderWithOVO()       {
		executePurchase(Locator.PAYMENT_METHOD_OVO, "OVO", false)
	}
	public static void createOrderWithGopay()         {
		executePurchase(Locator.PAYMENT_METHOD_GOPAY, "Gopay", false)
	}
	public static void createOrderWithQris()          {
		executePurchase(Locator.PAYMENT_METHOD_QR, "QRIS", false)
	}

	// --- BYOP Purchase ---
	public static void purchaseByopWithBalance()   {
		executePurchase(null, "Balance", true)
	}
	public static void purchaseByopWithDana()      {
		executePurchase(Locator.PAYMENT_METHOD_DANA, "Dana", true)
	}
	public static void purchaseByopWithShopeePay() {
		executePurchase(Locator.PAYMENT_METHOD_SHOPEEPAY, "ShopeePay", true)
	}
	public static void purchaseByopWithOVO()       {
		executePurchase(Locator.PAYMENT_METHOD_OVO, "OVO", true)
	}
	public static void purchaseByopWithGopay()     {
		executePurchase(Locator.PAYMENT_METHOD_GOPAY, "Gopay", true)
	}
	public static void purchaseByopWithQris()      {
		executePurchase(Locator.PAYMENT_METHOD_QR, "QRIS", true)
	}

	// --- E2E Success Purchase Multipayment---
	public static void successPurchaseWithShopeePay() {
		executeE2EPurchase(Locator.PAYMENT_METHOD_SHOPEEPAY, "ShopeePay")
	}
	public static void successPurchaseWithDana()      {
		executeE2EPurchase(Locator.PAYMENT_METHOD_DANA, "Dana")
	}
	public static void successPurchaseWithGopay()     {
		executeE2EPurchase(Locator.PAYMENT_METHOD_GOPAY, "Gopay")
	}
	public static void successPurchaseWithOVO()       {
		executeE2EPurchase(Locator.PAYMENT_METHOD_OVO, "OVO")
	}

	// --- Game Token ---
	public static void purchaseGameTokenwithBalance()      {
		executePurchaseGameToken(null, "Balance")
	}
	public static void purchaseGameTokenWithDana()      {
		executePurchaseGameToken(Locator.PAYMENT_METHOD_DANA, "Dana")
	}
	public static void purchaseGameTokenWithShopeePay() {
		executePurchaseGameToken(Locator.PAYMENT_METHOD_SHOPEEPAY, "ShopeePay")
	}
	public static void purchaseGameTokenWithOVO()       {
		executePurchaseGameToken(Locator.PAYMENT_METHOD_OVO, "OVO")
	}
	public static void purchaseGameTokenWithGopay()     {
		executePurchaseGameToken(Locator.PAYMENT_METHOD_GOPAY, "Gopay")
	}

	// --- Top Up Balance ---
	public static void topUpBalanceWithDana()      {
		executeTopUpBalance(Locator.PAYMENT_METHOD_DANA, "Dana")
	}
	public static void topUpBalanceWithShopeePay() {
		executeTopUpBalance(Locator.PAYMENT_METHOD_SHOPEEPAY, "ShopeePay")
	}
	public static void topUpBalanceWithOVO()       {
		executeTopUpBalance(Locator.PAYMENT_METHOD_OVO, "OVO")
	}
	public static void topUpBalanceWithGopay()     {
		executeTopUpBalance(Locator.PAYMENT_METHOD_GOPAY, "Gopay")
	}


	// ============================================================================
	// 2. CORE LOGIC
	// ============================================================================

	private static void executePurchase(String paymentLocator, String paymentName, boolean isByop) {
		try {
			boolean isMultiPayment = (paymentLocator != null && !paymentLocator.trim().isEmpty())

			if (isByop) {
				CommonUtils.scrollToText(TEXT_AKTIVASI)
				if (isMultiPayment) PaymentProcessor.selectPaymentMethod(paymentLocator, paymentName)
				executeActivationSequence()
			} else {
				CommonUtils.tap(Locator.BUTTON_AKTIFKAN)
				isGifting()
				if (isMultiPayment) PaymentProcessor.selectPaymentMethod(paymentLocator, paymentName)
				CommonUtils.tap(Locator.BUTTON_KONFIRMASI)
			}

			if (isMultiPayment) {
				CommonUtils.handleOptionalElement(Locator.INSUFF_BALANCE_MULTIPAYMENT, { -> CommonUtils.tap(Locator.BUTTON_LANJUT) }, 5)
				if (CommonUtils.isElementNotPresent(Locator.ERROR_PAYMENT_NOTIFICATION, 8)) {
					KeywordUtil.logInfo("Redirect success for " + paymentName)
				} else {
					KeywordUtil.logInfo("Payment Error detected")
				}
			}

			verifyCreatePayment()

			if (!isByop && !isMultiPayment) {
				verifyReceipt()
			} else if (isByop && !isMultiPayment) {
				CommonUtils.handleOptionalElement(Locator.RECEIPT_SUCCESS, { -> CommonUtils.tap(Locator.BUTTON_KE_HOME) }, 10)
			}
		} catch (TestActionException e) {
			CommonUtils.captureScreenshot("error_during_" + paymentName + "_purchase")
			throw new TestActionException("Failed purchase using " + paymentName, e)
		}
	}

	private static void executeE2EPurchase(String paymentLocator, String paymentName) {
		executePurchase(paymentLocator, paymentName, false)

		switch(paymentName.toLowerCase()) {
			case "shopeepay": PaymentProcessor.executeShopeePayFlow(); break;
			case "dana":      PaymentProcessor.executeDanaFlow(); break;
			case "gopay":     PaymentProcessor.executeGopayFlow(); break;
			case "ovo":       PaymentProcessor.executeOvoE2EFlow(); break;
		}
	}

	private static void executePurchaseGameToken(String paymentLocator, String paymentName) {
		try {
			boolean isMultiPayment = (paymentLocator != null)

			if (isMultiPayment) {
				// ==========================================
				// 1. FLOW MULTI-PAYMENT (DANA, SHOPEEPAY, DLL)
				// ==========================================
				PaymentProcessor.selectPaymentMethod(paymentLocator, paymentName)

				CommonUtils.tap(Locator.BUTTON_AKTIFKAN)

				CommonUtils.handleOptionalElement(
						Locator.INSUFF_BALANCE_MULTIPAYMENT,
						{ -> CommonUtils.tap(Locator.BUTTON_LANJUT) }, 5
						)

				verifyCreatePayment() // Tunggu redirect ke aplikasi e-wallet
			} else {
				// ==========================================
				// 2. FLOW BALANCE (PULSA) - DENGAN OTP
				// ==========================================
				CommonUtils.tap(Locator.BUTTON_AKTIFKAN)

				Mobile.delay(3)
				NotificationHelper.clearNotification()
				CommonUtils.tap(Locator.TRANSACTION_OTP_FIELD) // <--- Ini sudah sesuai di sini

				String otpCode = NotificationHelper.waitForOTPNotification(5)
				if (!otpCode) {
					KeywordUtil.logInfo("No SMS OTP Notification after 5 Second")
					Mobile.delay(15) 
				} else {
					CommonUtils.setText(Locator.TRANSACTION_OTP_FIELD, otpCode)
					Mobile.hideKeyboard()
					Mobile.delay(1)
				}

				CommonUtils.tap(Locator.BUTTON_NEXT_OTP_TRX)

				CommonUtils.handleOptionalElement(
						Locator.RECEIPT_SUCCESS,
						{ -> CommonUtils.tap(Locator.BUTTON_KE_HOME) }, 10
						)
			}
		} catch (Exception e) {
			CommonUtils.captureScreenshot("error_game_token_" + paymentName)
			throw new TestActionException("Failed purchase Game Token with " + paymentName, e)
		}
	}

	private static void executeTopUpBalance(String paymentLocator, String paymentName) {
		CommonUtils.tap(Locator.ISI_PULSA_PAYMENT_METHOD)
		CommonUtils.scrollToText(paymentName)
		CommonUtils.tap(paymentLocator)

		if (paymentName.toLowerCase().contains("ovo")) {
			PaymentProcessor.selectPaymentMethod(paymentLocator, paymentName)
		}

		CommonUtils.tap(Locator.BUTTON_KONFIRMASI)
		CommonUtils.handleOptionalElement(Locator.INSUFF_BALANCE_MULTIPAYMENT, { -> CommonUtils.tap(Locator.BUTTON_LANJUT) }, 5)
		//CommonUtils.tap(Locator.BUTTON_SPAY_INTERNAL_APP_PAY_NOW)
		verifyCreatePayment()
	}

	// ============================================================================
	// 3. UTILITIES & HELPERS
	// ============================================================================

	private static void executeActivationSequence() {
		CommonUtils.tap(Locator.AKTIVASI_SEKARANG)
		CommonUtils.handleOptionalElement(Locator.TEXT_VIEW_CHANGE_CUSTOM_NAME, { -> CommonUtils.tap(Locator.IGNORE_CHANGE_CUSTOM_NAME) }, 5)
		CommonUtils.tap(Locator.AKTIVASI_SEKARANG)
	}

	private static void verifyCreatePayment() {
		Mobile.delay(DELAY_AFTER_PAYMENT)
		CommonUtils.captureScreenshot()
	}

	public static void verifyReceipt() {
		try {
			CommonUtils.handleOptionalElement(Locator.SYNCHRONOUS_PAGE, { -> }, 5)
			CommonUtils.handleOptionalElement(Locator.PUSH_NOTIF_CALLBACK_TRANSACTION, { -> }, 5)

			String executionName = RunConfiguration.getExecutionSourceId()
			if (executionName != null && executionName.toLowerCase().contains("tenggo")) {
				CommonUtils.handleOptionalElement(Locator.RECEIPT_TENGGO_POP_UP, { -> CommonUtils.tap(Locator.BUTTON_OK_RECEIPT_TENGGO_POPUP) }, 10)
			}
			CommonUtils.handleOptionalElement(Locator.RECEIPT_SUCCESS, { -> CommonUtils.tap(Locator.BUTTON_KE_HOME) }, 10)
		} catch (TestActionException e) {
			throw new TestActionException("Receipt verification failed", e)
		}
	}

	private static void isGifting() {
		CommonUtils.handleOptionalElement(Locator.IS_GIFTING, { -> CommonUtils.tap(Locator.BUTTON_AKTIVASI) }, 5)
	}
}