import support.CommonUtils as CommonUtils
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import setar_game_support.SetarGameLocatorPaths as Locator
import setar_game_support.WebManagement as Login
import setar_game_support.PaymentUtils as Payment
import internal.GlobalVariable as GlobalVariable
import setar_game_support.PinHandler as Pin

'Login'
Login.startAtLoginPage()

CommonUtils.tap(Locator.LOGIN_BUTTON)

CommonUtils.setText(Locator.SET_NUMBER, '083110568297')

CommonUtils.setText(Locator.SET_PASSWORD, 'mantapDjiwa')

CommonUtils.check(Locator.CHECKBOX)

Login.handleManualRecaptcha()

CommonUtils.isElementExist(Locator.TOAST_MSG)