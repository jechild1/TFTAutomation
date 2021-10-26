package pageFactories.Reports.TeamLoginActivity;

import pageFactories.IndexBase;

public class TeamLoginActivityPageFactory extends IndexBase {
	
	public static String regexURL = BASE_URL + "TeamLoginActivities.*";
	
	/**
	 * Page Constructor: Accepts the WebDriver from the calling page &
	 * instantiates the elements on the page.
	 */
	public TeamLoginActivityPageFactory() {
		super(regexURL);
	}

}
