package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FoodPage {
	public WebDriver driver;
	
	By dusukFiyatBox= By.id("wpfMinPrice");
	By yuksekFiyatBox = By.id("wpfMaxPrice");
	By sortDropdown = By.cssSelector("select.orderby");
	By priceText = By.xpath("//div[@class='price-wrapper']/span/span/bdi");
	By kampanyaButton = By.xpath("//label[@aria-label='Kampanyalar']");
	By gıdaButton = By.xpath("//label[@aria-label='Gıda']");
	By gucluKadınButton = By.xpath("//label[@aria-label='Güçlü Kadınların Ürünleri']");
	By sofraButton = By.xpath("//label[@aria-label='Sofra & Mutfak']");
	By gıdaNumber = By.xpath("//li[@data-term-id='354']/label//span[@class='wpfDisplay selected']//span[@class='wpfCount']");
	By gucluKadınNumber = By.xpath("//li[@data-term-id='443']/label//span[@class='wpfDisplay selected']//span[@class='wpfCount']");
	By kampanyaNumber = By.xpath("//li[@data-term-id='283']/label//span[@class='wpfDisplay selected']//span[@class='wpfCount']");
	By sofraNumber = By.xpath("//li[@data-term-id='142']/label//span[@class='wpfDisplay selected']//span[@class='wpfCount']");
	By elements = By.xpath("//div[@class='products row row-small large-columns-3 medium-columns-3 small-columns-2 has-shadow row-box-shadow-1 has-equal-box-heights equalize-box']/div");

	public FoodPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public WebElement getDusukFiyatBox ()
	{
		return driver.findElement(dusukFiyatBox);
	}
	
	public WebElement getyuksekFiyatBox ()
	{
		return driver.findElement(yuksekFiyatBox);
	}
	
	public WebElement getsortDropdown ()
	{
		return driver.findElement(sortDropdown);
	}
	
	public List<WebElement> getPriceTexts ()
	{
		return driver.findElements(priceText);
	}
	
	public WebElement getKampanyaButton()
	{
		return driver.findElement(kampanyaButton);
	}
	
	public WebElement getGıdaButton()
	{
		return driver.findElement(gıdaButton);
	}
	public WebElement getGucluKadınButton()
	{
		return driver.findElement(gucluKadınButton);
	}
	public WebElement getSofraButton()
	{
		return driver.findElement(sofraButton);
	}
	
	public WebElement getKampanyaNumber()
	{
		return driver.findElement(kampanyaNumber);
	}
	
	public WebElement getGıdaNumber()
	{
		return driver.findElement(gıdaNumber);
	}
	public WebElement getGucluKadınNumber()
	{
		return driver.findElement(gucluKadınNumber);
	}
	public WebElement getSofraNumber()
	{
		return driver.findElement(sofraNumber);
	}
	
	public List<WebElement> getElements()
	{
		
		return driver.findElements(elements);
	}
}
