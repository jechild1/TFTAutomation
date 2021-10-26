package pageFactories;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import configuration.TFTConfig;
import utilities.AutomationHelper;

/**
 * Page factory for the Device Registration Page in the Team Fitness Tracker
 * application.<br>
 * 
 * (1) Finds a reference to objects on the page <br>
 * (2) Defines methods to interact with objects on the page.<br>
 * 
 * @author jesse.childress
 *
 */
public class DeviceRegistrationPageFactory extends TFTConfig {

	/**
	 * Page Constructor: Accepts the WebDriver from the calling page &
	 * instantiates the elements on the page.
	 */
	public DeviceRegistrationPageFactory() {
		PageFactory.initElements(driver, this);
	}

	/*
	 * FINDING OBJECTS ON A PAGE - GETTER METHODS
	 */
	
	@FindBy (xpath = "//td[contains(text(),'Fitbit')]/parent::tr//a")
	WebElement fitbitRegisterLink;
	
	@FindBy (xpath = "//td[contains(text(),'Garmin Connect')]/parent::tr//a")
	WebElement garminConnectRegisterLink;
	
	@FindBy (xpath = "//div/h2")
	WebElement pageHeader;
	
	@FindBy (xpath = "//td[contains(text(),'Fitbit')]/parent::tr//span")
	WebElement fitbitRegisteredNotRegisteredButton;
	
	@FindBy (xpath = "//td[contains(text(),'Garmin Connect')]/parent::tr//span")
	WebElement garminConnectRegisteredNotRegisteredButton;
	
	/**
	 * Clicks the Register link for Fitbit
	 */
	public void clickFitbitRegisterLink() {
		fitbitRegisterLink.click();
		AutomationHelper.waitForPageToLoad(NORMAL_TIMEOUT);
	}
	
	/**
	 * Clicks the Deregister link for Fitbit
	 */
	public void clickFitbitDeregister() {
		fitbitRegisterLink.click();
		AutomationHelper.waitForPageToLoad(NORMAL_TIMEOUT);

	}
	
	/**
	 * Clicks the Register link for Garmin Connect
	 */
	public void clickGarminRegisterLink() {
		garminConnectRegisterLink.click();
		AutomationHelper.waitForPageToLoad(NORMAL_TIMEOUT);

	}
	
	/**
	 * Clicks the Deregister link for Garmin Connect
	 */
	public void clickGarminDeregister() {
		garminConnectRegisterLink.click();
		AutomationHelper.waitForPageToLoad(NORMAL_TIMEOUT);

	}
	
	/**
	 * Reads the text of the page header.
	 * @return String
	 */
	public String readPageHeader() {
		return pageHeader.getText();
	}
	
	/**
	 * Reads the Fitbit Registered / Not Registered "button" text
	 * @return String
	 */
	public String readFitbitRegisteredStatus() {
		return fitbitRegisteredNotRegisteredButton.getText();
	}
	
	/**
	 * Reads the Garmin Connect Registered / Not Registered "button" text
	 * @return String
	 */
	public String readGarminConnectRegisteredStatus() {
		return garminConnectRegisteredNotRegisteredButton.getText();
	}
	

	/**
	 * Clicks the Fitbit Registration link.
	 */
	public void clickRegisterForFitbit() {
		AutomationHelper.printMethodName();
		fitbitRegisterLink.click();
		AutomationHelper.waitForPageToLoad(NORMAL_TIMEOUT);
	}
	
	/**
	 * Clicks the Garmin Connect Registration link.
	 */
	public void clickRegisterForGarminConnect() {
		AutomationHelper.printMethodName();
		garminConnectRegisterLink.click();
		AutomationHelper.waitForPageToLoad(NORMAL_TIMEOUT);
	}
	
	/**
	 * Clicks the Fitbit Deregister link.
	 */
	public void clickDeregisterForFitbit() {
		AutomationHelper.printMethodName();
		fitbitRegisterLink.click();
		AutomationHelper.waitForPageToLoad(NORMAL_TIMEOUT);
	}
	
	/**
	 * Clicks the Garmin Connect Deregister link.
	 */
	public void clickDeregisterForGarminConnect() {
		AutomationHelper.printMethodName();
		garminConnectRegisterLink.click();
		AutomationHelper.waitForPageToLoad(NORMAL_TIMEOUT);
	}



	
}
