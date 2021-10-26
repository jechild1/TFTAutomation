package pageFactories.LegacyPageFactories;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

import configuration.TestConfig;
import utilities.AutomationHelper;

/**
 * Page factory for the Register page for Team Fitness Tracker.<br>
 * (1) Finds a reference to objects on the page <br>
 * (2) Defines methods to interact with objects on the page.
 * 
 * @author jesse.childress
 *
 */
public class RegisterPageFactory extends TestConfig{

	/**
	 * Page Constructor: Accepts the WebDriver from the calling page &
	 * instantiates the elements on the page.
	 */
	public RegisterPageFactory(){
		PageFactory.initElements(driver, this);
	}
	
	/*
	 * FINDING OBJECTS ON A PAGE - GETTER METHODS
	 */
	
	/**
	 * Obtain a reference to the User Name field
	 */
	@FindBy(id="UserName")
	WebElement userName;
	
	/**
	 * Obtain a reference to the Email field
	 */
	@FindBy (id = "Email")
	WebElement email;
	
	/**
	 * Obtain a reference to the Password field
	 */
	@FindBy (id = "Password")
	WebElement password;
	
	/**
	 * Obtain a reference to the Confirm Password field
	 */
	@FindBy (id = "ConfirmPassword")
	WebElement confirmPassword;
	
	/**
	 * Obtain a reference to the User Role drop down field
	 */
	@FindBy (id = "Name")
	WebElement userRole;
	
	/**
	 * Obtain a reference to the box holding the email criteria.
	 */
	@FindBy (xpath = "//div[@class='col-md-6 alert alert-dismissible alert-danger']")
	WebElement emailCriteriaWarning;
	
	/**
	 * Obtain a reference to the Register button
	 */
	@FindBy (xpath = "//input[@value='Register']")
	WebElement registerButton;
	
	//TODO - Cantidate for abstract class
	/**
	 * Obtains a reference to the Home Link.
	 */
	@FindBy (linkText="Home")
	WebElement homeLink;
	
	/*
	 *METHODS TO INTERACT WITH OBJECTS 
	 */
	
	/**
	 * Reads the value of the User Name field. 
	 */
	public String readUserName(){
		Reporter.log("Start User Name read", true);
		String userName = this.userName.getAttribute("value").trim();
		//Write to the logs if we have a value
		if((userName != "") || (userName!= null)){
			Reporter.log("User Name field has value: " + userName, true);
			Reporter.log("", true); //New line in logs
		}
		return userName;
	}
	
	/**
	 * Sets the User Name field with the passed in text.
	 * @param userName
	 */
	public void setUserName(String userName){
		Reporter.log("Setting the User Name field", true);
		this.userName.sendKeys(userName);
		Reporter.log("User Name field set", true);
		Reporter.log("", true); //New line in logs
	}
	
	/**
	 * Clicks the User Name field
	 */
	public void clickUserName(){
		this.userName.click();
	}
	
	
	/**
	 * Reads the value of the Email Address field. 
	 */
	public String readEmailAddress(){
		Reporter.log("Start Email Address read", true);
		String emailAddress = this.email.getAttribute("value").trim();
		//Write to the logs if we have a value
		if((emailAddress != "") || (emailAddress!= null)){
			Reporter.log("Email Address field has value: " + emailAddress, true);
			Reporter.log("", true); //New line in logs
		}
		return emailAddress;
	}
	
	/**
	 * Clicks the Email Address field to put focus there.
	 */
	public void clickEmailAddress(){
		this.email.click();
	}
	
	/**
	 * Sets the Email Address field with the passed in text.
	 * @param emailAddress
	 */
	public void setEmailAddress(String emailAddress){
		Reporter.log("Setting the Email Address field", true);
		this.email.sendKeys(emailAddress);
		Reporter.log("Email Address field set", true);
		Reporter.log("", true); //New line in logs
	}
	
	/**
	 * Reads the value of the Password field. 
	 */
	public String readPassword(){
		Reporter.log("Start Password read", true);
		String password = this.password.getAttribute("value").trim();
		//Write to the logs if we have a value
		if((password != "") || (password!= null)){
			Reporter.log("Password field has value: " + password, true);
			Reporter.log("", true); //New line in logs
		}
		return password;
	}
	
