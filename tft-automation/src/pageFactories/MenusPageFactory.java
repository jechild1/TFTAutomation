package pageFactories;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import configuration.TFTConfig;
import utilities.AutomationHelper;

/**
 * Page factory for Menus that can be found throughout any page in Team Fitness
 * Tracker.<br>
 * (1) Finds a reference to objects on the page <br>
 * (2) Defines methods to interact with objects on the page.<br>
 * 
 * @author jesse.childress
 *
 */
public abstract class MenusPageFactory extends TFTBase {

	private Actions action = new Actions(driver);

	/**
	 * Abstract Navigation Menu Constructor: Accepts the WebDriver from the calling
	 * page, instantiates the elements on the page, and verifies the URL
	 */
	public MenusPageFactory(String regexURL) {
		PageFactory.initElements(driver, this);

		AutomationHelper.waitForPageToLoad(LONG_TIMEOUT);

		waitForPageToLoad();

		assertTrue(this.getCurrentUrl().matches(regexURL), "Validate URL changed to " + regexURL);
	}


	// Page Load Timeout
	int timeout = 30;

	WebDriverWait wait;

	/**
	 * Page Constructor: Accepts the WebDriver from the calling page & instantiates
	 * the elements on the page.
	 */
	public MenusPageFactory() {
		PageFactory.initElements(driver, this);
		// Declare a wait for specific objects to be clickable, etc.
		wait = new WebDriverWait(driver, timeout);
	}




	/**
	 * Obtains a reference to the Home Link (Team Fitness Tracker).
	 */
	@FindBy(linkText = "Team Fitness Tracker")
	WebElement homeLink;

	/**
	 * Clicks the Home link on the Home Page.
	 */
	public void clickHomeLink() {
		Reporter.log("Clicking Home link", true);
		homeLink.click();
		Reporter.log("Home link clicked", true);
		Reporter.log("", true);
		AutomationHelper.waitForPageToLoad(timeout);
	}

	/**
	 * Obtains a reference to the Log in link.
	 */
	@FindBy(linkText = "Log in")
	WebElement logInLink;

	/**
	 * Clicks the Log in link in the menu
	 */
	public void clickLoginLink() {
		AutomationHelper.printMethodName();
		logInLink.click();
		AutomationHelper.waitForPageToLoad(timeout);
	}
	
	/**
	 * Obtains a reference to the Team Fitness Tracker link.
	 */
	@FindBy(linkText = "Team Fitness Tracker")
	WebElement teamFitnessTrackerLink;

	/**
	 * Clicks the Team Fitness Tracker Link in the Menus
	 */
	public void clickTeamFitnessTrackerLink() {
		Reporter.log("Clicking Team Fitness Tracker link", true);
		teamFitnessTrackerLink.click();
		Reporter.log("Team Fitness Tracker link clicked", true);
		Reporter.log("", true);
		AutomationHelper.waitForPageToLoad(timeout);
	}

	/**
	 * Obtains a reference to the My Menu link.
	 * 
	 * @category MyMenu
	 */
	@FindBy(linkText = "My Menu")
	WebElement myMenuDropdown;

	/**
	 * Clicks the My Menu Link in the Menus.
	 * 
	 * @category MyMenu
	 * @return reference to MenusPageFactory
	 */
	private MenusPageFactory clickMyMenu() {
		myMenuDropdown.click();
		return this;
	}

	/**
	 * Obtains a reference to the My Activities link.
	 * 
	 * @category MyMenu
	 */
	@FindBy(linkText = "My Activities")
	WebElement myActivitiesLink;

	/**
	 * Clicks the My Menu > My Activities link. Note: This method takes care of
	 * clicking My Menu.
	 * 
	 * @category My Menu
	 */
	public void clickMyActivities() {
		AutomationHelper.printMethodName();
		clickMyMenu().myActivitiesLink.click();
	}

	/**
	 * Obtains a reference to the My Calorie Intake link.
	 * 
	 * @category MyMenu
	 */
	@FindBy(linkText = "My Calorie Intake")
	WebElement myCalorieIntakeLink;

	/**
	 * Clicks the My Menu > My Calorie Intake link. Note: This method takes care of
	 * clicking My Menu.
	 * 
	 * @category My Menu
	 */
	public void clickMyCalorieIntake() {
		AutomationHelper.printMethodName();
		clickMyMenu().myCalorieIntakeLink.click();
	}

	/**
	 * Obtains a reference to the My Sleep Log link.
	 * 
	 * @category MyMenu
	 */
	@FindBy(linkText = "My Sleep Log")
	WebElement mySleepLogLink;

	/**
	 * Clicks the My Menu > My Sleep Log link. Note: This method takes care of
	 * clicking My Menu.
	 * 
	 * @category My Menu
	 */
	public void clickMySleepLog() {
		AutomationHelper.printMethodName();
		clickMyMenu().mySleepLogLink.click();
	}

	/**
	 * Obtains a reference to the My Body Measurements menu link.
	 * 
	 * @category MyMenu
	 */
	@FindBy(linkText = "My Body Measurements")
	WebElement myBodyMeasurementsLink;

	/**
	 * Clicks the My Menu > My Body Measurements link in the menus. Note: This
	 * method takes care of clicking My Menu.
	 * 
	 * @category MyMenu
	 */
	public void clickMyBodyMeasurements() {
		AutomationHelper.printMethodName();
		clickMyMenu().myBodyMeasurementsLink.click();
	}

	/**
	 * Obtains a reference to the My Profile menu link.
	 */
	@FindBy(linkText = "My Profile")
	WebElement myProfileLink;

	/**
	 * Clicks the My Menu > My Profile link in the menus. Note: This method takes
	 * care of clicking My Menu.
	 * @category MyMenu
	 */
	public void clickMyProfile() {
		AutomationHelper.printMethodName();
		clickMyMenu().myProfileLink.click();
	}

	/**
	 * Obtains a reference to the My Diet Supplement Lookup page.
	 */
	@FindBy(linkText = "My Diet Supplement Lookup")
	WebElement myDietSupplementLookupLink;

	/**
	 * Moves cursor to My Diet Supplement Lookup in My Menu.
	 * @category MyMenu
	 * @return reference to MenusPageFactory
	 */
	private MenusPageFactory moveToMyDietSupplementlookup() {
		action.moveToElement(myDietSupplementLookupLink).build().perform();
		return this;
	}
	
	/**
	 * Obtains a reference to the Office of Dietary Supplements link.
	 */
	@FindBy(linkText = "Office of Dietary Supplements")
	WebElement officeOfDietarySupplementsLink;
	
	/**
	 * Clicks the My Menu > My Diet Supplement Lookup > Office of Dietary Supplements link.
	 * @category MyMenu
	 */
	public void clickOfficeOfDietarySupplementsLink() {
		AutomationHelper.printMethodName();
		clickMyMenu().moveToMyDietSupplementlookup().officeOfDietarySupplementsLink.click();
	}
	
