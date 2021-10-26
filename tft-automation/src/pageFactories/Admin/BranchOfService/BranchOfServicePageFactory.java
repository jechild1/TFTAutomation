package pageFactories.Admin.BranchOfService;

import pageFactories.IndexBase;

public class BranchOfServicePageFactory extends IndexBase{
	
	public static String regexURL = BASE_URL + "BranchOfServices.*";

	/**
	 * Page Constructor: Accepts the WebDriver from the calling page &
	 * instantiates the elements on the page.
	 */
	public BranchOfServicePageFactory() {
		super(regexURL);
	}

}
