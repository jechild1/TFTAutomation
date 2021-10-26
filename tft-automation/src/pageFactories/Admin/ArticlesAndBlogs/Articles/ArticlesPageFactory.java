package pageFactories.Admin.ArticlesAndBlogs.Articles;

import pageFactories.IndexBase;

public class ArticlesPageFactory extends IndexBase{
	
	public static String regexURL = BASE_URL + "Articles.*";

	/**
	 * Page Constructor: Accepts the WebDriver from the calling page &
	 * instantiates the elements on the page.
	 */
	public ArticlesPageFactory() {
		super(regexURL);
	}

}
