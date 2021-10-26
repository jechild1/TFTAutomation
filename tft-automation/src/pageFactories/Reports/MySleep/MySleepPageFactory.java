package pageFactories.Reports.MySleep;

import pageFactories.IndexBase;

public class MySleepPageFactory extends IndexBase {
	
	public static String regexURL = BASE_URL + "MySleeps.*";
	
	/**
	 * Page Constructor: Accepts the WebDriver from the calling page &
	 * instantiates the elements on the page.
	 */
	public MySleepPageFactory() {
		super(regexURL);
	}

}
