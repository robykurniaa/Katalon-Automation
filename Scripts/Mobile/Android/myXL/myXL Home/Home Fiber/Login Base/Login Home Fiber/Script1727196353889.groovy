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


email = GlobalVariable.homeFiberEmail
pin = GlobalVariable.validOTP
apps_password = 'auzc ynbq uokc yshw'
email_recv = 'testingbigbang@gmail.com'

try {
	Mobile.tap(findTestObject('Object Repository/PREPAID/etc/validate text exist', [('text') : 'NO']), 0)
} catch (Exception e) {
}

Thread.sleep(15000)
try {
	'tap Lets Start'
	Mobile.tap(findTestObject('Object Repository/PREPAID/landing page/button - Lets Start'), 15)
} catch (Exception e) {
	'tap Lets Start'
	Mobile.tap(findTestObject('Object Repository/PREPAID/landing page/button - Lets Start'), 10)
}


'Login prepaid valid'
WebUI.callTestCase(findTestCase('Test Cases/DT/etc/input valid email home fiber'), [('email'):email ], FailureHandling.STOP_ON_FAILURE)

Thread.sleep(15000)
println email
def emailBody = readLatestEmailBody(email_recv, apps_password, 'testread')
def pin = extractOTP(emailBody)
println(pin)

'Input PIN valid'
WebUI.callTestCase(findTestCase('Test Cases/DT/etc/Input PIN valid'), [('pin'):pin ], FailureHandling.STOP_ON_FAILURE)

Thread.sleep(15000)

try {
	Mobile.tap(findTestObject('Object Repository/PREPAID/etc/validate text exist', [('text') : 'Isi Survey']), 0)
	Mobile.pressBack()
} catch (Exception e) {
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
	store.connect('imap.gmail.com', 993, email, appPassword)
	def folder = store.getFolder(label)
	folder.open(Folder.READ_ONLY)
	def message = folder.getMessage(folder.messageCount)
	def content = message.getContent()
	def emailBody = content.toString()
	folder.close(false)
	store.close()
	return emailBody.toString()
}

