package tpr

import pages.tpr.*
import com.kms.katalon.core.util.KeywordUtil

public class TPRPage {

	// ============ SIMPLIFIED PUBLIC API (Delegated) ============

	public static Set<String> handleJumatBaikOnboarded() {
		return TPRPackageHandler.handleJumatBaikOnboarded()
	}

	public static Set<String> handleJumatBaikPackage(int index = 1) {
		return TPRPackageHandler.handleJumatBaikPackage(index)
	}

	public static Set<String> handleRabuRawitOnboarded() {
		return TPRPackageHandler.handleRabuRawitOnboarded()
	}

	public static Set<String> handleRabuRawitPackage(int index = 1) {
		return TPRPackageHandler.handleRabuRawitPackage(index)
	}

	public static Set<String> handleBoostrWeekendOnboarded() {
		return TPRPackageHandler.handleBoostrWeekendOnboarded()
	}

	public static Set<String> handleBoostrWeekendPackage(int index = 1) {
		return TPRPackageHandler.handleBoostrWeekendPackage(index)
	}

	// ============ PACKAGE MANAGEMENT API ============

	public static void registerNewPackage(String packageKey, List<Map<String, String>> packages) {
		TPRPackageManager.registerNewPackage(packageKey, packages)
	}

	public static List<Map<String, String>> getTPRPackages(String packageKey) {
		return TPRPackageManager.getPackages(packageKey)
	}

	public static Set<String> validateAllTPRPackages(String packageKey,
			TPRConstants.SearchType searchType = TPRConstants.SearchType.BOTH) {
		return TPRPackageHandler.validateAllTPRPackages(packageKey, searchType)
	}

	public static Set<String> tapTPRPackage(String packageKey, Object identifier,
			TPRConstants.SearchType searchType = TPRConstants.SearchType.BOTH) {
		return TPRPackageHandler.tapTPRPackage(packageKey, identifier, searchType)
	}

	// ============ UTILITY METHODS ============

	public static void printTPRPackagesWithIndex(String packageKey) {
		TPRPackageManager.printTPRPackagesWithIndex(packageKey)
	}

	public static void printAllTPRPackages() {
		TPRPackageManager.printAllTPRPackages()
	}

	public static Set<String> getRegisteredPackageKeys() {
		return TPRPackageManager.getRegisteredPackageKeys()
	}

	public static void clearAllPackages() {
		TPRPackageManager.clearAllPackages()
	}

	public static void removePackageKey(String packageKey) {
		TPRPackageManager.removePackageKey(packageKey)
	}
}