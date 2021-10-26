
package pageFactories;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import configuration.TFTConfig;
import utilities.AutomationHelper;

/**
 * Page factory for the Help page for Team Fitness Tracker.<br>
 * (1) Finds a reference to objects on the page <br>
 * (2) Defines methods to interact with objects on the page.<br>
 * 
 * @author scott.brazelton
 *
 */
public class HelpPageFactory extends TFTConfig {
	private int timeout = 30;

	private static String originalPageHandle;
	private static String pageTitle = "Help - Team Fitness Tracker";

	/**
	 * Page Constructor: Accepts the WebDriver from the calling page & instantiates
	 * the elements on the page.
	 */
	public HelpPageFactory() {
		PageFactory.initElements(driver, this);
		originalPageHandle = driver.getWindowHandle();

		ArrayList<String> tabHandles = new ArrayList<String>(driver.getWindowHandles());
		for (String handle : tabHandles) {
			driver.switchTo().window(handle);

			if (driver.getTitle().equalsIgnoreCase(pageTitle)) {
				break;
			}
		}
		AutomationHelper.waitForPageToLoad(timeout);
	}
	
	/**
	 * Closes current tab 
	 */
	public void close() {
		driver.close();
		driver.switchTo().window(originalPageHandle);
	}

	/**
	 * Obtains a reference to the details inside section "Overview of Team Fitness
	 * Tracker Research Project"
	 */
	@FindBy(xpath = "//p[preceding-sibling::h2[1][text() = 'Overview of Team Fitness Tracker Research Project']]")
	List<WebElement> overviewOfTeamFitnessTrackerResearchProject;

	/**
	 * Reads the text in the "Overview Of Team Fitness Tracker Research Project"
	 * section
	 * 
	 * @return String
	 */
	public String readOverviewOfTeamFitnessTrackerResearchProject() {
		AutomationHelper.printMethodName();
		return AutomationHelper.getTextFromWebElementList(overviewOfTeamFitnessTrackerResearchProject);
	}

	/*
	 * FINDING OBJECTS ON A PAGER - GETTER METHODS
	 */

	/**
	 * Obtains a reference to the details inside section "Welcome to Team Fitness
	 * Tracker"
	 */
	@FindBy(xpath = "//p[preceding-sibling::h2[1][text() = 'Welcome to Team Fitness Tracker']]")
	List<WebElement> welcomeToTeamFitnessTracker;

	/**
	 * Reads the text in the "Welcome to Team Fitness Tracker" section
	 * 
	 * @return String
	 */
	public String readWelcomeToTeamFitnessTracker() {
		AutomationHelper.printMethodName();

		return AutomationHelper.getTextFromWebElementList(welcomeToTeamFitnessTracker);
	}

	/**
	 * Obtains a reference to the details inside section "TATRC Helpdesk"
	 */
	@FindBy(xpath = "//p[preceding-sibling::h2[1][text() = 'TATRC Helpdesk']]")
	List<WebElement> tatrcHelpdesk;

	/**
	 * Reads the text in the "TATRC Helpdesk" section
	 * 
	 * @return String
	 */
	public String readTATRCHelpdesk() {
		AutomationHelper.printMethodName();
		return AutomationHelper.getTextFromWebElementList(tatrcHelpdesk);
	}

	/**
	 * Obtains a reference to the details inside section "Fitness Trackers"
	 */
	@FindBy(xpath = "//p[preceding-sibling::h2[1][text() = 'Fitness Trackers']]")
	List<WebElement> fitnessTrackers;

	/**
	 * Reads the text in the "Fitness Trackers" section
	 * 
	 * @return String
	 */
	public String readFitnessTrackers() {
		AutomationHelper.printMethodName();
		return AutomationHelper.getTextFromWebElementList(fitnessTrackers);
	}

	/**
	 * Obtains a reference to the details inside section "Getting Started"
	 */
	@FindBy(xpath = "//p[preceding-sibling::h2[1][text() = 'Getting Started']]")
	List<WebElement> gettingStarted;

	/**
	 * Reads the text in the "Getting Started" section
	 * 
	 * @return String
	 */
	public String readGettingStarted() {
		AutomationHelper.printMethodName();
		return AutomationHelper.getTextFromWebElementList(gettingStarted);
	}

	/**
	 * Obtains a reference to the details inside section "Accounts"
	 */
	@FindBy(xpath = "//*[self::p or self::ol][preceding-sibling::h2[1][text() = 'Accounts']]")
	List<WebElement> accounts;

	/**
	 * Reads the text in the "Accounts" section
	 * 
	 * @return String
	 */
	public String readAccounts() {
		AutomationHelper.printMethodName();
		return AutomationHelper.getTextFromWebElementList(accounts);
	}

	/**
	 * Obtains a reference to the details inside section "Devices"
	 */
	@FindBy(xpath = "//p[preceding-sibling::h2[text() = 'Devices'] and following-sibling::h3]")
	List<WebElement> devices;

