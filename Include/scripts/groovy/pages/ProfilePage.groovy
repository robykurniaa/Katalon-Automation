package pages

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import support.CommonUtils
import support.exceptions.*

class ProfilePage {
	private static final String PROFILE_MENU = 'Object Repository/myXL - Login And Logout/Profile Menu'
	private static final String ACCOUNT_INFO = 'Object Repository/myXL - Profile/Prepaid Profile Menu/Account Info/Account Information  Registration'
	private static final String EDIT_BUTTON = 'Object Repository/myXL - Profile/Edit - Account Info'
	private static final String NAME_INPUT = 'Object Repository/myXL - Profile/Account Info - Edit Info - Name Input'
	private static final String EMAIL_INPUT = 'Object Repository/myXL - Profile/Account Info - Edit Info - Email Input'
	private static final String SAVE_BUTTON = 'Object Repository/myXL - Profile/Save Button - Edit Information'

	public static void updateAccountInfo(String name, String email) {
		CommonUtils.tap(EDIT_BUTTON)
		CommonUtils.setText(NAME_INPUT, name)
		CommonUtils.setText(EMAIL_INPUT, email)
		CommonUtils.tap(SAVE_BUTTON)
		CommonUtils.waitForElement(EDIT_BUTTON)
	}

	public static void navigateToAccountInfo() {
		CommonUtils.tap(PROFILE_MENU)
		CommonUtils.tap(ACCOUNT_INFO)
	}
}
