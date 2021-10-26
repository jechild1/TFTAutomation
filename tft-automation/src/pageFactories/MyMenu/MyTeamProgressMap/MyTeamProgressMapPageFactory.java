package pageFactories.MyMenu.MyTeamProgressMap;

import pageFactories.IndexBase;

public class MyTeamProgressMapPageFactory extends IndexBase {
	
	public static String regexURL = BASE_URL + "Progress/Map\\?type\\=t.*";

	/**
	 * Page Constructor: Accepts the WebDriver from the calling page &
	 * instantiates the elements on the page.
	 */
	public MyTeamProgressMapPageFactory() {
		super(regexURL);
	}

}