	/**
	 * Reads the text in the "Devices" section
	 * 
	 * @return String
	 */
	public String readDevices() {
		AutomationHelper.printMethodName();
		return AutomationHelper.getTextFromWebElementList(devices);
	}

	/**
	 * Obtains a reference to the details inside section "To register a device"
	 */
	@FindBy(xpath = "//*[self::p or self::ol][preceding-sibling::h3[text() = 'To register a device'] and following-sibling::h1]")
	List<WebElement> toRegisterADevice;

	/**
	 * Reads the text in the "To register a device" section
	 * 
	 * @return String
	 */
	public String readToRegisterADevice() {
		AutomationHelper.printMethodName();
		return AutomationHelper.getTextFromWebElementList(toRegisterADevice);
	}

	/**
	 * Obtains a reference to the details inside section "My Menu"
	 */
	@FindBy(xpath = "//p[preceding-sibling::h1[1][text() = 'My Menu']]")
	List<WebElement> myMenu;

	/**
	 * Reads the text in the "My Menu" section
	 * 
	 * @return String
	 */
	public String readMyMenu() {
		AutomationHelper.printMethodName();
		return AutomationHelper.getTextFromWebElementList(myMenu);
	}

	/**
	 * Obtains a reference to the details inside section "My Activities"
	 */
	@FindBy(xpath = "//p[preceding-sibling::h2[1][text() = 'My Activities'] and following-sibling::h3[text() = 'To view activities']]")
	List<WebElement> myActivities;

	/**
	 * Reads the text in the "My Activities" section
	 * 
	 * @return String
	 */
	public String readMyActivities() {
		AutomationHelper.printMethodName();
		return AutomationHelper.getTextFromWebElementList(myActivities);
	}

	/**
	 * Obtains a reference to the details inside section "To view activities"
	 */
	@FindBy(xpath = "//p[preceding-sibling::h3[1][text() = 'To view activities']]")
	List<WebElement> toViewActivities;

	/**
	 * Reads the text in the "To View Activities" section
	 * 
	 * @return String
	 */
	public String readToViewActivities() {
		AutomationHelper.printMethodName();
		return AutomationHelper.getTextFromWebElementList(toViewActivities);
	}

	/**
	 * Obtains a reference to the details inside section "To create a new activity"
	 */
	@FindBy(xpath = "//*[self::p or self::ol][preceding-sibling::h3[1][text() = 'To create a new activity']]")
	List<WebElement> toCreateANewActivity;

	/**
	 * Reads the text in the "To create a new activity" section
	 * 
	 * @return String
	 */
	public String readToCreateANewActivity() {
		AutomationHelper.printMethodName();
		return AutomationHelper.getTextFromWebElementList(toCreateANewActivity);
	}

	/**
	 * Obtains a reference to the details inside section "To enter weight lifting
	 * metrics"
	 */
	@FindBy(xpath = "//*[self::p or self::ol][preceding-sibling::h3[1][text() = 'To enter weight lifting metrics']]")
	List<WebElement> toEnterWeightLiftingMetrics;

	/**
	 * Reads the text in the "To enter weight lifting metrics" section
	 * 
	 * @return String
	 */
	public String readToEnterWeightLiftingMetrics() {
		AutomationHelper.printMethodName();
		return AutomationHelper.getTextFromWebElementList(toEnterWeightLiftingMetrics);
	}

	/**
	 * Obtains a reference to the details inside section "My Calorie Intake"
	 */
	@FindBy(xpath = "//p[preceding-sibling::h2[text() = 'My Calorie Intake'] and following-sibling::h3]")
	List<WebElement> myCalorieIntake;

	/**
	 * Reads the text in the "To enter weight lifting metrics" section
	 * 
	 * @return String
	 */
	public String readMyCalorieIntake() {
		AutomationHelper.printMethodName();
		return AutomationHelper.getTextFromWebElementList(myCalorieIntake);
	}

	/**
	 * Obtains a reference to the details inside section "To view your calorie
	 * intake"
	 */
	@FindBy(xpath = "//*[self::p or self::ol][preceding-sibling::h3[1][text() = 'To view your calorie intake']]")
	List<WebElement> toViewYourCalorieIntake;

	/**
	 * Reads the text in the "To enter weight lifting metrics" section
	 * 
	 * @return String
	 */
	public String readToViewYourCalorieIntake() {
		AutomationHelper.printMethodName();
		return AutomationHelper.getTextFromWebElementList(toViewYourCalorieIntake);
	}

	/**
	 * Obtains a reference to the details inside section "To create new entries into
	 * your calorie intake via Lookup Nutritional Info"
	 */
	@FindBy(xpath = "//*[self::p or self::ol][preceding-sibling::h3[1][text() = 'To create new entries into your calorie intake via Lookup Nutritional Info']]")
	List<WebElement> toCreateNewEntriesViaLookupNutritionalInfo;

