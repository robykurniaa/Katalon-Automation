import com.katalon.extent.ExtentReportManager
import com.kms.katalon.core.annotation.*
import com.kms.katalon.core.context.*

class ExtentReportListener {


@BeforeTestSuite
def beforeSuite(TestSuiteContext suite) {
    ExtentReportManager.startSuite(suite, "Extent Report", "KSE2 QA Test Report")
}

@BeforeTestCase
def beforeCase(TestCaseContext testCase) {
    ExtentReportManager.startTestCase(testCase)
}

@AfterTestCase
def afterCase(TestCaseContext testCase) {
    ExtentReportManager.endTestCase(testCase)
}

@AfterTestSuite
def afterSuite(TestSuiteContext suite) {
    ExtentReportManager.endSuite()
}
}