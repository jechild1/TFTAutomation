package pageFactories.Admin.ArticlesAndBlogs.ArticleTypes;

import pageFactories.IndexBase;

public class ArticleTypesPageFactory extends IndexBase {
	
	public static String regexURL = BASE_URL + "ArticleTypes.*";

	/**
	 * Page Constructor: Accepts the WebDriver from the calling page &
	 * instantiates the elements on the page.
	 */
	public ArticleTypesPageFactory() {
		super(regexURL);
	}

}
