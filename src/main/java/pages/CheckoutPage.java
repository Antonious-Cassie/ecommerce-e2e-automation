package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class CheckoutPage {

	WebDriver driver;
	Actions act;
	WebDriverWait wait;
	
	public CheckoutPage(WebDriver driver) {
		this.driver = driver;
		this.act = new Actions(driver);
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	
	
	By checkoutBtn = By.className("check_out");
	By customerName = By.xpath("//li[text()='Mr. Antonious Cassie']");
	By firstLineOfAddress = By.xpath("//li[text()='Woodberry Avenue']");
	By customerPhoneNumber = By.xpath("//li[text()='07584272975']");
	By stretchJeans = By.xpath("//a[@href='/product_details/33']");
	By placeOrderBtn = By.xpath("//a[@href='/payment']");
	By cardName = By.name("name_on_card"); 
	By cardNumber = By.name("card_number");
	By cVC = By.name("cvc");
	By expiryMonth = By.name("expiry_month"); 
	By expiryYear = By.name("expiry_year");
	By payBtn = By.id("submit");
	By orderConfirmation = By.cssSelector("[data-qa='order-placed']");
	
			
	
	public void clickCheckoutBtn() {
		driver.findElement(checkoutBtn).click();
		
	}
	
	public boolean customerNameDisplayed() {
		return driver.findElement(customerName).isDisplayed();
	}
	
	public boolean addressDisplayed() {
		return driver.findElement(firstLineOfAddress).isDisplayed();
	}
	
	public String verifyPhoneNumber() {
		return driver.findElement(customerPhoneNumber).getText();
	}
	
	public boolean jeansDisplayed() {
		
		act.scrollByAmount(0, 500).perform();
		
		return driver.findElement(stretchJeans).isDisplayed();
	}
	
	public void paymentConfirmation() {
		
		act.scrollByAmount(0, 500).perform();
		
		driver.findElement(placeOrderBtn).click();
		
		driver.findElement(cardName).sendKeys("Mr Cassie");
		
		driver.findElement(cardNumber).sendKeys("0123 4567 8910 1112");
		
		driver.findElement(cVC).sendKeys("321");
		
		driver.findElement(expiryMonth).sendKeys("07");
		
		driver.findElement(expiryYear).sendKeys("2027");
		
		act.scrollByAmount(0, 300).perform();
		
		driver.findElement(payBtn).click();
		
	}
	
	public boolean orderPlacedDisplayed() {
		return driver.findElement(orderConfirmation).isDisplayed();
	}
	

}