	/**
	 * Reads the text in the "To create new entries into your calorie intake via
	 * Lookup Nutritional Info" section
	 * 
	 * @return String
	 */
	public String readToCreateNewEntriesIntoYourCalorieIntakeViaLookupNutritionalInfo() {
		AutomationHelper.printMethodName();
		return AutomationHelper.getTextFromWebElementList(toCreateNewEntriesViaLookupNutritionalInfo);
	}

	/**
	 * Obtains a reference to the details inside section "To create new entries into
	 * your calorie intake via Manual Entry"
	 */
	@FindBy(xpath = "//*[self::p or self::ol][preceding-sibling::h3[1][text() = 'To create new entries into your calorie intake via Manual Entry']]")
	List<WebElement> toCreateNewEntriesViaManualEntry;

	/**
	 * Reads the text in the "To create new entries into your calorie intake via
	 * Manual Entry" section
	 * 
	 * @return String
	 */
	public String readToCreateNewEntriesIntoYourCalorieIntakeViaManualEntry() {
		AutomationHelper.printMethodName();
		return AutomationHelper.getTextFromWebElementList(toCreateNewEntriesViaManualEntry);
	}

	/**
	 * Obtains a reference to the details inside section "To edit calorie
	 * consumption"
	 */
	@FindBy(xpath = "//*[self::p or self::ol][preceding-sibling::h3[1][text() = 'To edit calorie consumption']]")
	List<WebElement> toEditCalorieConsumption;

	/**
	 * Reads the text in the "To edit calorie consumption" section
	 * 
	 * @return String
	 */
	public String readToEditCalorieConsumption() {
		AutomationHelper.printMethodName();
		return AutomationHelper.getTextFromWebElementList(toEditCalorieConsumption);
	}

	/**
	 * Obtains a reference to the details inside section "To view calorie intake
	 * details"
	 */
	@FindBy(xpath = "//*[self::p or self::ol][preceding-sibling::h3[1][text() = 'To view calorie intake details']]")
	List<WebElement> toViewCalorieIntakeDetails;

	/**
	 * Reads the text in the "To view calorie intake details" section
	 * 
	 * @return String
	 */
	public String readToViewCalorieIntakeDetails() {
		AutomationHelper.printMethodName();
		return AutomationHelper.getTextFromWebElementList(toViewCalorieIntakeDetails);
	}

	/**
	 * Obtains a reference to the details inside section "To delete calorie intake
	 * entries"
	 */
	@FindBy(xpath = "//*[self::p or self::ol][preceding-sibling::h3[1][text() = 'To delete calorie intake entries']]")
	List<WebElement> toDeleteCalorieIntakeEntries;

	/**
	 * Reads the text in the "To delete calorie intake entries" section
	 * 
	 * @return String
	 */
	public String readToDeleteCalorieIntakeEntries() {
		AutomationHelper.printMethodName();
		return AutomationHelper.getTextFromWebElementList(toDeleteCalorieIntakeEntries);
	}

	/**
	 * Obtains a reference to the details inside section "My Sleep Log"
	 */
	@FindBy(xpath = "//p[preceding-sibling::h2[1][text() = 'My Sleep Log'] and following-sibling::h3]")
	List<WebElement> mySleepLog;

	/**
	 * Reads the text in the "My Sleep Log" section
	 * 
	 * @return String
	 */
	public String readMySleepLog() {
		AutomationHelper.printMethodName();
		return AutomationHelper.getTextFromWebElementList(mySleepLog);
	}

	/**
	 * Obtains a reference to the details inside section "To view your sleep log"
	 */
	@FindBy(xpath = "//*[self::p or self::ol][preceding-sibling::h3[1][text() = 'To view your sleep log']]")
	List<WebElement> toViewYourSleepLog;

	/**
	 * Reads the text in the "To view your sleep log" section
	 * 
	 * @return String
	 */
	public String readToViewYourSleepLog() {
		AutomationHelper.printMethodName();
		return AutomationHelper.getTextFromWebElementList(toViewYourSleepLog);
	}

	/**
	 * Obtains a reference to the details inside section "To create a log file
	 * entry"
	 */
	@FindBy(xpath = "//*[self::p or self::ol][preceding-sibling::h3[1][text() = 'To create a log file entry']]")
	List<WebElement> toCreateALogFileEntry;

	/**
	 * Reads the text in the "To create a log file entry" section
	 * 
	 * @return String
	 */
	public String readToCreateALogFileEntry() {
		AutomationHelper.printMethodName();
		return AutomationHelper.getTextFromWebElementList(toCreateALogFileEntry);
	}

	/**
	 * Obtains a reference to the details inside section "To edit a sleep log entry"
	 */
	@FindBy(xpath = "//*[self::p or self::ol][preceding-sibling::h3[1][text() = 'To edit a sleep log entry']]")
	List<WebElement> toEditASleepLogEntry;

	/**
	 * Reads the text in the "To edit a sleep log entry" section
	 * 
	 * @return String
	 */
	public String readToEditASleepLogEntry() {
		AutomationHelper.printMethodName();
		return AutomationHelper.getTextFromWebElementList(toEditASleepLogEntry);
	}

