package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {

	WebDriver driver;
	
	By loginButton = By.xpath("//ul[@class='header-nav header-nav-main nav nav-right '] //a[@href='https://www.peppythings.com/hesabim/'] ");
	By navBarGıdaButton = By.xpath("//ul[@class='nav header-nav header-bottom-nav nav-center  nav-line-bottom nav-size-medium nav-spacing-xlarge'] //a[@href='https://www.peppythings.com/urun-kategori/gida/']");
	By navBarEvDekorasyonButton = By.xpath("//ul[@class='nav header-nav header-bottom-nav nav-center  nav-line-bottom nav-size-medium nav-spacing-xlarge'] //a[@href='https://www.peppythings.com/urun-kategori/ev-dekorasyon/']");
	By logo = By.xpath("//img[@class='header_logo header-logo']");
	By evTekstil = By.id("menu-item-1061");
	By navBarLinks = By.xpath("//ul[@class='nav top-bar-nav nav-right nav-small  nav-divided'] //a[@class='nav-top-link']");
	By foodButton = By.xpath("//li[@id='menu-item-5792']/a");
	
	public MainPage (WebDriver driver)
	{
		this.driver=driver;
	}
	
	public WebElement getLogin() 
	{
		return driver.findElement(loginButton);
	}
	
	public WebElement getnavBarGıdaButton () 
	{
		return driver.findElement(navBarGıdaButton);
	}
	
	public WebElement getnavBarEvDekorasyonButton () 
	{
		return driver.findElement(navBarEvDekorasyonButton);
	}
	
	public WebElement getlogo () 
	{
		return driver.findElement(logo);
	}
	
	public WebElement getEvTekstil () 
	{
		return driver.findElement(evTekstil);
	}
	
	public List<WebElement> getnavBarLinks()
	{
		return driver.findElements(navBarLinks);
	}
	
	public WebElement getFoodButton () 
	{
		return driver.findElement(foodButton);
	}	
	

}
