import com.kms.katalon.core.annotation.AfterTestCase
import com.kms.katalon.core.context.TestCaseContext
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import io.appium.java_client.AppiumDriver

class TeardownListener {

    /**
     * Mengeksekusi logika setelah setiap test case selesai dijalankan.
     * @param testCaseContext merepresentasikan konteks dari test case yang baru saja dijalankan.
     */
    @AfterTestCase
    def forceCloseOnFailure(TestCaseContext testCaseContext) {
        // Deteksi apakah status test case adalah FAILED atau ERROR
        def status = testCaseContext.getTestCaseStatus()
        
        if (status == 'FAILED' || status == 'ERROR') {
            println("[Teardown] Test Case '${testCaseContext.getTestCaseId()}' gagal.")
            println("[Teardown] Memulai proses force-close dan pembersihan sesi untuk mencegah cascading failure...")
            
            try {
                // Cek apakah driver mobile sedang aktif untuk menghindari NullPointerException
                if (MobileDriverFactory.getDriver() != null) {
                    
                    // 1. Tutup aplikasi menggunakan keyword bawaan Katalon (Soft Close)
                    try {
                        Mobile.closeApplication()
                        println("[Teardown] Aplikasi berhasil ditutup.")
                    } catch (Exception e) {
                        println("[Teardown] Gagal menutup aplikasi via closeApplication: " + e.getMessage())
                    }
                    
                    /* 
                     * Opsi: Force-Close langsung dari level Appium Driver (Hard Close)
                     * Aktifkan jika Mobile.closeApplication() tidak mempan mematikan background process.
                     */
                    
                    // 2. Matikan sesi Appium agar tidak ada Ghost Session (Mencegah "Unable to start app")
                    try {
                        def driver = MobileDriverFactory.getDriver()
                        if (driver != null) {
                            driver.quit()
                            println("[Teardown] Sesi Appium Driver berhasil diakhiri secara paksa (Anti-Ghost Session).")
                        }
                    } catch (Exception ex) {
                        println("[Teardown] Gagal mengakhiri sesi Appium (mungkin sudah terputus): " + ex.getMessage())
                    }
                    
                }
            } catch (Exception e) {
                println("[Teardown] Terjadi kesalahan fatal saat proses pembersihan: " + e.getMessage())
            }
        } else {
            println("[Teardown] Test Case sukses, melanjutkan ke test berikutnya tanpa force-close.")
        }
    }
}