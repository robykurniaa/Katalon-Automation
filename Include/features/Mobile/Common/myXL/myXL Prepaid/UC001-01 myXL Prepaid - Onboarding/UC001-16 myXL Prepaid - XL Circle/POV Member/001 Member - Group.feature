Feature: XL Circle Landing Page (Member POV)

@memberA
Scenario: 01 Validate if member not accept or reject the invitation the member still eligible to create new group
	Given user opens myXL application
  When user perform login into the app with number "GlobalVariable.circleMemberA" and otp "GlobalVariable.validOTP"
  When user click on XL Circle Banner element "myXL Prepaid/dashboard/XL Circle Banner"
	And user "click" on the optional element "myXL Prepaid/XLCircle/Interstitial Page - Start XL Circle"
	And user "click" on the optional element "myXL Prepaid/XLCircle/Landing - Coachmark Next Button"
	And user "click" on the optional element "myXL Prepaid/XLCircle/Landing - Coachmark Finish Button"
  When user click on Check Invitation For You element "myXL Prepaid/XLCircle/Landing - Check Invitations for You"
  When user click on Skip element "myXL Prepaid/XLCircle/Check Invitations for You - Skip Button"
  Then user expect to see the Invitation (1) element "myXL Prepaid/XLCircle/Landing - Check Invitations for You"
  Then user expect to see the Create Group element "myXL Prepaid/XLCircle/Landing - Create Group Now Button"
  When user click on Create Group Now element "myXL Prepaid/XLCircle/Landing - Create Group Now Button"
  Then user expect to see the Group Settings element "myXL Prepaid/XLCircle/Create Group - Group Name Field"
  When user enter Group Name on element "myXL Prepaid/XLCircle/Create Group - Group Name Field" as "myCircleC"
  When user enter Organizer Name on element "myXL Prepaid/XLCircle/Create Group - Organizer Name Field" as "MemberC"
  When user click on Continue button element "myXL Prepaid/XLCircle/Create Group - Continue Button"
  Then user expect to see the Group Settings element "myXL Prepaid/XLCircle/Create Group - Group Settings - Edit Button"
  
@memberA  
Scenario: 02 Baseline - MemberA Accepts Invitation by App
  Given user opens myXL application
  When user perform login into the app with number "GlobalVariable.circleMemberA" and otp "GlobalVariable.validOTP"
  When user click on XL Circle Banner element "myXL Prepaid/dashboard/XL Circle Banner"
	And user "click" on the optional element "myXL Prepaid/XLCircle/Interstitial Page - Start XL Circle"
	And user "click" on the optional element "myXL Prepaid/XLCircle/Landing - Coachmark Next Button"
	And user "click" on the optional element "myXL Prepaid/XLCircle/Landing - Coachmark Finish Button"
	Then user expect to see the Create Group Now element "myXL Prepaid/XLCircle/Landing - Create Group Now Button"
  Then user expect to see the Check Invitation For You element "myXL Prepaid/XLCircle/Landing - Check Invitations for You"
  When user click on Check Invitation For You element "myXL Prepaid/XLCircle/Landing - Check Invitations for You"
  Then user expect to see the Join XL Circle button element "myXL Prepaid/XLCircle/Check Invitations for You - Join XL Circle Button"
  When user click on Join XL Circle button element "myXL Prepaid/XLCircle/Check Invitations for You - Join XL Circle Button"
  When user wait for Success Join Page element "myXL Prepaid/XLCircle/Success Join - View XL Circle Button" for 10 seconds to be clickable
  When user click on View XL Circle element "myXL Prepaid/XLCircle/Success Join - View XL Circle Button"
	When user click on next button element "myXL Prepaid/XLCircle/Landing - Coachmark Next Button"
	When user click on next button element "myXL Prepaid/XLCircle/Landing - Coachmark Next Button (2nd)"
	When user click on next button element "myXL Prepaid/XLCircle/Landing - Coachmark Next Button (2nd)"
	When user click on finish button element "myXL Prepaid/XLCircle/Landing - Coachmark Finish Button"
	When user scrolls to "myCircle"

@memberA  
Scenario: 03 Validate Lihat Details Group is display correctly - POV Member
  When user click on the View Group Details element "myXL Prepaid/XLCircle/Landing - View Group Details"
  Then user expect to see the Group Name element "myXL Prepaid/XLCircle/Group Settings - Group Name"
	Then user expect to see the organizer element "myXL Prepaid/XLCircle/Group Settings - Member - Organizer Label" 
	Then user expect to see the Quit Group element "myXL Prepaid/XLCircle/Group Settings - Quit Group Button"

@memberB_leave
Scenario: 04 Validate Leave the group family
	Given user opens myXL application
  When user perform login into the app with number "GlobalVariable.circleMemberB" and otp "GlobalVariable.validOTP"
  When user click on XL Circle Banner element "myXL Prepaid/dashboard/XL Circle Banner"
	And user "click" on the optional element "myXL Prepaid/XLCircle/Interstitial Page - Start XL Circle"
	When user click on Next Coachmark element "myXL Prepaid/XLCircle/Landing - Coachmark Next Button"
  When user click on Next Coachmark element "myXL Prepaid/XLCircle/Landing - Coachmark Next Button (2nd)"
  When user click on Next Coachmark element "myXL Prepaid/XLCircle/Landing - Coachmark Next Button (2nd)"
  When user click on Finish Coachmark element "myXL Prepaid/XLCircle/Landing - Coachmark Finish Button"
  When user scrolls to "myCircle"
  When user click on the View Group Details element "myXL Prepaid/XLCircle/Landing - View Group Details"
  When user click on the Quit Group element "myXL Prepaid/XLCircle/Group Settings - Quit Group Button"
	When user click on the Review Again element "myXL Prepaid/XLCircle/Group Settings - Quit-Disband - Review Again Button"
	When user click on the Quit Group element "myXL Prepaid/XLCircle/Group Settings - Quit Group Button"
	When user click on the Yes I'm Sure element "myXL Prepaid/XLCircle/Group Settings - Quit-Disband - Yes I'm Sure Button"
	Then user expect to see the Success Page element "myXL Prepaid/XLCircle/Quit-Disband - Success Page - View XL Circle Button"
	When user click on the Success Page element "myXL Prepaid/XLCircle/Quit-Disband - Success Page - View XL Circle Button"
	Then user expect to see the account suspended alert element "myXL Prepaid/XLCircle/Landing - Temporarily Inactive Red Alert"
	
	