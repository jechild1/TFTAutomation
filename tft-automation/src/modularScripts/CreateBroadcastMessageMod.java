package modularScripts;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.WebElement;

import configuration.TFTConfig;
import pageFactories.CreateBroadcastMessagePageFactory;
import pageFactories.MenusPageFactory;
import pageFactories.NotificationDetailsPageFactory;
import pageFactories.NotificationsPageFactory;
import utilities.AutomationHelper;
import utilities.ExcelDataConfig;

public class CreateBroadcastMessageMod extends TFTConfig {

	// Class level variables
	// This variable holds all of the team members that will receive a broadcast
	// message
	String[][] teamMemberLogins;

	/**
	 * This method will create a broadcast message for a specified group of
	 * users corresponding with the data in the passed in datafiles / test data
	 * ID.
	 * 
	 * @param dataFile
	 * @param testDataID
	 */
	public void createBroadcastMessage(ExcelDataConfig dataFile,
			String testDataID) {

		AutomationHelper.printMethodName();

		// Store the data from the datasheet
		String subject = dataFile.getData(testDataID, "Subject");
		String message = dataFile.getData(testDataID, "Message");
		String sendTeamNotifications = dataFile.getData(testDataID,
				"SendTeamNotifications");

		// The String below can me more complex. It is put in excel in a cell,
		// and
		// separated by a new line if there are multiples that are desired. We
		// must put
		// these items in a String[] to be used in a method which selects
		// multiple items
		// in a given list.
		String sendMemberNotifications = dataFile.getData(testDataID,
				"SendMemberNotifications");

		// Put the String above (could be multiple rows) in a String array. This
		// String
		// array will be used to select multiple items, if need be.
		// \\r? is carriage return, one or more times
		// \\n is carriage return

		// Initialize the array to null. It needs to stay null if there is no
		// data in
		// the String. The conditional for this is below.
		String[] sendMemberNotificationsArray = null;

		// If there is no data in the sendMemberNotifications string, do not
		// split it,
		// leaving the array null.
		if (!sendMemberNotifications.equals("")) {
			sendMemberNotificationsArray = sendMemberNotifications
					.split("\\r?\\n");
		}

		/*
		 * This section sets the fields with the passed in data.
		 */
		CreateBroadcastMessagePageFactory broadcastPF = new CreateBroadcastMessagePageFactory();
		broadcastPF.setSubjectTextField(subject);
		broadcastPF.setMessage(message);

		// If the datasheet has an empty value for "Send Team Notifications",
		// set it to
		// the "default TFT value" value of -- Select Team --
		if (sendTeamNotifications.equals("")) {
			sendTeamNotifications = "-- Select Team --";
		}
		broadcastPF.selectTeamNotifications(sendTeamNotifications);

		// Do not attempt to pass in an empty array, as we will fail by passing
		// in "".
		if (sendMemberNotificationsArray != null) {
			broadcastPF.selectMemberNotifications(sendMemberNotificationsArray);
		}

		// Grab the exact time - To be used to process wait time for server call
		Instant start = Instant.now();
		// Commit the message
		broadcastPF.clickSend();
		// Server time stored - Stop timer
		Instant stop = Instant.now();

		// Formatter for processing in 1/19/2019 4:16:19 PM format.
		DateTimeFormatter formatter1 = DateTimeFormatter
				.ofPattern("M/d/yyyy h:mm:ss a", Locale.US);
		// Formatter for processing a date into 08 May 2018 19:47 format.
		DateTimeFormatter formatter2 = DateTimeFormatter
				.ofPattern("dd MMM yyyy HH:mm", Locale.US);

		// Grabs the server date and stores it in a string.
		String date = getServerDateTime();
		// TODO
		System.out.println(date);
		long gap = ChronoUnit.MILLIS.between(start, stop);

		// Transforms the date into a Java 8 LocalDateTime object
		LocalDateTime serverDate = LocalDateTime.parse(date, formatter1);

		// Subtract the time it took to get the time from the server.
		serverDate = serverDate.minus(gap, ChronoUnit.MILLIS);

		dataFile.writeToWorkSheet(testDataID, "DateLastSent",
				formatter2.format(serverDate));

		// Capture the name of the sender of the broadcast message & write to
		// datasheet.
		MenusPageFactory menus = new MenusPageFactory();
		dataFile.writeToWorkSheet(testDataID, "MessageSentBy",
				menus.readGreetingName());

	}

