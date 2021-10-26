package pageFactories;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import configuration.TFTConfig;
import utilities.AutomationHelper;

/**
 * Page factory for the Device Registration for the Fitbit site<br>
 * 
 * (1) Finds a reference to objects on the page <br>
 * (2) Defines methods to interact with objects on the page.<br>
 * 
 * @author jesse.childress
 *
 */

public class FitbitRegistrationPageFactory extends TFTConfig {

	/**
	 * Page Constructor: Accepts the WebDriver from the calling page & instantiates
	 * the elements on the page.
	 */
	public FitbitRegistrationPageFactory() {
		PageFactory.initElements(driver, this);
	}

	/**
	 * Obtains a reference to the Email field.
	 */
	@FindBy(name = "email")
	WebElement email;

	/**
	 * Obtains a reference to the Password field
	 */
	@FindBy(name = "password")
	WebElement password;

	/**
	 * Obtains a reference to the Remember Me checkbox.
	 */
	@FindBy(id = "rememberMe")
	WebElement rememberMeCheckbox;

	/**
	 * Obtains a reference to the Login button.
	 */
	@FindBy(xpath = "//div[@class = 'submit']/button")
	WebElement loginButton;

	/**
	 * Obtains a reference to the Continue button.
	 */
	@FindBy(xpath = "//div[@class = 'submit']/button")
	WebElement continueButton;

	/**
	 * Obtains a reference to the free account link.
	 */
	@FindBy(linkText = "free account")
	WebElement freeAccountLink;

	/**
	 * Obtains a reference to the "I agree to Fitbit Terms of Service and Privacy
	 * Policy" checkbox.
	 */
	@FindBy(id = "termsPrivacyConnected")
	WebElement fitbitTermsOfServiceCheckbox;

	/**
	 * Obtains a reference to the "Keep me updated about Fitbit products, news, and
	 * promotions" checkbox.
	 */
	@FindBy(id = "emailSubscribeConnected")
	WebElement keepMeUpdatedCheckbox;

	/**
	 * Obtains a reference to the First Name field.
	 */
	@FindBy(id = "firstName")
	WebElement firstName;

	/**
	 * Obtains a reference to the Last Name field.
	 */
	@FindBy(id = "lastName")
	WebElement lastName;

	/**
	 * Obtains a reference to the Gender drop down
	 */
	@FindBy(id = "gender")
	WebElement genderDropdown;

	/**
	 * Obtains a reference to the Birth Month text field.
	 */
	@FindBy(name = "birthMonth")
	WebElement birthMonth;

	/**
	 * Obtains a reference to the Birth Date text field.
	 */
	@FindBy(name = "birthDayOfMonth")
	WebElement birthDay;

	/**
	 * Obtains a reference to the Birth Year text field.
	 */
	@FindBy(name = "birthYear")
	WebElement birthYear;

	/**
	 * Obtains a reference to the Height Feet text field.
	 */
	@FindBy(id = "heightFeet")
	WebElement heightFeet;

	/**
	 * Obtains a reference to the Height Inches text field.
	 */
	@FindBy(id = "heightInches")
	WebElement heightInches;

	/**
	 * Obtains a reference to the Weight text field.
	 */
	@FindBy(id = "field-weight-lbs")
	WebElement weight;

	/**
	 * Obtains a reference to the Save Profile button
	 */
	@FindBy(id = "complete-profile-submit")
	WebElement saveProfile;

	/**
	 * Obtains a reference to the Allow button.
	 */
	@FindBy(id = "allow-button")
	WebElement allowButton;

	/**
	 * Obtains a reference to the Select All Checkbox on the App Authorization page.
	 */
	@FindBy(id = "selectAllScope")
	WebElement selectAllCheckbox;

	// @FindBy (xpath = "//div[@class='errorMessage']")
	// WebElement validationErrorDiv;

	/**
	 * Sets the Remember Me checkbox with the passed in desired status. If it is
	 * already set to the desired status, it will not modify it.
	 * 
	 * @param desiredStatus
	 */
	public void setRememberMeCheckbox(boolean desiredStatus) {
		AutomationHelper.printMethodName();

		Reporter.log("Beginning Remember Me Set", true);
		// Get the current status
		boolean currentStatus = rememberMeCheckbox.isSelected();
		// ^ is exclusive OR.. It's only false when they have different values.
		if (desiredStatus ^ currentStatus) {
			rememberMeCheckbox.click();
		}
	}

