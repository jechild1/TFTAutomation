package testCases.Archived;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import configuration.TFTConfig;
import modularScripts.LoginMod;
import modularScripts.LogoffMod;
import pageFactories.HomePageFactory;
import utilities.AutomationHelper;

public class TeamLogin extends TFTConfig {

	@AfterMethod
	private void afterMethod() {
		AutomationHelper.finishTest();
	}

	@DataProvider(name = "userNamePasswordCombos")
	private String[][] getAccounts() {
		// return getUserAndPassDataProviderFromExcel("TFT Unit Members.xlsx",
		// "ChildressCalorieCrushers");
		return getUserAndPassDataProviderFromExcel("UsersData.xlsx", "POTUS");

	}

	/**
	 * Method to log in an user and then log out.
	 */
	@Test(dataProvider = "userNamePasswordCombos")
	public void loginUser(String userName) {
		LoginMod login = new LoginMod();

		login.execute("jessec");
		AutomationHelper.printClassName();
		AutomationHelper.printMethodName();

		HomePageFactory home = new HomePageFactory();
		softAsserter.assertEquals(AutomationHelper.getPageTitle(),
				"Team Fitness Tracker - Team Fitness Tracker",
				"Page Title assertion: ");

		LogoffMod myLogoff = new LogoffMod();
		myLogoff.logoff();

		softAsserter.assertAll();
	}
}
