package pageFactories;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import configuration.TFTConfig;

/**
 * Page factory for the Manage page for Team Fitness Tracker.<br>
 * (1) Finds a reference to objects on the page <br>
 * (2) Defines methods to interact with objects on the page.<br>
 * 
 * @author jesse.childress
 *
 */

public class ManagePageFactory extends TFTConfig{

	/**
	 * Page Constructor: Accepts the WebDriver from the calling page &
	 * instantiates the elements on the page.
	 */
	public ManagePageFactory() {
		PageFactory.initElements(driver, this);
	}

	/*
	 * FINDING OBJECTS ON A PAGE - GETTER METHODS
	 */
	
	@FindBy (xpath = "//p[@class='text-success']")
	WebElement successMessage;
	
	/**
	 * Reads the value that is currently in the Success Message field.
	 * 
	 * @return String
	 */
	public String readSuccessMessage() {
		Reporter.log("Start Success Message read", true);
	
		String message = this.successMessage.getAttribute("innerText").trim();
	
		// Write to the logs if we have a value
		if ((message != null) || (message != "")) {
			Reporter.log("Success Message field has value: " + message, true);
			Reporter.log("", true);// New line in the logs
		}
		return message;
	}

}