	/**
	 * Obtains a reference to the details inside section "To view details of an
	 * entry in your sleep log"
	 */
	@FindBy(xpath = "//*[self::p or self::ol][preceding-sibling::h3[1][text() = 'To view details of an entry in your sleep log']]")
	List<WebElement> toViewDetailsInYourSleepLog;

	/**
	 * Reads the text in the "To view details of an entry in your sleep log" section
	 * 
	 * @return String
	 */
	public String readToViewDetailsOfAnEntryInYourSleepLog() {
		AutomationHelper.printMethodName();
		return AutomationHelper.getTextFromWebElementList(toViewDetailsInYourSleepLog);
	}

	/**
	 * Obtains a reference to the details inside section "To delete a sleep log
	 * entry"
	 */
	@FindBy(xpath = "//*[self::p or self::ol][preceding-sibling::h3[1][text() = 'To delete a sleep log entry']]")
	List<WebElement> toDeleteASleepLogEntry;

	/**
	 * Reads the text in the "To delete a sleep log entry" section
	 * 
	 * @return String
	 */
	public String readToDeleteASleepLogEntry() {
		AutomationHelper.printMethodName();
		return AutomationHelper.getTextFromWebElementList(toDeleteASleepLogEntry);
	}

	/**
	 * Obtains a reference to the details inside section "My Body Measurements"
	 */
	@FindBy(xpath = "//p[preceding-sibling::h2[1][text() = 'My Body Measurements'] and following-sibling::h3]")
	List<WebElement> myBodyMeasurements;

	/**
	 * Reads the text in the "My Body Measurements" section
	 * 
	 * @return String
	 */
	public String readMyBodyMeasurements() {
		AutomationHelper.printMethodName();
		return AutomationHelper.getTextFromWebElementList(myBodyMeasurements);
	}

	/**
	 * Obtains a reference to the details inside section "To view your body
	 * measurements"
	 */
	@FindBy(xpath = "//*[self::p or self::ol][preceding-sibling::h3[1][text() = 'To view your body measurements']]")
	List<WebElement> toViewYourBodyMeasurements;

	/**
	 * Reads the text in the "To view your body measurements" section
	 * 
	 * @return String
	 */
	public String readToViewYourBodyMeasurements() {
		AutomationHelper.printMethodName();
		return AutomationHelper.getTextFromWebElementList(toViewYourBodyMeasurements);
	}

	/**
	 * Obtains a reference to the details inside section "To create body
	 * measurements"
	 */
	@FindBy(xpath = "//*[self::p or self::ol][preceding-sibling::h3[1][text() = 'To create body measurements']]")
	List<WebElement> toCreateBodyMeasurements;

	/**
	 * Reads the text in the "To create body measurements" section
	 * 
	 * @return String
	 */
	public String readToCreateBodyMeasurements() {
		AutomationHelper.printMethodName();
		return AutomationHelper.getTextFromWebElementList(toCreateBodyMeasurements);
	}
	
	/**
	 * Obtains a reference to the details inside section "To edit body measurements"
	 */
	@FindBy(xpath = "//*[self::p or self::ol][preceding-sibling::h3[1][text() = 'To edit body measurements']]")
	List<WebElement> toEditBodyMeasurements;

	/**
	 * Reads the text in the "To edit body measurements" section
	 * 
	 * @return String
	 */
	public String readToEditBodyMeasurements() {
		AutomationHelper.printMethodName();
		return AutomationHelper.getTextFromWebElementList(toEditBodyMeasurements);
	}
	
	/**
	 * Obtains a reference to the details inside section "To view body measurements details"
	 */
	@FindBy(xpath = "//*[self::p or self::ol][preceding-sibling::h3[1][text() = 'To view body measurements details']]")
	List<WebElement> toViewBodyMeasurementsDetails;

	/**
	 * Reads the text in the "To view body measurements details" section
	 * 
	 * @return String
	 */
	public String readToViewBodyMeasurementsDetails() {
		AutomationHelper.printMethodName();
		return AutomationHelper.getTextFromWebElementList(toViewBodyMeasurementsDetails);
	}	
	
	/**
	 * Obtains a reference to the details inside section "To delete body measurements"
	 */
	@FindBy(xpath = "//*[self::p or self::ol][preceding-sibling::h3[1][text() = 'To delete body measurements']]")
	List<WebElement> toDeleteBodyMeasurements;

	/**
	 * Reads the text in the "To delete body measurements" section
	 * 
	 * @return String
	 */
	public String readToDeleteBodyMeasurements() {
		AutomationHelper.printMethodName();
		return AutomationHelper.getTextFromWebElementList(toDeleteBodyMeasurements);
	}	
	
	/**
	 * Obtains a reference to the details inside section "My PFT Score"
	 */
	@FindBy(xpath = "//p[preceding-sibling::h2[1][text() = 'My PFT Score'] and following-sibling::h3[text() = 'To view your PFT Score']]")
	List<WebElement> myPFTScore;

