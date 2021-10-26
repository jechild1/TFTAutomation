package testCases;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import modularScripts.LoginMod;
import pageFactories.HomePageFactory;
import pageFactories.Admin.Activities.Activity.ActivitiesPageFactory;
import pageFactories.Admin.Activities.ActivityCategories.ActivityCategoryPageFactory;
import pageFactories.Admin.Activities.ActivitySources.ActivitySourcesPageFactory;
import pageFactories.Admin.Activities.Intensity.IntensityPageFactory;
import pageFactories.Admin.Activities.Mood.MoodPageFactory;
import pageFactories.Admin.ArticlesAndBlogs.ArticleTypes.ArticleTypesPageFactory;
import pageFactories.Admin.ArticlesAndBlogs.Articles.ArticlesPageFactory;
import pageFactories.Admin.BodyMeasurementType.BodyMeasurementTypePageFactory;
import pageFactories.Admin.BodyMeasurementsSurvey.BodyMeasurementsSurveyPageFactory;
import pageFactories.Admin.BranchComponent.BranchComponentPageFactory;
import pageFactories.Admin.BranchOfService.BranchOfServicePageFactory;
import pageFactories.Admin.DutyPosition.DutyPositionPageFactory;
import pageFactories.Admin.FoodIntake.Foods.FoodsPageFactory;
import pageFactories.Admin.FoodIntake.MealType.MealTypePageFactory;
import pageFactories.Admin.Goals.GoalsPageFactory;
import pageFactories.Admin.GradeRank.GradeRankPageFactory;
import pageFactories.Admin.NotificationType.NotificationTypesPageFactory;
import pageFactories.Admin.PFTScores.PFTScoresPageFactory;
import pageFactories.Admin.ProgressMap.Location.LocationsPageFactory;
import pageFactories.Admin.ResetPassword.ResetPasswordPageFactory;
import pageFactories.Admin.Roles.RolesPageFactory;
import pageFactories.Admin.Units.UnitsPageFactory;
import pageFactories.MyMenu.Blogs.BlogsPageFactory;
import pageFactories.MyMenu.MyACFTScore.MyACFTScorePageFactory;
import pageFactories.MyMenu.MyAchievements.MyAchievementsPageFactory;
import pageFactories.MyMenu.MyActivities.MyActivitiesPageFactory;
import pageFactories.MyMenu.MyBodyMeasurements.BodyMeasurementsPageFactory;
import pageFactories.MyMenu.MyCalorieIntake.MyCalorieIntakePageFactory;
import pageFactories.MyMenu.MyChallenges.MyChallengesPageFactory;
import pageFactories.MyMenu.MyGoals.MyGoalsPageFactory;
import pageFactories.MyMenu.MyPFTScore.MyPFTScorePageFactory;
import pageFactories.MyMenu.MyProfile.ProfilePageFactory;
import pageFactories.MyMenu.MyProgressMap.MyProgressMapPageFactory;
import pageFactories.MyMenu.MySleepLog.SleepLogPageFactory;
import pageFactories.MyMenu.MyTeamGoals.MyTeamGoalsPageFactory;
import pageFactories.MyMenu.MyTeamProgressMap.MyTeamProgressMapPageFactory;
import pageFactories.Reports.BodyMeasurementChanges.BodyMeasurementChangesPageFactory;
import pageFactories.Reports.CaloriesBurnedIngested.CaloriesBurnedIngestedPageFactory;
import pageFactories.Reports.GoalAchievements.GoalAchievementsPageFactory;
import pageFactories.Reports.GoalHistory.GoalHistoryPageFactory;
import pageFactories.Reports.MyBodyMeasurementChanges.MyBodyMeasurementChangesPageFactory;
import pageFactories.Reports.MySleep.MySleepPageFactory;
import pageFactories.Reports.NutrientContent.NutrientContentPageFactory;
import pageFactories.Reports.TeamActivity.TeamActivityPageFactory;
import pageFactories.Reports.TeamCurrentSteps.TeamCurrentStepsPageFactory;
import pageFactories.Reports.TeamGoalAchievements.TeamGoalAchievementsPageFactory;
import pageFactories.Reports.TeamLoginActivity.TeamLoginActivityPageFactory;
import pageFactories.Reports.TeamOverallSleep.TeamOverallSleepPageFactory;
import pageFactories.Reports.UnitOverallProgress.UnitOverallProgressPageFactory;
import utilities.ExcelDataConfig;

