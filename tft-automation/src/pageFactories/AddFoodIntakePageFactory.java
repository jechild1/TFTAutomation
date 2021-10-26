package pageFactories;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import configuration.TFTConfig;
import utilities.AutomationHelper;
import utilities.Tables;

public class AddFoodIntakePageFactory extends TFTConfig {

	/**
	 * Page Constructor: Accepts the WebDriver from the calling page &
	 * instantiates the elements on the page.
	 */
	public AddFoodIntakePageFactory() {
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

	@FindBy(id = "MealTypeId")
	WebElement mealType;

	@FindBy(id = "Servings")
	WebElement servingsConsumed;

	@FindBy(id = "foodName-field")
	WebElement foodName;

	@FindBy(xpath = "//a[contains(text(),'Lookup Nutritional Info')]")
	WebElement lookupNutritionalInfo;

	@FindBy(id = "useManualItem-lookup")
	WebElement useLookupEntry;

	@FindBy(id = "useManualItem-manual")
	WebElement useManualEntry;

	@FindBy(id = "lookupFoodName-field")
	WebElement lookupEntryFoodName;

	@FindBy(id = "lookupServingSize-field")
	WebElement lookupEntryServingSize;

	@FindBy(id = "lookupServingUnit-field")
	WebElement lookupEntryServingUnits;

	@FindBy(id = "lookupCalories-field")
	WebElement lookupEntryCalories;

	@FindBy(id = "ManualFoodItem_ServingSize")
	WebElement manualEntryServingSize;

	@FindBy(id = "ManualFoodItem_ServingUnit")
	WebElement manualEntryServingUnits;

	@FindBy(id = "ManualFoodItem_CaloriesPerServing")
	WebElement manualEntryCalories;

	@FindBy(xpath = "//input[@value='Create']")
	WebElement createButton;

	@FindBy(xpath = "//div[@id='foodLookupModalContent']//table[@class = 'table table-striped table-hover table-bordered']")
	WebElement lookupTable;

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
	 * Reads the value of the Meal Type drop down box.
	 * 
	 * @return String - the currently selected option in the Meal Type field.
	 */
	public String readMealType() {

		AutomationHelper.printMethodName();
		Select mealTypeDropDown = new Select(this.mealType);
		String mealType = mealTypeDropDown.getFirstSelectedOption().getText();
		return mealType;
	}

	/**
	 * Selects a value from the Meal Type drop down, corresponding with the
	 * passed in value.
	 * 
	 * @param mealTYpe
	 */
	public void selectMealType(String mealTYpe) {

		AutomationHelper.printMethodName();
		Select myDropDown = new Select(this.mealType);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(this.mealType));

		myDropDown.selectByVisibleText(mealTYpe);
	}

	/**
	 * Reads the value of the Servings Consumed Field.
	 * 
	 * @return String
	 */
	public String readServingsConsumed() {
		AutomationHelper.printMethodName();
		// return servingsConsumed.getText();
		return servingsConsumed.getAttribute("value");
	}

	/**
	 * Sets the Servings Consumed field with the passed in value.
	 * 
	 * @param servingsConsumed
	 *            - d.d format
	 */
	public void setServingsConsumed(String servings) {
		AutomationHelper.printMethodName();
		servingsConsumed.clear();
		servingsConsumed.sendKeys(servings);
	}

	/**
	 * Reads the value of the Food Name Field.
	 * 
	 * @return String
	 */
	public String readFoodName() {
		AutomationHelper.printMethodName();
		return foodName.getAttribute("value");
	}

	/**
	 * Sets the Food Name field with the passed in value.
	 * 
	 * @param foodName
	 */
	public void setFoodName(String foodName) {
		AutomationHelper.printMethodName();
		this.foodName.clear();
		this.foodName.sendKeys(foodName);
	}

	/**
	 * Clicks the Lookup Nutritional Info button
	 */
	public void clickLookupNutritionalInfo() {
		AutomationHelper.printMethodName();
		lookupNutritionalInfo.click();
		AutomationHelper.waitForPageToLoad(10);
	}

	/**
	 * Clicks the Use Lookup Entry radio button
	 */
	public void clickUseLookupEntry() {
		AutomationHelper.printMethodName();
		useLookupEntry.click();
	}

	/**
	 * Clicks the Use Manual Entry radio button
	 */
	public void clickUseManualEntry() {
		AutomationHelper.printMethodName();
		useManualEntry.click();
	}

	/**
	 * Reads the value of the Lookup Entry - Food Name Field.
	 * 
	 * @return String
	 */
	public String readLookupEntryFoodName() {
		AutomationHelper.printMethodName();
		return lookupEntryFoodName.getAttribute("value");
	}

	/**
	 * Reads the value of the Lookup Entry - Serving Size Field.
	 * 
	 * @return String
	 */
	public String readLookupEntryServingSize() {
		AutomationHelper.printMethodName();
		return lookupEntryServingSize.getAttribute("value");
	}

	/**
	 * Reads the value of the Lookup Entry - Serving Units Field.
	 * 
	 * @return String
	 */
	public String readLookupEntryServingUnits() {
		AutomationHelper.printMethodName();
		return lookupEntryServingUnits.getAttribute("value");
	}

	/**
	 * Reads the value of the Lookup Entry - Calories Field.
	 * 
	 * @return String
	 */
	public String readLookupEntryCalories() {
		AutomationHelper.printMethodName();
		return lookupEntryCalories.getAttribute("value");
	}

	/**
	 * Reads the value of the Manual Entry - Serving Size Field.
	 * 
	 * @return String
	 */
	public String readManualEntryServingSize() {
		AutomationHelper.printMethodName();
		return manualEntryServingSize.getAttribute("value");
	}

	/**
	 * Sets the Manual Entry - Serving Size field with the passed value.
	 * 
	 * @param servingSize
	 */
	public void setManualEntryServingSize(String servingSize) {
		AutomationHelper.printMethodName();
		this.manualEntryServingSize.clear();
		this.manualEntryServingSize.sendKeys(servingSize);
	}

	/**
	 * Reads the value of the Manual Entry - Serving Units Field.
	 * 
	 * @return String
	 */
	public String readManualEntryServingUnits() {
		AutomationHelper.printMethodName();
		return manualEntryServingUnits.getAttribute("value");
	}

	/**
	 * Sets the Manual Entry - Serving Units field with the passed value.
	 * 
	 * @param servingUnits
	 */
	public void setManualEntryServingUnits(String servingUnits) {
		AutomationHelper.printMethodName();
		this.manualEntryServingUnits.clear();
		this.manualEntryServingUnits.sendKeys(servingUnits);
	}

	/**
	 * Reads the value of the Manual Entry - Calories Field.
	 * 
	 * @return String
	 */
	public String readManualEntryCalories() {
		AutomationHelper.printMethodName();
		return manualEntryCalories.getAttribute("value");
	}

	/**
	 * Sets the Manual Entry - Serving Units field with the passed value.
	 * 
	 * @param calories
	 */
	public void setManualEntryCalories(String calories) {
		AutomationHelper.printMethodName();
		this.manualEntryCalories.clear();
		this.manualEntryCalories.sendKeys(calories);
	}

	/**
	 * Clicks the Create Button
	 */
	public void clickCreate() {
		createButton.click();
		AutomationHelper.waitForPageToLoad(10);
	}

	/**
	 * Returns a reference to the Nutritional Information Table
	 * 
	 * @return Tables
	 */

	public Tables getNutritionalInformatonTable() {
		return new Tables(lookupTable);
	}

}