	/**
	 * Sets the Fitbit Terms of Service checkbox with the passed in desired status.
	 * If it is already set to the desired status, it will not modify it.
	 * 
	 * @param desiredStatus
	 */
	public void setFitbitTermsOfServiceCheckbox(boolean desiredStatus) {
		AutomationHelper.printMethodName();

		Reporter.log("Beginning Fitbit Terms of Service Set", true);
		// Get the current status
		boolean currentStatus = fitbitTermsOfServiceCheckbox.isSelected();
		// ^ is exclusive OR.. It's only false when they have different values.
		if (desiredStatus ^ currentStatus) {
			fitbitTermsOfServiceCheckbox.click();
		}
	}

	/**
	 * Sets the Keep Me Updated checkbox with the passed in desired status. If it is
	 * already set to the desired status, it will not modify it.
	 * 
	 * @param desiredStatus
	 */
	public void setKeepMeUpdatedCheckbox(boolean desiredStatus) {
		AutomationHelper.printMethodName();
		Reporter.log("Beginning Keep Me Updated Set", true);
		// Get the current status
		boolean currentStatus = keepMeUpdatedCheckbox.isSelected();
		// ^ is exclusive OR.. It's only false when they have different values.
		if (desiredStatus ^ currentStatus) {
			keepMeUpdatedCheckbox.click();
		}
	}

	/**
	 * Clicks the LOG IN button
	 */
	public void clickLogin() {
		AutomationHelper.printMethodName();
		Reporter.log("Clicking the Login button.", true);
		loginButton.click();
		// AutomationHelper.wait(2);
		AutomationHelper.waitForPageToLoad(NORMAL_TIMEOUT);
	}

	/**
	 * Clicks the Continue button
	 */
	public void clickContinue() {
		AutomationHelper.printMethodName();
		Reporter.log("Clicking the Continue button.", true);
		continueButton.click();
		// AutomationHelper.wait(2);
		AutomationHelper.waitForPageToLoad(NORMAL_TIMEOUT);
	}

	/**
	 * Clicks the free account link
	 */
	public void clickFreeAccountLink() {
		AutomationHelper.printMethodName();
		Reporter.log("Clicking the Free Account link", true);
		freeAccountLink.click();
		// AutomationHelper.wait(2);
		AutomationHelper.waitForPageToLoad(NORMAL_TIMEOUT);
	}

	/**
	 * Clicks the Save Profile button
	 */
	public void clickSaveProfile() {
		AutomationHelper.printMethodName();
		Reporter.log("Clicking the Save Profile button", true);
		saveProfile.click();
		// AutomationHelper.wait(2);
		AutomationHelper.waitForPageToLoad(NORMAL_TIMEOUT);
	}

	/**
	 * Clicks the Allow button
	 */
	public void clickAllow() {
		AutomationHelper.printMethodName();
		Reporter.log("Clicking the Allow button", true);
		allowButton.click();
		AutomationHelper.waitForPageToLoad(NORMAL_TIMEOUT);
	}

	/**
	 * Sets the email field with the passed in value.
	 * 
	 * @param email
	 */
	public void setEmail(String email) {
		AutomationHelper.printMethodName();
		Reporter.log("Setting the email field to " + email, true);
		this.email.click();
		AutomationHelper.wait(3);
		this.email.sendKeys(email);
	}

	/**
	 * Sets the password field with the passed in value.
	 * 
	 * @param password
	 */
	public void setPassword(String password) {
		AutomationHelper.printMethodName();
		Reporter.log("Setting the Password field to " + password, true);
		this.password.sendKeys(password);
	}

	/**
	 * Sets the First Name field with the passed in value.
	 * 
	 * @param firstName
	 */
	public void setFirstName(String firstName) {
		AutomationHelper.printMethodName();
		// Because first name is the first field we set, we must force a pause here to
		// let the javascript update.
		AutomationHelper.wait(3);
		Reporter.log("Setting the First Name field to " + firstName, true);
		this.firstName.sendKeys(firstName);
	}

	/**
	 * Sets the Last Name field with the passed in value.
	 * 
	 * @param lastName
	 */
	public void setLastName(String lastName) {
		AutomationHelper.printMethodName();
		Reporter.log("Setting the Last Name field to " + lastName, true);
		this.lastName.sendKeys(lastName);
	}