	public void validateBroadcastMessage(String testDataID) {

		AutomationHelper.printMethodName();

		NotificationsPageFactory notificationsPF = new NotificationsPageFactory();

		// Now that we are on the Notifications Page, gather the data from the
		// datasheet
		// that we will need to be validating.
		ExcelDataConfig broadcastMessageDataFile = getExcelFile(
				"BroadcastMessages.xlsx", "CreateBroadcastMessage");

		String notificationType = broadcastMessageDataFile.getData(
				broadcastMessageDataFile.getRowIndex("TestDataID", testDataID),
				broadcastMessageDataFile.getColumnIndex("NotificationType"));
		String subject = broadcastMessageDataFile.getData(
				broadcastMessageDataFile.getRowIndex("TestDataID", testDataID),
				broadcastMessageDataFile.getColumnIndex("Subject"));
		String message = broadcastMessageDataFile.getData(
				broadcastMessageDataFile.getRowIndex("TestDataID", testDataID),
				broadcastMessageDataFile.getColumnIndex("Message"));
		String sentBy = broadcastMessageDataFile.getData(
				broadcastMessageDataFile.getRowIndex("TestDataID", testDataID),
				broadcastMessageDataFile.getColumnIndex("MessageSentBy"));

		String dateLastSentDatasheet = broadcastMessageDataFile.getData(
				broadcastMessageDataFile.getRowIndex("TestDataID", testDataID),
				broadcastMessageDataFile.getColumnIndex("DateLastSent"));

		/*
		 * Getting server time has been a signifint issue. There is always a
		 * good chance the script will fail due to a < 1 minute deviation
		 * between the time we capture the date when we send it, and the time
		 * that shows up in the table. Next block of code will handle ensuring
		 * the date is within 1 minute.
		 */

		String dateSentTFT;
		// Grab the entire text from the first row in the table.
		WebElement firstRow = notificationsPF.getNotificationsTable()
				.getFirstRowInTable();

		// Get the date in the first row of the table
		String rowText = firstRow.getText();

		// Variable to store the ending index of the sentBy field.
		int stopIndex = 0;

		Pattern pattern = Pattern.compile(sentBy);
		Matcher match = pattern.matcher(rowText);

		// While loop exists to keep running until we find the last match, if
		// indeed multiples exist.
		while (match.find()) {
			match.start();
			stopIndex = match.end();
		}

		dateSentTFT = rowText.substring(stopIndex, rowText.indexOf("Details"))
				.trim();

		System.out.println("String Date: " + dateSentTFT);

		// Formatter for processing a date into 08 May 2018 19:47 format.
		DateTimeFormatter formatter = DateTimeFormatter
				.ofPattern("dd MMM yyyy HH:mm", Locale.US);

		// LocalDateTime of row in TFT
		LocalDateTime dateSentTFTLocalDateTime = LocalDateTime
				.parse(dateSentTFT, formatter);
		System.out.println("Local Date Time - TFT Application: "
				+ dateSentTFTLocalDateTime);

		// LocalDateTime of datasheet
		LocalDateTime dateLastSentDatasheetLocalDateTime = LocalDateTime
				.parse(dateLastSentDatasheet, formatter);
		System.out.println("Local Date Time - Datasheet: "
				+ dateLastSentDatasheetLocalDateTime);

		// Compare the date in the table against the date in the datasheet. If
		// they are equal, no need to do anything, If they are more than 1
		// minute apart, throw an exception. If they are within a one minute
		// window, update datasheet variable to match what TFT is currently
		// displaying.

		// Get the difference in minutes between the two times
		// Use Math.abs so that if the number is negative, it's adjusted to a
		// positive number.
		long timeDifferenceInMin = Math.abs(ChronoUnit.MINUTES.between(
				dateSentTFTLocalDateTime, dateLastSentDatasheetLocalDateTime));

		if (timeDifferenceInMin <= 1) {
			System.out
					.println("The time differece between TFT and Datasheet is: "
							+ timeDifferenceInMin + " minutes.");

			// Update the datasheet with the most recent value if they are only
			// 1 minute apart.
			if (timeDifferenceInMin != 0) {

				// Update DateLastSent in datasheet
				broadcastMessageDataFile.writeToWorkSheet(testDataID,
						"DateLastSent",
						formatter.format(dateSentTFTLocalDateTime));

				// Update TimeAdjusted field in datasheet
				broadcastMessageDataFile.writeToWorkSheet(testDataID,
						"TimeAdjusted",
						"Time Adjusted from original " + dateLastSentDatasheet
								+ " to new "
								+ formatter.format(dateSentTFTLocalDateTime));

				// Update the variable to the newest one
				dateLastSentDatasheet = dateSentTFT;
			}
		}

		/*
		 * End time calcs
		 */

		// Starting on the Notifications page.
		// Validate the row is in the table
		assertTrue(
				notificationsPF.getNotificationsTable().isRowInTable(subject,
						sentBy, dateLastSentDatasheet),
				"Broadcast message in Notification Table");

		// Click the Details link in that record
		notificationsPF.getNotificationsTable().clickLinkInRow(subject, sentBy,
				dateLastSentDatasheet, "Details");

		// Notification Details Page
		NotificationDetailsPageFactory notificationDetailsPF = new NotificationDetailsPageFactory();

		assertEquals(notificationDetailsPF.readPageTitle(),
				"Notification Details - Team Fitness Tracker",
				"Notification Detials Page Title");

		// Perform the verifications
		softAsserter.assertEquals(
				notificationDetailsPF.readNotificationTypeText(),
				notificationType, "Notification Type: ");
		softAsserter.assertEquals(notificationDetailsPF.readSubjectText(),
				subject, "Subject: ");
		softAsserter.assertEquals(notificationDetailsPF.readMessageText(),
				message, "Message: ");
		softAsserter.assertEquals(notificationDetailsPF.readSentByText(),
				sentBy, "Sent By: ");
		// TODO - Enable this
		// softAsserter.assertEquals(notificationDetailsPF.readDateSentText(),
		// dateLastSent, "Date Sent: ");

		notificationDetailsPF.clickBackToNotificationListLink();

		// Ensure we landed back on the Notifications page
		assertEquals(notificationsPF.readPageTitle(),
				"Notifications - Team Fitness Tracker");

	}

