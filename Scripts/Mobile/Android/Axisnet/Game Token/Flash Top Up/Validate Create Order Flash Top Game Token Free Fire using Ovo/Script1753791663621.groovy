import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import axisnet_support.AppManagement as Login
import support.CommonUtils as CommonUtils
import axisnet_support.LocatorPaths as Locator
import pages.DashboardPage as DashboardPage
import pages.PurchaseJourney as PurchaseJourney

Login.startApplication('083827389321', 'ZXCV22')

'Tap Menu Hiburan'
CommonUtils.tap(Locator.HIBURAN_MENU)

'Select Game Top Up'
CommonUtils.tap(Locator.GAME_TOKEN_FF)

'Fill User Id'
CommonUtils.setText(Locator.GAME_TOKEN_USER_ID, '6710588672')

'Select Denom'
CommonUtils.tap(Locator.GAME_TOKEN_TOP_UP_1)

'Tap Lanjut'
CommonUtils.tap(Locator.BUTTON_LANJUT)

'Purchase Journey'
PurchaseJourney.purchaseGameTokenWithOVO()