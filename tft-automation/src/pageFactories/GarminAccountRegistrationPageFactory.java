package pageFactories;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import configuration.TFTConfig;
import utilities.AutomationHelper;

/**
 * Page factory for Registering a user on the Garmin Connect page. This is a
 * totally separate page from the TFT/Garmin integration. This is the actual
 * Garmin Account Registration site.<br>
 * 
 * (1) Finds a reference to objects on the page <br>
 * (2) Defines methods to interact with objects on the page.<br>
 * 
 * @author jesse.childress
 *
 */
public class GarminAccountRegistrationPageFactory extends TFTConfig {



	/**
	 * Page Constructor: Accepts the WebDriver from the calling page & instantiates
	 * the elements on the page.
	 */
	public GarminAccountRegistrationPageFactory() {
		PageFactory.initElements(driver, this);
	}
	


	/*
	 * OBTAIN REFERENCES TO OBJECTS
	 */

	/**
	 * Obtain a reference to the Create Account link.
	 */
	// @FindBy (id = "lnkCreateAccount")
	@FindBy(linkText = "Create One")
	WebElement createOneLink;

	/**
	 * Obtain a reference to the Full Name text field.
	 */
	@FindBy(id = "name")
	WebElement fullName;

	/**
	 * Obtain a reference to the Email Address text field.
	 */
	@FindBy(id = "email")
	WebElement emailAddress;

	/**
	 * Obtain a reference to the Password text field.
	 */
	@FindBy(id = "password")
	WebElement password;

	/**
	 * Obtain a reference to the Retype Password text field.
	 */
	@FindBy(id = "passwordMatch")
	WebElement retypePassword;

	// TODO - productNews, read agreements, 16 years old
	@FindBy(id = "globalOptIn")
	WebElement productNewsAndPromotionsCheckbox;

	@FindBy(id = "termsOfUse")
	WebElement termsOfUseCheckbox;

	@FindBy(id = "confirmAge")
	WebElement confirmAgeCheckbox;

	/**
	 * Obtain a reference to the Create Account button.
	 */
	@FindBy(id = "submitBtn")
	WebElement createAccountButton;

	/*
	 * METHODS TO INTERACT WITH OBJECTS
	 */

	/**
	 * Clicks the Create One link
	 */
	public void clickCreateOneLink() {
		AutomationHelper.printMethodName();
		Reporter.log("Clicking the Create One link.", true);
		createOneLink.click();

		AutomationHelper.waitSeconds(2);
	}

	/**
	 * Sets the Full Name field with the passed in value.
	 * 
	 * @param fullName
	 */
	public void setFullName(String fullName) {
		AutomationHelper.printMethodName();
		Reporter.log("Setting the Full Name field to " + fullName, true);
		this.fullName.sendKeys(fullName);
	}

	/**
	 * Sets the Email Address field with the passed in value.
	 * 
	 * @param emailAddress
	 */
	public void setEmailAddress(String emailAddress) {
		AutomationHelper.printMethodName();
		Reporter.log("Setting the Email Address field to " + emailAddress, true);
		this.emailAddress.sendKeys(emailAddress);
	}
	


	/**
	 * Sets the Password field with the passed in value.
	 * 
	 * @param password
	 */
	public void setPassword(String password) {
		AutomationHelper.printMethodName();
		Reporter.log("Setting the Password field to " + password, true);
		this.password.sendKeys(password);

	}

	/**
	 * Sets the Retype Password field with the passed in value.
	 * 
	 * @param password
	 */
	public void setRetypePassword(String password) {
		AutomationHelper.printMethodName();
		Reporter.log("Setting the Retype Password field to " + password, true);
		this.retypePassword.sendKeys(password);
	}

	/**
	 * Sets the Product News and Promotions checkbox with the passed in desired
	 * status. If it is already set to the desired status, it will not modify it.
	 * 
	 * @param desiredStatus
	 */
	public void setProductNewsAndPromotionsCheckbox(boolean desiredStatus) {
		Reporter.log("Beginning Get Product news and promotions Set", true);
		// Get the current status
		boolean currentStatus = productNewsAndPromotionsCheckbox.isSelected();
		// ^ is exclusive OR.. It's only false when they have different values.
		if (desiredStatus ^ currentStatus) {
			productNewsAndPromotionsCheckbox.click();
		}
	}
	
	
	/**
	 * Sets the I have read and agree to the Garmin Terms of Use checkbox with the passed in desired
	 * status. If it is already set to the desired status, it will not modify it.
	 * 
	 * @param desiredStatus
	 */
	public void setTermsOfUseCheckbox(boolean desiredStatus) {
		Reporter.log("Beginning Terms Of Use Set", true);
		// Get the current status
		boolean currentStatus = termsOfUseCheckbox.isSelected();
		// ^ is exclusive OR.. It's only false when they have different values.
		if (desiredStatus ^ currentStatus) {
			termsOfUseCheckbox.click();
		}
	}
	
	/**
	 * Sets the Confirm Age checkbox with the passed in desired
	 * status. If it is already set to the desired status, it will not modify it.
	 * 
	 * @param desiredStatus
	 */
	public void setConfirmAgeCheckbox(boolean desiredStatus) {
		Reporter.log("Beginning I Am at least 16 years old Set", true);
		// Get the current status
		boolean currentStatus = confirmAgeCheckbox.isSelected();
		// ^ is exclusive OR.. It's only false when they have different values.
		if (desiredStatus ^ currentStatus) {
			confirmAgeCheckbox.click();
		}
	}

	/**
	 * Clicks the Create Account button
	 */
	public void clickCreateAccountButton() {
		AutomationHelper.printMethodName();
		Reporter.log("Clicking the Create Account button.", true);
		createAccountButton.click();
		AutomationHelper.waitSeconds(2);
	}
}
