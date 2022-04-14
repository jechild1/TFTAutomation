package pageFactories.LegacyPageFactories;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

import configuration.TestConfig;
import utilities.AutomationHelper;

/**
 * Page factory for the Create User Profile page for Team Fitness Tracker.<br>
 * (1) Finds a reference to objects on the page <br>
 * (2) Defines methods to interact with objects on the page.<br>
 * 
 * @author jesse.childress
 *
 */
public class CreateUserProfilePageFactory extends TestConfig {


	/**
	 * Page Constructor: Accepts the WebDriver from the calling page &
	 * instantiates the elements on the page.
	 */
	public CreateUserProfilePageFactory() {
		PageFactory.initElements(driver, this);
	}

	/*
	 * FINDING OBJECTS ON A PAGE - GETTER METHODS
	 */

	/**
	 * Obtains a reference to the Display Name text field.
	 */
	@FindBy(id = "DisplayName")
	WebElement displayName;

	/**
	 * Obtains a reference to the Unit drop down field.
	 */
	@FindBy(id = "UnitId")
	WebElement unit;

	/**
	 * Obtains a reference to the Phone (mobile) text field.
	 */
	@FindBy(id = "cellphone")
	WebElement phoneCell;

	/**
	 * Obtains a reference to the Birth Year text field.
	 */
	@FindBy(id = "birthyear")
	WebElement birthYear;

	/**
	 * Obtains a reference to the Male Gender radio button
	 */
	@FindBy(xpath = "//input[@value = 'M']")
	WebElement maleGenderRadioButton;

	/**
	 * Obtains a reference to the Female Gender radio button
	 */
	@FindBy(xpath = "//input[@value = 'F']")
	WebElement femaleGenderRadioButton;

	/**
	 * Obtains a reference to the Height text box.
	 */
	@FindBy(id = "height")
	WebElement height;

	/**
	 * Obtains a reference to the Weight text box.
	 */
	@FindBy(id = "weight")
	WebElement weight;

	/**
	 * Obtains a reference to the waist text box.
	 */
	@FindBy(id = "waist")
	WebElement waist;

	/**
	 * Returns a reference to the terms and conditions check box.
	 */
	@FindBy(id = "AgreedToTerms")
	WebElement termsAndConditionsCheckbox;
	
	/**
	 * Obtains a reference to the Terms and Conditions link.
	 */
	@FindBy (linkText = "Terms and Conditions")
	WebElement termsAndConditionsLink;
	
	/**
	 * Returns a reference to the Terms and Conditions Modal Header.
	 */
//	@FindBy (xpath = "//div[@class='modal-header']")
	@FindBy (xpath = "//h2[@class = 'modal-title text-primary text-center']")
	WebElement termsAndConditionsModalHeader;
	
	/**
	 * Returns a reference to the Terms and Conditions Modal Body.
	 */
	@FindBy (xpath = "//div[@class='modal-body text-info']")
	WebElement termsAndConditionsModalBody;
	
	/**
	 * Returns a reference to the Close button on the Terms and Conditions modal
	 */
//	@FindBy (xpath = "//button[@innerText='Close']")
	@FindBy (xpath = "//button[@class='btn btn-primary center-block']")
	WebElement termsAndConditionsCloseButton;

	/**
	 * Obtains a reference to the Email radio button.
	 */
	@FindBy(xpath = "//input[@value = 'Email']")
	WebElement emailRadioButton;

	/**
	 * Obtains a reference to the Text radio button.
	 */
	@FindBy(xpath = "//input[@value = 'Text']")
	WebElement textRadioButton;

	/**
	 * Obtains a reference to the Save Profile button.
	 */
	@FindBy(xpath = "//input[@value='Save Profile']")
	WebElement saveProfile;

	/*
	 * METHODS TO INTERACT WITH OBJECTS
	 */

	/**
	 * Reads the value that is currently in the Display Name field.
	 * 
	 * @return String
	 */
	public String readDisplayName() {
		Reporter.log("Start Display Name read", true);

		String displayName = this.displayName.getAttribute("value").trim();

		// Write to the logs if we have a value
		if ((displayName != null) || (displayName != "")) {
			Reporter.log("Display Name field has value: " + displayName, true);
			Reporter.log("", true);// New line in the logs
		}
		return displayName;
	}

