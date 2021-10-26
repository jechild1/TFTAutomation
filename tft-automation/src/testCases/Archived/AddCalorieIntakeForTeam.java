package testCases.Archived;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import configuration.TFTConfig;
import modularScripts.AddCalorieIntakeMod;
import modularScripts.HomePageMod;
import modularScripts.LoginMod;
import modularScripts.LogoffMod;
import pageFactories.MenusPageFactory;
import utilities.AutomationHelper;

/**
 * This test script logs in AN ENTIRE TEAM and does the following: <br>
 * (1) Navigates to the Calorie Intake page and does look through of the records
 * in the table. <br>
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
public class AddCalorieIntakeForTeam extends TFTConfig {

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
		// return getUserAndPassDataProviderFromExcel("UsersData.xlsx",
		// "POTUS");
	}

	/**
	 * Method to log into the TFT application each time for every user on a
	 * team, as provided by the dataprovider. Then adds calories for week and
	 * validates the dashboard.
	 * 
	 * @param userName
	 * @param password
	 */
	@Test(dataProvider = "userNamePasswordCombos")
	public void addCalorieIntakeForTeam(String userName) {

		LoginMod login = new LoginMod();

		login.execute("jessec");

		AutomationHelper.printMethodName();

		// On the Home page now.
		addCalorieIntakeForWeek();

		// Navigate Back to the Home Page
		MenusPageFactory menus = new MenusPageFactory();
		menus.clickHomeLink();

		// Validate the dashboard for the last 7 nutritional items
		validateLast7NutritionalItems();

		// Log off
		LogoffMod logoff = new LogoffMod();
		logoff.logoff();

	}

	/**
	 * Method to add a calorie intake for an entire week for a user.
	 */
	private void addCalorieIntakeForWeek() {

		AutomationHelper.printMethodName();

		// Navigate to the Activity menu
		MenusPageFactory menus = new MenusPageFactory();
		menus.clickMyCalorieIntake();

		// Add food intake for the current day
		AddCalorieIntakeMod calIntake = new AddCalorieIntakeMod();
		calIntake.addFoodIntakeForWeek();

	}

	/**
	 * Validates the last 7 nutritional items on the dashboard.
	 */
	private void validateLast7NutritionalItems() {
		HomePageMod homePage = new HomePageMod();
		homePage.validateLast7NutritionalItems();
	}
}
