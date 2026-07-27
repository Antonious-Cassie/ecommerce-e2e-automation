package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait; 
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.LoginPage;

public class NegativeLoginTest {

	WebDriver driver; 
	LoginPage loginPage;
	
	
	
	@BeforeMethod
	public void start() {  
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless=new");
		options.addArguments("--no-sandbox");
		options.addArguments("--disable-dev-shm-usage");
		options.addArguments("--window-size=1920,1080");

		driver = new ChromeDriver(options);
	driver.get("https://automationexercise.com/");
	driver.manage().window().maximize();
		
	loginPage = new LoginPage(driver);
		
	}
	
	@Test
	public void NegativeLogin() {
	
		loginPage.executeLogin("cass901a@gmail.com", "Wrongpassword");
		
		Assert.assertTrue(loginPage.isErrorMessageDisplayed());
	}
	
	@AfterMethod 
	public void closeBrowser() {
		driver.quit();
	}
	
	
}