	/**
	 * Sets the Display Name with the passed in text.
	 * 
	 * @param displayName
	 */
	public void setDisplayName(String displayName) {
		Reporter.log("Setting the Display Name field", true);

		this.displayName.sendKeys(displayName);

		Reporter.log("Display Name field set to" + displayName, true);
		Reporter.log("", true); // New line in logs
	}

	/**
	 * Clears the Display Name field
	 */
	public void clearDisplayName() {
		Reporter.log("Clearing the Display Name field", true);

		this.displayName.clear();

		Reporter.log("Display Name field cleared", true);
		Reporter.log("", true); // New line in logs
	}

	/**
	 * Reads the value of the Unit drop down box.
	 * 
	 * @return
	 */
	public String readUnit() {

		Reporter.log("Start Unit read", true);
		// String unit = this.unit.getAttribute("value").trim();
		Select unitDropDown = new Select(this.unit);

		String unit = unitDropDown.getFirstSelectedOption().getText();

		// Write to the logs if we have a value
		if ((unit != "") || (unit != null)) {
			Reporter.log("Unit field has value: " + unit, true);
			Reporter.log("", true); // New line in logs
		}
		return unit;
	}

	/**
	 * Selects a value from the Unit drop down, corresponding with the passed in
	 * value.
	 * 
	 * @param unit
	 */
	public void selectUnit(String unit) {

		Reporter.log("Setting the Unit drop down", true);

		Select myDropDown = new Select(this.unit);
		myDropDown.selectByVisibleText(unit);

		Reporter.log("Unit drop down set to " + unit, true);
		Reporter.log("", true);
	}

	/**
	 * Clears the Phone (mobile) field
	 */
	public void clearPhone() {
		Reporter.log("Clearing the Phone (mobile)field", true);

		this.phoneCell.clear();

		Reporter.log("Phone (mobile) field cleared", true);
		Reporter.log("", true); // New line in logs
	}

	/**
	 * Clicks the phone field.
	 */
	public void clickPhone() {
		this.phoneCell.click();
	}

	/**
	 * Reads the value that is currently in the Phone (mobile) field.
	 * 
	 * @return String
	 */
	public String readPhone() {
		Reporter.log("Start Phone (mobile) read", true);

		String phone = this.phoneCell.getAttribute("value").trim();

		// Write to the logs if we have a value
		if ((phone != null) || (phone != "")) {
			Reporter.log("Phone (mobile) field has value: " + phone, true);
			Reporter.log("", true);// New line in the logs
		}
		return phone;
	}

	/**
	 * Sets the Phone (mobile) with the passed in text.
	 * 
	 * @param phone
	 */
	public void setPhone(String phone) {
		Reporter.log("Setting the Phone (mobile)field", true);

		this.phoneCell.sendKeys(phone);

		Reporter.log("Phone (mobile) field set to" + phone, true);
		Reporter.log("", true); // New line in logs
	}

	/**
	 * Clears the Birth Year field.
	 */
	public void clearBirthYear() {
		Reporter.log("Clearing the Birth Year field", true);

		this.birthYear.clear();

		Reporter.log("Birth Year field cleared", true);
		Reporter.log("", true);
	}

	/**
	 * Reads the value that is currently in the Birth Year field.
	 * 
	 * @return String
	 */
	public String readBirthYear() {
		Reporter.log("Start Birth Year read", true);

		String birthYear = this.birthYear.getAttribute("value").trim();

		// Write to the logs if we have a value
		if ((birthYear != null) || (birthYear != "")) {
			Reporter.log("Birth Year field has value: " + birthYear, true);
			Reporter.log("", true);// New line in the logs
		}
		return birthYear;
	}

	/**
	 * Sets the Birth Year with the passed in text.
	 * 
	 * @param birthYear
	 */
	public void setBirthYear(String birthYear) {
		Reporter.log("Setting the Birth Year field", true);

		this.birthYear.sendKeys(birthYear);

		Reporter.log("Birth Year field set to" + birthYear, true);
		Reporter.log("", true); // New line in logs
	}

