package pageFactories.MyMenu.MyBodyMeasurements;

import pageFactories.IndexBase;

public class BodyMeasurementsPageFactory extends IndexBase{
	
	public static String regexURL = BASE_URL + "BodyMeasurements.*";

	/**
	 * Page Constructor: Accepts the WebDriver from the calling page &
	 * instantiates the elements on the page.
	 */
	public BodyMeasurementsPageFactory() {
		super(regexURL);
	}	

}
