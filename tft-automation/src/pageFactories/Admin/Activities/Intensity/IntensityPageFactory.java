package pageFactories.Admin.Activities.Intensity;

import pageFactories.IndexBase;

public class IntensityPageFactory extends IndexBase{
	
	public static String regexURL = BASE_URL + "Intensities.*";

	/**
	 * Page Constructor: Accepts the WebDriver from the calling page &
	 * instantiates the elements on the page.
	 */
	public IntensityPageFactory() {
		super(regexURL);
	}

}
