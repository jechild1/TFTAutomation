package modularScripts;

import org.openqa.selenium.JavascriptExecutor;

import configuration.TFTConfig;
import pageFactories.GarminAccountRegistrationPageFactory;
import utilities.ExcelDataConfig;

/**
 * 
 * @author jesse.childress
 *
 */
public class GarminConnectAccountCreationMod extends TFTConfig {

	GarminAccountRegistrationPageFactory garminAcctCreation = new GarminAccountRegistrationPageFactory();

	// Garmin Connect URL
	public final String garminConnectURL = "https://connect.garmin.com/en-US/signin";

	//Launches a new Garmin Connect window.
	public void launchGarminConnectWindow() {

		((JavascriptExecutor) driver).executeScript("window.open(arguments[0])", garminConnectURL);
	}

	private void switchToSignInIframe() {
		driver.switchTo().frame("gauth-widget-frame-gauth-widget");
	}

	private void switchToCompleteFieldsIframe() {
		driver.switchTo().frame("popup-iframe-id");
	}

	/**
	 * Method to handle creating a new Garmin Connect account.
	 * 
	 * @param excelFile
	 * @param workSheetName
	 * @param userName
	 * @param password
	 * @param garminConnectWindowHandle
	 */
	public void createAccount(ExcelDataConfig excelFile, String workSheetName, String userName, String password,
			String garminConnectWindowHandle) {

		// Set up variables
		String fullName = excelFile.getData(excelFile.getRowIndex("UserName", userName),
				excelFile.getColumnIndex("FirstName")) + " "
				+ excelFile.getData(excelFile.getRowIndex("UserName", userName), excelFile.getColumnIndex("LastName"));

		String email = excelFile.getData(excelFile.getRowIndex("UserName", userName),
				excelFile.getColumnIndex("Email"));

		// System.out.println(fullName + " " + email);
		
		//TODO - if failure, switch back...
//		switchToSignInIframe();
		setDriverToFrameByID("gauth-widget-frame-gauth-widget");

		garminAcctCreation.clickCreateOneLink();

		// This takes you out of the IFrame back into page.
		driver.switchTo().defaultContent();

		switchToCompleteFieldsIframe();

		garminAcctCreation.setFullName(fullName);
		garminAcctCreation.setEmailAddress(email);
		garminAcctCreation.setPassword(password);
		garminAcctCreation.setRetypePassword(password);
		garminAcctCreation.setProductNewsAndPromotionsCheckbox(false);
		garminAcctCreation.setTermsOfUseCheckbox(true);
		garminAcctCreation.setConfirmAgeCheckbox(true);

		garminAcctCreation.clickCreateAccountButton();

		// TODO - section for creating dashboard

		driver.switchTo().defaultContent();

	}

}
