package testCases.Archived;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import configuration.TFTConfig;
import modularScripts.LoginMod;
import pageFactories.MenusPageFactory;
import utilities.AutomationHelper;

/**
 * This Test Script will launch TFT and exercise all the menu options for a Team
 * Lead role, only asserting that the page loads and the title is correct.
 * 
 * @author jesse.childress
 *
 */
public class ExerciseAllMenusTeamLead extends TFTConfig {

	String actualTitle;
	String expectedTitle;

	@AfterClass
	private void afterClass() {
		AutomationHelper.finishTest();
	}

	@DataProvider(name = "teamLeadAccount")
	private String[][] getUserAccount() {
		return new String[][]{{TEAM_LEAD_USERNAME, TEAM_LEAD_PASSWORD}};
	}

	/**
	 * Method to log into the TFT application as an administrator
	 */
	@Test(dataProvider = "teamLeadAccount")
	public void login(String userName) {
		LoginMod login = new LoginMod();

		login.execute("jessec");
	}

	/**
	 * Method to click each menu option under MY MENU and ensure page loads with
	 * correct title.
	 */
	@Test(dependsOnMethods = "login", priority = 1)
	public void exerciseMyMenuTeamLead() {
		AutomationHelper.printClassName();
		AutomationHelper.printMethodName();

		// Instantiate local soft asserter as to not concatenate errors with the
		// global
		// soft assert.
		SoftAssert softAsserter = new SoftAssert();

		MenusPageFactory menus = new MenusPageFactory();

		// Counts the number of menu option tests we will perform.
		int menuOptionTestIterator = 0;

		/*
		 * My Menu
		 */
		menus.clickMyActivities();
		actualTitle = readPageTitle();
		expectedTitle = "My Activity Log - Team Fitness Tracker";
		softAsserter.assertEquals(actualTitle, expectedTitle);
		menuOptionTestIterator++;

		menus.clickMyCalorieIntake();
		actualTitle = readPageTitle();
		expectedTitle = "My Calorie Intake - Team Fitness Tracker";
		softAsserter.assertEquals(actualTitle, expectedTitle);
		menuOptionTestIterator++;

		menus.clickMySleepLog();
		actualTitle = readPageTitle();
		expectedTitle = "Sleep Log - Team Fitness Tracker";
		softAsserter.assertEquals(actualTitle, expectedTitle);
		menuOptionTestIterator++;

		menus.clickMyBodyMeasurements();
		actualTitle = readPageTitle();
		expectedTitle = "Body Measurements - Team Fitness Tracker";
		softAsserter.assertEquals(actualTitle, expectedTitle);
		menuOptionTestIterator++;

		menus.clickMyPFTScore();
		actualTitle = readPageTitle();
		expectedTitle = "My PFT Score - Team Fitness Tracker";
		softAsserter.assertEquals(actualTitle, expectedTitle);
		menuOptionTestIterator++;

		menus.clickMyProgressMap();
		actualTitle = readPageTitle();
		expectedTitle = "My Progress Map - Team Fitness Tracker";
		softAsserter.assertEquals(actualTitle, expectedTitle);
		menuOptionTestIterator++;

		menus.clickMyTeamProgressMap();
		actualTitle = readPageTitle();
		expectedTitle = "My Team Progress Map - Team Fitness Tracker";
		softAsserter.assertEquals(actualTitle, expectedTitle);
		menuOptionTestIterator++;

		menus.clickMyAchievements();
		actualTitle = readPageTitle();
		expectedTitle = "My Achievements - Team Fitness Tracker";
		softAsserter.assertEquals(actualTitle, expectedTitle);
		menuOptionTestIterator++;

		menus.clickMyChallenges();
		actualTitle = readPageTitle();
		expectedTitle = "My Challenges - Team Fitness Tracker";
		softAsserter.assertEquals(actualTitle, expectedTitle);
		menuOptionTestIterator++;

		menus.clickMyGoals();
		actualTitle = readPageTitle();
		expectedTitle = "My Goals - Team Fitness Tracker";
		softAsserter.assertEquals(actualTitle, expectedTitle);
		menuOptionTestIterator++;

		menus.clickMyTeamGoals();
		actualTitle = readPageTitle();
		expectedTitle = "Team Goals - Team Fitness Tracker";
		softAsserter.assertEquals(actualTitle, expectedTitle);
		menuOptionTestIterator++;

		menus.clickBlogs();
		actualTitle = readPageTitle();
		expectedTitle = "Blogs - Team Fitness Tracker";
		softAsserter.assertEquals(actualTitle, expectedTitle);
		menuOptionTestIterator++;

		menus.clickArticlesMyMenu();
		actualTitle = readPageTitle();
		expectedTitle = "Articles - Team Fitness Tracker";
		softAsserter.assertEquals(actualTitle, expectedTitle);
		menuOptionTestIterator++;

		softAsserter.assertAll();

		// This checks to see that there are the same amount of menu options as
		// there
		// are tests that we executed.
		assertEquals(menus.getMyMenuOptionCount(), menuOptionTestIterator,
				"Menu Item List Count: ");
	}

