package pageFactories.Admin.Units;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import pageFactories.IndexBase;
import utilities.AutomationHelper;

public class UnitsPageFactory extends IndexBase {

	public static String regexURL = BASE_URL + "Units.*";

	/**
	 * Page Constructor: Accepts the WebDriver from the calling page &
	 * instantiates the elements on the page.
	 */
	public UnitsPageFactory() {
		super(regexURL);
	}
	
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
		AutomationHelper.wait(2);
	}
	
	/**
	 * Returns a reference to the Units Table
	 * @return WebElement unitsTable
	 */
	public WebElement getUnitsTable(){
		return unitsTable;
	}
}
