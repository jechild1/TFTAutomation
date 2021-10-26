package testCases.Archived;

import static org.testng.Assert.assertEquals;

import javax.imageio.IIOException;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import configuration.TFTConfig;
import modularScripts.DeviceRegistrationMod;
import modularScripts.LoginMod;
import pageFactories.DeviceRegistrationPageFactory;
import pageFactories.HomePageFactory;
import pageFactories.MenusPageFactory;
import utilities.AutomationHelper;
import utilities.ExcelDataConfig;

public class DeviceRegistration extends TFTConfig {

	String excelFilePath = generateFullFileNameAndPath("UsersData.xlsx");
	String excelWorksheetName = "ChildressCalorieCrushers";
	ExcelDataConfig excelFile = new ExcelDataConfig(excelFilePath,
			excelWorksheetName);

	String deviceType;
	String userName;
	String password;

	@DataProvider(name = "userNamePassword")
	private String[][] getAccount() {

		// String[][] userNamePassCombo = { { "Hamburgler",
		// "ste@lThemBurgerz100" } };
		// String[][] userNamePassCombo = { { "ChadArnold", "P@ssword1" } };
		// String[][] userNamePassCombo = { { "kennychildress", "P@ssword1" } };
		// String[][] userNamePassCombo = { { "HokieBird", "b!rdBr@1n" } };
		// String[][] userNamePassCombo = { { "TomBrady715", "TomBrady#100" } };
		// String[][] userNamePassCombo = { { "Mr. Pine Cone", "P!neC0ne" } };

		String[][] userNamePassCombo = new String[][]{
				{TEAM_MEMBER_USERNAME, TEAM_MEMBER_PASSWORD}};
		deviceType = excelFile.getData(
				excelFile.getRowIndex("UserName", userNamePassCombo[0][0]),
				excelFile.getColumnIndex("DeviceType"));

		return userNamePassCombo;

	}

	@AfterClass
	private void afterClass() {
		AutomationHelper.finishTest();
	}

	@Test(dataProvider = "userNamePassword")
	protected void login(String userName) {
		AutomationHelper.printMethodName();

		// Log in with a user
		LoginMod login = new LoginMod();

		login.execute("jessec");

		// Set the class level variable here as to be used in passing up to the
		// modular.
		this.userName = userName;
		this.password = password;
	}

	// Perform "deregistration" if needed
	/**
	 * This method checks to see if a user is already registered with the device
	 * type that is marked in their datasheet. If so, we de-register them so
	 * that they can be re-registered.
	 */
	@Test(dependsOnMethods = "login")
	public void performDeregistration() {
		AutomationHelper.printMethodName();
		// Page Factories
		DeviceRegistrationPageFactory deviceRegistrationPF = new DeviceRegistrationPageFactory();
		MenusPageFactory menus = new MenusPageFactory();
		HomePageFactory homePage = new HomePageFactory();

		// Ensure we are on the Device Registration page, if not already loaded
		if (readPageTitle()
				.equals("Team Fitness Tracker - Team Fitness Tracker")) {
			menus.clickRegisterDevice();
		}

		// Grab the value of the device type column from the dataset
		deviceType = excelFile.getData(
				excelFile.getRowIndex("UserName", userName),
				excelFile.getColumnIndex("DeviceType"));

		// Grab the value of the Device Registered column from the dataset.
		boolean deviceRegistered = Boolean.valueOf(
				excelFile.getData(excelFile.getRowIndex("UserName", userName),
						excelFile.getColumnIndex("DeviceRegistered")));

		// If the device is a Fitbit and we have already registered it, then we
		// want to
		// unregister it, and set the datasheet back to FALSE. This is just to
		// test the
		// process.
		if (deviceType.equalsIgnoreCase("Fitbit") && deviceRegistered == true
				&& deviceRegistrationPF.readFitbitRegisteredStatus()
						.equalsIgnoreCase("Registered")) {
			Reporter.log("Deregistering Fitbit", true);

			deviceRegistrationPF.clickDeregisterForFitbit();

			// Assert that the "Button" us updated to "Not Registered"
			assertEquals(deviceRegistrationPF.readFitbitRegisteredStatus(),
					"Not Registered", "Fitbit Registered Status:");

			// Update the datasheet to FALSE since we just deregistered
			excelFile.setColumnHeaderKey("UserName");
			excelFile.writeToWorkSheet(userName, "DeviceRegistered", "FALSE");

		}

		// If the device is a Garmin and we have already registered it, then we
		// want to
		// unregister it, and set the datasheet back to FALSE. This is just to
		// test the
		// process.
		else if (deviceType.equalsIgnoreCase("Garmin")
				&& deviceRegistered == true
				&& deviceRegistrationPF.readGarminConnectRegisteredStatus()
						.equalsIgnoreCase("Registered")) {
			Reporter.log("Deregistering Gamin Connect", true);
			// Deregister the device
			deviceRegistrationPF.clickDeregisterForGarminConnect();

			// Assert that the "Button" us updated to "Not Registered"
			assertEquals(
					deviceRegistrationPF.readGarminConnectRegisteredStatus(),
					"Not Registered", "Garmin Connect Registered Status:");

			// Update the datasheet to FALSE.
			excelFile.writeToWorkSheet(
					excelFile.getRowIndex("UserName", userName),
					excelFile.getColumnIndex("DeviceRegistered"), "FALSE");

			// Navigate back to the Home page and ensure that we need to
			// re-register
			menus.clickHomeLink();

			// Validate the error message
			assertEquals(homePage.readErrorHeader(), "Device Registration",
					"Home Page: Device Registration Header:");
			assertEquals(homePage.readErrorBody(),
					"Please complete Device Registration process to view your activity data. Please click here to to start the process.",
					"Home Page: Device Registration Body Text:");

			// Go back to the Device Registration page
			menus.clickRegisterDevice();
		} else {
			Reporter.log(
					"Deregistration not needed. User was not registered to either Fitbit or Garmin",
					true);
		}

	}

	// Determine if we have a FITBIT or GARMIN registration
	/**
	 * This method performs a registration for a user. If the user has a device
	 * type of Fitbit, we are taken to Fitbit and we add a new account.
	 * Likewise, if Garmin Connect, we create a new garmin connect account as
	 * outlined with the data in the datasheet.
	 */
	@Test(dependsOnMethods = "performDeregistration")
	public void performRegistration() {
		AutomationHelper.printMethodName();

		// Page Factories
		DeviceRegistrationMod deviceRegistration = new DeviceRegistrationMod();
		MenusPageFactory menus = new MenusPageFactory();

		// Ensure we are on the Device Registration page, if not already loaded
		if (readPageTitle()
				.equals("Team Fitness Tracker - Team Fitness Tracker")) {
			menus.clickRegisterDevice();
		}

		// Check to see if this is a Fitbit or Garmin
		if (deviceType.equalsIgnoreCase("Fitbit")) {
			deviceRegistration.fitbitRegistration(excelFile, excelWorksheetName,
					userName, password);

		} else if (deviceType.equals("Garmin")) {
			deviceRegistration.garminConnectRegistration(excelFile,
					excelWorksheetName, userName, password);

		} else {
			try {
				throw new IIOException(
						"Expected a device type of Fitbit or Garmin. This was not found in the datasheet.");
			} catch (IIOException e) {
				e.printStackTrace();
			}
		}
	}

}
