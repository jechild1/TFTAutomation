package modularScripts;

import static org.testng.Assert.assertEquals;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.MoveTargetOutOfBoundsException;

import configuration.TFTConfig;
import pageFactories.CreateSleepLogEntryPageFactory;
import pageFactories.SleepDetailsPageFactory;
import pageFactories.MyMenu.MySleepLog.SleepLogPageFactory;
import utilities.AutomationHelper;
import utilities.Tables;

public class AddSleepEntryMod extends TFTConfig {

	/*
	 * These variables are to hold the sleep time for a given record on the
	 * Sleep Log page. They are of type LocalTime so that we can append values
	 * in instances where we have more than one sleep instance per day, e.g., a
	 * nap.
	 */
	String date;
	LocalTime awakeTimeForSleepLog = LocalTime.of(0, 0);
	LocalTime deepSleepTimeForSleepLog = LocalTime.of(0, 0);
	LocalTime lightSleepTimeForSleepLog = LocalTime.of(0, 0);
	LocalTime remSleepTimeForSleepLog = LocalTime.of(0, 0);
	LocalTime totalSleepTimeForLog = LocalTime.of(0, 0);
	LocalTime totalTime = LocalTime.of(0, 0);// This is basically a duplicate of
												// totalSleepTimeForLog, but
												// necessary for correct array
												// comparison

