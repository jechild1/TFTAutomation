package pageFactories.MyMenu.Blogs;

import pageFactories.IndexBase;

public class BlogsPageFactory extends IndexBase {

	public static String regexURL = BASE_URL + "Blogs.*";
	
	/**
	 * Page Constructor: Accepts the WebDriver from the calling page &
	 * instantiates the elements on the page.
	 */
	public BlogsPageFactory() {
		super(regexURL);
	}

}
