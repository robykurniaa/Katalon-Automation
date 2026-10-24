package support

import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import groovy.json.JsonSlurper
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import io.appium.java_client.AppiumDriver
import org.openqa.selenium.WebDriver
import internal.GlobalVariable
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.testobject.ConditionType

public class LocatorUtil {

	public static String platform = ""

	/*
	 * Load all JSON files in /locators/ before execution
	 */
	static String loadLocators(String filename, String key) {
		// Construct the JSON file path
		def normalizedPath = filename.replace("\\", "/").trim()
		def jsonFilePath = RunConfiguration.getProjectDir() + "/Locators/${normalizedPath}.json"
		def jsonFile = new File(jsonFilePath)
		if(!jsonFile.exists()) {
			throw new Exception("File not found ${jsonFilePath}")
		}
		// Parse the JSON file
		def jsonSlurper = new JsonSlurper()
		def jsonText = jsonFile.text

		// Parse JSON content
		def jsonData = jsonSlurper.parseText(jsonText)
		def jsonObject = jsonData[key]

		// Detect platform once after loading
		if(platform.isEmpty()) {
			platform = detectPlatform()
		}

		def locatorPath = jsonObject[platform]
		println("selected locator path for ${platform} and i.e.: ${locatorPath}")

		locatorPath = autoTranslateXPath(locatorPath)

		return locatorPath
	}

	/*
	 * Detect Android, iOS or web platform
	 */
	static String detectPlatform() {
		if (platform?.trim()) {
			println "Platform already set: ${platform}"
			return platform
		}

		/**
		 * get platform from the global variable
		 */
		try {
			String platformType = GlobalVariable.platform
			if (platformType.toLowerCase() == 'android' || platformType.toLowerCase() == 'ios'|| platformType.toLowerCase() == 'Axisnet-Android') {
				platform = platformType
				println "Platform detected from mobile device: ${platform}"
				return platform
			}
		} catch (Exception ignored) {
			// not a mobile test
		}

		/**
		 * Local Mobile Detection
		 */
		try {
			String deviceOS = Mobile.getDeviceOS()?.toLowerCase()
			if (deviceOS == 'android' || deviceOS == 'ios') {
				platform = deviceOS
				println "Platform detected from mobile device: ${platform}"
				return platform
			}
		} catch (Exception ignored) {
			// not a mobile test
		}

		// Local Web Detection
		try {
			def webDriver = DriverFactory.getWebDriver()
			if (webDriver != null) {
				platform = "web"
				println "Platform detected from WebDriver: web"
				return "web"
			}
		} catch (Exception ignored) {}

		// Fallback
		platform = "web"
		println "Fallback to platform: web"
		return "web"
	}


	/*
	 * Fetch locator using key and platform
	 */
	static String getLocatorPath(String key) {
		if (!key.contains("/")) {
			throw new Exception("Incomplete locator path: '${key}'. Expected format: 'filename/locatorName'.")
		}

		int lastSlashIndex = key.lastIndexOf("/")
		String fileName = key.substring(0, lastSlashIndex).trim()
		String locatorName = key.substring(lastSlashIndex + 1).trim()

		if (!fileName || !locatorName) {
			throw new Exception("Invalid locator path: '${key}'. Filename or locator name is missing.")
		}
		return loadLocators(fileName, locatorName)
	}

	static TestObject getTestObjectFromJson(String key) {
		// 1. Ambil path string dari fungsi Anda sebelumnya
		String locatorString = getLocatorPath(key)

		// 2. Buat TestObject kosong dengan nama key
		TestObject dynamicObject = new TestObject(key)

		// 3. Masukkan locator ke dalam TestObject (Asumsi JSON Anda berisi XPath)
		dynamicObject.addProperty("xpath", ConditionType.EQUALS, locatorString, true)

		return dynamicObject
	}

	/*
	 * -------------------------------------------------------------
	 * METHOD BARU: Mengubah @text='Apapun' menjadi case-insensitive
	 * -------------------------------------------------------------
	 */
	static String autoTranslateXPath(String locator) {
		if (!locator || !locator.contains("@text")) return locator

		// 1. Handle exact match: @text='Value'
		String exactRegex = /@text=['"]([^'"]+)['"]/
		locator = locator.replaceAll(exactRegex) { fullMatch, textValue ->
			String lowerValue = textValue.toLowerCase()
			return "translate(@text, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz')='${lowerValue}'"
		}

		// 2. Handle contains match: contains(@text, 'Value')
		String containsRegex = /contains\(\s*@text\s*,\s*['"]([^'"]+)['"]\s*\)/
		locator = locator.replaceAll(containsRegex) { fullMatch, textValue ->
			String lowerValue = textValue.toLowerCase()
			return "contains(translate(@text, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), '${lowerValue}')"
		}

		println("Auto-translated XPath: " + locator)
		return locator
	}
	static String getDynamicXPath(String key, String replacementText) {
		String locatorString = getLocatorPath(key)

		String lowerReplacement = replacementText.toLowerCase()

		String dynamicLocator = locatorString
				// Jika belum kena translate (masih kapital)
				.replace("<PACKAGE_NAME>", replacementText)
				.replace("<TAB_NAME>", replacementText)
				.replace("<CATEGORY_NAME>", replacementText)
				// Jika sudah kena translate (huruf kecil)
				.replace("<package_name>", lowerReplacement)
				.replace("<tab_name>", lowerReplacement)
				.replace("<category_name>", lowerReplacement)

		println("Dynamic XPath created: " + dynamicLocator)
		return dynamicLocator
	}
}