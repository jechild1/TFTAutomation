package pageFactories.LegacyPageFactories;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import configuration.TFTConfig;
import utilities.Tables;

public class PFTScoresPageFactory extends TFTConfig {

	// Obtain a reference to the table

	@FindBy(xpath = "//table[@class='table table-striped table-hover table-bordered']")
	WebElement pftScoresTable;

	public Tables getPFTScoresTable() {
		return new Tables(pftScoresTable);
	}

}
