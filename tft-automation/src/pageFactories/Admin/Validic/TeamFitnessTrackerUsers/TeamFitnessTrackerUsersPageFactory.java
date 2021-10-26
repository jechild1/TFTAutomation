package pageFactories.Admin.Validic.TeamFitnessTrackerUsers;

import pageFactories.IndexBase;

public class TeamFitnessTrackerUsersPageFactory extends IndexBase {
	
	public static String regexURL = BASE_URL + "UserProvisionings/UserListByStatus\\?Status\\=all.*";

	/**
	 * Page Constructor: Accepts the WebDriver from the calling page &
	 * instantiates the elements on the page.
	 */
	public TeamFitnessTrackerUsersPageFactory() {
		super(regexURL);
	}

}