	/**
	 * Obtains a reference to the Office of Examine.com link.
	 */	
	@FindBy(linkText = "Examine.Com")
	WebElement examineDotComLink;
	
	/**
	 * Clicks the My Menu > My Diet Supplement Lookup > Dietary Supplement Label Database link.
	 * @category MyMenu
	 */
	public void clickDietartySupplementLabelDatabase() {
		AutomationHelper.printMethodName();
		clickMyMenu().moveToMyDietSupplementlookup().examineDotComLink.click();
	}
	
	/**
	 * Obtains a reference to the Dietary Supplement Label Database (DSLD) link.
	 */
	@FindBy(linkText = "Dietary Supplement Label Database (DSLD)")
	WebElement dietarySupplementLabelDatabaseLink;
	
	/**
	 * Clicks the My Menu > My Diet Supplement Lookup > Dietary Supplement Label Database (DSLD) link.
	 * @category MyMenu
	 */
	public void clickDietartySupplementLabelDatabaseLink() {
		AutomationHelper.printMethodName();
		clickMyMenu().moveToMyDietSupplementlookup().dietarySupplementLabelDatabaseLink.click();
	}
	
	/**
	 * Obtains a reference to the MedLinePlus link.
	 */
	@FindBy (linkText = "MedLinePlus")
	WebElement medLinePlusLink;
	
	/**
	 * Clicks the My Menu > My Diet Supplement Lookup > MedLinePlus link.
	 * @category MyMenu
	 */
	public void clickMedLinePlus() {
		AutomationHelper.printMethodName();
		clickMyMenu().moveToMyDietSupplementlookup().medLinePlusLink.click();
	}
	
	@FindBy (linkText = "My ACFT Score")
	WebElement myACFTScoreLink;
	
	/**
	 * Clicks the My Menu > My ACFT Score link.
	 * @category MyMenu
	 */
	public void clickMyACTFScoreLink() {
		AutomationHelper.printMethodName();
		clickMyMenu().myACFTScoreLink.click();
	}

	/**
	 * Obtains a reference to the My PFT Score menu link.
	 * 
	 * @category MyMenu
	 */
	@FindBy(linkText = "My PFT Score")
	WebElement myPFTScoreLink;

	/**
	 * Clicks the My Menu > My PFT Score link in the menus. Note: This method takes
	 * care of clicking My Menu.
	 * 
	 * @category MyMenu
	 */
	public void clickMyPFTScore() {
		AutomationHelper.printMethodName();
		clickMyMenu().myPFTScoreLink.click();
	}

	/**
	 * Obtains a reference to the My Progress Map menu link.
	 * 
	 * @category MyMenu
	 */
	@FindBy(linkText = "My Progress Map")
	WebElement myProgressMapLink;

	/**
	 * Clicks the My Menu > My Progress Map link in the menus. Note: This method
	 * takes care of clicking My Menu.
	 * 
	 * @category MyMenu
	 */
	public void clickMyProgressMap() {
		AutomationHelper.printMethodName();
		clickMyMenu().myProgressMapLink.click();
	}

	/**
	 * Obtains a reference to the My Team Progress Map menu link.
	 * 
	 * @category MyMenu
	 */
	@FindBy(linkText = "My Team Progress Map")
	WebElement myTeamProgressMapLink;

	/**
	 * Clicks the My Menu > My Team Progress Map link in the menus. Note: This
	 * method takes care of clicking My Menu.
	 * 
	 * @category MyMenu
	 */
	public void clickMyTeamProgressMap() {
		AutomationHelper.printMethodName();
		clickMyMenu().myTeamProgressMapLink.click();
	}

	/**
	 * Obtains a reference to the My Achievements menu link.
	 * 
	 * @category MyMenu
	 */
	@FindBy(linkText = "My Achievements")
	WebElement myAchievementsLink;

	/**
	 * Clicks the My Menu > My Achievements link in the menus. Note: This method
	 * takes care of clicking My Menu.
	 * 
	 * @category MyMenu
	 */
	public void clickMyAchievements() {
		AutomationHelper.printMethodName();
		clickMyMenu().myAchievementsLink.click();
	}

	/**
	 * Obtains a reference to the My Goals menu link.
	 * 
	 * @category MyMenu
	 */
	@FindBy(linkText = "My Challenges")
	WebElement myChallengesLink;

	/**
	 * Clicks the My Menu > My Challenges link in the menus. Note: This method takes
	 * care of clicking My Menu.
	 * 
	 * @category MyMenu
	 */
	public void clickMyChallenges() {
		AutomationHelper.printMethodName();
		clickMyMenu().myChallengesLink.click();
	}

	/**
	 * Obtains a reference to the My Goals menu link.
	 * 
	 * @category MyMenu
	 */
	@FindBy(linkText = "My Goals")
	WebElement myGoalsLink;

	/**
	 * Clicks the My Menu > My Goals link in the menus. Note: This method takes care
	 * of clicking My Menu.
	 * 
	 * @category MyMenu
	 */
	public void clickMyGoals() {
		AutomationHelper.printMethodName();
		clickMyMenu().myGoalsLink.click();
	}

	/**
	 * Obtains a reference to the My Team Goals menu link.
	 * 
	 * @category MyMenu
	 */
	@FindBy(linkText = "My Team Goals")
	WebElement myTeamGoalsLink;

	/**
	 * Clicks the My Menu > My Team Goals link in the menus. Note: This method takes
	 * care of clicking My Menu.
	 * 
	 * @category MyMenu
	 */
	public void clickMyTeamGoals() {
		AutomationHelper.printMethodName();
		clickMyMenu().myTeamGoalsLink.click();
	}

	/**
	 * Obtains a reference to the My Body Statistics menu link.
	 * 
	 * @category MyMenu
	 */
	@FindBy(linkText = "My Body Measurements for Survey")
	WebElement myBodyMeasurementsForSurveyLink;

	/**
	 * Clicks the My Menu > My Body Statistics link in the menus. Note: This method
	 * takes care of clicking My Menu.
	 * 
	 * @category MyMenu
	 */
	public void clickMyBodyMeasurementsForSurvey() {
		AutomationHelper.printMethodName();
		clickMyMenu().myBodyMeasurementsForSurveyLink.click();
	}

	/**
	 * Obtains a reference to the My Body Statistics menu link.
	 * 
	 * @category MyMenu
	 */
	@FindBy(linkText = "Blogs")
	WebElement blogsLink;

	/**
	 * Clicks the My Menu > Blogs link in the menus. Note: This method takes care of
	 * clicking My Menu.
	 * 
	 * @category MyMenu
	 */
	public void clickBlogs() {
		AutomationHelper.printMethodName();
		clickMyMenu().blogsLink.click();
	}

