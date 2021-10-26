package pageFactories.MyMenu.MyACFTScore;

import pageFactories.IndexBase;

public class MyACFTScorePageFactory extends IndexBase{

	public static String regexURL = BASE_URL + "ACFT.*";
	
	/**
	 * Page Constructor: Accepts the WebDriver from the calling page &
	 * instantiates the elements on the page.
	 */
	public MyACFTScorePageFactory() {
		super(regexURL);
	}

}
