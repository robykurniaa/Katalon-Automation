Feature: myXL Prepaid - Onboarding

Scenario: Login - Prepaid Login
	Given user opens myXL application
	When user wait for Lets Start button element "myXL Prepaid/login/Lets Start Button" for 15 seconds to be clickable
	When user click on element "myXL Prepaid/login/Lets Start Button"
	When user click on Login to myXL button element "myXL Prepaid/login/Yes, Login to myXL button"

