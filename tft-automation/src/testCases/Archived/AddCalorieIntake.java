package testCases.Archived;

import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import configuration.TFTConfig;
import modularScripts.AddCalorieIntakeMod;
import modularScripts.HomePageMod;
import modularScripts.LoginMod;
import pageFactories.MenusPageFactory;
import utilities.AutomationHelper;

/**
 * This test script logs in as a team member and does the following: (1)
 * Navigates to the Calorie Intake page and does look through of the records in
 * the table. <br>
 * (2) Notes any dates that occurred within the last 7 days that do not have a
 * food item. <br>
 * (3) Adds a food item for any day in the past 7 days that does not currently
 * have one. <br>
 * (4) Checks to see that the new data was added on the log. <br>
 * (5) Checks the Last 7 nutritional Items on the dashboard.
 * 
 * @author jesse.childress
 *
 */
public class AddCalorieIntake extends TFTConfig {

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

		return getUserAndPassDataProviderFromExcel("TFT Unit Members.xlsx",
				"ChildressCalorieCrushers", "echildress");
	}

	/**
	 * Adds calorie intake for an entire week for the passed in user.
	 */
	@Test(dataProvider = "userNamePasswordCombos")
	public void addCalorieIntakeForWeek(String userName) {
		LoginMod login = new LoginMod();

		login.execute("jessec");

		AutomationHelper.printMethodName();

		// Navigate to the Activity menu
		MenusPageFactory menus = new MenusPageFactory();
		menus.clickMyCalorieIntake();

		// Add food intake for the current day
		AddCalorieIntakeMod calIntake = new AddCalorieIntakeMod();
		calIntake.addFoodIntakeForWeek();

		// Navigate Back to the Home Page
		menus.clickHomeLink();
	}

	/**
	 * Method to validate that the last 7 nutritional items were added
	 * successfully to the dashboard.
	 */
	@Test(dependsOnMethods = "addCalorieIntakeForWeek")
	public void validateLast7NutritionalItems() {
		HomePageMod homePage = new HomePageMod();
		homePage.validateLast7NutritionalItems();
	}

}
