package modularScripts;

import static org.testng.Assert.assertEquals;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import configuration.TFTConfig;
import pageFactories.AddWaterIntakePageFactory;
import pageFactories.MyMenu.MyCalorieIntake.MyCalorieIntakePageFactory;
import utilities.AutomationHelper;
import utilities.ExcelDataConfig;
import utilities.Tables;

/**
 * This Modular Class analyzes the current records for Calorie Intake for the
 * past 7 days. For each day that does not have a food entry, the
 * addFoodIntakeForWeek() method will add a record for a given day.
 * 
 * PRE-CONDITION: User is on the HOME page when this script starts.
 * POST-CONDITION: User is navigated back to the HOME page.
 * 
 * @author jesse.childress
 *
 */
public class AddWaterIntakeMod extends TFTConfig {

	/**
	 * Page Constructor that takes in a driver from the calling script
	 */
	public AddWaterIntakeMod() {
	}

	/**
	 * This method analyzes the current records for Calorie Intake for the past
	 * 7 days. For each day that does not have a food entry, this method will
	 * add a record for a given day.
	 */
	public void addWaterIntakeForWeek() {
		AutomationHelper.printClassName();
		AutomationHelper.printMethodName();

		// MY CALORIE INTAKE PAGE

		// Grab the current system date and store a week of dates in a String
		// Array.Java 8 API
		LocalDate currentSystemDate = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

		// Create an array of 7 days based on todays day, minus 7 days
		List<String> weekOfDates = new ArrayList<String>();
		for (int i = 0; i <= 6; i++) {
			weekOfDates.add(currentSystemDate.minusDays(i).format(formatter));
		}

		MyCalorieIntakePageFactory calIntake = new MyCalorieIntakePageFactory();
		int pagingAttempts = 1;
		boolean skipToNextNavigationLinkPresent;

		/*
		 * This DO WHILE loop cycles through the first three pages of the
		 * Calorie Intake tables to gather dates from the table. For each page,
		 * it looks to see if the dates in the list above (the last 7 days) is
		 * found in the table. If it is, we DO NOT need to add a water item for
		 * it. As such, we remove it from the list so that in the end, we have a
		 * list (weekOfDates) that only has days for the past 7 days that
		 * currently DO NOT have a water intake item in it.
		 */
		do {

			// Get the current table
			Tables table = calIntake.getMyCalorieIntakeTable();

			// Cycle through the week of dates. If the date is in the current
			// table, AND there is an entry that says WATER in the Date Consumed
			// column, then remove that date from
			// the list as it will not need to have a water added.
			List<String> datesToRemove = new ArrayList<String>();
			for (String currentDateInList : weekOfDates) {
				String dateConsumedInTable = table.readTableRowValue(
						"Date Consumed", currentDateInList + ".*",
						"Date Consumed", false);
				String waterInFoodNameTable = table.readTableRowValue(
						"Date Consumed", currentDateInList + ".*", "Food Name",
						false);

				if (dateConsumedInTable != null
						&& waterInFoodNameTable.equals("Water")) {
					datesToRemove.add(currentDateInList);
				}
			}
			// Remove items collected for removal
			weekOfDates.removeAll(datesToRemove);
			// weekOfDates.forEach(System.out::println);

			// See if there exists a link to page. If so, click it
			skipToNextNavigationLinkPresent = Tables
					.isSkipToNextNavigationPresent();
			if (skipToNextNavigationLinkPresent) {
				Tables.getSkipToNextNavigationLink(driver).click();
			}

			pagingAttempts++;
			// TODO - NAVIGATE BACK TO FIRST PAGE
		} while (pagingAttempts <= 3 && skipToNextNavigationLinkPresent);

		/*
		 * The next section takes all of the dates for the last 7 days that
		 * currently do not have a food item added to it, and adds a record.
		 */

		// Declare worksheet

		String excelFilePath = generateFullFileNameAndPath(
				"AddWaterIntake.xlsx");
		String excelWorksheetName = "Manual";
		ExcelDataConfig excelFile = new ExcelDataConfig(excelFilePath,
				excelWorksheetName);

		for (String currentDateInList : weekOfDates) {

			// Click the Add Food Intake button
			calIntake.clickAddWaterIntake();
			AutomationHelper.waitForPageToLoad(NORMAL_TIMEOUT);
			assertEquals(readPageTitle(),
					"Add Water Intake - Team Fitness Tracker",
					"Add Water Intake page title:");

			// Now on the Add Food Intake page

			// SET UP DATA VALUES FROM SHEET
			String dayOfWeek = LocalDate.parse(currentDateInList, formatter)
					.getDayOfWeek().toString();

			String dateConsumed = currentDateInList;

			String cupsOfWater = excelFile.getData(
					excelFile.getRowIndex("DayOfWeek", dayOfWeek),
					excelFile.getColumnIndex("CupsOfWater"));

			// FOOD INTAKE PAGE
			AddWaterIntakePageFactory addWater = new AddWaterIntakePageFactory();
			addWater.setDateConsumed(dateConsumed);
			addWater.setCupsOfWater(cupsOfWater);;

			// Execute verification points
			softAsserter.assertEquals(addWater.readDateConsumed(), dateConsumed,
					"Date Consumed Assert:");
			softAsserter.assertEquals(addWater.readCupsOfWater(), cupsOfWater,
					"Cups of Water Assert:");
			softAsserter.assertAll();

			addWater.clickCreate();
			AutomationHelper.waitForPageToLoad(NORMAL_TIMEOUT);
			assertEquals(readPageTitle(),
					"My Calorie Intake - Team Fitness Tracker",
					"Add Calorie Intake page title:");

		}
	}
}
