import axisnet_support.AppManagement as Login
import support.CommonUtils as CommonUtils
import axisnet_support.LocatorPaths as Locator
import pages.DashboardPage as Dashboard
import pages.LimitedOfferSelectedCitiesPage as LimitedOffer
import pages.PurchaseJourney as PurchaseJourney
import internal.GlobalVariable

Login.startApplication(GlobalVariable.LO16DeliSerdang)

'Swipe Up'
Dashboard.swipeHandling()

'tap Mendadak Diskon'
CommonUtils.tap(Locator.LIMITED_OFFER_BUTTON)

'Validate Limited Offer'
LimitedOffer.handlingLO16CitiesPackage()

'Purchase Journey'
PurchaseJourney.successPurchaseWithShopeePay()