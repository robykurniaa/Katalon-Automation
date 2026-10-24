import com.kms.katalon.core.annotation.AfterTestCase
import com.kms.katalon.core.annotation.AfterTestSuite
import com.kms.katalon.core.annotation.BeforeTestSuite
import com.kms.katalon.core.context.TestCaseContext
import com.kms.katalon.core.context.TestSuiteContext

import javax.mail.*
import javax.mail.internet.*
import java.util.Properties
import java.util.Date
import java.text.SimpleDateFormat
import java.util.TimeZone
import java.util.concurrent.TimeUnit

class CustomEmailListener {

	// Global variables for this listener
	List testCaseResults = []
	long suiteStartTime = 0

	@BeforeTestSuite
	def sampleBeforeTestSuite(TestSuiteContext testSuiteContext) {
		testCaseResults.clear()
		// Record the start time when a new Test Suite begins
		suiteStartTime = System.currentTimeMillis()
	}

	@AfterTestCase
	def sampleAfterTestCase(TestCaseContext testCaseContext) {
		String testCaseId = testCaseContext.getTestCaseId()
		String[] pathParts = testCaseId.split('/')
		String testCaseName = pathParts[pathParts.length - 1]
		String testCaseStatus = testCaseContext.getTestCaseStatus()

		// Store name and status in a Map for the HTML table
		Map<String, String> testData = new HashMap<>()
		testData.put("name", testCaseName)
		testData.put("status", testCaseStatus)
		testCaseResults.add(testData)
	}

