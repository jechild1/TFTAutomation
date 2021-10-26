package pageFactories.Admin.ResetPassword;

import pageFactories.IndexBase;

public class ResetPasswordPageFactory extends IndexBase{
	
	public static String regexURL = BASE_URL + "ResetPasswordByAdmin.*";

	/**
	 * Page Constructor: Accepts the WebDriver from the calling page &
	 * instantiates the elements on the page.
	 */
	public ResetPasswordPageFactory() {
		super(regexURL);
	}

}
