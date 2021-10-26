package pageFactories;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import configuration.TFTConfig;
import utilities.AutomationHelper;
import utilities.Tables;

public class NotificationsPageFactory extends TFTConfig {

	/**
	 * Page Constructor: Accepts the WebDriver from the calling page &
	 * instantiates the elements on the page.
	 */
	public NotificationsPageFactory() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "Create New Message")
	WebElement createNewMessageLink;

	@FindBy(linkText = "Create New Broadcast Message")
	WebElement createNewBroadcastMessageLink;

	@FindBy(xpath = "//table[@class ='table table-striped table-hover table-bordered']")
	WebElement notificationsTable;

	/**
	 * Clicks the Create New Message link.
	 */
	public void clickCreateNewMessageLink() {
		createNewMessageLink.click();
		AutomationHelper.waitForPageToLoad(NORMAL_TIMEOUT);
	}

	/**
	 * Clicks the Create New Broadcast Message link.
	 */
	public void clickCreateNewBroadcastMessageLink() {
		createNewBroadcastMessageLink.click();
		AutomationHelper.waitForPageToLoad(NORMAL_TIMEOUT);
	}

	/**
	 * Returns a reference to the Notifications Table.
	 * 
	 * @return Tables
	 */
	public Tables getNotificationsTable() {
		return new Tables(notificationsTable);
	}

}
