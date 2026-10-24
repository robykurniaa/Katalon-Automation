package axisnet_support

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.configuration.RunConfiguration

import internal.GlobalVariable
import axisnet_support.PermissionHandling as Permission
import support.CommonUtils
import axisnet_support.NotificationHelper
import axisnet_support.LocatorPaths as Locator
import support.exceptions.*
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import io.appium.java_client.InteractsWithApps

/**
 * AppManagement class handles the application's lifecycle, environment detection (Local vs TestCloud),
 * and authentication state (Login, Logout, Pre-Login, and App Reset).
 */
public class AppManagement {

	private static final String PACKAGE_NAME = "com.axis.net"
	private static final String PHONE_NUMBER_XPATH = "//*[@resource-id='com.axis.net:id/msisdnTv']"

	/**
	 * Represents the state of the MSISDN found on the dashboard compared to the expected MSISDN.
	 */
	private enum DASHBOARD_STATUS {
		MATCH,      // The displayed MSISDN matches (or specific user is not required) -> Skip login
		MISMATCH,   // The displayed MSISDN is different -> Requires logout
		NOT_FOUND   // The MSISDN element is not found -> Requires app restart/clear data
	}

	/**
	 * Main entry point to start the application and ensure the correct user is logged in.
	 * Skips the login flow if the expected user is already logged in or if specific user is not required.
	 * * @param msisdn The phone number intended to be logged in (used as fallback if requireSpecificUser is false).
	 * @param otp The OTP code used for manual login if auto-detection fails.
	 * @param requireSpecificUser If false, skips login as long as ANY user is already logged in on the dashboard.
	 */
	@Keyword
	static void startApplication(String msisdn, String otp = GlobalVariable.AxisDefaultOTP, boolean requireSpecificUser = true) {
		log("========== START APPLICATION ==========")
		log("MSISDN: ${msisdn} | Require Specific User: ${requireSpecificUser}")

		try {
			boolean isTestCloud = isRunningOnTestCloud()
			log("Environment detected: ${isTestCloud ? 'TestCloud / Remote' : 'Local / Laptop'}")

			if (isTestCloud) {
				log("TestCloud: Checking current app state...")
				Mobile.startApplication('', false)
				Mobile.delay(5)

				String msisdnForSearch = normalizeMsisdn(msisdn)
				Integer dashboardStatus = tryFindPhoneNumber(msisdnForSearch, 0, requireSpecificUser)

				if (dashboardStatus == 1) {
					log("TestCloud: User criteria met! Skipping login flow...")
					handleDashboardPopups()
					log("========== START APPLICATION COMPLETED (SKIPPED LOGIN) ==========")
					return
				} else {
					log("TestCloud: MSISDN mismatch or not found. Resetting app...")
					Mobile.startApplication('', true)
					Mobile.delay(5)

					log("Performing full login (TestCloud mode)...")
					performLoginFlow(msisdn, otp, isTestCloud)
				}
			} else {
				// ==========================================
				// LOCAL EXECUTION FLOW
				// ==========================================
				log("Starting application locally...")

				boolean driverReused = false

				try {
					def driver = MobileDriverFactory.getDriver()

					if (driver != null) {
						log("Reusing existing Appium session...")
						((InteractsWithApps) driver).activateApp(PACKAGE_NAME)
						driverReused = true
					}
				} catch (Exception e) {
					log("No reusable Appium session available: ${e.message}")
				}

				if (!driverReused) {
					log("Creating a new Appium session...")
					Mobile.startExistingApplication(PACKAGE_NAME)
				}

				Thread.sleep(2000)

				String deviceSerial = DeviceManager.getActiveDeviceUDID()
				if (!deviceSerial) throw new RuntimeException("No device detected via ADB")
				log("Device detected: ${deviceSerial}")

				log("Checking dashboard for MSISDN...")
				DASHBOARD_STATUS status = checkMsisdnOnDashboard(msisdn, deviceSerial, requireSpecificUser)

				if (status == DASHBOARD_STATUS.MATCH) {
					log("User criteria met on dashboard. Skipping login flow...")
					handleDashboardPopups()
					log("========== START APPLICATION COMPLETED (SKIPPED LOGIN) ==========")
					return
				}

				if (status == DASHBOARD_STATUS.MISMATCH) {
					log("MSISDN mismatch detected. Performing logout...")
					performLogout()
				} else if (status == DASHBOARD_STATUS.NOT_FOUND) {
					log("Still not on dashboard after restart. Falling back to clear data...")
					performClearDataAndRestart(deviceSerial)
				}

				log("Performing full login (Local mode)...")
				performLoginFlow(msisdn, otp, isTestCloud)
			}

			log("========== START APPLICATION COMPLETED ==========")
		} catch (TestActionException e) {
			markFailed("Login failed: ${e.message}")
			throw new TestActionException("Login process failed on device", e)
		} catch (Exception e) {
			markFailed("Unexpected error: ${e.message}")
			throw e
		}
	}

