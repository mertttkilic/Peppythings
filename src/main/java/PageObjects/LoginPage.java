package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	WebDriver driver;
	
	By signInEmail = By.id("username");
	By signInPassword= By.id("password");
	By signInButton= By.cssSelector("button[class*='woocommerce-form-login__submit']");
	By signUpEmail= By.id("reg_email");
	By signUpPassword= By.id("reg_password");
	By signUpButton = By.cssSelector("button[class*='commerce-form-register__submit']");
	By text = By.xpath("//div[@class='woocommerce-MyAccount-content']/p/strong[1]");
	By exitButton = By.linkText("Çıkış yapın");
	By dashboardLinks = By.xpath("//ul[@class='dashboard-links']/li/a");
	
	public LoginPage (WebDriver driver)
	{
		this.driver=driver;
	}
	
	public WebElement getSignInEmail()
	{
		return driver.findElement(signInEmail);
	}
	
	public WebElement getSignInPassword()
	{
		return driver.findElement(signInPassword);
	}
	
	public WebElement getSignInButton()
	{
		return driver.findElement(signInButton);
	}
	
	public WebElement getSignUpEmail()
	{
		return driver.findElement(signUpEmail);
	}
	
	public WebElement getSignUpPassword()
	{
		return driver.findElement(signUpPassword);
	}
	
	public WebElement getSignUpButton()
	{
		return driver.findElement(signUpButton);
	}
	
	public WebElement getText()
	{
		return driver.findElement(text);
	}
	
	public WebElement getExitButton()
	{
		return driver.findElement(exitButton);
	}
	
	public List<WebElement> getDashboardLinks()
	{
		return driver.findElements(dashboardLinks);
	}
}
