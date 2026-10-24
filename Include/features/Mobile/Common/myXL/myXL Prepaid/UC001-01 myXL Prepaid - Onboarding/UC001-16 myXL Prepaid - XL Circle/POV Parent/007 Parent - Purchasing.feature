Feature: XL Circle - Parent Purchasing Package

@buy_circle
Scenario: Validate spending tracker will be display Rp 0 when parent or member before any transaction
  Given user opens myXL application
  When user perform login into the app with number "GlobalVariable.circleParentB" and otp "GlobalVariable.validOTP"
  When user click on XL Circle Banner element "myXL Prepaid/dashboard/XL Circle Banner"
  And user "click" on the optional element "myXL Prepaid/XLCircle/Interstitial Page - Start XL Circle"
  When user click on Next Coachmark element "myXL Prepaid/XLCircle/Landing - Coachmark Next Button"
  When user click on Next Coachmark element "myXL Prepaid/XLCircle/Landing - Coachmark Next Button (2nd)"
  When user click on Next Coachmark element "myXL Prepaid/XLCircle/Landing - Coachmark Next Button (2nd)"
  When user click on Finish Coachmark element "myXL Prepaid/XLCircle/Landing - Coachmark Finish Button"
  Then user expect to see the initial spending IDR 0 element "myXL Prepaid/XLCircle/Landing - Total Spending of XL Circle (IDR 0)" 

@buy_circle   
Scenario: Validate can purchase package for family
  When user swipes "left" on element "myXL Prepaid/XLCircle/Landing - Circle Quota 2" 3 times
  When user click on Circle Quota element "myXL Prepaid/XLCircle/Landing - Circle Quota 3"
  Then user expect to see the PDP element "myXL Global Element/purchase/Product Detail Page - Activate Button"
  When user click on Activate element "myXL Global Element/purchase/Product Detail Page - Activate Button"
  Then user expect to see the Confirmation page element "myXL Global Element/purchase/Confirmation Page - Open Package Detail"
  When user scrolls to "ShopeePay"
  When user click on Gopay radio button element "myXL Global Element/purchase/Confirmation Page - Payment Method - GoPay"
  When user click on Pay button element "myXL Global Element/purchase/Confirmation Page - Pay Button"
  And user "click" on the optional element "myXL Global Element/purchase/Confirmation Page - Payment Consent - Checkbox" with timeout as 5 seconds
  And user "click" on the optional element "myXL Global Element/purchase/Confirmation Page - Payment Consent - Continue Button" with timeout as 5 seconds
  Then user expect to see the Pending page element "myXL Global Element/purchase/Multipayment Purchase Pending - Refresh Payment Status"
  When user click on Close Pending page element "myXL Global Element/purchase/Multipayment Purchase Pending - Close Button"
  When user click on Back to Dashboard element "myXL Global Element/purchase/Success Purchase - Back to Dashboard Button"
  Then user expect to see the Dashboard element "myXL Prepaid/dashboard/XL Circle Banner"

@buy_circle  
Scenario: Validate can view details quota family (Lihat Benefit Bersama)
  When user click on XL Circle Banner element "myXL Prepaid/dashboard/XL Circle Banner"
  When user click on Total XL Circle Quota element "myXL Prepaid/XLCircle/Landing - Total XL Circle Quota"
  Then user expect to see the Quota Tab element "myXL Prepaid/XL Circle/Benefit XL Circle - Quota Tab"
  When user click on Back button element "myXL Global Element/navigation/Back Button"
  
Scenario: Validate spending tracker will be display achived target and unlocked the bonus
	Then user compares value "myXL Prepaid/XLCircle/Landing - Total Spending of XL Circle" with "Landing - Transaction Target" using "equal"
 
  
Scenario: Validate spending tracker will be adding when users buy package outside XL Circle
	Given user opens myXL application
  When user perform login into the app with number "GlobalVariable.circleParentA" and otp "GlobalVariable.validOTP"
  When user click on XL Circle Banner element "myXL Prepaid/dashboard/XL Circle Banner"
  
