import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

import axisnet_support.AppManagement as Login
import support.CommonUtils
import axisnet_support.LocatorPaths as Locator
import pages.DashboardPage
import pages.PurchaseJourney

Login.startApplication('083827388378', 'DT2022')

'Tap Quick Menu Convert Pulsa'
DashboardPage.handleAxisQuickMenu(Locator.CONVERT_PULSA_MENU)

'Check First Time Introduction'
CommonUtils.handleOptionalElement(Locator.CONVERT_PULSA_INTRODUCTION, { CommonUtils.tap(Locator.BUTTON_LANJUT) }, 10)

'Convert Pulsa'
CommonUtils.handleOptionalElement(Locator.CONVERT_PULSA_BENEFIT, { CommonUtils.tap(Locator.BUTTON_LANJUTKAN) }, 10)

'Gift Convert Pulsa'
CommonUtils.tap(Locator.GIFTING_BUTTON)

'Choose Destination Number'
CommonUtils.setText(Locator.MSISDN_FIELD, '085713519994')

'Tap Lanjut'
CommonUtils.swipe(Locator.MSISDN_FIELD, "up")
CommonUtils.tap(Locator.BUTTON_LANJUT)

'Check Pop Up'
CommonUtils.handleOptionalElement(
Locator.CONVERT_PULSA_INVALID_NUMBER,{ CommonUtils.tap(Locator.BUTTON_KIRIM_KE_ORANG_LAIN)},10)
