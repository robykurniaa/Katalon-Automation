package axisnet_support

import groovy.json.JsonSlurper
import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.testobject.ConditionType
import support.CommonUtils
import axisnet_support.LocatorPaths
import axisnet_support.LocatorPaths as Locator

public class PackageHandler {

	static Map getPackageData(String category, String tabName, String packageId) {
		def jsonFilePath = RunConfiguration.getProjectDir() + "/Locators/AXISNet/AxisnetPackagesPool.json"
		def jsonFile = new File(jsonFilePath)
		
		if(!jsonFile.exists()) {
			throw new Exception("Data Pool file not found at: ${jsonFilePath}")
		}
		
		def jsonSlurper = new JsonSlurper()
		def jsonData = jsonSlurper.parseText(jsonFile.text)
		
		try {
			def packageMap = jsonData[category][tabName][packageId]
			if (packageMap == null) {
				throw new Exception("Package data is null")
			}
			return packageMap
		} catch (Exception e) {
			throw new Exception("Failed to retrieve package data for [${category} -> ${tabName} -> ${packageId}]")
		}
	}

	static void selectAndValidatePackage(Map testData) {
		String pkgName = testData.packageName
		int expectedPrice = testData.expectedPrice
		
		KeywordUtil.logInfo("ACTION 3: Found Package '${pkgName}' with expected price: Rp${expectedPrice} (Scroll Vertikal)")
		
		String cardLocator = LocatorPaths.dynamicPackageCard(pkgName)
		TestObject cardObj = new TestObject("Card_${pkgName}")
		cardObj.addProperty("xpath", ConditionType.EQUALS, cardLocator)
		
		// ------------------------------------------------------------------
		// CUSTOM SCROLL VERTIKAL UNTUK MENCARI NAMA PAKET
		// ------------------------------------------------------------------
		boolean isPkgFound = false
		for(int i = 0; i < 5; i++) {
			if(Mobile.verifyElementVisible(cardObj, 2, FailureHandling.OPTIONAL)) {
				isPkgFound = true
				break
			}
			int deviceHeight = Mobile.getDeviceHeight()
			int deviceWidth = Mobile.getDeviceWidth()
			int startX = deviceWidth / 2
			int startY = (int) (deviceHeight * 0.7) // Mulai swipe dari 70% layar bawah
			int endY = (int) (deviceHeight * 0.3)   // Tarik ke 30% layar atas
			
			Mobile.swipe(startX, startY, startX, endY)
		}
		
		if(!isPkgFound) KeywordUtil.markFailedAndStop("Gagal! Paket '${pkgName}' tidak ditemukan meski sudah di-scroll.")
		// ------------------------------------------------------------------

		// Validasi dan Tap Paket
		String priceLocator = LocatorPaths.dynamicPackagePrice(pkgName)
		int actualPrice = CommonUtils.getNumericFromElement(priceLocator)
		
		Mobile.verifyEqual(actualPrice.toString(), expectedPrice.toString(), FailureHandling.STOP_ON_FAILURE)
		KeywordUtil.logInfo("Harga sesuai: Rp${actualPrice}")
		Mobile.tap(cardObj, 3, FailureHandling.STOP_ON_FAILURE)
	}

	@Keyword
	static void processPackageSelection(String category, String tabName, String packageId) {
		Map data = getPackageData(category, tabName, packageId) 
		
		// ==========================================
		// ACTION 1: KATEGORI UTAMA 
		// ==========================================
		KeywordUtil.logInfo("ACTION 1: Menuju kategori utama -> ${category}")
		String categoryLocator = LocatorPaths.dynamicMainCategory(category)
		TestObject categoryObj = new TestObject("Cat_${category}")
		categoryObj.addProperty("xpath", ConditionType.EQUALS, categoryLocator)
		
		if(Mobile.verifyElementVisible(categoryObj, 3, FailureHandling.OPTIONAL)) {
			Mobile.tap(categoryObj, 3, FailureHandling.OPTIONAL)
			Mobile.delay(1)
		}
		
		// ==========================================
		// ACTION 2: TAB SUB-KATEGORI (DENGAN SCROLL HORIZONTAL)
		// ==========================================
		KeywordUtil.logInfo("ACTION 2: Mencari tab -> ${tabName} (Scroll Horizontal)")
		String tabLocator = LocatorPaths.dynamicTabCategory(tabName)
		TestObject tabObj = new TestObject("Tab_${tabName}")
		tabObj.addProperty("xpath", ConditionType.EQUALS, tabLocator)
		
		boolean isTabFound = false
		for(int i = 0; i < 5; i++) {
			if(Mobile.verifyElementVisible(tabObj, 2, FailureHandling.OPTIONAL)) {
				isTabFound = true
				break
			}
			
			// Jika belum ketemu, swipe horizontal menggunakan ID Wadah (Container)
			KeywordUtil.logInfo("Tab belum terlihat, melakukan swipe horizontal ke kiri...")
			CommonUtils.swipe(Locator.PKG_TAB_CONTAINER, "left", 5)
		}
		
		if(isTabFound) {
			Mobile.tap(tabObj, 3, FailureHandling.STOP_ON_FAILURE)
			Mobile.delay(1) 
		} else {
			KeywordUtil.markFailedAndStop("Tab '${tabName}' gagal ditemukan di layar!")
		}
		
		// ==========================================
		// ACTION 3: CARI DAN TAP PAKET
		// ==========================================
		selectAndValidatePackage(data) 
	}
}