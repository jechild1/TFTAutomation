package testCases.Archived;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import configuration.TFTConfig;
import modularScripts.AddWaterIntakeMod;
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
public class AddWaterIntakeSingleUser extends TFTConfig {

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
	@DataProvider(name = "userNamePasswordCombo")
	private String[][] getAccount() {

		return new String[][]{{"TomBrady715", "TomBrady#100"}};
	}

	/**
	 * Method to log into the TFT application each time for every user on a
	 * team, as provided by the dataprovider. Then adds calories for week and
	 * validates the dashboard.
	 * 
	 * @param userName
	 * @param password
	 */
	@Test(dataProvider = "userNamePasswordCombo")
	public void addWaterIntakeForSingleUser(String userName) {

		LoginMod login = new LoginMod();

		login.execute("jessec");

		AutomationHelper.printMethodName();

		// On the Home page now.
		assertEquals(readPageTitle(),
				"Team Fitness Tracker - Team Fitness Tracker",
				"Home Page -  page title:");

		// Call private method to add water intake for the week
		addWaterIntakeForWeek();

		// Navigate Back to the Home Page
		MenusPageFactory menus = new MenusPageFactory();
		menus.clickHomeLink();

		// Log off
		LogoffMod logoff = new LogoffMod();
		logoff.logoff();

	}

	/**
	 * Method to add a water intake for an entire week for a user.
	 */
	private void addWaterIntakeForWeek() {

		AutomationHelper.printMethodName();

		// Navigate to the Activity menu
		MenusPageFactory menus = new MenusPageFactory();
		menus.clickMyCalorieIntake();
		assertEquals(readPageTitle(),
				"My Calorie Intake - Team Fitness Tracker",
				"Home Page -  page title:");

		// Add food intake for the current day
		AddWaterIntakeMod waterIntake = new AddWaterIntakeMod();
		waterIntake.addWaterIntakeForWeek();
	}
}
