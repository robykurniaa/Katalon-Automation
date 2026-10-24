# The test case below works for both Android and iOS

Feature: XL Circle - Parent A Create Group and Invite Member

@common_run_1
Scenario: 01. Create Group Family Hub Screen
	Given user opens myXL application
  When user perform login into the app with number "GlobalVariable.circleParentA" and otp "GlobalVariable.validOTP"
  When user click on XL Circle Banner element "myXL Prepaid/dashboard/XL Circle Banner"
	And user "click" on the optional element "myXL Prepaid/XLCircle/Interstitial Page - Start XL Circle"
	When user click on Next Coachmark element "myXL Prepaid/XLCircle/Landing - Coachmark Next Button"
	When user click on Finish Coachmark element "myXL Prepaid/XLCircle/Landing - Coachmark Finish Button"
  When user click on Create Group Now element "myXL Prepaid/XLCircle/Landing - Create Group Now Button"
  When user enter Group Name on element "myXL Prepaid/XLCircle/Create Group - Group Name Field" as "myCircle"
  When user enter Organizer Name on element "myXL Prepaid/XLCircle/Create Group - Organizer Name Field" as "ParentA"
  When user click on Continue button element "myXL Prepaid/XLCircle/Create Group - Continue Button"
  Then user expect to see the Group Settings element "myXL Prepaid/XLCircle/Create Group - Group Settings - Edit Button"

@common_run_1
Scenario: 02. New Group Family Hub Screen - Click Button Send Invitation without not having group members
	When user click on Send Invitation element "myXL Prepaid/XLCircle/Create Group - Send Invitation Button"
  Then user expect to see the Red Alert No Member Invited element "myXL Prepaid/XLCircle/Create Group - No Member Added Alert"

@common_run_2
Scenario: 04. Validate kill apps after parent on sceen XL Family
	Given user opens myXL application
  When user perform login into the app with number "GlobalVariable.circleParentA" and otp "GlobalVariable.validOTP"
  When user click on XL Circle Banner element "myXL Prepaid/dashboard/XL Circle Banner"
	And user "click" on the optional element "myXL Prepaid/XLCircle/Interstitial Page - Start XL Circle"
	When user click on Next Coachmark element "myXL Prepaid/XLCircle/Landing - Coachmark Next Button"
	When user click on Finish Coachmark element "myXL Prepaid/XLCircle/Landing - Coachmark Finish Button"
	When user click on Create Group Now element "myXL Prepaid/XLCircle/Landing - Create Group Now Button"
  When user enter Group Name on element "myXL Prepaid/XLCircle/Create Group - Group Name Field" as "myCircle"
  When user enter Organizer Name on element "myXL Prepaid/XLCircle/Create Group - Organizer Name Field" as "ParentA"
  When user click on Continue button element "myXL Prepaid/XLCircle/Create Group - Continue Button"
  Then user expect to see the Group Settings element "myXL Prepaid/XLCircle/Create Group - Group Settings - Edit Button"
  When user click on Add Member icon row 1 element "myXL Prepaid/XLCircle/Create Group - Member - Add Member 1"
  When user enter Member MSISDN on element "myXL Prepaid/XLCircle/Add Member - Member Information - Input Member Number Field" as "GlobalVariable.circleMemberA"
  When user enter Member Name on element "myXL Prepaid/XLCircle/Add Member - Member Information - Input Member Name Field" as "MemberA"
  When user click on Continue button element "myXL Prepaid/XLCircle/Create Group - Continue Button"
  Then user expect to see the pending member element "myXL Prepaid/XLCircle/Create Group - Member - Pending Member 1"
	Given user closes myXL application
	# Reopen the app
	Given user opens myXL application
  When user perform login into the app with number "GlobalVariable.circleParentA" and otp "GlobalVariable.validOTP"
  When user click on XL Circle Banner element "myXL Prepaid/dashboard/XL Circle Banner"
	And user "click" on the optional element "myXL Prepaid/XLCircle/Interstitial Page - Start XL Circle"
	When user click on Next Coachmark element "myXL Prepaid/XLCircle/Landing - Coachmark Next Button"
	When user click on Finish Coachmark element "myXL Prepaid/XLCircle/Landing - Coachmark Finish Button"
	Then user expect to see the XL Circle Landing Page Empty element "myXL Prepaid/XLCircle/Landing - Create Group Now Button"

