package pageFactories;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import configuration.TFTConfig;
import utilities.AutomationHelper;

/**
 * Page factory for the Login page for Team Fitness Tracker.<br>
 * (1) Finds a reference to objects on the page <br>
 * (2) Defines methods to interact with objects on the page.<br>
 * 
 * @author jesse.childress
 *
 */

public class LoginPageFactory extends TFTConfig {
	/**
	 * Page Constructor: Accepts the WebDriver from the calling page &
	 * instantiates the elements on the page.
	 */
	public LoginPageFactory() {
		PageFactory.initElements(driver, this);
	}

	/*
	 * FINDING OBJECTS ON A PAGER - GETTER METHODS
	 */

	/**
	 * Obtains a reference to the User Name text field.
	 */
	@FindBy(id = "UserName")
	WebElement userName;

	/**
	 * Obtains a reference to the Password text field.
	 */
	@FindBy(id = "Password")
	WebElement password;

	/**
	 * Obtains a reference to the Remember Me check box.
	 */
	@FindBy(id = "RememberMe")
	WebElement rememberMe;

	/**
	 * Obtains a reference to the Log in button.
	 */
	@FindBy(xpath = "//input[(@value='Log in')]")
//	@FindBy(id="loginLink")
	WebElement logInButton;

	/**
	 * Obtains a reference to the Register as a new user link.
	 */
	@FindBy(linkText = "Register as a new user")
	WebElement registerAsNewUserLink;

	/*
	 * METHODS TO INTERACT WITH OBJECTS
	 */

	/**
	 * Reads the value of the User Name text field.
	 * 
	 * @return
	 */
	public String readUserName() {
		AutomationHelper.printMethodName();

		String userName = this.userName.getAttribute("value").trim();

		// Write to the logs if we have a value
		if ((userName != null) || (userName != "")) {
			Reporter.log("User Name field has value: " + userName, true);
			Reporter.log("", true);
		}
		return userName;
	}

	/**
	 * Sets the value for the User Name field.
	 * 
	 * @param userName
	 */
	public void setUserName(String userName) {

		Reporter.log("Setting the User Name field", true);

		this.userName.sendKeys(userName);

		Reporter.log("User Name field set to " + userName, true);
		Reporter.log("", true); // New line in logs
	}

	/**
	 * Reads the value of the Password text field.
	 * 
	 * @return
	 */
	public String readPassword() {
		Reporter.log("Password Name Read", true);

		String password = this.password.getAttribute("value").trim();

		// Write to the logs if we have a value
		if ((password != null) || (password != "")) {
			Reporter.log("Password field has value: " + password, true);
			Reporter.log("", true);
		}
		return password;
	}

	/**
	 * Sets the value for the Password field.
	 * 
	 * @param password
	 */
	public void setPassword(String password) {

		Reporter.log("Setting the Password field", true);

		this.password.sendKeys(password);

		Reporter.log("User Password field set to " + password, true);
		Reporter.log("", true); // New line in logs
	}

	/**
	 * Returns the value of the Remember Me check box.
	 * 
	 * @return boolean true if checked; false if not checked.
	 */
	public boolean readRememberMeCheckBox() {
		Reporter.log("Reading the Remember Me check box", true);

		// Get current boolean status of checked or not checked.
		boolean checked = this.rememberMe.isSelected();

		Reporter.log("Remember Me check box is set to: " + checked, true);
		Reporter.log("", true);

		return checked;
	}

	/**
	 * Sets the Remember Me check box with the desired status as passed in by
	 * the user.
	 * 
	 * @param desiredStatus
	 */
	public void setRememberMeCheckBox(boolean desiredStatus) {

		Reporter.log("Setting the Remember Me check box", true);

		// Get current boolean status of checked or not checked.
		boolean checked = this.rememberMe.isSelected();

		if ((desiredStatus == true) && (checked == false)) {
			this.rememberMe.click();
		} else if ((desiredStatus == false) && (checked == true)) {
			this.rememberMe.click();
		}
		// Else leave it alone how it is.
		Reporter.log("Remember Me check box set to desired status", true);
		Reporter.log("", true);
	}

	/**
	 * Clicks the Log in button
	 */
	public void clickLoginButton() {

		Reporter.log("Clicking Log in button");
		logInButton.click();
		Reporter.log("Log in button clicked", true);
		Reporter.log("", true);
		AutomationHelper.waitSeconds(2);

	}
	
	/**
	 * Clicks the Register as a new user link.
	 */
	public void clickRegisterAsANewUserLink() {

		Reporter.log("Clicking Register as a new user link");
		registerAsNewUserLink.click();
		Reporter.log("Register as a new user link clicked", true);
		Reporter.log("", true);
		AutomationHelper.waitSeconds(2);

	}

}