	/**
	 * Reads the text in the "My PFT Score" section
	 * 
	 * @return String
	 */
	public String readMyPFTScore() {
		AutomationHelper.printMethodName();
		return AutomationHelper.getTextFromWebElementList(myPFTScore);
	}	
	
	/**
	 * Obtains a reference to the details inside section "To view your PFT Score"
	 */
	@FindBy(xpath = "//*[self::p or self::ol][preceding-sibling::h3[1][text() = 'To view your PFT Score']]")
	List<WebElement> toViewYourPFTScore;

	/**
	 * Reads the text in the "To view your PFT Score" section
	 * 
	 * @return String
	 */
	public String readToViewYourPFTScore() {
		AutomationHelper.printMethodName();
		return AutomationHelper.getTextFromWebElementList(toViewYourPFTScore);
	}	
	
	/**
	 * Obtains a reference to the details inside section "To create new activities"
	 */
	@FindBy(xpath = "//*[self::p or self::ol][preceding-sibling::h3[1][text() = 'To create new activities'] and following-sibling::h2[text() = 'My Progress Map']]")
	List<WebElement> toCreateNewActivities;

	/**
	 * Reads the text in the "To create new activities" section
	 * 
	 * @return String
	 */
	public String readToCreateNewActivities() {
		AutomationHelper.printMethodName();
		return AutomationHelper.getTextFromWebElementList(toCreateNewActivities);
	}	
	
	/**
	 * Obtains a reference to the details inside section "My Progress Map"
	 */
	@FindBy(xpath = "//p[preceding-sibling::h2[1][text() = 'My Progress Map'] and following-sibling::h3[text() = 'To view your progress']]")
	List<WebElement> myProgressMap;

	/**
	 * Reads the text in the "My Progress Map" section
	 * 
	 * @return String
	 */
	public String readMyProgressMap() {
		AutomationHelper.printMethodName();
		return AutomationHelper.getTextFromWebElementList(myProgressMap);
	}	
	
	/**
	 * Obtains a reference to the details inside section "To view your progress"
	 */
	@FindBy(xpath = "//p[preceding-sibling::h3[1][text() = 'To view your progress'] and following-sibling::h2[text() = 'View the My Team Progress Map']]")
	List<WebElement> toViewYourProgress;

	/**
	 * Reads the text in the "To view your progress" section
	 * 
	 * @return String
	 */
	public String readToViewYourProgress() {
		AutomationHelper.printMethodName();
		return AutomationHelper.getTextFromWebElementList(toViewYourProgress);
	}	
	
	/**
	 * Obtains a reference to the details inside section "View the My Team Progress Map"
	 */
	@FindBy(xpath = "//p[preceding-sibling::h2[1][text() = 'View the My Team Progress Map'] and following-sibling::h3[text() = 'To view your team progress map']]")
	List<WebElement> viewTheMyTeamProgressMap;

	/**
	 * Reads the text in the "View the My Team Progress Map" section
	 * 
	 * @return String
	 */
	public String readViewTheMyTeamProgressMap() {
		AutomationHelper.printMethodName();
		return AutomationHelper.getTextFromWebElementList(viewTheMyTeamProgressMap);
	}	
	
	/**
	 * Obtains a reference to the details inside section "To view your team progress map"
	 */
	@FindBy(xpath = "//*[self::p or self::ol][preceding-sibling::h3[1][text() = 'To view your team progress map']]")
	List<WebElement> toViewYourTeamProgressMap;

	/**
	 * Reads the text in the "To view your team progress map" section
	 * 
	 * @return String
	 */
	public String readToViewYourTeamProgressMap() {
		AutomationHelper.printMethodName();
		return AutomationHelper.getTextFromWebElementList(toViewYourTeamProgressMap);
	}	
	
	/**
	 * Obtains a reference to the details inside section "My Achievements"
	 */
	@FindBy(xpath = "//p[preceding-sibling::h2[1][text() = 'My Achievements']]")
	List<WebElement> myAchievements;

	/**
	 * Reads the text in the "My Achievements" section
	 * 
	 * @return String
	 */
	public String readMyAchievements() {
		AutomationHelper.printMethodName();
		return AutomationHelper.getTextFromWebElementList(myAchievements);
	}	
	
	/**
	 * Obtains a reference to the details inside section "My Goals"
	 */
	@FindBy(xpath = "//p[preceding-sibling::h2[1][text() = 'My Goals'] and following-sibling::h3]")
	List<WebElement> myGoals;

	/**
	 * Reads the text in the "My Goals" section
	 * 
	 * @return String
	 */
	public String readMyGoals() {
		AutomationHelper.printMethodName();
		return AutomationHelper.getTextFromWebElementList(myGoals);
	}	
	
	/**
	 * Obtains a reference to the details inside section "To set your goals"
	 */
	@FindBy(xpath = "//*[self::p or self::ol][preceding-sibling::h3[1][text() = 'To set your goals']]")
	List<WebElement> toSetYourGoals;