	/**
	 * Ensures the application is open and standing by at the Login Page (Pre-login state).
	 * Used for test cases testing features before a user logs in (e.g., Pre-login menus).
	 */
	@Keyword
	static void startAtLoginPage() {
		log("========== PREPARING LOGIN PAGE STATE ==========")

		try {
			boolean isTestCloud = isRunningOnTestCloud()

			if (isTestCloud) {
				log("TestCloud: Forcing fresh start (Clear Data)...")
				Mobile.startApplication('', true)
				Mobile.delay(5)
			} else {
				log("Local: Checking current app state...")
				Mobile.startExistingApplication(PACKAGE_NAME)
				Thread.sleep(2000)

				String deviceSerial = DeviceManager.getActiveDeviceUDID()
				if (!deviceSerial) throw new RuntimeException("No device detected via ADB")

				// 1. Check if already on the login page (MSISDN field is present)
				boolean isOnLoginPage = CommonUtils.isElementPresent(Locator.MSISDN_FIELD, 3, FailureHandling.OPTIONAL)

				if (!isOnLoginPage) {
					// 2. If no MSISDN field, check if user is logged in (Dashboard)
					TestObject phoneNumberObj = new TestObject("phoneNumberDashboard")
					phoneNumberObj.addProperty("xpath", ConditionType.EQUALS, PHONE_NUMBER_XPATH)

					if (Mobile.verifyElementExist(phoneNumberObj, 3, FailureHandling.OPTIONAL)) {
						log("App is on Dashboard. Performing Logout to reach Login Page...")
						performLogout()
					} else {
						// 3. If neither on Dashboard nor Login (unknown state), clear data
						log("App is in an unknown state. Performing Clear Data...")
						performClearDataAndRestart(deviceSerial)
					}
				} else {
					log("App is already on the Login Page.")
				}
			}

			log("========== READY AT LOGIN PAGE ==========")
		} catch (Exception e) {
			markFailed("Failed to prepare Login Page: ${e.message}")
			throw e
		}
	}

	// ============= CORE FLOW METHODS =============

	/**
	 * Executes the UI steps required to log into the application.
	 */
	private static void performLoginFlow(String msisdn, String otp, boolean isTestCloud) {
		log("========== LOGIN FLOW ==========")

		CommonUtils.handleOptionalElement(Locator.AXIS_LETS_START_BUTTON, { CommonUtils.hit(Locator.AXIS_LETS_START_BUTTON) }, 5)
		CommonUtils.handleOptionalElement(Locator.AXIS_AGREE_PERMISSION_BUTTON, { CommonUtils.hit(Locator.AXIS_AGREE_PERMISSION_BUTTON) }, 3)

		log("Entering MSISDN: ${msisdn}")
		CommonUtils.setText(Locator.MSISDN_FIELD, msisdn)

		if (!isTestCloud) {
			log("Clearing SMS Notification...")
			NotificationHelper.clearNotification()
		}

		log("Tapping login button...")
		CommonUtils.tap(Locator.AXIS_LOGIN_BUTTON)

		// Environment-based OTP Handling
		String autoOTP = null
		if (!isTestCloud) {
			log("Attempting to auto-detect OTP from notification (Local Mode)...")
			autoOTP = NotificationHelper.waitForOTPNotification(6, "LOGIN")
		} else {
			log("Running on TestCloud - Bypassing ADB notification check.")
		}

		Mobile.delay(3)

		log("Verifying UI state: Checking if OTP field is still present...")
		boolean isOtpFieldPresent = CommonUtils.isElementPresent(Locator.OTP_FIELD, 3, FailureHandling.OPTIONAL)

		if (!isOtpFieldPresent) {
			log("OTP field is no longer visible. Native auto-read successful. Skipping manual input...")
		} else {
			log("OTP field is still visible (Native auto-read failed or delayed).")

			if (autoOTP) {
				log("Injecting intercepted OTP: ${autoOTP}...")
				CommonUtils.setText(Locator.OTP_FIELD, autoOTP)
				CommonUtils.hit(Locator.AXIS_CONTINUE_BUTTON)
			} else {
				log("No OTP notification captured. Falling back to manual/hardcoded input...")
				CommonUtils.setText(Locator.OTP_FIELD, otp, 30)
				CommonUtils.hit(Locator.AXIS_CONTINUE_BUTTON)
			}
		}
		CommonUtils.handleOptionalElement(Locator.VERIF_BIO_TEXT_VIEW, { CommonUtils.tap(Locator.IGNORE_SET_BIOMETRIC) }, 5)
		CommonUtils.handleOptionalElement(Locator.SNK_PAGE_LOGIN, { CommonUtils.tap(Locator.BUTTON_SETUJU) }, 5)

		// Close any remaining popups sequentially
		3.times {
			Mobile.pressBack()
			Mobile.delay(3)
		}

		log("Successfully logged in - Dashboard visible")
		handleDashboardPopups()
		log("Login flow completed!")
	}