	/**
	 * Method to click each menu option under REPORTS and ensure page loads with
	 * correct title.
	 */
	@Test(dependsOnMethods = "login", priority = 2)
	public void exerciseReportsTeamLead() {
		AutomationHelper.printClassName();
		AutomationHelper.printMethodName();

		// Instantiate local soft asserter as to not concatenate errors with the
		// global
		// soft assert.
		SoftAssert softAsserter = new SoftAssert();

		MenusPageFactory menus = new MenusPageFactory();

		// Counts the number of menu option tests we will perform.
		int menuOptionTestIterator = 0;

		menus.clickTeamLoginActivity();
		actualTitle = readPageTitle();
		expectedTitle = "Team Login Activity - Team Fitness Tracker";
		softAsserter.assertEquals(actualTitle, expectedTitle);
		menuOptionTestIterator++;

		menus.clickTeamOverallSleep();
		actualTitle = readPageTitle();
		expectedTitle = "Team Overall Sleep - Team Fitness Tracker";
		softAsserter.assertEquals(actualTitle, expectedTitle);
		menuOptionTestIterator++;

		menus.clickTeamActivity();
		actualTitle = readPageTitle();
		expectedTitle = "Team Activity - Team Fitness Tracker";
		softAsserter.assertEquals(actualTitle, expectedTitle);
		menuOptionTestIterator++;

		menus.clickTeamGoalAchievements();
		actualTitle = readPageTitle();
		expectedTitle = "Team Goal Achievements - Team Fitness Tracker";
		softAsserter.assertEquals(actualTitle, expectedTitle);
		menuOptionTestIterator++;

		menus.clickMyActivitiesReport();
		actualTitle = readPageTitle();
		expectedTitle = "My Activities - Team Fitness Tracker";
		softAsserter.assertEquals(actualTitle, expectedTitle);
		menuOptionTestIterator++;

		menus.clickMySleepReport();
		actualTitle = readPageTitle();
		expectedTitle = "My Sleep - Team Fitness Tracker";
		softAsserter.assertEquals(actualTitle, expectedTitle);
		menuOptionTestIterator++;

		menus.clickGoalHistoryReport();
		actualTitle = readPageTitle();
		expectedTitle = "Goal History - Team Fitness Tracker";
		softAsserter.assertEquals(actualTitle, expectedTitle);
		menuOptionTestIterator++;

		menus.clickGoalAchievementsReport();
		actualTitle = readPageTitle();
		expectedTitle = "Goal Achievements - Team Fitness Tracker";
		softAsserter.assertEquals(actualTitle, expectedTitle);
		menuOptionTestIterator++;

		menus.clickCaloriesBurnedIngestedReport();
		actualTitle = readPageTitle();
		expectedTitle = "Calories Burned/Ingested - Team Fitness Tracker";
		softAsserter.assertEquals(actualTitle, expectedTitle);
		menuOptionTestIterator++;

		menus.clickMyBodyMeasurementsChangesReport();
		actualTitle = readPageTitle();
		expectedTitle = "My Body Measurements - Team Fitness Tracker";
		softAsserter.assertEquals(actualTitle, expectedTitle);
		menuOptionTestIterator++;

		softAsserter.assertAll();

		// This checks to see that there are the same amount of menu options as
		// there
		// are tests that we executed.
		assertEquals(menus.getReportsMenuOptionCount(), menuOptionTestIterator,
				"Menu Item List Count: ");

	}

	/**
	 * Exercises menu options under the "Hello xyz user" menu
	 */
	@Test(dependsOnMethods = "login", priority = 3)
	public void exerciseHelloUser() {

		AutomationHelper.printClassName();
		AutomationHelper.printMethodName();

		// Instantiate local soft asserter as to not concatenate errors with the
		// global
		// soft assert.
		SoftAssert softAsserter = new SoftAssert();

		MenusPageFactory menus = new MenusPageFactory();

		// Counts the number of menu option tests we will perform.
		int menuOptionTestIterator = 0;

		menus.clickProfile();
		actualTitle = readPageTitle();
		expectedTitle = "Edit User Profile - Team Fitness Tracker";
		softAsserter.assertEquals(actualTitle, expectedTitle);
		menuOptionTestIterator++;

		menus.clickPRTStatus();
		actualTitle = readPageTitle();
		// Because if a title is not filled out, it says Edit. Else, it says
		// Create.
		expectedTitle = ".*PRT Status - Team Fitness Tracker";
		softAsserter.assertTrue(actualTitle.matches(expectedTitle));
		menuOptionTestIterator++;

		menus.clickTeamMemberships();
		actualTitle = readPageTitle();
		expectedTitle = "Team Membership - Team Fitness Tracker";
		softAsserter.assertEquals(actualTitle, expectedTitle);
		menuOptionTestIterator++;

		menus.clickRegisterDevice();
		actualTitle = readPageTitle();
		expectedTitle = "Device Registration - Team Fitness Tracker";
		softAsserter.assertEquals(actualTitle, expectedTitle);
		menuOptionTestIterator++;

		menus.clickChangePassword();
		actualTitle = readPageTitle();
		expectedTitle = "Change Password - Team Fitness Tracker";
		softAsserter.assertEquals(actualTitle, expectedTitle);
		menuOptionTestIterator++;

		softAsserter.assertAll();

		// This checks to see that there are the same amount of menu options as
		// there
		// are tests that we executed. Minus one here because we don't actually
		// execute
		// a test for LogOff.
		assertEquals((menus.getHelloUserOptionCount() - 1),
				menuOptionTestIterator, "Menu Item List Count: ");
	}

}