	/**
	 * This method adds sleep records for any days in the past 7 days that do
	 * not already have records.
	 * <li>1 - Creates a list of dates for the past 7 days (excluding today)
	 * <li>2 - For each date that happens in the last 7 days (on the first two
	 * pages), we open each one and compile the times.
	 */
	public void addSleepForUndocumentedDay() {

		SleepLogPageFactory sleepLogPF = new SleepLogPageFactory();

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

		/*
		 * This block of code will look at the first two table pages of sleep
		 * records and compile a list of dates to be used later.
		 */

		// A List of dates which will be used to store all of the dates in the
		// first two pages of the table.
		List<LocalDate> datesInTables = new ArrayList<LocalDate>();

		// A List of current table rows for the visible table.
		List<WebElement> currentTableRows = sleepLogPF.getSleepLogTable()
				.getTableRowsForVisibleTable();

		for (int i = 1; i <= currentTableRows.size(); i++) {

			// Add each individual date to the dates list.
			String date = sleepLogPF.getSleepLogTable().getCellText(i, "Date");
			LocalDate localDate = LocalDate.parse(date, formatter);
			// Convert String date to LocalDate for processing later
			datesInTables.add(localDate);
		}

		// This section of code will navigate to the next table page, incase
		// multiples exist. It will add the dates on that page as well.
		if (Tables.isSkipToNextNavigationPresent()) {
			Tables.clickSkipToNextNavigationLink();
			// After paging one time, get an updated reference to the rows on
			// page two, if necessary
			currentTableRows = sleepLogPF.getSleepLogTable()
					.getTableRowsForVisibleTable();

			for (int i = 1; i <= currentTableRows.size(); i++) {
				// Add each individual date to the dates list.
				String date = sleepLogPF.getSleepLogTable().getCellText(i,
						"Date");
				// Convert String date to LocalDate for processing later
				datesInTables.add(LocalDate.parse(date, formatter));
			}

			// Go back to the first page of the table.
			if (Tables.isSkipToPreviousNavigationPresent()) {
				Tables.clickSkipToPreviousNavigationLink();
			}
		}

		/*
		 * END User left on Sleep Log page and we have an accurate List
		 * datesInTables which contains the first two pages of data in sleep
		 * log.
		 */

		/*
		 * This block of code will create a list of dates that are absent from
		 * the last 7 days, which will be used to add a manual entry.
		 */

		// Create a current list of LocalDates for the past 7 days (starting
		// yesterday)
		List<LocalDate> currentWeekDates = new ArrayList<LocalDate>();
		for (int i = 1; i <= 7; i++) {
			currentWeekDates.add(LocalDate.now().minusDays(i));
		}

		// List to store dates that need added.
		List<LocalDate> datesThatNeedRecord = new ArrayList<LocalDate>();

		// This cycles through each date in the last 7 days
		for (LocalDate currentDateInList : currentWeekDates) {

			// If this flag never gets set, we need to add the date to our final
			// list
			boolean dateFoundInBoth = false;

			// Cycle through the list of dates in the application.
			for (LocalDate currentDateInTable : datesInTables) {

				// If the current date in the table matches the current date in
				// our list, then set our flag to true and break.
				if (currentDateInTable.equals(currentDateInList)) {
					dateFoundInBoth = true;
					break;
				}
			}

			// If we cycle through the list of dates from the application, and
			// we still didn't change our flag above, then we add that to the
			// datesThatNeedRecord list.
			if (!dateFoundInBoth) {
				datesThatNeedRecord.add(currentDateInList);
			}
		}

		/*
		 * END - We now have a List datesThatNeedRecord in which we need to add
		 * records for.
		 */

		/*
		 * Add a new record for each date that does not have one.
		 */

		// Cycle through each individual date that needs a record. For each one,
		// add a sleep record.

		for (LocalDate date : datesThatNeedRecord) {
			// Take the LocalDate and convert it to correct format in string.
			String formattedDate = formatter.format(date);

			CreateSleepLogEntryPageFactory sleepLogEntryPF = new CreateSleepLogEntryPageFactory();

			// Click Create New Sleep Entry
			sleepLogPF.clickCreateNewSleepEntry();
			assertEquals(readPageTitle(),
					"Create Sleep Log Entry - Team Fitness Tracker",
					"Create Sleep Log Entry page:");

			// Set the date with the current date in the loop
			sleepLogEntryPF.setdate(formattedDate);
			// Set the total sleep - hours with a time from 1 to 8 hours
			String sleepHours = String
					.valueOf(AutomationHelper.generateRandomInteger(1, 8));
			sleepLogEntryPF.setSleepHours(sleepHours);
			// Set the total sleep - minutes field with a time from 1 to 59
			// minutes.
			String sleepMinutes = String
					.valueOf(AutomationHelper.generateRandomInteger(1, 59));
			sleepLogEntryPF.setSleepMinutes(sleepMinutes);

			// Ensure the values are set
			assertEquals(sleepLogEntryPF.readDate(), formattedDate,
					"Create Sleep Log Entry - Date");
			assertEquals(sleepLogEntryPF.readSleepHours(), sleepHours,
					"Create Sleep Log Entry - Hours");
			assertEquals(sleepLogEntryPF.readSleepMinutes(), sleepMinutes,
					"Create Sleep Log Entry - Minutes");

			sleepLogEntryPF.clickCreate();
			// Ensure we are back on the Sleep Log page
			assertEquals(readPageTitle(), "Sleep Log - Team Fitness Tracker",
					"Sleep Log page:");
		}

	}

