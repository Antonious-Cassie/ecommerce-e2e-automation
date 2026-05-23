package tests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.LoginPage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement; 

public class LoginTest {
	
	WebDriver driver; 
	LoginPage loginPage;
	
	@BeforeMethod 
	public void setUp() {
		
		driver = new ChromeDriver();
		driver.get("https://automationexercise.com/");
		driver.manage().window().maximize();
		
		loginPage = new LoginPage(driver);
	}
	
	@Test 
	public void loginAccount() {
		loginPage.executeLogin("cass901a@gmail.com", "Password123"); 
		
		//Assertions
		WebElement logoutBtn = driver.findElement(By.xpath("//a[@href='/logout']")); 
		Assert.assertTrue(logoutBtn.isDisplayed());
		
		WebElement accountName = driver.findElement(By.xpath("//b[text()='Antonious']")); 
		Assert.assertTrue(accountName.isDisplayed()); 
	}
}
	

	