	/**
	 * Obtains a reference to the Track Individual Performance menu link.
	 * 
	 * @category Reports
	 */
	@FindBy(linkText = "Track Individual Performance")
	WebElement trackIndividualPerformanceReportsLink;


	/**
	 * Obtains a reference to the Reports menu link.
	 * 
	 * @category Reports
	 */
	@FindBy(linkText = "Reports")
	WebElement reportsLink;

	/**
	 * Clicks the Reports Link in the Menus.
	 * 
	 * @category Reports
	 */
	private MenusPageFactory clickReports() {
		AutomationHelper.printMethodName();
		reportsLink.click();
		return this;
	}
	
	/**
	 * Returns a reference to the Unit Overall Progress link.
	 */
	@FindBy(linkText = "Unit Overall Progress")
	WebElement unitOverallProgressLink;

	/**
	 * Clicks the Unit Overall Progress Link in the Menus. Note: This method takes
	 * care of clicking the Reports main menu.
	 * 
	 * @category Reports
	 */
	public void clickUnitOverallProgress() {
		AutomationHelper.printMethodName();
		clickReports().unitOverallProgressLink.click();
	}
	
	
	/**
	 * Obtains a reference to the Team Login Activity menu link.
	 * 
	 * @category Reports
	 */
	@FindBy(linkText = "Team Login Activity")
	WebElement teamLoginActivityReportsLink;

	/**
	 * Clicks the Team Login Activity Link in the Menus. Note: This method takes
	 * care of clicking the Reports main menu.
	 * 
	 * @category Reports
	 */
	public void clickTeamLoginActivity() {
		AutomationHelper.printMethodName();
		clickReports().teamLoginActivityReportsLink.click();
	}

/**
	 * Obtains a reference to the Team Overall Sleep menu link.
	 * 
	 * @category Reports
	 */
	@FindBy(linkText = "Team Overall Sleep")
	WebElement teamOverallSleepLink;

	/**
	 * Clicks the Team Overall Sleep Link in the Menus. Note: This method takes care
	 * of clicking the Reports main menu.
	 * 
	 * @category Reports
	 */
	public void clickTeamOverallSleep() {
		AutomationHelper.printMethodName();
		clickReports().teamOverallSleepLink.click();
	}

	/**
	 * Obtains a reference to the Team Activity menu link.
	 * 
	 * @category Reports
	 */
	@FindBy(linkText = "Team Activity")
	WebElement teamActivityReportsLink;

	/**
	 * Clicks the Team Activity Link in the Menus. Note: This method takes care of
	 * clicking the Reports main menu.
	 * 
	 * @category Reports
	 */
	public void clickTeamActivity() {
		AutomationHelper.printMethodName();
		clickReports().teamActivityReportsLink.click();
	}

	/**
	 * Obtains a reference to the Team Goal Achievements menu link.
	 * 
	 * @category Reports
	 */
	@FindBy(linkText = "Team Goal Achievements")
	WebElement teamGoalAchievements;

	/**
	 * Clicks the Team Goal Achievements in the Menus. Note: This method takes care
	 * of clicking the Reports main menu.
	 * 
	 * @category Reports
	 */
	public void clickTeamGoalAchievements() {
		AutomationHelper.printMethodName();
		clickReports().teamGoalAchievements.click();
	}
	
	/**
	 * Obtains a reference to the Nutrient Content menu link.
	 * 
	 * @category Reports
	 */
	@FindBy (linkText = "Nutrient Content")
	WebElement nutrientContentLink;
	
	/**
	 * Clicks the Nutrient Content link in the Menus. Note: This method takes care
	 * of clicking the Reports main menu.
	 * 
	 * @category Reports
	 */
	public void clickNutrientContent() {
		AutomationHelper.printMethodName();
		clickReports().nutrientContentLink.click();
	}
	
	/**
	 * Obtains a reference to the Body Measurement Changes menu link.
	 * 
	 * @category Reports
	 */
	@FindBy (linkText = "Body Measurement Changes")
	WebElement bodyMeasurementChangesLink;
	
	/**
	 * Clicks the Body Measurement Changes link in the Menus. Note: This method takes care
	 * of clicking the Reports main menu.
	 * 
	 * @category Reports
	 */
	public void clickBodyMeasurementChangesLink() {
		AutomationHelper.printMethodName();
		clickReports().bodyMeasurementChangesLink.click();
	}

	/**
	 * Obtains a reference to the My Activities menu link.
	 * 
	 * @category Reports
	 */
	@FindBy(xpath = "//a[@href='/TFT_Test/MyActivities']")
	WebElement myActivitiesReportLink;

	/**
	 * Clicks the My Activities Link in the Menus. Note: This method takes care of
	 * clicking the Reports main menu.
	 * 
	 * @category Reports
	 */
	public void clickMyActivitiesReport() {
		AutomationHelper.printMethodName();
		clickReports().myActivitiesReportLink.click();
	}

	/**
	 * Obtains a reference to the my Sleep menu link.
	 * 
	 * @category Reports
	 */
	@FindBy(linkText = "My Sleep")
	WebElement mySleepReportsLink;

	/**
	 * Clicks the My Sleep Link in the Menus. Note: This method takes care of
	 * clicking the Reports main menu.
	 * 
	 * @category Reports
	 */
	public void clickMySleepReport() {
		AutomationHelper.printMethodName();
		clickReports().mySleepReportsLink.click();
	}

	/**
	 * Obtains a reference to the Goal History menu link.
	 * 
	 * @category Reports
	 */
	@FindBy(linkText = "Goal History")
	WebElement goalHistoryReportsLink;

	/**
	 * Clicks the Goal History in the Menus. Note: This method takes care of
	 * clicking the Reports main menu.
	 * 
	 * @category Reports
	 */
	public void clickGoalHistoryReport() {
		AutomationHelper.printMethodName();
		clickReports().goalHistoryReportsLink.click();
	}

	/**
	 * Obtains a reference to the Goal Achievements menu link.
	 * 
	 * @category Reports
	 */
	@FindBy(linkText = "Goal Achievements")
	WebElement goalAchievementsReportsLink;

	/**
	 * Clicks the Goal Achievements Link in the Menus. Note: This method takes care
	 * of clicking the Reports main menu.
	 * 
	 * @category Reports
	 */
	public void clickGoalAchievementsReport() {
		AutomationHelper.printMethodName();
		clickReports().goalAchievementsReportsLink.click();
	}

	/**
	 * Obtains a reference to the Calories Burned / Ingested menu link.
	 * 
	 * @category Reports
	 */
	@FindBy(linkText = "Calories Burned/Ingested")
	WebElement caloriesBurnedIngestedReportsLink;

	/**
	 * Clicks the Calories Burned/Ingested in the Menus. Note: This method takes
	 * care of clicking the Reports main menu.
	 * 
	 * @category Reports
	 */
	public void clickCaloriesBurnedIngestedReport() {
		AutomationHelper.printMethodName();
		clickReports().caloriesBurnedIngestedReportsLink.click();
	}

