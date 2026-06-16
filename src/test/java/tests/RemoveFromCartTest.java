package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;
import org.openqa.selenium.support.ui.WebDriverWait;


import pages.LoginPage;
import pages.ProductsPage;

public class RemoveFromCartTest {

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
	
	productsPage.openProductPage();
	
	productsPage.closeAdPopup();
	
	productsPage.selectJeans();
	
	productsPage.verifyCart(); 
}

@Test 
public void removeItem() {
	
	productsPage.removeItemFromCart();
	
	String cartMessage = productsPage.getEmptyCartMessage(); 
	
	Assert.assertTrue(cartMessage.contains("Cart is empty!")); 
	

	
}


@AfterMethod
public void closeBroswer() {
	driver.quit();
}

}




