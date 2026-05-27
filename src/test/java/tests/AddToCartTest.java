package tests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

import org.openqa.selenium.By;

import pages.LoginPage;
import pages.ProductsPage;

public class AddToCartTest {
	
	
	
	
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
	public void addToCart() {
		
		productsPage.openProductPage(); 
		
		productsPage.closeAdPopup();
		
		productsPage.selectJeans();
		
		productsPage.verifyCart();
	}

	@AfterMethod
	public void after() {
	    driver.quit();
	}
		
	}
			
 


	// Issues overcame: 
			
	//1.i struggled with the iframe because it was a nested iframe. i thought the close button was in the inner iframe, i viewd the image again and saw it was on the outer iframe.
	
	// 2. BUT the advertisement iframe was physically sitting on top of the button. So the ad received the click instead
	 
	//To overcome this i used scroll to move the iframe position. 
	
	//3. an ad i frame poped up and blocked the click of an option. I overcame this by adding scroll. 
	
	//4. adding waits for assertions 
	 		
