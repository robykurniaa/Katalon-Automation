package tpr

import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.configuration.RunConfiguration
import java.io.File
import java.io.FilenameFilter
import support.ExcelOfferParser

import java.time.DayOfWeek
import java.time.ZonedDateTime
import java.time.ZoneId

public class TPRPackageManager {
	private static final Map<String, List<Map<String, String>>> TPR_PACKAGE_MAP = new LinkedHashMap<>()

	// ============ EXCEL INTEGRATION (LAZY LOADING) ============

	private static void loadFromExcel(String packageKey) {
		String keyword = ""
		String tabName = ""

		// Tentukan kata kunci pencarian file dan nama tab berdasarkan packageKey
		switch(packageKey) {
			case 'JUMAT_BAIK_ONBOARDED':
				keyword = "jumat baik"
				tabName = "JUMAT BAIK" // Pastikan nama sheet di Excel "JUMAT BAIK"
				break
			case 'RABU_RAWIT_ONBOARDED':
				keyword = "rawit"      
				tabName = "RAWIT"      // Sesuaikan dengan nama sheet di file Excel Rawit
				break
			case 'WEEKEND_SATURDAY':
				keyword = "saturday"   
				tabName = "BOOSTR WEEKEND"  
				break
			case 'WEEKEND_SUNDAY':
				keyword = "sunday"   
				tabName = "BOOSTR WEEKEND"  
				break
			default:
				KeywordUtil.logInfo("Unknown package key: ${packageKey}")
				return
		}

		String excelPath = findDynamicExcelFile(keyword)

		if (excelPath != null) {
			KeywordUtil.logInfo("Loading ${packageKey} from Excel: ${excelPath}")
			// Memanggil fungsi vertikal dari ExcelOfferParser
			List<Map<String, String>> packages = ExcelOfferParser.getPackagesFromVerticalExcel(excelPath, tabName)
			TPR_PACKAGE_MAP.put(packageKey, packages)
		} else {
			KeywordUtil.markWarning("Gagal memuat Excel untuk ${packageKey}. Pastikan file ada di folder Data Files.")
			TPR_PACKAGE_MAP.put(packageKey, new ArrayList<>()) // Isi array kosong agar tidak error null
		}
	}

	private static String findDynamicExcelFile(String expectedKeyword) {
		String folderPath = RunConfiguration.getProjectDir() + "/Data Files"
		File folder = new File(folderPath)

		if (!folder.exists()) {
			KeywordUtil.markWarning("Folder not found: ${folderPath}")
			return null
		}

		File[] listOfFiles = folder.listFiles({ dir, name ->
			String lowerName = name.toLowerCase()
			return lowerName.contains(expectedKeyword.toLowerCase()) &&
					!lowerName.startsWith("~") &&
					lowerName.endsWith(".xlsx")
		} as FilenameFilter)

		if (listOfFiles == null || listOfFiles.length == 0) {
			KeywordUtil.markWarning("No matching Excel file found for '${expectedKeyword}' in ${folderPath}")
			return null
		}

		File latestFile = listOfFiles.sort { a, b -> b.lastModified() <=> a.lastModified() }.first()
		return latestFile.getAbsolutePath()
	}

	// ============ CRUD OPERATIONS ============

	public static List getPackages(String key) {
		// LAZY LOADING: Jika paket belum ada di memori, baca dari Excel
		if (!TPR_PACKAGE_MAP.containsKey(key) || TPR_PACKAGE_MAP.get(key).isEmpty()) {
			loadFromExcel(key)
		}
		return TPR_PACKAGE_MAP.getOrDefault(key, Collections.emptyList())
	}

	public static Set<String> getRegisteredPackageKeys() {
		return new LinkedHashSet<>(TPR_PACKAGE_MAP.keySet())
	}

	public static void registerNewPackage(String packageKey, List<Map<String, String>> packages) {
		if (packageKey == null || packageKey.trim().isEmpty()) {
			throw new IllegalArgumentException('packageKey must be provided')
		}

		if (packages == null || packages.isEmpty()) {
			throw new IllegalArgumentException('packages must be provided')
		}

		TPR_PACKAGE_MAP.put(packageKey.trim(), new ArrayList<>(packages))
		KeywordUtil.logInfo("Registered new package: ${packageKey} with ${packages.size()} packages")
	}

	public static void removePackageKey(String packageKey) {
		if (TPR_PACKAGE_MAP.remove(packageKey) != null) {
			KeywordUtil.logInfo("Removed package key: ${packageKey}")
		} else {
			KeywordUtil.logInfo("Package key not found: ${packageKey}")
		}
	}

	public static void clearAllPackages() {
		TPR_PACKAGE_MAP.clear()
		KeywordUtil.logInfo("All TPR packages cleared")
	}

	// ============ HELPER METHODS ============

	public static String getWeekendPackageKey() {
		DayOfWeek today = ZonedDateTime.now(TPRConstants.JAKARTA_ZONE).getDayOfWeek()

		switch(today) {
			case DayOfWeek.SATURDAY:
				return 'WEEKEND_SATURDAY'
			case DayOfWeek.SUNDAY:
				return 'WEEKEND_SUNDAY'
			default:
				return ''
		}
	}

	public static Map<String, String> getPackageByIndex(String packageKey, int index) {
		List<Map<String, String>> packages = getPackages(packageKey)
		int adjustedIndex = index - 1
		if (adjustedIndex >= 0 && adjustedIndex < packages.size()) {
			return packages.get(adjustedIndex)
		}
		return null
	}

	public static Map<String, String> findPackageByIdentifier(String packageKey, Object identifier) {
		List<Map<String, String>> packages = getPackages(packageKey)

		if (identifier instanceof Integer) {
			int index = ((Integer) identifier) - 1
			if (index >= 0 && index < packages.size()) {
				return packages.get(index)
			}
		}

		if (identifier instanceof String) {
			String packageName = identifier.toString().trim()
			return packages.find { it['name']?.equalsIgnoreCase(packageName) }
		}

		return null
	}

	// ============ UTILITY METHODS ============

	public static void printTPRPackagesWithIndex(String packageKey) {
		List<Map<String, String>> packages = getPackages(packageKey)
		if (packages.isEmpty()) {
			KeywordUtil.logInfo("No packages found for ${packageKey}")
			return
		}

		KeywordUtil.logInfo("Packages for ${packageKey}:")
		for (int i = 0; i < packages.size(); i++) {
			Map<String, String> pkg = packages.get(i)
			KeywordUtil.logInfo("  ${i + 1}. ${pkg['name']} - ${pkg['price']}")
		}
	}

	public static void printAllTPRPackages() {
		if (TPR_PACKAGE_MAP.isEmpty()) {
			KeywordUtil.logInfo("No TPR packages registered")
			return
		}

		KeywordUtil.logInfo("\n=== ALL TPR PACKAGES ===")
		TPR_PACKAGE_MAP.each { key, packages ->
			KeywordUtil.logInfo("\n${key} (${packages.size()} packages):")
			packages.eachWithIndex { pkg, i ->
				KeywordUtil.logInfo("  ${i + 1}. ${pkg['name']} - ${pkg['price']}")
			}
		}
	}

	public static String formatPackageList(String packageKey) {
		List<Map<String, String>> packages = getPackages(packageKey)
		if (packages.isEmpty()) {
			return "No packages"
		}

		List<String> packageDetails = packages.collect { "${it['name']} (${it['price']})" }
		return packageDetails.join(', ')
	}
}