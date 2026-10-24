import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import javax.security.auth.login.LoginContext as LoginContext
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import customKeywords.ScreenshotKeywords as Screenshot
import customKeywords.ScreenshotKeywords as TestCase
import customKeywords.LoginKeywords as Login
import customKeywords.PermissionKeywords as Permission

String testCaseName = "Login with Valid Axis MSISDN and OTP"
TestCase.setTestCaseName(testCaseName)

Login.isAppInstalled()

'Tap Start'
Mobile.tap(findTestObject('Mobile/Login/Login Page/ObjBtnLoginPage - Start'), 0, FailureHandling.OPTIONAL)

Screenshot.takeScreenshot( 'Start')

'Input MSISDN'
def newUiMsisdnObj = findTestObject('Mobile/Login/Login Page/ObjLogin - Set Msisdn Login (New UI)')
def oldUiMsisdnObj = findTestObject('Mobile/Login/Login Page/ObjLogin - Set Msisdn Login')

if (Mobile.verifyElementExist(newUiMsisdnObj, 10, FailureHandling.OPTIONAL)) {
    //New UI Login Input MSISDN
    Mobile.setText(newUiMsisdnObj, '083827388378', 0, FailureHandling.OPTIONAL)
} else {
	//Old UI Login Input MSISDN
	Mobile.setText(oldUiMsisdnObj, '083827388378', 0, FailureHandling.OPTIONAL)
}

Screenshot.takeScreenshot( 'Input msisdn')

'Tap Login'
def newUiBtnLogin = findTestObject('Mobile/Login/Login Page/ObjBtnLoginPage - Number (New UI)')

def oldUiBtnLogin = findTestObject('Mobile/Login/Login Page/ObjBtnLoginPage - Number')

if (Mobile.verifyElementExist(newUiBtnLogin, 3, FailureHandling.OPTIONAL)) {
    //New UI Login Button
    Mobile.tap(newUiBtnLogin, 0, FailureHandling.OPTIONAL) //Old UI Login Button
} else {
    Mobile.tap(oldUiBtnLogin, 0, FailureHandling.OPTIONAL)
}

// Check if the Login Rejection object is present
def RejectionReqOtp = findTestObject('Mobile/Login/Login Page/ObjLogin - Login Rejection (otp request)')

//def ErrConnection =
if (Mobile.verifyElementExist(RejectionReqOtp, 3, FailureHandling.OPTIONAL)) {
    // Delay for 33 seconds
    Mobile.delay(60)

    // Tap on the Login Page Number button
    Mobile.tap(findTestObject('Mobile/Login/Login Page/ObjBtnLoginPage - Number'), 5)
}

'Input Otp'
def newUiSetOtp = findTestObject('Mobile/Login/Login Page/ObjSetOtp - Set OTP Login (New UI)')

def oldUiSetOtp = findTestObject('Mobile/Login/Login Page/ObjSetOtp - Set OTP Login')

if (Mobile.verifyElementExist(newUiSetOtp, 3, FailureHandling.OPTIONAL)) {
    //New UI Set OTP
    Mobile.setText(newUiSetOtp, 'DT2022', 0)
} else {
	//Old UI Set OTP
    Mobile.setText(oldUiSetOtp, 'DT2022', 0)
}

Screenshot.takeScreenshot( 'Input OTP')

'Tap Lanjut'
def newUiBtnLanjut = findTestObject('Mobile/Login/Login Page/ObjBtnNext - LANJUT (New UI)')

def oldUiBtnLanjut = findTestObject('Mobile/Login/Login Page/ObjBtn - Lanjut (After OTP)')

if (Mobile.verifyElementExist(newUiBtnLanjut, 3, FailureHandling.OPTIONAL)) {
    //New UI Set OTP
    Mobile.tap(newUiBtnLanjut, 0, FailureHandling.OPTIONAL) //Old UI Set OTP
} else {
    Mobile.tap(oldUiBtnLanjut, 0, FailureHandling.OPTIONAL)
}

'Verfify success Login'
Mobile.waitForElementPresent(findTestObject('Mobile/Login/SuccessLogin'), 0)

Screenshot.takeScreenshot( 'Success Login')