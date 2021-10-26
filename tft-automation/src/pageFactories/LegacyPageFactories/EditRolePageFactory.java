package pageFactories.LegacyPageFactories;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import configuration.TestConfig;
import utilities.AutomationHelper;

/**
 * Page factory for the Edit Role Page in the Team Fitness Tracker
 * application.<br>
 * 
 * (1) Finds a reference to objects on the page <br>
 * (2) Defines methods to interact with objects on the page.<br>
 * 
 * @author jesse.childress
 *
 */
public class EditRolePageFactory extends TestConfig {

	/**
	 * Page Constructor: Accepts the WebDriver from the calling page &
	 * instantiates the elements on the page.
	 */
	public EditRolePageFactory() {
		PageFactory.initElements(driver, this);
	}

	/*
	 * FINDING OBJECTS ON THE PAGE
	 */

	/**
	 * Obtains a reference to the Name field.
	 */
	@FindBy (id = "Name")
	WebElement name;
	
	/**
	 * Obtains a reference to the Save button.
	 */
	@FindBy(xpath = "//input[@value='Save']")
	WebElement save;
	
	/**
	 * Obtains a reference to the Back to Role List link
	 */
	@FindBy(linkText = "Back to Role List")
	WebElement backToRoleListLink;

	/*
	 * METHODS TO INTERACT WITH OBJECTS
	 */
	
	/**
	 * Reads the value currently in the Name field.
	 * @return String
	 */
	public String readName(){
		Reporter.log("Start Name read", true);

		String name = this.name.getAttribute("value").trim();

		// Write to the logs if we have a value
		if ((name != null) || (name != "")) {
			Reporter.log("Name field has value: " + name, true);
			Reporter.log("", true);
		}
		return name;
	}
	
	/**
	 * Sets the Name field with the passed in value.
	 * @param name
	 */
	public void setName(String name){
		Reporter.log("Setting the Name field to" + name, true);

		this.name.sendKeys(name);

		Reporter.log("Name field set", true);
		Reporter.log("", true); // New line in logs
	}
	
	/**
	 * Clears the Name field
	 */
	public void clearName() {
		Reporter.log("Clearing the Name field", true);

		this.name.clear();

		Reporter.log("Name field cleared", true);
		Reporter.log("", true); // New line in logs
	}
	
	/**
	 * Clicks the Save button
	 */
	public void clickSave() {
		Reporter.log("Clicking Save");
		save.click();
		Reporter.log("Save button clicked", true);
		Reporter.log("", true);
		AutomationHelper.wait(2);
	}


	/**
	 * Clicks the Back to Role List link on the Edit Role page.
	 */
	public void clickAddNewRoleLink() {
		Reporter.log("Clicking Back to Role List Link", true);
		backToRoleListLink.click();
		Reporter.log("Back to Role List link clicked", true);
		Reporter.log("", true);
		;
		AutomationHelper.wait(2);
		;
	}

}
