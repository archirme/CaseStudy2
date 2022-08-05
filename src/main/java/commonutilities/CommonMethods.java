package commonutilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

import pageObjects.ibibopage;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class CommonMethods {

	private WebDriver driver=null;
	private Properties prop=null;
	FileInputStream fs=null;
	protected static final Logger Log = LogManager.getLogger(ibibopage.class.getName());

/*
	public WebDriver getDriver() {
		return this.driver;
	}
*/
	
	public CommonMethods(WebDriver driver) {
		this.driver = driver;
	}

	public String getProp(String key) {
		return prop.getProperty(key);
	}
	
	public WebElement getElementByXpath(String key) 
	{
		return driver.findElement(By.xpath(getProp(key)));
	}
	
	public List<WebElement> getElementsByXpath(String key) 
	{
		return driver.findElements(By.xpath(getProp(key)));
	}
	
	public void selectFromWebElementList(List<WebElement> Options, String key) 
	{
		for(WebElement Option: Options)
	    {
	    	if (Option.getText().contains(key))
	    	{
	    		Option.click();
	    		System.out.println(key + " Selected");
	    		break;
	    	}
	    }	    
	}
	
	public void selectFromDropdown(WebElement ele, String key)
	{
		Select sel = new Select(ele);
		List<WebElement> selOptions = sel.getOptions();
		System.out.println("Number of Options count is " + selOptions.size());		
		for(WebElement Option: selOptions)
	    {
			String Optionname=Option.getText();
	    	if (Optionname.equalsIgnoreCase(key))
	    	{
//	    		Actions actions = new Actions(driver);
//	    		actions.moveToElement(Option).click().build().perform();
	    		sel.selectByVisibleText(key);
//	    		Option.click();
	    		System.out.println(key + " Selected");
	    		break;
	    	}
	    }	    
	}
	
/*
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
*/
	
	public String getScreenShotPath(String testCaseName, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir") + "\\reports\\" + testCaseName + ".png";
		FileUtils.copyFile(source, new File(destinationFile));
		return destinationFile;

	}
	
	public void readWebElementLocators(String filePath) throws IOException
	{
		prop = new Properties();
		FileInputStream fis = new FileInputStream(filePath);
		prop.load(fis);
		fis.close();
	}

	public void launchPage(String URL)
	{
		driver.get(URL);
	}

/*
	public void closeAll()
	{
		driver.close();
		System.out.println("End of the Test");
		
	}
*/
	
	public void clickElement(WebElement ele)
	{
		ele.click();
	}
	
	public void enterText(WebElement ele, String text)
	{
		ele.sendKeys(text);
	}
	
	public void focusOnElement(WebElement ele)
	{
		((RemoteWebDriver) driver).executeScript("arguments[0].scrollIntoView(true);", ele);

	}
	
	public String showtext(WebElement ele) {
		return ele.getText();
	}
	
	public  int monthInNum(String monthS) {
		// TODO Auto-generated method stub
		switch(monthS)
    	{
	    	case "January":
	    		return 1;
	    	case "February":
	    		return 2;
	    	case "March":
	    		return 3;
	    	case "April":
	    		return 4;
	    	case "May":
	    		return 5;
	    	case "June":
	    		return 6;
	    	case "July":
	    		return 7;
	    	case "August":
	    		return 8;
	    	case "September":
	    		return 9;
	    	case "October":
	    		return 10;
	    	case "November":
	    		return 11;
	    	case "December":
	    		return 12;
	    	default:
	    		return 0;   		
	      	}
	}

}
