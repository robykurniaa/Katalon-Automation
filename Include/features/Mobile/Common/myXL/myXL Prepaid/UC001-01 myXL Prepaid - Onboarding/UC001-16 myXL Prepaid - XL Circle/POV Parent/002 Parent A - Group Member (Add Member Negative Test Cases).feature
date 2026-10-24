Feature: XL Circle - Parent Create Group and Add Member but only negative test cases.


Scenario: 11 Add Member with not XL prabayar number
	Given user opens myXL application
  When user perform login into the app with number "GlobalVariable.circleParentA" and otp "GlobalVariable.validOTP"
  When user click on XL Circle Banner element "myXL Prepaid/dashboard/XL Circle Banner"
	And user "click" on the optional element "myXL Prepaid/XLCircle/Interstitial Page - Start XL Circle"
	# Landing Page Displayed
	When user click on Add Member 4 element "myXL Prepaid/XLCircle/Landing - Add Member 4"
  When user enter Member MSISDN on element "myXL Prepaid/XLCircle/Add Member - Member Information - Input Member Number Field" as "GlobalVariable.prioUpfrontNum"
  When user enter Member Name on element "myXL Prepaid/XLCircle/Add Member - Member Information - Input Member Name Field" as "Upfront"
  When user click on Continue button element "myXL Prepaid/XLCircle/Create Group - Continue Button"
  Then user expect to see the pending member element "myXL Prepaid/XLCircle/Add Member - Error - MSISDN Non Prepaid"
  When user click on Back to The previous Page element "myXL Prepaid/XLCircle/Add Member - Error - MSISDN Non Prepaid"
  Then user expect to see the Add Member 4 element "myXL Prepaid/XLCircle/Create Group - Member - Add Member 4"


Scenario: 12 Add Member with member already join to other group
	When user click on Add Member 4 element "myXL Prepaid/XLCircle/Create Group - Member - Add Member 4"
  When user enter Member MSISDN on element "myXL Prepaid/XLCircle/Add Member - Member Information - Input Member Number Field" as "GlobalVariable.circleMemberA"
  When user enter Member Name on element "myXL Prepaid/XLCircle/Add Member - Member Information - Input Member Name Field" as "MemberA"
  When user click on Continue button element "myXL Prepaid/XLCircle/Create Group - Continue Button"
  Then user expect to see the pending member element "myXL Prepaid/XLCircle/Add Member - Error - Back to The Previous Page"
  When user click on Back to The previous Page element "myXL Prepaid/XLCircle/Add Member - Error - Back to The Previous Page"
  Then user expect to see the Add Member 3 element "myXL Prepaid/XLCircle/Create Group - Member - Add Member 4"

 
Scenario: 13 Add Member with member number is not active
	When user click on Add Member 4 element "myXL Prepaid/XLCircle/Create Group - Member - Add Member 4"
  When user enter Member MSISDN on element "myXL Prepaid/XLCircle/Add Member - Member Information - Input Member Number Field" as "GlobalVariable.inactiveNum"
  When user enter Member Name on element "myXL Prepaid/XLCircle/Add Member - Member Information - Input Member Name Field" as "Inactive"
  When user click on Continue button element "myXL Prepaid/XLCircle/Create Group - Continue Button"
  Then user expect to see the pending member element "myXL Prepaid/XLCircle/Add Member - Error - Back to The Previous Page"
  When user click on Back to The previous Page element "myXL Prepaid/XLCircle/Add Member - Error - Back to The Previous Page"
  Then user expect to see the Add Member 3 element "myXL Prepaid/XLCircle/Create Group - Member - Add Member 4"

  
Scenario: 14 Add Member with member number is wrong format
	When user click on Add Member 4 element "myXL Prepaid/XLCircle/Create Group - Member - Add Member 4"
  When user enter Member MSISDN on element "myXL Prepaid/XLCircle/Add Member - Member Information - Input Member Number Field" as "1234567890"
  Then user expect to see the red alert not prepaid number element "myXL Prepaid/XLCircle/Add Member - Alert - Invalid MSISDN"


Scenario: 15 Add Member if Parent not complete fill the form
	When user "clear text" on the optional element "myXL Prepaid/XLCircle/Add Member - Member Information - Input Member Number Field"
	When user enter Member MSISDN on element "myXL Prepaid/XLCircle/Add Member - Member Information - Input Member Number Field" as "6285943263030"
	When user enter Member Name on element "myXL Prepaid/XLCircle/Add Member - Member Information - Input Member Name Field" as ""
	When user click on Continue button element "myXL Prepaid/XLCircle/Create Group - Continue Button"
  Then user expect to see the red alert element "myXL Prepaid/XLCircle/Add Member - Alert - Incomplete Form"
  

Scenario: 16 Add Member if Parent fill the name member with special char
	When user enter Member Name on element "myXL Prepaid/XLCircle/Add Member - Member Information - Input Member Name Field" as "P3ND!NG"
	Then user expect to see the red alert element "myXL Prepaid/XLCircle/Add Member - Alert - Invalid Member Name"
	When user "clear text" on the optional element "myXL Prepaid/XLCircle/Add Member - Member Information - Input Member Name Field"
	

Scenario: 17 Validate add member with status pending on another group
	When user "clear text" on the optional element "myXL Prepaid/XLCircle/Add Member - Member Information - Input Member Number Field"
	When user enter Member MSISDN on element "myXL Prepaid/XLCircle/Add Member - Member Information - Input Member Number Field" as "GlobalVariable.circleMemberA"
	When user "clear text" on the optional element "myXL Prepaid/XLCircle/Add Member - Member Information - Input Member Name Field"
  When user enter Member Name on element "myXL Prepaid/XLCircle/Add Member - Member Information - Input Member Name Field" as "Pending"
  When user click on Continue button element "myXL Prepaid/XLCircle/Create Group - Continue Button"
  Then user expect to see the error page Number Already Invited element "myXL Prepaid/XLCircle/Add Member - Error - Back to The Previous Page"
  When user click on Back to The previous Page element "myXL Prepaid/XLCircle/Add Member - Error - Back to The Previous Page" 
  When user click on Back button element "myXL Global Element/navigation/Back Button"
  Then user expect to see the Add Member 3 element "myXL Prepaid/XLCircle/Landing - Add Member 4"
