package testCases.Archived;

import static org.testng.Assert.assertEquals;

import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import configuration.TFTConfig;
import modularScripts.LoginMod;
import modularScripts.NotificationsMod;
import pageFactories.MenusPageFactory;
import utilities.AutomationHelper;

/**
 * This test case logs in as a specified user and opens and checks all
 * notifications until it reaches the end of the table.
 * 
 * @author jesse.childress
 *
 */
public class ReadAllNotifications extends TFTConfig {

	@AfterMethod
	private void afterClass() {
		AutomationHelper.finishTest();
	}

	/**
	 * Data provider which returns a String [][] of user(s).
	 * 
	 * @return String[][]
	 */
	@DataProvider(name = "userLogin")
	private String[][] getUserAccount() {
		// return new String[][] { { ADMIN_USERNAME, ADMIN_PASSWORD } };
		return getUserAndPassDataProviderFromExcel("UsersData.xlsx",
				"ChildressCalorieCrushers");
	}

	/**
	 * Method to click each menu option under MY MENU and ensure page loads with
	 * correct title.
	 */
	@Test(dataProvider = "userLogin")
	public void readNumberOfNotifications(String userName) {

		LoginMod login = new LoginMod();

		login.execute("jessec");

		// Instantiate Menus Page Factory
		MenusPageFactory menus = new MenusPageFactory();

		// Store the number of original notifications
		int originalNotifications = menus.readNumberOfNotifications();
		Reporter.log(
				"Reading Notifications - Original Number of notifications: "
						+ originalNotifications,
				true);

		// Open up the Notifications page
		menus.clickNotificationsLink();
		assertEquals(AutomationHelper.getPageTitle(),
				"Notifications - Team Fitness Tracker");

		// Go through each page in the table, looking for each and every "blue"
		// row,
		// indicating that the notification has not been read.
		NotificationsMod notifications = new NotificationsMod();
		notifications.openAllTableRecords();

	}

}
