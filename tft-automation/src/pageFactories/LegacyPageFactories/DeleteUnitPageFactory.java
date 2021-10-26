package pageFactories.LegacyPageFactories;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import configuration.TestConfig;
import utilities.AutomationHelper;

/**
 * Page factory for the Delete Unit Page in the Team Fitness Tracker
 * application.<br>
 * 
 * (1) Finds a reference to objects on the page <br>
 * (2) Defines methods to interact with objects on the page.<br>
 * 
 * @author jesse.childress
 */
public class DeleteUnitPageFactory extends TestConfig {

	/**
	 * Page Constructor: Accepts the WebDriver from the calling page &
	 * instantiates the elements on the page.
	 */
	public DeleteUnitPageFactory() {
		PageFactory.initElements(driver, this);
	}

	/*
	 * FINDING OBJECTS ON A PAGE - GETTER METHODS
	 */

	/**
	 * Returns a reference to the unit name label.
	 */
	@FindBy(xpath = "//dl[@class = 'dl-horizontal']//dd[1]")
	WebElement unitName;

	/**
	 * Returns a reference to the unit commander label.
	 */
	@FindBy(xpath = "//dl[@class = 'dl-horizontal']//dd[2]")
	WebElement unitCommander;

	/**
	 * Returns a reference to the active checkbox.
	 */
	@FindBy(id = "ActiveFlag")
	WebElement activeCheckbox;

	/**
	 * Creates a reference to the Delete button.
	 */
	@FindBy(xpath = "//input[@value='Delete']")
	WebElement deleteButton;

	/**
	 * Obtains a reference to the Back to Team List Link.
	 */
	@FindBy(linkText = "Back to Team List")
	WebElement backToTeamListLink;

	/*
	 * INTERACT WITH OBJECTS ON PAGE
	 */

	/**
	 * Clicks the Delete button
	 */
	public void clickDelete() {
		Reporter.log("Clicking Delete button: ", true);
		deleteButton.click();
		Reporter.log("Delete button clicked: ", true);
		Reporter.log("", true);
		AutomationHelper.wait(2);
	}

	/**
	 * Reads the value of the Unit Name field.
	 * 
	 * @return String
	 */
	public String readUnitName() {
		Reporter.log("Starting Unit Name read", true);
		String myText = unitName.getText();
		Reporter.log("Unit Name value is: " + myText, true);
		Reporter.log("", true);

		return myText;
	}

	/**
	 * Reads the value of the Unit Commander field.
	 * 
	 * @return String
	 */
	public String readUnitCommander() {
		Reporter.log("Starting Unit Commander read", true);
		String myText = unitCommander.getText();
		Reporter.log("Unit Commander value is: " + myText, true);
		Reporter.log("", true);

		return myText;
	}

	/**
	 * Reads the value of the active checkbox.
	 */
	public boolean readActiveCheckbox() {
		Reporter.log("Starting checkbox read", true);
		boolean checkedStatus = Boolean.valueOf(activeCheckbox.getAttribute("checked"));
		Reporter.log("Checkbox status is: " + checkedStatus, true);
		Reporter.log("", true);
		return checkedStatus;
	}
}
