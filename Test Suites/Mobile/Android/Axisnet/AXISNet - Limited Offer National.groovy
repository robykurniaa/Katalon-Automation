import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

/**
 * Run before each test case starts.
 */
@SetupTestCase(skipped = false)
def setUpTestCase() {
    // Pastikan ADB server ready sebelum test case dimulai
    KeywordUtil.logInfo("Preparing ADB server...")
    // Tidak perlu action khusus di sini
}

/**
 * Run after each test case ends.
 */
@TearDownTestCase(skipped = false)
def tearDownTestCase(TestCaseContext testCaseContext) {
    // Ambil status test case terakhir
    def testCaseStatus = testCaseContext.getTestCaseStatus()
    def errorMessage = testCaseContext.getTestCaseErrorMessage()
    
    KeywordUtil.logInfo("Test case selesai dengan status: ${testCaseStatus}")
    
    // Cek apakah test case gagal
    if (testCaseStatus == "FAILED") {
        KeywordUtil.logInfo("Error yang terjadi: ${errorMessage}")
        
        // Cek apakah error terkait ADB
        if (isAdbError(errorMessage)) {
            KeywordUtil.markWarning("⚠️ ADB error terdeteksi. Melakukan restart ADB server...")
            
            try {
                // Kill ADB server
                Runtime.getRuntime().exec("adb kill-server").waitFor()
                KeywordUtil.logInfo("ADB server dimatikan")
                
                Thread.sleep(2000)
                
                // Start ADB server
                Runtime.getRuntime().exec("adb start-server").waitFor()
                KeywordUtil.logInfo("ADB server dinyalakan kembali")
                
                Thread.sleep(3000)
                
                // Verifikasi device
                def process = Runtime.getRuntime().exec("adb devices")
                process.waitFor()
                def output = process.inputStream.text
                KeywordUtil.logInfo("Device terhubung:\n${output}")
                
                KeywordUtil.logInfo("✅ ADB server berhasil direstart")
                
                // Tutup aplikasi untuk membersihkan session
                try {
                    Mobile.closeApplication()
                } catch (Exception e) {
                    KeywordUtil.markWarning("Gagal menutup aplikasi (mungkin belum terbuka): ${e.getMessage()}")
                }
                
            } catch (Exception e) {
                KeywordUtil.markWarning("❌ Gagal restart ADB: ${e.getMessage()}")
            }
        } else {
            KeywordUtil.logInfo("Error bukan terkait ADB, tidak perlu restart")
        }
    }
}

/**
 * Cek apakah error message mengandung keyword ADB-related
 */
private boolean isAdbError(String errorMessage) {
    if (errorMessage == null) return false
    
    def adbKeywords = [
        "Unable to start app",
        "NoSuchSessionException",
        "session identified by",
        "device offline",
        "ADB server didn't ACK",
        "Failed to setup application",
        "Could not find a connected Android device"
    ]
    
    for (keyword in adbKeywords) {
        if (errorMessage.contains(keyword)) {
            return true
        }
    }
    
    return false
}