	/**
	 * Obtains a reference to the My Body Measurements Changes menu link.
	 * 
	 * @category Reports
	 */
	@FindBy(linkText = "My Body Measurement Changes")
	WebElement myBodyMeasurementChangesLink;

	/**
	 * Clicks the My Body Measurements Changes link in the Menus. Note: This method
	 * takes care of clicking the Reports main menu.
	 * 
	 * @category Reports
	 */
	public void clickMyBodyMeasurementsChangesReport() {
		AutomationHelper.printMethodName();
		clickReports().myBodyMeasurementChangesLink.click();
	}
	
	/**
	 * Obtains a reference to the Team Current Steps menu link.
	 * 
	 * @category Reports
	 */
	@FindBy(linkText = "Team Current Steps")
	WebElement teamCurrentStepsLnk;

	/**
	 * Clicks the Team Current Steps link in the Menus. Note: This method
	 * takes care of clicking the Reports main menu.
	 * 
	 * @category Reports
	 */
	public void clickTeamCurrentSteps() {
		AutomationHelper.printMethodName();
		clickReports().teamCurrentStepsLnk.click();
	}

	
	/**
	 * Clicks the Admin link in the menus.
	 * 
	 * @category admin
	 */
	private MenusPageFactory clickAdmin() {
		AutomationHelper.printMethodName();
		adminLink.click();
		return this;
	}

	
	/**
	 * Obtains a reference to the Branch Component menu link.
	 * 
	 * @category admin
	 */
	@FindBy(linkText = "Branch Component")
	WebElement branchComponentLink;

	/**
	 * Clicks the Branch Component in the Admin menu. Note: This method takes care
	 * of clicking the Admin main menu.
	 * 
	 * @category admin
	 */
	public void clickBranchComponent() {
		AutomationHelper.printMethodName();
		clickAdmin().branchComponentLink.click();
	}
	
	/**
	 * Obtains a reference to the Branch of Service menu link.
	 * 
	 * @category admin
	 */
	@FindBy(linkText = "Branch of Service")
	WebElement branchOfServiceLink;

	/**
	 * Clicks the Branch of Service in the Admin menu. Note: This method takes care
	 * of clicking the Admin main menu.
	 * 
	 * @category admin
	 */
	public void clickBranchOfService() {
		AutomationHelper.printMethodName();
		clickAdmin().branchOfServiceLink.click();
	}

	/**
	 * Obtains a reference to the Body Measurement Type menu link.
	 * 
	 * @category admin
	 */
	@FindBy(linkText = "Body Measurement Type")
	WebElement bodyMeasurementTypeLink;

	/**
	 * Clicks the Body Measurement Type in the Admin menu. Note: This method takes
	 * care of clicking the Admin main menu.
	 * 
	 * @category admin
	 */
	public void clickBodyMeasurementType() {
		AutomationHelper.printMethodName();
		clickAdmin().bodyMeasurementTypeLink.click();
	}

	/**
	 * Obtains a reference to the Goals menu link.
	 * 
	 * @category admin
	 */
	@FindBy(linkText = "Goals")
	WebElement goalsLink;

	/**
	 * Clicks the Goals in the Admin menu. Note: This method takes care of clicking
	 * the Admin main menu.
	 * 
	 * @category admin
	 */
	public void clickGoals() {
		AutomationHelper.printMethodName();
		clickAdmin().goalsLink.click();
	}

	/*
	 * ADMIN RELATED MENUS
	 */
	
	/**
	 * Obtains a reference to the Notification Type menu link.
	 * 
	 * @category admin
	 */
	@FindBy(linkText = "Notification Type")
	WebElement notificationTypeLink;

	/**
	 * Clicks the Notification Type link in the Admin menu. Note: This method takes
	 * care of clicking the Admin main menu.
	 * 
	 * @category admin
	 */
	public void clickNotificationType() {
		clickAdmin();
		AutomationHelper.printMethodName();
		notificationTypeLink.click();
		AutomationHelper.waitForPageToLoad(timeout);
	}

	/**
	 * Obtains a reference to the PFT Scores menu link.
	 * 
	 * @category admin
	 */
	@FindBy(linkText = "PFT Scores")
	WebElement pftScoresLink;

	/**
	 * Clicks the PFT Scores Link in the Admin menu. Note: This method takes care of
	 * clicking the Admin main menu.
	 * 
	 * @category admin
	 */
	public void clickPFTScores() {
		AutomationHelper.printMethodName();
		clickAdmin().pftScoresLink.click();
	}

	/**
	 * Obtains a reference to the Roles menu link.
	 * 
	 * @category admin
	 */
	@FindBy(linkText = "Roles")
	WebElement rolesLink;

	/**
	 * Clicks the Roles Link in the Admin menu. Note: This method takes care of
	 * clicking the Admin main menu.
	 * 
	 * @category admin
	 */
	public void clickRoles() {
		AutomationHelper.printMethodName();
		clickAdmin().rolesLink.click();
	}

	/**
	 * Obtains a reference to the Units menu link.
	 * 
	 * @category admin
	 */
	@FindBy(linkText = "Units")
	WebElement unitsLink;

	/**
	 * Clicks the Units Link in the Admin menu. Note: This method takes care of
	 * clicking the Admin main menu.
	 * 
	 * @category admin
	 */
	public void clickUnits() {
		AutomationHelper.printMethodName();
		clickAdmin().unitsLink.click();
	}
	
	/**
	 * Obtains a reference to the Duty Position menu link.
	 * 
	 * @category admin
	 */
	@FindBy(linkText = "Duty Position")
	WebElement dutyPositionLink;

	/**
	 * Clicks the Duty Position Link in the Admin menu. Note: This method takes care
	 * of clicking the Admin main menu.
	 * 
	 * @category admin
	 */
	public void clickDutyPosition() {
		AutomationHelper.printMethodName();
		clickAdmin().dutyPositionLink.click();
	}
	
	/**
	 * Obtains a reference to the Grade/Rank menu link.
	 * 
	 * @category admin
	 */
	@FindBy(linkText = "Grade/Rank")
	WebElement gradeRankLink;

	/**
	 * Clicks the Grade/Rank Link in the Admin menu. Note: This method takes care
	 * of clicking the Admin main menu.
	 * 
	 * @category admin
	 */
	public void clickGradeRank() {
		AutomationHelper.printMethodName();
		clickAdmin().gradeRankLink.click();
	}

	/**
	 * Obtains a reference to the Reset Password menu link.
	 * 
	 * @category admin
	 */
	@FindBy(linkText = "Reset Password")
	WebElement resetPasswordLink;

