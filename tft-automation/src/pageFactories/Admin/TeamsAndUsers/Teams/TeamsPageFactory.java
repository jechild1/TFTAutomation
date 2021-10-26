package pageFactories.Admin.TeamsAndUsers.Teams;

import pageFactories.IndexBase;

public class TeamsPageFactory extends IndexBase{
	
	public static String regexURL = BASE_URL + "Teams.*";

	/**
	 * Page Constructor: Accepts the WebDriver from the calling page &
	 * instantiates the elements on the page.
	 */
	public TeamsPageFactory() {
		super(regexURL);
	}

}
