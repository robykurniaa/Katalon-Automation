import axisnet_support.AppManagement as Login
import support.CommonUtils as CommonUtils
import axisnet_support.LocatorPaths as Locator
import pages.DashboardPage as Dashboard
import pages.LimitedOfferSelectedCitiesPage as LimitedOffer
import pages.PurchaseJourney as PurchaseJourney

Login.startApplication('083866291412')

'Swipe Up'
Dashboard.swipeHandling()

'tap Mendadak Diskon'
CommonUtils.tap(Locator.LIMITED_OFFER_BUTTON)

'Validate Limited Offer'
LimitedOffer.handlingLO77CitiesPackage(2)

'Purchase Journey'
PurchaseJourney.purchaseWithDana()