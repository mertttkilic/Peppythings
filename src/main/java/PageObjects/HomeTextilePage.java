package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomeTextilePage {
	public WebDriver driver;
	
	By dekorasyonUrunAdedi = By.xpath("//li[@data-term-id='137']/label/span[@class='wpfDisplay']/span[@class='wpfCount']");
	By dekorasyonUrunleri = By.xpath("//div[@class='product-small box ']");
	By minPrice = By.id("wpfMinPrice");
	By maxPrice = By.id("wpfMaxPrice");
	By searchButton = By.xpath("//input[@placeholder='Search ...']");
	By markaOptions = By.xpath("//div[@class='product-small box '] //div[@class='box-text box-text-products text-center grid-style-2']/div/p//a[@class='woocommerce-LoopProduct-link woocommerce-loop-product__link']");
	By lokalYumakButton = By.xpath("//label[@aria-label='Lokalyumak']");
	By dekorasyonUrunleriAdları = By.xpath("//a[@class='woocommerce-LoopProduct-link woocommerce-loop-product__link']");
	
	public HomeTextilePage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public WebElement getdekorasyonUrunAdedi()
	{
		return driver.findElement(dekorasyonUrunAdedi);
	}
	
	public List<WebElement> getdekorasyonUrunleri()
	{
		return driver.findElements(dekorasyonUrunleri);
	}
	
	public WebElement getMinPrice ()
	{
		return driver.findElement(minPrice);
	}
	
	public WebElement getMaxPrice ()
	{
		return driver.findElement(maxPrice);
	}
	
	public WebElement getsearchButton ()
	{
		return driver.findElement(searchButton);
	}
	
	public List<WebElement> getmarkaOptions() 
	{
		return driver.findElements(markaOptions);
	} 

	public WebElement getlokalYumakButton() 
	{
		return driver.findElement(lokalYumakButton);
	}
	
	public List<WebElement> getdekorasyonUrunleriAdları()
	{
		return driver.findElements(dekorasyonUrunleriAdları);
	}
	
}
