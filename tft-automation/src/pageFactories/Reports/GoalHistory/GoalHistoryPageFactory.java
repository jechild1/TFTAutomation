package pageFactories.Reports.GoalHistory;

import pageFactories.IndexBase;

public class GoalHistoryPageFactory extends IndexBase{
	
	public static String regexURL = BASE_URL + "GoalHistories.*";
	
	/**
	 * Page Constructor: Accepts the WebDriver from the calling page &
	 * instantiates the elements on the page.
	 */
	public GoalHistoryPageFactory() {
		super(regexURL);
	}

}
