package testCases.Archived;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import configuration.TFTConfig;
import modularScripts.LoginAsExistingUserMod;
import pageFactories.ChangePasswordPageFactory;
import pageFactories.ManagePageFactory;
import pageFactories.MenusPageFactory;
import utilities.AutomationHelper;
import utilities.ExcelDataConfig;

/**
 * This test exercises the Change Password capability in TFT.
 */
public class ChangePassword extends TFTConfig {

	// Set up datafiles
	String excelFilePath = generateFullFileNameAndPath("UsersData.xlsx");

	String excelWorksheet = "TFTMisfits";
	ExcelDataConfig excelFile = new ExcelDataConfig(excelFilePath, excelWorksheet);
	// int rowIndex;

	// Obtain a row index where the user IS registered, AND the profile IS
	// completed
	// Data Used = true; Profile Complete = true;
	int rowIndex = excelFile.getRandomRegisteredUserWithProfile();
	// Pull in data from datasheet to be used throughout test
	String userName = excelFile.getData(rowIndex, excelFile.getColumnIndex("UserName"));
	String originalPassword = excelFile.getData(rowIndex, excelFile.getColumnIndex("Password"));
	String displayName = excelFile.getData(rowIndex, excelFile.getColumnIndex("DisplayName"));
	String newPassword;

	/**
	 * This method closes the driver (window).
	 */
	@AfterClass
	private void afterClass() {
		AutomationHelper.finishTest();
	}

	@Test
	public void performPasswordChangeTests() {
		loginAsExistingUser();
		navigateToChangePasswordPage();
		validateNumbersRequired();
		validateSpecialCharactersRequired();
		validateCapitalLettersRequired();
		validateLowerCaseLettersRequired();
		validatePasswordAtLeast6Chars();
		validatePasswordMismatchError();
		validateExistingPasswordIsEntered();
		changePasswordAndValidateSave();
		changePasswordBackToOriginal();
	}

	/**
	 * This method logs in as an existing user and ensures their display name is in
	 * the header.
	 */
	private void loginAsExistingUser() {

		AutomationHelper.printMethodName();

		// // Validate we are on the home page
		// AutomationHelper.checkPageTitlePresent(driver, "Home Page - Team
		// Fitness Tracker");

		// Call modular script to login
		LoginAsExistingUserMod loginScript = new LoginAsExistingUserMod();
		loginScript.loadPage();
		loginScript.loginAsUser(userName, originalPassword, excelFile);

		MenusPageFactory menus = new MenusPageFactory();
		// Validate greeting name
		assertEquals(menus.readGreetingName(), displayName, "Display Name in Menu:");
	}

	/**
	 * Method to navigate to the Change Password page.
	 */
	private void navigateToChangePasswordPage() {

		AutomationHelper.printMethodName();

		// ***TESTS***
		MenusPageFactory menus = new MenusPageFactory();
		menus.clickChangePassword();

		// Validate we are on the Change Password page
		AutomationHelper.waitForPageToLoad(15);
		AutomationHelper.checkPageTitlePresent("Change Password - Team Fitness Tracker");

		// ***END TESTS

		// Catch and print errors
		softAsserter.assertAll();

	}

