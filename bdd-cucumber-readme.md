# 📱🌐 Katalon Studio Test Automation Framework

This project is a cross-platform **test automation framework** built using **Katalon Studio**. It supports **Android**, **iOS**, and **Web** testing. The framework follows the **BDD (Behavior-Driven Development)** approach with **Page Object Model (POM)** to promote readability, scalability, and maintainability.

---

## 🔧 Key Features 

- ✅ BDD-style scenarios using **Gherkin syntax**
- ✅ Platform-specific and common feature segregation
- ✅ Page Object Model for clean code organization
- ✅ JSON-based locator management
- ✅ Dynamic locator resolution for Android, iOS, and Web
- ✅ Modular utility classes for code reuse and abstraction

---

## 📁 Folder Structure

Include/
├── features/
│   ├── Common/          # Reusable feature files for all platforms
│   ├── Android/         # Android-specific feature files
│   ├── iOS/             # iOS-specific feature files
│   └── Web/             # Web-specific feature files
│
├── scripts/groovy/
│   ├── stepDefinitions/
│   │   ├── CommonSteps.groovy       # Shared step definitions
│   │   └── <PageName>.groovy        # Page-specific steps (e.g., LoginPage.groovy)
│   │
│   ├── hooks/
│   │   └── Hooks.groovy             # Cucumber hooks for setup/teardown
│   │
│   └── pages/
│       ├── LoginPage.groovy         # Page class for login screen
│       └── DashboardPage.groovy     # Page class for dashboard screen
│
Locators/
└── <AppName>/
    └── <PageName>.json              # JSON files with locators by key

Keywords/
└── support/
    ├── CommonUtility.groovy         # Main dispatcher class
    ├── MobileUtility.groovy         # Utility methods for Android/iOS
    └── WebUtility.groovy            # Utility methods for web

---

## 🛠️ Prerequisites

Ensure the following are installed/configured:
* Katalon Studio (v10.1.0 or later)
* Katalon Runtime Engine
* JDK 11+ (Java 21 optionally, if supported)
* Appium (for Android/iOS testing)
* Mobile Device or Emulator (Android/iOS)
* Web Drivers (e.g., ChromeDriver)
* Proper Execution Profiles configured in Katalon

---

## 🧪 Writing Test Scenarios
➕ Step 1: Create Feature File
Save your .feature file under the appropriate folder:

```
Feature: Login to myXL and Update Profile Information
  Scenario: User logs in to myXL and updates profile information
    Given user opens Flipkart application
    When user click on the login element "XL Prepaid/login/Lets Start Button"
    And user enter phone number on element "XL Prepaid/login/Yes, Login to myXL button" as "9658713301"
    When user click on the request otp button element "XL Prepaid/login/Agree Button - Half Card"
```

🔎 Step Format
```
When user click on the login element "XL Prepaid/login/Lets Start Button"
```
**XL Prepaid/login** → path to JSON file
**Lets Start Button** → key inside the JSON file

🧩 Step 2: Add or Reuse Step Definitions
```
Create new steps in Include/scripts/groovy/stepDefinitions or reuse those in CommonSteps.groovy.

🔁 Reuse First: Prefer adding new steps only if not already covered by existing common ones.
```

---

## 📌 Locator Management
Use JSON files for defining and managing locators per platform and page.

📂 File Location: Locators/<AppName>/<PageName>.json

🔎 Step Format
```
When user click on the login element "XL Prepaid/login/Lets Start Button"
```
**XL Prepaid/login** → path to JSON file
**Lets Start Button** → key inside the JSON file

---

## 🔧 Utility Functions
Located at Keywords/support/, utility functions help reduce code duplication and enable platform-specific operations.

🔍 CommonUtility.groovy
```
Detects platform (web/mobile)
Dispatches to appropriate utility class
```

🤖 MobileUtility.groovy
```
Platform-aware methods for Android & iOS
Touch actions, gestures, waits, etc.
```

🖥 WebUtility.groovy
```Utility methods for browser interactions```

---

## 🔄 Cucumber Hooks
Located in Include/scripts/groovy/hooks/Hooks.groovy.
Used for:
Initializing drivers or environment
Cleaning up sessions after test execution

---

## 🚀 Execution
▶ From Katalon Studio
```
Open the test suite or test suite collection
Select the appropriate execution profile
Click Run
```
💻 Command Line Execution
```
katalonc -noSplash -runMode=console \
-projectPath="/path/to/your/project.prj" \
-testSuitePath="Test Suites/Sanity" \
-executionProfile="default" -browserType="Chrome"
```
🎯 Run Feature File with Tags
```
katalonc -testSuitePath="Test Suites/BDD Runner" \
-executionProfile="default" \
-browserType="Chrome" \
-cucumberOptions="--tags @login"
```

---

## 🧠 Best Practices
✅ Use CommonSteps.groovy for reusable steps
✅ Follow the page object pattern for maintainability
✅ Use tags like @smoke, @regression for test grouping
✅ Keep locators out of code and in external JSON
✅ Name your locators consistently for easy readability

---

## 📬 Contact / Contributions
Feel free to fork, enhance, or raise issues. Pull requests are welcome!