	/**
	 * Reads the text in the "To set your goals" section
	 * 
	 * @return String
	 */
	public String readToSetYourGoals() {
		AutomationHelper.printMethodName();
		return AutomationHelper.getTextFromWebElementList(toSetYourGoals);
	}	
	
	/**
	 * Obtains a reference to the details inside section "To create a goal"
	 */
	@FindBy(xpath = "//*[self::p or self::ol][preceding-sibling::h3[1][text() = 'To create a goal']]")
	List<WebElement> toCreateAGoal;

	/**
	 * Reads the text in the "To create a goal" section
	 * 
	 * @return String
	 */
	public String readToCreateAGoal() {
		AutomationHelper.printMethodName();
		return AutomationHelper.getTextFromWebElementList(toCreateAGoal);
	}	
	
	/**
	 * Obtains a reference to the details inside section "To edit a goal"
	 */
	@FindBy(xpath = "//*[self::p or self::ol][preceding-sibling::h3[1][text() = 'To edit a goal']]")
	List<WebElement> toEditAGoal;

	/**
	 * Reads the text in the "To edit a goal" section
	 * 
	 * @return String
	 */
	public String readToEditAGoal() {
		AutomationHelper.printMethodName();
		return AutomationHelper.getTextFromWebElementList(toEditAGoal);
	}	
	
	/**
	 * Obtains a reference to the details inside section "To delete a goal"
	 */
	@FindBy(xpath = "//*[self::p or self::ol][preceding-sibling::h3[1][text() = 'To delete a goal']]")
	List<WebElement> toDeleteAGoal;

	/**
	 * Reads the text in the "To delete a goal" section
	 * 
	 * @return String
	 */
	public String readToDeleteAGoal() {
		AutomationHelper.printMethodName();
		return AutomationHelper.getTextFromWebElementList(toDeleteAGoal);
	}	
	
	/**
	 * Obtains a reference to the details inside section "My Team Goals"
	 */
	@FindBy(xpath = "//p[preceding-sibling::h2[1][text() = 'My Team Goals'] and following-sibling::h3]")
	List<WebElement> myTeamGoals;

	/**
	 * Reads the text in the "My Team Goals" section
	 * 
	 * @return String
	 */
	public String readMyTeamGoals() {
		AutomationHelper.printMethodName();
		return AutomationHelper.getTextFromWebElementList(myTeamGoals);
	}	
	
	/**
	 * Obtains a reference to the details inside section "To view your team goals"
	 */
	@FindBy(xpath = "//*[self::p or self::ol][preceding-sibling::h3[1][text() = 'To view your team goals']]")
	List<WebElement> toViewYourTeamGoals;

	/**
	 * Reads the text in the "To view your team goals" section
	 * 
	 * @return String
	 */
	public String readToViewYourTeamGoals() {
		AutomationHelper.printMethodName();
		return AutomationHelper.getTextFromWebElementList(toViewYourTeamGoals);
	}	
	
	
	/**
	 * Obtains a reference to the details inside section "To create a team goal"
	 */
	@FindBy(xpath = "//*[self::p or self::ol][preceding-sibling::h3[1][text() = 'To create a team goal']]")
	List<WebElement> toCreateATeamGoal;

	/**
	 * Reads the text in the "To create a team goal" section
	 * 
	 * @return String
	 */
	public String readToCreateATeamGoal() {
		AutomationHelper.printMethodName();
		return AutomationHelper.getTextFromWebElementList(toCreateATeamGoal);
	}	
	
	/**
	 * Obtains a reference to the details inside section "To edit a team goal"
	 */
	@FindBy(xpath = "//*[self::p or self::ol][preceding-sibling::h3[1][text() = 'To edit a team goal']]")
	List<WebElement> toEditATeamGoal;

	/**
	 * Reads the text in the "To edit a team goal" section
	 * 
	 * @return String
	 */
	public String readToEditATeamGoal() {
		AutomationHelper.printMethodName();
		return AutomationHelper.getTextFromWebElementList(toEditATeamGoal);
	}	
	
	/**
	 * Obtains a reference to the details inside section "To delete a team goal"
	 */
	@FindBy(xpath = "//*[self::p or self::ol][preceding-sibling::h3[1][text() = 'To delete a team goal'] and following-sibling::h2]")
	List<WebElement> toDeleteATeamGoal;

	/**
	 * Reads the text in the "To delete a team goal" section
	 * 
	 * @return String
	 */
	public String readToDeleteATeamGoal() {
		AutomationHelper.printMethodName();
		return AutomationHelper.getTextFromWebElementList(toDeleteATeamGoal);
	}
	
	/**
	 * Obtains a reference to the details inside section "My Team Membership"
	 */
	@FindBy(xpath = "//p[preceding-sibling::h2[1][text() = 'My Team Membership']]")
	List<WebElement> myTeamMembership;