	/**
	 * Clicks the Reset Password link in the Admin menu. Note: This method takes
	 * care of clicking the Admin main menu.
	 * 
	 * @category admin
	 */
	public void clickResetPassword() {
		AutomationHelper.printMethodName();
		clickAdmin().resetPasswordLink.click();
	}

	/**
	 * Obtains a reference to the Body Measurements Survey menu link.
	 * 
	 * @category admin
	 */
	@FindBy(linkText = "Body Measurements Survey")
	WebElement bodyMeasurementsSurveyLink;

	/**
	 * Clicks the Body Measurements Survey link in the Admin menu. Note: This method
	 * takes care of clicking the Admin main menu.
	 * 
	 * @category admin
	 */
	public void clickBodyMeasurementsSurvey() {
		AutomationHelper.printMethodName();
		clickAdmin().bodyMeasurementsSurveyLink.click();
	}

	
	

	/*
	 * THE FOLLOWING HAVE SUB-MENU ITEMS  
	 */
	
	/**
	 * Obtains a reference to the Activities menu link.
	 * 
	 * @category adminSubMenu
	 */
	@FindBy(linkText = "Activities")
	WebElement activitiesSubLink;

	/**
	 * Moves to the Admin > Activities menu option to display the sub-menu items.
	 */
	private MenusPageFactory moveToActivitiesInAdmin() {
		
		action.moveToElement(activitiesSubLink).build().perform();
		activitiesSubLink.click();
		action.moveToElement(activitiesSubLink).build().perform();
		return this;
//		Actions action = new Actions(driver);
//		clickAdmin();
//		AutomationHelper.printMethodName();
//		wait.until(ExpectedConditions.elementToBeClickable(activitiesSubLink));
//
//		// After hours of work, this combination tends to prompt the javascript
//		// to display the menus. It's not ideal, but it works.
//		activitiesSubLink.click();
//		action.moveToElement(activitiesSubLink).build().perform();
//		action.moveToElement(articlesAndBlogsSubLink).build().perform();
//		action.moveToElement(foodIntakeSubLink).build().perform();
//		action.moveToElement(activitiesSubLink).build().perform();
//		activitiesSubLink.click();
	}

	/**
	 * Obtains a reference to the Activities > Activity menu link.
	 * 
	 * @category adminSubSubMenu
	 */
	@FindBy(xpath = "//a[@href='/TFT_Test/Activities']")
	WebElement activitiesSubSubLink;

	/**
	 * Clicks the Activity menu option in the Admin > Activities menu option. This
	 * method takes care of clicking Admin, hovering over Activities, and then
	 * performing the click.
	 * 
	 * @throws InterruptedException
	 */
	public void clickActivity() {
		AutomationHelper.printMethodName();
		clickAdmin().moveToActivitiesInAdmin().activitiesSubSubLink.click();
	}

	/**
	 * Obtains a reference to the Activities > Activity Category menu link.
	 * 
	 * @category adminSubSubMenu
	 */
	@FindBy(linkText = "Activity Categories")
	WebElement activityCategoriesSubSubLink;

	/**
	 * Clicks the Activity Categories menu option in the Admin > Activities menu
	 * option. This method takes care of clicking Admin, hovering over Activities,
	 * and then performing the click.
	 */
	public void clickActivityCategories() {
		AutomationHelper.printMethodName();
		clickAdmin().moveToActivitiesInAdmin().activityCategoriesSubSubLink.click();
	}

	/**
	 * Obtains a reference to the Activities > Activity Sources menu link.
	 * 
	 * @category adminSubSubMenu
	 */
	@FindBy(linkText = "Activity Sources")
	WebElement activitySourcesSubSubLink;

	/**
	 * Clicks the Activity Sources menu option in the Admin > Activities menu
	 * option. This method takes care of clicking Admin, hovering over Activities,
	 * and then performing the click.
	 */
	public void clickActivitySources() {
		AutomationHelper.printMethodName();
		clickAdmin().moveToActivitiesInAdmin().activitySourcesSubSubLink.click();
	}

	/**
	 * Obtains a reference to the Activities > Intensity menu link.
	 * 
	 * @category adminSubSubMenu
	 */
	@FindBy(linkText = "Intensity")
	WebElement intensitySubSubLink;

	/**
	 * Clicks the Intensity menu option in the Admin > Activities menu option. This
	 * method takes care of clicking Admin, hovering over Activities, and then
	 * performing the click.
	 */
	public void clickIntensity() {
		AutomationHelper.printMethodName();
		clickAdmin().moveToActivitiesInAdmin().intensitySubSubLink.click();
	}

	/**
	 * Obtains a reference to the Activities > Mood menu link.
	 * 
	 * @category adminSubSubMenu
	 */
	@FindBy(linkText = "Mood")
	WebElement moodSubSubLink;

	/**
	 * Clicks the Mood menu option in the Admin > Activities menu option. This
	 * method takes care of clicking Admin, hovering over Activities, and then
	 * performing the click.
	 */
	public void clickMood() {
		AutomationHelper.printMethodName();
		clickAdmin().moveToActivitiesInAdmin().moodSubSubLink.click();
	}

	/**
	 * Obtains a reference to the Articles & Blogs menu link.
	 * 
	 * @category adminSubMenu
	 */
	@FindBy(linkText = "Articles & Blogs")
	WebElement articlesAndBlogsSubLink;

	/**
	 * Clicks the Admin > Articles menu option to display the sub-menu items.
	 */
	private MenusPageFactory moveToArticlesAndBlogsInAdmin() {
		
		action.moveToElement(articlesAndBlogsSubLink).build().perform();
		return this;
//		Actions action = new Actions(driver);
//		clickAdmin();
//		AutomationHelper.printMethodName();
//		wait.until(ExpectedConditions.elementToBeClickable(articlesAndBlogsSubLink));
//
//		// After hours of work, this combination tends to prompt the javascript
//		// to display the menus. It's not ideal, but it works.
//		articlesAndBlogsSubLink.click();
//		action.moveToElement(articlesAndBlogsSubLink).build().perform();
//		action.moveToElement(foodIntakeSubLink).build().perform();
//		action.moveToElement(progressMapSubLink).build().perform();
//		action.moveToElement(articlesAndBlogsSubLink).build().perform();
//		articlesAndBlogsSubLink.click();
	}

	/**
	 * Obtains a reference to the Articles > Articles & Blogs menu link.
	 * 
	 * @category articlesAndBlogsSubSubMenu
	 */
	@FindBy(xpath = "//a[@href='/TFT_Test/Articles']")
	WebElement articlesSubSubLink;

	/**
	 * Clicks the Articles sub menu option in the Admin > Articles & Blogs menu
	 * option. This method takes care of clicking Admin, hovering over Admin >
	 * Articles & Blogs, and then performing the click.
	 */
	public void clickArticlesSubMenu() {
		AutomationHelper.printMethodName();
		clickAdmin().moveToArticlesAndBlogsInAdmin().articlesSubSubLink.click();
	}

