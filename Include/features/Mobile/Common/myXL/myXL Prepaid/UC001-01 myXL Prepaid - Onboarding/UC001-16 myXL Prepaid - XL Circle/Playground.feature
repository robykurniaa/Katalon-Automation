Feature: Test

#Scenario: Validate claim Bonus Bersama
#	Given user opens myXL application
  #When user perform login into the app with number "085964418385" and otp "GlobalVariable.validOTP"
  #When user click on XL Circle Banner element "Android/myXL Prepaid/Dashboard/Family Hub Banner"
#	And user "click" on the optional element "Android/myXL Prepaid/XL Circle/Interstitial Page - Start XL Circle"
#	When user click on Next Coachmark element "Android/myXL Prepaid/XL Circle/Coachmark Landing - Next Button"
#	When user click on Next Coachmark element "Android/myXL Prepaid/XL Circle/Coachmark Landing - Next Button"
#	When user click on Next Coachmark element "Android/myXL Prepaid/XL Circle/Coachmark Landing - Next Button"
#	When user click on Finish Coachmark element "Android/myXL Prepaid/XL Circle/Coachmark Landing - Finish Button"
#	When user scrolls to "View Group Details"
#	When user click on XL Circle Bonus element "Android/myXL Prepaid/XL Circle/POV Parent/Landing - XL Circle Bonus"
#	Then user expect to see the Quota Tab element "Android/myXL Prepaid/XL Circle/POV Parent/Benefit XL Circle - Quota Tab"
#	When user click on Quota Tab element "Android/myXL Prepaid/XL Circle/POV Parent/Benefit XL Circle - Quota Tab"
#	When user swipes "left" on element "Android/myXL Prepaid/XL Circle/POV Parent/XL Circle Quota (2nd Quota)" 5 times
#	

Scenario: test scroll to text on ios
	Given user opens myXL application
  When user perform login into the app with number "GlobalVariable.circleMemberB" and otp "GlobalVariable.validOTP"
  When user click on XL Circle Banner element "myXL Prepaid/dashboard/XL Circle Banner"
	And user "click" on the optional element "myXL Prepaid/XLCircle/Interstitial Page - Start XL Circle"
	When user click on next button element "myXL Prepaid/XLCircle/Landing - Coachmark Next Button"
	When user click on next button element "myXL Prepaid/XLCircle/Landing - Coachmark Next Button (2nd)"
	When user click on next button element "myXL Prepaid/XLCircle/Landing - Coachmark Next Button (2nd)"
	When user click on finish button element "myXL Prepaid/XLCircle/Landing - Coachmark Finish Button"
	When user scrolls to "myCircle"
	When user click on the View Group Details element "myXL Prepaid/XLCircle/Landing - View Group Details"
  Then user expect to see the Group Name element "myXL Prepaid/XLCircle/Group Settings - Group Name"
	Then user expect to see the organizer element "myXL Prepaid/XLCircle/Group Settings - Member - Organizer Label" 
	Then user expect to see the Quit Group element "myXL Prepaid/XLCircle/Group Settings - Quit Group Button"
	
	