	/**
	 * Clicks the Gender - Male radio button if the user passes in true.
	 */
	private void clickGenderMaleRadioButton() {
		// If the user passes in true, click the radio button.
		Reporter.log("Clicking the Gender - Male radio button", true);
		this.maleGenderRadioButton.click();
		Reporter.log("Gender - Male radio button clicked", true);
		Reporter.log("", true);
	}

	// /**
	// * Returns the value of the Gender - Male radio button.
	// *
	// * @return boolean true if checked; false if not checked.
	// */
	// private boolean readGenderMale() {
	// Reporter.log("Reading the Gender - Male radio button", true);
	//
	// // Get current boolean status of checked or not checked.
	// boolean clicked = this.maleGender.isSelected();
	//
	// Reporter.log("Gender - Male radio button is set to: " + clicked, true);
	// Reporter.log("", true);
	//
	// return clicked;
	// }

	/**
	 * Clicks the Gender - Female radio button if the user passes in true.
	 * 
	 * @param clickedStatus
	 */
	private void clickGenderFemaleRadioButton() {
		// If the user passes in true, click the radio button.
		Reporter.log("Clicking the Gender - Female radio button", true);
		this.femaleGenderRadioButton.click();
		Reporter.log("Gender - Female radio button clicked", true);
		Reporter.log("", true);
	}

	// /**
	// * Returns the value of the Gender - Female radio button.
	// *
	// * @return boolean true if checked; false if not checked.
	// */
	// private boolean readGenderFemale() {
	// Reporter.log("Reading the Gender - Female radio button", true);
	//
	// // Get current boolean status of checked or not checked.
	// boolean clicked = this.femaleGender.isSelected();
	//
	// Reporter.log("Gender - Female radio button is set to: " + clicked, true);
	// Reporter.log("", true);
	//
	// return clicked;
	// }

	/**
	 * Sets the Gender radio button corresponding with the passed in gender.
	 * 
	 * @param gender
	 */
	public void setGender(String gender) {
		Reporter.log("Setting the gender radio button of " + gender);
		if (gender.equalsIgnoreCase("MALE")) {
			clickGenderMaleRadioButton();
			Reporter.log("Male radio button selected");
		} else if (gender.equalsIgnoreCase("FEMALE")) {
			clickGenderFemaleRadioButton();
			Reporter.log("Male radio button selected");
		} else {
			throw new InvalidArgumentException(
					"The value of " + gender + " is not a valid value for Gender. See Datasheet.");
		}

		Reporter.log("", true);
	}

	/**
	 * Reads the gender status corresponding with the passed in gender.
	 * 
	 * @param gender
	 * @return boolean returns false if not selected; returns true if selected;
	 */
	public boolean isGenderSelected(String gender) {
		boolean sex;

		Reporter.log("Beginning Is Gender Selected check for " + gender + " gender.", true);

		if ((gender.equalsIgnoreCase("MALE")) && (this.maleGenderRadioButton.isSelected() == true)) {
			sex = true;
		} else if ((gender.equalsIgnoreCase("FEMALE")) && (this.femaleGenderRadioButton.isSelected() == true)) {
			sex = true;
		}

		else if ((this.maleGenderRadioButton.isSelected() == false)
				&& this.femaleGenderRadioButton.isSelected() == false) {
			throw new InvalidArgumentException("Neither Male or Female radio buttons are selected.");
		} else {
			throw new InvalidArgumentException("The passed in gender of " + gender + " is not selected.");
		}

		Reporter.log("Gender selection is " + sex + " for gender " + gender, true);
		Reporter.log("", true);

		return sex;
	}

	/**
	 * Clears the Height field
	 */
	public void clearHeight() {
		Reporter.log("Clearing the Height field", true);

		this.height.clear();

		Reporter.log("Height field cleared", true);
		Reporter.log("", true); // New line in logs
	}

	/**
	 * Reads the value that is currently in the Height field.
	 * 
	 * @return String
	 */
	public String readHeight() {
		Reporter.log("Start Height read", true);

		String height = this.height.getAttribute("value").trim();

		// Write to the logs if we have a value
		if ((height != null) || (height != "")) {
			Reporter.log("Height field has value: " + height, true);
			Reporter.log("", true);
		}
		return height;
	}

