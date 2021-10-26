package pageFactories.MyMenu.MyActivities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageFactories.IndexBase;
import utilities.Tables;

public class MyActivitiesPageFactory extends IndexBase{
	
	private static String regexURL = BASE_URL + "UserActivities.*";
	
	/**
	 * Page Constructor: Instantiates super class with URL provided
	 */
	public MyActivitiesPageFactory() {
		
		super(regexURL);
	}

	@FindBy(linkText = "Create New Activity")
	WebElement createNewActivityLink;

	@FindBy(xpath = "//table[@class = 'table table-striped table-hover table-bordered']")
	WebElement activityLogTable;

	/**
	 * Clicks the Create New Activity link
	 */
	public void clickCreateNewActivity() {
		createNewActivityLink.click();
	}

	/**
	 * Returns a reference to the My Activity Log Table
	 * 
	 * @return Tables
	 */
	public Tables getMyActivityLogTable() {
		return new Tables(activityLogTable);
	}

}
