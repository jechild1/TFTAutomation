package testCases.Archived;

import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import configuration.TFTConfig;
import modularScripts.CreateNewActivityMod;
import modularScripts.LoginMod;
import pageFactories.MenusPageFactory;
import utilities.AutomationHelper;

public class CreateNewActivity extends TFTConfig {

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

		return getUserAndPassDataProviderFromExcel("UsersData.xlsx",
				"ChildressCalorieCrushers", "echildress");
	}

	@Test(dataProvider = "userNamePasswordCombos")
	public void addNewActivitiesForWeek(String userName, String password) {
		LoginMod login = new LoginMod();

		login.execute("jessec");

		AutomationHelper.printMethodName();

		// Navigate to the Activity menu
		MenusPageFactory menus = new MenusPageFactory();
		menus.clickMyActivities();

		// Add activity for the current day
		CreateNewActivityMod createActivity = new CreateNewActivityMod();
		createActivity.addActivityForCurrentDate();
	}

}
