import axisnet_support.AppManagement as Login
import support.CommonUtils as CommonUtils
import axisnet_support.LocatorPaths as Locator
import pages.DashboardPage as Dashboard
import limitedOffers.LimitedOfferSelectedCitiesPage as LimitedOffer
import pages.PurchaseJourney as PurchaseJourney

Login.startApplication('6283147757888')

'Swipe Up'
Dashboard.swipeHandling()

'tap Mendadak Diskon'
CommonUtils.tap(Locator.LIMITED_OFFER_BUTTON)

'Validate Limited Offer'
LimitedOffer.handlingLO3CitiesPackage(3)

'Purchase Journey'
PurchaseJourney.purchaseWithShopeePay()