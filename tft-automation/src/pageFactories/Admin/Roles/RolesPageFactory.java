package pageFactories.Admin.Roles;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import pageFactories.IndexBase;
import utilities.AutomationHelper;

public class RolesPageFactory extends IndexBase {
	
	public static String regexURL = BASE_URL + "Role.*";

	/**
	 * Page Constructor: Accepts the WebDriver from the calling page &
	 * instantiates the elements on the page.
	 */
	public RolesPageFactory() {
		super(regexURL);
	}
	
	/**
	 * Returns a reference to the Add New Role link.
	 */
	@FindBy(linkText = "Add New Role")
	WebElement addNewRoleLink;
	
	/**
	 * Returns a reference to the Roles table.
	 */
	@FindBy(xpath = "//table[@class = 'table table-striped table-hover table-bordered']")
	WebElement rolesTable;
	
	/*
	 * METHODS TO INTERACT WITH OBJECTS
	 */
	
	/**
	 * Clicks the Add New Role link on the Roles page.
	 */
	public void clickAddNewRoleLink(){
		Reporter.log("Clicking Add New Role Link", true);
		addNewRoleLink.click();
		Reporter.log("Add New Role link clicked", true);
		Reporter.log("", true);;
		AutomationHelper.waitSeconds(2);;
	}
	
	/**
	 * Returns a reference to the Roles Table.
	 * @return WebElement rolesTable
	 */
	public WebElement getRolesTable(){
		return rolesTable;
	}

}
