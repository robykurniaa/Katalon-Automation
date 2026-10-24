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

import javax.mail.BodyPart as BodyPart
import javax.mail.Folder as Folder
import javax.mail.Message as Message
import javax.mail.Session as Session
import javax.mail.Store as Store
import javax.mail.internet.MimeMultipart as MimeMultipart
import org.jsoup.Jsoup as Jsoup
import java.util.regex.Matcher as Matcher
import java.util.regex.Pattern as Pattern
import internal.GlobalVariable as GlobalVariable

String mailFolderName = 'INBOX'

String emailSubjectContent = 'Kode OTP Login MyXL Anda'

String emailContent = 'This is your OTP for Gmail: '

int lengthOfOTP = '6'

String hostName = 'imap.gmail.com' //change it according to your mail

String username = 'myxltest2@gmail.com' //username

String password = 'fofmlklezndizjof'

String searchText = null

Properties sysProps = new Properties()

sysProps.put('mail.store.protocol', 'imaps')

sysProps.put('mail.imaps.socketFactory.class', 'javax.net.ssl.SSLSocketFactory')

sysProps.put('mail.imaps.socketFactory.fallback', 'false')

sysProps.put('mail.imaps.port', '993')

sysProps.put('mail.imaps.socketFactory.port', '993')

Session session = Session.getDefaultInstance(sysProps, null)

//session.setDebug(true)
Store store = session.getStore('imaps')

store.connect(hostName, username, password)

Folder emailFolder = store.getFolder(mailFolderName)

emailFolder.open(Folder.READ_ONLY)

// retrieve the messages from the folder in an array and print it
Message[] messages = emailFolder.getMessages()

System.out.println('messages.length---' + messages.length)

int msglen = messages.length - 1

for (int i = msglen; i >= 0; i--) {
	Message message = messages[i]

	System.out.println('---------------------------------')

	//System.out.println('Email Number ' + (i + 1))
	//System.out.println('Subject: ' + message.getSubject())
	//System.out.println('From: ' + (message.getFrom()[0]))
	Object content = message.getContent()

	if (message.getSubject().startsWith(emailSubjectContent)) {
		if (content instanceof String) {
			System.out.println('Email Number ' + (i + 1))

			System.out.println('Subject: ' + message.getSubject())

			System.out.println('From: ' + (message.getFrom()[0]))

			System.out.println('Text: ' + content)

			break
		} else if (content instanceof MimeMultipart) {
			System.out.println('Email Number ' + (i + 1))

			System.out.println('Subject: ' + message.getSubject())

			System.out.println('From: ' + (message.getFrom()[0]))

			System.out.println('Text: ' + getMutipartMessage(content))

			intOTP = extractOTP(getMutipartMessage(content))

			System.out.println('OTP from Gmail is: ' + intOTP)

			break
		}
	}
}

//close the store and folder objects
emailFolder.close(false)

store.close()

def getMutipartMessage(MimeMultipart mimeMultipart) {
	String result = ''

	int count = mimeMultipart.getCount()

	for (def j : (0..count - 1)) {
		BodyPart bodyPart = mimeMultipart.getBodyPart(j)

		if (bodyPart.isMimeType('text/plain')) {
			result = ((result + '\n') + bodyPart.getContent())

			break
		} else if (bodyPart.isMimeType('text/html')) {
			String html = ((bodyPart.getContent()) as String)

			result = ((result + '\n') + Jsoup.parse(html).text())
		}
	}
	
	return result
}

def extractOTP(String msgcontent) {
	Pattern p1 = Pattern.compile('This is your OTP for Gmail: ([0-9]+)')

	Matcher m1 = p1.matcher(msgcontent)

	if (m1.find()) {
		return m1.group(1)
	}
}