	/**
	 * Selects a value from the Gender drop down, corresponding with the passed in
	 * value.
	 * 
	 * @param gender
	 */
	public void selectGender(String gender) {

		/*
		 * Note: The drop down on this form is wrapped in some funny javascript and
		 * doesn't allow interaction as a normal select object. The code below is a hack
		 * to make it work.
		 */

		AutomationHelper.printMethodName();
		Reporter.log("Setting the Gender field to " + gender, true);

		// WebElement form - so that we can do send keys via form.
		WebElement selectDiv = driver.findElement(By.xpath("//div[@class='dropdown-wrapper']"));
		selectDiv.click();

		List<WebElement> linkList = driver.findElements(By.xpath("//ul[@id='gender-menu']//a"));
		for (WebElement x : linkList) {
			if (x.getText().equalsIgnoreCase(gender)) {
				x.click();
				break;
			}
		}

		// NOTE: Previously this code worked. No longer does. Keeping for reference.
		// // If our gender is female, we need to down arrow one time. else, we need
		// // to down arrow two times to get male.
		//
		// if (gender.equalsIgnoreCase("Female")) {
		//
		// formFrame.sendKeys(Keys.TAB); // Tab out of Lastname field.
		// formFrame.sendKeys(Keys.chord(Keys.CONTROL, Keys.ARROW_DOWN));
		// } else {
		// formFrame.sendKeys(Keys.TAB); // Tab out of Lastname field.
		// AutomationHelper.wait(3);
		// formFrame.sendKeys(Keys.chord(Keys.CONTROL, Keys.ARROW_DOWN));
		// formFrame.sendKeys(Keys.chord(Keys.CONTROL, Keys.ARROW_DOWN));
		// }
		// Reporter.log("Gender drop down set to " + gender, true);
		// Reporter.log("", true);
	}

	/**
	 * Sets the Birth - Month field with the passed in value.
	 * 
	 * @param birthMonth
	 */
	public void setBirthMonth(String birthMonth) {
		AutomationHelper.printMethodName();
		Reporter.log("Setting the Birth-Month field to " + birthMonth, true);
		this.birthMonth.sendKeys(birthMonth);
	}

	/**
	 * Sets the Birth - Day field with the passed in value.
	 * 
	 * @param birthDay
	 */
	public void setBirthDay(String birthDay) {
		AutomationHelper.printMethodName();
		Reporter.log("Setting the Birth-Day field to " + birthDay, true);
		this.birthDay.sendKeys(birthDay);
	}

	/**
	 * Sets the Birth - Year field with the passed in value.
	 * 
	 * @param birthYear
	 */
	public void setBirthYear(String birthYear) {
		AutomationHelper.printMethodName();
		Reporter.log("Setting the Birth-Year field to " + birthYear, true);
		this.birthYear.sendKeys(birthYear);
	}

	/**
	 * Sets the Height - Feet field with the passed in value.
	 * 
	 * @param heightFeet
	 */
	public void setHeightFeet(String heightFeet) {
		AutomationHelper.printMethodName();
		Reporter.log("Setting the Height-Feet field to " + heightFeet, true);
		this.heightFeet.sendKeys(heightFeet);
	}

	/**
	 * Sets the Height - Inches field with the passed in value.
	 * 
	 * @param heightInches
	 */
	public void setHeightInches(String heightInches) {
		AutomationHelper.printMethodName();
		Reporter.log("Setting the Height-Inches field to " + heightInches, true);
		this.heightInches.sendKeys(heightInches);
	}

	/**
	 * Sets the Weight field with the passed in weight.
	 * 
	 * @param weight
	 */
	public void setWeight(String weight) {
		AutomationHelper.printMethodName();
		Reporter.log("Setting the Weight field to " + weight, true);
		this.weight.sendKeys(weight);
	}

	/**
	 * Sets the Select All checkbox with the passed in desired status. If it is
	 * already set to the desired status, it will not modify it.
	 * 
	 * @param desiredStatus
	 */
	public void setSelectAllCheckbox(boolean desiredStatus) {
		AutomationHelper.printMethodName();
		// Get the current status
		boolean currentStatus = selectAllCheckbox.isSelected();
		// ^ is exclusive OR.. It's only false when they have different values.
		if (desiredStatus ^ currentStatus) {
			selectAllCheckbox.click();
		}
	}

	/**
	 * Checks for the presence of a validation error.
	 * 
	 * @return boolean
	 */
	public boolean isValidationErrorPresent() {
		WebDriverWait wait = new WebDriverWait(driver, 2);
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//div[@class='errorMessage']"))));
			return true;
		} catch (org.openqa.selenium.TimeoutException e) {
			return false;
		}
	}

}
