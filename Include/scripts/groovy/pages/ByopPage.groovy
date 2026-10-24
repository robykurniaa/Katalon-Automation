package pages

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.util.KeywordUtil

import support.CommonUtils
import support.exceptions.TestActionException
import support.exceptions.*
import support.LocatorUtil
import axisnet_support.LocatorPaths as Locator

import internal.GlobalVariable

public class ByopPage {

	public static void HandlingByopMccm() {
		// Flow: Select BYOP Validity with Ribbon "TERHEMAT"
		try {
			// List Option validity BYOP
			def validityOptions = [
				Locator.BYOP_VALIDITY_3D,
				Locator.BYOP_VALIDITY_7D,
				Locator.BYOP_VALIDITY_14D,
				Locator.BYOP_VALIDITY_28D
			]

			boolean ribbonFound = false

			for (def option : validityOptions) {
				// Scroll Up
				CommonUtils.scrollToText("Masa Aktif")

				// Tap validity option
				CommonUtils.tap(option)

				// Check if Ribbon Exist
				if (CommonUtils.isElementExist(Locator.RIBBON_TERHEMAT)) {
					CommonUtils.tap(Locator.RIBBON_TERHEMAT)
					KeywordUtil.logInfo("Ribbon TERHEMAT ditemukan pada opsi: ${option}")
					ribbonFound = true
					break
				}
			}

			if (!ribbonFound) {
				KeywordUtil.markWarning("Ribbon TERHEMAT not found from validity.")
			}
		} catch (Exception e) {
			KeywordUtil.markFailed("Flow BYOP Validity is failed: " + e.message)
		}
	}
}
