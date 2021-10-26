package configuration;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.NotFoundException;

import utilities.ExcelDataConfig;
import utilities.WebServiceClient;

/**
 * @author scott.brazelton
 *
 */
public abstract class TFTConfig extends TestConfig {

	protected static final String BASE_URL = "https://nat-p12.tatrc.org/TFT_Test/";

	// private static final String ADDRESS =
	// "https://nat-p12.esp.tatrc.org/TFT_Prod";
	// User this URL when testing on PX-02
	// private static final String ADDRESS =
	// "http://esp-s-px-02.esp.tatrc.org/TFT_Test";

	// Accounts for test
	protected static String TEAM_MEMBER_USERNAME = "echildress";
	protected static String TEAM_MEMBER_PASSWORD = "P@ssword1";
	protected static String ADMIN_USERNAME = "jessec";
	protected static String ADMIN_PASSWORD = "P@ssword1";
	protected static String TEAM_LEAD_USERNAME = "bmullins";
	protected static String TEAM_LEAD_PASSWORD = "P@ssword1";

	public TFTConfig() {
		super(BASE_URL);
	}

	/**
	 * This method takes an excel data file and puts the data in a list. Then it
	 * does size checking and converts it to a multidimensional string array to
	 * be used in the main method.
	 * 
	 * @param excelFile
	 * @param excelWorksheetName
	 * 
	 * @return String[][]
	 */
	protected String[][] getUserAndPassDataProviderFromExcel(String excelFile,
			String worksheet) {
		String[][] userPassCombinations = getUserAndPassDataProviderFromExcel(
				excelFile, worksheet, null);

		return userPassCombinations;
	}

	/**
	 * This method takes an excel data file and puts the data in a list if it
	 * matches the specified username. Then it does size checking and converts
	 * it to a multidimensional string array to be used in the main method.
	 * 
	 * @param excelFile
	 * @param excelWorksheetName
	 * @param specifiedUserName
	 * 
	 * @return String[][]
	 */
	protected String[][] getUserAndPassDataProviderFromExcel(String excelFile,
			String excelWorksheetName, String specifiedUserName) {
		// Set up datafiles
		ExcelDataConfig edc = getExcelFile(excelFile, excelWorksheetName);

		// Get the row count of the datasheet.
		int rowCount = edc.getRowCount();

		// Create an array to store username / password combinations
		List<String> userNameList = new ArrayList<String>();
		List<String> passwordList = new ArrayList<String>();

		/*
		 * Cycle through the username / password columns and store in the
		 * respective array lists. Note: Start x variable at 1 to avoid storing
		 * the datasheet title row.
		 */
		for (int i = 1; i <= rowCount; i++) {

			// If the ACTIVE column value is TRUE, then we want to add that the
			// index to the array
			if (edc.getData(i, edc.getColumnIndex("Active"))
					.equalsIgnoreCase("TRUE")) {

				if (specifiedUserName != null && !specifiedUserName.isEmpty()
						&& !specifiedUserName.equals(edc.getData(i,
								edc.getColumnIndex("UserName")))) {
					continue;
				}

				userNameList
						.add(edc.getData(i, edc.getColumnIndex("UserName")));
				passwordList
						.add(edc.getData(i, edc.getColumnIndex("Password")));
			}
		}

		// Ensure that the lists are the same size. Else, we have bad data.
		if (userNameList.size() != passwordList.size()) {
			// TODO - Can work on exception name.
			throw new IllegalArgumentException(
					"The user name and password list sizes are different. Check datasheet.");
		} else if (userNameList.size() == 0) {
			throw new NotFoundException(
					"No username and password combinations found");
		}
		// Now that we have two String Lists, we need to convert them to arrays
		// to be later added to multi-dimensional array.

		String[] userNameArray = userNameList
				.toArray(new String[userNameList.size()]);
		String[] passwordArray = passwordList
				.toArray(new String[passwordList.size()]);

		String[][] userPassCombinations = new String[userNameArray.length][2];
		for (int i = 0; i < userNameArray.length; i++) {
			userPassCombinations[i][0] = userNameArray[i];
			userPassCombinations[i][1] = passwordArray[i];
		}
		return userPassCombinations;
	}

	/**
	 * Returns the server date in format d/MM/yyyy
	 * 
	 * @return String
	 */
	protected String getServerDate() {
		// base url to initialize
		WebServiceClient wsc = new WebServiceClient(getBaseUrl());

		// path to API
		SystemInfoAPIResponse response = wsc.get("/Home/GetSystemInfo")
				.readResults(SystemInfoAPIResponse.class);

		return response.currentDate;
	}

	/**
	 * Returns the server time in format HH:mm:ss a format
	 * 
	 * @return String e.g. 4:33:45 PM
	 */
	protected String getServerTime() {
		// base url to initialize
		WebServiceClient wsc = new WebServiceClient(getBaseUrl());

		// path to API
		SystemInfoAPIResponse response = wsc.get("/Home/GetSystemInfo")
				.readResults(SystemInfoAPIResponse.class);

		return response.currentTime;
	}

	/**
	 * Returns the server Date Time in 5/29/2018 4:58:47 PM format.
	 * 
	 * @return String
	 */
	protected String getServerDateTime() {

		// base url to initialize
		WebServiceClient wsc = new WebServiceClient(getBaseUrl());

		// path to API
		SystemInfoAPIResponse response = wsc.get("/Home/GetSystemInfo")
				.readResults(SystemInfoAPIResponse.class);

		return response.currentDate + " " + response.currentTime;
	}

}
