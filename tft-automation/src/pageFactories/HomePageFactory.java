package pageFactories;

/**
 * Page factory for the Home Page for Team Fitness Tracker.<br>
 * (1) Finds a reference to objects on the page <br>
 * (2) Defines methods to interact with objects on the page.
 * 
 * @author jesse.childress
 *
 */
public class HomePageFactory extends MenusPageFactory {
	
	private static String regexURL = BASE_URL + ".*";
	
	/**
	 * Page Constructor: Instantiates super class with URL provided
	 */
	public HomePageFactory() {
		super(regexURL);
	}
	
	

//	/**
//	 * Page Constructor: Accepts the WebDriver from the calling page &
//	 * instantiates the elements on the page.
//	 */
//	public HomePageFactory() {
//		PageFactory.initElements(driver, this);
//	}
//
//	@FindBy(xpath = "//div[@id='myLastNutritionEntry']//table")
//	WebElement last7NutritinalItemsTable;
//
//	@FindBy(xpath = "//div[@class = 'panel panel-danger']//h3")
//	WebElement errorHeader;
//
//	@FindBy(xpath = "//div[@class = 'panel panel-danger']/div[@class='panel-body']")
//	WebElement errorBody;
//
//	/**
//	 * Returns a reference to the Last 7 Nutritional Items table.
//	 * 
//	 * @return Tables
//	 */
//	public Tables getLast7NutritionalItemsTable() {
//		WebDriverWait wait = new WebDriverWait(driver, 10);
//
//		wait.until(ExpectedConditions.visibilityOf(last7NutritinalItemsTable));
//
//		return new Tables(last7NutritinalItemsTable);
//	}
//
//	/**
//	 * Reads the error header that exists on the dashboard. E.g. "Not a Part of
//	 * Any Team"
//	 * 
//	 * @return String
//	 */
//	public String readErrorHeader() {
//		return errorHeader.getText();
//	}
//
//	/**
//	 * Reads the error body that exists on the dashboard. E.g. "You are not a
//	 * part of any team. Please contact your administrator to add you to a
//	 * team."
//	 * 
//	 * @return String
//	 */
//	public String readErrorBody() {
//		return errorBody.getText();
//	}
}
