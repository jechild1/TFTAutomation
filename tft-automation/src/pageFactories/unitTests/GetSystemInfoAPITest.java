package pageFactories.unitTests;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.testng.annotations.Test;

import configuration.SystemInfoAPIResponse;
import configuration.TFTConfig;
import utilities.WebServiceClient;

public class GetSystemInfoAPITest extends TFTConfig {
	@Test
	public void execute() {
		// base url to initialize
		WebServiceClient wsc = new WebServiceClient(getBaseUrl());

		// path to API
		SystemInfoAPIResponse response = wsc.get("/Home/GetSystemInfo")
				.readResults(SystemInfoAPIResponse.class);

		// read API
//		System.out.println(response.currentDate);
//		System.out.println(response.currentTime);

//		SimpleDateFormat formatter1 = new SimpleDateFormat("MM/dd/yyyy HH:mm");
//		SimpleDateFormat formatter2 = new SimpleDateFormat("MMM dd yyyy HH:mm");
		String concatenatedDate = response.currentDate + " " + response.currentTime;
//		System.out.println(concatenatedDate);
		
		
		DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("M/dd/yyyy h:mm:ss a");
		DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd MMM yyyy HH:mm");

		LocalDateTime date = LocalDateTime.parse(response.currentDate + " " + response.currentTime, formatter1);
		System.out.println(date);
		
		
		LocalDateTime localDateTime = LocalDateTime.parse(concatenatedDate, formatter1);
		System.out.println(localDateTime.format(formatter1));
		
		System.out.println(localDateTime.format(formatter2));

		
	}

}
