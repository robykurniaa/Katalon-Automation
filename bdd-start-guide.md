# myXL-Katalon Project - BDD Framework (Branch: myXL-FamilyHub)

## 1. Git Clone the Project Branch `myXL-FamilyHub`

### Clone via Katalon

> ⚠️ **Do not overwrite the existing project folder. It's recommended to use a new empty folder.**

- Go to `Clone Project`
  - **Repository URL**: `https://gitrepo.xlaxiata.id/BATM.FEDYFAHRONG/myxl-katalon.git`
  - **User**: `<your_email>@xl.co.id`
  - **Password**: `<access_token>`  
    > *Make sure to use **Access Token**, not Feed Token.*
  - Choose branch: `myXL-FamilyHub`
- Once the clone is completed, open the project on Katalon as usual.

### Clone via Terminal / CMD

```bash
git clone -b myXL-FamilyHub https://gitrepo.xlaxiata.id/BATM.FEDYFAHRONG/myxl-katalon.git
```

---

## 2. Starting BDD

### Writing Test Case

- Test cases are written in `.feature` files located under `Include/features`.
- Each `.feature` file can contain multiple test cases (scenarios).

#### Example:

**Old Framework:**
```
**Folder**: UC001-01 myXL Prepaid - Onboarding
Test Cases:
- 000 Login - Prepaid Login
- 001 Login - Validate CVP
- 002 Login - Validate Login using Invalid MSISDN
- 003 Login - Validate Login using AXIS MSISDN
```

**BDD Framework:**
```
**File**: UC001-01 myXL Prepaid - Onboarding.feature
Scenarios:
- Scenario: 000 Login - Prepaid Login
- Scenario: 001 Login - Validate CVP
- Scenario: 002 Login - Validate Login using Invalid MSISDN
- Scenario: 003 Login - Validate Login using AXIS MSISDN
```

### Gherkin Syntax

- Syntax is based on predefined human-friendly steps defined in:
  ```
  Include/scripts/groovy/stepDefinitions/CommonSteps.groovy
  ```
- If there's a step that has not defined yet inside the commonsteps, you can create one within the same format. 
- Gherkin's keyword usage : 

| Keyword | Purpose |
|--------|---------|
| Given  | Setup preconditions (the starting state) |
| When   | Describe the action taken by the user/system |
| Then   | Assert the expected outcome/result |
| And / But | Add more context or conditions |

#### Example:

**Old Framework:**
```groovy
'Verify Choose Login Segment Page'
Mobile.waitForElementPresent(findTestObject('Object Repository/myXL - Login And Logout/XL Prepaid Segment Button - Login'), 0)
```

**BDD Framework:**
- Find matching syntax in `CommonSteps.groovy`, e.g.:
```gherkin
@When(/^user wait for(?: .*?)? element "([^"]*)" for (\d+) second(?:s?) to be (clickable|visible|present)$/)
```

- Usage:
```gherkin
When user wait for Prepaid Segment Button element "myXL Prepaid/login/XL Prepaid Segment Button" for 10 seconds to be clickable
```

---

## 3. Object Locators Management

- `Locators/` folder contains subfolders representing app segmentation, similar to `Object Repository`.
- Each subfolder contains `.json` files where objects are defined.

#### Example:

**Old Framework Path:**
```
Object Repository/Android/myXL Global Element/See Feature in My Balance/Landing Page - Balance Active Period
```

**BDD Framework Path:**
```
myXL Global Element/dashboard/Balance Active Period
```

> ℹ️ Why we don’t need to include the `Locators/` folder in the object path in BDD Framework?  
All locator-loading logic is already handled via utility methods such as `loadLocators` and `getLocatorPath` from:
```
Keywords/support/CommonUtils.groovy
Keywords/support/LocatorUtil.groovy
```

---

## 4. Reporting & Screenshot Folder

- BDD Framework **still uses** Test Case and Test Suite files for report generation.
- The report format remains the same but **does not include screenshots** by default.
- Test Case files are used only to call corresponding `.feature` files.
- Test Suite files group multiple Test Case files.

### Screenshot Capture
- A screenshot is taken **before each action at scenario level**.
- Stored in the `Screenshots/` folder with appropriately named structure.