	@AfterTestSuite
	def sampleAfterTestSuite(TestSuiteContext testSuiteContext) {
		String suiteStatus = testSuiteContext.getStatus()
		String fullSuiteName = testSuiteContext.getTestSuiteId()

		// Extract the final part of the suite path as the suite name
		String[] suiteParts = fullSuiteName.split('/')
		String suiteName = suiteParts[suiteParts.length - 1]

		// 1. Calculate Metrics (Pass/Fail/Skip counts)
		int totalTests = testCaseResults.size()
		int passedTests = 0
		int failedTests = 0
		int skippedTests = 0

		for (Map<String, String> tc : testCaseResults) {
			String status = tc.get("status")
			if (status.equals("PASSED")) {
				passedTests++
			} else if (status.equals("FAILED") || status.equals("ERROR")) {
				failedTests++
			} else {
				skippedTests++
			}
		}

		// 2. Calculate Duration (Format: 1m 25.039s)
		long endTimeMillis = System.currentTimeMillis()
		long durationMillis = endTimeMillis - suiteStartTime

		long minutes = TimeUnit.MILLISECONDS.toMinutes(durationMillis)
		long seconds = TimeUnit.MILLISECONDS.toSeconds(durationMillis) - TimeUnit.MINUTES.toSeconds(minutes)
		long millis = durationMillis % 1000
		String durationStr = String.format("%dm %d.%03ds", minutes, seconds, millis)

		// 3. Format Start Time with Timezone (Example: Wednesday, 19 August 2026 at 09:00 WIB)
		SimpleDateFormat sdf = new SimpleDateFormat("EEEE, dd MMMM yyyy 'at' HH:mm 'WIB'", Locale.ENGLISH)
		sdf.setTimeZone(TimeZone.getTimeZone("Asia/Jakarta"))
		String startTimeStr = sdf.format(new Date(suiteStartTime))

		// 4. Header Text and Color Configuration
		String headerColor = ""
		String headerText = suiteStatus // Defaults to "PASSED" or "FAILED"

		if (suiteStatus.equals("PASSED")) {
			headerColor = "#3b4cca" // Blue color for PASSED
		} else if (suiteStatus.equals("FAILED") || suiteStatus.equals("ERROR")) {
			headerColor = "#b3002d" // Dark Red color for FAILED/ERROR
		} else {
			headerColor = "#1084de" // Blue color
			headerText = "COMPLETE" // Custom COMPLETE text
		}

		// 5. Construct HTML Email Body
		StringBuilder emailBody = new StringBuilder()
		emailBody.append("<html><body style='font-family: Arial, sans-serif; color: #333;'>")

		// Greeting & Intro (Updated Copywriting)
		emailBody.append("<p style='font-weight: bold; font-size: 15px;'>Dear All,</p>")
		emailBody.append("<p>Automation Test already done.<br>Here is the summary report.</p>")

		// Summary Report Table
		emailBody.append("<table border='1' cellpadding='8' cellspacing='0' style='border-collapse: collapse; width: 100%; max-width: 650px; border-color: #555;'>")

		// Main Header
		emailBody.append("<tr style='background-color: " + headerColor + "; color: white;'><th colspan='2' style='text-align: left; font-size: 15px; text-transform: uppercase;'>" + headerText + "</th></tr>")

		// Table Rows
		emailBody.append("<tr><td style='width: 25%; font-weight: bold; background-color: #f2f2f2;'>Test Name</td><td>" + suiteName + "</td></tr>")
		emailBody.append("<tr><td style='font-weight: bold; background-color: #f2f2f2;'>Start time</td><td>" + startTimeStr + "</td></tr>")
		emailBody.append("<tr><td style='font-weight: bold; background-color: #f2f2f2;'>Duration</td><td>" + durationStr + "</td></tr>")

		// Metrics Summary Row
		String metricsHtml = String.format("<b>Total: %d</b> | <span style='color: #28a745;'>Passed: %d</span> | <span style='color: #dc3545;'>Failed: %d</span> | <span style='color: #6c757d;'>Skipped: %d</span>", totalTests, passedTests, failedTests, skippedTests)
		emailBody.append("<tr><td style='font-weight: bold; background-color: #f2f2f2;'>Test Results</td><td>" + metricsHtml + "</td></tr>")

		emailBody.append("</table>")

		// Test Case Details Table
		emailBody.append("<br/><h3>Test Case Details:</h3>")
		emailBody.append("<table border='1' cellpadding='8' cellspacing='0' style='border-collapse: collapse; width: 100%; max-width: 650px; border-color: #555;'>")
		emailBody.append("<tr style='background-color: #e6e6e6;'><th style='text-align: left;'>Test Case Name</th><th style='text-align: center; width: 25%;'>Status</th></tr>")

		for (Map<String, String> tc : testCaseResults) {
			String tcStatus = tc.get("status")
			String statusColor = tcStatus.equals("PASSED") ? "#28a745" : (tcStatus.equals("FAILED") ? "#dc3545" : "#333")

			emailBody.append("<tr>")
			emailBody.append("<td>" + tc.get("name") + "</td>")
			emailBody.append("<td style='text-align: center; font-weight: bold; color: " + statusColor + ";'>" + tcStatus + "</td>")
			emailBody.append("</tr>")
		}
		emailBody.append("</table>")

		// Closing & Signature (Updated Copywriting)
		emailBody.append("<p style='margin-top: 25px;'>Please refer to the Katalon automated email for the detailed PDF evidence.</p>")
		emailBody.append("<p style='margin-top: 20px;'>Best Regards,<br><b>AXISNet QA</b></p>")

		emailBody.append("</body></html>")

		//TODO 6. Send Email
		String emailSubject = "Katalon Report: " + suiteName + " [" + headerText + "]"
		sendCustomEmail("robykurniaaa@gmail.com, adl.robbykur@xlsmart.co.id, robby.kurnia@amartek.id", emailSubject, emailBody.toString())
	}

	def sendCustomEmail(String toEmail, String subject, String emailBody) {
		// OFFICE365 SMTP CONFIGURATION
		String host = "smtp.office365.com"
		String port = "587"
		String senderEmail = "adl.robbykur@xlsmart.co.id"
		String senderPassword = "mymrrfzhzfrmchfj"

		Properties props = new Properties()
		props.put("mail.smtp.auth", "true")
		props.put("mail.smtp.starttls.enable", "true")
		props.put("mail.smtp.host", host)
		props.put("mail.smtp.port", port)

		Session session = Session.getInstance(props,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(senderEmail, senderPassword)
					}
				})

		try {
			Message message = new MimeMessage(session)
			message.setFrom(new InternetAddress(senderEmail))
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail))
			message.setSubject(subject)

			// Set content as HTML
			message.setContent(emailBody, "text/html; charset=utf-8")

			Transport.send(message)
			println("--> [SUCCESS] Custom HTML Email Report successfully sent to: " + toEmail)
		} catch (MessagingException e) {
			println("--> [ERROR] Failed to send Custom Email: " + e.getMessage())
			e.printStackTrace()
		}
	}
}