public class Menus_Administrator extends BaseTestScriptConfig {
	
	//Holds the amount of menus we expect for the various menu sections. The number EXCLUDES 
	
	public final static int MY_MENU_SIZE = 18;
	public final static int REPORTS_MENU_SIZE = 14;
	public final static int ADMIN_MENU_SIZE = 31;
	public final static int HELLO_MENU_SIZE = 6;
	
	
	@Test(dataProvider = "adminRoles")
	public void executeTest(String userName) {
		
		/*
		 * There are 4 separate menu items for an Admin. (1) My Menu (2) Reports (3)
		 * Admin (4) "Hello" menu
		 * 
		 * Check that the size of these menus and sub menus do not change from a given
		 * static value.
		 */
		
		LoginMod login = new LoginMod();
		login.execute(userName);
		
		//For administrators, we must assert there are 4 major menus available
		assertMyMenuSize();
		assertReportsSize();
		assertAdminSize();
		assertHelloSize();
		
//		assertMyMenuContent();
//		assertReportsMenuContent();
		assertAdminMenuContent();
		





	
		

		
	}
	
	/**
	 * Utility method to assert the size of the My Menu for an Admin role.
	 */
	private void assertMyMenuSize() {
		//MY MENU
		List<WebElement> myMenuSubMenus = driver.findElements(By.xpath("//a[@href='#' and contains (text(), 'My Menu')]/..//a[not(@href='#')]"));
		

		Reporter.log("Asserting that the My Menu Size is " + MY_MENU_SIZE + ".", true);
		Assert.assertEquals(myMenuSubMenus.size(), MY_MENU_SIZE, "Sub Link count for My Menu");
		Reporter.log("My Menu - Sub Menu size: " + myMenuSubMenus.size(), true);
		
		//Create a loop to print out all the URL's in the console.
		for(int i = 0; i < myMenuSubMenus.size(); i++) {
			Reporter.log("My Menu URL # " + (i+1) + ":" + myMenuSubMenus.get(i).getAttribute("href"), true);
		}
		Reporter.log("", true);

	}
	
	/**
	 * Utility method to assert the size of the Reports menu for an Admin role.
	 */
	private void assertReportsSize() {
		//Obtain all of the links in an List object
		List<WebElement> reportsSubMenus = driver.findElements(By.xpath("//a[@href='#' and contains (text(), 'Reports')]/..//a[not(@href='#')]"));
		
		Reporter.log("Asserting that the Reports menu size is " + REPORTS_MENU_SIZE + ".", true);
		Assert.assertEquals(reportsSubMenus.size(), REPORTS_MENU_SIZE, "Sub link count for Reports");
		Reporter.log("Reports - Sub Menu size: " + reportsSubMenus.size(), true );
		
		//Create a loop to print out all the URL's in the console.
		for(int i = 0; i < reportsSubMenus.size(); i++) {
			Reporter.log("Reports URL # " + (i+1) + ":" + reportsSubMenus.get(i).getAttribute("href"), true);
		}
		Reporter.log("", true);
	}
	
