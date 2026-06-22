package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;


import pages.LoginPage;
import pages.ProductsPage;
import pages.CheckoutPage;


public class CheckoutFlowTest {
	
	WebDriver driver; 
	LoginPage loginPage;
	ProductsPage productsPage;
	CheckoutPage checkoutPage;
	
	@BeforeMethod
	public void beforeTest() {
		
		driver = new ChromeDriver();
		driver.get("https://automationexercise.com/");
		driver.manage().window().maximize();
		
		loginPage = new LoginPage(driver);
		loginPage.executeLogin("cass901a@gmail.com", "Password123");
		
		productsPage = new ProductsPage(driver);
		
		checkoutPage = new CheckoutPage(driver);
		
		productsPage.openProductPage(); 
		
		productsPage.closeAdPopup(); 
		
		
		productsPage.selectJeans();
		
		
		
	}
	
	@Test 
	public void checkoutFlow() {
		
		
		checkoutPage.clickCheckoutBtn(); 
		
		Assert.assertTrue(checkoutPage.customerNameDisplayed());
		
		Assert.assertTrue(checkoutPage.addressDisplayed());
		
		Assert.assertEquals(checkoutPage.verifyPhoneNumber(),"07584272975");
		
		Assert.assertTrue(checkoutPage.jeansDisplayed());
		
		checkoutPage.paymentConfirmation();
		
		Assert.assertTrue(checkoutPage.orderPlacedDisplayed());
		
	}
	
	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}

	
}

