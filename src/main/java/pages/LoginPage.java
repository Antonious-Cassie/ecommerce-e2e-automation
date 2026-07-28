package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.TimeoutException;

public class LoginPage {
	
	
	WebDriver driver; 
	By consentBtn = By.xpath("//p[@class='fc-button-label']");
	By loginAccountLocator = By.xpath("//a[@href='/login']");
	By emailInputLocator = By.xpath("//input[@type='email']");
	By passwordInputLocator = By.xpath("//input[@type='password']"); 
	By loginBtnLocator = By.xpath("//button[text()='Login']"); 
	By errorMessageLocator = By.xpath("//p[text()='Your email or password is incorrect!']");
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickConsent() {

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

	    try {
	        WebElement consentButton = wait.until(
	            ExpectedConditions.elementToBeClickable(consentBtn)
	        );

	        consentButton.click();

	        wait.until(
	            ExpectedConditions.invisibilityOfElementLocated(
	                By.className("fc-dialog-overlay")
	            )
	        );

	    } catch (TimeoutException e) {
	        
	    }
	}
	
	public void loginAccount() {
		driver.findElement(loginAccountLocator).click();
	}

	public void inputEmail(String email) {
		driver.findElement(emailInputLocator).sendKeys(email);
		
	}
	
	public void inputPassword(String password) {
		driver.findElement(passwordInputLocator).sendKeys(password);
	}

	public void clickLoginButton() {
		driver.findElement(loginBtnLocator).click();	
		}
	
	public boolean isErrorMessageDisplayed() {
	    return driver.findElement(errorMessageLocator).isDisplayed();
	}
	
	public void executeLogin( String email, String password) {
		clickConsent();
		loginAccount();
		inputEmail(email); 
		inputPassword(password);
		clickLoginButton();
	}
	
}