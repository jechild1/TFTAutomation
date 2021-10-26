package pageFactories.Admin.BodyMeasurementType;

import pageFactories.IndexBase;

public class BodyMeasurementTypePageFactory extends IndexBase{
	
	public static String regexURL = BASE_URL + "BodyMeasurementTypes.*";

	/**
	 * Page Constructor: Accepts the WebDriver from the calling page &
	 * instantiates the elements on the page.
	 */
	public BodyMeasurementTypePageFactory() {
		super(regexURL);
	}

}
