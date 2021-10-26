package pageFactories.Admin.Activities.Mood;

import pageFactories.IndexBase;

public class MoodPageFactory extends IndexBase{
	
	public static String regexURL = BASE_URL + "Moods.*";

	/**
	 * Page Constructor: Accepts the WebDriver from the calling page &
	 * instantiates the elements on the page.
	 */
	public MoodPageFactory() {
		super(regexURL);
	}

}
