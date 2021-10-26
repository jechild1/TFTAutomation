package pageFactories.Reports.TeamCurrentSteps;

import pageFactories.IndexBase;

public class TeamCurrentStepsPageFactory extends IndexBase{
	
	public static String regexURL = BASE_URL + "TeamCurrentSteps.*";
	
	/**
	 * Page Constructor: Accepts the WebDriver from the calling page &
	 * instantiates the elements on the page.
	 */
	public TeamCurrentStepsPageFactory() {
		super(regexURL);
	}
	
	

}
