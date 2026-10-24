package setar_game_support

import support.CommonUtils
import support.LocatorUtil
import internal.GlobalVariable

public class SetarGameLocatorPaths {

	// ---- LOGIN ----
	static final String LOGIN_DESCRIPTION = "SetarGame/Login/Login - Description"
	static final String LOGIN_BUTTON = "SetarGame/Login/Login Button"
	static final String SET_NUMBER = "SetarGame/Login/Input Number"
	static final String SET_PASSWORD = "SetarGame/Login/Input Password"
	static final String CHECKBOX = "SetarGame/Login/CheckBox"
	static final String BUTTON_LANJUT = "SetarGame/Login/Button Lanjut"
	static final String INPUT_OTP = "SetarGame/Login/Input OTP"
	static final String TOAST_MSG = "SetarGame/Login/Toast Message"
	static final String FORM_LOGIN_TITLE = "SetarGame/Login/Form Login Title"

	// ---- DASHBOARD ----
	static final String SEARCH_BAR = "SetarGame/Dashboard/Search Bar"
	static final String MODE_BORONGAN = "SetarGame/Dashboard/Mode Borongan"
	static final String FREE_FIRE = "SetarGame/Dashboard/Free Fire"
	static final String UNIPIN = "SetarGame/Dashboard/UniPin"
	static final String G_PLAY = "SetarGame/Dashboard/Google Play"
	static final String ICON_USER_DASHBOARD = "SetarGame/Dashboard/Icon Dashboard"
	static final String MENU_LIST_NUMBER = "SetarGame/Dashboard/Menu List Number"
	static final String MENU_HISTORY = "SetarGame/Dashboard/Menu History"
	static final String BUTTON_KELUAR = "SetarGame/Dashboard/Button Keluar"
	static final String BUTTON_OPTION_NUMBER = "SetarGame/Dashboard/Button Option Number"
	static final String CHANGE_PIN = "SetarGame/Dashboard/Change Pin"
	static final String DELETE_NUMBER = "SetarGame/Dashboard/Delete Number"
	static final String ADD_PHONE_NUMBER = "SetarGame/Dashboard/Tambah Nomor Telepon"
	static final String BUTTON_YA = "SetarGame/Dashboard/Button Ya"

	// ---- ORDER ----
	static final String USER_ID = "SetarGame/Order/User Id"
	static final String FIRST_DENOM = "SetarGame/Order/First Denomination"
	static final String BUTTON_LANJUTKAN = "SetarGame/Order/Button Lanjutkan"
	static final String BUTTON_KONFIRMASI = "SetarGame/Order/Button Konfirmasi"
	static final String FIRST_DETAIL_TRANSAKSI = "SetarGame/Order/First Detail Transaksi"
	static final String BUTTON_BELI = "SetarGame/Order/Button Beli"
	static final String BUTTON_PLUS = "SetarGame/Order/Button Plus"
	static final String TOTAL_TRANSAKSI = "SetarGame/Order/Total Transaksi"
	static final String WARNING_INSUFF_BALANCE = "SetarGame/Order/Warning Insuff Balance"
	static final String INPUT_QUANTITY = "SetarGame/Order/Input Quantity"
	static final String DETAIL_PRICE = "SetarGame/Order/Detail Price"
	static final String ERROR_INVALID_PIN = "SetarGame/Order/Error Message Text"

	static final String GANTI_NOMOR = "SetarGame/Order/Ganti Nomor"
	static final String SECOND_NUMBER = "SetarGame/Order/Choose Second Number"
	static final String BUAT_PIN = "SetarGame/Order/Buat Pin"

	static final String INPUT_PIN = "SetarGame/Order/Input Pin"
	static final String INPUT_PIN_BASE = "SetarGame/Order/Input Pin"

	static final String CHECKLIST_ICON = "SetarGame/Order/Checklist Icon"
	static final String HEADER_DETAIL_ORDER = "SetarGame/Order/Header Detail Order"

	
	public static String getPinLocator(int index) {
		String rawXPath = LocatorUtil.getLocatorPath(INPUT_PIN_BASE)
		return String.format(rawXPath, index)
	}
}