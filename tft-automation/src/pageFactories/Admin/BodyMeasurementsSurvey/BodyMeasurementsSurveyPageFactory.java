package pageFactories.Admin.BodyMeasurementsSurvey;

import pageFactories.IndexBase;

public class BodyMeasurementsSurveyPageFactory extends IndexBase{
	
	public static String regexURL = BASE_URL + "BodyStatistics.*";

	/**
	 * Page Constructor: Accepts the WebDriver from the calling page &
	 * instantiates the elements on the page.
	 */
	public BodyMeasurementsSurveyPageFactory() {
		super(regexURL);
	}

}
