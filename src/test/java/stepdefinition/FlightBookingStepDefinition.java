package stepdefinition;

import java.io.IOException;
import java.text.ParseException;

import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentReports;

import commonutilities.BaseTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.ibibopage;

public class FlightBookingStepDefinition extends BaseTest {

	private WebDriver driver;
	ibibopage ibpg;
	
	@Before
	public void starter() throws IOException
	{
		report= new ExtentReports("C:\\Users\\anilc\\selenium_training\\SDETAssignment\\training\\reports\\ExtentReports.html");
		System.out.println("Start of the Test Suite");
		test=report.startTest("Flight Booking Tests");
		System.out.println("Start of Test");
		driver=initializeDriver("chrome","C:\\Learning\\Drivers\\Chrome\\chromedriver.exe");
	}
	
	@Given("^User launches website successfully for one way trip$")
	public void launchURL() throws IOException
	{
		ibpg = new ibibopage(driver);
		ibpg.readWebElementLocators("C:\\Users\\anilc\\selenium_training\\SDETAssignment\\training\\src\\main\\java\\commonutilities\\ibibo.properties");
		ibpg.launchPage("https://www.goibibo.com");

	}
	
	@When("^All the information entered by the User for one-way flight are proper$")
	public void flightBookingTest() throws IOException, InterruptedException
	{

		String startdate="23-08-2022";
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

	}
	
	@When("^User provides details for \"([^\"]*)\" flight with \"([^\"]*)\" and \"([^\"]*)\" from \"([^\"]*)\" to \"([^\"]*)\" with class as \"([^\"]*)\" for \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
	public void flightBookingTest(String tripType, String startDate, String returnDate, String sourceCity, String destinationCity, String classType, int noOfAdults, int noOfChildren, int noOfInfants) throws IOException, InterruptedException, ParseException
	{

		ibpg.selectTripType(tripType);
		ibpg.selectSourceDestinationCity(sourceCity, destinationCity);
		if (tripType.equals("One-way"))
		ibpg.selectdates(startDate);
		else 
		if (tripType.equals("Round-trip"))
		{
			ibpg.selectdates(startDate,returnDate);
		}
		ibpg.dateselectionaccept(true);
		ibpg.selectpassengers(noOfAdults,noOfChildren,noOfInfants);
		ibpg.selectclass(classType);
		ibpg.passengersandclassaccept(true);

	}

	@Then("^User able to click on Search and get the list of flights available$")
	public void searchflights() throws InterruptedException	
	{
		ibpg.searchflights(true);
		Thread.sleep(5000);
	}
	
	
	@After
	public void cleanup()
	{
		System.out.println("End of Test");
		report.endTest(test);
		closeAll();
		report.flush();
		System.out.println("End of the Test Suite");

	}
}
