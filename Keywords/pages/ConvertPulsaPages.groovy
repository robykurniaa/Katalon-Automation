package pages

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import support.LocatorUtil
import com.kms.katalon.core.testobject.TestObject
import pages.DashboardPage
import support.CommonUtils
import axisnet_support.LocatorPaths as Locator

import internal.GlobalVariable

public class ConvertPulsaPages {

	static final String CONVERT_PULSA_INTRODUCTION = LocatorUtil.getLocatorPath("AXISNet/Convert Pulsa/First Time Introduction")
	static final String CONVERT_PULSA_BENEFIT = LocatorUtil.getLocatorPath("AXISNet/Convert Pulsa/Benefit Page")
	static final String BUTTON_LANJUTKAN = LocatorUtil.getLocatorPath("AXISNet/Convert Pulsa/Button Lanjutkan")
	static final String CONVERT_PULSA_INVALID_NUMBER = LocatorUtil.getLocatorPath("AXISNet/Convert Pulsa/Pop Up Invalid Msisdn")
	static final String BUTTON_KIRIM_KE_ORANG_LAIN = LocatorUtil.getLocatorPath("AXISNet/Convert Pulsa/Button Kirim Ke Orang Lain")
	static final String CONVERT_PULSA_MENU = LocatorUtil.getLocatorPath("AXISNet/Dashboard/Quick Menu - Convert Pulsa")

	@Keyword
	static void tapMenuConvertPulsa() {
		DashboardPage.handleAxisQuickMenu(CONVERT_PULSA_MENU)
	}

	@Keyword
	static void tapButtonLanjut() {
		'Check First Time Introduction'
		CommonUtils.handleOptionalElement(CONVERT_PULSA_INTRODUCTION, { CommonUtils.tap(Locator.BUTTON_LANJUT) }, 10)

		'Convert Pulsa'
		CommonUtils.handleOptionalElement(Locator.CONVERT_PULSA_BENEFIT, { CommonUtils.tap(Locator.BUTTON_LANJUTKAN) }, 10)

		'Tap Lanjut'
		CommonUtils.tap(Locator.BUTTON_LANJUT)
	}

	@Keyword
	static void tapButtonAktivasi() {
		'Tap Button Aktivasi'
		CommonUtils.tap(Locator.AKTIVASI_SEKARANG)
	}

	@Keyword
	static void checkSuccessReceipt() {
		CommonUtils.handleOptionalElement(
				Locator.RECEIPT_SUCCESS,{ CommonUtils.tap(Locator.BUTTON_KE_HOME)},10)
	}
}

