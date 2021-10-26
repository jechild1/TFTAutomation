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
 * Page factory for the Edit Unit Page in the Team Fitness Tracker
 * application.<br>
 * 
 * (1) Finds a reference to objects on the page <br>
 * (2) Defines methods to interact with objects on the page.<br>
 * 
 * @author jesse.childress
 *
 */
public class EditUnitPageFactory extends TestConfig {

	/**
	 * Page Constructor: Accepts the WebDriver from the calling page &
	 * instantiates the elements on the page.
	 */
	public EditUnitPageFactory() {
		PageFactory.initElements(driver, this);
	}

	/*
	 * FINDING OBJECTS ON A PAGE - GETTER METHODS
	 */

	/**
	 * Obtains a reference to the Unit Name text field.
	 */
	@FindBy(id = "UnitName")
	WebElement unitName;
	
	/**
	 * Obtains a reference to the Unit Commander drop down.
	 */
	@FindBy (id="UnitCommanderId")
	WebElement unitCommander;

	/**
	 * Obtains a reference to the Active flag.
	 */
	@FindBy(id = "ActiveFlag")
	WebElement activeCheckbox;

	/**
	 * Obtains a reference to the Save button
	 */
	@FindBy(xpath = "//input[@value = 'Save']")
	WebElement saveButton;

	/**
	 * Obtains a reference to the Back to Unit List link
	 */
	@FindBy(linkText = "Back to Unit List")
	WebElement backToUnitListLink;

	/*
	 * INTERACTING WITH OBJECTS ON THE PAGE
	 */

	/**
	 * Clicks the Save button
	 */
	public void clickSave(){
		Reporter.log("Clicking Save button. ", true);
		saveButton.click();
		Reporter.log("Save button clicked. ", true);
		Reporter.log("", true);
		AutomationHelper.wait(2);
	}

	/**
	 * Clicks the Back to Unit List link button
	 */
	public void clickBackToUnitList(){
		Reporter.log("Clicking Back to Unit List link. ", true);
		backToUnitListLink.click();
		Reporter.log("Clicked Back to Unit List link. ", true);
		Reporter.log("", true);
		AutomationHelper.wait(2);
	}

	/**
	 * Clears text in the Unit Name.
	 */
	public void clearUnitName() {
		Reporter.log("Clearing Unit Name", true);
		unitName.clear();
		Reporter.log("Unit Name Text is cleared", true);
		Reporter.log("", true);
	}

	/**
	 * Reads the text in the Unit Name field.
	 * 
	 * @return String
	 */
	public String readUnitName() {
		Reporter.log("Reading the Unit Name: ", true);
		String text = unitName.getAttribute("value");
		Reporter.log("Unit Name Text is: " + text, true);
		Reporter.log("", true);
		return text;
	}

	/**
	 * Sets the Unit Name field with the passed in Unit Name.
	 * 
	 * @param unitName
	 */
	public void setUnitName(String unitName) {
		Reporter.log("Setting Unit Name: ", true);
		this.unitName.sendKeys(unitName);
		Reporter.log("Unit Name set to: " + unitName, true);
		Reporter.log("", true);
	}
	
	/**
	 * Reads the value of the Unit Commander drop down box.
	 * 
	 * @return
	 */
	public String readUnitCommander() {

		Reporter.log("Start Unit Commander read", true);
		// String unit = this.unit.getAttribute("value").trim();
		Select unitCommanderDropDown = new Select(this.unitCommander);

		String unitCommander = unitCommanderDropDown.getFirstSelectedOption().getText();

		// Write to the logs if we have a value
		if ((unitCommander != "") || (unitCommander != null)) {
			Reporter.log("Unit Commander field has value: " + unitCommander, true);
			Reporter.log("", true); // New line in logs
		}
		return unitCommander;
	}

	/**
	 * Selects a value from the Unit Commander drop down, corresponding with the passed in
	 * value.
	 * 
	 * @param unitCommander
	 */
	public void selectUnitCommander(String unitCommander) {

		Reporter.log("Setting the Unit Commander drop down", true);

		Select myDropDown = new Select(this.unitCommander);
		myDropDown.selectByVisibleText(unitCommander);

		Reporter.log("Unit Commander drop down set to " + unitCommander, true);
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
				.findElements(By.xpath("//span[@class='field-validation-error text-danger']"));

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
