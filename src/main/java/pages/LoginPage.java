package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	
	
	WebDriver driver; 
	By consentBtn = By.xpath("//p[@class='fc-button-label']");
	By loginAccountLocator = By.xpath("//a[@href='/login']");
	By emailInputLocator = By.xpath("//input[@type='email']");
	By passwordInputLocator = By.xpath("//input[@type='password']"); 
	By loginBtnLocator = By.xpath("//button[text()='Login']"); 
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickConsent() {
		driver.findElement(consentBtn).click();
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
	
	public void executeLogin( String email, String password) {
		clickConsent();
		loginAccount();
		inputEmail(email); 
		inputPassword(password);
		clickLoginButton();
	}
	
}