package tests;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;

import pages.LoginPage;
import pages.ProductsPage;

public class LogoutTest {

	WebDriver driver; 
	LoginPage loginPage;
	ProductsPage productsPage;
	
	@BeforeMethod() 
	
	public void beforeTest() {
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless=new");
		options.addArguments("--no-sandbox");
		options.addArguments("--disable-dev-shm-usage");
		options.addArguments("--window-size=1920,1080");

		driver = new ChromeDriver(options);
		driver.get("https://automationexercise.com/");
		driver.manage().window().maximize();
		
		loginPage = new LoginPage(driver);
		
		loginPage.executeLogin("cass901a@gmail.com", "Password123"); 
		productsPage = new ProductsPage(driver);
		
	}	
	
	@Test
	
	public void logoutTest() {
		
		productsPage.logout();
		
		Assert.assertTrue(productsPage.loginBtnDisplayed());
		
		Assert.assertTrue(productsPage.loginURLDisplayed());
		
		
	}
	
	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}

	
	
}
