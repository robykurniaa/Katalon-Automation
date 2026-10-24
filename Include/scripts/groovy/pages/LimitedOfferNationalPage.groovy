package pages

import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.configuration.RunConfiguration
import support.ExcelOfferParser
import limitedOffers.LimitedOfferBasePage
import java.io.File
import java.io.FilenameFilter

public class LimitedOfferNationalPage extends LimitedOfferBasePage {

	private List<Map<String, String>> excelPackages
	private String sheetName

	public LimitedOfferNationalPage(String sheetName = null) {
		this.sheetName = sheetName
		this.excelPackages = new ArrayList<>()
		loadFromExcel()
	}

	private void loadFromExcel() {
		String excelPath = findDynamicExcelFile()

		if (excelPath == null) {
			KeywordUtil.markWarning("${getLogPrefix()}: Failed to find the Excel file. Packages will be empty.")
			return
		}

		// PERBAIKAN: Gunakan format "d" untuk mendapatkan angka tanggal saja (Contoh: "3" atau "30")
		String todayDate = new java.text.SimpleDateFormat("d").format(new Date())

		KeywordUtil.logInfo("Loading packages from Excel: ${excelPath} | Filter Target: Tanggal ${todayDate}")

		this.excelPackages = ExcelOfferParser.getPackagesFromExcel(excelPath, this.sheetName, todayDate)
	}

	private String findDynamicExcelFile() {
		String folderPath = RunConfiguration.getProjectDir() + "/Data Files"
		File folder = new File(folderPath)

		if (!folder.exists()) {
			KeywordUtil.markWarning("Folder not found: ${folderPath}")
			return null
		}

		// Otomatis mencari file Excel terbaru yang namanya mengandung kata "nasional"
		File[] listOfFiles = folder.listFiles({ dir, name ->
			String lowerName = name.toLowerCase()
			return lowerName.contains("nasional") &&
					!lowerName.startsWith("~") &&
					lowerName.endsWith(".xlsx")
		} as FilenameFilter)

		if (listOfFiles == null || listOfFiles.length == 0) {
			KeywordUtil.markWarning("No matching Excel file found for National LO in ${folderPath}")
			return null
		}

		File latestFile = listOfFiles.sort { a, b -> b.lastModified() <=> a.lastModified() }.first()
		KeywordUtil.logInfo("Found dynamic Excel file: ${latestFile.getName()}")

		return latestFile.getAbsolutePath()
	}

	@Override
	protected List<Map<String, String>> getPackages() {
		if (this.excelPackages.isEmpty()) {
			KeywordUtil.markWarning("${getLogPrefix()}: No packages loaded from Excel.")
		}
		return this.excelPackages
	}

	@Override
	protected String getLogPrefix() {
		return "LO National"
	}

	// ================== PUBLIC CALLER METHODS ==================
	// Fungsi ini tetap dipertahankan agar test case lama kamu tidak error

	public static Set<String> handlingLoNasOnboarded(String targetSheetName = null) {
		return new LimitedOfferNationalPage(targetSheetName).validateAllPackages()
	}

	public static Set<String> handlingLoNasPackage(int index = 1, String targetSheetName = null) {
		return new LimitedOfferNationalPage(targetSheetName).tapPackageByIndex(index)
	}

	public static Set<String> handlingLoNasPackage(String packageName, String targetSheetName = null) {
		return new LimitedOfferNationalPage(targetSheetName).tapPackageByName(packageName)
	}
}