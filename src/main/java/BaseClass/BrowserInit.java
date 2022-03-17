
package BaseClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserInit 
{

	public  static WebDriver driver;
	public  static WebDriver initRequiredBrowser(String browserName)
	
	{
		if(browserName.equals("CR"))
		{
		System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
		 driver=new ChromeDriver();
		}
		else if(browserName.equals("IE"))
		{
		System.setProperty("webdriver.ie.driver", "Drivers/IEDriverServer.exe");
		 driver=new InternetExplorerDriver();
		}
		if(browserName.equals("Edge"))
		{
		System.setProperty("webdriver.edge.driver", "Drivers/msedgedriver.exe");
		 driver=new EdgeDriver();
		}
		return driver;
	}
	public void browserPreConditions(String url)
	{
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
	
}
