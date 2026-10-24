Feature: Boostr Weekend

  As a QA tester
  I want to verify that special packages are displayed correctly based on the current day
  So that I can ensure the right promotions are available to users
  
Scenario: Validate Boostr Weekend Onboarded 

Given user opens axisnet application test
When user opens paket via bottom navigation menu element "AXISNet/Dashboard/Bottom Navigation Menu - Paket"
And user click on Internet Tab element "AXISNet/Paket List/Paket List-Internet"
And system detects current day and selects matching packages:
    | day       | packageName                |
    | SATURDAY  | BOOSTR 1GB 2hr             |
    | SATURDAY  | BOOSTR 2GB 2hr             |
    | SATURDAY  | BOOSTR 3GB 2hr             |
    | SATURDAY  | BOOSTR 1GB 1hr             |
    | SATURDAY  | BOOSTR 2GB 1hr             |
    | SATURDAY  | BOOSTR 3GB 1hr             |
    | SATURDAY  | Bronet Sosmed 9GB 3hr      |
    | SUNDAY    | BOOSTR 1GB 1hr             |
    | SUNDAY    | BOOSTR 2GB 1hr             |
    | SUNDAY    | BOOSTR 3GB 1hr             |
    | SUNDAY    | PROMO BRONET 16GB 60hr     |
    | SUNDAY    | OWSEM 16GB + Unli Games 30hr |
    | SUNDAY    | Bronet Sosmed 9GB 3hr      |
Then all configured packages should be found on the screen    


