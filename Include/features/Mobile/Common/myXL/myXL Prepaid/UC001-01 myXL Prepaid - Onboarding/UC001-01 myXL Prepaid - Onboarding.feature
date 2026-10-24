Feature: UC001-01 myXL Prepaid - Onboarding

Scenario: 011 Login - Validate Logout
	Given user opens myXL application
	When user click on Profile element "myXL Prepaid/navbar/Profile Menu"
	When user scrolls to "Logout"
	Then user expect to see the Logout button element "myXL Global Element/profile/Logout Button"
	When user click on Logout button element "myXL Global Element/profile/Logout Button"
	When user click on Confirm Logout button element "myXL Global Element/profile/Logout Half Card - Logout Button"
	



