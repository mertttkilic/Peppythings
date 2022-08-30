package Training1.Peppythings;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import PageObjects.FoodPage;
import PageObjects.MainPage;
import Resources.base;
import Resources.extentReport;

public class FoodPageTest extends base {
	WebDriver driver;
	SoftAssert a = new SoftAssert();
	public static Logger log = LogManager.getLogger(base.class.getName());
	
	@BeforeTest
	public void initiliaze() throws IOException
	{
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
		log.info("Dogru URL e yonlendirildi");
		
	}
	
	@Test(groups= {"Smoke"})
	public void foodFilter () throws InterruptedException
	{
		
		MainPage mp = new MainPage(driver);
		FoodPage fp = new FoodPage(driver);
		mp.getFoodButton().click();
		Thread.sleep(3000);
		fp.getKampanyaButton().click();
		Thread.sleep(3000);
		List<WebElement> list = fp.getPriceTexts();
		List<String> listString = list.stream().map(s->s.getText()).sorted().collect(Collectors.toList());	
		Select s = new Select(fp.getsortDropdown());
		s.selectByIndex(4);
		Thread.sleep(3000);
		ArrayList<String> lis = new ArrayList<String>();
		for(int i=0;i<list.size();i++)
		{
			Thread.sleep(2000);
			list = fp.getPriceTexts();
			lis.add(list.get(i).getText());	
		}
		a.assertEquals(listString, lis);
		log.info("Filtreleme islemi duzgun bir sekilde yapilmistir");
		
		fp.getGıdaButton().click();
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scroll(0,5000)");
		Thread.sleep(4000);
		js.executeScript("window.scroll(0,50)");
		String numbers = Integer.toString(fp.getElements().size());
		char x = '('; char y =')'; String finale = x+numbers+y;
		a.assertEquals(finale, fp.getGıdaNumber().getText());
		if(finale.equals(fp.getGıdaNumber().getText()))
				{
			log.fatal("Gida Button sayim islemi duzgun bir sekilde yapilmamistir.");
				}
		fp.getGucluKadınButton().click();
		Thread.sleep(2000);
		String number = Integer.toString(fp.getElements().size());
		char z = '('; char b =')'; String fin = z+number+b;
		a.assertEquals(fin, fp.getGucluKadınNumber().getText());
		log.info("GucluKadin Button sayim islemi duzgun bir sekilde yapilmistir.");
			
		fp.getKampanyaButton().click();
		Thread.sleep(2000);
		String numbere = Integer.toString(fp.getElements().size());
		char q = '('; char r =')'; String finit = q+numbere+r;
		a.assertEquals(finit, fp.getKampanyaNumber().getText());
		log.info("Kampanya button sayim islemi duzgun bir sekilde yapilmistir.");
		
		
		fp.getSofraButton().click();
		Thread.sleep(2000);
		String num = Integer.toString(fp.getElements().size());
		char l = '('; char m =')'; String finito = l+num+m;
		a.assertEquals(finito, fp.getSofraNumber().getText());
		log.info("Sofra button sayim islemi duzgun bir sekilde yapilmistir.");
		
		
		
		a.assertAll();

			
		
	}
	
	@AfterTest
	public void closeDriver()
	{
		driver.quit();
	}
	
}
