package pageFactories.MyMenu.MyProfile;

import pageFactories.IndexBase;

public class ProfilePageFactory extends IndexBase{
	
	public static String regexURL = BASE_URL + "MyProfiles.*";
	/**
	 * Page Constructor: Accepts the WebDriver from the calling page &
	 * instantiates the elements on the page.
	 */
	public ProfilePageFactory() {
		super(regexURL);
	}
	


}
