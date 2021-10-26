package testCases.Archived;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import configuration.TFTConfig;
import modularScripts.CreateNewActivityMod;
import modularScripts.LoginMod;
import pageFactories.MenusPageFactory;
import utilities.AutomationHelper;

public class CreateNewActivityForTeam extends TFTConfig {

	@AfterMethod
	private void afterMethod() {
		AutomationHelper.finishTest();

	}

	/**
	 * This method takes an excel data file and puts the data in a list. Then it
	 * does size checking and converts it to a multidimensional string array to
	 * be used in the main method.
	 * 
	 * @return String[][]
	 */
	@DataProvider(name = "userNamePasswordCombos")
	private String[][] getAccounts() {

		return getUserAndPassDataProviderFromExcel("UsersData.xlsx",
				"ChildressCalorieCrushers");
	}

	@Test(dataProvider = "userNamePasswordCombos")
	public void addNewActivityForCurrentDate(String userName) {

		LoginMod login = new LoginMod();

		login.execute("jessec");

		AutomationHelper.printMethodName();

		// Navigate to the Activity menu
		MenusPageFactory menus = new MenusPageFactory();
		menus.clickMyActivities();

		// Add activity for the current day
		CreateNewActivityMod createActivity = new CreateNewActivityMod();
		createActivity.addActivityForCurrentDate();

		// Navigate back to home page.
		menus.clickHomeLink();

	}

}