	/**
	 * Utility method to assert the size of the Admin menu for an Admin role.
	 */
	private void assertAdminSize() {
		//Obtain all of the links in an List object
		List<WebElement> adminSubMenus = driver.findElements(By.xpath("//a[@href='#'][text()='Admin']/..//a[not(@href='#')]"));
		
		Reporter.log("Asserting that the Admin menu size is " + ADMIN_MENU_SIZE + ".", true);
		Assert.assertEquals(adminSubMenus.size(), ADMIN_MENU_SIZE, "Sub link count for Admin");
		Reporter.log("Admin - Sub Menu size: " + adminSubMenus.size(), true );
		
		//Create a loop to print out all the URL's in the console.
		for(int i = 0; i < adminSubMenus.size(); i++) {
			Reporter.log("Admin URL # " + (i+1) + ":" + adminSubMenus.get(i).getAttribute("href"), true);
		}
		Reporter.log("", true);
	}
	
	/**
	 * Utility method to assert the size of the Hello menu for an Hello role.
	 */
	private void assertHelloSize() {
		//Obtain all of the links in an List object
		List<WebElement> helloSubMenus = driver.findElements(By.xpath("//a[@href='#' and contains (text(), 'Hello')]/..//a[not(@href='#')]"));
		
		Reporter.log("Asserting that the Hello menu size is " + HELLO_MENU_SIZE + ".", true);
		Assert.assertEquals(helloSubMenus.size(), HELLO_MENU_SIZE, "Sub link count for Hello Menu");
		Reporter.log("Hello - Sub Menu size: " + helloSubMenus.size(), true );
		
		//Create a loop to print out all the URL's in the console.
		for(int i = 0; i < helloSubMenus.size(); i++) {
			Reporter.log("Hello Menu URL # " + (i+1) + ":" + helloSubMenus.get(i).getAttribute("href"), true);
		}
		Reporter.log("", true);
	}
	
