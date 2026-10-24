import support.CommonUtils

import setar_game_support.SetarGameLocatorPaths as Locator
import setar_game_support.WebManagement as Login

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

'Login'
Login.loginToDashboard("083110568390")

CommonUtils.setText(Locator.SEARCH_BAR, "Free Fire")
CommonUtils.setText(Locator.SEARCH_BAR, "Mobile Legends")
CommonUtils.setText(Locator.SEARCH_BAR, "Garena")
CommonUtils.setText(Locator.SEARCH_BAR, "Mario")


