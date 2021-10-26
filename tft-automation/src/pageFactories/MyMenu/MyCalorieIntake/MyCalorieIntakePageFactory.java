package pageFactories.MyMenu.MyCalorieIntake;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageFactories.IndexBase;
import utilities.AutomationHelper;
import utilities.Tables;

public class MyCalorieIntakePageFactory extends IndexBase {
	
	private static String regexURL = BASE_URL + "UserCalorieConsumptions.*";
	
	public MyCalorieIntakePageFactory() {
		super(regexURL);
	}

	/**
	 * Obtains a reference to the Add Food Intake link
	 */
	@FindBy(linkText = "Add Food Intake")
	WebElement addFoodIntakeLink;

	/**
	 * Obtains a reference to the Add Water Intake link
	 */
	@FindBy(linkText = "Add Water Intake")
	WebElement addWaterIntakeLink;

	/**
	 * Obtains a reference to the Search by Food Name text box
	 */
	@FindBy(id = "SearchString")
	WebElement searchByFoodNameTextField;

	/**
	 * Obtains a reference to the Search button.
	 */
	@FindBy(xpath = "//button[contains(text(),'Search')]")
	WebElement searchButton;

	/**
	 * Obtains a reference to the My Calorie Intake table
	 */
	@FindBy(xpath = "//table[@class='table table-striped table-hover table-bordered']")
	WebElement myCalorieIntakeTable;

	/**
	 * Clicks the Add Food Intake link
	 */
	public void clickAddFoodIntake() {
		AutomationHelper.printMethodName();
		addFoodIntakeLink.click();
	}

	/**
	 * Clicks the Add Water Intake link
	 */
	public void clickAddWaterIntake() {
		AutomationHelper.printMethodName();
		addWaterIntakeLink.click();
	}

	/**
	 * Sets the Search by Food Name text box with the passed in text.
	 * 
	 * @param searchText
	 */
	public void setSearchByFoodName(String searchText) {
		AutomationHelper.printMethodName();
		searchByFoodNameTextField.clear();
		searchByFoodNameTextField.sendKeys(searchText);
	}

	/**
	 * Reads the Search by Food Name text box value.
	 * 
	 * @return String
	 */
	public String readSearchByFoodName() {
		AutomationHelper.printMethodName();
		return searchByFoodNameTextField.getText();
	}

	/**
	 * Clicks the Search button
	 */
	public void clickSearch() {
		searchButton.click();
	}

	/**
	 * Returns a reference to the My Calorie Intake table
	 * 
	 * @return Tables
	 */
	public Tables getMyCalorieIntakeTable() {
		return new Tables(myCalorieIntakeTable);
	}

}
