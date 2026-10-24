package support

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable
import support.exceptions.*
import support.LocatorUtil
import support.CommonUtils
import support.MobileUtils
import axisnet_support.AppManagement as Login
import axisnet_support.PermissionHandling as Permission

class BaseTest {
	/**
	 * Sets up the test environment before executing a test.
	 * @param enableScreenshots Whether to enable screenshot capturing.
	 */

	static void setUp(boolean enableScreenshots = true) {
		CommonUtils.takeScreenshots = enableScreenshots

		def deviceType = LocatorUtil.detectPlatform();
		println ("Device is ${deviceType}")

		switch (deviceType) {
			case "Axisnet-Android":
				Login.openApplication()
				break
			case "Axisnet iOS":
				Mobile.startApplication('app path', true)
				break
			case "ios":
				Mobile.startApplication(GlobalVariable.IPA, true)
				break
			case "web":
				WebUI.openBrowser(GlobalVariable.applicationURL)
				WebUI.maximizeWindow()
				break
			default:
				throw new Exception("Unsupported platform: '${deviceType}'. Supported values are: android, ios, web.")
		}
	}


	/**
	 * Cleans up the test environment after executing a test.
	 */

	static void tearDown() {
		try {
			def deviceType = LocatorUtil.detectPlatform();

			switch (deviceType) {
				case ["android", "ios"]:
					Mobile.closeApplication()
					break

				case "web":
					WebUI.closeBrowser()
					break

				default:
					throw new Exception("Unsupported platform: '${deviceType}'. Supported values are: android, ios, web.")
			}
		} catch (Exception e) {
			println "Warning: Failed to close application: ${e.message}"
		}
	}
}
