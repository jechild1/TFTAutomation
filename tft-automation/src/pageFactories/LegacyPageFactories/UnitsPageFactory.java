package pageFactories.LegacyPageFactories;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import configuration.TestConfig;
import utilities.AutomationHelper;

/**
 * Page factory for the Units Page in the Team Fitness Tracker application.<br>
 * 
 * (1) Finds a reference to objects on the page <br>
 * (2) Defines methods to interact with objects on the page.<br>
 * 
 * @author jesse.childress
 *
 */
public class UnitsPageFactory extends TestConfig {

	/**
	 * Page Constructor: Accepts the WebDriver from the calling page &
	 * instantiates the elements on the page.
	 */
	public UnitsPageFactory() {
		PageFactory.initElements(driver, this);
	}

	/*
	 * FINDING OBJECTS ON A PAGE - GETTER METHODS
	 */
	
	/**
	 * Obtains a reference to the Add New Unit link.
	 */
	@FindBy (linkText = "Add New Unit")
	WebElement addNewUnitLink;
	
	/**
	 * Obtain a reference to the Units table
	 */
	@FindBy (xpath = "//table[@class = 'table table-striped table-hover table-bordered']")
	WebElement unitsTable;
	
	/*
	 * Methods to interact with objects
	 */
	
	/**
	 * Clicks the Add New Unit link.
	 */
	public void clickAddNewUnitLink(){
		Reporter.log("Clicking Add New Unit link", true);
		addNewUnitLink.click();
		Reporter.log("Add New Unit link clicked", true);
		Reporter.log("", true);
		AutomationHelper.waitSeconds(2);
	}
	
	/**
	 * Returns a reference to the Units Table
	 * @return WebElement unitsTable
	 */
	public WebElement getUnitsTable(){
		return unitsTable;
	}
	
	

}
