import com.kms.katalon.core.annotation.BeforeTestCase
import com.kms.katalon.core.annotation.AfterTestCase
import com.kms.katalon.core.annotation.BeforeTestSuite
import com.kms.katalon.core.annotation.AfterTestSuite
import com.kms.katalon.core.context.TestCaseContext
import com.kms.katalon.core.context.TestSuiteContext
import com.kms.katalon.core.configuration.RunConfiguration

class TestCaseTracker {
	
	@BeforeTestSuite
	void beforeTestSuite(TestSuiteContext testSuiteContext) {
		println("Test Suite Started: ${testSuiteContext.getTestSuiteId()}")
		// Bersihkan file temporary saat suite dimulai
		clearCurrentTestCaseFile()
	}
	
	@BeforeTestCase
	void beforeTestCase(TestCaseContext testCaseContext) {
		try {
			String testCaseId = testCaseContext.getTestCaseId()
			if (testCaseId) {
				// Extract nama test case dari path
				String testCaseName = extractTestCaseName(testCaseId)
				
				// Simpan ke file temporary
				saveCurrentTestCaseToFile(testCaseName)
				
				println("📌 [TestCaseTracker] Starting Test Case: ${testCaseName}")
				println("📌 [TestCaseTracker] Full Path: ${testCaseId}")
			}
		} catch (Exception e) {
			println("⚠️ [TestCaseTracker] Error in BeforeTestCase: ${e.message}")
			e.printStackTrace()
		}
	}
	
	@AfterTestCase
	void afterTestCase(TestCaseContext testCaseContext) {
		println("✅ [TestCaseTracker] Finished Test Case")
		// Tidak perlu clear file di sini karena akan di-overwrite oleh test case berikutnya
	}
	
	@AfterTestSuite
	void afterTestSuite(TestSuiteContext testSuiteContext) {
		// Clear file saat suite selesai
		clearCurrentTestCaseFile()
		println("🏁 Test Suite Finished")
	}
	
	private String extractTestCaseName(String testCasePath) {
		// Hapus prefix "Test Cases/"
		String name = testCasePath.replaceFirst(/^Test Cases[\\\/]/, '')
		
		// Ambil nama file tanpa ekstensi .tc
		name = name.replaceAll(/.*[\\\/]/, '').replace('.tc', '')
		
		return name
	}
	
	private void saveCurrentTestCaseToFile(String testCaseName) {
		try {
			String projectDir = RunConfiguration.getProjectDir()
			File tempFile = new File(projectDir, "temp/current_testcase.txt")
			tempFile.getParentFile().mkdirs()
			tempFile.text = testCaseName
			println("[TestCaseTracker] Saved to file: ${tempFile.absolutePath}")
		} catch (Exception e) {
			println("[TestCaseTracker] Cannot save to file: ${e.message}")
		}
	}
	
	private void clearCurrentTestCaseFile() {
		try {
			String projectDir = RunConfiguration.getProjectDir()
			File tempFile = new File(projectDir, "temp/current_testcase.txt")
			if (tempFile.exists()) {
				tempFile.delete()
				println("[TestCaseTracker] Cleared temp file")
			}
		} catch (Exception e) {
			// Ignore
		}
	}
}