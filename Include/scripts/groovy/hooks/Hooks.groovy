package hooks
import io.cucumber.java.Before
import io.cucumber.java.Scenario
import com.kms.katalon.core.configuration.RunConfiguration
import internal.GlobalVariable

class Hooks {

	@Before
	def beforeScenario(Scenario scenario) {
		String scenarioName = scenario.getName()
		String featureName = getFeatureName(scenario)

		println "Running Feature: ${featureName}"
		println "Running Scenario: ${scenarioName}"

		GlobalVariable.currentFeature = featureName;
		GlobalVariable.currentScenario = scenarioName;

		/**
		 * setting isBDD flag true to handle the BDD cucumber specific listeners
		 */
		if(!GlobalVariable.isBDD) {
			GlobalVariable.isBDD = true
		}
	}

	private String getFeatureName(Scenario scenario) {
		// Extract feature file name from the scenario's URI
		def rawURI = scenario.getUri().toString()
		println("feature file path is: ${rawURI}")
		return rawURI.substring(rawURI.lastIndexOf("/") + 1).replace(".feature", "")
	}

	//	public Boolean setIsBDD(Scenario scenario) {
	//		String scenarioName = scenario.getName()
	//		println "Running Scenario: ${scenarioName}"
	//		/**
	//		 * setting isBDD flag true to handle the BDD cucumber specific listeners
	//		 */
	//		if(!GlobalVariable.isBDD) {
	//			GlobalVariable.isBDD = true
	//		}
	//		return GlobalVariable.isBDD
	//	}
}