	/**
	 * This method asserts that numbers are required in the password.
	 */
	private void validateNumbersRequired() {

		AutomationHelper.printMethodName();

		// String for password without a number
		String passwordWithoutNumber = "P@ssword";

		// ***TESTS***
		ChangePasswordPageFactory changePasswordPage = new ChangePasswordPageFactory();
		changePasswordPage.setCurrentPassword(originalPassword);
		changePasswordPage.setNewPassword(passwordWithoutNumber);
		changePasswordPage.setConfirmPassword(passwordWithoutNumber);

		softAsserter.assertEquals(changePasswordPage.readCurrentPassword(), originalPassword,
				"Original Password field (Password w/out Number):");
		softAsserter.assertEquals(changePasswordPage.readNewPassword(), passwordWithoutNumber,
				"New Password field (Password w/out Number):");
		softAsserter.assertEquals(changePasswordPage.readConfirmPassword(), passwordWithoutNumber,
				"Confirm Password field (Password w/out Number):");

		// Click Save to receive error message
		changePasswordPage.clickChangePassword();

		softAsserter.assertTrue(
				changePasswordPage.isErrorMessagePresent("Passwords must have at least one digit ('0'-'9')."));

		// Clear fields for next test
		changePasswordPage.clearCurrentPassword();
		changePasswordPage.clearNewPassword();
		changePasswordPage.clearConfirmPassword();

		softAsserter.assertEquals(changePasswordPage.readCurrentPassword(), "",
				"Original Password field - (Password w/out Number) Cleared:");
		softAsserter.assertEquals(changePasswordPage.readNewPassword(), "",
				"New Password field - (Password w/out Number) Cleared:");
		softAsserter.assertEquals(changePasswordPage.readConfirmPassword(), "",
				"Confirm Password field - (Password w/out Number) Cleared:");

		// ***END TESTS

		// Catch and print errors
		softAsserter.assertAll();

		// Validate we are on the Change Password page. Ensures a password did
		// not save.
		String pageTitle = utilities.AutomationHelper.getPageTitle();
		Assert.assertEquals(pageTitle, "Change Password - Team Fitness Tracker",
				"Change Password Page not found. Instead found page with title " + pageTitle);
	}

	/**
	 * This method asserts that special characters are required.
	 */
	private void validateSpecialCharactersRequired() {
		AutomationHelper.printMethodName();

		// String for password without a Special Character
		String passwordWithoutSpecialCharacter = "PASSword123";

		// ***TESTS***
		// Perform Sets
		ChangePasswordPageFactory changePasswordPage = new ChangePasswordPageFactory();
		changePasswordPage.setCurrentPassword(originalPassword);
		changePasswordPage.setNewPassword(passwordWithoutSpecialCharacter);
		changePasswordPage.setConfirmPassword(passwordWithoutSpecialCharacter);
		// Perform reads
		softAsserter.assertEquals(changePasswordPage.readCurrentPassword(), originalPassword,
				"Original Password field (No special characters):");
		softAsserter.assertEquals(changePasswordPage.readNewPassword(), passwordWithoutSpecialCharacter,
				"New Password field (No special characters):");
		softAsserter.assertEquals(changePasswordPage.readConfirmPassword(), passwordWithoutSpecialCharacter,
				"Confirm Password field (No special characters):");

		// Click Save to receive error message
		changePasswordPage.clickChangePassword();

		softAsserter.assertTrue(changePasswordPage
				.isErrorMessagePresent("Passwords must have at least one non letter or digit character."));

		// Clear fields for next test
		changePasswordPage.clearCurrentPassword();
		changePasswordPage.clearNewPassword();
		changePasswordPage.clearConfirmPassword();

		softAsserter.assertEquals(changePasswordPage.readCurrentPassword(), "",
				"Original Password field - (No special characters) Cleared:");
		softAsserter.assertEquals(changePasswordPage.readNewPassword(), "",
				"New Password field - (No special characters) Cleared:");
		softAsserter.assertEquals(changePasswordPage.readConfirmPassword(), "",
				"Confirm Password field - (No special characters) Cleared:");

		// ***END TESTS

		// Catch and print errors
		softAsserter.assertAll();

		// Validate we are on the Change Password page. Ensures a password did
		// not save.
		String pageTitle = utilities.AutomationHelper.getPageTitle();
		Assert.assertEquals(pageTitle, "Change Password - Team Fitness Tracker",
				"Change Password Page not found. Instead found page with title " + pageTitle);
	}