	// ============= ENVIRONMENT CHECK =============

	/**
	 * Determines if the script is executing on a cloud platform.
	 */
	private static boolean isRunningOnTestCloud() {
		try {
			Map runConfig = RunConfiguration.getExecutionProperties()

			Map generalProps = (Map) runConfig.get("general")
			String executedBrowser = generalProps?.get("executedBrowser")?.toString()
			String driverName = generalProps?.get("driver")?.toString()

			boolean isCloud = (executedBrowser == "TestCloud" || executedBrowser == "Remote" ||
					driverName == "TestCloud" || driverName == "Remote")

			Map driversProps = (Map) runConfig.get("drivers")
			String driversString = driversProps?.toString() ?: ""

			boolean hasCloudConfig = driversString.contains("TestCloud") ||
					driversString.contains("remoteWebDriverUrl") ||
					driversString.contains("kobiton")

			return isCloud || hasCloudConfig
		} catch (Exception e) {
			log("Failed to detect execution environment. Error: ${e.message}")
			return false
		}
	}

	// ============= VALIDATION & EXTRACTION HELPERS =============

	/**
	 * Validates the currently logged-in MSISDN against the expected MSISDN.
	 */
	private static DASHBOARD_STATUS checkMsisdnOnDashboard(String expectedMsisdn, String deviceSerial, boolean requireSpecificUser) {
		try {
			String msisdnForSearch = normalizeMsisdn(expectedMsisdn)

			// First check
			Integer result = tryFindPhoneNumber(msisdnForSearch, 0, requireSpecificUser)
			if (result == 1) return DASHBOARD_STATUS.MATCH
			if (result == -1) return DASHBOARD_STATUS.MISMATCH

			// Not found condition 1: Force close and reopen
			log("Phone number not visible. Closing application to return to dashboard...")
			boolean isTestCloud = isRunningOnTestCloud()
			closeApplication(deviceSerial, isTestCloud)
			Thread.sleep(2000)

			log("Restarting application via startExistingApplication...")
			Mobile.startExistingApplication(PACKAGE_NAME)
			Thread.sleep(3000)


			// Second check after restart
			result = tryFindPhoneNumber(msisdnForSearch, 1, requireSpecificUser)
			if (result == 1) return DASHBOARD_STATUS.MATCH
			if (result == -1) return DASHBOARD_STATUS.MISMATCH

			// Not found condition 2: App state unknown, fallback to clear data
			log("After restart: Phone number still not found -> unexpected state.")
			return DASHBOARD_STATUS.NOT_FOUND
		} catch (Exception e) {
			log("Dashboard check error: ${e.message}")
			return DASHBOARD_STATUS.NOT_FOUND
		}
	}

