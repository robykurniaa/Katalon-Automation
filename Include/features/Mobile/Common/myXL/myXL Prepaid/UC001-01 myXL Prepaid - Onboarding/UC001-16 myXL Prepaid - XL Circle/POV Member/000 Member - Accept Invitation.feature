Feature: XL Circle Landing Page (Member POV)

Scenario Outline: Baseline - Member accepts invitation by App
  Given user opens myXL application
  When user perform login into the app with number "<memberNumber>" and otp "GlobalVariable.validOTP"
  When user click on XL Circle Banner element "myXL Prepaid/dashboard/XL Circle Banner"
  And user "click" on the optional element "myXL Prepaid/XLCircle/Interstitial Page - Start XL Circle"
  And user "click" on the optional element "myXL Prepaid/XLCircle/Landing - Coachmark Next Button"
  And user "click" on the optional element "myXL Prepaid/XLCircle/Landing - Coachmark Finish Button"
  Then user expect to see the Create Group Now element "myXL Prepaid/XLCircle/Landing - Create Group Now Button"
  And user expect to see the Check Invitation For You element "myXL Prepaid/XLCircle/Landing - Check Invitations for You"
  When user click on Check Invitation For You element "myXL Prepaid/XLCircle/Landing - Check Invitations for You"
  Then user expect to see the Join XL Circle button element "myXL Prepaid/XLCircle/Check Invitations for You - Join XL Circle Button"
  When user click on Join XL Circle button element "myXL Prepaid/XLCircle/Check Invitations for You - Join XL Circle Button"
  When user wait for Success Join Page element "myXL Prepaid/XLCircle/Success Join - View XL Circle Button" for 10 seconds to be clickable
  When user click on View XL Circle element "myXL Prepaid/XLCircle/Success Join - View XL Circle Button"
  When user click on next button element "myXL Prepaid/XLCircle/Landing - Coachmark Next Button"

Examples:
  | memberNumber              	 |
  | GlobalVariable.circleMemberB |
  | GlobalVariable.circleMemberC |
  | GlobalVariable.circleMemberD |
  | GlobalVariable.circleMemberE |
  | GlobalVariable.circleMemberF |