	/**
	 * This method accepts two datasheets and a test data ID. It looks at the
	 * broadcastMessageDataFile and extracts all of the users from the
	 * SendMemberNotifications column. This is all of the users that the message
	 * is meant for.
	 * 
	 * It then modifies the string to strip off everything but the Display Name.
	 * It uses this display name to create a String[][] which will be used to
	 * store the username / password combinations from the second datasheet.
	 * 
	 * @param broadcastMessageDataFile
	 * @param testDataID
	 * @param usersDataFile
	 * @return String[][] of username / password combinations
	 */
	public String[][] getUserNameListForBroadcastMessage(
			ExcelDataConfig broadcastMessageDataFile, String testDataID,
			ExcelDataConfig usersDataFile) {

		AutomationHelper.printMethodName();

		String[][] userNamePasswordArray = null;

		// The String below can be more complex. It is put in excel in a cell,
		// and
		// separated by a new line if there are multiples that are desired. We
		// must put
		// these items in a String[] to be used in a method which selects
		// multiple items
		// in a given list.
		String sendMemberNotifications = broadcastMessageDataFile
				.getData(testDataID, "SendMemberNotifications");

		// Initialize the array to null. It needs to stay null if there is no
		// data in
		// the String. The conditional for this is below.
		String[] sendMemberNotificationsArray = null;

		// First, if the SendMemberNotifications column is blank, we know that
		// this went to ALL team members within the unit.
		// In that case, get a String[][] of ALL OF THE MEMBERS OF THE UNIT.

		if (sendMemberNotifications == "") {

			userNamePasswordArray = getUserAndPassDataProviderFromExcel(
					"UsersData.xlsx", "ChildressCalorieCrushers");
		}

		// Put the String above (could be multiple rows) in a String array. This
		// String
		// array will be used to select multiple items, if need be.
		// \\r? is carriage return, one or more times
		// \\n is carriage return

		// If there is no data in the sendMemberNotifications string, do not
		// split it,
		// leaving the array null.
		else if (!sendMemberNotifications.equals("")) {
			sendMemberNotificationsArray = sendMemberNotifications
					.split("\\r?\\n");

			// Now that we have an array of notifications (if any), we extract
			// the display
			// name and then pull the user name / password from the second
			// datasheet.
			String userName;
			String password;
			userNamePasswordArray = new String[sendMemberNotificationsArray.length][2];

			if (sendMemberNotificationsArray != null) {

				// Set up String[][]
				// First position is the x, or the number of rows.
				// Second position is the y, or number of columns/datapoints
				// (user name / pass)
				// String[][] userNamePasswordArray = new
				// String[sendMemberNotificationsArray.length][2];

				for (int i = 0; i < sendMemberNotificationsArray.length; i++) {

					// First, we must get the display name from the
					// sendMemberNotificaionArray
					// Will be in format MY TEAM NAME - DISPLAY NAME, e.g.
					// Childress Calorie
					// Crushers - Eli Childress
					String[] displayNameArray;
					String displayName;
					String rawDisplayName = sendMemberNotificationsArray[i];
					// System.out.println("Raw Display Name: " +
					// rawDisplayName);

					// Remove everything to the left of the hyphen in the raw
					// string. This will
					// leave us with the display name.
					displayNameArray = rawDisplayName.split(" - ");
					displayName = displayNameArray[1];

					// Now we have a display name, we can use the UserData
					// datasheet to return a
					// list of username / password combinations.
					userName = usersDataFile.getData(
							usersDataFile.getRowIndex("DisplayName",
									displayName),
							usersDataFile.getColumnIndex("UserName"));
					password = usersDataFile.getData(
							usersDataFile.getRowIndex("DisplayName",
									displayName),
							usersDataFile.getColumnIndex("Password"));

					System.out.println(
							"User Name / Pass: " + userName + " " + password);

					// Add the values to the userNamePasswordArray
					userNamePasswordArray[i][0] = userName;
					userNamePasswordArray[i][1] = password;

				}
			}
		}

		return userNamePasswordArray;

	}

}
