import com.kms.katalon.core.context.TestCaseContext
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import internal.GlobalVariable

import java.lang.Exception
import java.io.BufferedReader
import java.io.InputStreamReader

class AdbRecoveryListener {

	/**
	 * Dipanggil SETELAH setiap test case selesai (PASS atau FAIL)
	 */
	def void afterTestCase(TestCaseContext testCaseContext) {

		String testCaseStatus = testCaseContext.getTestCaseStatus()
		String errorMessage = testCaseContext.getMessage()

		KeywordUtil.logInfo("========================================")
		KeywordUtil.logInfo("Test Case : ${testCaseContext.getTestCaseId()}")
		KeywordUtil.logInfo("Status    : ${testCaseStatus}")
		KeywordUtil.logInfo("========================================")

		// Lanjut hanya jika gagal dan errornya terkait ADB
		if (testCaseStatus == "FAILED" && isAdbError(errorMessage)) {

			// Ambil UDID dari GlobalVariable (sesuai dengan getActiveDeviceSerial kamu)
			String deviceUDID = getDeviceUDID()

			KeywordUtil.markWarning("ADB error terdeteksi pada device: ${deviceUDID}")
			KeywordUtil.markWarning("Error message: ${errorMessage}")

			try {
				// Reset device spesifik tanpa mengganggu device lain
				if (deviceUDID && !deviceUDID.isEmpty()) {
					resetSpecificDevice(deviceUDID)
				} else {
					KeywordUtil.markWarning("UDID tidak ditemukan, mencoba reset semua device (hati-hati multi-device!)")
					resetAllDevices()
				}

				// Tutup aplikasi untuk membersihkan session
				try {
					Mobile.closeApplication()
					KeywordUtil.logInfo("Session aplikasi ditutup")
				} catch (Exception e) {
					KeywordUtil.logInfo("Tidak ada session aplikasi yang perlu ditutup")
				}

				KeywordUtil.logInfo("Device ${deviceUDID} siap digunakan kembali")

			} catch (Exception ex) {
				KeywordUtil.markWarning("Gagal reset device ${deviceUDID}: ${ex.getMessage()}")
			}
		}
	}

	/**
	 * Ambil UDID dari GlobalVariable sesuai dengan getActiveDeviceSerial() punya kamu
	 */
	private String getDeviceUDID() {
		// Prioritas sesuai dengan kode AppManagement kamu:
		// 1. System property
		String fromProperty = System.getProperty("device.serial")
		if (fromProperty) return fromProperty

		// 2. GlobalVariable (pakai nama yang sama: DEVICE_UDID)
		try {
			if (GlobalVariable.DEVICE_UDID && !GlobalVariable.DEVICE_UDID.isEmpty()) {
				return GlobalVariable.DEVICE_UDID
			}
		} catch (Exception ignored) {
			// GlobalVariable.DEVICE_UDID mungkin belum didefinisikan
		}

		// 3. Environment variable
		String fromEnv = System.getenv("DEVICE_SERIAL")
		if (fromEnv) return fromEnv

		// 4. Fallback: coba auto-detect
		return autoDetectFirstDevice()
	}

	/**
	 * Auto-detect device pertama yang online (mirip autoDetectDevice kamu)
	 */
	private String autoDetectFirstDevice() {
		try {
			Process process = Runtime.getRuntime().exec("adb devices")
			BufferedReader reader = new BufferedReader(new InputStreamReader(process.inputStream))
			String line
			while ((line = reader.readLine()) != null) {
				if (line.contains("\tdevice") && !line.startsWith("List")) {
					String udid = line.split("\t")[0]
					KeywordUtil.logInfo("Auto-detected device: ${udid}")
					return udid
				}
			}
			process.waitFor()
		} catch (Exception e) {
			KeywordUtil.markWarning("Gagal auto-detect device: ${e.message}")
		}
		return null
	}

	/**
	 * Reset hanya device spesifik tanpa kill-server
	 */
	private void resetSpecificDevice(String udid) {
		KeywordUtil.logInfo("Reset device: ${udid}")

		// 1. Disconnect device spesifik (ini tidak mempengaruhi device lain)
		Process disconnect = Runtime.getRuntime().exec("adb -s ${udid} reconnect device")
		disconnect.waitFor()
		KeywordUtil.logInfo("Device ${udid} di-reconnect")

		Thread.sleep(3000)

		// 2. Verifikasi device kembali online (tunggu max 30 detik)
		int maxRetry = 10
		boolean deviceReady = false
		for (int i = 0; i < maxRetry; i++) {
			Process check = Runtime.getRuntime().exec("adb -s ${udid} shell echo 'OK'")
			check.waitFor()
			String result = check.inputStream.text.trim()
			if (result == "OK") {
				deviceReady = true
				KeywordUtil.logInfo("Device ${udid} sudah online setelah ${i + 1}x cek")
				break
			}
			Thread.sleep(3000)
		}

		if (!deviceReady) {
			throw new RuntimeException("Device ${udid} tidak kunjung online setelah ${maxRetry}x retry")
		}

		// 3. Optional: Clear app data agar device bersih (pakai method kamu sendiri)
		try {
			clearAppDataForDevice(udid)
		} catch (Exception e) {
			KeywordUtil.markWarning("Gagal clear app data: ${e.message}")
		}
	}

	/**
	 * Clear app data untuk device spesifik (opsional)
	 */
	private void clearAppDataForDevice(String udid) {
		String packageName = "com.axis.net"
		String command = "adb -s ${udid} shell pm clear ${packageName}"

		KeywordUtil.logInfo("Clear app data: ${command}")
		Process process = Runtime.getRuntime().exec(command)
		process.waitFor()

		if (process.exitValue() == 0) {
			KeywordUtil.logInfo("App data cleared successfully")
		} else {
			KeywordUtil.logInfo("Clear app data selesai (exit code: ${process.exitValue()})")
		}
	}

	/**
	 * Fallback: Reset semua device (hati-hati untuk multi-device paralel!)
	 */
	private void resetAllDevices() {
		KeywordUtil.markWarning("Melakukan full ADB restart (semua device akan terpengaruh)")

		Runtime.getRuntime().exec("adb kill-server").waitFor()
		KeywordUtil.logInfo("ADB server killed")
		Thread.sleep(3000)

		Runtime.getRuntime().exec("adb start-server").waitFor()
		KeywordUtil.logInfo("ADB server started")
		Thread.sleep(3000)

		// Verifikasi
		Process process = Runtime.getRuntime().exec("adb devices")
		process.waitFor()
		KeywordUtil.logInfo("Devices after restart:\n${process.inputStream.text}")
	}

	/**
	 * Deteksi apakah error mengandung keyword ADB
	 */
	private boolean isAdbError(String errorMessage) {
		if (errorMessage == null) return false

		def adbKeywords = [
			"Unable to start app",
			"NoSuchSessionException",
			"session identified by",
			"device offline",
			"ADB server didn't ACK",
			"Failed to setup application",
			"Could not find a connected Android device",
			"ADB command failed",
			"ADB command timed out",      
			"Failed to open application",
			"socket hang up",
			"Could not proxy command",            
			"Unknown server-side error"
		]

		return adbKeywords.any { errorMessage.contains(it) }
	}
}