	/**
	 * Sets the Password field with the passed in text.
	 * @param password
	 */
	public void setPassword(String password){
		Reporter.log("Setting the Password field", true);
		this.password.sendKeys(password);
		Reporter.log("Password field set", true);
		Reporter.log("", true); //New line in logs
	}
	
	/**
	 * Reads the value of the Confirm Password field. 
	 */
	public String readConfirmPassword(){
		Reporter.log("Start Confirm Password read", true);
		String confirmPassword = this.confirmPassword.getAttribute("value").trim();
		//Write to the logs if we have a value
		if((confirmPassword != "") || (confirmPassword!= null)){
			Reporter.log("Confirm Password field has value: " + confirmPassword, true);
			Reporter.log("", true); //New line in logs
		}
		return confirmPassword;
	}
	
	/**
	 * Sets the Confirm Password field with the passed in text.
	 * @param confirmPassword
	 */
	public void setConfirmPassword(String confirmPassword){
		Reporter.log("Setting the Confirm Password field", true);
		this.confirmPassword.sendKeys(confirmPassword);
		Reporter.log("Confirm Password field set", true);
		Reporter.log("", true); //New line in logs
	}
	
	/**
	 * Reads the value currently selected for the user role.
	 * 
	 * @return String
	 */
	public String readUserRole(){
		Reporter.log("Start User Role read", true);
		String userRoleOption = this.userRole.getAttribute("value").trim();
		//Write to the logs if we have a value
		if((userRoleOption != "") || (userRoleOption!= null)){
			Reporter.log("Confirm Password field has value: " + userRoleOption, true);
			Reporter.log("", true); //New line in logs
		}
		return userRoleOption;
	}

	/**
	 * Selects a value from the User Role drop down, corresponding with the
	 * passed in value.
	 * 
	 * @param userRole
	 */
	public void selectUserRole(String userRole){
		Reporter.log("Setting the User Role drop down", true);
		
		Select myDropDown = new Select(this.userRole);
		myDropDown.selectByValue(userRole);
		
		Reporter.log("Confirm User Role drop down set", true);
		Reporter.log("", true);
	}
	
	/**
	 * Clicks the Register button on the Register Page
	 */
	public void clickRegister(){
		Reporter.log("Clicking Register button", true);
		registerButton.click();
		
		//Allow opportunity for errors and messages to display
		AutomationHelper.wait(3);
		
		Reporter.log("Register button clicked", true);
		Reporter.log("", true);
	}
	
	/**
	 * Reads the Email Criteria message present on the page.
	 * @return String
	 */
	public String readEmailCriteriaMessage(){
		return emailCriteriaWarning.getAttribute("textContent").trim();
	}
	
	
	/**
	 * Checks for the presence of an error message on the page.
	 * 
	 * @param errorMessage
	 * @return boolean true if found; false if not found.
	 */
	public boolean isErrorMessagePresent(String errorMessage){
		
		Reporter.log("Beginning Error Message Check for is field present.", true);
		
		boolean errorFound = false;
		
		//Create a list of error message elements (they live in a li)
		List<WebElement> errorMessages = driver.findElements(By.xpath("//div[@class='text-danger validation-summary-errors']/ul/li"));
		
		if (errorMessages.size() > 0) {

			for (WebElement currentMessage : errorMessages) {
				if (errorMessage.equals(currentMessage.getAttribute("innerText"))) {
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
	 * Checks the entire page for ANY error messages.
	 * @return boolean
	 */
	public boolean doesPageHaveErrorMessages(){
		
		Reporter.log("Beginning Check for ANY error messages", true);
		
		boolean errorFound = false;
		
		//Create a list of error message elements (they live in a li)
		
		errorFound = driver.findElements(By.xpath("//div[@class='text-danger validation-summary-errors']/ul/li")).size() > 0;
	
		return errorFound;
	}
	
	/**
	 * Clears all the fields on the Register page.
	 */
	public void clearPageFields(){
		Reporter.log("Starting to clear all fields", true);
		userName.clear();
		email.clear();
		password.clear();
		confirmPassword.clear();

		Reporter.log("All fields cleared", true);
		Reporter.log("", true);
	}
}