	/**
	 * Reads the text in the "My Team Membership" section
	 * 
	 * @return String
	 */
	public String readMyTeamMembership() {
		AutomationHelper.printMethodName();
		return AutomationHelper.getTextFromWebElementList(myTeamMembership);
	}
	
	/**
	 * Obtains a reference to the details inside section "To submit articles to TFT"
	 */
	@FindBy(xpath = "//*[self::p or self::ol][preceding-sibling::h3[1][text() = 'To submit articles to TFT'] and following-sibling::h1]")
	List<WebElement> toSubmitArticlesToTFT;

	/**
	 * Reads the text in the "To submit articles to TFT" section
	 * 
	 * @return String
	 */
	public String readtoSubmitArticlesToTFT() {
		AutomationHelper.printMethodName();
		return AutomationHelper.getTextFromWebElementList(toSubmitArticlesToTFT);
	}
	
	/**
	 * Obtains a reference to the details inside section "Hello Menu"
	 */
	@FindBy(xpath = "//p[preceding-sibling::h1[1][text() = 'Hello Menu']]")
	List<WebElement> helloMenu;

	/**
	 * Reads the text in the "Hello Menu" section
	 * 
	 * @return String
	 */
	public String readHelloMenu() {
		AutomationHelper.printMethodName();
		return AutomationHelper.getTextFromWebElementList(helloMenu);
	}
	
	/**
	 * Obtains a reference to the details inside section "Profile"
	 */
	@FindBy(xpath = "//p[preceding-sibling::h2[1][text() = 'Profile']]")
	List<WebElement> profile;

	/**
	 * Reads the text in the "Profile" section
	 * 
	 * @return String
	 */
	public String readProfile() {
		AutomationHelper.printMethodName();
		return AutomationHelper.getTextFromWebElementList(profile);
	}
	
	/**
	 * Obtains a reference to the details inside section "To edit your profile"
	 */
	@FindBy(xpath = "//*[self::p or self::ol][preceding-sibling::h3[1][text() = 'To edit your profile']]")
	List<WebElement> toEditYourProfile;

	/**
	 * Reads the text in the "To edit your profile" section
	 * 
	 * @return String
	 */
	public String readToEditYourProfile() {
		AutomationHelper.printMethodName();
		return AutomationHelper.getTextFromWebElementList(toEditYourProfile);
	}
	
	/**
	 * Obtains a reference to the details inside section "PRT Status"
	 */
	@FindBy(xpath = "//p[preceding-sibling::h2[1][text() = 'PRT Status']]")
	List<WebElement> prtStatus;

	/**
	 * Reads the text in the "PRT Status" section
	 * 
	 * @return String
	 */
	public String readPRTStatus() {
		AutomationHelper.printMethodName();
		return AutomationHelper.getTextFromWebElementList(prtStatus);
	}
	
	/**
	 * Obtains a reference to the details inside section "To edit your PRT status"
	 */
	@FindBy(xpath = "//*[self::p or self::ol][preceding-sibling::h3[1][text() = 'To edit your PRT status']]")
	List<WebElement> toEditYourPRTStatus;

	/**
	 * Reads the text in the "To edit your PRT status" section
	 * 
	 * @return String
	 */
	public String readToEditYourPRTStatus() {
		AutomationHelper.printMethodName();
		return AutomationHelper.getTextFromWebElementList(toEditYourPRTStatus);
	}
	
	/**
	 * Obtains a reference to the details inside section "Team Membership"
	 */
	@FindBy(xpath = "//p[preceding-sibling::h2[1][text() = 'Team Membership'] and following-sibling::h3[text() = 'To edit your team memberships']]")
	List<WebElement> teamMembership;

	/**
	 * Reads the text in the "Team Membership" section
	 * 
	 * @return String
	 */
	public String readTeamMembership() {
		AutomationHelper.printMethodName();
		return AutomationHelper.getTextFromWebElementList(teamMembership);
	}
	
	/**
	 * Obtains a reference to the details inside section "To edit your team memberships"
	 */
	@FindBy(xpath = "//*[self::p or self::ol][preceding-sibling::h3[1][text() = 'To edit your team memberships'] and following-sibling::h2[text() = 'Register Device']]")
	List<WebElement> toEditYourTeamMemberships;

	/**
	 * Reads the text in the "To edit your team memberships" section
	 * 
	 * @return String
	 */
	public String readToEditYourTeamMemberships() {
		AutomationHelper.printMethodName();
		return AutomationHelper.getTextFromWebElementList(toEditYourTeamMemberships);
	}
	
	/**
	 * Obtains a reference to the details inside section "Register Device"
	 */
	@FindBy(xpath = "//p[preceding-sibling::h2[1][text() = 'Register Device']]")
	List<WebElement> registerDevice;

	/**
	 * Reads the text in the "Register Device" section
	 * 
	 * @return String
	 */
	public String readRegisterDevice() {
		AutomationHelper.printMethodName();
		return AutomationHelper.getTextFromWebElementList(registerDevice);
	}

