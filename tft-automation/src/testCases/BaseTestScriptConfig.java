package testCases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;

import configuration.TFTConfig;
import utilities.AutomationHelper;

/**
 * Base Test Script to be extended by TFT Test cases
 * 
 * @author jesse.childress
 *
 */
public abstract class BaseTestScriptConfig extends TFTConfig {
	
	/**
	 * After class method that will run the cleanup finish test methods at the
	 * end of all tests in a given class
	 */
	@AfterClass
	public void afterClass() {
		AutomationHelper.finishTest();
	}

	/**
	 * After method that will close the driver in-between tests in the loop
	 */
	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

}