	/**
	 * Obtains a reference to the Articles > Articles & Blogs Type menu link.
	 * 
	 * @category articlesAndBlogsSubSubMenu
	 */
	@FindBy(linkText = "Article Types")
	WebElement articleTypeSubSubLink;

	/**
	 * Clicks the Article Types sub menu option in the Admin > Articles & Blogs menu
	 * option. This method takes care of clicking Admin, hovering over Admin >
	 * Articles & Blogs, and then performing the click.
	 */
	public void clickArticleTypesSubMenu() {
		AutomationHelper.printMethodName();
		clickAdmin().moveToArticlesAndBlogsInAdmin().articleTypeSubSubLink.click();
	}

	/**
	 * Obtains a reference to the Articles & Blogs > Blogs menu link.
	 * 
	 * @category articlesAndBlogsSubSubMenu
	 */
	@FindBy(xpath = "//a[@href='/TFT_Test/Blogs/AdminIndex']")
	WebElement blogsSubSubLink;

	/**
	 * Clicks the Blogs sub menu option in the Admin > Articles & Blogs menu option.
	 * This method takes care of clicking Admin, hovering over Articles & Blogs, and
	 * then performing the click.
	 */
	public void clickBlogsSubMenu() {
		AutomationHelper.printMethodName();
		clickAdmin().moveToArticlesAndBlogsInAdmin().blogsSubSubLink.click();
	}

	/**
	 * Obtains a reference to the Food Intake menu link.
	 * 
	 * @category foodIntakeSubMenu
	 */
	@FindBy(linkText = "Food Intake")
	WebElement foodIntakeSubLink;

	/**
	 * Clicks the Admin > Food Intake menu option to display the sub-menu items.
	 */
	private MenusPageFactory moveToFoodIntakeInAdmin() {
		action.moveToElement(foodIntakeSubLink).build().perform();
		return this;
		
//		Actions action = new Actions(driver);
//		clickAdmin();
//		AutomationHelper.printMethodName();
//		wait.until(ExpectedConditions.elementToBeClickable(foodIntakeSubLink));
//
//		// After hours of work, this combination tends to prompt the javascript
//		// to display the menus. It's not ideal, but it works.
//		foodIntakeSubLink.click();
//		action.moveToElement(foodIntakeSubLink).build().perform();
//		action.moveToElement(progressMapSubLink).build().perform();
//		action.moveToElement(teamsAndUsersSubLink).build().perform();
//		action.moveToElement(foodIntakeSubLink).build().perform();
//
//		foodIntakeSubLink.click();
	}

	/**
	 * Obtains a reference to the Foods menu link.
	 * 
	 * @category foodIntakeSubSubMenu
	 */
	@FindBy(linkText = "Foods")
	WebElement foodsSubSubLink;

	/**
	 * Clicks the Foods sub menu option in the Admin > Food Intake menu option. This
	 * method takes care of clicking Admin, hovering over Food Intake, and then
	 * performing the click.
	 */
	public void clickFoodsSubMenu() {
		AutomationHelper.printMethodName();
		clickAdmin().moveToFoodIntakeInAdmin().foodsSubSubLink.click();
	}

	/**
	 * Obtains a reference to the Meal Type menu link.
	 * 
	 * @category foodIntakeSubSubMenu
	 */
	@FindBy(linkText = "Meal Type")
	WebElement mealTypeSubSubLink;

	/**
	 * Clicks the Meal Type sub menu option in the Admin > Food Intake menu option.
	 * This method takes care of clicking Admin, hovering over Food Intake, and then
	 * performing the click.
	 */
	public void clickMealTypeSubMenu() {
		AutomationHelper.printMethodName();
		clickAdmin().moveToFoodIntakeInAdmin().foodsSubSubLink.click();
	}

	/**
	 * Obtains a reference to the Progress Map menu link.
	 * 
	 * @category progressMapSubMenu
	 */
	@FindBy(linkText = "Progress Map")
	WebElement progressMapSubLink;

	/**
	 * Clicks the Admin > Progress Map menu option to display the sub-menu items.
	 */
	private MenusPageFactory moveToProgressMapInAdmin() {
		
		action.moveToElement(progressMapSubLink).build().perform();
		return this;
//		Actions action = new Actions(driver);
//		clickAdmin();
//		AutomationHelper.printMethodName();
//		wait.until(ExpectedConditions.elementToBeClickable(progressMapSubLink));
//
//		// After hours of work, this combination tends to prompt the javascript
//		// to display the menus. It's not ideal, but it works.
//		progressMapSubLink.click();
//		action.moveToElement(progressMapSubLink).build().perform();
//		action.moveToElement(foodIntakeSubLink).build().perform();
//		action.moveToElement(articlesAndBlogsSubLink).build().perform();
//		action.moveToElement(progressMapSubLink).build().perform();
//		progressMapSubLink.click();
	}

	/**
	 * Obtains a reference to the Location menu link.
	 * 
	 * @category progressMapSubSubMenu
	 */
	@FindBy(linkText = "Location")
	WebElement locationSubSubMenu;

	/**
	 * Clicks the Location sub menu option in the Admin > Progress Map menu option.
	 * This method takes care of clicking Admin, hovering over Progress Map, and
	 * then performing the click.
	 */
	public void clickLocationSubMenu() {
		AutomationHelper.printMethodName();
		clickAdmin().moveToProgressMapInAdmin().locationSubSubMenu.click();
	}

	/**
	 * Obtains a reference to the Route menu link.
	 * 
	 * @category progressMapSubSubMenu
	 */
	@FindBy(linkText = "Route")
	WebElement routeSubSubMenu;

	/**
	 * Clicks the Route sub menu option in the Admin > Progress Map menu option.
	 * This method takes care of clicking Admin, hovering over Progress Map, and
	 * then performing the click.
	 */
	public void clickRouteSubMenu() {
		AutomationHelper.printMethodName();
		clickAdmin().moveToProgressMapInAdmin().routeSubSubMenu.click();
	}

	/**
	 * Obtains a reference to the Route Locations menu link.
	 * 
	 * @category progressMapSubSubMenu
	 */
	@FindBy(linkText = "Route Locations")
	WebElement routeLocationsSubSubMenu;

	/**
	 * Clicks the Route Locations sub menu option in the Admin > Progress Map menu
	 * option. This method takes care of clicking Admin, hovering over Progress Map,
	 * and then performing the click.
	 */
	public void clickRouteLocationsSubMenu() {
		AutomationHelper.printMethodName();
		clickAdmin().moveToProgressMapInAdmin().routeLocationsSubSubMenu.click();
	}

	/**
	 * Obtains a reference to the Admin menu link.
	 * 
	 * @category admin
	 */
	@FindBy(linkText = "Admin")
	WebElement adminLink;

