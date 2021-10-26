package pageFactories.Admin.FoodIntake.Foods;

import pageFactories.IndexBase;

public class FoodsPageFactory extends IndexBase{
	
	public static String regexURL = BASE_URL + "Food.*";

	/**
	 * Page Constructor: Accepts the WebDriver from the calling page &
	 * instantiates the elements on the page.
	 */
	public FoodsPageFactory() {
		super(regexURL);
	}

}
