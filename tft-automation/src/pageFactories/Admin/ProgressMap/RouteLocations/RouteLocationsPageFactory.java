package pageFactories.Admin.ProgressMap.RouteLocations;

import pageFactories.IndexBase;

public class RouteLocationsPageFactory extends IndexBase{
	
	public static String regexURL = BASE_URL + "RouteLocations.*";

	/**
	 * Page Constructor: Accepts the WebDriver from the calling page &
	 * instantiates the elements on the page.
	 */
	public RouteLocationsPageFactory() {
		super(regexURL);
	}

}
