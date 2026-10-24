Feature: XL Circle - Parent A Group created and Member Accept/Reject Invitation

@before_memB_leave
Scenario: Validate Lihat Details Group is display correctly
	Given user opens myXL application
  When user perform login into the app with number "GlobalVariable.circleParentA" and otp "GlobalVariable.validOTP"
  When user click on XL Circle Banner element "myXL Prepaid/dashboard/XL Circle Banner"
	And user "click" on the optional element "myXL Prepaid/XLCircle/Interstitial Page - Start XL Circle"
	When user click on Next Coachmark element "myXL Prepaid/XLCircle/Landing - Coachmark Next Button"
	When user click on Next Coachmark element "myXL Prepaid/XLCircle/Landing - Coachmark Next Button (2nd)"
	When user click on Next Coachmark element "myXL Prepaid/XLCircle/Landing - Coachmark Next Button (2nd)"
	When user click on Finish Coachmark element "myXL Prepaid/XLCircle/Landing - Coachmark Finish Button"
	When user scrolls to "myCircle"
	When user click on the View Group Details element "myXL Prepaid/XLCircle/Parent Landing - View Group Details"
	Then user expect to see the Edit Group Name element "myXL Prepaid/XLCircle/Create Group - Group Settings - Edit Button"
	# Assume the group has added 3 members, so the total should be 4/5 including the Organizer
	Then user expect to see the Total Member element "myXL Prepaid/XLCircle/Parent Group Settings - Total Member (4 of 5)"
	Then user expect to see the Remove Member 1 element "myXL Prepaid/XLCircle/Parent Group Settings - Remove Member 1"
	Then user expect to see the Remove Member 2 element "myXL Prepaid/XLCircle/Parent Group Settings - Remove Member 2"
	Then user expect to see the Remove Member 3 element "myXL Prepaid/XLCircle/Parent Group Settings - Remove Member 3"
	Then user expect to see the Add Member 4 element "myXL Prepaid/XLCircle/Create Group - Member - Add Member 4"
	Then user expect to see the Disband Group element "myXL Prepaid/XLCircle/Parent Group Settings - Disband Group Button"

@before_memB_leave	
Scenario: Validate remove member if have >1 member
	When user click on the Remove Member 1 element "myXL Prepaid/XLCircle/Parent Group Settings - Remove Member 1"
	Then user expect to see the half card element "myXL Prepaid/XLCircle/Parent Group Settings - Remove Member Half Card"
	Then user click on the Yes, I'm Sure element "myXL Prepaid/XLCircle/Group Settings - Quit-Disband - Yes I'm Sure Button"
	Then user expect to see the Success Remove page element "myXL Prepaid/XLCircle/Quit-Disband - Success Page - View XL Circle Button"
	When user click on the View XL Circle element "myXL Prepaid/XLCircle/Quit-Disband - Success Page - View XL Circle Button"
	Then user expect to see the Add member 3 available element "myXL Prepaid/XLCircle/Landing - Freeze Member 1"

@after_memB_leave
Scenario: Validate remove member if have < 1 member
	Given user opens myXL application
  When user perform login into the app with number "GlobalVariable.circleParentA" and otp "GlobalVariable.validOTP"
  When user click on XL Circle Banner element "myXL Prepaid/dashboard/XL Circle Banner"
	And user "click" on the optional element "myXL Prepaid/XLCircle/Interstitial Page - Start XL Circle"
	And user "click" on the optional element "myXL Prepaid/XLCircle/Landing - Coachmark Next Button"
	And user "click" on the optional element "myXL Prepaid/XLCircle/Landing - Coachmark Next Button (2nd)"
	And user "click" on the optional element "myXL Prepaid/XLCircle/Landing - Coachmark Next Button (2nd)"
	And user "click" on the optional element "myXL Prepaid/XLCircle/Landing - Coachmark Finish Button"
	When user scrolls to "myCircle"
	When user click on the View Group Details element "myXL Prepaid/XLCircle/Parent Landing - View Group Details"
	# Assume the group has only 1 member left, so the total should be 2/5 including the Organizer
	Then user expect to see the Total Member element "myXL Prepaid/XLCircle/Parent Group Settings - Total Member (4 of 5)"
	When user click on the Remove Member 3 element "myXL Prepaid/XLCircle/Parent Group Settings - Remove Member 3"
	Then user click on the Yes, I'm Sure element "myXL Prepaid/XLCircle/Group Settings - Quit-Disband - Yes I'm Sure Button"
	Then user expect to see the Success Remove page element "myXL Prepaid/XLCircle/Quit-Disband - Success Page - View XL Circle Button"
	When user click on the View XL Circle element "myXL Prepaid/XLCircle/Quit-Disband - Success Page - View XL Circle Button"
	Then user expect to see the Temporarily inactive ribbon element "Android/myXL Prepaid/XL Circle/Landing - Red Alert Inactive"
	