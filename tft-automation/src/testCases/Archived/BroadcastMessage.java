package testCases.Archived;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import configuration.TFTConfig;
import modularScripts.CreateBroadcastMessageMod;
import modularScripts.LoginMod;
import pageFactories.MenusPageFactory;
import pageFactories.NotificationsPageFactory;
import utilities.AutomationHelper;

/**
 * This test case signs in as a team leader
 * 
 * @author jesse.childress
 *
 */
public class BroadcastMessage extends TFTConfig {

	// Select which record to run in the dataset.
	String testDataID = "1";

	/**
	 * After method to NOT call AutomationHelper.finishTest() as we do not want
	 * to stop the test if we hit an issue.
	 */
	@AfterMethod
	private void afterMethod() {
		driver.quit();
	}

	/**
	 * After class method necessary to perform softAsserter.assertAll() method.
	 * We don't want to fail until the end.
	 */
	@AfterClass
	private void afterClass() {
		AutomationHelper.finishTest();
	}

	/**
	 * Data provider for the team leader login.
	 * 
	 * @return String[][] - Team Leader Login Credentials
	 */
	@DataProvider(name = "teamLeadLogin")
	private String[][] teamLeaderLogin() {
		return new String[][]{{TEAM_LEAD_USERNAME, TEAM_LEAD_PASSWORD}};
	}

	/**
	 * Data Provider for all of the users on a given team that received the
	 * message.
	 * 
	 * @return String[][] of team logins for which the broadcast message was
	 *         sent.
	 */
	@DataProvider(name = "teamLoginList")
	private String[][] teamMemberLogins() {
		CreateBroadcastMessageMod broadcast = new CreateBroadcastMessageMod();
		String[][] teamLoginArray = broadcast
				.getUserNameListForBroadcastMessage(
						getExcelFile("BroadcastMessages.xlsx",
								"CreateBroadcastMessage"),
						testDataID, getExcelFile("UsersData.xlsx",
								"ChildressCalorieCrushers"));

		return teamLoginArray;
	}

	/**
	 * Method to login as a team leader and create a broadcast message.
	 * 
	 * @param userName
	 * @param password
	 */
	@Test(dataProvider = "teamLeadLogin")
	public void createNewBroadcastMessage(String userName) {
		AutomationHelper.printMethodName();
		LoginMod login = new LoginMod();

		login.execute("jessec");

		// Landed on the home page.
		assertEquals(readPageTitle(),
				"Team Fitness Tracker - Team Fitness Tracker",
				"Home Page Landing");

		// Navigate to Notifications Page
		MenusPageFactory menus = new MenusPageFactory();
		menus.clickNotificationsLink();

		// Landed on the Notifications page
		assertEquals(readPageTitle(), "Notifications - Team Fitness Tracker",
				"Notifications Page Landing");

		// Click Create New Broadcast Message on the Notifications page
		NotificationsPageFactory notifications = new NotificationsPageFactory();
		notifications.clickCreateNewBroadcastMessageLink();

		// Call method in modular script
		CreateBroadcastMessageMod boadcastMessage = new CreateBroadcastMessageMod();
		boadcastMessage
				.createBroadcastMessage(getExcelFile("BroadcastMessages.xlsx",
						"CreateBroadcastMessage"), testDataID);

	}

	/**
	 * Method to log in as each team member who received a broadcast message and
	 * validate its contents.
	 * 
	 * @param userName
	 * @param password
	 */
	@Test(dependsOnMethods = "createNewBroadcastMessage", dataProvider = "teamLoginList")
	public void validateBroadcastMessage(String userName) {
		AutomationHelper.printMethodName();
		// We do not want to log in as the team lead, because the person that
		// SENDS the broadcast message does not receive it.
		if (!userName.equals(TEAM_LEAD_USERNAME)) {

			LoginMod login = new LoginMod();

			login.execute("jessec");
			// Landed on the home page.
			assertEquals(readPageTitle(),
					"Team Fitness Tracker - Team Fitness Tracker",
					"Home Page Landing");

			// Navigate to Notifications Page
			MenusPageFactory menus = new MenusPageFactory();
			menus.clickNotificationsLink();

			// Landed on the Notifications page
			assertEquals(readPageTitle(),
					"Notifications - Team Fitness Tracker",
					"Notifications Page Landing");

			CreateBroadcastMessageMod broadcast = new CreateBroadcastMessageMod();
			broadcast.validateBroadcastMessage(testDataID);

			// Log out.
			menus.clickLogOff();
		}

	}

}
