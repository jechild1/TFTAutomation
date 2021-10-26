package pageFactories.Admin.TeamsAndUsers.TeamLeads;

import pageFactories.IndexBase;

public class TeamLeadsPageFactory extends IndexBase {
	
	public static String regexURL = BASE_URL + "TeamLeads.*";

	/**
	 * Page Constructor: Accepts the WebDriver from the calling page &
	 * instantiates the elements on the page.
	 */
	public TeamLeadsPageFactory() {
		super(regexURL);
	}

}
