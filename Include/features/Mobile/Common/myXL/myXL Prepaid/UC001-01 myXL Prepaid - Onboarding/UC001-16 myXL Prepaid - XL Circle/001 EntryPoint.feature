Feature: XL Circle Entry Points (First Visit)

# Total Scenario : 8/8

Background: 
  Given user opens myXL application
  When user perform login into the app with number "GlobalVariable.circleMemberA" and otp "GlobalVariable.validOTP"

@entrypoint  
Scenario: Validate entry point Family Hub from Banner on dashboard (lotty version)
	When user click on XL Circle Banner element "myXL Prepaid/dashboard/XL Circle Banner"

@entrypoint
Scenario: Validate display intertitial page when open Family Hub for the 1st time
	When user click on XL Circle Banner element "myXL Prepaid/dashboard/XL Circle Banner"
	And user "click" on the optional element "myXL Prepaid/XLCircle/Interstitial Page - Start XL Circle"

@entrypoint
Scenario: Validate display coachmark if cust 1st open landing Family Hub
	When user click on XL Circle Banner element "myXL Prepaid/dashboard/XL Circle Banner"
	And user "click" on the optional element "myXL Prepaid/XLCircle/Interstitial Page - Start XL Circle"
	When user click on Next Coachmark element "myXL Prepaid/XLCircle/Landing - Coachmark Next Button"
	When user click on Finish Coachmark element "myXL Prepaid/XLCircle/Landing - Coachmark Finish Button"
	Then user expect to see the XL Circle Landing Page element "myXL Prepaid/XLCircle/Landing - Create Group Now Button"
	Then user takes the screenshot name "Validate_Landing_Page_XLCircle_ByBanner"
	
@entrypoint	
Scenario: Validate entry Point Family Hub from NavBar
	When user click on XL Circle Navbar element "myXL Prepaid/navbar/XL Circle"
	And user "click" on the optional element "myXL Prepaid/XLCircle/Interstitial Page - Start XL Circle"
	When user click on Next Coachmark element "myXL Prepaid/XLCircle/Landing - Coachmark Next Button"
	When user click on Finish Coachmark element "myXL Prepaid/XLCircle/Landing - Coachmark Finish Button"
	Then user expect to see the XL Circle Landing Page element "myXL Prepaid/XLCircle/Landing - Create Group Now Button"
	Then user takes the screenshot name "Validate_Landing_Page_XLCircle_ByNavBar"

@entrypoint
Scenario: Validate entrypoint Family Hub from Quick Link
	When user opens "myXL Prepaid/dashboard/Quick Menu - XL Circle" via Quick Menu, landing on "myXL Prepaid/XLCircle/Interstitial Page - Start XL Circle" or using Others "myXL Prepaid/dashboard/Other Menu - XL Circle"
	And user "click" on the optional element "myXL Prepaid/XLCircle/Interstitial Page - Start XL Circle"
	When user click on Next Coachmark element "myXL Prepaid/XLCircle/Landing - Coachmark Next Button"
	When user click on Finish Coachmark element "myXL Prepaid/XLCircle/Landing - Coachmark Finish Button"
	Then user expect to see the XL Circle Landing Page element "myXL Prepaid/XLCircle/Landing - Create Group Now Button"
	Then user takes the screenshot name "Validate_Landing_Page_XLCircle_ByQuickLink"
 
@entrypoint
Scenario: Validate FAQ Family Hub
	When user click on XL Circle Banner element "myXL Prepaid/dashboard/XL Circle Banner"
	And user "click" on the optional element "myXL Prepaid/XLCircle/Interstitial Page - Start XL Circle"
	When user click on Next Coachmark element "myXL Prepaid/XLCircle/Landing - Coachmark Next Button"
	When user click on Finish Coachmark element "myXL Prepaid/XLCircle/Landing - Coachmark Finish Button"
	When user click on FAQ XL Circle element "myXL Prepaid/XLCircle/Landing - FAQ"
	Then user expect to see the FAQs element "myXL Prepaid/XLCircle/Landing FAQ - FAQ 1"
	When user click on What is XL Circle? element "myXL Prepaid/XLCircle/Landing FAQ - FAQ 1"
	When user click on Back button element "myXL Global Element/navigation/Back Button"
	Then user expect to see the FAQs element "myXL Prepaid/XLCircle/Landing FAQ - FAQ 2"
	When user click on Who can join XL Circle? element "myXL Prepaid/XLCircle/Landing FAQ - FAQ 2"
	When user click on Back button element "myXL Global Element/navigation/Back Button"
	Then user expect to see the FAQs element "myXL Prepaid/XLCircle/Landing FAQ - FAQ 3"
	When user click on How do i create an XL Circle? element "myXL Prepaid/XLCircle/Landing FAQ - FAQ 3"
	When user click on Back button element "myXL Global Element/navigation/Back Button"
	Then user expect to see the FAQs element "myXL Prepaid/XLCircle/Landing FAQ - FAQ 4"
	When user click on What is the max number of members in one XL Circle? element "myXL Prepaid/XLCircle/Landing FAQ - FAQ 4"
	When user click on Back button element "myXL Global Element/navigation/Back Button"
	Then user expect to see the FAQs element "myXL Prepaid/XLCircle/Landing FAQ - FAQ 5"
	When user click on What is Circle Quota? element "myXL Prepaid/XLCircle/Landing FAQ - FAQ 5"
	When user click on Back button element "myXL Global Element/navigation/Back Button"
	Then user expect to see the FAQs element "myXL Prepaid/XLCircle/Landing FAQ - FAQ 6"
	When user click on When will the Circle Quota be used element "myXL Prepaid/XLCircle/Landing FAQ - FAQ 6"
	When user click on Back button element "myXL Global Element/navigation/Back Button"
	Then user expect to see the FAQs element "myXL Prepaid/XLCircle/Landing FAQ - FAQ 7"
	When user click on What happens if a member leaves an XL Circle? element "myXL Prepaid/XLCircle/Landing FAQ - FAQ 7"
	When user click on Back button element "myXL Global Element/navigation/Back Button"
	Then user expect to see the FAQs element "myXL Prepaid/XLCircle/Landing FAQ - FAQ 1"

@entrypoint	
Scenario: Validate landing Family Hub correctly - empty landing not have invitation
  When user click on XL Circle Banner element "myXL Prepaid/dashboard/XL Circle Banner"
  And user "click" on the optional element "myXL Prepaid/XLCircle/Interstitial Page - Start XL Circle"
  When user click on Next Coachmark element "myXL Prepaid/XLCircle/Landing - Coachmark Next Button"
  When user click on Finish Coachmark element "myXL Prepaid/XLCircle/Landing - Coachmark Finish Button"
  Then user expect to see the XL Circle Landing Page element "myXL Prepaid/XLCircle/Landing - Create Group Now Button"
  Then user expect the element "myXL Prepaid/XLCircle/Landing - Check Invitations for You" to not exist

@invited
Scenario: Validate landing Family Hub correctly - empty landing have invitation
	When user click on XL Circle Banner element "myXL Prepaid/dashboard/XL Circle Banner"
	And user "click" on the optional element "myXL Prepaid/XLCircle/Interstitial Page - Start XL Circle"
	Then user expect to see the XL Circle Landing Page element "myXL Prepaid/XLCircle/Member - Landing - Check Invitations for You"
	Then user takes the screenshot name "one_invitation_landing_page_XL_Circle"
	


