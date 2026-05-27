package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ProductsPage {

	WebDriver driver;
	Actions act;
	WebDriverWait wait;
	
	//Locators 
	
	By productPage = By.xpath("//a[@href='/products']");
	By iframe1 = By.id("aswift_3");
	By closeFrameBtn = By.xpath("//*[text()='Close']");
	By menClothing = By.xpath("//a[@href='#Men']");
	By jeans = By.xpath("//a[@href='/category_products/6']");
	By jeansAddToCart = By.xpath("//div[@class='productinfo text-center']//a[@data-product-id='33']");
	By addToCartMsg = By.xpath("//h4[text()='Added!']");
	By viewCart = By.xpath("//u[text()='View Cart']");
	By quantity = By.xpath("//button[text()='1']");
	
	
	public ProductsPage(WebDriver driver) {
		this.driver = driver;
		this.act = new Actions(driver);
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	public void openProductPage() {
		//driver.findElement(productPage).click();
		wait.until(ExpectedConditions.elementToBeClickable(productPage)).click();
	
	}
	
	public void closeAdPopup() {

		driver.switchTo().frame(driver.findElement(iframe1)); 
		
		driver.findElement(closeFrameBtn).click();
		
		driver.switchTo().defaultContent();
		
	} 
	
	public void selectJeans() {
		driver.findElement(menClothing).click();
		
		act.scrollByAmount(0, 500).perform();
		
		wait.until(ExpectedConditions.elementToBeClickable(jeans)).click();

		act.scrollByAmount(0, 500).perform();

		wait.until(ExpectedConditions.elementToBeClickable(jeansAddToCart)).click();
		
		Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(addToCartMsg)).isDisplayed());
		
		driver.findElement(viewCart).click();
		
	}
	
	public void verifyCart() {
		
		String expectedUrl = "https://automationexercise.com/view_cart"; 
		
		String actualUrl = driver.getCurrentUrl();
		
		Assert.assertEquals(actualUrl, expectedUrl); 
		
		Assert.assertEquals(wait.until(ExpectedConditions.visibilityOfElementLocated(quantity)).getText(),"1");
	}
	
			
} 
			

