package Training1.Peppythings;

import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import PageObjects.MainPage;
import Resources.base;
import Resources.extentReport;

public class MainPageTest extends base {

	WebDriver driver;
	SoftAssert a = new SoftAssert();
	public static Logger log = LogManager.getLogger(base.class.getName());

	@BeforeTest
	public void initiliaze() throws IOException
	{
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
	}
	
	@Test
	public void firstTest() throws IOException 
	{
		MainPage lp = new MainPage(driver);
		a.assertTrue(lp.getlogo().isDisplayed());
		log.info("Logo duzgun goruntulendi");
		a.assertEquals(driver.getCurrentUrl(), prop.getProperty("mainPageURL"));
		List<WebElement> navBarLinks = lp.getnavBarLinks();
		for (int i=0;i<navBarLinks.size();i++)
		{
			String url = navBarLinks.get(i).getAttribute("href");
			HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
			conn.setRequestMethod("HEAD");
			conn.connect();
			int respCode = conn.getResponseCode();
			a.assertTrue(respCode<400,"The link with text" + navBarLinks.get(i).getText()+ "is broken with code " + respCode);
			log.info(navBarLinks.get(i).getText() + "linki duzgun calismaktadir.");
		}
	}
	@AfterTest
	public void closeDriver()
	{
		a.assertAll();
		driver.close();
	}
	
}
