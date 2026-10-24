Feature: XL Circle Parent Create Group, Claim Bonus, and Purchase

Scenario: Validate claim Bonus Bersama
	Given user opens myXL application
  When user perform login into the app with number "085964418385" and otp "GlobalVariable.validOTP"
  When user click on XL Circle Banner element "Android/myXL Prepaid/Dashboard/Family Hub Banner"
	And user "click" on the optional element "Android/myXL Prepaid/XL Circle/Interstitial Page - Start XL Circle"
	When user click on Next Coachmark element "Android/myXL Prepaid/XL Circle/Coachmark Landing - Next Button"
	When user click on Next Coachmark element "Android/myXL Prepaid/XL Circle/Coachmark Landing - Next Button"
	When user click on Next Coachmark element "Android/myXL Prepaid/XL Circle/Coachmark Landing - Next Button"
	When user click on Finish Coachmark element "Android/myXL Prepaid/XL Circle/Coachmark Landing - Finish Button"
	When user scrolls to "View Group Details"
	When user click on XL Circle Bonus element "Android/myXL Prepaid/XL Circle/POV Parent/Landing - XL Circle Bonus"
	Then user expect to see the Quota Tab element "Android/myXL Prepaid/XL Circle/POV Parent/Benefit XL Circle - Quota Tab"
	When user click on Quota Tab element "Android/myXL Prepaid/XL Circle/POV Parent/Benefit XL Circle - Quota Tab"
	When user swipes "left" on element "Android/myXL Prepaid/XL Circle/POV Parent/XL Circle Quota (2nd Quota)" 5 times
	