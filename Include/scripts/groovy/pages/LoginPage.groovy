package pages

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

import support.CommonUtils
import support.exceptions.*
import support.LocatorUtil
import com.kms.katalon.core.model.FailureHandling

class LoginPage {
	// Object Repository paths
	private static final String LETS_START_BUTTON = LocatorUtil.getLocatorPath("myXL Global Element/login/Lets Start Button")
	private static final String LOGIN_BUTTON = LocatorUtil.getLocatorPath("myXL Global Element/login/Yes, Login to myXL button")
	private static final String AGREE_BUTTON = LocatorUtil.getLocatorPath("myXL Global Element/login/Agree Button - Half Card")
	private static final String PREPAID_BUTTON = LocatorUtil.getLocatorPath("myXL Global Element/login/XL Prepaid Segment Button")
	private static final String PRIORITAS_BUTTON = LocatorUtil.getLocatorPath("myXL Global Element/login/XL Prioritas Segment Button")
	private static final String SATUFM_BUTTON = LocatorUtil.getLocatorPath("myXL Global Element/login/XL SATU & First Media Segment Button")
	private static final String HOME_BUTTON = LocatorUtil.getLocatorPath("myXL Global Element/login/XL HOME Segment Button")
	private static final String GOIZI_BUTTON = LocatorUtil.getLocatorPath("myXL Global Element/login/XL GO IZI Segment Button")
	private static final String ENTERPRISE_BUTTON = LocatorUtil.getLocatorPath("myXL Global Element/login/XL Enterprise Segment Button")
	private static final String MSISDN_INPUT = LocatorUtil.getLocatorPath("myXL Global Element/login/Field Input MSISDN")
	private static final String CONTINUE_BUTTON = LocatorUtil.getLocatorPath("myXL Global Element/login/Continue Button")
	private static final String OTP_INPUT = LocatorUtil.getLocatorPath("myXL Global Element/login/Field Input OTP")

	// AXISNet Object Repository paths
	private static final String AXIS_LETS_START_BUTTON = LocatorUtil.getLocatorPath("AXISNet/Login Page/Lets Start Button")
	private static final String AXIS_AGREE_PERMISSION_BUTTON = LocatorUtil.getLocatorPath("AXISNet/Login Page/Agree Button")
	private static final String MSISDN_FIELD = LocatorUtil.getLocatorPath("AXISNet/Login Page/MSISDN Field")
	private static final String AXIS_LOGIN_BUTTON = LocatorUtil.getLocatorPath("AXISNet/Login Page/Login Button")
	private static final String OTP_FIELD = LocatorUtil.getLocatorPath("AXISNet/Login Page/OTP Field")
	private static final String AXIS_CONTINUE_BUTTON = LocatorUtil.getLocatorPath("AXISNet/Login Page/Continue Button")

	public static void performLogin(String msisdn, String otp) {
		try {
			CommonUtils.handleOptionalElement(LETS_START_BUTTON, { -> CommonUtils.tap(LETS_START_BUTTON) }, 15)
			CommonUtils.tap(LOGIN_BUTTON)
			CommonUtils.tap(AGREE_BUTTON)

			CommonUtils.tap(PREPAID_BUTTON)
			CommonUtils.setText(MSISDN_INPUT, msisdn)
			CommonUtils.tap(CONTINUE_BUTTON)

			CommonUtils.waitForElement(OTP_INPUT, 30, FailureHandling.STOP_ON_FAILURE)

			CommonUtils.setText(OTP_INPUT, otp, 30)
		} catch (TestActionException e) {
			throw new TestActionException("Login process failed", e)
		}
	}

	public static void performLoginMyXL(String segment, String msisdn, String otp) {
		try{
			CommonUtils.handleOptionalElement(LETS_START_BUTTON, { -> CommonUtils.tap(LETS_START_BUTTON) }, 15)
			CommonUtils.tap(LOGIN_BUTTON)
			CommonUtils.tap(AGREE_BUTTON)

			if(segment.equalsIgnoreCase("prepaid")){
				CommonUtils.tap(PREPAID_BUTTON)
			} else if(segment.equalsIgnoreCase("prioritas")){
				CommonUtils.tap(PRIORITAS_BUTTON)
			} else if(segment.equalsIgnoreCase("go izi")){
				CommonUtils.tap(GOIZI_BUTTON)
			} else {
				throw new IllegalArgumentException("Unknown Segment: " + segment);
			}

			CommonUtils.setText(MSISDN_INPUT, msisdn);
			CommonUtils.tap(CONTINUE_BUTTON);

			CommonUtils.waitForElement(OTP_INPUT, 30);
			CommonUtils.setText(OTP_INPUT, otp, 30);
		} catch (TestActionException e) {
			throw new TestActionException("Login process failed", e);
		}
	}

