package pageFactories.Admin.ProgressMap.Route;

import pageFactories.IndexBase;

public class RoutesPageFactory extends IndexBase {
	
	public static String regexURL = BASE_URL + "Routes.*";

	/**
	 * Page Constructor: Accepts the WebDriver from the calling page &
	 * instantiates the elements on the page.
	 */
	public RoutesPageFactory() {
		super(regexURL);
	}

}