	/**
	 * Sets the Height field with the passed in height.
	 * 
	 * @param height
	 */
	public void setHeight(String height) {

		Reporter.log("Setting the Height field to " + height, true);

		this.height.sendKeys(height);

		Reporter.log("Height field set", true);
		Reporter.log("", true); // New line in logs
	}

	/**
	 * Clears the Weight field
	 */
	public void clearWeight() {
		Reporter.log("Clearing the Weight field", true);

		this.weight.clear();

		Reporter.log("Weight field cleared", true);
		Reporter.log("", true); // New line in logs
	}

	/**
	 * Reads the value that is currently in the Weight field.
	 * 
	 * @return String
	 */
	public String readWeight() {
		Reporter.log("Start Weight read", true);

		String weight = this.weight.getAttribute("value").trim();

		// Write to the logs if we have a value
		if ((weight != null) || (weight != "")) {
			Reporter.log("Weight field has value: " + weight, true);
			Reporter.log("", true);
		}
		return weight;
	}

	/**
	 * Sets the Weight field with the passed in weight value.
	 * 
	 * @param weight
	 */
	public void setWeight(String weight) {

		Reporter.log("Setting the Weight field to " + weight, true);

		this.weight.sendKeys(weight);

		Reporter.log("Weight field set", true);
		Reporter.log("", true); // New line in logs
	}

	/**
	 * Clears the Waist field
	 */
	public void clearWaist() {
		Reporter.log("Clearing the Waist field", true);

		this.waist.clear();

		Reporter.log("Waist field cleared", true);
		Reporter.log("", true); // New line in logs
	}

	/**
	 * Reads the value that is currently in the Waist field.
	 * 
	 * @return String
	 */
	public String readWaist() {
		Reporter.log("Start Waist read", true);

		String waist = this.waist.getAttribute("value").trim();

		// Write to the logs if we have a value
		if ((waist != null) || (waist != "")) {
			Reporter.log("Waist field has value: " + waist, true);
			Reporter.log("", true);
		}
		return waist;
	}

	/**
	 * Sets the Waist field with the passed in waist value.
	 * 
	 * @param waist
	 */
	public void setWaist(String waist) {

		Reporter.log("Setting the Waist field to " + waist, true);

		this.waist.sendKeys(waist);

		Reporter.log("Waist field set", true);
		Reporter.log("", true); // New line in logs
	}

	/**
	 * Sets the Terms and Conditions checkbox with the passed in desired status.
	 * If it is already set to the desired status, it will not modify it.
	 * 
	 * @param desiredStatus
	 */
	public void setTermsAndConditions(boolean desiredStatus) {
		Reporter.log("Beginning Terms & Conditions Set", true);
		// Get the current status
		boolean currentStatus = termsAndConditionsCheckbox.isSelected();
		Reporter.log("Terms & Conditions initial value: " + currentStatus, true);
		// ^ is exclusive OR.. It's only false when they have different values.
		if (desiredStatus ^ currentStatus) {
			termsAndConditionsCheckbox.click();
		}
		// Else leave it alone and do nothing
		Reporter.log("Terms & Conditions final value: " + termsAndConditionsCheckbox.isSelected(), true);
		Reporter.log("", true);
	}

	/**
	 * Returns the value of the Terms and Conditions checkbox.
	 * @return boolean true if selected; false if not selected.
	 */
	public boolean readTermsAndConditionsCheckbox() {
		Reporter.log("Beginning Terms & Conditions Read", true);
		boolean termsValue = termsAndConditionsCheckbox.isSelected();
		Reporter.log("Terms & Conditions value is: " + termsValue, true);
		Reporter.log("", true);
		return termsValue;
	}
	
	/**
	 * Reads the link text from the Terms and Conditions link.
	 * @return String
	 */
	public String readTermsAndConditionsLinkText(){
		Reporter.log("Beginning Terms & Conditions Link Text Read", true);
		String text = termsAndConditionsLink.getAttribute("text");
		Reporter.log("Terms and Conditions link text is : " + text, true);
		Reporter.log("", true);
		
		return text;	
	}
	