	private void assertMyMenuContent() {
		
		//Load each page in the MY MENU menu
		HomePageFactory homePage = new HomePageFactory();
		homePage.clickMyActivities();
		
		//My Activities
		MyActivitiesPageFactory myActivitiesPage = new MyActivitiesPageFactory();
		softAsserter.assertEquals(myActivitiesPage.readPageTitle(), "My Activity Log", "My Menu - My Activity Log");
		myActivitiesPage.clickMyCalorieIntake();
		
		//My Calorie Intake
		MyCalorieIntakePageFactory calorieIntakePage = new MyCalorieIntakePageFactory();
		softAsserter.assertEquals(calorieIntakePage.readPageTitle(), "My Calorie Intake", "My Menu - My Calorie Intake");
		calorieIntakePage.clickMySleepLog();
		
		//My Sleep Log
		SleepLogPageFactory sleepLogPage = new SleepLogPageFactory();
		softAsserter.assertEquals(sleepLogPage.readPageTitle(), "Sleep Log", "My Menu - Sleep Log");
		sleepLogPage.clickMyBodyMeasurements();
		
		//My Body Measurements
		BodyMeasurementsPageFactory bodyMeasurementsPage = new BodyMeasurementsPageFactory();
		softAsserter.assertEquals(bodyMeasurementsPage.readPageTitle(), "Body Measurements", "My Menu - Body Measurements");
		bodyMeasurementsPage.clickMyProfile();
		
		//My Profile
		ProfilePageFactory profilePage = new ProfilePageFactory();
		softAsserter.assertEquals(profilePage.readPageTitle(), "Profile", "My Menu - Profile");
		
		/*
		 * Skipping My Diet Supplement Lookup pages as they are external to TFT
		 */
		
		profilePage.clickMyACTFScoreLink();
		
		//My ACFT Score
		MyACFTScorePageFactory acftScorePage = new MyACFTScorePageFactory();
//		softAsserter.assertEquals(acftScorePage.readPageTitle(), "My ACFT Score", "My Menu - My ACFT Score");
//		softAsserter.assertEquals(acftScorePage.readPageTitle(), "Internal Server Error - Team Fitness Tracker", "My Menu - My ACFT Score");
		
		acftScorePage.clickMyPFTScore();
		
		//My PFT Score - Army
		MyPFTScorePageFactory pftScorePage = new MyPFTScorePageFactory();
		softAsserter.assertEquals(pftScorePage.readPageTitle(), "My PFT Score - Army", "My Menu - My PFT Score - Army");
		pftScorePage.clickMyProgressMap();
		
		//My Progress Map
		MyProgressMapPageFactory myProgressMapPage = new MyProgressMapPageFactory();
		softAsserter.assertEquals(myProgressMapPage.readPageTitle(), "My Progress Map", "My Menu - My Progress Map");
		myProgressMapPage.clickMyTeamProgressMap();
		
		//My Team Progress Map
		MyTeamProgressMapPageFactory myTeamProgressMapPage = new MyTeamProgressMapPageFactory();
		softAsserter.assertEquals(myTeamProgressMapPage.readPageTitle(), "My Team Progress Map", "My Menu - My Team Progress Map");
		myTeamProgressMapPage.clickMyAchievements();
		
		//My Achievements
		MyAchievementsPageFactory myAchievementsPage = new MyAchievementsPageFactory();
		softAsserter.assertEquals(myAchievementsPage.readPageTitle(), "My Achievements", "My Menu - My Achievements");
		myAchievementsPage.clickMyChallenges();
		
		//My Challenges
		MyChallengesPageFactory myChallengesPage = new MyChallengesPageFactory();
		softAsserter.assertEquals(myChallengesPage.readPageTitle(), "My Challenges", "My Menu - My Challenges");
		myChallengesPage.clickMyGoals();
		
		//My Goals
		MyGoalsPageFactory myGoalsPage = new MyGoalsPageFactory();
		softAsserter.assertEquals(myGoalsPage.readPageTitle(), "My Goals", "My Menu - My Goals");
		myGoalsPage.clickMyTeamGoals();
		
		//My Team Goals
		MyTeamGoalsPageFactory teamGoalsPage = new MyTeamGoalsPageFactory();
		softAsserter.assertEquals(teamGoalsPage.readPageTitle(), "Team Goals", "My Menu - Team Goals");
		teamGoalsPage.clickBlogs();
		
		//Blogs
		BlogsPageFactory blogsPage = new BlogsPageFactory();
		softAsserter.assertEquals(blogsPage.readPageTitle(), "Blogs", "My Menu - Blogs");
		HomePageFactory hp = new HomePageFactory();
		hp.clickHomeLink();
		
	}
	
