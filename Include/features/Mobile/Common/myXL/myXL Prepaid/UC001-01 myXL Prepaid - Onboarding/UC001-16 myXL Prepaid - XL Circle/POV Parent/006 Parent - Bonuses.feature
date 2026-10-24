Feature: XL Circle - Parent Claim Bonus
	
Scenario: Validate claim Bonus Bersama
	Given user opens myXL application
  When user perform login into the app with number "6285943263025" and otp "GlobalVariable.validOTP"
  When user click on XL Circle Banner element "myXL Prepaid/dashboard/XL Circle Banner"
	And user "click" on the optional element "myXL Prepaid/XLCircle/Interstitial Page - Start XL Circle"
	When user click on Next Coachmark element "myXL Prepaid/XLCircle/Landing - Coachmark Next Button"
	When user click on Next Coachmark element "myXL Prepaid/XLCircle/Landing - Coachmark Next Button (2nd)"
	When user click on Next Coachmark element "myXL Prepaid/XLCircle/Landing - Coachmark Next Button (2nd)"
	When user click on Finish Coachmark element "myXL Prepaid/XLCircle/Landing - Coachmark Finish Button"
	When user click on XL Circle Bonus element "myXL Prepaid/XLCircle/Landing - XL Circle Bonus"
	Then user expect to see the Claim Reward element "myXL Prepaid/XLCircle/Benefit for XL Circle - Claim Reward"
	When user click on Claim Reward element "myXL Prepaid/XLCircle/Benefit for XL Circle - Claim Reward"
	Then user expect to see the PDP and Tnc element "myXL Prepaid/XLCircle/Bonus XL Circle - TnC"
	When user click on TnC element "myXL Prepaid/XLCircle/Bonus XL Circle - TnC"
	When user click on Close Half Card element "myXL Global Element/Half Card - Close Button"
	When user click on Take Now element "myXL Prepaid/XLCircle/Bonus XL Circle - Take Now Button"
	# Assume the Claim Bonus is Success
	When user wait for Back to Dashboard element "Purchase/Back to Dashboard Button" for 30 seconds to be present
	When user click on Back to Dashboard element "Purchase/Back to Dashboard Button"
		  
Scenario: Validate Bonus Bersama - If not have bonuses
	When user wait for XL Circle Banner element "myXL Prepaid/dashboard/XL Circle Banner" for 30 seconds to be present
	When user click on XL Circle Banner element "myXL Prepaid/dashboard/XL Circle Banner"
	And user "click" on the optional element "myXL Prepaid/XLCircle/Interstitial Page - Start XL Circle"
	When user click on Close Coachmark element "myXL Prepaid/XLCircle/Landing - Coachmark Close Button"
	When user click on XL Circle Bonus element "myXL Prepaid/XLCircle/Landing - XL Circle Bonus"
	# Assume Bonus has claimed
	Then user expect to see the Back to XL Circle button element "myXL Prepaid/XLCircle/Benefit for XL Circle - Back to XL Circle Button"
	
  