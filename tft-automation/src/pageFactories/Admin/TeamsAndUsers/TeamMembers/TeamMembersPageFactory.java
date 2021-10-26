package pageFactories.Admin.TeamsAndUsers.TeamMembers;

import pageFactories.IndexBase;

public class TeamMembersPageFactory extends IndexBase {
	
	public static String regexURL = BASE_URL + "UserTeams.*";

	/**
	 * Page Constructor: Accepts the WebDriver from the calling page &
	 * instantiates the elements on the page.
	 */
	public TeamMembersPageFactory() {
		super(regexURL);
	}
	
	

}
