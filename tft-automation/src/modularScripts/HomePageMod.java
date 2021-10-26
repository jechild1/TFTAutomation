package modularScripts;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.openqa.selenium.WebElement;

import configuration.TFTConfig;
import pageFactories.HomePageFactory;
import pageFactories.MenusPageFactory;
import pageFactories.MyMenu.MyCalorieIntake.MyCalorieIntakePageFactory;
import utilities.AutomationHelper;
import utilities.Tables;

public class HomePageMod extends TFTConfig {

	/**
	 * Constructor takes in a driver from the calling script
	 */
	public HomePageMod() {
	}

	/**
	 * Method to check the My Calorie Intake table for the last 7 days of food,
	 * and compare to the last 7 Nutritional Items on the dashboard.
	 * <p>
	 * This method:
	 * <ul>
	 * <li>Starts on the home page
	 * <li>Navigates to the Calorie Intake page and grabs the last 7 records
	 * <li>Returns to the home page and grabs the Last 7 Nutritional Items
	 * <li>Compares the two values to ensure they are the same
	 * </ul>
	 */
	public void validateLast7NutritionalItems() {

		AutomationHelper.printClassName();
		AutomationHelper.printMethodName();

		// Assume user starts from Home Page...

		// Navigate to the Calorie Intake page and grab the last 7 nutritional
		// items
		// from the table. Store in a list array.

		MenusPageFactory menus = new MenusPageFactory();
		menus.clickMyCalorieIntake();

		MyCalorieIntakePageFactory calorieIntake = new MyCalorieIntakePageFactory();
		Tables calorieIntakeTable = calorieIntake.getMyCalorieIntakeTable();

		// List to store all the rows for the visible table on the calorie
		// intake page.
		List<WebElement> myCalorieIntakeList = calorieIntakeTable
				.getTableRowsForVisibleTable();

		// Print the array list to the console, for reference
		System.out.println("**Calorie Intake List***");
		for (WebElement x : myCalorieIntakeList) {
			System.out.println(x.getText());
		}
		System.out.println();

		// List (string) to store the calorie intake list after (a)Storing only
		// the last
		// 7 days and (b) formatting the data so that we can compare it to the
		// other
		// table.
		List<String> formattedCalorieIntake = new ArrayList<String>();

		// Obtain the table size. This is necessary to know how many times to
		// loop.
		// There will be a maximum of 10 records on the first page.
		int rowCount = myCalorieIntakeList.size();

		// By putting the && in the for loop, were able to either cycle through
		// what
		// rows are in the table, or cut it off when it gets to 7 (one weeks
		// data)
		for (int x = 1; (x <= rowCount && x <= 7); x++) {

			// local string to concatenate the table values
			String concatenatedString = "";

			String foodName = calorieIntakeTable.getCellText(x, "Food Name");

			// If the row is Water, we don't want to add it. Else, we want to.
			if (foodName.equals("Water")) {
				continue;
			} else {

				// Food Name
				concatenatedString = foodName;

				// Calories
				// Temporarily remove .0
				String caloriesString = calorieIntakeTable.getCellText(x,
						"Calories");
				caloriesString = caloriesString.substring(0,
						caloriesString.indexOf("."));
				concatenatedString += " " + caloriesString;

				// Date - Goal is to change 04/06/2018 to 4/6
				String rawDate = calorieIntakeTable.getCellText(x,
						"Date Consumed");
				DateTimeFormatter formatter = DateTimeFormatter
						.ofPattern("MM/dd/yyyy", Locale.ENGLISH);
				DateTimeFormatter formatter2 = DateTimeFormatter
						.ofPattern("M/d", Locale.ENGLISH);
				LocalDate formattedDate = LocalDate.parse(rawDate, formatter);
				concatenatedString += " " + formatter2.format(formattedDate);

				// Add the formatted data to the formattedCalorieIntake list
				// array.
				formattedCalorieIntake.add(concatenatedString);
			}
		}

		// Print the array list to the console, for reference
		System.out.println("**Formatted Calorie Intake List***");
		for (String x : formattedCalorieIntake) {
			System.out.println(x);
		}
		System.out.println();

		// Go back to the home page.
		menus.clickHomeLink();

		// Get the table on the home page.
		HomePageFactory home = new HomePageFactory();
		Tables last7NutritionalItemsTable = home
				.getLast7NutritionalItemsTable();

		List<WebElement> last7NutritinalItemsList = last7NutritionalItemsTable
				.getTableRowsForVisibleTable();
		// Print the array list to the console, for reference
		System.out.println("**Last 7 Nutritional Items List***");
		for (WebElement x : last7NutritinalItemsList) {
			System.out.println(x.getText());
		}
		System.out.println();

		// First, check size to ensure that the arrays are the same size. If
		// not, we
		// have an issue.
		if (formattedCalorieIntake.size() == last7NutritinalItemsList.size()) {

			// Compare the two tables to ensure the values are the same. This is
			// where the
			// verification points are executed.
			for (int x = 0; x < formattedCalorieIntake.size(); x++) {

				softAsserter.assertEquals(formattedCalorieIntake.get(x),
						last7NutritinalItemsList.get(x).getText(),
						"Food Table Comparison row " + x + ": ");
			}

			softAsserter.assertAll();

		} else {
			throw new ArrayIndexOutOfBoundsException(
					"The two lists are not the same for Calorie Intake and Last 7 Nutritional Items");
		}

	}

}
