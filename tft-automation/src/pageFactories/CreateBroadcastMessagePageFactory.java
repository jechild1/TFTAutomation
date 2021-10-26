package pageFactories;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import configuration.TFTConfig;
import utilities.AutomationHelper;

/**
 * @author jesse.childress
 *
 */
public class CreateBroadcastMessagePageFactory extends TFTConfig {

	/**
	 * Page Constructor: Accepts the WebDriver from the calling page &
	 * instantiates the elements on the page.
	 */
	public CreateBroadcastMessagePageFactory() {
		PageFactory.initElements(driver, this);
	}

	/*
	 * FINDING OBJECTS
	 */
	@FindBy(id = "NotificationSubject")
	WebElement subjectTextField;

	@FindBy(id = "NotificationMessage")
	WebElement messageTextArea;

	@FindBy(id = "SelectedTeamRecipient")
	WebElement sendTeamNotificationsDropdown;

	@FindBy(id = "SelectedRecipients")
	WebElement sendMemberNotificationsListbox;

	@FindBy(xpath = "//input[@value= 'Send']")
	WebElement sendButton;

	@FindBy(linkText = "Back to Notification List")
	WebElement backToNotificationListLink;

	/*
	 * INTERACTING WITH OBJECTS
	 */

	/**
	 * Sets the Subject text field with the passed in value.
	 * 
	 * @param valueToSet
	 */
	public void setSubjectTextField(String valueToSet) {
		AutomationHelper.printMethodName();
		AutomationHelper.setTextField(subjectTextField, valueToSet);
	}

	/**
	 * Sets the Message text area with the passed in value.
	 * 
	 * @param valueToSet
	 */
	public void setMessage(String valueToSet) {
		AutomationHelper.printMethodName();
		AutomationHelper.setTextField(messageTextArea, valueToSet);
	}

	/**
	 * Selects a value from the Send Team Notifications drop down.
	 * 
	 * @param teamToSelect
	 */
	public void selectTeamNotifications(String teamToSelect) {
		AutomationHelper.printMethodName();
		AutomationHelper.selectDropdownItem(sendTeamNotificationsDropdown,
				teamToSelect);
	}

	/**
	 * Selects a group of users from the Send Member Notifications list box,
	 * corresponding with the passed in items in the String[].
	 * 
	 * @param membersToSelect
	 */
	public void selectMemberNotifications(String[] membersToSelect) {
		AutomationHelper.selectListBoxItems(sendMemberNotificationsListbox,
				membersToSelect);
	}

	/**
	 * Clicks the Send button.
	 */
	public void clickSend() {
		AutomationHelper.printMethodName();
		sendButton.click();
		AutomationHelper.waitForPageToLoad(NORMAL_TIMEOUT);
	}

	/**
	 * Clicks the Back to Notification List link.
	 */
	public void clickBackToNotificationListLink() {
		AutomationHelper.printMethodName();
		backToNotificationListLink.click();
		AutomationHelper.waitForPageToLoad(NORMAL_TIMEOUT);

	}

}
