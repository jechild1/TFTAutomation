package pageFactories.Admin.DutyPosition;

import pageFactories.IndexBase;

public class DutyPositionPageFactory extends IndexBase {
	
	public static String regexURL = BASE_URL + "DutyPositions.*";

	/**
	 * Page Constructor: Accepts the WebDriver from the calling page &
	 * instantiates the elements on the page.
	 */
	public DutyPositionPageFactory() {
		super(regexURL);
	}

}