	/**
	 * Attempts to locate and verify the phone number text on the dashboard.
	 */
	private static Integer tryFindPhoneNumber(String expectedMsisdn, int attempt, boolean requireSpecificUser) {
		try {
			TestObject phoneNumberObj = new TestObject("phoneNumberDashboard")
			phoneNumberObj.addProperty("xpath", ConditionType.EQUALS, PHONE_NUMBER_XPATH)

			int timeout = (attempt == 0) ? 10 : 5
			if (!Mobile.verifyElementExist(phoneNumberObj, timeout, FailureHandling.OPTIONAL)) return 0 // NOT_FOUND

			String actualText = Mobile.getText(phoneNumberObj, timeout)
			if (actualText?.trim()) {
				// LOGIC BARU: Jika tidak butuh MSISDN spesifik, asal ada elemen HP anggap MATCH
				if (!requireSpecificUser) {
					log("Found MSISDN ${actualText} on dashboard. Specific user not required. Proceeding...")
					return 1 // Dianggap MATCH
				}

				String actualClean = actualText.replaceAll("\\s+", "")
				String expectedClean = expectedMsisdn.replaceAll("\\s+", "")
				return actualClean.equals(expectedClean) ? 1 : -1
			}
			return 0
		} catch (Exception e) {
			return 0
		}
	}

	/**
	 * Standardizes the format of phone numbers.
	 */
	private static String normalizeMsisdn(String msisdn) {
		if (!msisdn) return ""
		if (msisdn.startsWith("+62")) return "0" + msisdn.substring(3)
		if (msisdn.startsWith("62")) return "0" + msisdn.substring(2)
		return msisdn
	}

	// ============= LOCAL FALLBACK & LOGOUT HELPERS =============

	/**
	 * Logs out the current user via the Profile menu.
	 */
	private static void performLogout() {
		try {
			log("========== PERFORMING LOGOUT ==========")
			CommonUtils.tap(Locator.BUTTON_PROFILE)
			CommonUtils.scrollToText("Keluar")
			CommonUtils.tap(Locator.BUTTON_KELUAR)
			CommonUtils.tap(Locator.BUTTON_YA)
			log("Logout successful! Now on login page.")
		} catch (Exception e) {
			log("Logout failed: ${e.message}. Falling back to clear data...")
			performClearDataAndRestart(DeviceManager.getActiveDeviceUDID())
		}
	}

	/**
	 * Wipes application data using ADB and restarts the app.
	 */
	private static void performClearDataAndRestart(String deviceSerial) {
		try {
			log("========== FALLBACK: CLEAR DATA ==========")
			DeviceManager.clearAppData(PACKAGE_NAME, deviceSerial)
			Thread.sleep(2000)

			log("Starting application freshly after clear data...")
			Mobile.startExistingApplication(PACKAGE_NAME)
			Thread.sleep(3000)

			Permission.grantPermissions(PACKAGE_NAME, deviceSerial)
		} catch (Exception e) {
			throw new RuntimeException("Failed to clear data and restart app", e)
		}
	}

	// ============= APP CONTROL HELPERS (LOCAL ADB) =============

	/**
	 * Forcefully terminates the application process.
	 */
	private static void closeApplication(String deviceSerial, boolean isTestCloud) {
		log("Force stopping application...")

		try {
			if (isTestCloud) {
				log("TestCloud Mode: Using Appium terminateApp...")
				def driver = MobileDriverFactory.getDriver()
				((InteractsWithApps) driver).terminateApp(PACKAGE_NAME)
			} else {
				log("Local Mode: Using ADB force-stop...")
				NotificationHelper.executeAdbCommandSafe([
					"adb",
					"-s",
					deviceSerial,
					"shell",
					"am",
					"force-stop",
					PACKAGE_NAME
				], false)
			}
			Thread.sleep(2000)
		} catch (Exception e) {
			log("Failed force-stop App: " + e.getMessage())
		}
	}

	// ============= OTHER METHODS =============

	/**
	 * Dismisses optional pop-ups over the dashboard (e.g., Medallia survey).
	 */
	private static void handleDashboardPopups() {
		CommonUtils.handleOptionalElement(Locator.MEDALLIA_TEXT, { CommonUtils.hit(Locator.MEDALLIA_CLOSE_BUTTON) }, 5)
	}

	/**
	 * Quick utility keyword to start the existing application without full validation.
	 */
	@Keyword
	static void quickDeviceTest() {
		Mobile.startExistingApplication(PACKAGE_NAME)
	}

	/**
	 * Logs informational messages prefixed with the current thread name.
	 */
	private static void log(String message, String customPrefix = "") {
		String threadName = Thread.currentThread().getName()
		String prefix = customPrefix ?: "[${threadName}]"
		KeywordUtil.logInfo("${prefix} ${message}")
	}

	/**
	 * Logs a failure message.
	 */
	private static void markFailed(String message) {
		String threadName = Thread.currentThread().getName()
		KeywordUtil.markFailed("[${threadName}] ${message}")
	}
}