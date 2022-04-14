package modularScripts;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;

import configuration.TFTConfig;
import pageFactories.DeviceRegistrationPageFactory;
import pageFactories.FitbitRegistrationPageFactory;
import pageFactories.GarminConnectPageFactory;
import pageFactories.HomePageFactory;
import pageFactories.MenusPageFactory;
import utilities.AutomationHelper;
import utilities.ExcelDataConfig;

/**
 * Modular script to perform the action of registering a device for a user. If a
 * user finds himself on the Device Registration page after logging in, this
 * script will: (1) Confirm with the datasheet that the user has NOT registered
 * the device. (2) Determine which device the user has from the datasheet, e.g.
 * Garmin, Fitbit, Jawbone (3) Call a script for the third party sites to create
 * an account and perform registration. (3)****************COME BACK
 * 
 * @author jesse.childress
 *
 */
public class DeviceRegistrationMod extends TFTConfig {

	/**
	 * This method accepts a number of arguments and either (a) re-registers a user
	 * or (b) creates a new Fitbit account for the user by leaving TFT, creating an
	 * account, and then returning to TFT with the newly created account.
	 * 
	 * @param excelFile
	 * @param worksheetName
	 * @param userName
	 * @param password
	 */
	public void fitbitRegistration(ExcelDataConfig excelFile, String worksheetName, String userName, String password) {
		AutomationHelper.printClassName();
		AutomationHelper.printMethodName();
		excelFile.setColumnHeaderKey("UserName");


		// It may be that we land on the Device Registration page, but if not, we need
		// to navigate there anyway.
		MenusPageFactory menus = new MenusPageFactory();
		menus.clickRegisterDevice();

		DeviceRegistrationPageFactory registration = new DeviceRegistrationPageFactory();

		// Ensure that the device is not already registered.
		if (registration.readFitbitRegisteredStatus().equals("Registered")) {
			// TODO
			throw new InvalidElementStateException("The device has already been registered.");
		}

		// On the FITBIT Login page
		registration.clickRegisterForFitbit();
		assertEquals(AutomationHelper.getPageTitle(), "Fitbit Login", "Fitbit page title: ");

		// Gather variables for use on Fitbit page
		String email = excelFile.getData(excelFile.getRowIndex("UserName", userName),
				excelFile.getColumnIndex("Email"));
		// String password comes in parameters of methods. No need to get
		String firstName = excelFile.getData(excelFile.getRowIndex("UserName", userName),
				excelFile.getColumnIndex("FirstName"));
		String lastName = excelFile.getData(excelFile.getRowIndex("UserName", userName),
				excelFile.getColumnIndex("LastName"));
		String gender = excelFile.getData(excelFile.getRowIndex("UserName", userName),
				excelFile.getColumnIndex("Gender"));
		String birthMonth = excelFile.getData(excelFile.getRowIndex("UserName", userName),
				excelFile.getColumnIndex("BirthMonth"));
		String birthDay = excelFile.getData(excelFile.getRowIndex("UserName", userName),
				excelFile.getColumnIndex("BirthDay"));
		String birthYear = excelFile.getData(excelFile.getRowIndex("UserName", userName),
				excelFile.getColumnIndex("BirthYear"));
		String heightFeet = excelFile.getData(excelFile.getRowIndex("UserName", userName),
				excelFile.getColumnIndex("HeightFeet"));
		String heightInches = excelFile.getData(excelFile.getRowIndex("UserName", userName),
				excelFile.getColumnIndex("HeightInches"));
		String weight = excelFile.getData(excelFile.getRowIndex("UserName", userName),
				excelFile.getColumnIndex("Weight"));

		/*
		 * ATTEMPT PREVIOUS REGISTRATION BY ENTERING EMAIL AND PASSWORD AND CLICKING
		 * LOGIN.
		 */

		FitbitRegistrationPageFactory fitbitRegistration = new FitbitRegistrationPageFactory();

		// NOTE: There were significant issues in getting the fields to set due to the
		// design of the Fitbit site. Had to do a "Hack" with robot.

		try {
			Robot bot = new Robot();
			driver.switchTo().activeElement().sendKeys(email);
			AutomationHelper.waitSeconds(1);
			bot.keyPress(KeyEvent.VK_TAB);
			bot.keyRelease(KeyEvent.VK_TAB);

			driver.switchTo().activeElement().sendKeys(password);
			AutomationHelper.waitSeconds(1);

			fitbitRegistration.setRememberMeCheckbox(false);
			// Tabs to "Forgot Password" link
			bot.keyPress(KeyEvent.VK_TAB);
			bot.keyRelease(KeyEvent.VK_TAB);
			// Tabs to Log In button
			bot.keyPress(KeyEvent.VK_TAB);
			bot.keyRelease(KeyEvent.VK_TAB);
			// Hits Enter on button
			bot.keyPress(KeyEvent.VK_ENTER);
			bot.keyRelease(KeyEvent.VK_ENTER);

			AutomationHelper.waitForPageToLoad(NORMAL_TIMEOUT);

		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// If we have an error present, we know that the user has not been registered
		// before and we need an account (this is assuming our data is 100% legit). At
		// this point, we should follow the process to create a new account if we have
		// an error. Else, we are returned to the TFT Device Registration page.

		if (fitbitRegistration.isValidationErrorPresent()) {
			System.out.println("ERROR PRESENT: " + fitbitRegistration.isValidationErrorPresent());
			// Sign up for a free account
			// TODO - This is opening up in same window and losing focus to TFT, never
			// returning. Opening in new window.
			// fitbitRegistration.clickFreeAccountLink();

			// Grab the handle of the current window (Fitbit Login)
			String originalWindowHandle = driver.getWindowHandle();

			WebElement freeAccountLink = driver.findElement(By.linkText("free account"));
			Actions action = new Actions(driver);
			action.keyDown(Keys.SHIFT).click(freeAccountLink).keyUp(Keys.SHIFT).build().perform();

			// Switch to the new window
			// Make sure to switch to the Garmin Connect window.
			ArrayList<String> tabHandles = new ArrayList<String>(driver.getWindowHandles());
			for (String handle : tabHandles) {
				if (!handle.equals(originalWindowHandle)) {
					driver.switchTo().window(handle);
				}
			}

			// Set email & password
			fitbitRegistration.setEmail(email);

			fitbitRegistration.setPassword(password);
			// Set checkboxes
			fitbitRegistration.setFitbitTermsOfServiceCheckbox(true);
			fitbitRegistration.setKeepMeUpdatedCheckbox(false);
			// Click continue
			fitbitRegistration.clickContinue();

			// Tell us about yourself section
			fitbitRegistration.setFirstName(firstName);
			fitbitRegistration.setLastName(lastName);
			fitbitRegistration.selectGender(gender);
			fitbitRegistration.setBirthMonth(birthMonth);
			fitbitRegistration.setBirthDay(birthDay);
			fitbitRegistration.setBirthYear(birthYear);
			fitbitRegistration.setHeightFeet(heightFeet);
			fitbitRegistration.setHeightInches(heightInches);
			fitbitRegistration.setWeight(weight);

			// Save the profile
			fitbitRegistration.clickSaveProfile();
			driver.close();

			// Fitbit page loaded now. Switch back to original window. Attempt to enter
			// newly created account data.
			driver.switchTo().window(originalWindowHandle);

			// NOTE: There were significant issues in getting the fields to set due to the
			// design of the Fitbit site. Had to do a "Hack" with robot.

			// Oddly enough, clicking "Back" after registering is all we need to get to teh
			// App Authroization page. Forcing the values were problematic as the window
			// didn't have focus.

			driver.navigate().back();
			AutomationHelper.waitForPageToLoad(NORMAL_TIMEOUT);

			// Ensure we are on the "App Authorization" page
			AutomationHelper.checkPageTitlePresent("App Authorization");

			// Click the "Select All" checkbox
			fitbitRegistration.setSelectAllCheckbox(true);

			// Click "Allow" button
			fitbitRegistration.clickAllow();

			// Write to the datasheet
			excelFile.writeToWorkSheet(userName, "DeviceRegistered", "TRUE");
			// Check that we are registered.
			verifyRegisteredDeviceRegistrationPageContent("Fitbit");

			// Navigate back to Dashboard to ensure we have a dashboard
			menus.clickHomeLink();

			// Not part of any team
			AutomationHelper.checkPageTitlePresent("Team Fitness Tracker - Team Fitness Tracker");
			HomePageFactory home = new HomePageFactory();
			assertEquals(home.readErrorHeader(), "Not a Part of Any Team", "Error Header Text:");
			assertEquals(home.readErrorBody(),
					"You are not a part of any team. Please contact your administrator to add you to a team.",
					"Error Body Text:");

		}

		// Else if no errors were present on the initial sign in attempt, we know we
		// have an account and can proceed.
		else {
			fitbitRegistration.setSelectAllCheckbox(true);
			fitbitRegistration.clickAllow();

			// Write to the datasheet
			excelFile.writeToWorkSheet( userName, "DeviceRegistered", "TRUE");
			// Check that we are registered.
			verifyRegisteredDeviceRegistrationPageContent("Fitbit");

			// Navigate back to Dashboard to ensure we have a dashboard
			menus.clickHomeLink();

			// Not part of any team
			AutomationHelper.checkPageTitlePresent("Team Fitness Tracker - Team Fitness Tracker");
			HomePageFactory home = new HomePageFactory();
			assertTrue(
					home.readErrorHeader().equals("Not a Part of Any Team") || home.readErrorHeader().equals("Today"),
					"Page Title Assertion: ");

			if (home.readErrorHeader().equals("Not a part of Any Team")) {
				assertEquals(home.readErrorBody(),
						"You are not a part of any team. Please contact your administrator to add you to a team.",
						"Error Body Text:");

			}
		}

	}

	/**
	 * This method accepts a number of arguments and either (a) re-registers a user
	 * or (b) creates a new Garmin Connect account for the user by leaving TFT,
	 * creating an account, and then returning to TFT with the newly created
	 * account.
	 * 
	 * @param excelFile
	 * @param worksheetName
	 * @param userName
	 * @param password
	 */
	public void garminConnectRegistration(ExcelDataConfig excelFile, String worksheetName, String userName,
			String password) {
		AutomationHelper.printClassName();
		AutomationHelper.printMethodName();

		// It may be that we land on the Device Registration page, but if not, we need
		// to navigate there anyway.
		MenusPageFactory menus = new MenusPageFactory();
		if (!AutomationHelper.getPageTitle().equals("Device Registration - Team Fitness Tracker")) {
			menus.clickRegisterDevice();
		}

		// Instantiate a new Device Registration page
		DeviceRegistrationPageFactory deviceRegistrationPage = new DeviceRegistrationPageFactory();

		// Click the Register link
		deviceRegistrationPage.clickGarminRegisterLink();

		/*
		 * Garmin Connect - mCare site loaded
		 */

		// Store the original TFT / Garmin Connect mCare site window so we can switch
		// back later, if needed.
		String originalTFTWindow = driver.getWindowHandle();

		// Attempt to enter email and password for existing account first. If we get an
		// error message on the page, we know we need to attempt to register this user.
		// If not, sign in and proceed.
		GarminConnectPageFactory garminConnectPF = new GarminConnectPageFactory();
		String email = excelFile.getData(excelFile.getRowIndex("UserName", userName),
				excelFile.getColumnIndex("Email"));

		Reporter.log("Switching to Garmin Connect window", true);
		garminConnectPF.switchToSignInIframe();
		garminConnectPF.setEmail(email);
		garminConnectPF.setPassword(password);
		garminConnectPF.setRememberMeCheckbox(false);
		garminConnectPF.clickSignIn();

		// If there is any type of error present, we should try to register this user.
		// This assumes our data is correct
		if (garminConnectPF.isErrorStatusPresent() || garminConnectPF.isEmailErrorPresent()
				|| garminConnectPF.isPasswordErrorPresent()) {

			Reporter.log("Errors found on attempted Garmin login. Attempting Garmin Connect registration.", true);

			/*
			 * Launch a new window for creating a new Garmin Account. This window is called
			 * Garmin Connect: Sign In.
			 *
			 */

			// Method to launch a new tab for the Garmin Connect window. This is the window
			// that we will need to register with.

			GarminConnectAccountCreationMod garminConnectAccountCreation = new GarminConnectAccountCreationMod();
			garminConnectAccountCreation.launchGarminConnectWindow();
			AutomationHelper.waitForPageToLoad(NORMAL_TIMEOUT);

			// Make sure to switch to the Garmin Connect window.
			ArrayList<String> tabHandles = new ArrayList<String>(driver.getWindowHandles());
			for (String handle : tabHandles) {
				driver.switchTo().window(handle);

				if (driver.getTitle().equalsIgnoreCase("Garmin Connect: Sign In")) {
					break;
				}
			}

			// New handle for the Account Create window
			String garminAccountSignInWindow = driver.getWindowHandle();

			garminConnectAccountCreation.createAccount(excelFile, worksheetName, userName, password,
					garminAccountSignInWindow);

			AutomationHelper.waitSeconds(3);

			driver.switchTo().window(originalTFTWindow);
			driver.switchTo().defaultContent();

			// There is an iFrame within the
			garminConnectPF.switchToSignInIframe();
			Reporter.log("Attempting to login to Garmin Connect after registering on site.", true);
			garminConnectPF.clearEmail();
			garminConnectPF.setEmail(email);
			garminConnectPF.clearPassword();
			garminConnectPF.setPassword(password);
			garminConnectPF.setRememberMeCheckbox(false);
			garminConnectPF.clickSignIn();

		}

		// On the original page, click I Consent.
		driver.switchTo().window(originalTFTWindow);
		driver.switchTo().defaultContent();
		garminConnectPF.clickIConsent();

		assertEquals(deviceRegistrationPage.readGarminConnectRegisteredStatus(), "Registered",
				"Device Registration - Garmin Connect: ");

		excelFile.writeToWorkSheet(userName, "DeviceRegistered", "TRUE");

		menus.clickHomeLink();
		assertEquals(AutomationHelper.getPageTitle(), "Team Fitness Tracker - Team Fitness Tracker");

	}

	/**
	 * Method to check the status of a page for an unregistered user.
	 * 
	 * @param deviceType
	 */
	private void verifyRegisteredDeviceRegistrationPageContent(String deviceType) {
		AutomationHelper.printMethodName();
		DeviceRegistrationPageFactory registration = new DeviceRegistrationPageFactory();
		softAsserter.assertEquals(registration.readPageHeader(), "Device Registration", "Page Header Assert");

		if (deviceType.equals("Fitbit")) {
			softAsserter.assertEquals(registration.readFitbitRegisteredStatus(), "Registered",
					"Fitbit Registration Status");
		} else {

			softAsserter.assertEquals(registration.readGarminConnectRegisteredStatus(), "Not Registered",
					"Garmin Connect Registration Status");
		}

		softAsserter.assertAll();
	}

}
