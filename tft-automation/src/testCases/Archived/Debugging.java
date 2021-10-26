package testCases.Archived;

import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import configuration.TFTConfig;
import modularScripts.HomePageMod;
import modularScripts.LoginMod;
import utilities.AutomationHelper;

public class Debugging extends TFTConfig {

	@AfterClass
	private void afterClass() {
		AutomationHelper.finishTest();
	}

	/**
	 * This method takes gets the username/password combo being used for
	 * HelpPageFactory and returns a String[][]
	 * 
	 * @return String[][]
	 */
	@DataProvider(name = "userNamePasswordCombos")
	private String[][] getAccounts() {

		return new String[][]{{"GeorgeWashington", "P@ssword1"}};
	}

	@Test(dataProvider = "userNamePasswordCombos")
	public void validateLast7NutritionalItemsTable(String userName) {
		LoginMod login = new LoginMod();

		login.execute("jessec");

		HomePageMod home = new HomePageMod();
		home.validateLast7NutritionalItems();

	}

}
