package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ProductsPage;

public class RemoveFromMultipleCartTest {

	WebDriver driver;
	LoginPage loginPage;
	ProductsPage productsPage;
	
	
	@BeforeMethod 
	public void before() {
	
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
		
		productsPage.openProductPage();
		
		productsPage.closeAdPopup(); 
		 
		productsPage.addGreenShirtToCart();
		
		productsPage.addPoloShirtToCart();
		
		productsPage.addGraphicShirt();
		
		productsPage.selectJeansCategory();
		
		productsPage.addStraightJeansToCart();
		
		productsPage.addSlimJeansToCart();
		
		
	}
	
	@Test 
	public void removeItems() {
		
		Assert.assertEquals(productsPage.cartItemTotal(), 6); 
		
		Assert.assertTrue(productsPage.greenShirtDisplayed());
		
		Assert.assertTrue(productsPage.poloShirtDisplayed());
		
		Assert.assertTrue(productsPage.slimJeansDisplayed());
		
		productsPage.removeSlimJeans();
		
		productsPage.removeGraphicTshirt();
		
		productsPage.waitForCartToUpdate();
		
		Assert.assertEquals(productsPage.cartItemTotal(), 3); 
		
		Assert.assertTrue(productsPage.greenShirtDisplayed());
		
		Assert.assertTrue(productsPage.poloShirtDisplayed());
		
		Assert.assertTrue(productsPage.straightJeansDisplayed());
		
		
	} 
		
		
	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}
	
	
	
	}
	

	

