package pageFactories.Reports.GoalAchievements;

import pageFactories.IndexBase;

public class GoalAchievementsPageFactory extends IndexBase {
	
	public static String regexURL = BASE_URL + "GoalAchievements.*";
	
	/**
	 * Page Constructor: Accepts the WebDriver from the calling page &
	 * instantiates the elements on the page.
	 */
	public GoalAchievementsPageFactory() {
		super(regexURL);
	}
	

}
