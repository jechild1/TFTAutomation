package pageFactories;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import configuration.TFTConfig;
import utilities.AutomationHelper;

/**
 * Page factory for the Device Registration for the Garmin Connect site<br>
 * 
 * (1) Finds a reference to objects on the page <br>
 * (2) Defines methods to interact with objects on the page.<br>
 * 
 * @author jesse.childress
 *
 */
public class GarminConnectPageFactory extends TFTConfig {
	/**
	 * Page Constructor: Accepts the WebDriver from the calling page & instantiates
	 * the elements on the page.
	 */
	public GarminConnectPageFactory() {
		PageFactory.initElements(driver, this);
	}

	/*
	 * OBTAIN A REFERENCE TO OBJECTS ON THE GARMIN CONNECT PAGE.
	 */

	/**
	 * Obtains a reference to the Authorize button
	 */
	@FindBy(id = "auth-app")
	WebElement authorizeButton;

	/**
	 * Obtains a reference to the No not Authorize button
	 */
	@FindBy(id = "cancel")
	WebElement doNotAuthorizeButton;

	/**
	 * Obtain a reference to the Email text field.
	 */
	@FindBy(id = "username")
	WebElement email;

	/**
	 * Obtain a reference to the Password text field.
	 */
	@FindBy(id = "password")
	WebElement password;

	/**
	 * Obtains a reference to the Sign In button.
	 */
	@FindBy(id = "login-btn-signin")
	WebElement signInButton;

	@FindBy(id = "login-remember-checkbox")
	WebElement rememberMeCheckbox;

	@FindBy(id = "status")
	WebElement errorStatus;

	@FindBy(id = "login-form-username-errors")
	WebElement emailError;

	@FindBy(id = "login-form-password-errors")
	WebElement passwordError;

	@FindBy(id = "auth-app-gdpr")
	WebElement iConsentButton;

	/*
	 * METHODS TO INTERACT WITH OBJECTS
	 */

	/**
	 * Clicks the Authorize button
	 */
	public void clickAuthorize() {
		Reporter.log("Clicking the Authroize button.", true);
		authorizeButton.click();
		Reporter.log("Authroize button clicked. ", true);
		Reporter.log("", true);
		AutomationHelper.wait(2);
	}

	/**
	 * Clicks the Do not Authorize button
	 */
	public void clickDoNotAuthorize() {
		Reporter.log("Clicking the Do not Authroize button.", true);
		doNotAuthorizeButton.click();
		Reporter.log("Do not Authroize button clicked. ", true);
		Reporter.log("", true);
		AutomationHelper.wait(2);
	}

	/**
	 * Clicks the Sign In button
	 */
	public void clickSignIn() {
		Reporter.log("Clicking the Sign In button.", true);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", signInButton);
		AutomationHelper.wait(1);

		signInButton.click();
		Reporter.log("Sign In button clicked. ", true);
		Reporter.log("", true);
		AutomationHelper.waitForPageToLoad(NORMAL_TIMEOUT);
	}

	/**
	 * Clears any text out of the email field.
	 */
	public void clearEmail() {
		AutomationHelper.printMethodName();
		email.clear();
	}

	/**
	 * Sets the Email field with the passed in value.
	 * 
	 * @param email
	 */
	public void setEmail(String email) {
		Reporter.log("Setting the email field to " + email, true);

		this.email.sendKeys(email);

		Reporter.log("Email field set", true);
		Reporter.log("", true);
	}

	/**
	 * Clears any text out of the password field.
	 */
	public void clearPassword() {
		AutomationHelper.printMethodName();
		password.clear();
	}

	/**
	 * Sets the Password field with the passed in value.
	 * 
	 * @param password
	 */
	public void setPassword(String password) {
		Reporter.log("Setting the Password field to " + password, true);

		this.password.sendKeys(password);

		Reporter.log("Password field set", true);
		Reporter.log("", true);
	}

	/**
	 * Sets the Remember Me checkbox with the passed in desired status. If it is
	 * already set to the desired status, it will not modify it.
	 * 
	 * @param desiredStatus
	 */
	public void setRememberMeCheckbox(boolean desiredStatus) {
		Reporter.log("Remember Me Set", true);
		// Get the current status
		boolean currentStatus = rememberMeCheckbox.isSelected();
		// ^ is exclusive OR.. It's only false when they have different values.
		if (desiredStatus ^ currentStatus) {
			rememberMeCheckbox.click();
		}
	}

	/**
	 * Switches to an iframe object that contains the fields needed for interaction
	 * on the Garmin Connect page
	 */
	public void switchToSignInIframe() {
		driver.switchTo().frame("gauth-widget-frame-gauth-component");
	}

	/**
	 * Checks for the presence of an error on the Garmin Connect site.
	 * 
	 * @return boolean
	 */
	public boolean isErrorStatusPresent() {
		boolean found = false;
		// This is in a try catch because the HTML does not render it until it's
		// present.
		try {
			if (!errorStatus.getAttribute("style").equals("display: none;")) {
				found = true;
			}
		} catch (org.openqa.selenium.NoSuchElementException exception) {

		}
		return found;
	}

	/**
	 * Checks for the presence of an Email Error on the Garmin Connect page
	 * 
	 * @return boolean
	 */
	public boolean isEmailErrorPresent() {
		boolean found = false;

		try {
			if (!emailError.getAttribute("style").equals("display: none;")) {
				found = true;
			}
		} catch (org.openqa.selenium.NoSuchElementException exception) {

		}
		return found;
	}

	/**
	 * Checks for the presence of a password error on teh Garmin Connect page.
	 * 
	 * @return boolean
	 */
	public boolean isPasswordErrorPresent() {
		boolean found = false;
		try {

			if (!passwordError.getAttribute("style").equals("display: none;")) {
				found = true;
			}
		} catch (org.openqa.selenium.NoSuchElementException exception) {

		}
		return found;
	}

	/**
	 * Clicks the I Consent button on the Garmin Connect page.
	 */
	public void clickIConsent() {
		Reporter.log("Clicking I Consent button", true);
		iConsentButton.click();
		AutomationHelper.waitForPageToLoad(NORMAL_TIMEOUT);
	}

}