	private void assertReportsMenuContent() {
		
		HomePageFactory homePage = new HomePageFactory();
		homePage.clickUnitOverallProgress();
		
		//Unit Overall Progress
		UnitOverallProgressPageFactory unitOverllProgressPage = new UnitOverallProgressPageFactory();
		softAsserter.assertEquals(unitOverllProgressPage.readPageTitle(), "Unit Overall Progress", "Reports - Unit Overall Progress");
		unitOverllProgressPage.clickTeamLoginActivity();
		
		//Team Login Activity
		TeamLoginActivityPageFactory teamLoginPage = new TeamLoginActivityPageFactory();
		softAsserter.assertEquals(teamLoginPage.readPageTitle(), "Team Login Activity", "Reports - Team Login Activity");
		teamLoginPage.clickTeamOverallSleep();
		
		//Team Overall Sleep
		TeamOverallSleepPageFactory teamOverallSleepPage = new TeamOverallSleepPageFactory();
		softAsserter.assertEquals(teamOverallSleepPage.readPageTitle(), "Team Overall Sleep", "Reports - Team Overall Sleep");
		teamOverallSleepPage.clickTeamActivity();
		
		//Team Activity
		TeamActivityPageFactory teamActivityPage = new TeamActivityPageFactory();
		softAsserter.assertEquals(teamActivityPage.readPageTitle(), "Team Activity", "Reports - Team Activity");
		teamActivityPage.clickTeamGoalAchievements();
		
		//Team Goal Achievements
		TeamGoalAchievementsPageFactory teamGoalAchievementsPage = new TeamGoalAchievementsPageFactory();
		softAsserter.assertEquals(teamGoalAchievementsPage.readPageTitle(), "Team Goal Achievements", "Reports - Team Goal Achievements");
		teamGoalAchievementsPage.clickNutrientContent();
		
		//Nutrient Content
		NutrientContentPageFactory nutrientContentPage = new NutrientContentPageFactory();
		softAsserter.assertEquals(nutrientContentPage.readPageTitle(), "Nutrient Content", "Reports - Nutrient Content");
		nutrientContentPage.clickBodyMeasurementChangesLink();
		
		//Body Measurement Changes
		BodyMeasurementChangesPageFactory bodyMeasurementChangePage  = new BodyMeasurementChangesPageFactory();
		softAsserter.assertEquals(bodyMeasurementChangePage.readPageTitle(), "Body Measurement Changes", "Reports - Body Measurement Changes");
		bodyMeasurementChangePage.clickMyActivitiesReport();
		
		//My Activities
		pageFactories.Reports.MyActivities.MyActivitiesPageFactory myActivitiesPage = new pageFactories.Reports.MyActivities.MyActivitiesPageFactory();
		softAsserter.assertEquals(myActivitiesPage.readPageTitle(), "My Activities", "Reports - My Activities");
		myActivitiesPage.clickMySleepReport();
		
		//My Sleep
		MySleepPageFactory mySleepPage = new MySleepPageFactory();
		softAsserter.assertEquals(mySleepPage.readPageTitle(), "My Sleep", "Reports - My Sleep");
		mySleepPage.clickGoalHistoryReport();
		
		//Goal History
		GoalHistoryPageFactory goalHistoryPage = new GoalHistoryPageFactory();
		softAsserter.assertEquals(goalHistoryPage.readPageTitle(), "Goal History", "Reports - Goal History");
		goalHistoryPage.clickGoalAchievementsReport();
		
		//Goal Achievements
		GoalAchievementsPageFactory goalAchievementsPage = new GoalAchievementsPageFactory();
		softAsserter.assertEquals(goalAchievementsPage.readPageTitle(), "Goal Achievements", "Reports - Goal Achievements");
		goalAchievementsPage.clickCaloriesBurnedIngestedReport();
		
		//Calories Burned/Ingested
		CaloriesBurnedIngestedPageFactory caloriesBurnedIngestedPage = new CaloriesBurnedIngestedPageFactory();
		softAsserter.assertEquals(caloriesBurnedIngestedPage.readPageTitle(), "Calories Burned/Ingested", "Reports - Calories Burned/Ingested");
		caloriesBurnedIngestedPage.clickMyBodyMeasurementsChangesReport();
		
		//My Body Measurement Changes
		MyBodyMeasurementChangesPageFactory myBodyMeasurementChangesPage = new MyBodyMeasurementChangesPageFactory();
		softAsserter.assertEquals(myBodyMeasurementChangesPage.readPageTitle(), "My Body Measurements", "Reports - My Body Measurments");
		myBodyMeasurementChangesPage.clickTeamCurrentSteps();		
		
		//Team Current Steps
		TeamCurrentStepsPageFactory teamcurrentStepsPage = new TeamCurrentStepsPageFactory();
		softAsserter.assertEquals(teamcurrentStepsPage.readPageTitle(), "Team Current Steps", "Reports - Team Current Steps");
		teamcurrentStepsPage.clickHomeLink();

		
	}
	
