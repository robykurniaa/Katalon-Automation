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
import java.text.NumberFormat as NumberFormat
import java.text.DecimalFormat as DecimalFormat
import javax.mail.*
import javax.mail.internet.MimeMessage as MimeMessage
import java.util.Properties as Properties
import java.util.regex.Matcher as Matcher
import java.util.regex.Pattern as Pattern
import com.kms.katalon.core.webui.driver.DriverFactory
import groovy.json.JsonOutput
import axisnet_support.LocatorPaths as Locator
import web_connectivity_support.inputOtp as OTP


WebUI.openBrowser('')

WebUI.maximizeWindow()

apps_password = GlobalVariable.apps_password

email = GlobalVariable.email

WebUI.navigateToUrl('https://connectivityplus.xl.co.id/dashboard')

WebUI.delay(5)

WebUI.setText(findTestObject('Object Repository/Web Connectivity/Login/Login - Username'), 'robby.eksternal')

WebUI.setText(findTestObject('Object Repository/Web Connectivity/Login/Login - Password'),
	'robYk@222015')

WebUI.click(findTestObject('Object Repository/Web Connectivity/Login/Button Login'))

Thread.sleep(4000)

Thread.sleep(20000)

println(email)

def emailBody = readLatestEmailBody(email, apps_password, 'Inbox')

println(emailBody)

def pin = extractOTP2(emailBody)

println(pin)

// ===== INPUT OTP PER DIGIT PAKE CUSTOM KEYWORD =====
OTP.inputOTP(pin)

WebUI.click(findTestObject('Object Repository/Web Connectivity/Login/Button verify'))

// 2️⃣ Ambil cookies dari browser
def driver = DriverFactory.getWebDriver()
def cookies = driver.manage().getCookies()

// 3️⃣ Simpan cookies ke file JSON
def cookieList = []
cookies.each { c ->
	cookieList << [
		name: c.name,
		value: c.value,
		domain: c.domain,
		path: c.path,
		expiry: c.expiry?.time,
		isSecure: c.secure,
		isHttpOnly: c.isHttpOnly()
	]
}

def json = JsonOutput.prettyPrint(JsonOutput.toJson(cookieList))
new File('saved_cookies.json').text = json

WebUI.comment("Cookies disimpan ke file saved_cookies.json (${cookieList.size()} cookies)")

// ===== FUNCTIONS =====

def extractOTP2(def inputText) {
	Pattern pattern = Pattern.compile('\\d{6}')

	Matcher matcher = pattern.matcher(inputText)

	if (matcher.find()) {
		String otp = matcher.group()

		return otp
	} else {
		return 'OTP not found in the message.'
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