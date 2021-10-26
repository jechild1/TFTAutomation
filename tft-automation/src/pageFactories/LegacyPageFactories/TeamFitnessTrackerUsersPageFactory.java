package pageFactories.LegacyPageFactories;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import configuration.TestConfig;

/**
 * Page factory for the Team Fitness Tracker Users Page in the Team Fitness
 * Tracker application.<br>
 * 
 * (1) Finds a reference to objects on the page <br>
 * (2) Defines methods to interact with objects on the page.<br>
 * 
 * @author jesse.childress
 *
 */
public class TeamFitnessTrackerUsersPageFactory extends TestConfig {

	/**
	 * Page Constructor: Accepts the WebDriver from the calling page &
	 * instantiates the elements on the page.
	 */
	public TeamFitnessTrackerUsersPageFactory() {
		PageFactory.initElements(driver, this);
	}

	/*
	 * OBTAIN A REFERENCE TO OBJECTS ON THE PAGE
	 */

	/**
	 * Obtains a reference to the All radio button
	 */
	@FindBy(id = "optionsAll")
	WebElement allRadioButton;

	/**
	 * Obtains a reference to the Active radio button
	 */
	@FindBy(id = "optionsActive")
	WebElement activeRadioButton;

	/**
	 * Obtains a reference to the Inactive radio button
	 */
	@FindBy(id = "optionsInactive")
	WebElement inactiveRadioButton;

	/**
	 * Obtains a reference to the Provisioned radio button
	 */
	@FindBy(id = "optionsProvisioned")
	WebElement provisionedRadioButton;

	/**
	 * Obtains a reference to the Suspended radio button
	 */
	@FindBy(id = "optionsSuspended")
	WebElement suspendedRadioButton;

	/**
	 * Obtains a reference to the Team Fitness Tracker Users table.
	 */
	@FindBy(xpath = "//table[@class = 'table table-striped table-hover table-bordered'")
	WebElement usersTable;

	/*
	 * INTERACTING WITH OBJECTS ON THE PAGE
	 */

	/**
	 * Clicks the All radio button.
	 */
	public void clickAllRadioButton() {
		Reporter.log("Clicking All radio button", true);
		allRadioButton.click();
		Reporter.log("All radio button clicked", true);
		Reporter.log("", true);
	}

	/**
	 * Clicks the Active radio button.
	 */
	public void clickActiveRadioButton() {
		Reporter.log("Clicking Active radio button", true);
		activeRadioButton.click();
		Reporter.log("Active radio button clicked", true);
		Reporter.log("", true);
	}

	/**
	 * Clicks the Inactive radio button.
	 */
	public void clickInactiveRadioButton() {
		Reporter.log("Clicking Inactive radio button", true);
		inactiveRadioButton.click();
		Reporter.log("Inactive radio button clicked", true);
		Reporter.log("", true);
	}

	/**
	 * Clicks the Provisioned radio button.
	 */
	public void clickProvisionedRadioButton() {
		Reporter.log("Clicking Provisioned radio button", true);
		provisionedRadioButton.click();
		Reporter.log("Provisioned radio button clicked", true);
		Reporter.log("", true);
	}

	/**
	 * Clicks the Suspended radio button.
	 */
	public void clickSuspendedRadioButton() {
		Reporter.log("Clicking Suspended radio button", true);
		suspendedRadioButton.click();
		Reporter.log("Suspended radio button clicked", true);
		Reporter.log("", true);
	}

	/**
	 * Returns a reference to the Team Fitness Tracker Users table.
	 * 
	 * @return TFT Users Table
	 */
	public WebElement getTeamFitnessTrackerUsersTable() {
		return usersTable;
	}

}