	public String[][] getSleepFromSleepLog(String userName) {

		/*
		 * STEP 1 - Create a List of LocalDates for the past 7 days (starting
		 * yesterday). Because of the method addSleepForUndocumentedDay, we know
		 * we have at least the last 7 dates populated. However, there could be
		 * a date with multiple entries due to a device / manual entry or two
		 * manual entries.
		 */
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

		List<String> currentWeekDates = new ArrayList<String>();
		for (int i = 1; i <= 7; i++) {
			currentWeekDates.add(
					formatter.format(LocalDate.now().minusDays(i)).toString());
		}

		// Print list
		System.out.println("LIST OF DATES:");
		for (String x : currentWeekDates) {
			System.out.println(x);
		}

		/*
		 * STEP 2 - Create a String[][] to be used to store the as populated by
		 * utility methods below.
		 */
		// x value = 7 days in a week
		// y = (1)Date (2)Total Time (3)Deep Sleep (4)Awake (5)Light (6)REM
		// (7)TotalSleep
		String[][] sleepLogData = new String[7][7];

		/*
		 * STEP 3 - For each and every date in the last 7 days (as obtained by
		 * the currentWeekDates list), check the CURRENT TABLE PAGE for a record
		 * that starts with that date.
		 */
		for (int i = 0; i < currentWeekDates.size(); i++) {

			SleepLogPageFactory sleepLogPF = new SleepLogPageFactory();

			/*
			 * STEP 3(b) - We are going to loop through two pages of data to
			 * search for these dates. This IF loop accomplishes that
			 */
			int pageIterator = 0;

			do {

				// Grab a list of all the TR's on the visible page
				List<WebElement> currentPageTRs = new ArrayList<WebElement>();
				currentPageTRs = sleepLogPF.getSleepLogTable()
						.getTableRowsForVisibleTable();

				/*
				 * STEP 4 - for each row in this table that starts with the date
				 * in our currentWeekDates row, open the row and extract the
				 * sleep information from the sleep details page.
				 */
				for (int x = 0; x < currentPageTRs.size(); x++) {

					if (currentPageTRs.get(x).getText()
							.startsWith(currentWeekDates.get(i))) {

						String source = sleepLogPF.getSleepLogTable()
								.getCellText(x + 1, "Source");

						// Click Details - This takes us to Sleep Details page
						sleepLogPF.getSleepLogTable().clickLinkInRow(
								currentPageTRs.get(x), "Details");
						assertEquals(readPageTitle(),
								"Sleep Details - Team Fitness Tracker",
								"Sleep Details Page");

						switch (source) {
							case "Manual" :
								storeDataForManualEntry();
								break;
							case "Garmin Connect" :
								storeDataForGarminConnect();
								break;
							case "Fitbit" :
								storeDataForFitbit();
								break;
							default :
								throw new IllegalArgumentException(
										"Invalid device type. Must be Manual, Garmin, or Fitbit.");
						}

						// This prevents a stale reference error.
						currentPageTRs = sleepLogPF.getSleepLogTable()
								.getTableRowsForVisibleTable();
					}
				}

				pageIterator++;

				if (Tables.isSkipToNextNavigationPresent()
						&& pageIterator < 2) {
					Tables.clickSkipToNextNavigationLink();
				}

			} while (Tables.isSkipToNextNavigationPresent()
					&& pageIterator < 2);

			// Get back to the first page after each time we go to the second.
			if (pageIterator == 2) {
				Tables.clickSkipToPreviousNavigationLink();
			}

			/*
			 * STEP 5 - Populate the String [][] with the data
			 */

			sleepLogData[i][0] = date;
			sleepLogData[i][1] = String.valueOf(totalTime)
					.replaceFirst("^0(?!$)", ""); // Transforms 03:12 to 3:12;
			sleepLogData[i][2] = String.valueOf(deepSleepTimeForSleepLog)
					.replaceFirst("^0(?!$)", ""); // Transforms 03:12 to 3:12;;
			sleepLogData[i][3] = String.valueOf(awakeTimeForSleepLog)
					.replaceFirst("^0(?!$)", ""); // Transforms 03:12 to 3:12;;
			sleepLogData[i][4] = String.valueOf(lightSleepTimeForSleepLog)
					.replaceFirst("^0(?!$)", ""); // Transforms 03:12 to 3:12;;
			// Blank if Garmin - Just adding 0:00
			sleepLogData[i][5] = String.valueOf(remSleepTimeForSleepLog)
					.replaceFirst("^0(?!$)", ""); // Transforms 03:12 to 3:12;;
			sleepLogData[i][6] = String.valueOf(totalSleepTimeForLog)
					.replaceFirst("^0(?!$)", ""); // Transforms 03:12 to 3:12;;

			// TODO - Remove
			System.out.println(
					"Summed Sleep time for date " + currentWeekDates.get(i));
			System.out.println("Date: " + date);
			System.out.println("Total Time: " + totalTime);
			System.out.println("Awake: " + awakeTimeForSleepLog);
			System.out.println("Deep Sleep: " + deepSleepTimeForSleepLog);
			System.out.println("Light Sleep: " + lightSleepTimeForSleepLog);
			System.out.println("REM Sleep: " + remSleepTimeForSleepLog);
			System.out.println("Total Sleep: " + totalSleepTimeForLog);

			// Before exiting the loop for a given day, ensure we set the date
			// variables back to 0.
			/*
			 * These variables are to hold the sleep time for a given record on
			 * the Sleep Log page. They are of type LocalTime so that we can
			 * append values in instances where we have more than one sleep
			 * instance per day, e.g., a nap.
			 */
			awakeTimeForSleepLog = LocalTime.of(0, 0);
			deepSleepTimeForSleepLog = LocalTime.of(0, 0);
			lightSleepTimeForSleepLog = LocalTime.of(0, 0);
			remSleepTimeForSleepLog = LocalTime.of(0, 0);
			totalSleepTimeForLog = LocalTime.of(0, 0);

			// Make sure that we start back on the first page of the table
			// again, as we navigated to the second page, if it in fact existed.
			if (Tables.isSkipToPreviousNavigationPresent()) {
				Tables.clickSkipToPreviousNavigationLink();
			}
			System.out.println(Arrays.deepToString(sleepLogData));

		}

		return sleepLogData;

	}

