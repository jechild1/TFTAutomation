package pageFactories.MyMenu.MyChallenges;

import pageFactories.IndexBase;

public class MyChallengesPageFactory extends IndexBase{
	
	public static String regexURL = BASE_URL + "Challenges.*";

	/**
	 * Page Constructor: Accepts the WebDriver from the calling page &
	 * instantiates the elements on the page.
	 */
	public MyChallengesPageFactory() {
		super(regexURL);
	}
	

}