	/**
	 * This method attempts a password without using capital letter.
	 */
	private void validateCapitalLettersRequired() {
		AutomationHelper.printMethodName();

		// String for password without capital letters
		String passwordWithoutUpperCaseLetter = "p@ssword123";

		// ***TESTS***
		// Perform Sets
		ChangePasswordPageFactory changePasswordPage = new ChangePasswordPageFactory();
		changePasswordPage.setCurrentPassword(originalPassword);
		changePasswordPage.setNewPassword(passwordWithoutUpperCaseLetter);
		changePasswordPage.setConfirmPassword(passwordWithoutUpperCaseLetter);
		// Perform reads
		softAsserter.assertEquals(changePasswordPage.readCurrentPassword(), originalPassword,
				"Original Password field (No Uppercase Letters):");
		softAsserter.assertEquals(changePasswordPage.readNewPassword(), passwordWithoutUpperCaseLetter,
				"New Password field (No Uppercase Letters):");
		softAsserter.assertEquals(changePasswordPage.readConfirmPassword(), passwordWithoutUpperCaseLetter,
				"Confirm Password field (No Uppercase Letters):");

		// Click Save to receive error message
		changePasswordPage.clickChangePassword();

		softAsserter.assertTrue(
				changePasswordPage.isErrorMessagePresent("Passwords must have at least one uppercase ('A'-'Z')."));

		// Clear fields for next test
		changePasswordPage.clearCurrentPassword();
		changePasswordPage.clearNewPassword();
		changePasswordPage.clearConfirmPassword();

		softAsserter.assertEquals(changePasswordPage.readCurrentPassword(), "",
				"Original Password field - (No Uppercase Letters) Cleared:");
		softAsserter.assertEquals(changePasswordPage.readNewPassword(), "",
				"New Password field - (No Uppercase Letters) Cleared:");
		softAsserter.assertEquals(changePasswordPage.readConfirmPassword(), "",
				"Confirm Password field - (No Uppercase Letters) Cleared:");

		// ***END TESTS

		// Catch and print errors
		softAsserter.assertAll();

		// Validate we are on the Change Password page. Ensures a password did
		// not save.
		String pageTitle = utilities.AutomationHelper.getPageTitle();
		Assert.assertEquals(pageTitle, "Change Password - Team Fitness Tracker",
				"Change Password Page not found. Instead found page with title " + pageTitle);
	}

	/**
	 * Method to attempt password without using a lower case letter
	 */
	private void validateLowerCaseLettersRequired() {
		AutomationHelper.printMethodName();

		// String for password without lower case letters
		String passwordWithoutLowerCaseLetter = "P@SSWORD123";

		// ***TESTS***
		// Perform Sets
		ChangePasswordPageFactory changePasswordPage = new ChangePasswordPageFactory();
		changePasswordPage.setCurrentPassword(originalPassword);
		changePasswordPage.setNewPassword(passwordWithoutLowerCaseLetter);
		changePasswordPage.setConfirmPassword(passwordWithoutLowerCaseLetter);
		// Perform reads
		softAsserter.assertEquals(changePasswordPage.readCurrentPassword(), originalPassword,
				"Original Password field (No Lowercase Letters):");
		softAsserter.assertEquals(changePasswordPage.readNewPassword(), passwordWithoutLowerCaseLetter,
				"New Password field (No Lowercase Letters):");
		softAsserter.assertEquals(changePasswordPage.readConfirmPassword(), passwordWithoutLowerCaseLetter,
				"Confirm Password field (No Lowercase Letters):");

		// Click Save to receive error message
		changePasswordPage.clickChangePassword();

		softAsserter.assertTrue(
				changePasswordPage.isErrorMessagePresent("Passwords must have at least one lowercase ('a'-'z')."));

		// Clear fields for next test
		changePasswordPage.clearCurrentPassword();
		changePasswordPage.clearNewPassword();
		changePasswordPage.clearConfirmPassword();

		softAsserter.assertEquals(changePasswordPage.readCurrentPassword(), "",
				"Original Password field - (No Lowercase Letters) Cleared:");
		softAsserter.assertEquals(changePasswordPage.readNewPassword(), "",
				"New Password field - (No Lowercase Letters) Cleared:");
		softAsserter.assertEquals(changePasswordPage.readConfirmPassword(), "",
				"Confirm Password field - (No Lowercase Letters) Cleared:");

		// ***END TESTS

		// Catch and print errors
		softAsserter.assertAll();

		// Validate we are on the Change Password page. Ensures a password did
		// not save.
		String pageTitle = utilities.AutomationHelper.getPageTitle();
		Assert.assertEquals(pageTitle, "Change Password - Team Fitness Tracker",
				"Change Password Page not found. Instead found page with title " + pageTitle);

	}

