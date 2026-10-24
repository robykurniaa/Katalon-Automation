package axisnet_support

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.util.KeywordUtil
import internal.GlobalVariable
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import java.util.concurrent.TimeUnit

public class DeviceManager {

	// ========== CONSTANTS & CACHE ==========
	private static final String DEFAULT_PACKAGE = "com.axis.net"
	private static final int ADB_TIMEOUT_SECONDS = 30

	// ThreadLocal cache to store UDID per thread, avoiding repetitive Appium/ADB calls
	private static ThreadLocal<String> threadDeviceCache = new ThreadLocal<>()

	/**
	 * Thread-safe method to get the active device UDID with caching mechanism.
	 * Dramatically improves performance on repeated calls within the same thread.
	 */
	@Keyword
	static String getActiveDeviceUDID() {
		// 0. Check cache first
		String cachedUdid = threadDeviceCache.get()
		if (cachedUdid) {
			return cachedUdid
		}

		String resolvedUdid = null

		// 1. Try getting it from the active Katalon session
		try {
			def driver = MobileDriverFactory.getDriver()
			if (driver) {
				def caps = driver.getCapabilities()
				resolvedUdid = caps.getCapability("udid") ?:
						caps.getCapability("appium:udid") ?:
						caps.getCapability("deviceUDID") ?:
						caps.getCapability("deviceName")

				if (resolvedUdid) logInfo("Device UDID retrieved from Appium session: ${resolvedUdid}")
			}
		} catch (Exception e) {
			// Driver might not be initialized yet, proceed to fallbacks
		}

		// 2. Fallback: GlobalVariable
		if (!resolvedUdid && GlobalVariable.DEVICE_UDID) {
			resolvedUdid = GlobalVariable.DEVICE_UDID
			logInfo("Device UDID retrieved from GlobalVariable: ${resolvedUdid}")
		}

		// 3. Fallback: System property (usually set by CI/CD pipelines)
		if (!resolvedUdid) {
			String serialFromProperty = System.getProperty("device.serial")
			if (serialFromProperty) {
				resolvedUdid = serialFromProperty
				logInfo("Device UDID retrieved from System Property: ${resolvedUdid}")
			}
		}

		// 4. Last resort: auto-detect physical/emulator device
		if (!resolvedUdid) {
			resolvedUdid = autoDetectSingleDevice()
		}

		// Save to cache if found, so next calls are instant
		if (resolvedUdid) {
			threadDeviceCache.set(resolvedUdid)
		}

		return resolvedUdid
	}

	/**
	 * Clear the UDID cache for the current thread. 
	 * Useful if testing involves switching devices mid-test.
	 */
	@Keyword
	static void clearDeviceCache() {
		threadDeviceCache.remove()
		logInfo("Device cache cleared for current thread")
	}

	/**
	 * Smarter auto-detect: Ignores offline/unauthorized devices.
	 */
	private static String autoDetectSingleDevice() {
		try {
			def result = executeAdbCommand(["adb", "devices", "-l"], 10)
			List<Map<String, String>> readyDevices = []

			result.output.split('\n').each { line ->
				String trimmedLine = line.trim()
				// Skip empty lines and header
				if (trimmedLine && !trimmedLine.startsWith("List")) {
					String[] parts = trimmedLine.split("\\s+")

					// Only process if device status is strictly 'device' (ignore offline/unauthorized)
					if (parts.length >= 2 && parts[1] == "device") {
						Map<String, String> deviceData = [serial: parts[0]]

						for (int i = 2; i < parts.length; i++) {
							if (parts[i].contains(":")) {
								def (key, value) = parts[i].split(":", 2)
								deviceData[key] = value
							}
						}
						readyDevices.add(deviceData)
					}
				}
			}

			if (readyDevices.isEmpty()) {
				logInfo("No 'ready' devices found via ADB auto-detect.")
				return null
			}

			// Prioritize physical devices over emulators
			def physicalDevice = readyDevices.find {
				it.model && !it.model.contains("sdk_gphone") && !it.model.contains("emulator")
			}
			def selectedDevice = physicalDevice ?: readyDevices[0]

			logInfo("Auto-detected ready device: ${selectedDevice.serial} (${selectedDevice.model ?: 'Unknown'})")

			if (readyDevices.size() > 1) {
				KeywordUtil.markWarning("[${getThreadName()}] Multiple ready devices found! Defaulting to: ${selectedDevice.serial}.")
			}

			return selectedDevice.serial
		} catch (Exception e) {
			logInfo("Auto-detect failed: ${e.message}")
			return null
		}
	}

