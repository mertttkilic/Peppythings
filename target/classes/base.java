package Resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class base {
	
	public WebDriver driver;
	public Properties prop;
	
	public WebDriver initializeDriver() throws IOException 
	{
		prop = new Properties();
		FileInputStream path = new FileInputStream("C:\\Users\\mertt\\SeleniumProjects\\Peppythings\\src\\main\\java\\Resources\\data.properties");
		prop.load(path);
		String browserName = prop.getProperty("browser");	
		
		if (browserName.equals("chrome")) 
		{
			System.setProperty("webdriver.chrome.driver", "C:/Users/mertt/SeleniumProjects/chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browserName.equals("mozilla")) 
		{
			System.setProperty("webdriver.chrome.driver", "C:/Users/mertt/SeleniumProjects/geckodriver.exe");
			driver = new FirefoxDriver(); 			
			//execute in mozilla driver
		}
		else if(browserName.equals("IE"))
		{
			System.setProperty("webdriver.chrome.driver", "C:/Users/mertt/SeleniumProjects/msedgedriver.exe");
			driver = new EdgeDriver(); 
			//execute in IE driver
		}
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
	}
	
	public void getScreenshotPath(String methodName, WebDriver driver) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source= ts.getScreenshotAs(OutputType.FILE);
		String destinationPath = System.getProperty("user.dir")+"\\reports\\"+methodName+".png";
		FileUtils.copyFile(source, new File(destinationPath));
	}

}
