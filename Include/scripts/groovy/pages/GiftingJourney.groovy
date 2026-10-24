package pages

import support.CommonUtils
import support.exceptions.TestActionException
import axisnet_support.LocatorPaths as Locator
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import internal.GlobalVariable

public class GiftingJourney {

    /**
     * Reusable method untuk core logika gifting
     */
    private static void processGifting(String msisdnRecipient, boolean proceedToOtp = true) {
        try {
            CommonUtils.tap(Locator.BUTTON_AKTIFKAN)
            CommonUtils.handleOptionalElement(
                Locator.IS_GIFTING,
                { -> CommonUtils.tap(Locator.GIFTING_BUTTON) }, 5
            )
            CommonUtils.setText(Locator.GIFTING_TEXT_FIELD, msisdnRecipient)
            CommonUtils.tap(Locator.BUTTON_AKTIVASI)

            if (proceedToOtp) {
                CommonUtils.tap(Locator.BUTTON_KONFIRMASI)
                Mobile.delay(5)
                CommonUtils.tap(Locator.TRANSACTION_OTP_FIELD)
                CommonUtils.tap(Locator.BUTTON_NEXT_OTP_TRX)
                Mobile.delay(7)
            }
        } catch (TestActionException e) {
            CommonUtils.captureScreenshot("error_during_gifting")
            throw new TestActionException("Failed during gifting flow to ${msisdnRecipient}", e)
        }
    }

    public static void sendGift() {
        processGifting(GlobalVariable.giftingDefaultNumber, true)
    }

    public static void sendGiftToGraceMsisdn() {
        processGifting(GlobalVariable.giftingGraceNumber, true)
    }

    public static void sendGiftToInvalidMsisdn() {
        // Jika nomor invalid, biasanya button konfirmasi mati atau tidak bisa lanjut ke OTP
        processGifting(GlobalVariable.giftingInvalidNumber, false)
    }
}