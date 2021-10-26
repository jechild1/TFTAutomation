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
 * This Test Script will launch TFT and exercise all the menu options for an
 * Administrator, only asserting that the page loads and the title is correct.
 * 
 * @author jesse.childress
 *
 */
public class ExerciseAllMenusAdmin extends TFTConfig {

	String actualTitle;
	String expectedTitle;

	@AfterClass
	private void afterClass() {
		AutomationHelper.finishTest();
	}

	@DataProvider(name = "adminAccount")
	private String[][] getUserAccount() {
		return new String[][]{{ADMIN_USERNAME, ADMIN_PASSWORD}};
	}

	/**
	 * Method to log into the TFT application as an administrator
	 */
	@Test(dataProvider = "adminAccount")
	public void login(String userName) {
		LoginMod login = new LoginMod();

		login.execute("jessec");
	}

	/**
	 * Method to click each menu option under MY MENU and ensure page loads with
	 * correct title.
	 */
	@Test(dependsOnMethods = "login", priority = 1)
	public void exerciseMyMenuAdmin() {
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
	public void exerciseReportsAdmin() {
		AutomationHelper.printClassName();
		AutomationHelper.printMethodName();

		// Instantiate local soft asserter as to not concatenate errors with the
		// global
		// soft assert.
		SoftAssert softAsserter = new SoftAssert();

		MenusPageFactory menus = new MenusPageFactory();

		// Counts the number of menu option tests we will perform.
		int menuOptionTestIterator = 0;

		menus.clickUnitOverallProgress();
		actualTitle = readPageTitle();
		expectedTitle = "Unit Overall Progress - Team Fitness Tracker";
		softAsserter.assertEquals(actualTitle, expectedTitle);
		menuOptionTestIterator++;

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
	 * Method to click each menu option under Admin and ensure page loads with
	 * correct title.
	 */
	@Test(dependsOnMethods = "login", priority = 3)
	public void exerciseAdmin() {
		AutomationHelper.printClassName();
		AutomationHelper.printMethodName();

		// Instantiate local soft asserter as to not concatenate errors with the
		// global
		// soft assert.
		SoftAssert softAsserter = new SoftAssert();

		MenusPageFactory menus = new MenusPageFactory();

		// Counts the number of menu option tests we will perform.
		int menuOptionTestIterator = 0;

		menus.clickBranchComponent();
		actualTitle = readPageTitle();
		expectedTitle = "Branch Components - Team Fitness Tracker";
		softAsserter.assertEquals(actualTitle, expectedTitle);
		menuOptionTestIterator++;

		menus.clickBranchOfService();
		actualTitle = readPageTitle();
		expectedTitle = "Branch of Service - Team Fitness Tracker";
		softAsserter.assertEquals(actualTitle, expectedTitle);
		menuOptionTestIterator++;

		menus.clickBodyMeasurementType();
		actualTitle = readPageTitle();
		expectedTitle = "Body Measurement Type - Team Fitness Tracker";
		softAsserter.assertEquals(actualTitle, expectedTitle);
		menuOptionTestIterator++;

		menus.clickGoals();
		actualTitle = readPageTitle();
		expectedTitle = "Goals - Team Fitness Tracker";
		softAsserter.assertEquals(actualTitle, expectedTitle);
		menuOptionTestIterator++;

		menus.clickNotificationType();
		actualTitle = readPageTitle();
		expectedTitle = "Notification Types - Team Fitness Tracker";
		softAsserter.assertEquals(actualTitle, expectedTitle);
		menuOptionTestIterator++;

		menus.clickPFTScores();
		actualTitle = readPageTitle();
		expectedTitle = "PFT Scores - Team Fitness Tracker";
		softAsserter.assertEquals(actualTitle, expectedTitle);
		menuOptionTestIterator++;

		menus.clickRoles();
		actualTitle = readPageTitle();
		expectedTitle = "Roles - Team Fitness Tracker";
		softAsserter.assertEquals(actualTitle, expectedTitle);
		menuOptionTestIterator++;

		menus.clickUnits();
		actualTitle = readPageTitle();
		expectedTitle = "Units - Team Fitness Tracker";
		softAsserter.assertEquals(actualTitle, expectedTitle);
		menuOptionTestIterator++;

		menus.clickResetPassword();
		actualTitle = readPageTitle();
		expectedTitle = "Reset password - Team Fitness Tracker";
		softAsserter.assertEquals(actualTitle, expectedTitle);
		menuOptionTestIterator++;

		menus.clickBodyMeasurementsSurvey();
		actualTitle = readPageTitle();
		expectedTitle = "Body Measurements Surveys - Team Fitness Tracker";
		softAsserter.assertEquals(actualTitle, expectedTitle);
		menuOptionTestIterator++;

		// *****BEGINNING SUB MENU OPTIONS*****
		menus.clickActivity();
		actualTitle = readPageTitle();
		expectedTitle = "Activities - Team Fitness Tracker";
		softAsserter.assertEquals(actualTitle, expectedTitle);
		menuOptionTestIterator++;

		menus.clickActivityCategories();
		actualTitle = readPageTitle();
		expectedTitle = "Activity Categories - Team Fitness Tracker";
		softAsserter.assertEquals(actualTitle, expectedTitle);
		menuOptionTestIterator++;

		menus.clickActivitySources();
		actualTitle = readPageTitle();
		expectedTitle = "Activity Sources - Team Fitness Tracker";
		softAsserter.assertEquals(actualTitle, expectedTitle);
		menuOptionTestIterator++;

		menus.clickIntensity();
		actualTitle = readPageTitle();
		expectedTitle = "Intensity - Team Fitness Tracker";
		softAsserter.assertEquals(actualTitle, expectedTitle);
		menuOptionTestIterator++;

		menus.clickMood();
		actualTitle = readPageTitle();
		expectedTitle = "Mood List - Team Fitness Tracker";
		softAsserter.assertEquals(actualTitle, expectedTitle);
		menuOptionTestIterator++;

		menus.clickArticlesSubMenu();
		actualTitle = readPageTitle();
		expectedTitle = "Articles - Team Fitness Tracker";
		softAsserter.assertEquals(actualTitle, expectedTitle);
		menuOptionTestIterator++;

		menus.clickArticleTypesSubMenu();
		actualTitle = readPageTitle();
		expectedTitle = "Article Types - Team Fitness Tracker";
		softAsserter.assertEquals(actualTitle, expectedTitle);
		menuOptionTestIterator++;

		menus.clickBlogsSubMenu();
		actualTitle = readPageTitle();
		expectedTitle = "Admin Blog Listing - Team Fitness Tracker";
		softAsserter.assertEquals(actualTitle, expectedTitle);
		menuOptionTestIterator++;

		// Food Intake
		menus.clickFoodsSubMenu();
		actualTitle = readPageTitle();
		expectedTitle = "Foods - Team Fitness Tracker";
		softAsserter.assertEquals(actualTitle, expectedTitle);
		menuOptionTestIterator++;

		menus.clickMealTypeSubMenu();
		actualTitle = readPageTitle();
		expectedTitle = "Meal Types - Team Fitness Tracker";
		softAsserter.assertEquals(actualTitle, expectedTitle);
		menuOptionTestIterator++;

		// Progress Map
		menus.clickLocationSubMenu();
		actualTitle = readPageTitle();
		expectedTitle = "Locations - Team Fitness Tracker";
		softAsserter.assertEquals(actualTitle, expectedTitle);
		menuOptionTestIterator++;

		menus.clickRouteSubMenu();
		actualTitle = readPageTitle();
		expectedTitle = "Routes - Team Fitness Tracker";
		softAsserter.assertEquals(actualTitle, expectedTitle);
		menuOptionTestIterator++;

		menus.clickRouteLocationsSubMenu();
		actualTitle = readPageTitle();
		expectedTitle = "Route Locations - Team Fitness Tracker";
		softAsserter.assertEquals(actualTitle, expectedTitle);
		menuOptionTestIterator++;

		// Teams & Users
		menus.clickTeamsSubMenu();
		actualTitle = readPageTitle();
		expectedTitle = "Teams - Team Fitness Tracker";
		softAsserter.assertEquals(actualTitle, expectedTitle);
		menuOptionTestIterator++;

		menus.clickTeamLeadsSubMenu();
		actualTitle = readPageTitle();
		expectedTitle = "Team Leads - Team Fitness Tracker";
		softAsserter.assertEquals(actualTitle, expectedTitle);
		menuOptionTestIterator++;

		menus.clickTeamMembersSubMenu();
		actualTitle = readPageTitle();
		expectedTitle = "Team & Team Members - Team Fitness Tracker";
		softAsserter.assertEquals(actualTitle, expectedTitle);
		menuOptionTestIterator++;

		menus.clickUsersSubMenu();
		actualTitle = readPageTitle();
		expectedTitle = "Users - Team Fitness Tracker";
		softAsserter.assertEquals(actualTitle, expectedTitle);
		menuOptionTestIterator++;

		// Validic
		menus.clickDeleteValidicUserSubMenu();
		actualTitle = readPageTitle();
		expectedTitle = "Provisioned Users - Team Fitness Tracker";
		softAsserter.assertEquals(actualTitle, expectedTitle);
		menuOptionTestIterator++;

		menus.clickTeamFitnessTrackerUsersSubMenu();
		actualTitle = readPageTitle();
		expectedTitle = "Team Fitness Tracker Users - Team Fitness Tracker";
		softAsserter.assertEquals(actualTitle, expectedTitle);
		menuOptionTestIterator++;

		softAsserter.assertAll();

		// This checks to see that there are the same amount of menu options as
		// there
		// are tests that we executed. We subtract 6 in this case for the
		// sub-menu
		// items. They're just a way to get to a menu.
		assertEquals((menus.getAdminMenuOptionCount() - 6),
				menuOptionTestIterator, "Menu Item List Count: ");

	}

	/**
	 * Exercises menu options under the "Hello xyz user" menu
	 */
	@Test(dependsOnMethods = "login", priority = 4)
	public void exerciseHelloUser() {

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
		expectedTitle = "Edit PRT Status - Team Fitness Tracker";
		// Because this can be "Edit PRT Status" or "Create PRT Status"
		softAsserter.assertTrue(
				actualTitle.matches(".*PRT Status - Team Fitness Tracker"));
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
