package utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverDetails 
{
	public static WebDriver driver;
		
	public static WebDriver InitializeChromedriver()
	{
		try
		{
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		return driver;
	}
	
	public static WebDriver InitializeFirefoxDriver()
	{
		System.setProperty("webdriver.gecko.driver", 
				"G:/Selenium JARS/geckodriver-v0.16.1-win64/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	
	public static WebDriver GetDriverInstance()
	{
	return driver;
	}
}
