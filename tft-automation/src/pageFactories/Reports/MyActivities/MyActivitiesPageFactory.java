package pageFactories.Reports.MyActivities;

import pageFactories.IndexBase;

public class MyActivitiesPageFactory extends IndexBase {
	
	public static String regexURL = BASE_URL + "MyActivities.*";
	
	/**
	 * Page Constructor: Accepts the WebDriver from the calling page &
	 * instantiates the elements on the page.
	 */
	public MyActivitiesPageFactory() {
		super(regexURL);
	}

}
