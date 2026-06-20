package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ProductsPage;

public class AddMultipleItemsTest {

	
	WebDriver driver;
	LoginPage loginPage;
	ProductsPage productsPage;
	
	
	@BeforeMethod
	public void before() {
		driver = new ChromeDriver();
		driver.get("https://automationexercise.com/");
		driver.manage().window().maximize();
		
		loginPage = new LoginPage(driver);
		loginPage.executeLogin("cass901a@gmail.com", "Password123");
		
		productsPage = new ProductsPage(driver);
		
		
	}
	
	@Test 
	public void addMultipleItemsToCart() {
		
		productsPage.openProductPage();
		
		productsPage.closeAdPopup(); 
		 
		productsPage.addGreenShirtToCart();
		
		productsPage.addPoloShirtToCart();
		
		productsPage.addGraphicShirt();
		
		productsPage.selectJeansCategory();
		
		productsPage.addStraightJeansToCart();
		
		productsPage.addSlimJeansToCart();
		
		productsPage.cartItemTotal();
		
		Assert.assertEquals(productsPage.cartItemTotal(), 5); 
		
		Assert.assertTrue(productsPage.greenShirtDisplayed());
		
		Assert.assertTrue(productsPage.poloShirtDisplayed());
		
		Assert.assertTrue(productsPage.slimJeansDisplayed());
	}
	
	@AfterMethod 
	
	public void closeBrowser() {
		driver.quit();
	}
	

	
			
}
