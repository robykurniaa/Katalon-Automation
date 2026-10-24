package pages

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.testobject.TestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import support.CommonUtils
import support.exceptions.TestActionException
import support.exceptions.*
import support.LocatorUtil

class DashboardPage {


	// AXISNet Object Repository paths
	private static final String AXIS_BALANCE_CARD = LocatorUtil.getLocatorPath("AXISNet/Dashboard/Success Login")
	private static final String AXIS_TNC_PAGE = LocatorUtil.getLocatorPath("AXISNet/Dashboard/TNC Page")
	private static final String AXIS_TNC_PAGE_BUTTON = LocatorUtil.getLocatorPath("AXISNet/Dashboard/TNC Button")
	private static final String QUICK_MENU_AREA_KEY = LocatorUtil.getLocatorPath("AXISNet/Dashboard/Quick Menu - Swipe")

	public static void handleAxisQuickMenu(String menuObject) {
		// Default menuType = "quick menu"
		handleAxisQuickMenu(menuObject, "quick menu")
	}

	public static void handleAxisQuickMenu(String menuObject, String menuType) {
		if (menuType.equalsIgnoreCase("bottom navigation menu")) {
			println "Bottom navigation menu: tap langsung pada ${menuObject}"
			CommonUtils.tap(menuObject)
			return
		}

		// Proses untuk quick menu
		if (CommonUtils.isElementExist(menuObject, 3)) {
			println "${menuType} ditemukan: ${menuObject}"
			CommonUtils.tap(menuObject)
			return
		}

		if (menuType.equalsIgnoreCase("quick menu")) {
			println "Quick menu not found. Swipe left to search..."

			int maxSwipes = 7
			boolean found = false

			for (int i = 0; i < maxSwipes; i++) {
				CommonUtils.swipe(QUICK_MENU_AREA_KEY, "left", 3)
				if (CommonUtils.isElementExist(menuObject, 3)) {
					println "Menu ditemukan setelah swipe ke-${i + 1}"
					CommonUtils.tap(menuObject)
					found = true
					break
				}
			}

			if (!found) {
				println "Quick menu not found after ${maxSwipes} times swipe."
			}
		} else {
			println "${menuType} not found and no swipe required."
		}
	}



	public static void verifyAxisDashboardLoaded() {
		CommonUtils.waitForElement(AXIS_BALANCE_CARD, 30)
	}

	public static void acceptTnCIfVisible() {
		CommonUtils.handleOptionalElement(AXIS_TNC_PAGE,5 { -> CommonUtils.tap(AXIS_TNC_PAGE_BUTTON) },5)
	}
	
	public static void swipeHandling() {
		
				// Find the element for which want to get the attributes
				TestObject testObject = findTestObject('Object Repository/Mobile/Android/AXISNet New Object/Limited Offer/Scroll Up Limited Offer')
				// Get element attributes
				String x = Mobile.getAttribute(testObject, 'x', 10)
				String y = Mobile.getAttribute(testObject, 'y', 10)
				// Convert attribute to integer
				int startX = Integer.parseInt(x)
				int startY = Integer.parseInt(y)
				// Determine the final coordinates for the swipe
				int endX = startX
				// Stay on the same y line
				int endY = startY - 400 // For example, shift 400 pixels down
		
				Mobile.swipe(startX, startY, endX, endY)
			}
}
