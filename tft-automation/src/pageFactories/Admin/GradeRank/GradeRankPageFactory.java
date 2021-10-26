package pageFactories.Admin.GradeRank;

import pageFactories.IndexBase;

public class GradeRankPageFactory extends IndexBase{
	
	public static String regexURL = BASE_URL + "Ranks.*";

	/**
	 * Page Constructor: Accepts the WebDriver from the calling page &
	 * instantiates the elements on the page.
	 */
	public GradeRankPageFactory() {
		super(regexURL);
	}

}
