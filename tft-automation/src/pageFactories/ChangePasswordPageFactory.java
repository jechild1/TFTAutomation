package pageFactories;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import configuration.TFTConfig;
import utilities.AutomationHelper;

/**
 * Page factory for the Change Password page for Team Fitness Tracker.<br>
 * (1) Finds a reference to objects on the page <br>
 * (2) Defines methods to interact with objects on the page.<br>
 * 
 * @author jesse.childress
 *
 */

public class ChangePasswordPageFactory extends TFTConfig {
	
	/**
	 * Page Constructor: Accepts the WebDriver from the calling page &
	 * instantiates the elements on the page.
	 */
	public ChangePasswordPageFactory() {
		PageFactory.initElements(driver, this);
	}

	/*
	 * FINDING OBJECTS ON A Page - GETTER METHODS
	 */
	
	/**
	 * Obtains a reference to the Current Password field.
	 */
	@FindBy (id = "OldPassword")
	WebElement currentPassword;
	
	/**
	 * Obtains a reference to the New password field.
	 */
	@FindBy (id = "NewPassword")
	WebElement newPassword;
	
	/**
	 * Obtains a reference to the Confirm password field.
	 */
	@FindBy (id = "ConfirmPassword")
	WebElement confirmPassword;
	
	/**
	 * Obtains a reference to the Change password button.
	 */
	@FindBy (xpath = "//input[@value='Change password']")
	WebElement changePassword;
	
	/*
	 * METHODS TO INTERACT WITH OBJECTS
	 */
	
	/**
	 * Reads the value that is currently in the Current Password field.
	 * 
	 * @return String
	 */
	public String readCurrentPassword() {
		Reporter.log("Start Current Password read", true);

		String currentPassword = this.currentPassword.getAttribute("value").trim();

		// Write to the logs if we have a value
		if ((currentPassword != null) || (currentPassword != "")) {
			Reporter.log("Current Password field has value: " + currentPassword, true);
			Reporter.log("", true);// New line in the logs
		}
		return currentPassword;
	}

	/**
	 * Sets the Current Password with the passed in text.
	 * 
	 * @param currentPassword
	 */
	public void setCurrentPassword(String currentPassword) {
		Reporter.log("Setting the Current Password field", true);

		this.currentPassword.sendKeys(currentPassword);

		Reporter.log("Current Password field set to" + currentPassword, true);
		Reporter.log("", true); // New line in logs
	}

	/**
	 * Clears the Current Password field
	 */
	public void clearCurrentPassword() {
		Reporter.log("Clearing the Current Password field", true);

		this.currentPassword.clear();

		Reporter.log("Current Password field cleared", true);
		Reporter.log("", true); // New line in logs
	}
	
	/**
	 * Reads the value that is currently in the New Password field.
	 * 
	 * @return String
	 */
	public String readNewPassword() {
		Reporter.log("Start New Password read", true);

		String newPassword = this.newPassword.getAttribute("value").trim();

		// Write to the logs if we have a value
		if ((newPassword != null) || (newPassword != "")) {
			Reporter.log("New Password field has value: " + newPassword, true);
			Reporter.log("", true);// New line in the logs
		}
		return newPassword;
	}

	/**
	 * Sets the New Password with the passed in text.
	 * 
	 * @param newPassword
	 */
	public void setNewPassword(String newPassword) {
		Reporter.log("Setting the New Password field", true);

		this.newPassword.sendKeys(newPassword);

		Reporter.log("New Password field set to" + newPassword, true);
		Reporter.log("", true); // New line in logs
	}

	/**
	 * Clears the New Password field
	 */
	public void clearNewPassword() {
		Reporter.log("Clearing the New Password field", true);

		this.newPassword.clear();

		Reporter.log("New Password field cleared", true);
		Reporter.log("", true); // New line in logs
	}
	
	/**
	 * Reads the value that is currently in the Confirm Password field.
	 * 
	 * @return String
	 */
	public String readConfirmPassword() {
		Reporter.log("Start Confirm Password read", true);

		String confirmPassword = this.confirmPassword.getAttribute("value").trim();

		// Write to the logs if we have a value
		if ((confirmPassword != null) || (confirmPassword != "")) {
			Reporter.log("Confirm Password field has value: " + confirmPassword, true);
			Reporter.log("", true);// New line in the logs
		}
		return confirmPassword;
	}

	/**
	 * Sets the Confirm Password with the passed in text.
	 * 
	 * @param confirmPassword
	 */
	public void setConfirmPassword(String confirmPassword) {
		Reporter.log("Setting the Confirm Password field", true);

		this.confirmPassword.sendKeys(confirmPassword);

		Reporter.log("Confirm Password field set to" + confirmPassword, true);
		Reporter.log("", true); // New line in logs
	}

	/**
	 * Clears the Confirm Password field
	 */
	public void clearConfirmPassword() {
		Reporter.log("Clearing the Confirm Password field", true);

		this.confirmPassword.clear();

		Reporter.log("Confirm Password field cleared", true);
		Reporter.log("", true); // New line in logs
	}
	
	/**
	 * Clicks the Change password button
	 */
	public void clickChangePassword() {
		Reporter.log("Clicking Change password");
		changePassword.click();
		Reporter.log("Change Password button clicked", true);
		Reporter.log("", true);
		AutomationHelper.wait(2);
	}
	
	/**
	 * Checks for the presence of an error message on the page.
	 * 
	 * @param errorMessage
	 * @return boolean true if found; false if not found.
	 */
	public boolean isErrorMessagePresent(String errorMessage) {

		Reporter.log("Beginning Error Message Check for is field present.", true);

		boolean errorFound = false;

		// Create a list of error message elements.
		List<WebElement> errorMessages = driver
				.findElements(By.xpath("//div[@class='validation-summary-errors text-danger']//ul//li"));

		if (errorMessages.size() > 0) {

			for (WebElement currentMessage : errorMessages) {
				if (errorMessage.equals(currentMessage.getAttribute("innerText").trim())) {
					errorFound = true;
					Reporter.log("Error message " + currentMessage.getAttribute("innerText").trim() + " was present.", true);
					Reporter.log("", true);
					break;
				}
			}
		}
		return errorFound;
	}
	
	
	
	

}
