package modularScripts;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import configuration.TFTConfig;
import pageFactories.MenusPageFactory;
import pageFactories.NotificationDetailsPageFactory;
import pageFactories.NotificationsPageFactory;
import utilities.Tables;

public class NotificationsMod extends TFTConfig {

	/**
	 * Method to open all of the notifications for a given user. This method
	 * will page through the tables until the new notification count is 0.
	 */
	public void openAllTableRecords() {
		// Obtain a reference to the table.
		// NotificationsPageFactory notificationsPF = new
		// NotificationsPageFactory();
		NotificationDetailsPageFactory notificationDetailsPF = new NotificationDetailsPageFactory();
		MenusPageFactory menus = new MenusPageFactory();

		// Returns a list of UNREAD list items for a given day.
		List<WebElement> unreadTableRows = getUnreadNotifications();

		if (menus.readNumberOfNotifications() > 0) {

			/*
			 * While there are active notifications, but not on the first page,
			 * skip through each page until we find the one that has teh unread
			 * notification.
			 */
			while (menus.readNumberOfNotifications() > 0
					&& unreadTableRows.size() == 0
					&& Tables.isSkipToNextNavigationPresent()) {
				Tables.clickSkipToNextNavigationLink();
				unreadTableRows = getUnreadNotifications();
			}

			/*
			 * For each page with records, click each individual link and
			 * navigate to the Notification Details page.
			 */
			NotificationsPageFactory notificationsPF = new NotificationsPageFactory();

			do {

				// Grab the text from the table for comparison
				String tableText = notificationsPF.getNotificationsTable()
						.getCellText(Integer.valueOf(unreadTableRows.get(0)
								.getAttribute("rowIndex")), "Subject");
				Reporter.log("Table Text " + tableText, true);

				// Clicks the first row it gets to that is "blue" or, unread.
				notificationsPF.getNotificationsTable()
						.clickLinkInRow(unreadTableRows.get(0), "Details");

				// Now on Notification Details Page
				assertEquals(notificationDetailsPF.readPageTitle(),
						"Notification Details - Team Fitness Tracker");

				// Grab the text from the page and compare it to the table
				// value.
				assertEquals(notificationDetailsPF.readSubjectText(), tableText,
						"Table Text to NOtifications Text comparison");

				// Go back to the Notifications page
				notificationDetailsPF.clickBackToNotificationListLink();

				// Not back on Notifications page
				assertEquals(notificationsPF.readPageTitle(),
						"Notifications - Team Fitness Tracker");

				// Obtain a new reference to the table (this is necessary to
				// prevent stale
				// reference)
				unreadTableRows = getUnreadNotifications();

				// If there are more notifications present, but current page has
				// no more blue
				// records, and we have a menu option to navigate to, click
				// Next.
				if (menus.readNumberOfNotifications() > 0
						&& unreadTableRows.size() == 0
						&& Tables.isSkipToNextNavigationPresent()) {
					Tables.clickSkipToNextNavigationLink();
					// New page, we need a reference to a new table.
					unreadTableRows = getUnreadNotifications();
				}

			} while (unreadTableRows.size() > 0);

		}

		else {
			Reporter.log("There were no unread records for this user", true);
		}

	}

	/**
	 * Utility method to get return a list of all of the UNREAD notifications
	 * for a given table (visible table only).
	 * 
	 * @return List<WebElement>
	 */
	private List<WebElement> getUnreadNotifications() {
		NotificationsPageFactory notificationsPF = new NotificationsPageFactory();

		Tables notificationsTable = notificationsPF.getNotificationsTable();

		// Create a list array of all of the given rows on the table
		List<WebElement> allCurrentTableRows = new ArrayList<WebElement>();
		allCurrentTableRows = notificationsTable.getTableRowsForVisibleTable();

		// Create a list array to store only unread notifications
		List<WebElement> unreadTableRows = new ArrayList<WebElement>();

		for (WebElement currentTR : allCurrentTableRows) {

			if (currentTR.getAttribute("style").equals("color: blue;")) {
				unreadTableRows.add(currentTR);
			}

		}

		return unreadTableRows;

	}
}
