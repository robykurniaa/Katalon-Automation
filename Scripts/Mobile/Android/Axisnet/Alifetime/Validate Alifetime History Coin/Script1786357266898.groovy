import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

import axisnet_support.AppManagement as Login
import support.BaseTest
import support.CommonUtils
import support.LocatorUtil
import axisnet_support.LocatorPaths as Locator
import axisnet_support.DeeplinkConstants as Deeplink

Login.startApplication('083110568390')

'Tap Alifetime Menu'
CommonUtils.openDeepLink(Deeplink.SCHEME_MAP["PROFILE"])