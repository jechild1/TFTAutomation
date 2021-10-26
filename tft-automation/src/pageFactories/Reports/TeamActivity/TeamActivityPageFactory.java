package pageFactories.Reports.TeamActivity;

import pageFactories.IndexBase;

public class TeamActivityPageFactory extends IndexBase {
	
	public static String regexURL = BASE_URL + "TeamActivities.*";
	
	/**
	 * Page Constructor: Accepts the WebDriver from the calling page &
	 * instantiates the elements on the page.
	 */
	public TeamActivityPageFactory() {
		super(regexURL);
	}

}
