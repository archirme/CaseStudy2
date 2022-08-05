package sdet.training;

import java.io.IOException;
import java.text.ParseException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import commonutilities.BaseTest;
import pageObjects.ibibopage;

@Listeners(listener.ListenerSupport.class)

public class ibiboFlightBookingTest extends BaseTest
{
	private WebDriver driver;
	ibibopage ibpg;

	@BeforeSuite
	public void startsuite() throws IOException
	{
		report= new ExtentReports("C:\\Users\\anilc\\selenium_training\\SDETAssignment\\training\\reports\\ExtentReports.html");
		System.out.println("Start of the Test Suite");
	}
	
	@BeforeClass
	public void starclass()
	{
//		test=report.startTest("Flight Booking Tests");
	}
	
	@BeforeMethod
	public void setup() throws IOException
	{
		test=report.startTest("Flight Booking Tests");
		System.out.println("Start of Test");
		driver=initializeDriver("chrome","C:\\Learning\\Drivers\\Chrome\\chromedriver.exe");
		ibpg = new ibibopage(driver);
		ibpg.readWebElementLocators("C:\\Users\\anilc\\selenium_training\\SDETAssignment\\training\\src\\main\\java\\commonutilities\\ibibo.properties");
		ibpg.launchPage("https://www.goibibo.com");
	}
	
	@Test
	public void onewayTest() throws IOException, InterruptedException
	{

		String startdate="26-07-2022";
		int adultno=1;	
		int childrenno=0;
		int infantsno=0;
		ibpg.selectTripType("One-way");
		ibpg.selectSourceDestinationCity("Ahmedabad", "Chennai");
		ibpg.selectdates(startdate);
		ibpg.dateselectionaccept(true);
		ibpg.selectpassengers(adultno,childrenno,infantsno);
		ibpg.selectclass("Economy");
		ibpg.passengersandclassaccept(true);
		ibpg.searchflights(true);
		Thread.sleep(50000);

	}

	
	@Test
	public void roundtripTest() throws IOException, InterruptedException, ParseException
	{
		String startdate="26-07-2022";
		String returndate="05-08-2022";
		int adultno=2;	
		int childrenno=1;
		int infantsno=1;
		ibpg.selectTripType("Round-trip");
		ibpg.selectSourceDestinationCity("Coimbatore", "Chennai");
		ibpg.selectdates(startdate,returndate);
		ibpg.dateselectionaccept(true);		
		ibpg.selectpassengers(adultno,childrenno,infantsno);
		ibpg.selectclass("Business");
		ibpg.passengersandclassaccept(true);
		ibpg.searchflights(true);
		Thread.sleep(50000);
	}
	
	@AfterMethod
	public void cleanup()
	{
		System.out.println("End of Test");
		report.endTest(test);
		closeAll();
	}
	
	@AfterClass
	public void afterclass()
	{
//		report.endTest(test);
	}
	
	@AfterSuite
	public void endsuite()
	{
		report.flush();
		System.out.println("End of the Test Suite");
	}

}	

