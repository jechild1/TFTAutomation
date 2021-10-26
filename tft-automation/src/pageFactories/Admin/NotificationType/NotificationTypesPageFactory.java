package pageFactories.Admin.NotificationType;

import pageFactories.IndexBase;

public class NotificationTypesPageFactory extends IndexBase{
	
	public static String regexURL = BASE_URL + "NotificationTypes.*";

	/**
	 * Page Constructor: Accepts the WebDriver from the calling page &
	 * instantiates the elements on the page.
	 */
	public NotificationTypesPageFactory() {
		super(regexURL);
	}

}
