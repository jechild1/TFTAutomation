package pageFactories.Admin.TeamsAndUsers.Users;

import pageFactories.IndexBase;

public class UsersPageFactory extends IndexBase{
	
	public static String regexURL = BASE_URL + "AppUsers.*";

	/**
	 * Page Constructor: Accepts the WebDriver from the calling page &
	 * instantiates the elements on the page.
	 */
	public UsersPageFactory() {
		super(regexURL);
	}

}
