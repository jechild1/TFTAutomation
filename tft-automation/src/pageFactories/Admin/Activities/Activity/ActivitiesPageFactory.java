package pageFactories.Admin.Activities.Activity;

import pageFactories.IndexBase;

public class ActivitiesPageFactory extends IndexBase {
	
	public static String regexURL = BASE_URL + "Activities.*";

	/**
	 * Page Constructor: Accepts the WebDriver from the calling page &
	 * instantiates the elements on the page.
	 */
	public ActivitiesPageFactory() {
		super(regexURL);
	}

}