	/**
	 * Method to validate that the password is at least 6 characters long
	 */
	private void validatePasswordAtLeast6Chars() {
		AutomationHelper.printMethodName();

		// String for short password
		String shortPassword = "P@ss1";

		// ***TESTS***
		// Perform Sets
		ChangePasswordPageFactory changePasswordPage = new ChangePasswordPageFactory();
		changePasswordPage.setCurrentPassword(originalPassword);
		changePasswordPage.setNewPassword(shortPassword);
		changePasswordPage.setConfirmPassword(shortPassword);
		// Perform reads
		softAsserter.assertEquals(changePasswordPage.readCurrentPassword(), originalPassword,
				"Original Password field (Short password):");
		softAsserter.assertEquals(changePasswordPage.readNewPassword(), shortPassword,
				"New Password field (Short password):");
		softAsserter.assertEquals(changePasswordPage.readConfirmPassword(), shortPassword,
				"Confirm Password field (Short password):");

		// Click Save to receive error message
		changePasswordPage.clickChangePassword();

		softAsserter.assertTrue(
				changePasswordPage.isErrorMessagePresent("The New password must be at least 6 characters long."));

		// Clear fields for next test
		changePasswordPage.clearCurrentPassword();
		changePasswordPage.clearNewPassword();
		changePasswordPage.clearConfirmPassword();

		softAsserter.assertEquals(changePasswordPage.readCurrentPassword(), "",
				"Original Password field - (Short password) Cleared:");
		softAsserter.assertEquals(changePasswordPage.readNewPassword(), "",
				"New Password field - (Short password) Cleared:");
		softAsserter.assertEquals(changePasswordPage.readConfirmPassword(), "",
				"Confirm Password field - (Short password) Cleared:");

		// ***END TESTS

		// Catch and print errors
		softAsserter.assertAll();

		// Validate we are on the Change Password page. Ensures a password did
		// not save.
		String pageTitle = utilities.AutomationHelper.getPageTitle();
		Assert.assertEquals(pageTitle, "Change Password - Team Fitness Tracker",
				"Change Password Page not found. Instead found page with title " + pageTitle);
	}

	/**
	 * Method to validate a password mismatch error
	 */
	private void validatePasswordMismatchError() {
		AutomationHelper.printMethodName();

		// Strings for mismatched password
		String mismatchPassword1 = "MISM@tch1";
		String mismatchPassword2 = "MISM@tch2";

		// ***TESTS***
		// Perform Sets
		ChangePasswordPageFactory changePasswordPage = new ChangePasswordPageFactory();
		changePasswordPage.setCurrentPassword(originalPassword);
		changePasswordPage.setNewPassword(mismatchPassword1);
		changePasswordPage.setConfirmPassword(mismatchPassword2);
		// Perform reads
		softAsserter.assertEquals(changePasswordPage.readCurrentPassword(), originalPassword,
				"Original Password field (Password mismatch):");
		softAsserter.assertEquals(changePasswordPage.readNewPassword(), mismatchPassword1,
				"New Password field (Password mismatch):");
		softAsserter.assertEquals(changePasswordPage.readConfirmPassword(), mismatchPassword2,
				"Confirm Password field (Password mismatch):");

		// Click Save to receive error message
		changePasswordPage.clickChangePassword();

		softAsserter.assertTrue(
				changePasswordPage.isErrorMessagePresent("The new password and confirmation password do not match."));

		// Clear fields for next test
		changePasswordPage.clearCurrentPassword();
		changePasswordPage.clearNewPassword();
		changePasswordPage.clearConfirmPassword();

		softAsserter.assertEquals(changePasswordPage.readCurrentPassword(), "",
				"Original Password field - (Password mismatch) Cleared:");
		softAsserter.assertEquals(changePasswordPage.readNewPassword(), "",
				"New Password field - (Password mismatch) Cleared:");
		softAsserter.assertEquals(changePasswordPage.readConfirmPassword(), "",
				"Confirm Password field - (Password mismatch) Cleared:");

		// ***END TESTS

		// Catch and print errors
		softAsserter.assertAll();

		// Validate we are on the Change Password page. Ensures a password did
		// not save.
		String pageTitle = utilities.AutomationHelper.getPageTitle();
		Assert.assertEquals(pageTitle, "Change Password - Team Fitness Tracker",
				"Change Password Page not found. Instead found page with title " + pageTitle);
	}

