package tpr

import com.kms.katalon.core.util.KeywordUtil

public class TPRPackageHandler {

	// ============ SIMPLIFIED PUBLIC API ============

	public static Set<String> handleJumatBaikOnboarded() {
		return handlePackageValidation('JUMAT_BAIK_ONBOARDED')
	}

	public static Set<String> handleJumatBaikPackage(int index = 1) {
		return handlePackageSelection('JUMAT_BAIK_ONBOARDED', index)
	}

	public static Set<String> handleRabuRawitOnboarded() {
		return handlePackageValidation('RABU_RAWIT_ONBOARDED')
	}

	public static Set<String> handleRabuRawitPackage(int index = 1) {
		return handlePackageSelection('RABU_RAWIT_ONBOARDED', index)
	}

	public static Set<String> handleBoostrWeekendOnboarded() {
		String packageKey = TPRPackageManager.getWeekendPackageKey()
		if (packageKey.isEmpty()) {
			KeywordUtil.logInfo("No weekend packages available for today")
			return Collections.emptySet()
		}
		return handlePackageValidation(packageKey)
	}

	public static Set<String> handleBoostrWeekendPackage(int index = 1) {
		String packageKey = TPRPackageManager.getWeekendPackageKey()
		if (packageKey.isEmpty()) {
			KeywordUtil.logInfo("No weekend packages available for today")
			return Collections.emptySet()
		}
		return handlePackageSelection(packageKey, index)
	}

	// ============ GENERIC HANDLERS ============

	public static Set<String> handlePackageValidation(String packageKey) {
		List<Map<String, String>> packages = TPRPackageManager.getPackages(packageKey)
		if (packages.isEmpty()) {
			KeywordUtil.logInfo("No packages found for key: ${packageKey}")
			return Collections.emptySet()
		}

		// KEMBALI KE BOTH
		Set<String> foundPackages = TPRPackageSearcher.searchAndHandlePackages(
				packages, false, TPRConstants.SearchType.BOTH)

		List<String> foundDetails = new ArrayList<>()
		for (String packageName : foundPackages) {
			Map<String, String> pkgData = packages.find { it['name'] == packageName }
			String price = pkgData != null ? pkgData['price'] : "Price Not Found"

			foundDetails.add("${packageName} (${price})")
		}

		String formattedList = foundDetails.join(", ")

		if (formattedList.isEmpty()) {
			formattedList = "None"
		}

		if (foundPackages.size() < packages.size()) {
			KeywordUtil.markWarning("Found ${foundPackages.size()}/${packages.size()} packages for ${packageKey}: ${formattedList}")
		} else {
			KeywordUtil.logInfo("Found ${foundPackages.size()}/${packages.size()} packages for ${packageKey}: ${formattedList}")
		}

		return foundPackages
	}

	public static Set<String> handlePackageSelection(String packageKey, int index) {
		List<Map<String, String>> packages = TPRPackageManager.getPackages(packageKey)
		if (packages.isEmpty()) {
			KeywordUtil.logInfo("No packages found for key: ${packageKey}")
			return Collections.emptySet()
		}

		Map<String, String> selectedPackage = TPRPackageManager.getPackageByIndex(packageKey, index)
		if (selectedPackage == null) {
			KeywordUtil.logInfo("Invalid index ${index} for ${packageKey}. Using first package.")
			selectedPackage = packages.get(0)
		}

		// KEMBALI KE BOTH
		return TPRPackageSearcher.searchAndHandlePackages([selectedPackage], true, TPRConstants.SearchType.BOTH)
	}

	// ============ ADVANCED PUBLIC API ============

	public static Set<String> validateAllTPRPackages(String packageKey,
			TPRConstants.SearchType searchType = TPRConstants.SearchType.BOTH) {
		List<Map<String, String>> packages = TPRPackageManager.getPackages(packageKey)

		if (packages.isEmpty()) {
			KeywordUtil.logInfo("No packages found for key: ${packageKey}")
			return Collections.emptySet()
		}

		return TPRPackageSearcher.searchAndHandlePackages(packages, false, searchType)
	}


	public static Set<String> tapTPRPackage(String packageKey, Object identifier,
			TPRConstants.SearchType searchType = TPRConstants.SearchType.BOTH) {
		List<Map<String, String>> packages = TPRPackageManager.getPackages(packageKey)

		if (packages.isEmpty()) {
			KeywordUtil.logInfo("No packages found for key: ${packageKey}")
			return Collections.emptySet()
		}

		Map<String, String> selectedPackage = TPRPackageManager.findPackageByIdentifier(packageKey, identifier)
		if (selectedPackage == null) {
			KeywordUtil.logInfo("Package not found for identifier: ${identifier}. Using first package.")
			selectedPackage = packages.get(0)
		}

		return TPRPackageSearcher.searchAndHandlePackages([selectedPackage], true, searchType)
	}
}