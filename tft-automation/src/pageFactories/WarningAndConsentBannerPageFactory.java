package pageFactories;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.time.Instant;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import configuration.TFTConfig;
import utilities.AutomationHelper;
/**
 * Page factory for the Warning and Consent Banner popup in the Team Fitness
 * Tracker application.<br>
 * 
 * (1) Finds a reference to objects on the page <br>
 * (2) Defines methods to interact with objects on the page.<br>
 * 
 * @author jesse.childress
 */
public class WarningAndConsentBannerPageFactory extends TFTConfig {
	
	String USGHeaderText = "DOD STANDARD WARNING AND NOTICE BANNER";
	String USGWarningAndNoticeText = "You are accessing a U.S. Government (USG) Information System (IS) that is provided for USG-authorized use only. By using this IS (which includes any device attached to this IS), you consent to the following conditions: The USG routinely intercepts and monitors communications on this IS for purposes including, but not limited to, penetration testing, Communications Security (COMSEC) monitoring, network operations and defense, personnel misconduct (PM), law enforcement (LE), and counterintelligence (CI) investigations. The USG may inspect and seize data stored on this IS at anytime. Communications using, or data stored on, this IS are not private; are subject to routine monitoring, interception, and search; and may be disclosed or used for any USG authorized purpose. This IS includes security measures (e.g., authentication and access controls) to protect USG interests--not for your personal benefit or privacy. Notwithstanding the above, using this IS does not constitute consent to PM, LE, or CI investigative searching or monitoring of the content of privileged communications, or work product, related to personal representation or services by attorneys, psychotherapists, or clergy and their assistants. Such communications and work product are private and confidential. See User Agreement for details." ;

	/**
	 * Constructor takes in a driver from the calling script
	 * 
	 * @param driver
	 */
	public WarningAndConsentBannerPageFactory() {
		PageFactory.initElements(driver, this);
	}

	/*
	 * REFERENCE TO ELEMENTS ON THE PAGE
	 */

	/**
	 * Obtain a reference to the header of the modal
	 */
	@FindBy(xpath = "//div[1]/h2")
	WebElement modalHeader;

	/**
	 * Read Modal body text.
	 */
	@FindBy(xpath = "//div[@class='modal-body text-info']")
	WebElement modalBodyText;

	/**
	 * Obtains a reference to the OK button.
	 */
	@FindBy(id = "buttonOk")
	WebElement okButton;

	/*
	 * INTERACTING WITH ELEMENTS ON PAGE
	 */

	/**
	 * Reads the header text of the modal.
	 */
	private String readModalHeader() {
		AutomationHelper.printMethodName();
		
		String headerText = modalHeader.getAttribute("innerText");
		Reporter.log("Modal Header Text = " + headerText, true);
		Reporter.log("", true);
		return headerText;
	}


	/**
	 * Reads the body text of the modal.
	 */
	private String readModalBodyText() {
		AutomationHelper.printMethodName();
		
		String bodyText = modalBodyText.getAttribute("innerText").replaceAll("[\\t\\n\\r\\s]+", " ").trim();
		
		Reporter.log("Modal Body Text = " + bodyText, true);
		Reporter.log("", true);

		return bodyText;
	}

	/**
	 * Validates the USG Modal Header is present as expected.
	 */
	public void validateUSGModalHeader(){
		AutomationHelper.printClassName();
		AutomationHelper.printMethodName();
		assertEquals(readModalHeader(), USGHeaderText);	
	}
	
	/**
	 * Validates the USG Modal Body Text is present as expected.
	 */
	public void validateUSGBodyText(){
		AutomationHelper.printClassName();
		AutomationHelper.printMethodName();
		assertEquals(readModalBodyText(), USGWarningAndNoticeText);
	}
	

	/**
	 * Clicks the OK button on the USG Warning and Consent Banner popup.
	 */
	public void clickOK() {
		AutomationHelper.printClassName();
		AutomationHelper.printMethodName();
		
		// For method execution time
		Instant start = Instant.now();

		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOf(okButton));

		okButton.click();
		Reporter.log("OK clicked on USG Warning and Consent Banner", true);

		Instant stop = Instant.now();

		String timeReport = "Clicking OK took " + Duration.between(start, stop) + " seconds to complete";
		Reporter.log(timeReport, true);
		Reporter.log("", true);
		
		AutomationHelper.waitSeconds(2);
	}

}
