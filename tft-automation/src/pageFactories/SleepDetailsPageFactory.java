package pageFactories;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import configuration.TFTConfig;
import utilities.AutomationHelper;

public class SleepDetailsPageFactory extends TFTConfig{
	
	/**
	 * Page Constructor: Accepts the WebDriver from the calling page &
	 * instantiates the elements on the page.
	 */
	public SleepDetailsPageFactory() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (linkText = "Back to My Sleep List")
	WebElement backToMySleepListLink;
	
	@FindBy (xpath = "//dt[contains(text(),'Awake')]//following::dd[1]")
	WebElement awakeLabel;
	
	@FindBy (xpath = "//dt[contains(text(),'Deep Sleep')]//following::dd[1]")
	WebElement deepSleepLabel;
	
	@FindBy (xpath = "//dt[contains(text(),'Light Sleep')]//following::dd[1]")
	WebElement lightSleepLabel;
	
	@FindBy (xpath = "//dt[contains(text(),'REM Sleep')]//following::dd[1]")
	WebElement remSleepLabel;
	
	@FindBy (xpath = "//dt[contains(text(),'Total Sleep')]//following::dd[1]")
	WebElement totalSleepLabel;
	
	@FindBy (xpath = "//dt[contains(text(),'Date')]//following::dd[1]")
	WebElement dateLabel;
	
	@FindBy (xpath = "//dt[contains(text(),'Activity Source')]//following::dd[1]")
	WebElement activitySourceLabel;
	

	
	/**
	 * Clicks the Back to My Sleep List button.
	 */
	public void clickBackToMySleepList() {
		backToMySleepListLink.click();
		AutomationHelper.waitForPageToLoad(NORMAL_TIMEOUT);
	}
	
	/**
	 * Reads the Awake label on the Sleep Details page.
	 * @return String
	 */
	public String readAwakeTime() {
		return awakeLabel.getText();
	}
	
	/**
	 * Reads the Deep Sleep label on the Sleep Details page.
	 * @return String
	 */
	public String readDeepSleepTime() {
		return deepSleepLabel.getText();
	}
	
	/**
	 * Reads the Light Sleep label on the Sleep Details page.
	 * @return String
	 */
	public String readLightSleepTime() {
		return lightSleepLabel.getText();
	}
	
	/**
	 * Reads the REM Sleep label on the Sleep Details page.
	 * @return String
	 */
	public String readREMSleepTime() {
		return remSleepLabel.getText();
	}
	
	/**
	 * Reads the Total Sleep label on the Sleep Details page.
	 * @return String
	 */
	public String readTotalSleepTime() {
		return totalSleepLabel.getText();
	}
	
	/**
	 * Reads the Date label on the Sleep Details page.
	 * @return String
	 */
	public String readDate() {
		return dateLabel.getText();
	}
	
	/**
	 * Reads the Activity Source label on the Sleep Details page.
	 * @return String
	 */
	public String readActivitySource() {
		return activitySourceLabel.getText();
	}

}
