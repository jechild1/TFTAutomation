package pageFactories.Reports.MyBodyMeasurementChanges;

import pageFactories.IndexBase;

public class MyBodyMeasurementChangesPageFactory extends IndexBase{
	
	public static String regexURL = BASE_URL + "MyBodyMeasurementChanges.*";
	
	/**
	 * Page Constructor: Accepts the WebDriver from the calling page &
	 * instantiates the elements on the page.
	 */
	public MyBodyMeasurementChangesPageFactory() {
		super(regexURL);
	}

}
