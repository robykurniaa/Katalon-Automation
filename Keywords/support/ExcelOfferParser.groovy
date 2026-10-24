package support

import java.io.File
import java.io.FileInputStream
import org.apache.poi.ss.usermodel.*
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import com.kms.katalon.core.util.KeywordUtil
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.util.regex.Matcher
import java.util.regex.Pattern

public class ExcelOfferParser {

	// =================================================================================
	// 1. FUNGSI HORIZONTAL (Untuk Limited Offer National & Selected Cities)
	// =================================================================================
	public static List<Map<String, String>> getPackagesFromExcel(String filePath, String sheetName = null, String targetDate = null) {
		List<Map<String, String>> packages = new ArrayList<>()
		FileInputStream fis = null
		Workbook workbook = null

		try {
			fis = new FileInputStream(new File(filePath))
			workbook = new XSSFWorkbook(fis)
			Sheet sheet = sheetName != null ? workbook.getSheet(sheetName) : workbook.getSheetAt(0)

			if (sheet == null) {
				KeywordUtil.markWarning("Sheet not found in Excel file!")
				return packages
			}

			Row promoLabelRow = null
			Row priceRow = null
			int promoLabelRowIndex = -1
			int priceRowIndex = -1

			for (Row row : sheet) {
				Cell firstCell = row.getCell(0)
				if (firstCell != null && firstCell.getCellType() == CellType.STRING) {
					String cellValue = firstCell.getStringCellValue().trim()
					if (cellValue.equalsIgnoreCase("Promo Items")) {
						promoLabelRow = row
						promoLabelRowIndex = row.getRowNum()
					} else if (cellValue.equalsIgnoreCase("Disc price")) {
						priceRow = row
						priceRowIndex = row.getRowNum()
					}
				}
			}

			if (promoLabelRow == null || priceRow == null) {
				KeywordUtil.markWarning("Could not find 'Promo Items' or 'Disc price' headers in Column A.")
				return packages
			}

			// Cari Baris Nama Paket (Bisa sejajar dengan "Promo Items" atau 1-2 baris di bawahnya)
			Row nameRow = sheet.getRow(promoLabelRowIndex)
			int nameRowIndex = promoLabelRowIndex

			for (int r = promoLabelRowIndex; r < priceRowIndex; r++) {
				Row tempRow = sheet.getRow(r)
				if (tempRow == null) continue

					Cell checkCell = tempRow.getCell(1) // Cek kolom B
				if (checkCell != null && checkCell.getCellType() == CellType.STRING) {
					String val = checkCell.getStringCellValue().trim()
					if (!val.isEmpty() && !val.contains("00:00") && val.length() > 5 && !val.matches(".*\\d{1,2}\\s+[a-zA-Z]{3}.*")) {
						nameRow = tempRow
						nameRowIndex = r
						break
					}
				}
			}

			// PENCARIAN BARIS TANGGAL FLEKSIBEL
			Row dateRow = promoLabelRow
			for (int r = promoLabelRowIndex; r < nameRowIndex; r++) {
				Row tempRow = sheet.getRow(r)
				if (tempRow == null) continue

					Cell checkCell = tempRow.getCell(1)
				if (checkCell != null) {
					if (checkCell.getCellType() == CellType.NUMERIC && DateUtil.isCellDateFormatted(checkCell)) {
						dateRow = tempRow
						break
					} else if (checkCell.getCellType() == CellType.STRING && checkCell.getStringCellValue().trim().matches(".*\\d+.*")) {
						dateRow = tempRow
						break
					}
				}
			}

			int maxCol = nameRow.getLastCellNum()
			String activeDateCategory = ""
			Set<String> detectedDates = new LinkedHashSet<>()
			DataFormatter formatter = new DataFormatter(Locale.ENGLISH)

			// Looping data kolom per kolom ke samping
			for (int i = 1; i < maxCol; i++) {
				// BACA TANGGAL DARI MERGED CELLS
				if (dateRow != null) {
					Cell dateCell = dateRow.getCell(i)
					if (dateCell != null && dateCell.getCellType() != CellType.BLANK) {
						String tempDateVal = ""

						if (dateCell.getCellType() == CellType.NUMERIC && DateUtil.isCellDateFormatted(dateCell)) {
							tempDateVal = new java.text.SimpleDateFormat("d").format(dateCell.getDateCellValue())
						} else {
							String dVal = formatter.formatCellValue(dateCell).trim()
							Matcher m = Pattern.compile("\\d+").matcher(dVal)
							if (m.find()) tempDateVal = m.group()
						}

						if (!tempDateVal.isEmpty()) {
							try {
								activeDateCategory = Integer.parseInt(tempDateVal).toString()
								detectedDates.add(activeDateCategory)
							} catch (Exception ignore) {}
						}
					}
				}

				// FILTER TANGGAL
				if (targetDate != null && !targetDate.isEmpty() && !activeDateCategory.equals(targetDate)) {
					continue
				}

				// BACA NAMA PAKET & HARGA
				Cell nameCell = nameRow.getCell(i)
				Cell priceCell = priceRow.getCell(i)

				if (nameCell != null && priceCell != null) {
					String name = formatter.formatCellValue(nameCell).trim()
					String rawPrice = formatter.formatCellValue(priceCell).trim()

					if (!name.isEmpty() && !rawPrice.isEmpty()) {
						Map<String, String> pkg = new LinkedHashMap<>()
						pkg.put("name", name)
						pkg.put("price", formatCurrencyIDR(rawPrice))
						packages.add(pkg)
					}
				}
			}

			KeywordUtil.logInfo("Detected Date Numbers in Excel: " + detectedDates.toString())
			KeywordUtil.logInfo("Successfully loaded ${packages.size()} packages" + (targetDate ? " for date ${targetDate}" : "") + " (Horizontal).")
		} catch (Exception e) {
			KeywordUtil.markWarning("Failed to read Horizontal Excel data: " + e.getMessage())
		} finally {
			if (workbook != null) workbook.close()
			if (fis != null) fis.close()
		}

		return packages
	}


