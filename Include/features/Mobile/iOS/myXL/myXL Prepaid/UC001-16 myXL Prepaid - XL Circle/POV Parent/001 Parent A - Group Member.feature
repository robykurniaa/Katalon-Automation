# The test case below only works for iOS

Feature: XL Circle - Parent A Create Group and Invite Member

@ios_run_1
Scenario: 03. Validate click back after parent on the screen XL family
	Given user opens myXL application
  When user perform login into the app with number "GlobalVariable.circleParentA" and otp "GlobalVariable.validOTP"
  When user click on XL Circle Banner element "myXL Prepaid/dashboard/XL Circle Banner"
	And user "click" on the optional element "myXL Prepaid/XLCircle/Interstitial Page - Start XL Circle"
	When user "click" on the optional element "myXL Prepaid/XLCircle/Landing - Coachmark Close Button"
  When user click on Create Group Now element "myXL Prepaid/XLCircle/Landing - Create Group Now Button"
  When user enter Group Name on element "myXL Prepaid/XLCircle/Create Group - Group Name Field" as "myCircle"
  When user enter Organizer Name on element "myXL Prepaid/XLCircle/Create Group - Organizer Name Field" as "ParentA"
  When user click on Continue button element "myXL Prepaid/XLCircle/Create Group - Continue Button"
  Then user expect to see the Group Settings element "myXL Prepaid/XLCircle/Create Group - Group Settings - Edit Button"
	When user wait for Add Member row 1 element "myXL Prepaid/XLCircle/Create Group - Member - Add Member 1" for 5 seconds to be clickable
	When user click on Add Member icon row 1 element "myXL Prepaid/XLCircle/Create Group - Member - Add Member 1"
  When user enter Member MSISDN on element "myXL Prepaid/XLCircle/Add Member - Member Information - Input Member Number Field" as "GlobalVariable.circleMemberA"
  When user enter Member Name on element "myXL Prepaid/XLCircle/Add Member - Member Information - Input Member Name Field" as "MemberA"
  When user click on Continue button element "myXL Prepaid/XLCircle/Create Group - Continue Button"
  # Line 21 has temporarily hidden (Bug on iOS ==> Need fixing)
  # Then user expect to see the pending member element "myXL Prepaid/XLCircle/Create Group - Member - Pending Member 1"
	When user click on Back button element "myXL Global Element/navigation/Back Button"
	Then user expect to see the XL Circle Landing Page Empty element "myXL Prepaid/XLCircle/Landing - Create Group Now Button"  