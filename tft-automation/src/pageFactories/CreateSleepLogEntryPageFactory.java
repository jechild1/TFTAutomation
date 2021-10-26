package pageFactories;

import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import configuration.TFTConfig;
import utilities.AutomationHelper;

public class CreateSleepLogEntryPageFactory extends TFTConfig{
	
	/**
	 * Page Constructor: Accepts the WebDriver from the calling page &
	 * instantiates the elements on the page.
	 */
	public CreateSleepLogEntryPageFactory() {
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * Obtain a reference to the Date Consumed field.
	 */
	@FindBy(id = "timestamp")
	WebElement date;
	
	@FindBy(id = "TotalSleepHours")
	WebElement sleepHours;
	
	@FindBy(id = "TotalSleepMinutes")
	WebElement sleepMinutes;
	
	@FindBy (xpath = "//input[@value='Create']")
	WebElement createButton;
	
	@FindBy (linkText = "Back to List")
	WebElement backToListLink;
	
	
	
	/**
	 * Reads the value of the Date Consumed Field.
	 * 
	 * @return String
	 */
	public String readDate() {
		AutomationHelper.printMethodName();
		return date.getAttribute("value");
	}

	/**
	 * Sets the Date Consumed field with the passed in date.
	 * 
	 * @param date
	 *            - MM/dd/yyyy format
	 */
	public void setdate(String date) {
		AutomationHelper.printMethodName();
		this.date.clear();
		this.date.click();
		AutomationHelper.setCalendarDate(date);
	}
	
	/**
	 * Reads the value of the Sleep Hours Field.
	 * 
	 * @return String
	 */
	public String readSleepHours() {
		AutomationHelper.printMethodName();
		return sleepHours.getAttribute("value");
	}

	/**
	 * Sets the Sleep Hours field with the passed in value.
	 * 
	 * @param sleepHours
	 */
	public void setSleepHours(String sleepHours) {
		AutomationHelper.printMethodName();

		// Try catch necessary because if we try to clear stuff that
		// disabled. This can throw an exception.
		try {
			this.sleepHours.clear();
			this.sleepHours.sendKeys(sleepHours);

		} catch (InvalidElementStateException e) {

		}
	}
	
	/**
	 * Reads the value of the Sleep Minutes Field.
	 * 
	 * @return String
	 */
	public String readSleepMinutes() {
		AutomationHelper.printMethodName();
		return sleepMinutes.getAttribute("value");
	}

	/**
	 * Sets the Sleep Minutes field with the passed in value.
	 * 
	 * @param sleepMinutes
	 */
	public void setSleepMinutes(String sleepMinutes) {
		AutomationHelper.printMethodName();

		// Try catch necessary because if we try to clear stuff that
		// disabled. This can throw an exception.
		try {
			this.sleepMinutes.clear();
			this.sleepMinutes.sendKeys(sleepMinutes);

		} catch (InvalidElementStateException e) {

		}
	}
	
	/**
	 * Clicks the Create button.
	 */
	public void clickCreate() {
		createButton.click();
		AutomationHelper.waitForPageToLoad(NORMAL_TIMEOUT);
	}
	
	/**
	 * Clicks the Back to List link.
	 */
	public void clickBackToList() {
		backToListLink.click();
		AutomationHelper.waitForPageToLoad(NORMAL_TIMEOUT);
	}
	
	

}
