package pageFactories.Reports.UnitOverallProgress;

import pageFactories.IndexBase;

public class UnitOverallProgressPageFactory extends IndexBase {
	
	public static String regexURL = BASE_URL + "UnitOverall.*";
	
	/**
	 * Page Constructor: Accepts the WebDriver from the calling page &
	 * instantiates the elements on the page.
	 */
	public UnitOverallProgressPageFactory() {
		super(regexURL);
	}

}
