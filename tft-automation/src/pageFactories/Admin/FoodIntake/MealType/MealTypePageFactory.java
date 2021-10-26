package pageFactories.Admin.FoodIntake.MealType;

import pageFactories.IndexBase;

public class MealTypePageFactory extends IndexBase{
	
	public static String regexURL = BASE_URL + "MealTypes.*";

	/**
	 * Page Constructor: Accepts the WebDriver from the calling page &
	 * instantiates the elements on the page.
	 */
	public MealTypePageFactory() {
		super(regexURL);
	}

}