	private void assertAdminMenuContent() {
		
		HomePageFactory hp = new HomePageFactory();
		
		
//		hp.clickBranchComponent();
//		
//		//Branch Component
//		BranchComponentPageFactory branchComponentPage = new BranchComponentPageFactory();
//		softAsserter.assertEquals(branchComponentPage.readPageTitle(), "Branch Components", "Admin - Branch Components");
//		branchComponentPage.clickBranchOfService();
//		
//		//Branch of Service
//		BranchOfServicePageFactory branchOfServicePage = new BranchOfServicePageFactory();
//		softAsserter.assertEquals(branchOfServicePage.readPageTitle(), "Branch of Service", "Admin - Branch of Service");
//		branchOfServicePage.clickBodyMeasurementType();
//		
//		//Body Measurement Type
//		BodyMeasurementTypePageFactory bodyMeasurementTypePage = new BodyMeasurementTypePageFactory();
//		softAsserter.assertEquals(bodyMeasurementTypePage.readPageTitle(), "Body Measurement Type", "Admin - Body Measurement Type");
//		bodyMeasurementTypePage.clickGoals();
//		
//		//Goals
//		GoalsPageFactory goalsPage = new GoalsPageFactory();
//		softAsserter.assertEquals(goalsPage.readPageTitle(), "Goals", "Admin - Goals");
//		goalsPage.clickNotificationType();
//		
//		//Notification Type
//		NotificationTypesPageFactory notificationTypesPage = new NotificationTypesPageFactory();
//		softAsserter.assertEquals(notificationTypesPage.readPageTitle(), "Notification Types", "Admin - Notification Types");
//		notificationTypesPage.clickPFTScores();
//		
//		//PFT Scores
//		PFTScoresPageFactory pftScoresPage = new PFTScoresPageFactory();
//		softAsserter.assertEquals(pftScoresPage.readPageTitle(), "PFT Scores", "Admin - PFT Scores");
//		pftScoresPage.clickRoles();
//		
//		//Roles
//		RolesPageFactory rolesPage = new RolesPageFactory();
//		softAsserter.assertEquals(rolesPage.readPageTitle(), "Roles", "Admin - Roles");
//		rolesPage.clickUnits();
//		
//		//Units
//		UnitsPageFactory unitsPage = new UnitsPageFactory();
//		softAsserter.assertEquals(unitsPage.readPageTitle(), "Units", "Admin - Duty Position");
//		unitsPage.clickDutyPosition();
//		
//		//Duty Position
//		DutyPositionPageFactory dutyPositionPage = new DutyPositionPageFactory();
//		softAsserter.assertEquals(dutyPositionPage.readPageTitle(), "Duty Position", "Admin - Duty Position");
//		dutyPositionPage.clickGradeRank();
//		
//		//Grade/Rank
//		GradeRankPageFactory gradeRankPage = new GradeRankPageFactory();
//		softAsserter.assertEquals(gradeRankPage.readPageTitle(), "Grade/Rank", "Admin - Grade/Rank");
//		gradeRankPage.clickResetPassword();
//		
//		//Reset Password
//		ResetPasswordPageFactory resetPasswordPage = new ResetPasswordPageFactory();
//		softAsserter.assertEquals(resetPasswordPage.readPageTitle(), "Reset Password", "Admin - Reset Password");
//		resetPasswordPage.clickBodyMeasurementsSurvey();
//		
//		//Body Measurements Survey
//		BodyMeasurementsSurveyPageFactory bodyMeasurementsSurveyPage = new BodyMeasurementsSurveyPageFactory();
//		softAsserter.assertEquals(bodyMeasurementsSurveyPage.readPageTitle(), "Body Measurements Surveys", "Admin - Body Measurements Surveys");
//		bodyMeasurementsSurveyPage.clickActivity();
		
		//Activities > Activity
		hp.clickActivity();
		
		
		
		ActivitiesPageFactory activitiesPage = new ActivitiesPageFactory();
		softAsserter.assertEquals(activitiesPage.readPageTitle(), "Activities", "Admin - Activities");
		activitiesPage.clickActivityCategories();
		
		//Activities > Activity Categories
		ActivityCategoryPageFactory activityCategoryPage = new ActivityCategoryPageFactory();
		softAsserter.assertEquals(activityCategoryPage.readPageTitle(), "Activity Category", "Admin - Activity Category");
		activityCategoryPage.clickActivitySources();
		
		//Activities > Activity Sources
		ActivitySourcesPageFactory activitySourcesPage = new ActivitySourcesPageFactory();
		softAsserter.assertEquals(activitySourcesPage.readPageTitle(), "Activity Sources", "Admin - Activity Sources");
		activitySourcesPage.clickIntensity();
		
		//Activities > Intensity
		IntensityPageFactory intensityPage = new IntensityPageFactory();
		softAsserter.assertEquals(intensityPage.readPageTitle(), "Intensity", "Admin - Intensity");
		intensityPage.clickMood();
		
		//Activities > Mood
		MoodPageFactory moodPage = new MoodPageFactory();
		softAsserter.assertEquals(moodPage.readPageTitle(), "Mood", "Admin - Mood");
		moodPage.clickArticlesSubMenu();
		
		//Articles & Blogs > Articles
		ArticlesPageFactory articlesPage = new ArticlesPageFactory();
		softAsserter.assertEquals(articlesPage.readPageTitle(), "Articles", "Admin - Articles");
		articlesPage.clickArticleTypesSubMenu();
		
		//Articles & Blogs > Article Types
		ArticleTypesPageFactory articleTypesPage = new ArticleTypesPageFactory();
		softAsserter.assertEquals(articleTypesPage.readPageTitle(), "Article Types", "Admin - Article Types");
		articleTypesPage.clickBlogsSubMenu();
		
		//Articles & Blogs > Blogs
		pageFactories.Admin.ArticlesAndBlogs.Blogs.BlogsPageFactory blogsPage = new pageFactories.Admin.ArticlesAndBlogs.Blogs.BlogsPageFactory();
		softAsserter.assertEquals(blogsPage.readPageTitle(), "Admin Blog Listing", "Admin - Blogs");
		blogsPage.clickFoodsSubMenu();
		
		//Food Intake > Foods
		FoodsPageFactory foodsPage = new FoodsPageFactory();
		softAsserter.assertEquals(foodsPage.readPageTitle(), "Foods", "Admin - Foods");
		foodsPage.clickMealTypeSubMenu();
		
		//Food Intake > Meal Types
		MealTypePageFactory mealTypesPage = new MealTypePageFactory();
		softAsserter.assertEquals(mealTypesPage.readPageTitle(), "Meal Types", "Admin - Meal Types");
		mealTypesPage.clickLocationSubMenu();
		
		//Progress Map > Location
		LocationsPageFactory locationsPage = new LocationsPageFactory();
		


		




		



		

		
		




		








		
	}
	
	
	
	
	
	/**
	 * Method to obtain the Admin Role users
	 * 
	 * @return String[]
	 */
	@DataProvider
	private String[] adminRoles() {

		ExcelDataConfig usersFile = getExcelFile("UsersData.xlsx",
				"UserAccounts");

		List<String> adminUserNames = new ArrayList<String>();

		// Sting[] to store the different types of Admin Roles
		String[] userRoleTypes = {"Admin"};

		// Get the row count for the data file
		int rowCount = usersFile.getRowCount();

		// Loop through each different roles outlined above.
		for (String currentRoleType : userRoleTypes) {

			// For each user type, loop through the data set until we find the
			// FIRST account in which the TYPE matches Admin Type
			for (int i = 1; i <= rowCount; i++) {

				String currentUserNameInDatasheet = usersFile.getData(i,
						"Role");

				if (currentRoleType.equals(currentUserNameInDatasheet)) {
					adminUserNames.add(usersFile.getData(i, "UserName"));
					break;
				}
			}
		}

		String[] returnArray = adminUserNames.stream().toArray(String[]::new);
		return returnArray;
	}
	
	
	
	

}
