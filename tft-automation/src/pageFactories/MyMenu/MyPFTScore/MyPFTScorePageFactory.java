package pageFactories.MyMenu.MyPFTScore;

import pageFactories.IndexBase;

public class MyPFTScorePageFactory extends IndexBase{

	public static String regexURL = BASE_URL + "PFT.*";
	
	/**
	 * Page Constructor: Accepts the WebDriver from the calling page &
	 * instantiates the elements on the page.
	 */
	public MyPFTScorePageFactory() {
		super(regexURL);
	}
	

}
