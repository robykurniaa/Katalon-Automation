package setar_game_support

import support.CommonUtils
import setar_game_support.SetarGameLocatorPaths as Locator
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.util.KeywordUtil

class PaymentUtils {

	/**
	 * Handles phone number selection for payment dynamically based on Grand Total.
	 * If the primary number has insufficient balance, it opens the list and finds one with enough balance.
	 */
	@Keyword
	static void processPaymentSelection() {
		// 1. Take the Grand Total value from the bottom corner (next to the Continue button)
		int totalTransactionPrice = 0
		if (CommonUtils.isElementExist(Locator.TOTAL_TRANSAKSI, 5)) {
			totalTransactionPrice = CommonUtils.getNumericFromElement(Locator.TOTAL_TRANSAKSI, 5)
			KeywordUtil.logInfo("Total transaksi yang harus dibayar: Rp${totalTransactionPrice}")
		} else {
			KeywordUtil.markFailedAndStop("Gagal: Tidak dapat menemukan elemen total harga transaksi di halaman.")
		}

		// 2. Check if there is an insufficient balance notification on the main number.
		boolean isSaldoCukup = !CommonUtils.isElementExist(Locator.WARNING_INSUFF_BALANCE, 3)

		// 3. If the balance is sufficient and there is a checklist icon, continue immediately.
		if (isSaldoCukup && CommonUtils.isElementExist(Locator.CHECKLIST_ICON, 2)) {
			KeywordUtil.logInfo("Valid number already selected and balance is sufficient. Proceeding to next step.")
			CommonUtils.tap(Locator.BUTTON_LANJUTKAN)
		} else {
			KeywordUtil.logInfo("Insufficient main balance or no PIN. Open number list....")

			// 4. Open List Number
			CommonUtils.tap(Locator.GANTI_NOMOR)

			boolean isNumberSelected = false
			int maxCheckLimit = 10

			for (int i = 1; i <= maxCheckLimit; i++) {
				String balanceXPath = "(//div[contains(@class, 'pulsa')])[${i}]"
				String cardXPath = "(//div[contains(@class, 'wrapper-card')])[${i}]"

				// Hentikan loop jika sudah tidak ada kartu nomor yang ditampilkan
				if (!CommonUtils.isElementExist(balanceXPath, 2)) {
					KeywordUtil.logInfo("Check complete, no more number items found on the screen.")
					break
				}

				int currentBalance = CommonUtils.getNumericFromElement(balanceXPath, 5)
				KeywordUtil.logInfo("Number in index ${i} have a balance: Rp${currentBalance}")

				// 5. Compare the number credit with the Grand Total Transaction
				if (currentBalance >= totalTransactionPrice) {
					KeywordUtil.logInfo("Credit meets requirements (>= Rp${totalTransactionPrice}). Choose this number...")

					CommonUtils.tap(cardXPath)
					isNumberSelected = true
					break
				}
			}

			// 6. Final validation and click continue if successful selection
			if (!isNumberSelected) {
				KeywordUtil.markFailedAndStop("Failed: There is no phone number with sufficient credit to pay. Rp${totalTransactionPrice}")
			} else {
				KeywordUtil.logInfo("New number successfully selected. Proceed to payment process..")
				CommonUtils.tap(Locator.BUTTON_LANJUTKAN)
			}
		}
	}
	
	@Keyword
	static void verifyTransactionQuantity(int expectedQuantity) {
		KeywordUtil.logInfo("Verifying quantity in transaction details. Expected: ${expectedQuantity}")

		// Retrieve text from price details (e.g., "500 x Rp20.948")
		String priceDetailText = CommonUtils.getTextFromElement(Locator.DETAIL_PRICE, 10)

		if (priceDetailText != null && priceDetailText.contains("x")) {
			// Split the text by "x" and extract the preceding number
			String displayedQuantityStr = priceDetailText.split("x")[0].trim()
			int displayedQuantity = displayedQuantityStr.toInteger()
			
			KeywordUtil.logInfo("Actual quantity on the details page: ${displayedQuantity}")
			
			// Validate if the expected quantity matches the actual displayed quantity
			if (expectedQuantity == displayedQuantity) {
				CommonUtils.captureScreenshot()
				KeywordUtil.logInfo("Verification Successful: Quantity in Transaction Details matches.")
			} else {
				KeywordUtil.markFailedAndStop("Verification Failed: Expected = ${expectedQuantity}, Actual = ${displayedQuantity}.")
			}
		} else {
			KeywordUtil.markFailedAndStop("Failed to validate quantity. Transaction details text not found or format is incorrect.")
		}
	}
}