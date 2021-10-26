package pageFactories.Admin.ProgressMap.Location;

import pageFactories.IndexBase;

public class LocationsPageFactory extends IndexBase{
	
	public static String regexURL = BASE_URL + "Locations.*";

	/**
	 * Page Constructor: Accepts the WebDriver from the calling page &
	 * instantiates the elements on the page.
	 */
	public LocationsPageFactory() {
		super(regexURL);
	}

}
