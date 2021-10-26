package pageFactories.Reports.NutrientContent;

import pageFactories.IndexBase;

public class NutrientContentPageFactory extends IndexBase {
	
	public static String regexURL = BASE_URL + "NutrientContents.*";
	
	/**
	 * Page Constructor: Accepts the WebDriver from the calling page &
	 * instantiates the elements on the page.
	 */
	public NutrientContentPageFactory() {
		super(regexURL);
	}
	
	
	

}
