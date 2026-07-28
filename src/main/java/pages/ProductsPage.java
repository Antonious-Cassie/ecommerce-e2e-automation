package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.openqa.selenium.JavascriptExecutor;

public class ProductsPage {

	WebDriver driver;
	Actions act;
	WebDriverWait wait;
	
	
	By productPage = By.xpath("//a[@href='/products']");
	By iframe1 = By.id("aswift_3");
	
	By closeFrameBtn = By.xpath("//*[text()='Close']");
	
	By menClothing = By.xpath("//a[@href='#Men']");
	By jeans = By.xpath("//a[@href='/category_products/6']");
	By jeansAddToCart = By.xpath("//div[@class='productinfo text-center']//a[@data-product-id='33']");
	By addToCartMsg = By.xpath("//h4[text()='Added!']");
	By viewCart = By.xpath("//u[text()='View Cart']");
	By quantity = By.xpath("//button[normalize-space()='1']");
	By Tshirts = By.xpath("//a[text()='Tshirts ']");
	By GreenShirt = By.xpath("//a[@data-product-id=\"29\"]");
	By ContinueBtn = By.xpath("//button[text()='Continue Shopping']");
	By PoloShirt = By.xpath("//a[@data-product-id=\"30\"]");
	By GraphicShirt = By.xpath("//a[@data-product-id=\"43\"]");
	By straightJeans = By.xpath("//a[@data-product-id=\"35\"]");
	By slimJeans = By.xpath("//a[@data-product-id=\"37\"]");
	By cartItems = By.xpath("//table[@id='cart_info_table']//tbody/tr");
	By greenShirtDescription = By.xpath("//a[text()='Green Side Placket Detail T-Shirt']");
	By poloShirtDescription = By.xpath("//a[text()='Premium Polo T-Shirts']"); 
	By slimJeansDescription = By.xpath("//a[text()='Grunt Blue Slim Fit Jeans']");
	By removeSlimJeans = By.xpath("//a[@data-product-id=\"37\"]");
	By removeGraphicShirt = By.xpath("//a[@data-product-id=\"43\"]");
	By straightJeansDescription = By.xpath("//a[text()='Regular Fit Straight Jeans']");
	By logoutBtn = By.xpath("//a[@href='/logout']");
	By loginAccountLocator = By.xpath("//a[@href='/login']");
	
	

	
	public ProductsPage(WebDriver driver) {
		this.driver = driver;
		this.act = new Actions(driver);
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	public void openProductPage() {
	    wait.until(ExpectedConditions.elementToBeClickable(productPage)).click();
	}
	

	public void closeAdPopup() {
	    try {
	        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iframe1));
	        wait.until(ExpectedConditions.elementToBeClickable(closeFrameBtn)).click();
	    } catch (Exception e) {
	        System.out.println("Advert not present — continuing.");
	    } finally {
	        driver.switchTo().defaultContent();
	    }
	}
	
	public void selectJeans() {
		driver.findElement(menClothing).click();
		
		act.scrollByAmount(0, 500).perform();
		
		wait.until(ExpectedConditions.elementToBeClickable(jeans)).click();

		act.scrollByAmount(0, 500).perform();

		wait.until(ExpectedConditions.elementToBeClickable(jeansAddToCart)).click();
		
		Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(addToCartMsg)).isDisplayed());
		
		wait.until(ExpectedConditions.elementToBeClickable(viewCart)).click();
		
	}
	
	public void verifyCart() {

	    String expectedUrl = "https://automationexercise.com/view_cart";

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	    wait.until(ExpectedConditions.urlToBe(expectedUrl));

	    Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);
	}
	
	public void removeItemFromCart() {

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

	    WebElement removeButton = wait.until(
	        ExpectedConditions.elementToBeClickable(
	            By.className("cart_quantity_delete")
	        )
	    );

	    removeButton.click();

	    wait.until(ExpectedConditions.stalenessOf(removeButton));
	}
	
	public String getEmptyCartMessage() {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); 
		
		
		WebElement emptyCart = wait.until(
			    ExpectedConditions.visibilityOfElementLocated(
			        By.xpath("//*[contains(normalize-space(), 'Cart is empty!')]"))
			);
	    return emptyCart.getText();
	}
	
	
	
	public void addGreenShirtToCart() {
		
		driver.findElement(menClothing).click();
		
		act.scrollByAmount(0, 500).perform();
		
		wait.until(ExpectedConditions.elementToBeClickable(Tshirts)).click();
		
		driver.findElement(GreenShirt).click(); 
		
		wait.until(ExpectedConditions.elementToBeClickable(ContinueBtn)).click();
		
		
		
	}
	
	public void addPoloShirtToCart() {
		
		act.scrollByAmount(0, 800).perform(); 
		
		driver.findElement(PoloShirt).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(ContinueBtn)).click();
	}
	
	
	public void addGraphicShirt() {
		
		driver.findElement(GraphicShirt).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(ContinueBtn)).click(); 
		
	} 
	
	
	public void selectJeansCategory() {
		
		act.scrollByAmount(0, -500).perform();
		
		WebElement men = wait.until(ExpectedConditions.elementToBeClickable(menClothing));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", men);
		
		wait.until(ExpectedConditions.elementToBeClickable(jeans)).click();
		
		
	}
	
	
	public void addStraightJeansToCart() {
		
		act.scrollByAmount(0, 500).perform();
		
		driver.findElement(straightJeans).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(ContinueBtn)).click();
		
	}
	
	
	public void addSlimJeansToCart() {
		
		driver.findElement(slimJeans).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(viewCart)).click();
	}
	
	
	public int cartItemTotal() {
		return driver.findElements(cartItems).size();
	}
	
	
	public boolean greenShirtDisplayed() {
		return driver.findElement(greenShirtDescription).isDisplayed();
	}
	
	
	public boolean poloShirtDisplayed() {
		return driver.findElement(poloShirtDescription).isDisplayed();
	}
	
	
	public boolean slimJeansDisplayed() {
		return driver.findElement(slimJeansDescription).isDisplayed();
		}
	
	
	public void removeSlimJeans() {
		driver.findElement(removeSlimJeans).click();
		
	}
	
	public void removeGraphicTshirt() {
		
		driver.findElement(removeGraphicShirt).click();
	}
	
	
	public boolean straightJeansDisplayed() {
		return driver.findElement(straightJeansDescription).isDisplayed();
	}
	
	
	public void waitForCartToUpdate() {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.numberOfElementsToBe(cartItems, 3));
	}
	
	
	public void logout() {
		driver.findElement(logoutBtn).click();
	}
	
	
	public boolean loginBtnDisplayed() {
		return driver.findElement(loginAccountLocator).isDisplayed();
	}
	
	
	public boolean loginURLDisplayed() {
		return driver.getCurrentUrl().equals("https://automationexercise.com/login");
	}
	
			 
} 
			

