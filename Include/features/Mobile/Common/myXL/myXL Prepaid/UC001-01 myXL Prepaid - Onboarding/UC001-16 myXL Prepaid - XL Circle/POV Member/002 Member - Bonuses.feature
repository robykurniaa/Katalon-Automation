Feature: XL Cirlce - Member Cannot Claim Bonus

Scenario: Validate on the member side cannot view and claim the bonus
	Given user opens myXL application
  When user perform login into the app with number "GlobalVariable.circleMemberB" and otp "GlobalVariable.validOTP"
  When user click on XL Circle Banner element "myXL Prepaid/dashboard/XL Circle Banner"
	And user "click" on the optional element "myXL Prepaid/XLCircle/Interstitial Page - Start XL Circle"
	When user click on next button element "myXL Prepaid/XLCircle/Landing - Coachmark Next Button"
	When user click on next button element "myXL Prepaid/XLCircle/Landing - Coachmark Next Button (2nd)"
	When user click on next button element "myXL Prepaid/XLCircle/Landing - Coachmark Next Button (2nd)"
	When user click on finish button element "myXL Prepaid/XLCircle/Landing - Coachmark Finish Button"
	When user click on the XL Circle Bonus element "myXL Prepaid/XLCircle/Landing - XL Circle Bonus" 
	Then user expect to see the back to xl circle button element "myXL Prepaid/XLCircle/Benefit for XL Circle - Back to XL Circle Button" 
	When user click on back to xl circle button element "myXL Prepaid/XLCircle/Benefit for XL Circle - Back to XL Circle Button"
	Then user expect to see the landing page element "myXL Prepaid/XLCircle/Landing - XL Circle Bonus" 
	