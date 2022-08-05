package commonutilities;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class BaseTest {

	WebDriver driver;
	public static ExtentReports report;
	public static ExtentTest test;
	public WebDriver initializeDriver(String browserName, String driverPath) throws IOException {
		
		switch (browserName)
		{
		case "chrome":
			System.setProperty("webdriver.chrome.driver", driverPath);
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			break;
			
		case "firefox":
			driver = new FirefoxDriver();
			System.setProperty("webdriver.gecko.driver", driverPath);
			driver.manage().window().maximize();
			break;

		case "edge":
			driver = new EdgeDriver();
			System.setProperty("webdriver.edge.driver", driverPath);
			driver.manage().window().maximize();
			break;
		default:
			System.out.println("browser : " + browserName
					+ " is invalid, Launching chrome as browser of choice..");
			System.setProperty("webdriver.chrome.driver", driverPath);
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			
		}
		
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		return driver;

	}
	
	public void closeAll()
	{
		driver.close();
		driver.quit();
		System.out.println("End of the Test");
		
	}
	
	
	public WebDriver getDriver() {
	        return driver;
	    }

}
