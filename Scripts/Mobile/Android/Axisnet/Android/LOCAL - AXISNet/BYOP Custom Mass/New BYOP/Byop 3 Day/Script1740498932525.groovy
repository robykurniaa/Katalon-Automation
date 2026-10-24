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
import customKeywords.SwipeHelper as Swipe
import customKeywords.ScreenshotKeywords as Screenshot
import customKeywords.ScreenshotKeywords as TestCase
import customKeywords.LoginKeywords as Login
import customKeywords.MedalliaHandling as Medallia

TestCase.setTestCaseName("Purchase Byop 3 Day")

'Login Axis Net'
Login.openExistingApp('083869516739', 'DT2022')

'Pop Up Handling'
Mobile.callTestCase(findTestCase('Test Cases/Mobile/LOCAL - AXISNet/Homepage handler/Press Back'), [:], FailureHandling.CONTINUE_ON_FAILURE)

'medallia handling'
Medallia.closeMedallia()

Screenshot.takeScreenshot('Byop 3Hr - Homepage')

Mobile.tap(findTestObject('Object Repository/Mobile/Byop/New Byop/android.widget.TextView - Paket Suka-Suka'), 0)

Mobile.tap(findTestObject('Object Repository/Mobile/Byop/New Byop/android.widget.ImageView'), 0)
Screenshot.takeScreenshot('Byop Page')

Mobile.tap(findTestObject('Object Repository/Mobile/Byop/New Byop/android.widget.LinearLayout'), 0)
Screenshot.takeScreenshot('Choose main kuota')

Mobile.tap(findTestObject('Object Repository/Mobile/Byop/New Byop/android.view.View'), 0)

Mobile.scrollToText('Tambahin')

Mobile.tap(findTestObject('Object Repository/Mobile/Byop/New Byop/android.widget.TextView - Tambahin kuota pelengkap'), 
    0)

Screenshot.takeScreenshot('Add Ons')

Mobile.scrollToText('conference')

Mobile.tap(findTestObject('Object Repository/Mobile/Byop/New Byop/android.widget.ImageView (1)'), 0)
Screenshot.takeScreenshot('Choose Add Ons')

Mobile.tap(findTestObject('Object Repository/Mobile/Byop/New Byop/androidx.appcompat.widget.LinearLayoutCompat'), 0)

Mobile.tap(findTestObject('Object Repository/Mobile/Byop/New Byop/android.widget.Button - TAMBAH'), 0)

Mobile.tap(findTestObject('Object Repository/Mobile/Byop/New Byop/android.widget.Button - LANJUT'), 0)

Mobile.scrollToText('aktivasi sekarang')
Screenshot.takeScreenshot('Confirmation')

Mobile.tap(findTestObject('Object Repository/Mobile/Byop/New Byop/android.widget.Button - AKTIVASI SEKARANG'), 0)

Mobile.tap(findTestObject('Object Repository/Mobile/Byop/New Byop/android.widget.Button - LAIN KALI'), 0)

Mobile.tap(findTestObject('Object Repository/Mobile/Byop/New Byop/android.widget.Button - AKTIVASI SEKARANG'), 0)
Mobile.delay(3)
Screenshot.takeScreenshot('Receipt Page')


