package pageFactories.Admin.Validic.DeleteValidicUser;

import pageFactories.IndexBase;

public class DeleteProvisionedUsersPageFactory extends IndexBase {
	
	public static String regexURL = BASE_URL + "UserProvisionings.*";

	/**
	 * Page Constructor: Accepts the WebDriver from the calling page &
	 * instantiates the elements on the page.
	 */
	public DeleteProvisionedUsersPageFactory() {
		super(regexURL);
	}

}
