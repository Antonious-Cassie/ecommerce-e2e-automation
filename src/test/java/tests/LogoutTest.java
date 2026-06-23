package tests;
import org.openqa.selenium.chrome.ChromeDriver;
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
		
		driver = new ChromeDriver();
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
