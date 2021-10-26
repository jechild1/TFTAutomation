package modularScripts;

import configuration.TFTConfig;
import pageFactories.HomePageFactory;
import pageFactories.LoginPageFactory;
import pageFactories.MenusPageFactory;
import testCases.Archived.DeviceRegistration;
import utilities.AutomationHelper;
import utilities.ExcelDataConfig;

public class LoginAsExistingUserMod extends TFTConfig {

	WarningAndConsentBannerMod usgWarningAndConsent;
	

	/**
	 * Constructor takes in a driver from the calling script
	 */
	public LoginAsExistingUserMod() {
		usgWarningAndConsent = new WarningAndConsentBannerMod();

	}

	/**
	 * Method takes in a user name and password and logs in. Checks for page
	 * confirmation.
	 * 
	 * @param userName
	 * @param password
	 * @param excelFile
	 */
	public void loginAsUser(String userName, String password, ExcelDataConfig excelFile) {
		AutomationHelper.printClassName();
		AutomationHelper.printMethodName();

		/*
		 * Before logging in, we must validate the USG Warning & Consent banner
		 * and close it.
		 */
		usgWarningAndConsent.validateAndCloseUSGWarningsAndConsentPopup();


		/*
		 * Logging into the system.
		 */
//		MenusPageFactory menus = new MenusPageFactory();
//		menus.clickLoginLink();
		
		HomePageFactory homePage = new HomePageFactory();
		homePage.clickLoginLink();


		// Validate we are on the login page.
		AutomationHelper.checkPageTitlePresent("Login - Team Fitness Tracker");

		LoginPageFactory loginPage = new LoginPageFactory();

		// Set fields
		loginPage.setUserName(userName);
		loginPage.setPassword(password);

		// Validate fields
		softAsserter.assertEquals(loginPage.readUserName(), userName, "User Name Field:");
		softAsserter.assertEquals(loginPage.readPassword(), password, "Password Field:");

		// Catch and print errors
		softAsserter.assertAll();

		// Click Login to proceed
		loginPage.clickLoginButton();

		// Wait for login to complete, up to 30 seconds.
		AutomationHelper.waitForPageToLoad(30);
		

		/*
		 * If a user has not registered their device, they will be pointed to
		 * the Device Registration page. When this situation occurs, Validate
		 * that we are on the Device Registration page, but then navigate back
		 * home
		 */
		// Check to see which page we landed on. If were on the Home page, do
		// nothing. If we land on the Device Registration page, call the modular
		// script to determine if we want to register a device for the user
		//TODO - Implement the below method when Device Registration is finished
//		if (AutomationHelper.getPageTitle().equals("Device Registration - Team Fitness Tracker")) {
//			// Call Device Registration modular script
//			DeviceRegistration deviceRegistration = new DeviceRegistration();
//			deviceRegistration.performRegistration();
//		}
	}
	
	//TODO - Most likely the method below will not be used.

//	/**
//	 * This method logs in as an administrator. Places the administrator
//	 * credentials inside the method so that it can be changed in one place
//	 * instead of multiple classes.
//	 * 
//	 * @param excelFile
//	 *            TODO
//	 */
//	public void loginAsAdmin(ExcelDataConfig excelFile) {
//		AutomationHelper.printClassName();
//		AutomationHelper.printMethodName();
//
//		/*
//		 * Before logging in, we must validate the USG Warning & Consent banner
//		 * and close it.
//		 */
//
//		usgWarningAndConsent.validateAndCloseUSGWarningsAndConsentPopup();
//
//		// Validate we are on the login page.
//		AutomationHelper.checkPageTitlePresent("Home Page - Team Fitness Tracker");
//
//		LoginPageFactory loginPage = new LoginPageFactory();
//
//		// ***TESTS***
//		// Admin Credentials
//		String userName = "jessec";
//		String password = "P@ssword1";
//		// Set fields
//		loginPage.setUserName(userName);
//		loginPage.setPassword(password);
//
//		// Validate fields
//		softAsserter.assertEquals(loginPage.readUserName(), userName, "User Name Field:");
//		softAsserter.assertEquals(loginPage.readPassword(), password, "Password Field:");
//
//		// ***END TESTS***
//
//		// Catch and print errors
//		softAsserter.assertAll();
//
//		// Click Login to proceed
//		loginPage.clickLoginButton();
//
//		// Wait for login to complete, up to 30 seconds.
//		AutomationHelper.waitForPageToLoad(30);
//
//		/*
//		 * If a user has not registered their device, they will be pointed to
//		 * the Device Registration page. When this situation occurs, Validate
//		 * that we are on the Device Registration page, but then navigate back
//		 * home
//		 */
//		// Check to see which page we landed on. If were on the Home page, do
//		// nothing. If we land on the Device Registration page, call the modular
//		// script to determine if we want to register a device for the user
//		if (AutomationHelper.getPageTitle().equals("Device Registration - Team Fitness Tracker")) {
//			// Call Device Registration modular script
////			DeviceRegistrationMod deviceRegistration = new DeviceRegistrationMod();
////			deviceRegistration.registerDevice(userName, password, excelFile);
//			
//			DeviceRegistration deviceRegistration = new DeviceRegistration();
//			deviceRegistration.performRegistration();
//		}
//	}
}
