package pageFactories.Admin.BranchComponent;

import pageFactories.IndexBase;

public class BranchComponentPageFactory extends IndexBase {

	public static String regexURL = BASE_URL + "BranchComponents.*";

	/**
	 * Page Constructor: Accepts the WebDriver from the calling page &
	 * instantiates the elements on the page.
	 */
	public BranchComponentPageFactory() {
		super(regexURL);
	}
	
	

}
