package pageFactories.MyMenu.MyActivities;

import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import configuration.TFTConfig;
import utilities.AutomationHelper;
import utilities.Tables;

public class CreateActivityPageFactory extends TFTConfig {

	/**
	 * Page Constructor: Accepts the WebDriver from the calling page &
	 * instantiates the elements on the page.
	 */
	public CreateActivityPageFactory() {
		// this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "Activity")
	WebElement activityDropdown;

	@FindBy(id = "activityStartTime")
	WebElement dateField;

	@FindBy(id = "durationInput")
	WebElement durationField;

	@FindBy(id = "DurationSeconds")
	WebElement durationSecondsField;

	@FindBy(id = "distanceInput")
	WebElement distanceField;

	@FindBy(id = "stepsInput")
	WebElement stepsField;

	@FindBy(id = "PFTAchievement")
	WebElement repetitionsField;

	@FindBy(id = "exerName")
	WebElement exerciseNameField;

	@FindBy(id = "exerWeight")
	WebElement exerciseWeightField;

	@FindBy(id = "exerSets")
	WebElement exerciseSetsField;

	@FindBy(id = "exerReps")
	WebElement exerciseRepsPerSetField;

	@FindBy(id = "btnAddWeightLiftEntry")
	WebElement addWorkoutEntryLink;

	@FindBy(id = "workOutList")
	WebElement workOutListTable;

	@FindBy(id = "IntensityReportedManuallyId")
	WebElement intensityDropdown;

	@FindBy(id = "MoodId")
	WebElement moodDropdown;

	@FindBy(xpath = "//input[@value='Create']")
	WebElement createButton;

	/**
	 * Reads the value of the Date Field.
	 * 
	 * @return String
	 */
	public String readDate() {
		AutomationHelper.printMethodName();
		return dateField.getAttribute("value");
	}

	/**
	 * Sets the Date field with the passed in date.
	 * 
	 * @param date
	 *            - dd/MM/yyyy format
	 */
	public void setDate(String date, String time) {
		AutomationHelper.printMethodName();
		dateField.clear();
		dateField.click();
		AutomationHelper.setCalendarDate(date, time);
	}

	/**
	 * Reads the value of the Activity drop down box.
	 * 
	 * @return String - the currently selected option in the Meal Type field.
	 */
	public String readActivity() {

		AutomationHelper.printMethodName();
		Select activityDropdown = new Select(this.activityDropdown);
		String activity = activityDropdown.getFirstSelectedOption().getText();
		return activity;
	}

	/**
	 * Selects a value from the Activity drop down, corresponding with the
	 * passed in value.
	 * 
	 * @param activity
	 */
	public void selectActivity(String activity) {

		AutomationHelper.printMethodName();
		Select myDropDown = new Select(this.activityDropdown);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(
				ExpectedConditions.elementToBeClickable(this.activityDropdown));

		myDropDown.selectByVisibleText(activity);
		AutomationHelper.wait(1);
	}

	/**
	 * Reads the value of the Duration Field.
	 * 
	 * @return String
	 */
	public String readDuration() {
		AutomationHelper.printMethodName();
		return durationField.getAttribute("value");
	}

	/**
	 * Sets the Duration field with the passed in value.
	 * 
	 * @param duration
	 */
	public void setDuration(String duration) {
		AutomationHelper.printMethodName();

		// Try catch necessary because for PFT items, we try to clear stuff that
		// disabled. This can throw an exception.
		try {
			this.durationField.clear();
			this.durationField.sendKeys(duration);

		} catch (InvalidElementStateException e) {

		}

	}

	/**
	 * Reads the value of the Duration Seconds Field.
	 * 
	 * @return String
	 */
	public String readDurationSeconds() {
		AutomationHelper.printMethodName();
		return durationSecondsField.getAttribute("value");
	}

	/**
	 * Sets the Duration Seconds field with the passed in value.
	 * 
	 * @param durationSeconds
	 */
	public void setDurationSeconds(String durationSeconds) {
		AutomationHelper.printMethodName();
		// Try catch necessary because for PFT items, we try to clear stuff that
		// disabled. This can throw an exception.
		try {
			this.durationSecondsField.clear();
			this.durationSecondsField.sendKeys(durationSeconds);

		} catch (InvalidElementStateException e) {

		}
	}

	/**
	 * Reads the value of the Distance Field.
	 * 
	 * @return String
	 */
	public String readDistance() {
		AutomationHelper.printMethodName();
		return distanceField.getAttribute("value");
	}

	/**
	 * Sets the Distance field with the passed in value.
	 * 
	 * @param distance
	 */
	public void setDistance(String distance) {
		AutomationHelper.printMethodName();
		// Try catch necessary because for PFT items, we try to clear stuff that
		// disabled. This can throw an exception.
		try {
			this.distanceField.clear();
			this.distanceField.sendKeys(distance);

		} catch (InvalidElementStateException e) {

		}
	}

	/**
	 * Reads the value of the Steps Field.
	 * 
	 * @return String
	 */
	public String readSteps() {
		AutomationHelper.printMethodName();
		return stepsField.getAttribute("value");
	}

	/**
	 * Sets the Steps field with the passed in value.
	 * 
	 * @param steps
	 */
	public void setSteps(String steps) {
		AutomationHelper.printMethodName();

		// Try catch necessary because for PFT items, we try to clear stuff that
		// disabled. This can throw an exception.
		try {
			this.stepsField.clear();
			this.stepsField.sendKeys(steps);

		} catch (InvalidElementStateException e) {

		}

	}

	/**
	 * Reads the value of the Repetitions Field.
	 * 
	 * @return String
	 */
	public String readRepetitions() {
		AutomationHelper.printMethodName();
		return repetitionsField.getAttribute("value");
	}

	/**
	 * Sets the Repetitions field with the passed in value.
	 * 
	 * @param repetitions
	 */
	public void setRepetitions(String repetitions) {
		AutomationHelper.printMethodName();
		this.repetitionsField.clear();
		this.repetitionsField.sendKeys(repetitions);
	}

	/**
	 * Reads the value of the Exercise Name Field.
	 * 
	 * @return String
	 */
	public String readExerciseName() {
		AutomationHelper.printMethodName();
		return exerciseNameField.getAttribute("value");
	}

	/**
	 * Sets the Exercise Name field with the passed in value.
	 * 
	 * @param exerciseName
	 */
	public void setExerciseName(String exerciseName) {
		AutomationHelper.printMethodName();

		this.exerciseNameField.clear();
		this.exerciseNameField.sendKeys(exerciseName);
	}

	/**
	 * Reads the value of the Exercise Weight Field.
	 * 
	 * @return String
	 */
	public String readExerciseWeight() {
		AutomationHelper.printMethodName();
		return exerciseWeightField.getAttribute("value");
	}

	/**
	 * Sets the Exercise Weight field with the passed in value.
	 * 
	 * @param exerciseWeight
	 */
	public void setExerciseWeight(String exerciseWeight) {
		AutomationHelper.printMethodName();

		this.exerciseWeightField.clear();
		this.exerciseWeightField.sendKeys(exerciseWeight);
	}

	/**
	 * Reads the value of the Exercise Sets Field.
	 * 
	 * @return String
	 */
	public String readExerciseSets() {
		AutomationHelper.printMethodName();
		return exerciseSetsField.getAttribute("value");
	}

	/**
	 * Sets the Exercise Sets field with the passed in value.
	 * 
	 * @param exerciseSets
	 */
	public void setExerciseSets(String exerciseSets) {
		AutomationHelper.printMethodName();

		this.exerciseSetsField.clear();
		this.exerciseSetsField.sendKeys(exerciseSets);
	}

	/**
	 * Reads the value of the Exercise Reps per Set Field.
	 * 
	 * @return String
	 */
	public String readExerciseRepsPerSet() {
		AutomationHelper.printMethodName();
		return exerciseRepsPerSetField.getAttribute("value");
	}

	/**
	 * Sets the Exercise Reps per Set field with the passed in value.
	 * 
	 * @param exerciseRepsPerSet
	 */
	public void setExerciseRepsPerSet(String exerciseRepsPerSet) {
		AutomationHelper.printMethodName();

		this.exerciseRepsPerSetField.clear();
		this.exerciseRepsPerSetField.sendKeys(exerciseRepsPerSet);
	}

	/**
	 * Clicks the Add Workout Entry button
	 */
	public void clickAddWorkoutEntry() {
		addWorkoutEntryLink.click();
		AutomationHelper.wait(1);
	}

	/**
	 * Returns a reference to the Weight Lifting Table;
	 * 
	 * @return Tables
	 */
	public Tables getWeightLiftingTable() {
		return new Tables(workOutListTable);
	}

	/**
	 * Reads the value of the Intensity drop down box.
	 * 
	 * @return String
	 */
	public String readIntensity() {

		AutomationHelper.printMethodName();
		Select myDropDown = new Select(this.intensityDropdown);
		String intensity = myDropDown.getFirstSelectedOption().getText();
		return intensity;
	}

	/**
	 * Selects a value from the Intensity drop down, corresponding with the
	 * passed in value.
	 * 
	 * @param intensity
	 */
	public void selectIntensity(String intensity) {

		AutomationHelper.printMethodName();
		Select myDropDown = new Select(this.intensityDropdown);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions
				.elementToBeClickable(this.intensityDropdown));

		myDropDown.selectByVisibleText(intensity);
	}

	/**
	 * Reads the value of the Mood drop down box.
	 * 
	 * @return String
	 */
	public String readMood() {

		AutomationHelper.printMethodName();
		Select myDropDown = new Select(this.moodDropdown);
		String intensity = myDropDown.getFirstSelectedOption().getText();
		return intensity;
	}

	/**
	 * Selects a value from the Mood drop down, corresponding with the passed in
	 * value.
	 * 
	 * @param mood
	 */
	public void selectMood(String mood) {

		AutomationHelper.printMethodName();
		Select myDropDown = new Select(this.moodDropdown);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(this.moodDropdown));

		myDropDown.selectByVisibleText(mood);
	}

	/**
	 * Clicks the Create Button
	 */
	public void clickCreate() {
		createButton.click();
		AutomationHelper.waitForPageToLoad(10);
	}

}
