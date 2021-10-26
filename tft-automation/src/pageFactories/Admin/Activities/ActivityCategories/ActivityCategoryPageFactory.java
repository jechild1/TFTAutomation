package pageFactories.Admin.Activities.ActivityCategories;

import pageFactories.IndexBase;

public class ActivityCategoryPageFactory extends IndexBase {
	
	public static String regexURL = BASE_URL + "ActivityCategories.*";

	/**
	 * Page Constructor: Accepts the WebDriver from the calling page &
	 * instantiates the elements on the page.
	 */
	public ActivityCategoryPageFactory() {
		super(regexURL);
	}

}
