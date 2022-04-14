package pageFactories.LegacyPageFactories;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

import configuration.TestConfig;
import utilities.AutomationHelper;

/**
 * Page factory for the Create Team Page in the Team Fitness Tracker
 * application.<br>
 * 
 * (1) Finds a reference to objects on the page <br>
 * (2) Defines methods to interact with objects on the page.<br>
 * 
 * @author jesse.childress
 *
 */
public class CreateTeamPageFactory extends TestConfig {

	/**
	 * Page Constructor: Accepts the WebDriver from the calling page &
	 * instantiates the elements on the page.
	 */
	public CreateTeamPageFactory() {
		PageFactory.initElements(driver, this);
	}

	/*
	 * FINDING OBJECTS ON A PAGE - GETTER METHODS
	 */

	/**
	 * Obtains a reference to the Team Name text field.
	 */
	@FindBy(id = "TeamName")
	WebElement teamName;

	/**
	 * Obtains a reference to the Unit Name drop down.
	 */
	@FindBy(id = "UnitId")
	WebElement unitName;

	/**
	 * Returns a reference to the Active checkbox.
	 */
	@FindBy(id = "ActiveFlag")
	WebElement activeCheckbox;

	/**
	 * Creates a reference to the Create button.
	 */
	@FindBy(xpath = "//input[@value='Create']")
	WebElement createButton;

	/**
	 * Obtains a reference to the Back to Team List Link.
	 */
	@FindBy(linkText = "Back to Team List")
	WebElement backToTeamListLink;

	/*
	 * INTERACT WITH OBJECTS ON PAGE
	 */

	/**
	 * Reads the value currently in the Team Name field.
	 * @return String
	 */
	public String readTeamName() {
		Reporter.log("Reading the Team Name: ", true);
		String text = teamName.getAttribute("value");
		Reporter.log("Team Name Text is: " + text, true);
		Reporter.log("", true);
		return text;
	}
	
	/**
	 * Sets the Team Name text field with the passed in value.
	 * @param teamName
	 */
	public void setTeamName(String teamName){
		Reporter.log("Setting Team Name: ", true);
		this.teamName.sendKeys(teamName);
		Reporter.log("Team Name set to: " + teamName, true);
		Reporter.log("", true);
	}
	
	/**
	 * Reads the value of the Unit drop down box.
	 * 
	 * @return
	 */
	public String readUnit() {

		Reporter.log("Start Unit read", true);

		Select unitDropDown = new Select(this.unitName);

		String unit = unitDropDown.getFirstSelectedOption().getText();

		// Write to the logs if we have a value
		if ((unit != "") || (unit != null)) {
			Reporter.log("Unit field has value: " + unit, true);
			Reporter.log("", true); // New line in logs
		}
		return unit;
	}

	/**
	 * Selects a value from the Unit drop down, corresponding with the passed in
	 * value.
	 * 
	 * @param unit
	 */
	public void selectUnit(String unit) {

		Reporter.log("Setting the Unit drop down", true);

		Select myDropDown = new Select(this.unitName);
		myDropDown.selectByVisibleText(unit);

		Reporter.log("Unit drop down set to " + unit, true);
		Reporter.log("", true);
	}
	
	/**
	 * Sets the Active checkbox with the passed in desired status.
	 * If it is already set to the desired status, it will not modify it.
	 * 
	 * @param desiredStatus
	 */
	public void setActive(boolean desiredStatus) {
		Reporter.log("Beginning Active Set", true);
		// Get the current status
		boolean currentStatus = activeCheckbox.isSelected();
		Reporter.log("Active initial value: " + currentStatus, true);
		// ^ is exclusive OR.. It's only false when they have different values.
		if (desiredStatus ^ currentStatus) {
			activeCheckbox.click();
		}
		// Else leave it alone and do nothing
		Reporter.log("Active final value: " + activeCheckbox.isSelected(), true);
		Reporter.log("", true);
	}

	/**
	 * Returns the value of the Active checkbox.
	 * @return boolean true if selected; false if not selected.
	 */
	public boolean readActive() {
		Reporter.log("Beginning Active Read", true);
		boolean termsValue = activeCheckbox.isSelected();
		Reporter.log("Active value is: " + termsValue, true);
		Reporter.log("", true);
		return termsValue;
	}
	
	/**
	 * Clicks the Create button
	 */
	public void clickCreate(){
		Reporter.log("Clicking Create button. ", true);
		createButton.click();
		Reporter.log("Create button clicked. ", true);
		Reporter.log("", true);
		AutomationHelper.waitSeconds(2);
	}
	
	/**
	 * Clicks the Back to Team List link button
	 */
	public void clickBackToTeamList(){
		Reporter.log("Clicking Back to Team List link. ", true);
		backToTeamListLink.click();
		Reporter.log("Clicked Back to Team List link. ", true);
		Reporter.log("", true);
		AutomationHelper.waitSeconds(2);
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
				.findElements(By.xpath("//span[@class='text-danger field-validation-error']"));

		if (errorMessages.size() > 0) {

			for (WebElement currentMessage : errorMessages) {
				if (errorMessage.equals(currentMessage.getAttribute("innerText").trim())) {
					errorFound = true;
					Reporter.log("Error message was present.", true);
					Reporter.log("", true);
					break;
				}
			}
		}
		return errorFound;
	}
}
