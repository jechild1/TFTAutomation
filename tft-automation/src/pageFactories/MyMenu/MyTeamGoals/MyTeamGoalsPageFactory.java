package pageFactories.MyMenu.MyTeamGoals;

import pageFactories.IndexBase;

public class MyTeamGoalsPageFactory extends IndexBase{

	public static String regexURL = BASE_URL + "TeamGoals.*";
	
	/**
	 * Page Constructor: Accepts the WebDriver from the calling page &
	 * instantiates the elements on the page.
	 */
	public MyTeamGoalsPageFactory() {
		super(regexURL);
	}

}
