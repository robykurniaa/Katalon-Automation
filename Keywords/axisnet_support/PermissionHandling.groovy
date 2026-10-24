package axisnet_support

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.util.KeywordUtil
import internal.GlobalVariable
import support.CommonUtils
import support.exceptions.TestActionException
import axisnet_support.LocatorPaths as Locator
import axisnet_support.AppManagement
import axisnet_support.DeviceManager

public class PermissionHandling {

	/**
	 * Grant permissions untuk aplikasi
	 * @param packageName Package name aplikasi
	 * @param deviceSerial (Optional) Device serial, auto-detect jika tidak diisi
	 */
	@Keyword
	static void grantPermissions(String packageName, String deviceSerial = null) {
		String threadName = Thread.currentThread().getName()

		if (!deviceSerial) {
			deviceSerial = DeviceManager.getActiveDeviceUDID()
			if (!deviceSerial) {
				KeywordUtil.markWarning("[${threadName}] ⚠️ No device found for granting permissions")
				return
			}
		}

		KeywordUtil.logInfo("[${threadName}] 🔐 Granting permissions for ${packageName} on device: ${deviceSerial}")

		// Filter: hanya permission yang bisa di-grant via ADB
		def permissions = [
			// Runtime permissions (bisa di-grant)
			"android.permission.READ_CONTACTS",
			"android.permission.ACCESS_FINE_LOCATION",
			"android.permission.ACCESS_COARSE_LOCATION",
			"android.permission.READ_PHONE_STATE",
			"android.permission.POST_NOTIFICATIONS",
			"android.permission.READ_EXTERNAL_STORAGE",
			"android.permission.WRITE_EXTERNAL_STORAGE",
			"android.permission.CAMERA",
		]

		// Enable USB debugging mode
		try {
			Runtime.getRuntime().exec("adb -s ${deviceSerial} shell settings put global development_settings_enabled 1")
			Runtime.getRuntime().exec("adb -s ${deviceSerial} shell settings put global adb_enabled 1")
		} catch (Exception e) {
			KeywordUtil.logInfo("[${threadName}] USB debugging: ${e.message}")
		}

		int grantedCount = 0
		int skippedCount = 0
		int failedCount = 0

		permissions.each { permission ->
			String permissionName = permission.split("\\.").last()

			try {
				String checkCmd = "adb -s ${deviceSerial} shell pm check-permission ${permission} ${packageName}"
				Process checkProcess = Runtime.getRuntime().exec(checkCmd)
				String checkResult = checkProcess.text.trim()
				checkProcess.waitFor()

				if (checkResult.contains("granted")) {
					// Sudah granted, skip
					skippedCount++
				} else {
					String grantCmd = "adb -s ${deviceSerial} shell pm grant ${packageName} ${permission}"
					Process grantProcess = Runtime.getRuntime().exec(grantCmd)

					String errorOutput = grantProcess.errorStream.text.trim()
					int exitCode = grantProcess.waitFor()

					if (exitCode == 0) {
						KeywordUtil.logInfo("[${threadName}]   ✓ ${permissionName}")
						grantedCount++
					} else if (errorOutput.contains("not a changeable permission type")) {
						// Normal untuk INTERNET, MANAGE_EXTERNAL_STORAGE
						skippedCount++
					} else if (errorOutput.contains("has not requested permission")) {
						// Normal - app tidak deklarasi permission ini di Manifest
						skippedCount++
					} else {
						KeywordUtil.logInfo("[${threadName}]   ⚠ ${permissionName} failed")
						failedCount++
					}
				}

				Thread.sleep(300)
			} catch (Exception e) {
				failedCount++
			}
		}

		// Summary singkat (tanpa spam log)
		if (failedCount > 0) {
			KeywordUtil.logInfo("[${threadName}] ✅ Permissions: ${grantedCount} granted, ${skippedCount} skipped, ${failedCount} failed (expected)")
		} else {
			KeywordUtil.logInfo("[${threadName}] ✅ Permissions: ${grantedCount} granted, ${skippedCount} skipped")
		}
	}

	/**
	 * Revoke specific permission (untuk testing negative case)
	 */
	@Keyword
	static void revokePermission(String packageName, String permission, String deviceSerial = null) {
		if (!deviceSerial) {
			deviceSerial = DeviceManager.getActiveDeviceUDID()
		}

		try {
			String revokeCmd = "adb -s ${deviceSerial} shell pm revoke ${packageName} ${permission}"
			Process process = Runtime.getRuntime().exec(revokeCmd)
			process.waitFor()
			KeywordUtil.logInfo("Permission revoked: ${permission.split("\\.").last()}")
		} catch (Exception e) {
			KeywordUtil.markWarning("Failed to revoke permission: ${e.message}")
		}
	}

	@Keyword
	static void popUpPermissions() {
		try {
			if (CommonUtils.isElementExist(Locator.LOCATION_PERMISSION, 5)) {
				CommonUtils.tap(Locator.PERMISSION_BUTTON_WHILE_USING_APP)

				CommonUtils.handleOptionalElement(
						Locator.NOTIFICATION_PERMISSION,
						{ -> CommonUtils.tap(Locator.PERMISSION_BUTTON_ALLOW)},
						5)

				CommonUtils.handleOptionalElement(
						Locator.PHONE_CALLS_PERMISSION,
						{ -> CommonUtils.tap(Locator.PERMISSION_BUTTON_ALLOW)},
						5)
			}
		} catch (TestActionException e) {
			CommonUtils.captureScreenshot("error_during_pop_up_permissions")
			throw new TestActionException("Failed during handling pop up permissions", e)
		}
	}
}