	public static void performLoginAccountType(String segment, String accType, String msisdn, String otp) {
		try{
			CommonUtils.handleOptionalElement(LETS_START_BUTTON, { -> CommonUtils.tap(LETS_START_BUTTON) }, 15)
			CommonUtils.tap(LOGIN_BUTTON)
			CommonUtils.tap(AGREE_BUTTON)

			if(segment.equalsIgnoreCase("satu first media")){
				CommonUtils.tap(SATUFM_BUTTON)
				if(accType.equalsIgnoreCase("satu fiber")){
					CommonUtils.tap()
				} else if(accType.equalsIgnoreCase("satu lite")){
					CommonUtils.tap()
				}
			} else if(segment.equalsIgnoreCase("home")){
				CommonUtils.tap(PRIORITAS_BUTTON)
			} else if(segment.equalsIgnoreCase("enterprise")){
				CommonUtils.tap(GOIZI_BUTTON)
			} else {
				throw new IllegalArgumentException("Unknown Segment: " + segment);
			}

			CommonUtils.setText(MSISDN_INPUT, msisdn);
			CommonUtils.tap(CONTINUE_BUTTON);

			CommonUtils.waitForElement(OTP_INPUT, 30);
			CommonUtils.setText(OTP_INPUT, otp, 30);
		} catch (TestActionException e) {
			throw new TestActionException("Login process failed", e);
		}
	}

	public static void performLoginSATUFM(String msisdn, String otp) {
		try {
			CommonUtils.handleOptionalElement(LETS_START_BUTTON, { -> CommonUtils.tap(LETS_START_BUTTON) }, 15)
			CommonUtils.tap(LOGIN_BUTTON)
			CommonUtils.tap(AGREE_BUTTON)
			CommonUtils.tap(PREPAID_BUTTON)
			CommonUtils.setText(MSISDN_INPUT, msisdn)
			CommonUtils.tap(CONTINUE_BUTTON)

			CommonUtils.waitForElement(OTP_INPUT, 30)

			CommonUtils.setText(OTP_INPUT, otp, 30)
		} catch (TestActionException e) {
			throw new TestActionException("Login process failed", e)
		}
	}

	public static void performLoginGOIZI(String msisdn, String otp) {
		try {
			CommonUtils.handleOptionalElement(LETS_START_BUTTON, { -> CommonUtils.tap(LETS_START_BUTTON) }, 15)
			CommonUtils.tap(LOGIN_BUTTON)
			CommonUtils.tap(AGREE_BUTTON)
			CommonUtils.tap(GOIZI_BUTTON)
			CommonUtils.setText(MSISDN_INPUT, msisdn)
			CommonUtils.tap(CONTINUE_BUTTON)

			CommonUtils.waitForElement(OTP_INPUT, 30)

			CommonUtils.setText(OTP_INPUT, otp, 30)
		} catch (TestActionException e) {
			throw new TestActionException("Login process failed", e)
		}
	}

	public static void performLoginEnterprise(String msisdn, String otp) {
		try {
			CommonUtils.handleOptionalElement(LETS_START_BUTTON, { -> CommonUtils.tap(LETS_START_BUTTON) }, 15)
			CommonUtils.tap(LOGIN_BUTTON)
			CommonUtils.tap(AGREE_BUTTON)
			CommonUtils.tap(ENTERPRISE_BUTTON)
			CommonUtils.setText(MSISDN_INPUT, msisdn)
			CommonUtils.tap(CONTINUE_BUTTON)

			CommonUtils.waitForElement(OTP_INPUT, 30)

			CommonUtils.setText(OTP_INPUT, otp, 30)
		} catch (TestActionException e) {
			throw new TestActionException("Login process failed", e)
		}
	}

	public static void performLoginAxisnet(String msisdn, String otp) {
		try {
			CommonUtils.handleOptionalElement(AXIS_LETS_START_BUTTON, { -> CommonUtils.tap(AXIS_LETS_START_BUTTON) }, 15)
			CommonUtils.handleOptionalElement(AXIS_AGREE_PERMISSION_BUTTON, { -> CommonUtils.tap(AXIS_AGREE_PERMISSION_BUTTON) }, 5)

			CommonUtils.setText(MSISDN_FIELD, msisdn)
			CommonUtils.tap(AXIS_LOGIN_BUTTON)

			CommonUtils.waitForElement(OTP_FIELD, 30)
			CommonUtils.setText(OTP_FIELD, otp, 30)

			CommonUtils.handleOptionalElement(AXIS_CONTINUE_BUTTON, { -> CommonUtils.tap(AXIS_CONTINUE_BUTTON) }, 5)
		} catch (TestActionException e) {
			throw new TestActionException("Login process failed", e)
		}
	}

}