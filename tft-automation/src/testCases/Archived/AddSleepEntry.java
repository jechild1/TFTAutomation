package testCases.Archived;

import java.util.Arrays;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import configuration.TFTConfig;
import modularScripts.AddSleepEntryMod;
import modularScripts.LoginMod;
import modularScripts.LogoffMod;
import pageFactories.MenusPageFactory;
import utilities.AutomationHelper;

public class AddSleepEntry extends TFTConfig {

	String[][] dashboardArray;
	String[][] sleepLogArray;
	String userName;

	@AfterClass
	private void afterClass() {
		AutomationHelper.finishTest();
	}

	@AfterMethod
	private void logoff() {
		// Log off
		LogoffMod logoff = new LogoffMod();
		logoff.logoff();
		closePage();

	}

	/**
	 * This method takes gets the username/password combo being used for
	 * HelpPageFactory and returns a String[][]
	 * 
	 * @return String[][]
	 */
	@DataProvider(name = "userNamePasswordCombos")
	private String[][] getAccounts() {

		// return getUserAndPassDataProviderFromExcel("TFT Unit Members.xlsx",
		// "ChildressCalorieCrushers", "jakechildress");

		return getUserAndPassDataProviderFromExcel("UsersData.xlsx",
				"UserAccounts");

		// return new String[][]{{"jechild1", "P@ssword1"}};
	}

	@Test(dataProvider = "userNamePasswordCombos")
	public void addSleepEntry(String userName) {

		addSleepRecordForUndocumentedDays(userName);

		extractSleepDataFromSleepLogForWeek();

		extractDataFromDashboard();

		dashboardSleeplogComparison();
	}

	/**
	 * This method logs in as a user, as provided by the data provider. It then
	 * does the following:
	 * <p>
	 * <ul>
	 * <li>1 - Looks through the first two pages the Sleep Log Table to capture
	 * ALL THE DATES on the first two pages.
	 * <li>2 - Looks at the dates, and determines which dates within the last 7
	 * days are missing.
	 * <li>3 - Compiles a list of dates for the past week (excluding current
	 * date)
	 * <li>4 - Creates a sleep record for each date in the last 7 days which
	 * currently does NOT have data in it. This method uses random number
	 * generators to determine an hour / minute that is < 9:00 hours.
	 * <li>5 - Returns the user to the home page.
	 * </ul>
	 * 
	 * @param userName
	 * @param password
	 */
	// @Test(dataProvider = "userNamePasswordCombos", priority=1)
	private void addSleepRecordForUndocumentedDays(String userName) {
		LoginMod login = new LoginMod();

		login.execute("jessec");
		// To be passed in to other methods to determine device type.
		this.userName = userName;

		AutomationHelper.printMethodName();

		MenusPageFactory menusPF = new MenusPageFactory();
		menusPF.clickMySleepLog();

		AddSleepEntryMod addSleep = new AddSleepEntryMod();
		addSleep.addSleepForUndocumentedDay();

		menusPF.clickHomeLink();
	}

	/**
	 * This method creates a String[][] of Sleep Log data for entries from the
	 * past 7 days.
	 * <ul>
	 * <li>1 - Creates a list of dates for the past 7 days (excluding today)
	 * <li>2 - For each date that happens in the last 7 days (on the first two
	 * pages), we open each one and compile the times.
	 * <li>3 - Add each individual compiled time to a position in an array.
	 * </ul>
	 */
	// @Test(dependsOnMethods = "addSleepRecordForUndocumentedDays")
	private void extractSleepDataFromSleepLogForWeek() {

		AutomationHelper.printMethodName();

		MenusPageFactory menus = new MenusPageFactory();
		menus.clickMySleepLog();

		AddSleepEntryMod addSleep = new AddSleepEntryMod();
		sleepLogArray = addSleep.getSleepFromSleepLog(userName);
		Reporter.log("Sleep Log Data: " + Arrays.deepToString(sleepLogArray),
				true);

		menus.clickHomeLink();

	}

	/**
	 * This method extracts sleep day from the graph (including tool tips) and
	 * stores it in an array.
	 */
	// @Test(dependsOnMethods = "extractSleepDataFromSleepLogForWeek")
	private void extractDataFromDashboard() {

		AutomationHelper.printMethodName();

		AddSleepEntryMod addSleep = new AddSleepEntryMod();

		dashboardArray = addSleep.getSleepFromDashboard(userName);
		Reporter.log("Dashboard Data: " + Arrays.deepToString(dashboardArray),
				true);
	}

	/**
	 * Compares the data from the Sleep Log and Dashboards, which are stored in
	 * two different multidimensional String[][].
	 */
	// @Test(dependsOnMethods = "extractDataFromDashboard")
	private void dashboardSleeplogComparison() {

		AutomationHelper.printMethodName();
		// Check to see that the arrays are not null
		Assert.assertTrue(dashboardArray != null,
				"Dashboard Array Null Check: ");
		Assert.assertTrue(sleepLogArray != null,
				"Sleep Log Array Null Check: ");

		// Check that the array size is equal
		Assert.assertEquals(dashboardArray.length == sleepLogArray.length, true,
				"Dashboard Array / Sleep Log Array length check");

		// Loop through the array and compare each row at a time.
		for (int i = 0; i < dashboardArray.length; i++) {

			Assert.assertTrue(
					Arrays.equals(dashboardArray[i], sleepLogArray[i]),
					"Array Comparison for iteration number: " + i);

			Reporter.log("Pass: Dashboard array "
					+ Arrays.deepToString(dashboardArray[i])
					+ " equals Sleep Log Array"
					+ Arrays.deepToString(sleepLogArray[i]), true);
		}

	}

}
