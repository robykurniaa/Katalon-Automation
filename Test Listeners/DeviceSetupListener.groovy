import com.kms.katalon.core.context.TestCaseContext
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import internal.GlobalVariable

import java.lang.Exception
import java.io.BufferedReader
import java.io.InputStreamReader

import com.kms.katalon.core.annotation.BeforeTestCase
import com.kms.katalon.core.annotation.BeforeTestSuite
import com.kms.katalon.core.annotation.AfterTestSuite
import com.kms.katalon.core.context.TestSuiteContext
import axisnet_support.AppManagement

class DeviceSetupListener {
	
	/**
	 * Setup di awal Test Suite
	 * Dijalankan SEKALI - cocok untuk environment check
	 */
	@BeforeTestSuite
	def beforeTestSuite(TestSuiteContext context) {
		String suiteId = context.getTestSuiteId()
		
		KeywordUtil.logInfo("=" * 60)
		KeywordUtil.logInfo("Test Suite Starting: ${suiteId}")
		KeywordUtil.logInfo("=" * 60)
		
		// Reset Global Variable
		GlobalVariable.DEVICE_UDID = ""
		
		// Check ADB & connected devices
		checkEnvironment()
	}
	
	/**
	 * Setup sebelum SETIAP test case
	 * Ini yang penting untuk multi-device execution
	 */
	@BeforeTestCase
	def beforeTestCase(TestCaseContext testCaseContext) {
		String testCaseId = testCaseContext.getTestCaseId()
		String threadName = Thread.currentThread().getName()
		
		KeywordUtil.logInfo("-" * 40)
		KeywordUtil.logInfo("[${threadName}] 📋 Starting: ${testCaseId}")
		
		try {
			// Deteksi device - ini akan otomatis beda per thread
			String deviceUDID = AppManagement.getActiveDeviceUDID()
			
			if (deviceUDID) {
				KeywordUtil.logInfo("[${threadName}] 📱 Device: ${deviceUDID}")
				
				// Verifikasi koneksi
				if (!AppManagement.verifyDeviceConnection()) {
					KeywordUtil.markWarning("[${threadName}] ⚠️ Device may have issues")
				}
			} else {
				// Normal untuk first run, akan terdeteksi saat app start
				KeywordUtil.logInfo("[${threadName}] 📱 Device will auto-detect")
			}
			
		} catch (Exception e) {
			// Jangan gagalkan test, hanya warning
			KeywordUtil.logInfo("[${threadName}] ⚠️ ${e.message}")
		}
		
		KeywordUtil.logInfo("[${threadName}] ✅ Ready")
		KeywordUtil.logInfo("-" * 40)
	}
	
	/**
	 * Cleanup setelah semua test selesai
	 */
	@AfterTestSuite
	def afterTestSuite(TestSuiteContext context) {
		KeywordUtil.logInfo("=" * 60)
		KeywordUtil.logInfo("✅ Test Suite Completed")
		KeywordUtil.logInfo("=" * 60)
	}
	
	/**
	 * Cek ADB dan device yang tersedia
	 */
	private void checkEnvironment() {
		try {
			// Check ADB
			Process process = Runtime.getRuntime().exec("adb version")
			BufferedReader reader = new BufferedReader(new InputStreamReader(process.inputStream))
			String version = reader.readLine()
			process.waitFor()
			
			if (version && version.contains("Android Debug Bridge")) {
				KeywordUtil.logInfo("ADB: ${version}")
			} else {
				KeywordUtil.markWarning("ADB not found")
			}
			
			// List connected devices
			process = Runtime.getRuntime().exec("adb devices")
			reader = new BufferedReader(new InputStreamReader(process.inputStream))
			List<String> devices = []
			String line
			
			while ((line = reader.readLine()) != null) {
				if (line.contains("device") && !line.startsWith("List")) {
					devices.add(line.trim())
				}
			}
			process.waitFor()
			
			if (devices.isEmpty()) {
				KeywordUtil.markWarning(" No devices connected")
			} else {
				KeywordUtil.logInfo("Connected devices: ${devices.size()}")
				devices.each { device ->
					KeywordUtil.logInfo("   - ${device}")
				}
			}
			
		} catch (Exception e) {
			KeywordUtil.markWarning("Environment check: ${e.message}")
		}
	}
}