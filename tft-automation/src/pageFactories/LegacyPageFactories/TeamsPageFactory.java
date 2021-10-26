package pageFactories.LegacyPageFactories;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import configuration.TestConfig;
import utilities.AutomationHelper;

/**
 * Page factory for the Teams Page in the Team Fitness Tracker application.<br>
 * 
 * (1) Finds a reference to objects on the page <br>
 * (2) Defines methods to interact with objects on the page.<br>
 * 
 * @author jesse.childress
 *
 */
public class TeamsPageFactory extends TestConfig {

	/**
	 * Page Constructor: Accepts the WebDriver from the calling page &
	 * instantiates the elements on the page.
	 */
	public TeamsPageFactory() {
		PageFactory.initElements(driver, this);
	}

	/*
	 * FINDING OBJECTS ON A PAGE - GETTER METHODS
	 */
	/**
	 * Obtains a reference to the Add New Unit Link.
	 */
	@FindBy(linkText = "Add New Team")
	WebElement addNewTeamLink;
	
	/**
	 * Obtains a reference to the Teams table.
	 */
	@FindBy (xpath = "//table[@class = 'table table-striped table-hover table-bordered']")
	WebElement teamsTable;
	
	/*
	 * METHODS TO INTERACT WITH OBJECTS
	 */
	
	/**
	 * Clicks the Add New Team link.
	 */
	public void clickAddNewTeam(){
		Reporter.log("Clicking Add New Team", true);
		addNewTeamLink.click();
		Reporter.log("Add New Team Link clicked", true);
		Reporter.log("", true);
		AutomationHelper.wait(2);
	}
	
	/**
	 * Returns a reference to the Teams Table.
	 * @return WebElement teamsTable
	 */
	public WebElement getTeamsTable(){
		return teamsTable;
	}
	
	
}