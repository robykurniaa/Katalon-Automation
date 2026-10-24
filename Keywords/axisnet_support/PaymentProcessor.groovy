package axisnet_support

import support.CommonUtils
import axisnet_support.LocatorPaths as Locator
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.util.KeywordUtil
import internal.GlobalVariable

public class PaymentProcessor {

	public static void selectPaymentMethod(String paymentMethodLocator, String paymentMethodName) {
		// Open the payment method selection menu
		CommonUtils.tap(Locator.BUTTON_PAYMENT_METHOD)

		// Scroll until the target payment method text is within the viewport
		CommonUtils.scrollToText(paymentMethodName)

		// Verify element visibility within a short 3-second timeout.
		// Perform an upward swipe if the element is still obscured (e.g., by a bottom navigation bar).
		if (!CommonUtils.isElementExist(paymentMethodLocator, 3)) {
			KeywordUtil.logInfo("Element '${paymentMethodName}' is not fully visible, performing swipe up...")
			CommonUtils.swipe(paymentMethodLocator, 'up')
		}

		// Select the payment method
		CommonUtils.tap(paymentMethodLocator)

		// Execute additional required steps specifically for OVO payments
		if (paymentMethodName.toLowerCase().contains("ovo")) {
			KeywordUtil.logInfo("Handling OVO specific flow")
			handleOvoFlow()
		}
	}

	private static void handleOvoFlow() {
		CommonUtils.handleOptionalElement(
				Locator.OVO_TEXT_FIELD, {
					->
					CommonUtils.setText(Locator.OVO_TEXT_FIELD, GlobalVariable.ovoDefaultNumber)
					CommonUtils.tap(Locator.BUTTON_LANJUT)
				}, 10
				)
	}

	// ================= E2E PAYMENT FLOWS =================

	public static void executeShopeePayFlow() {
		CommonUtils.tap(Locator.BUTTON_SHOPEEPAY_PAY_NOW)
		KeywordUtil.logInfo("Attempting first ShopeePay PIN")

		enterShopeePayPIN(GlobalVariable.firstPinShopeepay)
		Mobile.delay(5)

		if (CommonUtils.isElementExist(Locator.SHOPEEPAY_FAILED_PIN)) {
			KeywordUtil.logInfo("First ShopeePay PIN failed. Trying alternative PIN")
			enterShopeePayPIN(GlobalVariable.secondPinShopeepay)

			if (CommonUtils.isElementExist(Locator.SHOPEEPAY_FAILED_PIN)) {
				KeywordUtil.logInfo("Both ShopeePay PIN attempts failed. Please verify your PIN setup.")
			} else {
				KeywordUtil.logInfo("Alternative ShopeePay PIN entered successfully.")
			}
		} else {
			KeywordUtil.logInfo("First ShopeePay PIN entered successfully.")
		}

		CommonUtils.tap(Locator.BUTTON_KE_HOME)
		KeywordUtil.logInfo("ShopeePay flow completed.")
	}

	private static void enterShopeePayPIN(def pinInput) {
		List<Integer> pinDigits = (pinInput instanceof List) ? pinInput : pinInput.toString().collect { it as Integer }
		KeywordUtil.logInfo("Starting to enter ShopeePay PIN...")

		pinDigits.each { digit ->
			def key = Locator."SHOPEEPAY_KEYBOARD_${digit}"
			CommonUtils.tap(key)
		}
	}

	// --- SKELETON UNTUK E2E LAINNYA ---

	public static void executeDanaFlow() {
		KeywordUtil.logInfo("Executing E2E Dana Flow...")
		// TODO: Tambahkan tap tombol bayar DANA, input PIN DANA, dll
		// Contoh: CommonUtils.tap(Locator.BUTTON_DANA_PAY_NOW)
	}

	public static void executeGopayFlow() {
		KeywordUtil.logInfo("Executing E2E GoPay Flow...")
		// TODO: Tambahkan flow redirect GoPay dan input PIN GoPay
	}

	public static void executeOvoE2EFlow() {
		KeywordUtil.logInfo("Executing E2E OVO Flow...")
		// TODO: Tambahkan flow approval OVO (biasanya push notif / redirect app)
	}
}