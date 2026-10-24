package axisnet_support

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.util.KeywordUtil
import java.util.concurrent.TimeUnit
import axisnet_support.DeviceManager // Import DeviceManager for UDID retrieval

public class NotificationHelper {

	/**
	 * Tipe OTP yang tersedia: "LOGIN", "TRANSFER_PULSA", "TRANSFER_KUOTA", "GAME_TOKEN", "ALL"
	 */
	public static String waitForOTPNotification(int timeoutSeconds, String otpType = "ALL") {
		String deviceSerial = DeviceManager.getActiveDeviceUDID()
		if (!deviceSerial) {
			log("Failed to get device UDID. Cannot read notification.")
			return null
		}

		log("Waiting for ${otpType} OTP notification on device ${deviceSerial} (max ${timeoutSeconds}s)...")
		long startTime = System.currentTimeMillis()

		while (System.currentTimeMillis() - startTime < timeoutSeconds * 1000) {
			try {
				String result = executeAdbCommandSafe([
					"adb",
					"-s",
					deviceSerial,
					"shell",
					"dumpsys",
					"notification",
					"--noredact"
				], true)

				// Potong history agar hanya membaca notifikasi aktif
				def historyKeywords = [
					"mHistory",
					"mArchive",
					"Archive:",
					"Historical:"
				]
				int cutoffIndex = result.length()
				for (String keyword : historyKeywords) {
					int idx = result.indexOf(keyword)
					if (idx != -1 && idx < cutoffIndex) {
						cutoffIndex = idx
					}
				}
				if (cutoffIndex < result.length()) {
					result = result.substring(0, cutoffIndex)
				}

				// Cek notifikasi berdasarkan tipe
				if (isOtpNotif(result, otpType)) {
					def textMatcher = (result =~ /(?:android\.text|tickerText)=([^\n]+)/)
					while (textMatcher.find()) {
						String notifText = textMatcher.group(1)
						if (isOtpNotif(notifText, otpType)) {
							String otp = extractOTP(notifText, otpType)
							if (otp) {
								log("${otpType} OTP extracted: ${otp}")
								return otp
							}
						}
					}
				}
			} catch (Exception e) {
				// Silent fail, retry
			}
			Mobile.delay(1)
		}

		log("No ${otpType} OTP notification found within ${timeoutSeconds}s")
		return null
	}

	public static void clearNotification() {
		String deviceSerial = DeviceManager.getActiveDeviceUDID()
		if (!deviceSerial) return

		try {
			executeAdbCommandSafe([
				"adb",
				"-s",
				deviceSerial,
				"shell",
				"content",
				"update",
				"--uri",
				"content://sms/inbox",
				"--bind",
				"read:i:1",
				"--where",
				"read=0"
			], false)
			executeAdbCommandSafe([
				"adb",
				"-s",
				deviceSerial,
				"shell",
				"cmd",
				"notification",
				"clear"
			], false)
			executeAdbCommandSafe([
				"adb",
				"-s",
				deviceSerial,
				"shell",
				"service",
				"call",
				"notification",
				"1"
			], false)

			Mobile.delay(1)
			log("Old notifications & SMS unread status cleared on device ${deviceSerial}")
		} catch (Exception e) {
			log("Failed to clear notifications: ${e.message}")
		}
	}

	// Memisahkan kata kunci berdasarkan jenis SMS
	private static boolean isOtpNotif(String text, String otpType) {
		if (!text) return false
		String lowerText = text.toLowerCase()

		// Semua SMS dari Axis pasti punya kata axisnet
		if (!lowerText.contains("axisnet")) return false

		switch (otpType) {
			case "LOGIN":
			return lowerText.contains("kata sandi") || lowerText.contains("login axisnet")
			case "TRANSFER_PULSA":
			return lowerText.contains("bagi pulsa")
			case "TRANSFER_KUOTA":
			return lowerText.contains("transfer kuota")
			case "GAME_TOKEN":
			return lowerText.contains("game token")
			default: // "ALL"
			return lowerText.contains("kata sandi") || lowerText.contains("kode otp")
		}
	}

	// Memisahkan Regex (Pencari Angka) berdasarkan kalimat pastinya
	private static String extractOTP(String text, String otpType) {
		if (!isOtpNotif(text, otpType)) return null

		String cleanText = text.replaceAll("\\\\[nr]", " ").replaceAll("\\s+", " ").trim()
		def patterns = []

		switch (otpType) {
			case "LOGIN":
			// Mencari: kata sandi kamu 184639
			patterns = [
				/(?i)kata\s*sandi\s*kamu\s*(\d{6})/
			]
			break
			case "TRANSFER_PULSA":
			// Mencari: kode OTP: 323309 untuk transaksi Bagi Pulsa
			patterns = [
				/(?i)kode\s*OTP:\s*(\d{6})\s*untuk\s*transaksi\s*Bagi\s*Pulsa/
			]
			break
			case "TRANSFER_KUOTA":
			// Mencari: kode OTP: 440802 untuk transaksi Transfer Kuota
			patterns = [
				/(?i)kode\s*OTP:\s*(\d{6})\s*untuk\s*transaksi\s*Transfer\s*Kuota/
			]
			break
			case "GAME_TOKEN":
			// Mencari: kode OTP: 640813 untuk transaksi Game Token
			patterns = [
				/(?i)kode\s*OTP:\s*(\d{6})\s*untuk\s*transaksi\s*Game\s*Token/
			]
			break
			default: // Fallback jika pakai "ALL"
			patterns = [
				/(?i)kata\s*sandi\s*kamu\s*(\d{6})/,
				/(?i)kode\s*OTP:\s*(\d{6})\s*untuk\s*transaksi/
			]
			break
		}

		for (pattern in patterns) {
			def matcher = (cleanText =~ pattern)
			if (matcher.find()) {
				String candidate = matcher.group(1)
				if (candidate.length() == 6 && candidate.isNumber()) return candidate
			}
		}
		return null
	}

	public static String executeAdbCommandSafe(List<String> command, boolean returnOutput = false) {
		try {
			Process process = command.execute()
			StringBuilder out = new StringBuilder()
			StringBuilder err = new StringBuilder()
			process.consumeProcessOutput(out, err)
			boolean finished = process.waitFor(15, TimeUnit.SECONDS)

			if (!finished) {
				process.destroyForcibly()
				log("ADB Command timed out: ${command.join(' ')}")
				return ""
			}

			return returnOutput ? out.toString().trim() : ""
		} catch (Exception e) {
			log("ADB Command failed [${command.join(' ')}]: ${e.message}")
			return ""
		}
	}

	private static void log(String message) {
		String threadName = Thread.currentThread().getName()
		KeywordUtil.logInfo("[NotificationHelper][${threadName}] ${message}")
	}
}