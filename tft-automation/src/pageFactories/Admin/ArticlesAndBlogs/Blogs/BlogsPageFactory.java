package pageFactories.Admin.ArticlesAndBlogs.Blogs;

import pageFactories.IndexBase;

public class BlogsPageFactory extends IndexBase{
	
	public static String regexURL = BASE_URL + "Blogs/AdminIndex.*";

	/**
	 * Page Constructor: Accepts the WebDriver from the calling page &
	 * instantiates the elements on the page.
	 */
	public BlogsPageFactory() {
		super(regexURL);
	}

}