	/**
	 * Method to try an incorrect original password and assert error.
	 */
	private void validateExistingPasswordIsEntered() {
		AutomationHelper.printMethodName();

		// Strings for mismatched password
		String notOriginalPassword = "NotThe0riginalP@ss";
		String updatedPassword = "NewP@ssword123";

		// ***TESTS***
		// Perform Sets
		ChangePasswordPageFactory changePasswordPage = new ChangePasswordPageFactory();
		changePasswordPage.setCurrentPassword(notOriginalPassword);
		changePasswordPage.setNewPassword(updatedPassword);
		changePasswordPage.setConfirmPassword(updatedPassword);
		// Perform reads
		softAsserter.assertEquals(changePasswordPage.readCurrentPassword(), notOriginalPassword,
				"Original Password field (Incorrect Original Password):");
		softAsserter.assertEquals(changePasswordPage.readNewPassword(), updatedPassword,
				"New Password field (Incorrect Original Password):");
		softAsserter.assertEquals(changePasswordPage.readConfirmPassword(), updatedPassword,
				"Confirm Password field (Incorrect Original Password):");

		// Click Save to receive error message
		changePasswordPage.clickChangePassword();

		softAsserter.assertTrue(changePasswordPage.isErrorMessagePresent("Incorrect password."));

		// Clear fields for next test
		changePasswordPage.clearCurrentPassword();
		changePasswordPage.clearNewPassword();
		changePasswordPage.clearConfirmPassword();

		softAsserter.assertEquals(changePasswordPage.readCurrentPassword(), "",
				"Original Password field - (Incorrect Original Password) Cleared:");
		softAsserter.assertEquals(changePasswordPage.readNewPassword(), "",
				"New Password field - (Incorrect Original Password) Cleared:");
		softAsserter.assertEquals(changePasswordPage.readConfirmPassword(), "",
				"Confirm Password field - (Incorrect Original Password) Cleared:");

		// ***END TESTS

		// Catch and print errors
		softAsserter.assertAll();

		// Validate we are on the Change Password page. Ensures a password did
		// not save.
		String pageTitle = utilities.AutomationHelper.getPageTitle();
		Assert.assertEquals(pageTitle, "Change Password - Team Fitness Tracker",
				"Change Password Page not found. Instead found page with title " + pageTitle);

	}

	/**
	 * Method to change password and log out - then log back in and validate
	 */
	private void changePasswordAndValidateSave() {
		AutomationHelper.printMethodName();

		// Strings for updated password
		newPassword = "P@ssword1";

		Reporter.log("Password changing from " + originalPassword + " to " + newPassword, true);

		// ***TESTS***
		// Perform Sets
		ChangePasswordPageFactory changePasswordPage = new ChangePasswordPageFactory();
		changePasswordPage.setCurrentPassword(originalPassword);
		changePasswordPage.setNewPassword(newPassword);
		changePasswordPage.setConfirmPassword(newPassword);
		// Perform reads
		softAsserter.assertEquals(changePasswordPage.readCurrentPassword(), originalPassword,
				"Original Password field (Change password):");
		softAsserter.assertEquals(changePasswordPage.readNewPassword(), newPassword,
				"New Password field (Change password):");
		softAsserter.assertEquals(changePasswordPage.readConfirmPassword(), newPassword,
				"Confirm Password field (Change password):");

		// Click Save to receive error message
		changePasswordPage.clickChangePassword();

		/*
		 * MANAGE PAGE
		 */
		// The password is changed and we land on the Team Fitness Tracker page
		// with a success
		// message

		ManagePageFactory managePage = new ManagePageFactory();
		softAsserter.assertEquals(managePage.readSuccessMessage(), "Your password has been changed.",
				"Success Message on Manage Page:");

		// Write the new password to the datasheet
		excelFile.writeToWorkSheet(rowIndex, excelFile.getColumnIndex("Password"), newPassword);

		String pageTitle = utilities.AutomationHelper.getPageTitle();
		Assert.assertEquals(pageTitle, "Change Password Success - Team Fitness Tracker",
				"Manage Page not found. Instead found page with title " + pageTitle);

		MenusPageFactory menus = new MenusPageFactory();
		menus.clickLogOffLink();

		/*
		 * END MANAGE PAGE
		 */

		// Ensure we land back on the Home page after logging out.
		pageTitle = utilities.AutomationHelper.getPageTitle();
		Assert.assertEquals(pageTitle, "Team Fitness Tracker - Team Fitness Tracker",
				"Home Page not found. Instead found page with title " + pageTitle);

		// Catch and print errors
		softAsserter.assertAll();
	}

