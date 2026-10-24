Feature: Login

Scenario: Validate Login Axis Net
Given user opens axisnet application test
When user perform login into the axis app with number "083110568390" and otp "DT2022"
Then user expect to see the Balance card element "AXISNet/Dashboard/Success Login"