package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MailSetup  {
	
	public String baseUrl = "https://www.mail.com";
	public WebDriver driver;
	
	@BeforeTest
	public void setBaseURL() {
		WebDriverManager.firefoxdriver().setup();

		driver = new FirefoxDriver();
		driver.get(baseUrl);
		
	}
	
	@Test
	public void mailSetup() {
		
		WebElement signUpButton = driver.findElement(By.id("signup-button"));
		signUpButton.click();
		
		
		
		

	}
	
//	@AfterTest
//	public void endSession() {
//		driver.quit();
//	}
	
	private String[] registeredPeople() {
		return null;
		
		
	}
	
	
	

}
