package pageFactories.Admin.PFTScores;

import pageFactories.IndexBase;

public class PFTScoresPageFactory extends IndexBase{
	
	public static String regexURL = BASE_URL + "PFTScores.*";

	/**
	 * Page Constructor: Accepts the WebDriver from the calling page &
	 * instantiates the elements on the page.
	 */
	public PFTScoresPageFactory() {
		super(regexURL);
	}

}
