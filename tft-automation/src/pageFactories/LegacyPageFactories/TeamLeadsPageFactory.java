package pageFactories.LegacyPageFactories;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import configuration.TestConfig;
import utilities.AutomationHelper;

/**
 * Page factory for the Team Leads Page in the Team Fitness Tracker
 * application.<br>
 * 
 * (1) Finds a reference to objects on the page <br>
 * (2) Defines methods to interact with objects on the page.<br>
 * 
 * @author jesse.childress
 *
 */
public class TeamLeadsPageFactory extends TestConfig {
	/**
	 * Page Constructor: Accepts the WebDriver from the calling page &
	 * instantiates the elements on the page.
	 */
	public TeamLeadsPageFactory() {
		PageFactory.initElements(driver, this);
	}
	
	
	/*
	 * OBTAIN A REFERENCE TO OBJECTS ON THE PAGE
	 */
	
	/**
	 * Obtain a reference to the Add a Team Lead link.
	 */
	@FindBy (linkText = "Add a Team Lead")
	WebElement addATeamLeadLink;
	
	/**
	 * Obtains a reference to the Team Leads table.
	 */
	@FindBy (xpath = "//table[@class = 'table table-striped table-hover table-bordered']")
	WebElement teamLeadsTable;
	
	/*
	 * INTERACT WIHT OBJECTS ON THE PAGE
	 */
	
	public void clickAddATeamLeadLink(){
		Reporter.log("Clicking the Add a Team Lead link", true);
		addATeamLeadLink.click();
		Reporter.log("Add a Team Lead link clicked", true);
		Reporter.log("", true);
		AutomationHelper.wait(2);
	}
	
	/**
	 * Returns a reference to the Team Leads table.
	 * @return WebElement - Team Leads table
	 */
	public WebElement getTeamLeadsTable(){
		return teamLeadsTable;
	}


	
	
	
	

}
