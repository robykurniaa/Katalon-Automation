import axisnet_support.AppManagement as Login
import support.CommonUtils as CommonUtils
import axisnet_support.LocatorPaths as Locator
import pages.DashboardPage as Dashboard
import pages.LimitedOfferNationalPage as LONas
import pages.PurchaseJourney as PurchaseJourney

Login.startApplication('08327388378')

'Swipe Up'
Dashboard.swipeHandling()

'tap Mendadak Diskon'
CommonUtils.tap(Locator.LIMITED_OFFER_BUTTON)

'Validate Limited Offer'
LONas.handlingLoNasPackage(2)

'Purchase Journey'
PurchaseJourney.purchaseWithGopay()