	/**
	 * Clicks the Terms and Conditions link on the page.
	 */
	public void clickTermsAndConditionsLink(){
		Reporter.log("Clicking Terms and Conditions link", true);
		termsAndConditionsLink.click();
		Reporter.log("Terms and Conditions Link clicked", true);
		Reporter.log("", true);
		AutomationHelper.waitSeconds(2);
	}
	
	/**
	 * Reads the header value of the Terms and Conditions modal popup.
	 * @return String
	 */
	public String readTermsAndConditionsModalHeader() {
		Reporter.log("Beginning Terms & Conditions Modal Header Text Read", true);
		String text = termsAndConditionsModalHeader.getAttribute("innerText");
		Reporter.log("Terms and Conditions Modal Header text is: " + text, true);
		Reporter.log("", true);

		return text;
	}
	
	/**
	 * Reads the body value of the Terms and Conditions modal popup.
	 * @return String
	 */
	public String readTermsAndConditionsModalBody() {
		Reporter.log("Beginning Terms & Conditions Modal Body Text Read", true);
		String text = termsAndConditionsModalBody.getAttribute("textContent").trim();
		Reporter.log("Terms and Conditions Modal Body text is: " + text, true);
		Reporter.log("", true);

		return text;
	}
	
	/**
	 * Clicks the Terms and Conditions Close button on the modal.
	 */
	public void clickTermsAndConditionsCloseButton(){
		Reporter.log("Clicking Close on the Terms & Conditions Modal", true);
		termsAndConditionsCloseButton.click();
		Reporter.log("Terms & Conditions Modal Close button clicked", true);
		Reporter.log("", true);
		AutomationHelper.waitSeconds(2);
	}
	// /**
	// * Returns the value of the Email radio button.
	// *
	// * @return boolean true if clicked; false if not clicked.
	// */
	// public boolean readEmailRadioButton() {
	// Reporter.log("Reading the Email radio button", true);
	//
	// // Get current boolean status of checked or not checked.
	// boolean clicked = this.emailRadioButton.isSelected();
	//
	// Reporter.log("Email radio button is set to: " + clicked, true);
	// Reporter.log("", true);
	//
	// return clicked;
	// }

	/**
	 * Clicks the Email radio button on the Contact Preference page.
	 */
	private void clickEmailRadioButton() {

		Reporter.log("Clicking the Contact Preference - Email radio button", true);
		this.emailRadioButton.click();
		Reporter.log("Contact Preference - Email radio button clicked", true);
		Reporter.log("", true);
	}

	// /**
	// * Returns the value of the Text radio button.
	// *
	// * @return boolean true if checked; false if not checked.
	// */
	// public boolean readTextRadioButton() {
	// Reporter.log("Reading the Text radio button", true);
	//
	// // Get current boolean status of checked or not checked.
	// boolean clicked = this.textRadioButton.isSelected();
	//
	// Reporter.log("Text radio button is set to: " + clicked, true);
	// Reporter.log("", true);
	//
	// return clicked;
	// }

	/**
	 * Clicks the Text radio button on the Contact Preference page.
	 */
	private void clickTextRadioButton() {

		Reporter.log("Clicking the Contact Preference - Text radio button", true);
		this.textRadioButton.click();
		Reporter.log("Contact Preference - Text radio button clicked", true);
		Reporter.log("", true);
	}

	/**
	 * Sets the Contact Preference radio button corresponding with the passed in
	 * preference.
	 * 
	 * @param preferredContact
	 */
	public void setPreferredContact(String preferredContact) {

		Reporter.log("Setting the Preferred Contact radio button of " + preferredContact);
		if (preferredContact.equalsIgnoreCase("EMAIL")) {
			clickEmailRadioButton();
			Reporter.log("Email radio button selected");

		} else if (preferredContact.equalsIgnoreCase("TEXT")) {
			clickTextRadioButton();
			Reporter.log("Text radio button selected");

		} else {
			throw new InvalidArgumentException("The value of " + preferredContact
					+ " is not a valid value for Contact Preference. See Datasheet.");
		}
		Reporter.log("", true);
	}

