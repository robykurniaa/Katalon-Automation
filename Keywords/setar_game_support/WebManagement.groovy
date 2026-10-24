package setar_game_support

import support.CommonUtils
import setar_game_support.SetarGameLocatorPaths as Locator
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.webui.driver.DriverFactory
import internal.GlobalVariable

public class WebManagement {

	// Use GlobalVariable as the default fallback for dynamic URL handling
	static void loginToDashboard(String phoneNumber, String password = "VBNMvbnm@123", String url = GlobalVariable.SetarGameDev) {

		openOrNavigateBrowser(url)

		// Condition 1: Check if the user is already on the Dashboard
		if (CommonUtils.isElementExist(Locator.ICON_USER_DASHBOARD, 5)) {
			KeywordUtil.logInfo("User icon detected. Session is active, skipping login process.")
			return
		}

		KeywordUtil.logInfo("Not on Dashboard. Checking current page state...")

		// Condition 2: Check if directly redirected to the Login Form Page (bypassing the Landing Page)
		boolean isAtLoginForm = CommonUtils.isElementExist(Locator.FORM_LOGIN_TITLE, 3) || CommonUtils.isElementExist(Locator.SET_NUMBER, 1)

		if (!isAtLoginForm) {
			// Condition 3: Check if currently on the Landing Page ("Belanja Game Lebih Mudah")
			if (CommonUtils.isElementExist(Locator.LOGIN_DESCRIPTION, 5)) {
				KeywordUtil.logInfo("Landing page detected. Clicking LOGIN button to open form...")
				CommonUtils.tap(Locator.LOGIN_BUTTON)
			} else {
				KeywordUtil.markFailedAndStop("Login page not recognized. Neither Landing Page nor Login Form found.")
			}
		} else {
			KeywordUtil.logInfo("Directly landed on Login Form. Proceeding to input credentials...")
		}

		// Proceed with data input after confirming presence on the login form
		CommonUtils.setText(Locator.SET_NUMBER, phoneNumber)
		CommonUtils.setText(Locator.SET_PASSWORD, password)
		CommonUtils.check(Locator.CHECKBOX)

		handleManualRecaptcha(60)
		handleManualOtp(60)

		// Final Verification
		KeywordUtil.logInfo("Verifying Dashboard after login...")
		if (CommonUtils.isElementExist(Locator.ICON_USER_DASHBOARD, 10)) {
			KeywordUtil.logInfo("Login successful! Dashboard loaded.")
		} else {
			KeywordUtil.markFailedAndStop("Failed to load Dashboard after completing login and OTP.")
		}
	}

	/**
	 * Ensures the browser is at the Pre-Login/Guest state (e.g., for Registration).
	 * If an active session is detected, it will perform a logout first.
	 */
	static void startAtLoginPage(String url = GlobalVariable.SetarGameProd) {
		openOrNavigateBrowser(url)

		if (CommonUtils.isElementExist(Locator.ICON_USER_DASHBOARD, 5)) {
			KeywordUtil.logInfo("Active session detected on Dashboard. Performing logout...")
			logout()
		}

		KeywordUtil.logInfo("Verifying Pre-Login/Register state...")
		if (CommonUtils.isElementExist(Locator.LOGIN_DESCRIPTION, 5)) {
			KeywordUtil.logInfo("Successfully standing by at Login/Pre-Login page.")
		} else {
			KeywordUtil.markFailedAndStop("Failed to prepare Login Page (LOGIN_DESCRIPTION not found).")
		}
	}

	/**
	 * Dedicated method for the Logout process via UI with a fallback to clear session.
	 */
	static void logout() {
		KeywordUtil.logInfo("Executing Logout flow via UI...")
		try {
			CommonUtils.tap(Locator.ICON_USER_DASHBOARD)
			CommonUtils.tap(Locator.BUTTON_KELUAR)

			if (CommonUtils.isElementExist(Locator.LOGIN_DESCRIPTION, 10)) {
				KeywordUtil.logInfo("Logout successful. Returned to Pre-Login state.")
			} else {
				// Fallback if UI interaction fails to reset the session
				KeywordUtil.logInfo("Logout UI failed or taking too long. Forcing session clear...")
				forceClearSession()
			}
		} catch (Exception e) {
			KeywordUtil.logInfo("Error during UI logout: ${e.message}. Forcing session clear...")
			forceClearSession()
		}
	}

	/**
	 * Checks if the browser is already open.
	 * If yes, it navigates to the URL. If not, it opens a new browser instance.
	 */
	private static void openOrNavigateBrowser(String url) {
		try {
			if (DriverFactory.getWebDriver() != null) {
				KeywordUtil.logInfo("Browser already open. Navigating to: ${url}")
				WebUI.navigateToUrl(url)
			} else {
				throw new Exception("Driver is null")
			}
		} catch (Exception e) {
			KeywordUtil.logInfo("Opening new browser instance to: ${url}")
			WebUI.openBrowser(url)
			WebUI.maximizeWindow()
		}
	}

	/**
	 * Clears all browser cookies and refreshes the page to reset the session.
	 * Very useful as a fallback if UI logout fails or gets obstructed.
	 */
	static void forceClearSession() {
		KeywordUtil.logInfo("Clearing all browser cookies to force logout...")
		WebUI.deleteAllCookies()
		WebUI.refresh()

		if (CommonUtils.isElementExist(Locator.LOGIN_DESCRIPTION, 10)) {
			KeywordUtil.logInfo("Force clear session successful. Returned to Pre-Login state.")
		} else {
			KeywordUtil.markFailedAndStop("Failed to clear session. LOGIN_DESCRIPTION still not found.")
		}
	}

	static void handleManualRecaptcha(int timeoutInSeconds = 60) {
		KeywordUtil.logInfo("Waiting for manual reCAPTCHA resolution (max ${timeoutInSeconds}s)...")

		boolean isCaptchaResolved = waitForButtonEnabled(Locator.BUTTON_LANJUT, timeoutInSeconds)

		if (isCaptchaResolved) {
			KeywordUtil.logInfo("reCAPTCHA resolved! Continue button is enabled.")
			CommonUtils.tap(Locator.BUTTON_LANJUT)
		} else {
			KeywordUtil.markFailedAndStop("Failed: reCAPTCHA wait time expired (${timeoutInSeconds} seconds).")
		}
	}

	static void handleManualOtp(int timeoutInSeconds = 60) {
		KeywordUtil.logInfo("Waiting for OTP page to load...")
		CommonUtils.tap(Locator.INPUT_OTP, 10)

		KeywordUtil.logInfo("Please enter OTP manually. Waiting for Continue button (max ${timeoutInSeconds}s)...")

		boolean isOtpFilled = waitForButtonEnabled(Locator.BUTTON_LANJUT, timeoutInSeconds)

		if (isOtpFilled) {
			KeywordUtil.logInfo("OTP entered! Confirmation button is enabled.")
			CommonUtils.tap(Locator.BUTTON_LANJUT)
		} else {
			KeywordUtil.markFailedAndStop("Failed: OTP input wait time expired (${timeoutInSeconds} seconds).")
		}
	}

	private static boolean waitForButtonEnabled(def locator, int timeoutInSeconds) {
		for (int i = 1; i <= timeoutInSeconds; i++) {
			String disabledAttr = CommonUtils.getAttribute(locator, "disabled", 1)
			if (disabledAttr == null) {
				return true
			}
			WebUI.delay(1)
		}
		return false
	}
}