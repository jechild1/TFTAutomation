package pageFactories.LegacyPageFactories;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import configuration.TFTConfig;

public class DeletePFTScoresPageFactory extends TFTConfig{
	
	@FindBy(xpath = "//input[@class='btn btn-primary'][@value='Delete']")
	WebElement deleteButton;
	
	public void clickDelete() {
		deleteButton.click();
	}
	
	
	

}