	public String[][] getSleepFromDashboard(String userName) {

		// Create a String array
		// We know we have 7 rows for 7 days.
		// Columns is dynamic, because we could have a Garmin device, which does
		// NOT contain REM sleep
		String[][] dateTimeSleepData = new String[7][7];

		// Scroll the table into the middle of the page. This is necessary to
		// grab tool tips consistently
		WebElement mySleepGraph = driver.findElement(By.id("mySleep"));
		((JavascriptExecutor) driver).executeScript(
				"arguments[0].scrollIntoView(false);", mySleepGraph);

		// DASHBOARD
		// Grabs the Dates for the Weekly Sleep field. Should be a list of 7.
		List<WebElement> dailySleepDates = driver.findElements(By.xpath(
				"//div[@id='mySleep']//div[@class='jqplot-xaxis-tick']"));

		// Because we capture the dates in ascending order, we must reverse it
		// to descending. This is necessary to put the dates in such an order as
		// we can add it to the array.
		Collections.reverse(dailySleepDates);

		// Populate the 0 index with DATE for the entire array.
		for (int i = 0; i <= dailySleepDates.size() - 1; i++) {
			System.out.println(dailySleepDates.get(i).getText() + "/"
					+ LocalDate.now().getYear());
			// We must add year on to end of string (i.e. 1/24 needs to be
			// 1/24/2019)
			String totalDate = dailySleepDates.get(i).getText() + "/"
					+ LocalDate.now().getYear();

			// Creating some formatter objects, converting to localDate, and
			// then back to string to prevent formats of 6/1/2018. Need
			// 06/01/2018 and the following lines address this.
			DateTimeFormatter formatter = DateTimeFormatter
					.ofPattern("M/d/yyyy");
			DateTimeFormatter formatter2 = DateTimeFormatter
					.ofPattern("MM/dd/yyyy");
			LocalDate date = LocalDate.parse(totalDate, formatter);
			totalDate = date.format(formatter2);

			dateTimeSleepData[i][0] = totalDate;
		}

		// Grab the TOTAL SLEEP TIME of the bar

		List<WebElement> dailySleepTimes = driver.findElements(By.xpath(
				"//div[@id='mySleep']//div[contains(@class,'jqplot-point-label jqplot-series-')]"));

		for (int i = 0; i <= dailySleepTimes.size() - 1; i++) {
			System.out.println(dailySleepTimes.get(i).getText());
			// Put the value in the 1 position of the array
			dateTimeSleepData[i][1] = dailySleepTimes.get(i).getText();

			// Used to perform mouse over / click;
			Actions builder = new Actions(driver);

			// This is necessary to move the mouse over the bar and make the
			// tool tip appear with the sleep time values. If it has a time of
			// 0:00, then there will be no tool tip, so we must catch the error.
			try {
				builder.moveToElement(dailySleepTimes.get(i), 10, 10).click()
						.build().perform();
			} catch (MoveTargetOutOfBoundsException e) {

			}

			// If the text is not 0, then grab the tool tip values, else, set
			// the array to 0 for those.
			if (dailySleepTimes.get(i).getText().equals("0:00")) {
				// TODO - populate zeros in array

			} else {

				List<WebElement> toolTipValues = driver.findElements(By.xpath(
						"//div[@class='jqplot-highlighter-tooltip']//tr"));

				// for (WebElement y : toolTipValues) {
				// System.out.println(y.getText());
				// }

				// Column Index for Array
				int columnIndex = 2;// have to start at two because 0 was for
									// date, and 1 was for total sleep of bar
									// graph.
				// for (int x = 0; x <= toolTipValues.size() - 1; x++) {
				boolean remManuallyAdded = false;
				for (int x = 0; x < toolTipValues.size();) {

					String toolTipValue = null;

					// If there is REM sleep, it will be at index 3
					// (0=DeepSleep, 1=Awake, 2=Light, 3=REM, 4=totalSleep)
					if (x == 3 && toolTipValues.size() != 5
							&& remManuallyAdded == false) {
						// If we do not have 5 values, we do not have REM. In
						// instances where it isn't present, put a 0:00 in our
						// array.
						toolTipValue = "REM Sleep: 0:00";
						remManuallyAdded = true;

					} else {

						// E.g. Deep Sleep: 4:23
						toolTipValue = toolTipValues.get(x).getText();
						x++;

					}

					// Strips off text, leaving 4:23
					toolTipValue = toolTipValue
							.substring(toolTipValue.indexOf(":") + 1,
									toolTipValue.lastIndexOf(""))
							.trim();

					System.out.println(toolTipValue);
					dateTimeSleepData[i][columnIndex] = toolTipValue;
					columnIndex++;

				}
				System.out.println();
				System.out.println("*****");
				System.out.println();
			}
		}
		return dateTimeSleepData;
	}

