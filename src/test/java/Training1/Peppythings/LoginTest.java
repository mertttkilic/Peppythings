package Training1.Peppythings;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import PageObjects.LoginPage;
import Resources.base;
import Resources.extentReport;

public class LoginTest extends base {
	WebDriver driver;
	SoftAssert a = new SoftAssert();
	public static Logger log = LogManager.getLogger(base.class.getName());
	
	@BeforeTest
	public void initiliaze() throws IOException
	{
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));	
	}
	
	@Test (dataProvider ="getData")
	public void loginTest(String username, String password) throws InterruptedException
	{
		driver.switchTo().newWindow(WindowType.WINDOW);
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> it = handles.iterator();
		String parentWindow = it.next();
		String childWindow =it.next();
		driver.switchTo().window(childWindow);
		driver.manage().window().maximize();
		driver.get(prop.getProperty("loginPageURL"));
		LoginPage lp = new LoginPage(driver);
		lp.getSignUpEmail().sendKeys(username);
		lp.getSignUpPassword().sendKeys(password);
		lp.getSignUpButton().click();
 		Thread.sleep(3000);
 		String text1 = username.split("@")[0];
 		a.assertEquals(text1, lp.getText().getText());
 		log.info("username sonraki sayfada duzgun goruntulenmistir.");
 		lp.getExitButton().click();
 		a.assertAll();
	}
	
	@Test(dependsOnMethods= {"loginTest"}, dataProvider ="getData") 
	public void loginPageTextTest (String username, String password) throws InterruptedException
	{
		driver.switchTo().newWindow(WindowType.WINDOW);
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> it = handles.iterator();
		String parentWindow = it.next();
		String childWindow =it.next();
		driver.switchTo().window(childWindow);
		driver.manage().window().maximize();
		driver.get(prop.getProperty("loginPageURL"));
		LoginPage lp = new LoginPage(driver);
		lp.getSignInEmail().sendKeys(username);
		lp.getSignInPassword().sendKeys(password);
		lp.getSignInButton().click();
		Thread.sleep(3000);
		a.assertEquals(lp.getDashboardLinks().size(),6);
		log.info("6 tane alan siralanmistir");
		ArrayList<String> linksTexts = new ArrayList<String>(Arrays.asList("","Siparişler","Adres","Hesap detayları","Vendors","Favorilerim"));
		ArrayList<String> links = new ArrayList<String>();
		for (int i=0; i<lp.getDashboardLinks().size();i++)
		{
			links.add(lp.getDashboardLinks().get(i).getText());
		}
		System.out.println(links);
		a.assertEquals(links, linksTexts);
		log.info("Kutucuklarda yazılan degerle beklenildigi gibidir.");
		lp.getExitButton().click();
		
		
		a.assertAll();
	}
	
	
	@DataProvider
	public Object[][] getData()
	{
		Object [][] data = new Object [2][2];
		
		data [0][0] = "mert7890@gmail.com";
		data [0][1] = "1234";
		
		data [1][0] = "mert4582@gmail.com";
		data [1][1] = "12345";
		return data;
	}
	
		
	
	
	@AfterTest
	public void closeDriver()
	{
		driver.quit();
	}
}
