package pageFactories.MyMenu.MyAchievements;

import pageFactories.IndexBase;

public class MyAchievementsPageFactory extends IndexBase{
	
	public static String regexURL = BASE_URL + "UserBadges.*";
	
	/**
	 * Page Constructor: Accepts the WebDriver from the calling page &
	 * instantiates the elements on the page.
	 */
	public MyAchievementsPageFactory() {
		super(regexURL);
	}

	
	

}
