package pageFactories.Admin.Goals;

import pageFactories.IndexBase;

public class GoalsPageFactory extends IndexBase {
	
	public static String regexURL = BASE_URL + "Goals.*";

	/**
	 * Page Constructor: Accepts the WebDriver from the calling page &
	 * instantiates the elements on the page.
	 */
	public GoalsPageFactory() {
		super(regexURL);
	}

}
