package pageFactories.MyMenu.MyGoals;

import pageFactories.IndexBase;

public class MyGoalsPageFactory extends IndexBase {
	
	public static String regexURL = BASE_URL + "IndividualGoals.*";

	/**
	 * Page Constructor: Accepts the WebDriver from the calling page &
	 * instantiates the elements on the page.
	 */
	public MyGoalsPageFactory() {
		super(regexURL);
	}

}