@common_run_2
Scenario: 05. New Group Family Hub - Add Member
	#		Given user reopens the existing application
	Given user opens myXL application
  When user perform login into the app with number "GlobalVariable.circleParentA" and otp "GlobalVariable.validOTP"
  When user click on XL Circle Banner element "myXL Prepaid/dashboard/XL Circle Banner"
	And user "click" on the optional element "myXL Prepaid/XLCircle/Interstitial Page - Start XL Circle"
	When user click on Next Coachmark element "myXL Prepaid/XLCircle/Landing - Coachmark Next Button"
	When user click on Finish Coachmark element "myXL Prepaid/XLCircle/Landing - Coachmark Finish Button"
  When user click on Create Group Now element "myXL Prepaid/XLCircle/Landing - Create Group Now Button"
  When user enter Group Name on element "myXL Prepaid/XLCircle/Create Group - Group Name Field" as "myCircle"
  When user enter Organizer Name on element "myXL Prepaid/XLCircle/Create Group - Organizer Name Field" as "ParentA"
  When user click on Continue button element "myXL Prepaid/XLCircle/Create Group - Continue Button"
  Then user expect to see the Group Settings element "myXL Prepaid/XLCircle/Create Group - Group Settings - Edit Button"
  When user click on Add Member icon row 1 element "myXL Prepaid/XLCircle/Create Group - Member - Add Member 1"
  When user enter Member MSISDN on element "myXL Prepaid/XLCircle/Add Member - Member Information - Input Member Number Field" as "GlobalVariable.circleMemberA"
  When user enter Member Name on element "myXL Prepaid/XLCircle/Add Member - Member Information - Input Member Name Field" as "MemberA"
  When user click on Continue button element "myXL Prepaid/XLCircle/Create Group - Continue Button"
  Then user expect to see the pending member element "myXL Prepaid/XLCircle/Create Group - Member - Pending Member 1"
 
@common_run_2 
Scenario: 06. Validate page confirmation display correctly before send invitation
  When user click on Send Invitation element "myXL Prepaid/XLCircle/Create Group - Send Invitation Button"
  Then user expect to see the Consent and Tnc Checkbox element "myXL Prepaid/XLCircle/Send XL Circle Invitation - Checkbox Consent"
  Then user expect to see the Back button element "myXL Prepaid/XLCircle/Send XL Circle Invitation - Back Button"
  Then user expect to see the Continue button element "myXL Prepaid/XLCircle/Send XL Circle Invitation - Continue Button"
   
@common_run_2  
Scenario: 07. Validate untick checkbox user consent on confirmation page & 
 	When user click on Continue button element "myXL Prepaid/XLCircle/Send XL Circle Invitation - Continue Button"
  Then user expect to see the alert to agree on tnc first element "myXL Prepaid/XLCircle/Send XL Circle Invitation - Unchecked Checkbox Alert"
  
@common_run_2
Scenario: 08. Validate tick checkbox user consent on confirmation page
	When user click on Tnc Checkbox element "myXL Prepaid/XLCircle/Send XL Circle Invitation - Checkbox Consent"
  Then user expect the element "myXL Prepaid/XLCircle/Send XL Circle Invitation - Unchecked Checkbox Alert" to not exist
	
@common_run_2
Scenario: 09. Validate display page success to invitation the member
	When user click on Continue button element "myXL Prepaid/XLCircle/Send XL Circle Invitation - Continue Button"
	Then user expect to see the Share link element "myXL Prepaid/XLCircle/Success Send Invitation - Share Link Button"
  When user click on the shareable link element "myXL Prepaid/XLCircle/Success Send Invitation - Share Link Button"
  When user click on the copy link element "myXL Prepaid/XLCircle/Success Send Invitation - Copy Link Button"
  When user click on the Check XL Circle element "myXL Prepaid/XLCircle/Success Send Invitation - Check XL Circle Button"
  Then user expect to see the pending member added element "myXL Prepaid/XLCircle/Landing - Pending Member 1"
   
@common_run_2  
Scenario: 10. Validate as Parent can add member from landing tab GROUP icon avatar with +
	Given user opens myXL application
  When user perform login into the app with number "GlobalVariable.circleParentA" and otp "GlobalVariable.validOTP"
  When user click on XL Circle Banner element "myXL Prepaid/dashboard/XL Circle Banner"
	And user "click" on the optional element "myXL Prepaid/XLCircle/Interstitial Page - Start XL Circle"
	When user "click" on the optional element "myXL Prepaid/XLCircle/Landing - Coachmark Close Button"
	# Add member 2 to the group
	When user click on Add Member 2 element "myXL Prepaid/XLCircle/Landing - Add Member 2"
  When user enter Member MSISDN on element "myXL Prepaid/XLCircle/Add Member - Member Information - Input Member Number Field" as "GlobalVariable.circleMemberB"
  When user enter Member Name on element "myXL Prepaid/XLCircle/Add Member - Member Information - Input Member Name Field" as "MemberB"
  When user click on Continue button element "myXL Prepaid/XLCircle/Create Group - Continue Button"
  Then user expect to see the pending member element "myXL Prepaid/XLCircle/Create Group - Member - Pending Member 2"
  # Add member 3 to the group
  When user click on Add Member 3 element "myXL Prepaid/XLCircle/Create Group - Member - Add Member 3"
  When user enter Member MSISDN on element "myXL Prepaid/XLCircle/Add Member - Member Information - Input Member Number Field" as "GlobalVariable.circleMemberC"
  When user enter Member Name on element "myXL Prepaid/XLCircle/Add Member - Member Information - Input Member Name Field" as "MemberC"
  When user click on Continue button element "myXL Prepaid/XLCircle/Create Group - Continue Button"
  Then user expect to see the pending member element "myXL Prepaid/XLCircle/Create Group - Member - Pending Member 3"
 	# Send invitation to member 2 and 3
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
  