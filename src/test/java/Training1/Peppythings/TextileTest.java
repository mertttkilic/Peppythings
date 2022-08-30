package Training1.Peppythings;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import PageObjects.HomeTextilePage;
import PageObjects.MainPage;
import Resources.base;
import Resources.extentReport;

public class TextileTest extends base{

	public WebDriver driver;
	SoftAssert sa = new SoftAssert();
	public static Logger log=LogManager.getLogger(base.class.getName());
	@BeforeTest
	public void initiliaze() throws IOException
	{
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
	}
	
	@Test
	public void textileButtonOpentextilePage() throws InterruptedException  
	{	
		MainPage lp = new MainPage(driver);
		String clicksOnTab = Keys.chord(Keys.CONTROL, Keys.ENTER);
		lp.getnavBarEvDekorasyonButton().sendKeys(clicksOnTab);
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> it = handles.iterator();
		String parentWindowId = it.next();
		String childWindowId = it.next();
		
		driver.switchTo().window(childWindowId);
		log.info("Child Window a gecildi");
		HomeTextilePage htp = new HomeTextilePage(driver);
		if (driver.getCurrentUrl().equals(prop.getProperty("textilePageURL")))
		{
		log.info("Yonlendirilen URL dogrudur.");
		}
		else
		{
		log.fatal("Yonlendirilen URL dogru degildir");
		}
		String no = htp.getdekorasyonUrunAdedi().getText();
		String ab = Integer.toString(htp.getdekorasyonUrunleri().size());
		char x = '('; char y =')'; String finale = x+ab+y;
		if(finale.equals(no))
		{
		log.info("Adet numarası dogrudur.");
		}
		else
		{
		log.fatal("Adet numarası dogru degildir");
		}
		htp.getlokalYumakButton().click();
		Thread.sleep(5000);
		List<WebElement> urunler = htp.getmarkaOptions();
		ArrayList<String> list = new ArrayList<String>();
		for (int i=0;i<urunler.size();i++)
		{
			urunler = htp.getmarkaOptions();
			Thread.sleep(2000);
			String text = urunler.get(i).getText();
			list.add(text);
			System.out.println(text);
		}
	   for (int i=0; i<list.size(); i++)
		{
			if(!list.get(i).contains("Lif"))
			{
				sa.assertTrue(false);
				log.error(list.get(i)+"elementinde lif yazmamaktadır.");
			}
		}
						
		driver.switchTo().window(parentWindowId);
		
		sa.assertAll();
	}
	
	
	@AfterTest
	public void closeDriver()
	{
		driver.quit();
	}
	
	
	
}
