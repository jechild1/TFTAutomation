package pageFactories.MyMenu.MyProgressMap;

import pageFactories.IndexBase;

public class MyProgressMapPageFactory extends IndexBase {
	
	public static String regexURL = BASE_URL + "Progress/Map\\?type\\=m.*";

	/**
	 * Page Constructor: Accepts the WebDriver from the calling page &
	 * instantiates the elements on the page.
	 */
	public MyProgressMapPageFactory() {
		super(regexURL);
	}
	
	

}
