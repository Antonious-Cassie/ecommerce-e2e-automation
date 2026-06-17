package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
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
		
	driver = new ChromeDriver();
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
