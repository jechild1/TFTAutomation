package modularScripts;

import static org.testng.Assert.assertTrue;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriverException;

import configuration.TFTConfig;
import pageFactories.MyMenu.MyActivities.CreateActivityPageFactory;
import pageFactories.MyMenu.MyActivities.MyActivitiesPageFactory;
import utilities.AutomationHelper;
import utilities.ExcelDataConfig;
import utilities.Tables;

/**
 * This Modular Class analyzes the current records for Activity Log for the past
 * 7 days. For each day that does not have a food entry, the
 * addActivityForWeek() method will add a record for a given day.
 * 
 * PRE-CONDITION: User is on the HOME page when this script starts.
 * POST-CONDITION: User is navigated back to the HOME page.
 * 
 * @author jesse.childress
 *
 */
public class CreateNewActivityMod extends TFTConfig {

	/**
	 * Page Constructor that takes in a driver from the calling script
	 * 
	 * @param driver
	 */
	public CreateNewActivityMod() {
		// TestConfig.driver = driver;
	}

	/**
	 * This method analyzes the current records for Activity Log table for the
	 * past 7 days. For each day that does not have a food entry, this method
	 * will add a record for a given day.
	 */
	public void addActivityForCurrentDate() {

		AutomationHelper.printClassName();
		AutomationHelper.printMethodName();

		// CREATE NEW ACTIVITY PAGE

		// Grab the current system date and store a week of dates in a
		// String
		// Array.Java 8 API
		LocalDate currentSystemDate = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

		CreateActivityPageFactory createActivity = new CreateActivityPageFactory();
		MyActivitiesPageFactory activityLog = new MyActivitiesPageFactory();

		/*
		 * The next section takes all of the dates for the last 7 days that
		 * currently do not have a food item added to it, and adds a record.
		 */

		// Declare worksheet
		String excelFilePath = generateFullFileNameAndPath(
				"AddActivities.xlsx");
		String excelWorksheetName = "Activities";
		ExcelDataConfig excelFile = new ExcelDataConfig(excelFilePath,
				excelWorksheetName);

		// for (String currentDateInList : weekOfDates) {

		// Click the Create New Activity button
		activityLog.clickCreateNewActivity();

		/*
		 * DECLARE AND ASSIGN VARIABLES TO BE USED
		 */
		String date;
		String activity;
		String timeOfDay;
		String measuredBy;
		String durationMinutes;
		String durationSeconds;
		String distance;
		String steps;
		String repetitions;
		String intensity;
		String mood;
		String exerciseName;
		String weight;
		String sets;
		String repsPerSet;

		String dayOfMonth = String.valueOf(currentSystemDate.getDayOfMonth());
		date = currentSystemDate.format(formatter).toString();

		activity = excelFile.getData(
				excelFile.getRowIndex("DayOfMonth", dayOfMonth),
				excelFile.getColumnIndex("Activity"));
		timeOfDay = excelFile.getData(
				excelFile.getRowIndex("DayOfMonth", dayOfMonth),
				excelFile.getColumnIndex("TimeOfDay"));
		measuredBy = excelFile.getData(
				excelFile.getRowIndex("DayOfMonth", dayOfMonth),
				excelFile.getColumnIndex("MeasuredBy"));
		durationMinutes = excelFile.getData(
				excelFile.getRowIndex("DayOfMonth", dayOfMonth),
				excelFile.getColumnIndex("DurationMinutes"));
		durationSeconds = excelFile.getData(
				excelFile.getRowIndex("DayOfMonth", dayOfMonth),
				excelFile.getColumnIndex("DurationSeconds"));
		distance = excelFile.getData(
				excelFile.getRowIndex("DayOfMonth", dayOfMonth),
				excelFile.getColumnIndex("Distance"));
		steps = excelFile.getData(
				excelFile.getRowIndex("DayOfMonth", dayOfMonth),
				excelFile.getColumnIndex("Steps"));
		repetitions = excelFile.getData(
				excelFile.getRowIndex("DayOfMonth", dayOfMonth),
				excelFile.getColumnIndex("Repetitions"));
		intensity = excelFile.getData(
				excelFile.getRowIndex("DayOfMonth", dayOfMonth),
				excelFile.getColumnIndex("Intensity"));
		mood = excelFile.getData(
				excelFile.getRowIndex("DayOfMonth", dayOfMonth),
				excelFile.getColumnIndex("Mood"));
		exerciseName = excelFile.getData(
				excelFile.getRowIndex("DayOfMonth", dayOfMonth),
				excelFile.getColumnIndex("ExerciseName"));
		weight = excelFile.getData(
				excelFile.getRowIndex("DayOfMonth", dayOfMonth),
				excelFile.getColumnIndex("Weight"));
		sets = excelFile.getData(
				excelFile.getRowIndex("DayOfMonth", dayOfMonth),
				excelFile.getColumnIndex("Sets"));
		repsPerSet = excelFile.getData(
				excelFile.getRowIndex("DayOfMonth", dayOfMonth),
				excelFile.getColumnIndex("RepsPerSet"));

		/*
		 * POPULATE DATA ON CREATE ACTIVITY PAGE
		 */
		createActivity.selectActivity(activity);
		// We do a .contains here because we dont know if were doing air
		// force of army PFT. This covers both.
		softAsserter.assertTrue(
				createActivity.readActivity().contains(activity),
				"Activity field: ");

		createActivity.setDate(date, timeOfDay);
		softAsserter.assertEquals(createActivity.readDate(),
				date + " " + timeOfDay, "Date field: ");

		// For Duration / Distance / Steps, choose one based on the Measured
		// By value in the datasheet

		switch (measuredBy) {
			case "Distance" :
				createActivity.setDistance(distance);
				softAsserter.assertEquals(createActivity.readDistance(),
						distance, "Distance Field:");
				break;
			case "Duration" :
				createActivity.setDuration(durationMinutes);
				softAsserter.assertEquals(createActivity.readDuration(),
						durationMinutes, "Duration - Minutes field: ");

				// For PFT Mile and perhaps others, seconds is enabled
				if (durationSeconds != null) {
					createActivity.setDurationSeconds(durationSeconds);
					softAsserter.assertEquals(
							createActivity.readDurationSeconds(),
							durationSeconds, "Duration - Seconds field: ");

				}
				break;
			case "Steps" :
				createActivity.setSteps(steps);
				softAsserter.assertEquals(createActivity.readSteps(), steps,
						"Steps field: ");

				break;

			default :
				throw new IllegalArgumentException(
						"Datasheet must have correct value for Distance, Duration or Steps in MeasuredBy column");
		}

		// If we have a value for Repetitions, enter it (this is for PFT
		// primarily)
		if (repetitions != "") {
			createActivity.setRepetitions(repetitions);
			softAsserter.assertEquals(createActivity.readRepetitions(),
					repetitions, "Repetitions field: ");
		}

		// If we are weight lifting, we have several more fields to populate
		if (activity.equals("Weight lifting")) {
			createActivity.setExerciseName(exerciseName);
			softAsserter.assertEquals(createActivity.readExerciseName(),
					exerciseName, "Exercise Name field: ");

			createActivity.setExerciseWeight(weight);
			softAsserter.assertEquals(createActivity.readExerciseWeight(),
					weight, "Exercise Weight field: ");

			createActivity.setExerciseSets(sets);
			softAsserter.assertEquals(createActivity.readExerciseSets(), sets,
					"Exercise Sets field: ");

			createActivity.setExerciseRepsPerSet(repsPerSet);
			softAsserter.assertEquals(createActivity.readExerciseRepsPerSet(),
					repsPerSet, "Exercise Reps Per Set field: ");

			createActivity.clickAddWorkoutEntry();

			// Check that the value made it to the table
			assertTrue(
					createActivity.getWeightLiftingTable().isRowInTable(
							exerciseName, weight + " lbs", sets, repsPerSet),
					"Weight Lifting Table: ");

		}

		// Additional Metrics
		createActivity.selectIntensity(intensity);
		softAsserter.assertEquals(createActivity.readIntensity(), intensity,
				"Intensity field: ");

		createActivity.selectMood(mood);
		softAsserter.assertEquals(createActivity.readMood(), mood,
				"Mood field: ");

		// Catch any data discrepancies
		softAsserter.assertAll();

		// Click Create at the end of the page.
		createActivity.clickCreate();

		/*
		 * SEARCH THE MY ACTIVITY LOG TABLE FOR THE VALUE
		 */
		// If not found, cycle through the first 4 pages to try to find it.
		boolean rowFound = false;
		int loopCount = 0;

		do {

			switch (measuredBy) {
				case "Duration" :
					rowFound = activityLog.getMyActivityLogTable().isRowInTable(
							activity, date + " " + timeOfDay, durationMinutes);
					break;
				case "Distance" :
					rowFound = activityLog.getMyActivityLogTable().isRowInTable(
							activity, date + " " + timeOfDay, distance);
					break;
				case "Steps" :
					rowFound = activityLog.getMyActivityLogTable().isRowInTable(
							activity, date + " " + timeOfDay, steps);
					break;

				default :
					throw new WebDriverException(
							"Measured By did not evaluate");
			}

			if (rowFound) {
				break;
			}

			// Attempt to click the next arrow
			if (Tables.isSkipToNextNavigationPresent()) {
				Tables.getSkipToNextNavigationLink(driver).click();
			} else {
				throw new ElementNotInteractableException(
						"The next navigation button is not present on the Add Activity Log page.");
			}

			loopCount++;

		} while ((!rowFound) && loopCount <= 6);

		if (!rowFound) {
			throw new WebDriverException("Could Not Find a row with data: \n"
					+ "Activity: " + activity + "\n" + "Date/Time: " + date
					+ " " + timeOfDay + "\n" + "Duration: " + durationMinutes
					+ "\n" + "Steps: " + steps + "\n" + "Distance: " + distance
					+ "\n");
		}

	}

}
