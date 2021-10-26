package pageFactories.Reports.CaloriesBurnedIngested;

import pageFactories.IndexBase;

public class CaloriesBurnedIngestedPageFactory extends IndexBase {
	
	public static String regexURL = BASE_URL + "MyCalories.*";
	
	/**
	 * Page Constructor: Accepts the WebDriver from the calling page &
	 * instantiates the elements on the page.
	 */
	public CaloriesBurnedIngestedPageFactory() {
		super(regexURL);
	}

}