	/**
	 * Reads the Preferred Contact status corresponding with the passed in
	 * contact preference.
	 * 
	 * @param preferredContact
	 * @return boolean returns false if not selected; returns true if selected;
	 */
	public boolean isPreferredContactSelected(String preferredContact) {
		boolean contacPreferenceSet;

		Reporter.log("Beginning Is Preferred Contact Selected check for '" + preferredContact + "' preferred contact.",
				true);

		if ((preferredContact.equalsIgnoreCase("EMAIL")) && (this.emailRadioButton.isSelected() == true)) {
			contacPreferenceSet = true;
		}

		else if ((preferredContact.equalsIgnoreCase("TEXT")) && (this.textRadioButton.isSelected() == true)) {
			contacPreferenceSet = true;
		} else if ((this.emailRadioButton.isSelected() == false) && this.textRadioButton.isSelected() == false) {
			throw new InvalidArgumentException("Neither email or text radio buttons are selected.");
		} else {
			throw new InvalidArgumentException("The passed in contact of " + preferredContact + " is not selected.");
		}

		Reporter.log("Preferred Contact selection is " + contacPreferenceSet + " for contact preference of "
				+ preferredContact, true);
		Reporter.log("", true);

		return contacPreferenceSet;
	}

	/**
	 * Clicks the Save Profile button
	 */
	public void clickSaveProfile() {
		Reporter.log("Clicking Save Profile");
		saveProfile.click();
		Reporter.log("Save Profile button clicked", true);
		Reporter.log("", true);
		AutomationHelper.waitSeconds(2);
	}

	/**
	 * Checks for the presence of an error message on the page.
	 * 
	 * @param errorMessage
	 * @return boolean true if found; false if not found.
	 */
	public boolean isErrorMessagePresent(String errorMessage) {

		Reporter.log("Beginning Error Message Check for is field present.", true);

		boolean errorFound = false;

		// Create a list of error message elements.
		List<WebElement> errorMessages = driver
				.findElements(By.xpath("//span[@class='text-danger field-validation-error']"));

		if (errorMessages.size() > 0) {

			for (WebElement currentMessage : errorMessages) {
				if (errorMessage.equals(currentMessage.getAttribute("innerText").trim())) {
					errorFound = true;
					Reporter.log("Error message was present.", true);
					Reporter.log("", true);
					break;
				}
			}
		}
		return errorFound;
	}

	/**
	 * Checks the entire page for any error messages.
	 * 
	 * @return boolean
	 */
	public boolean doesPageHaveErrorMessages() {

		Reporter.log("Beginning Check for ANY error messages", true);

		boolean errorFound = false;

		// Create a list of error message elements

		errorFound = driver.findElements(By.xpath("//span[@class='field-validation-error text-danger']")).size() > 0;

		return errorFound;
	}

	// /**
	// * Returns the value of the Email radio button.
	// *
	// * @return boolean true if clicked; false if not clicked.
	// */
	// public boolean readEmailRadioButton() {
	// Reporter.log("Reading the Email radio button", true);
	//
	// // Get current boolean status of checked or not checked.
	// boolean clicked = this.emailRadioButton.isSelected();
	//
	// Reporter.log("Email radio button is set to: " + clicked, true);
	// Reporter.log("", true);
	//
	// return clicked;
	// }
	//
	// /**
	// * Sets the Email radio button with the desired status as passed in by the
	// * user.
	// *
	// * @param desiredStatus
	// */
	// public void setEmailRadioButton(boolean desiredStatus) {
	//
	// Reporter.log("Setting the Email radio button", true);
	//
	// // Get current boolean status of checked or not checked.
	// boolean checked = this.emailRadioButton.isSelected();
	//
	// if ((desiredStatus == true) && (checked == false)) {
	// this.emailRadioButton.click();
	// } else if ((desiredStatus == false) && (checked == true)) {
	// this.emailRadioButton.click();
	// }
	// // Else leave it alone how it is.
	// Reporter.log("Email radio button set to: " + desiredStatus, true);
	// Reporter.log("", true);
	// }

}
