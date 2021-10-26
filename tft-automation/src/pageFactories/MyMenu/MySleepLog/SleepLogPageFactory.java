package pageFactories.MyMenu.MySleepLog;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageFactories.IndexBase;
import utilities.AutomationHelper;
import utilities.Tables;

public class SleepLogPageFactory extends IndexBase {
	
	public static String regexURL = BASE_URL + "UserSleep";

	/**
	 * Page Constructor: Accepts the WebDriver from the calling page &
	 * instantiates the elements on the page.
	 */
	public SleepLogPageFactory() {
		super(regexURL);
	}

	@FindBy(xpath = "//table[@class='table table-striped table-hover table-bordered']")
	WebElement sleepLogTable;

	@FindBy(xpath = "//button[contains(text(),'Search')]")
	WebElement searchButton;

	@FindBy(linkText = "Create New Sleep Entry")
	WebElement createNewSleepEntryLink;

	/**
	 * Returns a reference to the Sleep Log Table.
	 * 
	 * @return Tables
	 */
	public Tables getSleepLogTable() {
		return new Tables(sleepLogTable);
	}

	/**
	 * Clicks the search button.
	 */
	public void clickSearchButton() {
		searchButton.click();
		AutomationHelper.waitForPageToLoad(NORMAL_TIMEOUT);
	}

	/**
	 * Clicks teh Create New Sleep Entry link.
	 */
	public void clickCreateNewSleepEntry() {
		createNewSleepEntryLink.click();
		AutomationHelper.waitForPageToLoad(NORMAL_TIMEOUT);
	}

}
