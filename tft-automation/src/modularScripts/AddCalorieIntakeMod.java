package modularScripts;

import static org.testng.Assert.assertTrue;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import configuration.TFTConfig;
import pageFactories.AddFoodIntakePageFactory;
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
public class AddCalorieIntakeMod extends TFTConfig {

	/**
	 * Page Constructor that takes in a driver from the calling script
	 */
	public AddCalorieIntakeMod() {
	}

	/**
	 * This method analyzes the current records for Calorie Intake for the past
	 * 7 days. For each day that does not have a food entry, this method will
	 * add a record for a given day.
	 */
	public void addFoodIntakeForWeek() {
		AutomationHelper.printClassName();
		AutomationHelper.printMethodName();

		// MY CALORIE INTAKE PAGE

		// Grab the current system date and store a week of dates in a String
		// Array.Java 8 API
		LocalDate currentSystemDate = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

		// Create an array of 7 days based on todays day, minus 7 days
		List<String> weekOfDates = new ArrayList<String>();
		for (int i = 0; i <= 7; i++) {
			weekOfDates.add(currentSystemDate.minusDays(i).format(formatter));
		}

		MyCalorieIntakePageFactory calIntake = new MyCalorieIntakePageFactory();
		int pagingAttempts = 1;
		boolean skipToNextNavigationLinkPresent;

		/*
		 * This DO WHILE loop cycles through the first three pages of the
		 * Calorie Intake tables to gather dates from the table. For each page,
		 * it looks to see if the dates in the list above (the last 7 days) is
		 * found in the table. If it is, we DO NOT need to add a food item for
		 * it. As such, we remove it from the list so that in the end, we have a
		 * list (weekOfDates) that only has days for the past 7 days that
		 * currently DO NOT have a food item in it.
		 */
		do {

			// Get the current table
			Tables table = calIntake.getMyCalorieIntakeTable();

			// Cycle through the week of dates. If the date is in the current
			// table, in the Date Consumed column, then remove that date from
			// the list as it will not need to have a food added.
			List<String> datesToRemove = new ArrayList<String>();
			for (String currentDateInList : weekOfDates) {

				if (table.readTableRowValue("Date Consumed",
						currentDateInList + ".*", "Date Consumed",
						false) != null) {
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
				"AddFoodIntake.xlsx");
		String excelWorksheetName = "Manual";
		ExcelDataConfig excelFile = new ExcelDataConfig(excelFilePath,
				excelWorksheetName);

		for (String currentDateInList : weekOfDates) {

			// Click the Add Food Intake button
			calIntake.clickAddFoodIntake();

			// Now on the Add Food Intake page

			// SET UP DATA VALUES FROM SHEET
			// We always add the same food for the same day of the week. E.g.
			// Monday is always Bagels.
			String dayOfWeek = LocalDate.parse(currentDateInList, formatter)
					.getDayOfWeek().toString();

			String dateConsumed = currentDateInList;
			String mealType = excelFile.getData(
					excelFile.getRowIndex("DayOfWeek", dayOfWeek),
					excelFile.getColumnIndex("MealType"));
			String servingsConsumed = excelFile.getData(
					excelFile.getRowIndex("DayOfWeek", dayOfWeek),
					excelFile.getColumnIndex("ServingsConsumed"));
			String foodName = excelFile.getData(
					excelFile.getRowIndex("DayOfWeek", dayOfWeek),
					excelFile.getColumnIndex("FoodName"));
			String servingSize = excelFile.getData(
					excelFile.getRowIndex("DayOfWeek", dayOfWeek),
					excelFile.getColumnIndex("ServingSize"));
			String servingUnits = excelFile.getData(
					excelFile.getRowIndex("DayOfWeek", dayOfWeek),
					excelFile.getColumnIndex("ServingUnits"));
			String calories = excelFile.getData(
					excelFile.getRowIndex("DayOfWeek", dayOfWeek),
					excelFile.getColumnIndex("Calories"));

			// FOOD INTAKE PAGE
			AddFoodIntakePageFactory addFood = new AddFoodIntakePageFactory();
			addFood.setDateConsumed(dateConsumed);
			addFood.selectMealType(mealType);
			addFood.setServingsConsumed(servingsConsumed);
			addFood.setFoodName(foodName);

			// Execute verification points
			softAsserter.assertEquals(addFood.readDateConsumed(), dateConsumed,
					"Date Consumed Assert:");
			softAsserter.assertEquals(addFood.readMealType(), mealType,
					"Meal Type Assert:");
			softAsserter.assertEquals(addFood.readServingsConsumed(),
					servingsConsumed, "Servings Consumed Assert:");
			softAsserter.assertEquals(addFood.readFoodName(), foodName,
					"Food Name Assert:");
			softAsserter.assertAll();

			// Click the Look up Nutritional Info button after setting the food
			// name
			addFood.clickLookupNutritionalInfo();
			// Because the modal fades in, we have to pause to allow ample time.
			// We can't wait for objects because it finds them and tries to
			// proceed
			AutomationHelper.waitSeconds(2);

			// See if the food name is in the table. If so, click it and use the
			// Lookup Entry method. If not, close out the window and validate
			// the Manual Entry field.
			boolean foodPresent = addFood.getNutritionalInformatonTable()
					.isRowInTable(foodName, "local");

			if (foodPresent) {
				// Click the Select button in the row were looking for
				addFood.getNutritionalInformatonTable()
						.clickButtonInRow(foodName, "local", "Select");

				// Execute verification points for Lookup Entry
				softAsserter.assertEquals(addFood.readLookupEntryFoodName(),
						foodName, "Food Name Assert:");
				softAsserter.assertEquals(addFood.readLookupEntryServingSize(),
						servingSize, "Serving Size Assert:");
				softAsserter.assertEquals(addFood.readLookupEntryServingUnits(),
						servingUnits, "Serving Units Assert:");
				softAsserter.assertEquals(addFood.readLookupEntryCalories(),
						calories, "Calories Assert:");
				softAsserter.assertAll();

			} else if (!foodPresent) {
				WebDriverWait wait = new WebDriverWait(driver, 10);
				// Close the lookup table
				WebElement closeTableX = driver
						.findElement(By.id("foodLookupModalCloseButton"));
				// Wait until the X is present
				wait.until(
						ExpectedConditions.elementToBeClickable(closeTableX));
				closeTableX.click();

				// Wait two seconds for the modal to fade out
				AutomationHelper.waitSeconds(2);

				// Execute verification points for manual entry
				addFood.setManualEntryServingSize(servingSize);
				addFood.setManualEntryServingUnits(servingUnits);
				addFood.setManualEntryCalories(calories);

				softAsserter.assertEquals(addFood.readManualEntryServingSize(),
						servingSize, "Serving Size Assert:");
				softAsserter.assertEquals(addFood.readManualEntryServingUnits(),
						servingUnits, "Serving Units Assert:");
				softAsserter.assertEquals(addFood.readManualEntryCalories(),
						calories, "Calories Assert:");
				softAsserter.assertAll();

			}

			addFood.clickCreate();

			// Validate that the entry was added on the My Calorie Intake page.
			assertTrue(
					calIntake.getMyCalorieIntakeTable()
							.isRowInTable(currentDateInList, foodName),
					"Food Added to Table");
		}
	}
}