	/**
	 * Verify device is connected and responsive.
	 */
	@Keyword
	static boolean verifyDeviceConnection() {
		String udid = getActiveDeviceUDID()
		if (!udid) {
			KeywordUtil.markFailed("No device connected or detected")
			return false
		}

		try {
			def result = executeAdbCommand([
				"adb",
				"-s",
				udid,
				"shell",
				"getprop",
				"ro.build.version.release"
			], 10)
			if (result.exitCode == 0 && result.output.trim()) {
				logInfo("Device ${udid} is connected and responsive (Android ${result.output.trim()})")
				return true
			}
		} catch (Exception e) {
			KeywordUtil.markFailed("Device ${udid} connection verification failed: ${e.message}")
		}
		return false
	}

	/**
	 * Checks if the specific application is currently installed on the device.
	 */
	@Keyword
	static boolean isAppInstalled(String packageName = DEFAULT_PACKAGE) {
		String udid = getActiveDeviceUDID()
		if (!udid) return false

		try {
			def result = executeAdbCommand([
				"adb",
				"-s",
				udid,
				"shell",
				"pm",
				"list",
				"packages",
				packageName
			], 10)
			boolean installed = result.output.contains("package:${packageName}")
			logInfo("App ${packageName} installed status: ${installed}")
			return installed
		} catch (Exception e) {
			logInfo("Failed to check app installation status: ${e.message}")
			return false
		}
	}

	/**
	 * Clear app data for a specific device serial number.
	 */
	@Keyword
	static void clearAppData(String packageName, String deviceSerial) {
		if (!deviceSerial) throw new IllegalArgumentException("Device serial cannot be null")

		logInfo("Executing: adb -s ${deviceSerial} shell pm clear ${packageName}")
		try {
			def result = executeAdbCommand([
				"adb",
				"-s",
				deviceSerial,
				"shell",
				"pm",
				"clear",
				packageName
			], ADB_TIMEOUT_SECONDS)

			if (result.exitCode != 0) {
				KeywordUtil.markWarning("[${getThreadName()}] ADB Output: ${result.output}")
				throw new RuntimeException("[${getThreadName()}] ADB command failed with exit code ${result.exitCode}: ${result.error}")
			}
			logInfo("App data cleared successfully for: ${packageName}")
		} catch (IllegalStateException e) {
			throw new IllegalStateException("[${getThreadName()}] ADB command timed out for device ${deviceSerial}", e)
		}
	}

	/**
	 * Clear app data for the currently active device in this thread.
	 */
	@Keyword
	static void clearAppDataForCurrentDevice(String packageName = DEFAULT_PACKAGE) {
		String deviceSerial = getActiveDeviceUDID()
		if (deviceSerial) {
			clearAppData(packageName, deviceSerial)
		} else {
			KeywordUtil.markWarning("Cannot clear data: No device detected in current thread")
		}
	}

	// ========== HELPER METHODS ==========

	private static Map executeAdbCommand(List<String> command, int timeoutSeconds) {
		Process process = command.execute()

		StringBuilder out = new StringBuilder()
		StringBuilder err = new StringBuilder()
		process.consumeProcessOutput(out, err)

		boolean finished = process.waitFor(timeoutSeconds, TimeUnit.SECONDS)

		if (!finished) {
			process.destroyForcibly()
			throw new IllegalStateException("Command timed out after ${timeoutSeconds}s: ${command.join(' ')}")
		}

		return [
			exitCode: process.exitValue(),
			output  : out.toString().trim(),
			error   : err.toString().trim()
		]
	}

	private static String getThreadName() {
		return Thread.currentThread().getName()
	}

	private static void logInfo(String message) {
		KeywordUtil.logInfo("[${getThreadName()}] ${message}")
	}
}