	/**
	 * Obtains a reference to the Teams & Users menu link.
	 * 
	 * @category teamsAndUsersSubMenu
	 */
	@FindBy(linkText = "Teams & Users")
	WebElement teamsAndUsersSubLink;

	/**
	 * Clicks the Admin > Team & Users menu option to display the sub-menu items.
	 */
	private MenusPageFactory moveToTeamsAndUsersInAdmin() {
		
		action.moveToElement(teamsAndUsersSubLink).build().perform();
		return this;
		
		
//		Actions action = new Actions(driver);
//		clickAdmin();
//		AutomationHelper.printMethodName();
//		wait.until(ExpectedConditions.elementToBeClickable(teamsAndUsersSubLink));
//
//		// After hours of work, this combination tends to prompt the javascript
//		// to display the menus. It's not ideal, but it works.
//		teamsAndUsersSubLink.click();
//		action.moveToElement(teamsAndUsersSubLink).build().perform();
//		action.moveToElement(progressMapSubLink).build().perform();
//		action.moveToElement(foodIntakeSubLink).build().perform();
//		action.moveToElement(teamsAndUsersSubLink).build().perform();
//		teamsAndUsersSubLink.click();
	}

	/**
	 * Obtains a reference to the Teams menu link.
	 * 
	 * @category teamsAndUsersSubSubMenu
	 */
	@FindBy(linkText = "Teams")
	WebElement teamsSubSubLink;

	/**
	 * Clicks the Teams sub menu option in the Admin > Teams & Users menu option.
	 * This method takes care of clicking Admin, hovering over Teams & Users, and
	 * then performing the click.
	 */
	public void clickTeamsSubMenu() {
		AutomationHelper.printMethodName();
		clickAdmin().moveToTeamsAndUsersInAdmin().teamsSubSubLink.click();
	}

	/**
	 * Obtains a reference to the Team Leads menu link.
	 * 
	 * @category teamsAndUsersSubSubMenu
	 */
	@FindBy(linkText = "Team Leads")
	WebElement teamLeadsSubSubLink;

	/**
	 * Clicks the Team Leads sub menu option in the Admin > Teams & Users menu
	 * option. This method takes care of clicking Admin, hovering over Teams &
	 * Users, and then performing the click.
	 */
	public void clickTeamLeadsSubMenu() {
		AutomationHelper.printMethodName();
		clickAdmin().moveToTeamsAndUsersInAdmin().teamLeadsSubSubLink.click();
	}

	/**
	 * Obtains a reference to the Team Members menu link.
	 * 
	 * @category teamsAndUsersSubSubMenu
	 */
	@FindBy(linkText = "Team Members")
	WebElement teamMembersSubSubLink;

	/**
	 * Clicks the Team Members sub menu option in the Admin > Teams & Users menu
	 * option. This method takes care of clicking Admin, hovering over Teams &
	 * Users, and then performing the click.
	 */
	public void clickTeamMembersSubMenu() {
		AutomationHelper.printMethodName();
		clickAdmin().moveToTeamsAndUsersInAdmin().teamMembersSubSubLink.click();
	}

	/**
	 * Obtains a reference to the Users menu link.
	 * 
	 * @category teamsAndUsersSubSubMenu
	 */
	@FindBy(linkText = "Users")
	WebElement usersSubSubLink;

	/**
	 * Clicks the Users sub menu option in the Admin > Teams & Users menu option.
	 * This method takes care of clicking Admin, hovering over Teams & Users, and
	 * then performing the click.
	 */
	public void clickUsersSubMenu() {
		AutomationHelper.printMethodName();
		clickAdmin().moveToTeamsAndUsersInAdmin().usersSubSubLink.click();
	}

	/**
	 * Obtains a reference to the Validic menu link.
	 * 
	 * @category validicSubMenu
	 */
	@FindBy(linkText = "Validic")
	WebElement validicSubLink;

	/**
	 * Clicks the Admin > Validic menu option to display the sub-menu items.
	 */
	private MenusPageFactory moveToValidicInAdmin() {
		action.moveToElement(validicSubLink).build().perform();
		return this;
//		Actions action = new Actions(driver);
//		clickAdmin();
//		AutomationHelper.printMethodName();
//		wait.until(ExpectedConditions.elementToBeClickable(validicSubLink));
//
//		// After hours of work, this combination tends to prompt the javascript
//		// to display the menus. It's not ideal, but it works.
//		validicSubLink.click();
//		action.moveToElement(validicSubLink).build().perform();
//		action.moveToElement(teamsAndUsersSubLink).build().perform();
//		action.moveToElement(progressMapSubLink).build().perform();
//		action.moveToElement(validicSubLink).build().perform();
//		validicSubLink.click();
	}

	/**
	 * Obtains a reference to the Delete Validic User menu link.
	 * 
	 * @category validicSubSubMenu
	 */
	@FindBy(linkText = "Delete Validic User")
	WebElement deleteValidicUserSubSubLink;

	/**
	 * Clicks the Delete Validic User sub menu option in the Admin > Validic menu
	 * option. This method takes care of clicking Admin, hovering over Validic, and
	 * then performing the click.
	 */
	public void clickDeleteValidicUserSubMenu() {
		AutomationHelper.printMethodName();
		clickAdmin().moveToValidicInAdmin().deleteValidicUserSubSubLink.click();
	}

/**
	 * Obtains a reference to the Team Fitness Tracker Users menu link.
	 * 
	 * @category validicSubSubMenu
	 */
	@FindBy(linkText = "Team Fitness Tracker Users")
	WebElement teamFitnessTrackerUsersSubSubLink;

	/**
	 * Clicks the Team Fitness Tracker Users sub menu option in the Admin > Validic
	 * menu option. This method takes care of clicking Admin, hovering over Validic,
	 * and then performing the click.
	 */
	public void clickTeamFitnessTrackerUsersSubMenu() {
		AutomationHelper.printMethodName();
		clickAdmin().moveToValidicInAdmin().teamFitnessTrackerUsersSubSubLink.click();
	}



	/**
	 * Obtains a reference to the Help link.
	 */
	@FindBy(xpath = "//a[contains(text(), 'Help')]")
	WebElement helpLink;

	/**
	 * Clicks the Help button link in the menu
	 * 
	 * @category Help
	 */
	public void clickHelp() {
		AutomationHelper.printMethodName();
		wait.until(ExpectedConditions.elementToBeClickable(helpLink));
		helpLink.click();
	}
	/**
	 * Obtains a reference to the User Menu link.
	 * 
	 * @category UserMenu
	 */
	@FindBy(partialLinkText = "Hello")
	WebElement userMenuLink;

	/**
	 * Clicks the User Menu Link in the Menus. Note: This is the menu that says
	 * "Hello User Name!"
	 * 
	 * @category UserMenu
	 */
	private MenusPageFactory clickUserMenu() {
		
		AutomationHelper.printMethodName();
		userMenuLink.click();
		return this;

	}


