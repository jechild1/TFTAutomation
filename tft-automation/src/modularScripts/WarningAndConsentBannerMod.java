package modularScripts;

import configuration.TFTConfig;
import pageFactories.WarningAndConsentBannerPageFactory;
import utilities.AutomationHelper;

/**
 * Modular class created to handle aspects of the USG Warning and Consent Banner
 * which is present upon a page load.
 * 
 * @author jesse.childress
 */
public class WarningAndConsentBannerMod extends TFTConfig {

	/**
	 * Constructor takes in a driver from the calling script
	 */
	public WarningAndConsentBannerMod() {
	}

	/**
	 * Confirms the text on the USG Warnings and Consent banner popup, and
	 * closes it.
	 */
	public void validateAndCloseUSGWarningsAndConsentPopup() {
		AutomationHelper.printClassName();
		AutomationHelper.printMethodName();

		WarningAndConsentBannerPageFactory usgWarningsAndConsent = new WarningAndConsentBannerPageFactory();
		
		usgWarningsAndConsent.validateUSGModalHeader();
		usgWarningsAndConsent.validateUSGBodyText();
		usgWarningsAndConsent.clickOK();
	}

}
