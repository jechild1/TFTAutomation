package pageFactories.unitTests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import configuration.TFTConfig;
import modularScripts.LoginMod;
import pageFactories.HelpPageFactory;
import pageFactories.HomePageFactory;
import pageFactories.MenusPageFactory;
import utilities.AutomationHelper;

public class HelpPageFactoryTest extends TFTConfig {

	@AfterClass
	public void finishTest() {
		AutomationHelper.finishTest();
	}

	/**
	 * This method takes gets the username/password combo being used for
	 * HelpPageFactory and returns a String[][]
	 * 
	 * @return String[][]
	 */
	@DataProvider(name = "userNamePasswordCombos")
	private String[][] getAccounts() {

		return getUserAndPassDataProviderFromExcel("TFT Unit Members.xlsx",
				"ChildressCalorieCrushers", "echildress");
	}

	@Test(dataProvider = "userNamePasswordCombos")
	public void execute(String userName) {

		LoginMod login = new LoginMod();

		login.execute("jessec");

		AutomationHelper.printMethodName();

		// Navigate to the Activity menu
//		MenusPageFactory menus = new MenusPageFactory();
		HomePageFactory hp = new HomePageFactory();
		hp.clickHelp();

		HelpPageFactory hpf = new HelpPageFactory();

		// System.out.println(hpf.readOverviewOfTeamFitnessTrackerResearchProject());
		//
		// System.out.println(hpf.readWelcomeToTeamFitnessTracker());
		//
		// System.out.println(hpf.readTATRCHelpdesk());
		//
		// System.out.println(hpf.readFitnessTrackers());
		//
		// System.out.println(hpf.readGettingStarted());
		//
		// System.out.println(hpf.readAccounts());
		//
		// System.out.println(hpf.readDevices());
		//
		// System.out.println(hpf.readToRegisterADevice());
		//
		// System.out.println(hpf.readMyMenu());
		//
		// System.out.println(hpf.readMyActivities());
		//
		// System.out.println(hpf.readToViewActivities());
		//
		// System.out.println(hpf.readToCreateANewActivity());
		//
		// System.out.println(hpf.readToEnterWeightLiftingMetrics());
		//
		// System.out.println(hpf.readMyCalorieIntake());
		//
		// System.out.println(hpf.readToViewYourCalorieIntake());
		//
		// System.out.println(hpf.readToCreateNewEntriesIntoYourCalorieIntakeViaLookupNutritionalInfo());
		//
		// System.out.println(hpf.readToCreateNewEntriesIntoYourCalorieIntakeViaManualEntry());
		//
		// System.out.println(hpf.readToEditCalorieConsumption());
		//
		// System.out.println(hpf.readToViewCalorieIntakeDetails());
		//
		// System.out.println(hpf.readToDeleteCalorieIntakeEntries());
		//
		// System.out.println(hpf.readMySleepLog());
		//
		// System.out.println(hpf.readToViewYourSleepLog());
		//
		// System.out.println(hpf.readToCreateALogFileEntry());
		//
		// System.out.println(hpf.readToEditASleepLogEntry());
		//
		// System.out.println(hpf.readToViewDetailsOfAnEntryInYourSleepLog());
		//
		// System.out.println(hpf.readToViewDetailsOfAnEntryInYourSleepLog());
		//
		// System.out.println(hpf.readToDeleteASleepLogEntry());
		//
		// System.out.println(hpf.readMyBodyMeasurements());
		//
		// System.out.println(hpf.readToCreateBodyMeasurements());
		//
		// System.out.println(hpf.readToEditBodyMeasurements());
		//
		// System.out.println(hpf.readToViewBodyMeasurementsDetails());
		//
		// System.out.println(hpf.readToDeleteBodyMeasurements());
		//
		// System.out.println(hpf.readMyPFTScore());
		//
		// System.out.println(hpf.readToViewYourPFTScore());
		//
		// System.out.println(hpf.readToCreateNewActivities());
		//
		// System.out.println(hpf.readMyProgressMap());
		//
		// System.out.println(hpf.readToViewYourProgress());
		//
		// System.out.println(hpf.readViewTheMyTeamProgressMap());
		//
		// System.out.println(hpf.readToViewYourTeamProgressMap());
		//
		// System.out.println(hpf.readMyAchievements());
		//
		// System.out.println(hpf.readMyGoals());
		//
		// System.out.println(hpf.readToSetYourGoals());
		//
		// System.out.println(hpf.readToCreateAGoal());
		//
		// System.out.println(hpf.readToEditAGoal());
		//
		// System.out.println(hpf.readToDeleteAGoal());
		//
		// System.out.println(hpf.readMyTeamGoals());
		//
		// System.out.println(hpf.readToViewYourTeamGoals());
		//
		// System.out.println(hpf.readToCreateATeamGoal());
		//
		// System.out.println(hpf.readToEditATeamGoal());
		//
		// System.out.println(hpf.readToDeleteATeamGoal());
		//
		// System.out.println(hpf.readMyTeamMembership());
		//
		// System.out.println(hpf.readtoSubmitArticlesToTFT());
		//
		// System.out.println(hpf.readHelloMenu());
		//
		// System.out.println(hpf.readProfile());
		//
		// System.out.println(hpf.readToEditYourProfile());
		//
		// System.out.println(hpf.readPRTStatus());
		//
		// System.out.println(hpf.readToEditYourPRTStatus());
		//
		// System.out.println(hpf.readTeamMembership());
		//
		// System.out.println(hpf.readToEditYourTeamMemberships());
		//
		// System.out.println(hpf.readRegisterDevice());
		//
		// System.out.println(hpf.readToRegisterYourdevice());
		//
		// System.out.println(hpf.readPassword());
		//
		// System.out.println(hpf.readToChangeYourPassword());
		//
		// System.out.println(hpf.readForgotPassword());
		//
		// System.out.println(hpf.readHelp());
		//
		// System.out.println(hpf.readLogOff());

		System.out.println(hpf
				.readAppendixAFitnessTrackersCompatibleWithTeamFitnessTracker());

		System.out.println(hpf.readAppendixCPRTDefinitions());

		System.out.println(hpf
				.readAppendixDMetabolicRatesAndOtherCalculationsUsedForFitnessTracking());

		hpf.close();

	}

}