	/**
	 * Method to change password back to original
	 */
	private void changePasswordBackToOriginal() {
		AutomationHelper.printMethodName();

		// ***TESTS***

		// Log back in with new password
		MenusPageFactory menus = new MenusPageFactory();
		menus.clickLoginLink();

		// Ensure we land on Login page.
		String pageTitle = utilities.AutomationHelper.getPageTitle();
		Assert.assertEquals(pageTitle, "Login - Team Fitness Tracker",
				"Login Page not found. Instead found page with title " + pageTitle);

		// Type login credentials with NEW password
		LoginAsExistingUserMod loginScript = new LoginAsExistingUserMod();
		loginScript.loginAsUser(userName, newPassword, excelFile);

		// Validate greeting name
		softAsserter.assertEquals(menus.readGreetingName(), displayName, "Display Name in Menu:");

		// Navigate back to the Change Password page.
		menus.clickChangePassword();

		// Ensure we landed on the Change Password page.
		pageTitle = utilities.AutomationHelper.getPageTitle();
		Assert.assertEquals(pageTitle, "Change Password - Team Fitness Tracker",
				"Change Password Page not found. Instead found page with title " + pageTitle);

		// Perform sets to change original password back.
		ChangePasswordPageFactory changePasswordPage = new ChangePasswordPageFactory();
		changePasswordPage.setCurrentPassword(newPassword);
		changePasswordPage.setNewPassword(originalPassword);
		changePasswordPage.setConfirmPassword(originalPassword);

		// Perform reads
		softAsserter.assertEquals(changePasswordPage.readCurrentPassword(), newPassword,
				"Original Password field (Change back to original):");
		softAsserter.assertEquals(changePasswordPage.readNewPassword(), originalPassword,
				"New Password field (Change back to original):");
		softAsserter.assertEquals(changePasswordPage.readConfirmPassword(), originalPassword,
				"Confirm Password field (Change back to original):");

		// Click Save to receive error message
		changePasswordPage.clickChangePassword();

		/*
		 * MANAGE PAGE
		 */

		// Write the new password to the datasheet
		excelFile.writeToWorkSheet(rowIndex, excelFile.getColumnIndex("Password"), originalPassword);

		// The password is changed and we land on the Team Fitness Tracker page
		// with a success
		// message
		pageTitle = utilities.AutomationHelper.getPageTitle();
		Assert.assertEquals(pageTitle, "Change Password Success - Team Fitness Tracker",
				"Team Fitness Tracker Page not found. Instead found page with title " + pageTitle);

		ManagePageFactory managePage = new ManagePageFactory();
		softAsserter.assertEquals(managePage.readSuccessMessage(), "Your password has been changed.",
				"Success Message on Manage Page:");

		menus.clickLogOffLink();

		/*
		 * END MANAGE PAGE
		 */

		// Ensure we land back on the Team Fitness Tracker page after logging out.
		pageTitle = utilities.AutomationHelper.getPageTitle();
		Assert.assertEquals(pageTitle, "Team Fitness Tracker - Team Fitness Tracker",
				"Home Page not found. Instead found page with title " + pageTitle);

		// Catch and print errors
		softAsserter.assertAll();

	}

}
