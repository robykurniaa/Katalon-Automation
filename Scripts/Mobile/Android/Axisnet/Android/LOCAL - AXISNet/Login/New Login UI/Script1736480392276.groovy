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
import customKeywords.LoginKeywords as Login
import customKeywords.PermissionKeywords as Permission

Login.isAppInstalled()

'Tap Start'
Mobile.tap(findTestObject('Mobile/Login/Login Page/ObjBtnLoginPage - Start'), 0, FailureHandling.OPTIONAL)

Screenshot.takeScreenshot('Login - Start')

'Input MSISDN'
def newUiMsisdnObj = findTestObject('Mobile/Login/Login Page/ObjLogin - Set Msisdn Login (New UI)')

def oldUiMsisdnObj = findTestObject('Mobile/Login/Login Page/ObjLogin - Set Msisdn Login')

//New UI Login Input MSISDN
Mobile.setText(newUiMsisdnObj, '083827388378', 0, FailureHandling.OPTIONAL)

Screenshot.takeScreenshot('Login - Input Msisdn')

'Tap Login'
def newUiBtnLogin = findTestObject('Mobile/Login/Login Page/ObjBtnLoginPage - Number (New UI)')

def oldUiBtnLogin = findTestObject('Mobile/Login/Login Page/ObjBtnLoginPage - Number')

//New UI Login Button
Mobile.tap(newUiBtnLogin, 0, FailureHandling.OPTIONAL)

// Check if the Login Rejection object is present
def RejectionReqOtp = findTestObject('Mobile/Login/Login Page/ObjLogin - Login Rejection (otp request)')

//def ErrConnection =
if (Mobile.verifyElementExist(RejectionReqOtp, 3, FailureHandling.OPTIONAL)) {
    // Delay for 6o seconds
    Mobile.delay(60)

    // Tap on the Login Page Number button
    Mobile.tap(findTestObject('Mobile/Login/Login Page/ObjBtnLoginPage - Number'), 5)
}

'Input Otp'
def newUiSetOtp = findTestObject('Object Repository/Mobile/Login/Login Page/newUiSetOtp')

def oldUiSetOtp = findTestObject('Mobile/Login/Login Page/ObjSetOtp - Set OTP Login')

//New UI Set OTP
Mobile.setText(oldUiSetOtp, 'DT2022', 0)

Screenshot.takeScreenshot('Login - Input OTP')

'Tap Lanjut'
def newUiBtnLanjut = findTestObject('Mobile/Login/Login Page/ObjBtnNext - LANJUT (New UI)')

def oldUiBtnLanjut = findTestObject('Mobile/Login/Login Page/ObjBtn - Lanjut (After OTP)')

//New UI Set OTP
Mobile.tap(newUiBtnLanjut, 0, FailureHandling.OPTIONAL)

'Verfify success Login'
Mobile.waitForElementPresent(findTestObject('Mobile/Login/SuccessLogin'), 0)

Screenshot.takeScreenshot('Login - Success Login')