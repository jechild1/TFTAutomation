package modularScripts;

import configuration.TFTConfig;
import pageFactories.MenusPageFactory;
import utilities.AutomationHelper;

public class LogoffMod extends TFTConfig {
	
	/**
	 * Page Constructor: Accepts the WebDriver from the calling page.
	 */
	public LogoffMod (){
	}
	
	
	/**
	 * Logs off of the application via the menus
	 */
	public void logoff(){
		AutomationHelper.printClassName();
		AutomationHelper.printMethodName();
		
		MenusPageFactory menus = new MenusPageFactory();
		clickLogOffLink();
		
	}

}
