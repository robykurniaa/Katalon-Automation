import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
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
import java.text.NumberFormat
import java.text.DecimalFormat
import javax.mail.*
import javax.mail.internet.MimeMultipart
import java.util.Properties

'Open myXL'
Mobile.startApplication(GlobalVariable.APK, true)

email = GlobalVariable.satuFiberEmail
pin = GlobalVariable.validOTP
apps_password = 'gplwlczuxlcwsggt'
//email_recv = 'testingbigbang@gmail.com'


'Verify CVP'
if (Mobile.waitForElementPresent(findTestObject('null'), 0)) {
	'Screenshot CVP'
	Mobile.takeScreenshot()
		
	'Click Continue on CVP'
	Mobile.tap(findTestObject('null'), 0)
}
		
'Screenshot Login Landing'
Mobile.takeScreenshot()
	
'Click Login to myXL Button'
Mobile.tap(findTestObject('null'), 0)

'Verify Consent Half Card Login'
Mobile.waitForElementPresent(findTestObject('null'), 0)

'Click on Agree on Consent Half Card Login'
Mobile.tap(findTestObject('null'), 0)


'Verify Choose Login Segment Page'
Mobile.waitForElementPresent(findTestObject('null'), 0)

'Screenshot Choose Login Segment Page'
Mobile.takeScreenshot()

'Click Login Segment Page'
Mobile.tap(findTestObject('null'), 0)

Mobile.takeScreenshot()

'Click XL SATU FIBER Segment Button'
Mobile.tap(findTestObject('null'), 0)

'Verify Input Number Page'
Mobile.waitForElementPresent(findTestObject('null'), 0)

'Screenshot Input Number Page'
Mobile.takeScreenshot()

'Input XL Prepaid MSISDN'
Mobile.setText(findTestObject('null'), email , 0)

'Screenshot Success Input XL Prepaid MSISDN'
Mobile.takeScreenshot()

'Click Continue Button - Login'
Mobile.tap(findTestObject('null'), 0)

Thread.sleep(15000)
println email
def emailBody = readLatestEmailBody(email, apps_password, 'Inbox')
def pin = extractOTP(emailBody)
println(pin)

'Verify Input OTP Page'
Mobile.waitForElementPresent(findTestObject('null'), 0)

'Input OTP'
Mobile.setText(findTestObject('null'), pin, 0)

'Screenshot Success Input OTP'
Mobile.takeScreenshot()

Thread.sleep(15000)

'Wait for Pre-Welcoming Log In to Dashboard Button'
Mobile.waitForElementPresent(findTestObject('null'), 0)

'Take Screenshot'
Mobile.takeScreenshot()

'Click Log In to Dashboard Button'
Mobile.tap(findTestObject('null'), 0)

'Wait for Welcoming Page'
Mobile.waitForElementPresent(findTestObject('null'), 0)

'Take Screenshot'
Mobile.takeScreenshot()

'Click Learn it Now! button on Welcoming Page'
Mobile.tap(findTestObject('null'), 0)

'Take Screenshot'
Mobile.takeScreenshot()

'Skip Learning Page (Click Close)'
Mobile.tap(findTestObject('null'), 0)

'Handling Interstitial Page'
if (Mobile.waitForElementPresent(findTestObject('null'), 0, FailureHandling.OPTIONAL)) {
	
	'Take Screenshot'
	Mobile.takeScreenshot()
	
	'Close Interstitial Page'
	(Mobile.tap(findTestObject('null'), 0))
}

'Handling Pop Up Shared Quota'
if (Mobile.waitForElementPresent(findTestObject('null'), 0, FailureHandling.OPTIONAL)) {
	
	'Take Screenshot'
	Mobile.takeScreenshot()
	
	'Clik OK on Pop Up Shared Quota'
	(Mobile.tap(findTestObject('null'), 0))
}





def extractOTP(String text) {
	def matcher = (text =~ /OTP for Login is (\d{6}) valid/)

	if (matcher.find()) {
		return matcher.group(1)
	} else {
		return "OTP not found"
	}
}

def readLatestEmailBody(String email, String appPassword, String label) {
    def props = new Properties()
    props.setProperty('mail.imap.ssl.enable', 'true')
    def session = Session.getDefaultInstance(props, null)
    def store = session.getStore('imap')
    store.connect('imap.googlemail.com', 993, email, appPassword)

    // List available folders to debug
    def defaultFolder = store.getDefaultFolder()
    def folders = defaultFolder.list()
    println("Available folders:")
    folders.each { folder ->
        println("Folder: " + folder.name)
    }

    // Access the desired folder
    def folder = store.getFolder(label)
    if (!folder.exists()) {
        throw new Exception("Folder '$label' not found.")
    }
    folder.open(Folder.READ_ONLY)

    def message = folder.getMessage(folder.messageCount)
    def content = message.getContent()
    def emailBody = content.toString()
    folder.close(false)
    store.close()
    return emailBody.toString()
}