	/**
	 * Obtains a reference to the details inside section "To register your device"
	 */
	@FindBy(xpath = "//p[preceding-sibling::h2[1][text() = 'To register your device']]")
	List<WebElement> toRegisterYourdevice;

	/**
	 * Reads the text in the "To register your device" section
	 * 
	 * @return String
	 */
	public String readToRegisterYourdevice() {
		AutomationHelper.printMethodName();
		return AutomationHelper.getTextFromWebElementList(toRegisterYourdevice);
	}
	
	/**
	 * Obtains a reference to the details inside section "Password"
	 */
	@FindBy(xpath = "//p[preceding-sibling::h2[1][text() = 'Password'] and following-sibling::h3]")
	List<WebElement> password;

	/**
	 * Reads the text in the "Password" section
	 * 
	 * @return String
	 */
	public String readPassword() {
		AutomationHelper.printMethodName();
		return AutomationHelper.getTextFromWebElementList(password);
	}
	
	/**
	 * Obtains a reference to the details inside section "To change your password"
	 */
	@FindBy(xpath = "//*[self::p or self::ol][preceding-sibling::h3[1][text() = 'To change your password']]")
	List<WebElement> toChangeYourPassword;

	/**
	 * Reads the text in the "To change your password" section
	 * 
	 * @return String
	 */
	public String readToChangeYourPassword() {
		AutomationHelper.printMethodName();
		return AutomationHelper.getTextFromWebElementList(toChangeYourPassword);
	}
	
	/**
	 * Obtains a reference to the details inside section "Forgot password"
	 */
	@FindBy(xpath = "//*[self::p or self::ol][preceding-sibling::h3[1][text() = 'Forgot password'] and following-sibling::h2[text() = 'Help']]")
	List<WebElement> forgotPassword;

	/**
	 * Reads the text in the "Forgot password" section
	 * 
	 * @return String
	 */
	public String readForgotPassword() {
		AutomationHelper.printMethodName();
		return AutomationHelper.getTextFromWebElementList(forgotPassword);
	}
	
	/**
	 * Obtains a reference to the details inside section "Help"
	 */
	@FindBy(xpath = "//p[preceding-sibling::h2[1][text() = 'Help']]")
	List<WebElement> help;

	/**
	 * Reads the text in the "Help" section
	 * 
	 * @return String
	 */
	public String readHelp() {
		AutomationHelper.printMethodName();
		return AutomationHelper.getTextFromWebElementList(help);
	}
	
	/**
	 * Obtains a reference to the details inside section "Log Off"
	 */
	@FindBy(xpath = "//p[preceding-sibling::h2[1][text() = 'Log Off']]")
	List<WebElement> logOff;

	/**
	 * Reads the text in the "Log Off" section
	 * 
	 * @return String
	 */
	public String readLogOff() {
		AutomationHelper.printMethodName();
		return AutomationHelper.getTextFromWebElementList(logOff);
	}
	
	/**
	 * Obtains a reference to the details inside section "Appendix A: Fitness Trackers Compatible with Team Fitness Tracker"
	 */
	@FindBy(xpath = "//table[preceding-sibling::h1[1][text() = 'Appendix A: Fitness Trackers Compatible with Team Fitness Tracker']]/tbody/tr/td")
	List<WebElement> appendixA;

	/**
	 * Reads the text in the "Appendix A: Fitness Trackers Compatible with Team Fitness Tracker" section
	 * 
	 * @return String
	 */
	public String readAppendixAFitnessTrackersCompatibleWithTeamFitnessTracker() {
		AutomationHelper.printMethodName();
		return AutomationHelper.getTextFromWebElementList(appendixA);
	}
	
	/**
	 * Obtains a reference to the details inside section "Appendix C: PRT Definitions"
	 */
	@FindBy(xpath = "//*[self::p or self::h3 or self::h4][preceding-sibling::h1[1][text() = 'Appendix C: PRT Definitions']]")
	List<WebElement> appendixC;

	/**
	 * Reads the text in the "Appendix C: PRT Definitions" section
	 * 
	 * @return String
	 */
	public String readAppendixCPRTDefinitions() {
		AutomationHelper.printMethodName();
		String test = AutomationHelper.getTextFromWebElementList(appendixC);
		
		return test;
	}
	
	/**
	 * Obtains a reference to the details inside section "Appendix D: Metabolic Rates and Other Calculations Used for Fitness Tracking"
	 */
	@FindBy(xpath = "//p[preceding-sibling::h1[1][text() = 'Appendix D: Metabolic Rates and Other Calculations Used for Fitness Tracking']]")
	List<WebElement> appendixD;

	/**
	 * Reads the text in the "Appendix D: Metabolic Rates and Other Calculations Used for Fitness Tracking" section
	 * 
	 * @return String
	 */
	public String readAppendixDMetabolicRatesAndOtherCalculationsUsedForFitnessTracking() {
		AutomationHelper.printMethodName();
		return AutomationHelper.getTextFromWebElementList(appendixD);
	}
	
}
