package limitedOffers

import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.configuration.RunConfiguration
import support.ExcelOfferParser
import java.io.File
import java.io.FilenameFilter

public class LimitedOfferSelectedCitiesPage extends LimitedOfferBasePage {
    
    private String loKey
    private String sheetName
    private List<Map<String, String>> excelPackages
    
    // ================== CONSTRUCTORS ==================
    public LimitedOfferSelectedCitiesPage(String loKey, String sheetName = null) {
        this.loKey = loKey
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
        
        KeywordUtil.logInfo("Loading packages from Excel: ${excelPath}")
        this.excelPackages = ExcelOfferParser.getPackagesFromExcel(excelPath, this.sheetName)
    }

    private String findDynamicExcelFile() {
        String folderPath = RunConfiguration.getProjectDir() + "/Data Files"
        File folder = new File(folderPath)
        
        if (!folder.exists()) {
            KeywordUtil.markWarning("Folder not found: ${folderPath}")
            return null
        }

        // Extract numbers from loKey (e.g., "LO72" becomes "72")
        String cityNumber = this.loKey.replaceAll("[^0-9]", "")
        
        // Expected string in filename, e.g., "72 cities"
        String expectedKeyword = "${cityNumber} cities"

        File[] listOfFiles = folder.listFiles({ dir, name -> 
            String lowerName = name.toLowerCase()
            // Detect file based on the extracted city number
            return lowerName.contains(expectedKeyword) && 
                   !lowerName.startsWith("~") && 
                   lowerName.endsWith(".xlsx")
        } as FilenameFilter)

        if (listOfFiles == null || listOfFiles.length == 0) {
            KeywordUtil.markWarning("No matching Excel file found for '${expectedKeyword}' in ${folderPath}")
            return null
        }

        File latestFile = listOfFiles.sort { a, b -> b.lastModified() <=> a.lastModified() }.first()
        KeywordUtil.logInfo("Found dynamic Excel file: ${latestFile.getName()}")
        
        return latestFile.getAbsolutePath()
    }
    
    // ================== IMPLEMENT ABSTRACT METHODS ==================
    @Override
    protected List<Map<String, String>> getPackages() {
        if (this.excelPackages.isEmpty()) {
            KeywordUtil.markWarning("${getLogPrefix()}: No packages loaded from Excel.")
        }
        return this.excelPackages
    }
    
    @Override
    protected String getLogPrefix() {
        return "LO ${loKey}"
    }
    
    // ================== PUBLIC METHODS ==================
    public static Set<String> handleLOCities(String key, String targetSheetName = null) {
        return new LimitedOfferSelectedCitiesPage(key, targetSheetName).validateAllPackages()
    }
    
    public static Set<String> handleLOCitiesPackage(String key, int index = 1, String targetSheetName = null) {
        return new LimitedOfferSelectedCitiesPage(key, targetSheetName).tapPackageByIndex(index)
    }
}