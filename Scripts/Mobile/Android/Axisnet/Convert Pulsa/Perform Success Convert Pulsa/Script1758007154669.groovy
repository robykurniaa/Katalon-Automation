import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

import axisnet_support.AppManagement as Login
import support.CommonUtils
import axisnet_support.LocatorPaths as Locator
import pages.DashboardPage
import pages.PurchaseJourney
import pages.ConvertPulsaPages as ConvertPulsa

Login.startApplication('083110568390')

'Tap Quick Menu Convert Pulsa'
ConvertPulsa.tapMenuConvertPulsa()

'Check First Time Introduction & Tap Button'
ConvertPulsa.tapButtonLanjut()

'Tap Button Aktivasi'
ConvertPulsa.tapButtonAktivasi()

'Check success Receipt'
ConvertPulsa.checkSuccessReceipt()