package pageFactories;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import configuration.TFTConfig;
import utilities.AutomationHelper;

public class NotificationDetailsPageFactory extends TFTConfig {

	/**
	 * Page Constructor: Accepts the WebDriver from the calling page & instantiates
	 * the elements on the page.
	 */
	public NotificationDetailsPageFactory() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//dd[1]")
	WebElement notificationTypeText;
	
	@FindBy(xpath = "//dd[2]")
	WebElement subjectText;
	
	@FindBy(xpath = "//dd[3]")
	WebElement messageText;
	
	@FindBy(xpath = "//dd[5]")
	WebElement sentByText;
	
	@FindBy(xpath = "//dd[6]")
	WebElement dateSentText;

	@FindBy(linkText = "Back to Notification List")
	WebElement backToNotificationListLink;
	
	/**
	 * Reads the value of the Notification Type text field.
	 * 
	 * @return String
	 */
	public String readNotificationTypeText() {
		return notificationTypeText.getText();
	}
	
	/**
	 * Reads the value of the Subject text field.
	 * 
	 * @return String
	 */
	public String readSubjectText() {
		return subjectText.getText();
	}
	
	/**
	 * Reads the value of the Message text field.
	 * 
	 * @return String
	 */
	public String readMessageText() {
		return messageText.getText();
	}
	
	/**
	 * Reads the value of the Sent By text field.
	 * 
	 * @return String
	 */
	public String readSentByText() {
		return sentByText.getText();
	}
	
	/**
	 * Reads the value of the Date Sent text field.
	 * 
	 * @return String
	 */
	public String readDateSentText() {
		return dateSentText.getText();
	}


	/**
	 * Clicks the Back to Notification List link.
	 */
	public void clickBackToNotificationListLink() {
		backToNotificationListLink.click();
		AutomationHelper.waitForPageToLoad(NORMAL_TIMEOUT);
	}

}