	private void storeDataForManualEntry() {
		AutomationHelper.printMethodName();

		// If the activity source is MANUAL, only store the total sleep. All
		// manual entries are stored as deep sleep. Store other values as 0:00
		SleepDetailsPageFactory sleepDetailsPF = new SleepDetailsPageFactory();

		awakeTimeForSleepLog = LocalTime.of(0, 0)
				.plusHours(awakeTimeForSleepLog.getHour())
				.plusMinutes(awakeTimeForSleepLog.getMinute()); // Basically,
																// 0:00

		lightSleepTimeForSleepLog = LocalTime.of(0, 0)
				.plusHours(lightSleepTimeForSleepLog.getHour())
				.plusMinutes(lightSleepTimeForSleepLog.getMinute()); // Basically,
																		// 0:00
		remSleepTimeForSleepLog = LocalTime.of(0, 0)
				.plusHours(remSleepTimeForSleepLog.getHour())
				.plusMinutes(remSleepTimeForSleepLog.getMinute()); // Basically,
																	// 0:00
		totalSleepTimeForLog = timeStringTransformer(
				sleepDetailsPF.readTotalSleepTime())
						.plusHours(totalSleepTimeForLog.getHour())
						.plusMinutes(totalSleepTimeForLog.getMinute());
		date = sleepDetailsPF.readDate();
		totalTime = totalSleepTimeForLog; // Yes - It's basically a duplicate
											// for comparison on Dashboard

		// Deep sleep does not show up for Manual Entries. Instead, it is a copy
		// of total sleep. Add total sleep to any other sleep time that may
		// exist for another record.
		// deepSleepTimeForSleepLog = totalSleepTimeForLog
		// .plusHours(deepSleepTimeForSleepLog.getHour())
		// .plusMinutes(deepSleepTimeForSleepLog.getMinute()); // Basically,
		// // 0:00
		deepSleepTimeForSleepLog = totalSleepTimeForLog;

		sleepDetailsPF.clickBackToMySleepList();
	}

