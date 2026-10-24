import axisnet_support.AppManagement as Login
import support.CommonUtils as CommonUtils
import axisnet_support.LocatorPaths as Locator
import pages.DashboardPage as Dashboard
import limitedOffers.LimitedOfferSelectedCitiesPage as LimitedOffer
import internal.GlobalVariable

Login.startApplication(GlobalVariable.LO16DeliSerdang)

'Swipe Up'
Dashboard.swipeHandling()

'tap Mendadak Diskon'
CommonUtils.tap(Locator.LIMITED_OFFER_BUTTON)

'Validate Limited Offer'
LimitedOffer.handleLOCities("LO72")