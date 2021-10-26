package pageFactories.Reports.TeamOverallSleep;

import pageFactories.IndexBase;

public class TeamOverallSleepPageFactory extends IndexBase{
	
	public static String regexURL = BASE_URL + "TeamOverallSleeps.*";
	
	/**
	 * Page Constructor: Accepts the WebDriver from the calling page &
	 * instantiates the elements on the page.
	 */
	public TeamOverallSleepPageFactory() {
		super(regexURL);
	}

}