	private void storeDataForGarminConnect() {
		AutomationHelper.printMethodName();
		SleepDetailsPageFactory sleepDetailsPF = new SleepDetailsPageFactory();

		awakeTimeForSleepLog = timeStringTransformer(
				sleepDetailsPF.readAwakeTime())
						.plusHours(awakeTimeForSleepLog.getHour())
						.plusMinutes(awakeTimeForSleepLog.getMinute());
		deepSleepTimeForSleepLog = timeStringTransformer(
				sleepDetailsPF.readDeepSleepTime())
						.plusHours(deepSleepTimeForSleepLog.getHour())
						.plusMinutes(deepSleepTimeForSleepLog.getMinute());
		lightSleepTimeForSleepLog = timeStringTransformer(
				sleepDetailsPF.readLightSleepTime())
						.plusHours(lightSleepTimeForSleepLog.getHour())
						.plusMinutes(lightSleepTimeForSleepLog.getMinute());
		// REM doesn't exist for Garmin - adding zeros to keep array size same.
		remSleepTimeForSleepLog = timeStringTransformer("00h 00m")
				.plusHours(remSleepTimeForSleepLog.getHour())
				.plusMinutes(remSleepTimeForSleepLog.getMinute());
		totalSleepTimeForLog = timeStringTransformer(
				sleepDetailsPF.readTotalSleepTime())
						.plusHours(totalSleepTimeForLog.getHour())
						.plusMinutes(totalSleepTimeForLog.getMinute());
		date = sleepDetailsPF.readDate();
		totalTime = totalSleepTimeForLog; // Yes - It's basically a duplicate
											// for comparison on Dashboard

		sleepDetailsPF.clickBackToMySleepList();
	}

	private void storeDataForFitbit() {
		AutomationHelper.printMethodName();
		SleepDetailsPageFactory sleepDetailsPF = new SleepDetailsPageFactory();

		awakeTimeForSleepLog = timeStringTransformer(
				sleepDetailsPF.readAwakeTime())
						.plusHours(awakeTimeForSleepLog.getHour())
						.plusMinutes(awakeTimeForSleepLog.getMinute());
		deepSleepTimeForSleepLog = timeStringTransformer(
				sleepDetailsPF.readDeepSleepTime())
						.plusHours(deepSleepTimeForSleepLog.getHour())
						.plusMinutes(deepSleepTimeForSleepLog.getMinute());
		lightSleepTimeForSleepLog = timeStringTransformer(
				sleepDetailsPF.readLightSleepTime())
						.plusHours(lightSleepTimeForSleepLog.getHour())
						.plusMinutes(lightSleepTimeForSleepLog.getMinute());
		remSleepTimeForSleepLog = timeStringTransformer(
				sleepDetailsPF.readREMSleepTime())
						.plusHours(remSleepTimeForSleepLog.getHour())
						.plusMinutes(remSleepTimeForSleepLog.getMinute());
		totalSleepTimeForLog = timeStringTransformer(
				sleepDetailsPF.readTotalSleepTime())
						.plusHours(totalSleepTimeForLog.getHour())
						.plusMinutes(totalSleepTimeForLog.getMinute());
		date = sleepDetailsPF.readDate();
		totalTime = totalSleepTimeForLog; // Yes - It's basically a duplicate
											// for comparison on Dashboard

		sleepDetailsPF.clickBackToMySleepList();
	}

	/**
	 * Utility method to pass in a time string of format 01h 23m or 13h 01m and
	 * return a time of 1:23 or 13:01.
	 * 
	 * @param time
	 * @return LocalTime e.g. 3:45 or 13:18
	 */
	private LocalTime timeStringTransformer(String time) {

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("H:mm",
				Locale.ENGLISH);

		// The following removes leading zeroes, but leaves one if necessary
		// (i.e. it wouldn't just turn "0" to a blank string).
		// The ^ anchor will make sure that the 0+ being matched is at the
		// beginning of the input. The (?!$) negative lookahead ensures that not
		// the entire string will be matched.
		// time = time.replace("h", "").replace("m", "")
		// .replace(" ", ":").replaceFirst("^0+(?!$)", "");

		time = time.replace("h", "").replace("m", "").replace(" ", ":")
				.replaceFirst("^0(?!$)", "");

		return LocalTime.parse(time, formatter);
	}

}
