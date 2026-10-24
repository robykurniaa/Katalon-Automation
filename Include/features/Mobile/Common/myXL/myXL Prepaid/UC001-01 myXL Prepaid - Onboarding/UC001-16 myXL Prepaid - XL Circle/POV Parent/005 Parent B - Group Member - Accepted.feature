Feature: XL Circle - Parent B Create Group and Invite Member
 
Scenario: Validate change the group name - Input with special character
	Given user opens myXL application
  When user perform login into the app with number "GlobalVariable.circleParentB" and otp "GlobalVariable.validOTP"
  When user click on XL Circle Banner element "myXL Prepaid/dashboard/XL Circle Banner"
  And user "click" on the optional element "myXL Prepaid/XLCircle/Interstitial Page - Start XL Circle"
	When user click on Next Coachmark element "myXL Prepaid/XLCircle/Landing - Coachmark Next Button"
	When user click on Next Coachmark element "myXL Prepaid/XLCircle/Landing - Coachmark Next Button (2nd)"
	When user click on Next Coachmark element "myXL Prepaid/XLCircle/Landing - Coachmark Next Button (2nd)"
	When user click on Finish Coachmark element "myXL Prepaid/XLCircle/Landing - Coachmark Finish Button"
	When user scrolls to "myCircle2"
	When user click on the Group Details element "myXL Prepaid/XLCircle/Parent Landing - View Group Details"
	When user click on the Edit Group Name element "myXL Prepaid/XLCircle/Create Group - Group Settings - Edit Button"
	When user "clear text" on the optional element "myXL Prepaid/XLCircle/Create Group - Group Settings - Half Card Edit Name Field"
	When user enter New Group name on element "myXL Prepaid/XLCircle/Create Group - Group Settings - Half Card Edit Name Field" as "CircleMy%$@"
	When user click on Save element "myXL Prepaid/XLCircle/Create Group - Group Settings -  Save Edit Name Button"

Scenario: Validate change the group name
	When user enter New Group name on element "myXL Prepaid/XLCircle/Create Group - Group Settings - Half Card Edit Name Field" as "CircleMy2"
	When user click on Save element "myXL Prepaid/XLCircle/Create Group - Group Settings -  Save Edit Name Button"
	
Scenario: Validate delete the group family if have > 1 member
	When user click on the Group Details element "myXL Prepaid/XLCircle/Parent Landing - View Group Details"
	# Assume the group has added 3 members, so the total should be 4/5 including the Organizer
	Then user expect to see the Total Member element "myXL Prepaid/XLCircle/Parent Group Settings - Total Member (4 of 5)"
	Then user expect to see the Remove Member 1 element "myXL Prepaid/XLCircle/Parent Group Settings - Remove Member 1"
	Then user expect to see the Remove Member 2 element "myXL Prepaid/XLCircle/Parent Group Settings - Remove Member 2"
	Then user expect to see the Add Member 3 element "myXL Prepaid/XLCircle/Create Group - Member - Add Member 3"
	Then user expect to see the Add Member 4 element "myXL Prepaid/XLCircle/Create Group - Member - Add Member 4"
	Then user expect to see the Disband Group element "myXL Prepaid/XLCircle/Parent Group Settings - Disband Group Button"
	When user click on the Disband Group element "myXL Prepaid/XLCircle/Parent Group Settings - Disband Group Button"
	Then user click on the Yes, I'm Sure element "myXL Prepaid/XLCircle/Group Settings - Quit-Disband - Yes I'm Sure Button"
	Then user expect to see the Success Remove page element "myXL Prepaid/XLCircle/Quit-Disband - Success Page - View XL Circle Button"
	When user click on the View XL Circle element "myXL Prepaid/XLCircle/Quit-Disband - Success Page - View XL Circle Button"

Scenario: Validate if group is deleted then XL family will be frezee until 1 month
	Then user expect to see the Temporarily inactive ribbon element "myXL Prepaid/XLCircle/Landing - Temporarily Inactive Red Alert"
	Then user expect the element "myXL Prepaid/XLCircle/Landing - Create Group Now Button" to not exist

