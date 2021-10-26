package modularScripts;

import org.testng.Assert;
import org.testng.Reporter;

import configuration.TFTConfig;
import pageFactories.HomePageFactory;
import pageFactories.LoginPageFactory;
import pageFactories.MenusPageFactory;
import pageFactories.WarningAndConsentBannerPageFactory;
import utilities.AutomationHelper;
import utilities.ExcelDataConfig;

public class LoginMod extends TFTConfig {

	/**
	 * Constructor takes in a driver from the calling script
	 */
	public LoginMod() {
	}

	/**
	 * Modular Script to login to an application from the main page.
	 * 
	 * @param userName
	 */
	public void execute(String userName) {

		AutomationHelper.printClassName();
		AutomationHelper.printMethodName();

		ExcelDataConfig ud = getExcelFile("UsersData.xlsx", "UserAccounts");

		// using UserName instead of default as column key
		ud.setColumnHeaderKey("UserName");
		String password = ud.getData(userName, "Password");
		String role = ud.getData(userName, "Role");

		Reporter.log("Logging in with User Name: " + userName
				+ " who is of role type: " + role, true);

		WarningAndConsentBannerPageFactory usgWarningsAndConsent = new WarningAndConsentBannerPageFactory();
		usgWarningsAndConsent.loadPage();
		usgWarningsAndConsent.validateUSGModalHeader();
		usgWarningsAndConsent.validateUSGBodyText();
		usgWarningsAndConsent.clickOK();

		// Click Login Link
//		MenusPageFactory menus = new MenusPageFactory();
//		menus.clickLoginLink();
		
		HomePageFactory homePage = new HomePageFactory();
		homePage.clickLoginLink();

		// Login
		LoginPageFactory login = new LoginPageFactory();
		login.setUserName(userName);
		login.setPassword(password);

		Assert.assertEquals(userName, login.readUserName(), "Username: ");
		Assert.assertEquals(password, login.readPassword(), "Password: ");

		login.clickLoginButton();

	}

}