	// =================================================================================
	// 2. FUNGSI VERTIKAL (Untuk TPR: Jumat Baik, Rabu Rawit, Boostr Weekend, dll)
	// =================================================================================
	public static List<Map<String, String>> getPackagesFromVerticalExcel(String filePath, String expectedSheetName) {
		List<Map<String, String>> packages = new ArrayList<>()
		FileInputStream fis = null
		Workbook workbook = null

		try {
			fis = new FileInputStream(new File(filePath))
			workbook = new XSSFWorkbook(fis)

			// PENCARIAN TAB FLEKSIBEL
			Sheet sheet = null
			for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
				String currentSheetName = workbook.getSheetName(i)
				if (currentSheetName.toLowerCase().contains(expectedSheetName.toLowerCase())) {
					sheet = workbook.getSheetAt(i)
					KeywordUtil.logInfo("Ditemukan tab yang cocok: '${currentSheetName}' untuk keyword '${expectedSheetName}'")
					break
				}
			}

			if (sheet == null) {
				KeywordUtil.markWarning("Sheet yang mengandung kata '${expectedSheetName}' tidak ditemukan di file Excel!")
				return packages
			}

			int nameColIndex = -1
			int priceColIndex = -1
			boolean isHeaderFound = false
			DataFormatter formatter = new DataFormatter(Locale.ENGLISH)

			for (Row row : sheet) {
				// 1. PENCARIAN DINAMIS KOLOM HEADER
				if (!isHeaderFound) {
					for (int c = 0; c < row.getLastCellNum(); c++) {
						Cell cell = row.getCell(c)
						if (cell != null && cell.getCellType() == CellType.STRING) {
							String val = cell.getStringCellValue().trim()
							if (val.equalsIgnoreCase("Marketing Name")) nameColIndex = c
							else if (val.equalsIgnoreCase("Price")) priceColIndex = c
						}
					}

					if (nameColIndex != -1 && priceColIndex != -1) {
						isHeaderFound = true
						KeywordUtil.logInfo("Header Vertikal ditemukan! Name di Kolom ${nameColIndex}, Price di Kolom ${priceColIndex}")
					}
					continue
				}

				// 2. BACA DATA BARIS PER BARIS
				Cell nameCell = row.getCell(nameColIndex)
				Cell priceCell = row.getCell(priceColIndex)

				if (nameCell != null && priceCell != null) {
					String name = formatter.formatCellValue(nameCell).trim()
					String rawPrice = formatter.formatCellValue(priceCell).trim()

					if (!name.isEmpty() && !rawPrice.isEmpty() && !name.equalsIgnoreCase("Marketing Name")) {
						Map<String, String> pkg = new LinkedHashMap<>()
						pkg.put("name", name)
						pkg.put("price", formatCurrencyIDR(rawPrice))
						packages.add(pkg)
					}
				}
			}

			KeywordUtil.logInfo("Successfully loaded ${packages.size()} packages from verical tab .")
		} catch (Exception e) {
			KeywordUtil.markWarning("failed read excel data (vertical): " + e.getMessage())
		} finally {
			if (workbook != null) workbook.close()
			if (fis != null) fis.close()
		}

		return packages
	}

	private static String formatCurrencyIDR(String rawPrice) {
		String cleanNumber = rawPrice.replaceAll("[^0-9]", "")
		if (cleanNumber.isEmpty()) {
			return rawPrice
		}

		DecimalFormat idrFormat = new DecimalFormat("#,###")
		DecimalFormatSymbols symbols = new DecimalFormatSymbols()
		symbols.setGroupingSeparator('.' as char)
		idrFormat.setDecimalFormatSymbols(symbols)

		return "Rp" + idrFormat.format(Long.parseLong(cleanNumber))
	}
}