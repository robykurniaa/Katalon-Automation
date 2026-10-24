Feature: Login to myXL

	
  Scenario: User logs in to myXL
    Given user opens myxl application
    When user "click" on the optional element "myXL Global Element/login/Lets Start Button"
    And user click on the login to myXL button element "myXL Global Element/login/Yes, Login to myXL button"
    And user click on the agree button element "myXL Global Element/login/Agree Button - Half Card"
    And user click on the prepaid segment button element "myXL Global Element/login/XL Prepaid Segment Button"
    And user enter mobile number on element "myXL Global Element/login/Field Input MSISDN" as "081779822488"
    And user click on the continue button element "myXL Global Element/login/Continue Button"
    
   # coba handler
   
    And user click on the login to myXL button element "myXL Global Element/login/Yes, Login to myXL button"
    And user enter otp on element "myXL Global Element/login/Field Input OTP" as "GlobalVariable.validOTP"
    And user "click" on the optional element "myXL Prepaid/dashboard/Interstitial Page - OK" with timeout as 5 seconds
    And user "click" on the optional element "myXL Prepaid/dashboard/Medalia - Text" with timeout as 5 seconds
    Then user expect to see the balance card element "myXL Prepaid/dashboard/Balance Card - See Feature in My Balance"

  #Scenario: User updates profile information
    #When user click on the profile menu element "example/bottomNavigationBar/Profile Menu"
    #And user click on the account info element "example/profileMenu/Account Information Registration"
    #And user click on the edit button element "example/accountInfoPage/Edit - Account Info"
    #And user enter name on element "example/accountInfoPage/Account Info - Edit Info - Name Input" as "Regression Automation"
    #And user enter email on element "example/accountInfoPage/Account Info - Edit Info - Email Input" as "Testingbigbang@gmail.com"
    #And user click on the save button element "example/accountInfoPage/Save Button - Edit Information"
    #Then user expect to see the account info page with edit button element "example/accountInfoPage/Edit - Account Info"

   #Scenario: Test new step
   #Given user opens axisnet application test
   #When user perform login into the app with number "GlobalVariable.circleParentA" and otp "GlobalVariable.validOTP"
   