	/**
	 * Obtains a reference to the Profile menu link.
	 * 
	 * @category helloMenu
	 */
	@FindBy(linkText = "Profile")
	WebElement profileLink;

	/**
	 * Clicks the Profile menu option in Hello User menu. Note: This method handles
	 * clicking "Hello user" menu first.
	 * 
	 * @category UserMenu
	 */
	public void clickProfile() {
		AutomationHelper.printMethodName();
		clickUserMenu().profileLink.click();
	}

	/**
	 * Obtains a reference to the PRT Status menu link.
	 * 
	 * @category helloMenu
	 */
	@FindBy(linkText = "PRT Status")
	WebElement prtStatusLink;

	/**
	 * Clicks the PRT Status menu option in Hello User menu. Note: This method
	 * handles clicking "Hello user" menu first.
	 * 
	 * @category UserMenu
	 */
	public void clickPRTStatus() {
		AutomationHelper.printMethodName();
		clickUserMenu().prtStatusLink.click();
	}
	
	/**
	 * Obtains a reference to the Team Memberships Status menu link.
	 * 
	 * @category helloMenu
	 */
	@FindBy(linkText = "Team Memberships")
	WebElement teamMembershipsLink;

	/**
	 * Clicks the Team Memberships menu option in Hello User menu. Note: This method
	 * handles clicking "Hello user" menu first.
	 * 
	 * @category UserMenu
	 */
	public void clickTeamMemberships() {
		AutomationHelper.printMethodName();
		clickUserMenu().teamMembershipsLink.click();
	}

	
	/**
	 * Obtains a reference to the Register Device menu link.
	 * 
	 * @category helloMenu
	 */
	@FindBy(linkText = "Register Device")
	WebElement registerDeviceLink;

	/**
	 * Clicks the Register Device menu option in Hello User menu. Note: This method
	 * handles clicking "Hello user" menu first.
	 * 
	 * @category UserMenu
	 */
	public void clickRegisterDevice() {
		AutomationHelper.printMethodName();
		clickUserMenu().registerDeviceLink.click();
	}

	/**
	 * Obtains a reference to the Change Password link.
	 * 
	 * @category helloMenu
	 */
	@FindBy(linkText = "Change Password")
	WebElement changePasswordLink;

	/**
	 * Clicks the Change Password menu option in Hello User menu. Note: This method
	 * handles clicking "Hello user" menu first.
	 * 
	 * @category UserMenu
	 */
	public void clickChangePassword() {
		AutomationHelper.printMethodName();
		clickUserMenu().changePasswordLink.click();
	}

	/**
	 * Obtains a reference to the Log off link.
	 * 
	 * @category helloMenu
	 */
	@FindBy(linkText = "Log off")
	WebElement logOffLink;

	/**
	 * Clicks the Log Off menu option in Hello User menu. Note: This method handles
	 * clicking "Hello user" menu first.
	 * 
	 * @category UserMenu
	 */
	public void clickLogOff() {
		AutomationHelper.printMethodName();
		clickUserMenu().logOffLink.click();
	}
	



	/**
	 * Obtains a reference to the greeting name
	 */
	@FindBy(xpath = "//a[contains(text(), 'Hello')]")
	WebElement greetingName;

	/**
	 * Returns the greeting name in the header of a given page, WITHOUT the "Hello"
	 * and "!".
	 * 
	 * @return String - the greeting name
	 */
	public String readGreetingName() {
		Reporter.log("Reading Greeting Name", true);
		String name = this.greetingName.getAttribute("text");

		// Remove the Hello and the "!" from the string.
		name = name.replace("Hello", "").replace("!", "").trim();

		Reporter.log("Greeting name is " + name, true);
		Reporter.log("", true);

		return name;

	}

	/**
	 * Counts the number of links (sub-menu items) in the My Menu menu.
	 * 
	 * @return int
	 */
	public int getMyMenuOptionCount() {
		// Obtain a list of links below the drop down menus.
		// Xpath info - finds the menu option by the name, gets the parent LI by "/..",
		// then finds all the down stream children that are Html.a.
		List<WebElement> listItems = driver.findElements(By.xpath("//a[contains(text(),'My Menu')]/..//child::a"));

		// Minus one because we do not want to count the Menu Option header itself (it's
		// a link).
		return listItems.size() - 1;
	}

	/**
	 * Counts the number of links (sub-menu items) in the Reports menu.
	 * 
	 * @return int
	 */
	public int getReportsMenuOptionCount() {
		// Obtain a list of links below the drop down menus.
		// Xpath info - finds the menu option by the name, gets the parent LI by "/..",
		// then finds all the down stream children that are Html.a.
		List<WebElement> listItems = driver.findElements(By.xpath("//a[contains(text(),'Reports')]/..//child::a"));

		// Minus one because we do not want to count the Menu Option header itself (it's
		// a link).
		return listItems.size() - 1;
	}

	/**
	 * Counts the number of links (sub-menu items) in the Admin menu.
	 * 
	 * @return int
	 */
	public int getAdminMenuOptionCount() {
		// Obtain a list of links below the drop down menus.
		// Xpath info - finds the menu option by the name, gets the parent LI by "/..",
		// then finds all the down stream children that are Html.a.
		List<WebElement> listItems = driver.findElements(By.xpath("//a[starts-with(.,'Admin')]/..//child::a"));

		// Minus one because we do not want to count the Menu Option header itself (it's
		// a link).
		return listItems.size() - 1;
	}

	/**
	 * Obtains a reference to the Notifications link
	 */
	@FindBy(id = "numberOfNewNotifications")
	WebElement notificationsLink;

	/**
	 * Clicks the Notifications link (With the bell icon).
	 */
	public void clickNotificationsLink() {
		notificationsLink.click();
		AutomationHelper.waitForPageToLoad(NORMAL_TIMEOUT);
	}

	/**
	 * Reads the number of notifications on the page header.
	 * 
	 * @return int
	 */
	public int readNumberOfNotifications() {
		// Sometimes the number will not load fast enough.

		try {
			return Integer.valueOf(notificationsLink.getText());

		} catch (NumberFormatException e) {
			AutomationHelper.waitSeconds(2);
			return Integer.valueOf(notificationsLink.getText());

		}

	}

	/**
	 * Counts the number of links (sub-menu items) in the Hello User menu.
	 * 
	 * @return int
	 */
	public int getHelloUserOptionCount() {
		// Obtain a list of links below the drop down menus.
		// Xpath info - finds the menu option by the name, gets the parent LI by "/..",
		// then finds all the down stream children that are Html.a.
		List<WebElement> listItems = driver.findElements(By.xpath("//a[contains(text(),'Hello')]/..//child::a"));

		// Minus one because we do not want to count the Menu Option header itself (it's
		// a link).
		return listItems.size() - 1;
	}

}
