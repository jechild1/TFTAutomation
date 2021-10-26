package pageFactories.Reports.BodyMeasurementChanges;

import pageFactories.IndexBase;

public class BodyMeasurementChangesPageFactory extends IndexBase{
	
	public static String regexURL = BASE_URL + "BodyMeasurementChanges.*";
	
	/**
	 * Page Constructor: Accepts the WebDriver from the calling page &
	 * instantiates the elements on the page.
	 */
	public BodyMeasurementChangesPageFactory() {
		super(regexURL);
	}

}
