package pageFactories.Reports.TeamGoalAchievements;

import pageFactories.IndexBase;

public class TeamGoalAchievementsPageFactory extends IndexBase {
	
	public static String regexURL = BASE_URL + "TeamStepGoals.*";
	
	/**
	 * Page Constructor: Accepts the WebDriver from the calling page &
	 * instantiates the elements on the page.
	 */
	public TeamGoalAchievementsPageFactory() {
		super(regexURL);
	}

}
