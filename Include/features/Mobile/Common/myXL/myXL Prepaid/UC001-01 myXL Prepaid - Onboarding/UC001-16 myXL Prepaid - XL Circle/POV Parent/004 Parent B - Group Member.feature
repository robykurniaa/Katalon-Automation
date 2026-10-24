Feature: XL Circle - Parent B Create Group and Invite Member 


Scenario: Precondition - Create Group for Parent B
	Given user opens myXL application
  When user perform login into the app with number "GlobalVariable.circleParentB" and otp "GlobalVariable.validOTP"
  When user click on XL Circle Banner element "myXL Prepaid/dashboard/XL Circle Banner"
  And user "click" on the optional element "myXL Prepaid/XLCircle/Interstitial Page - Start XL Circle"
	When user click on Next Coachmark element "myXL Prepaid/XLCircle/Landing - Coachmark Next Button"
	When user click on Finish Coachmark element "myXL Prepaid/XLCircle/Landing - Coachmark Finish Button"
  When user click on Create Group Now element "myXL Prepaid/XLCircle/Landing - Create Group Now Button"
  When user enter Group Name on element "myXL Prepaid/XLCircle/Create Group - Group Name Field" as "myCircle2"
  When user enter Organizer Name on element "myXL Prepaid/XLCircle/Create Group - Organizer Name Field" as "ParentB"
  When user click on Continue button element "myXL Prepaid/XLCircle/Create Group - Continue Button"
  Then user expect to see the Group Settings element "myXL Prepaid/XLCircle/Create Group - Group Settings - Edit Button"
   
Scenario: Precondition - Add Member for Parent B
  When user click on Add Member icon row 1 element "myXL Prepaid/XLCircle/Create Group - Member - Add Member 1"
  When user enter Member MSISDN on element "myXL Prepaid/XLCircle/Add Member - Member Information - Input Member Number Field" as "GlobalVariable.circleMemberD"
  When user enter Member Name on element "myXL Prepaid/XLCircle/Add Member - Member Information - Input Member Name Field" as "MemberD"
  When user click on Continue button element "myXL Prepaid/XLCircle/Create Group - Continue Button"
  Then user expect to see the pending member element "myXL Prepaid/XLCircle/Create Group - Member - Pending Member 1"
  When user click on Add Member 2 element "myXL Prepaid/XLCircle/Create Group - Member - Add Member 2"
  When user enter Member MSISDN on element "myXL Prepaid/XLCircle/Add Member - Member Information - Input Member Number Field" as "GlobalVariable.circleMemberE"
  When user enter Member Name on element "myXL Prepaid/XLCircle/Add Member - Member Information - Input Member Name Field" as "MemberE"
  When user click on Continue button element "myXL Prepaid/XLCircle/Create Group - Continue Button"
  Then user expect to see the pending member element "myXL Prepaid/XLCircle/Create Group - Member - Pending Member 2"
  When user click on Add Member 3 element "myXL Prepaid/XLCircle/Create Group - Member - Add Member 3"
  When user enter Member MSISDN on element "myXL Prepaid/XLCircle/Add Member - Member Information - Input Member Number Field" as "GlobalVariable.circleMemberF"
  When user enter Member Name on element "myXL Prepaid/XLCircle/Add Member - Member Information - Input Member Name Field" as "MemberF"
  When user click on Continue button element "myXL Prepaid/XLCircle/Create Group - Continue Button"
  Then user expect to see the pending member element "myXL Prepaid/XLCircle/Create Group - Member - Pending Member 3"
  When user click on Send Invitation element "myXL Prepaid/XLCircle/Create Group - Send Invitation Button"
  When user click on Tnc Checkbox element "myXL Prepaid/XLCircle/Send XL Circle Invitation - Checkbox Consent"
  When user click on Continue button element "myXL Prepaid/XLCircle/Send XL Circle Invitation - Continue Button"
  Then user expect to see the Share link element "myXL Prepaid/XLCircle/Success Send Invitation - Share Link Button"
  When user click on the shareable link element "myXL Prepaid/XLCircle/Success Send Invitation - Share Link Button"
  When user click on the copy link element "myXL Prepaid/XLCircle/Success Send Invitation - Copy Link Button"
  When user click on the Check XL Circle element "myXL Prepaid/XLCircle/Success Send Invitation - Check XL Circle Button"
  Then user expect to see the pending member added element "myXL Prepaid/XLCircle/Landing - Pending Member 3"
  Then user expect to see the pending member added element "myXL Prepaid/XLCircle/Landing - Pending Member 2"
  Then user expect to see the pending member added element "myXL Prepaid/XLCircle/Landing - Pending Member 1"
  
