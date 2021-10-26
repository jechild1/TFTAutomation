package pageFactories.Admin.Activities.ActivitySources;

import pageFactories.IndexBase;

public class ActivitySourcesPageFactory extends IndexBase{
	
	public static String regexURL = BASE_URL + "ActivitySources.*";

	/**
	 * Page Constructor: Accepts the WebDriver from the calling page &
	 * instantiates the elements on the page.
	 */
	public ActivitySourcesPageFactory() {
		super(regexURL);
	}

}
