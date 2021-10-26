package pageFactories;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import configuration.TFTConfig;
import utilities.AutomationHelper;

public class AddWaterIntakePageFactory extends TFTConfig {

	/**
	 * Page Constructor: Accepts the WebDriver from the calling page &
	 * instantiates the elements on the page.
	 */
	public AddWaterIntakePageFactory() {
		PageFactory.initElements(driver, this);
	}

	/*
	 * Finding obects on a page
	 */

	/**
	 * Obtain a reference to the Date Consumed field.
	 */
	@FindBy(id = "timestamp")
	WebElement dateConsumed;

	@FindBy(id = "Servings")
	WebElement cupsOfWater;
	
	@FindBy(xpath = "//input[@value='Create']")
	WebElement createButton;

	/**
	 * Reads the value of the Date Consumed Field.
	 * 
	 * @return String
	 */
	public String readDateConsumed() {
		AutomationHelper.printMethodName();
		return dateConsumed.getAttribute("value");
	}

	/**
	 * Sets the Date Consumed field with the passed in date.
	 * 
	 * @param date
	 *            - dd/MM/yyyy format
	 */
	public void setDateConsumed(String date) {
		AutomationHelper.printMethodName();
		dateConsumed.clear();
		dateConsumed.click();
		AutomationHelper.setCalendarDate(date);
	}

	/**
	 * Reads the value of the Cups Of Water Field.
	 * 
	 * @return String
	 */
	public String readCupsOfWater() {
		AutomationHelper.printMethodName();
		// return servingsConsumed.getText();
		return cupsOfWater.getAttribute("value");
	}

	/**
	 * Sets the Cups of Water field with the passed in value.
	 * 
	 * @param cupsOfWater
	 */
	public void setCupsOfWater(String cupsOfWater) {
		AutomationHelper.printMethodName();
		this.cupsOfWater.clear();
		this.cupsOfWater.sendKeys(cupsOfWater);
	}

	
	/**
	 * Clicks the Create Button
	 */
	public void clickCreate() {
		createButton.click();
		AutomationHelper.waitForPageToLoad(10);
	}
}
