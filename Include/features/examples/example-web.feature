Feature: Login to myXL and Update Profile Information

  Scenario: User logs in to myXL and updates profile information
    Given user opens Flipkart application
    #When user perform login into the app with number "6285975080108" and otp "GlobalVariable.validOTP"
    When user click on the login element "myXL Global Element/login/Lets Start Button"
    #And user enter phone number on element "myXL Global Element/login/Yes, Login to myXL button" as "9658718800"
    #When user click on the request otp button element "myXL Global Element/login/Agree Button - Half Card"

  Scenario: User logs in to myXL and updates profile information
    And user enter phone number on element "myXL Global Element/login/Yes, Login to myXL button" as "9658718800"
    When user click on the request otp button element "myXL Global Element/login/Agree Button - Half Card"
