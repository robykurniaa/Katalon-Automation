package pages


import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject

import support.CommonUtils
import support.exceptions.TestActionException
import support.exceptions.*
import support.LocatorUtil
import axisnet_support.LocatorPaths as Locator
import com.kms.katalon.core.model.FailureHandling



class AxisIOUPage {
	/**
	 This method will tap the first available loan amount in order,
	 starting from the smallest (Loan 1000) to the largest (Loan 10000).
	 */
	public static void HandlingIouAmount() {
		// List of loan options, sorted from the lowest to the highest
		List<String> loanOptions = [
			Locator.LOAN_1000,
			Locator.LOAN_2000,
			Locator.LOAN_3000,
			Locator.LOAN_4000,
			Locator.LOAN_5000,
			Locator.LOAN_7000,
			Locator.LOAN_10000
		];

		boolean isTapped = false;
		int detectedIndex = -1;

		// Step one: let’s find the first loan amount that’s visible on the screen
		for (int i = 0; i < loanOptions.size(); i++) {
			if (CommonUtils.isElementExist(loanOptions[i])) {
				detectedIndex = i;
				println "First visible loan option: ${loanOptions[i]} (index ${i})";
				break;
			}
		}

		// If we found something
		if (detectedIndex != -1) {
			// Let’s look *above* that option to see if there’s a bigger one available too
			for (int j = detectedIndex + 1; j < loanOptions.size(); j++) {
				if (CommonUtils.isElementExist(loanOptions[j])) {
					println "Found a higher loan option: ${loanOptions[j]} — tapping it!";
					CommonUtils.tap(loanOptions[j]);
					isTapped = true;
					break;
				}
			}

			// If nothing bigger is found, just chill nothing to tap
			if (!isTapped) {
				println "Checked all options above, but no higher amount is visible.";
			}
		} else {
			// If we didn’t even find the first loan option
			println "no loan options are showing up on the screen.";
		}
	}


	static void handlingIouLandingPage() {
		int maxSwipe = 3;
		int swipeCount = 0;

		if (CommonUtils.isElementExist(Locator.SWIPE_KEY_LANDING_PAGE_IOU)) {
			while (swipeCount < maxSwipe && CommonUtils.isElementExist(Locator.SWIPE_KEY_LANDING_PAGE_IOU)) {
				CommonUtils.swipe(Locator.SWIPE_KEY_LANDING_PAGE_IOU, 'left');
				swipeCount++;
			}
		} else {
			// element’s not there from the start skip the whole thing
			println "IOU landing page element not found — no swipe needed.";
		}
	}
}
