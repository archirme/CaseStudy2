package pageObjects;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import commonutilities.CommonMethods;


public class ibibopage extends CommonMethods {
	
	WebDriver driver;
	
	@FindBy(xpath = "//li[@class='sc-fbyfCU gouzLm']")
	WebElement oneway;

	@FindBy(xpath = "//li[@class='sc-fbyfCU BXfBL'][1]")
	WebElement roundtrip;

	@FindBy(xpath = "//li[@class='sc-fbyfCU BXfBL'][2]")
	WebElement multicity;

	@FindBy(xpath = "//div[@class='sc-hiCibw dGZLZw']")
	WebElement fromcity;

	@FindBy(xpath = "//div[@class='sc-cidDSM dOEpbS']/input[@type='text']")
	WebElement entercitytxt;

	@FindBy(xpath = "(//div[@class='sc-iAKWXU iyyKqe'])[1]")
	WebElement select1stcity;

	@FindBy(xpath = "//div[@class='sc-hiCibw hIEqKD']")
	WebElement tocity;

	@FindBy(xpath = "//div[@class='DayPicker-Month']")
	WebElement calmonth;

	@FindBy(xpath = "//div[@class='DayPicker-Week']/div[@class='DayPicker-Day']")
	WebElement calday;

	@FindBy(xpath = "//div[@class='DayPicker-Month'][1]//div[contains (@class, 'DayPicker-Day') and not(contains (@class, 'DayPicker-Day--disabled'))]/p[@class='fsw__date']")
	List<WebElement> caldays1stM;
	
	@FindBy(xpath = "//div[@class='DayPicker-Week']/div[@class='DayPicker-Day DayPicker-Day--today']")
	WebElement calcurdate;

	@FindBy(xpath = "//div[@class='DayPicker-Week']/div[@class='DayPicker-Day DayPicker-Day--start DayPicker-Day--selected']")
	WebElement selstardate;

	@FindBy(xpath = "//div[@class='DayPicker-Week']/div[@class='DayPicker-Day DayPicker-Day--end DayPicker-Day--selected']")
	WebElement selenddate;

	@FindBy(xpath = "//div[@class='DayPicker-Week']/div[@class='DayPicker-Day DayPicker-Day--disabled']")
	WebElement disableddate;

	@FindBy(xpath = "//div/span[@role='presentation'][@class='fswTrvl__cancel']")
	WebElement candatesel;

	@FindBy(xpath = "//div/span[@role='presentation'][@class='fswTrvl__done']")
	WebElement donedatesel;

	@FindBy(xpath = "//div[@class='sc-jJoQJp gzcbaP']")
	WebElement travelnclass;

	@FindBy(xpath = "//div/div/p/span[@class='sc-kfPuZi dprjVP fswDownArrow fswDownArrowTraveller']")
	WebElement travelnclass2;

	@FindBy(xpath = "(//span[@class='sc-faUpoM jSgnBw'])[1]")
	WebElement adultsm;

	@FindBy(xpath = "(//div/span[@class='sc-Galmp clPQEB'])[1]")
	WebElement adultss;

	@FindBy(xpath = "(//span[@class='sc-faUpoM jSgnBw'])[2]")
	WebElement adultsp;

	@FindBy(xpath = "(//span[@class='sc-faUpoM jSgnBw'])[3]")
	WebElement childrenm;

	@FindBy(xpath = "(//span[@class='sc-faUpoM jSgnBw'])[4]")
	WebElement childrenp;

	@FindBy(xpath = "(//div/span[@class='sc-Galmp clPQEB'])[2]")
	WebElement childrens;

	@FindBy(xpath = "(//span[@class='sc-faUpoM jSgnBw'])[5]")
	WebElement infantsm;

	@FindBy(xpath = "(//span[@class='sc-faUpoM jSgnBw'])[6]")
	WebElement infantsp;

	@FindBy(xpath = "(//div/span[@class='sc-Galmp clPQEB'])[3]")
	WebElement infantss;

	@FindBy(xpath = "//div[@class='sc-jeraig auKqD']//li[1]")
	WebElement classeco;
	
	@FindBy(xpath = "//div[@class='sc-jeraig auKqD']//li[2]")
	WebElement classpeco;

	@FindBy(xpath = "//div[@class='sc-jeraig auKqD']//li[3]")
	WebElement classbuss;

	@FindBy(xpath = "//div[@class='sc-jeraig auKqD']//li[4]")
	WebElement classfirst;
	
	@FindBy(xpath = "//div/a[@class='sc-hOGkXu hAcfuc']")
	WebElement cantravelnclass;

	@FindBy(xpath = "//div/a[@class='sc-dtMgUX daltrV']")
	WebElement donetravelnclass;

	@FindBy(xpath = "//div/span[@class='sc-fHeRUh jHgPBA']")
	WebElement searchflights;

	@FindBy(xpath = "//div[@class='DayPicker-Day']")
	List<WebElement> days;

	@FindBy(xpath = "(//div[@class='DayPicker-Months']/div[@class='DayPicker-Month']/div[@class='DayPicker-Caption'])[1]/div")
	WebElement display1stmonyr;

	@FindBy(xpath = "//div/span[@class='DayPicker-NavButton DayPicker-NavButton--next']")
	WebElement nextmonth;

	public ibibopage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		PropertyConfigurator.configure("log4j.properties");
	}

	
	public void searchflights(boolean accept)
	{
		if (accept=true)
		{
//			WebDriverWait wait = new WebDriverWait(driver,10);
//			wait.until(ExpectedConditions.elementToBeClickable(searchflights));
			clickElement(searchflights);
			Log.info("Search Flight Button is clicked");
		}
		else
		{	
			System.out.println("Search is not initiaited");
			Log.error("Search is not initiaited");
		}
	}
	
	
	public void dateselectionaccept(boolean accept)
	{
		if (accept=true)
		{	
			clickElement(donedatesel);
			Log.info("Start and/or Return Date selected");
		}
		else
		{
			clickElement(candatesel);
			Log.error("Start and/or Return Date not selected");

		}
	}
	

	public void passengersandclassaccept(boolean accept)
	{
		if (accept=true)
		{
			clickElement(donetravelnclass);
			Log.info("Passenger and class selected");
		}
		else
		{
			clickElement(cantravelnclass);
			Log.error("Passenger and class not selected");

		}
	}
	
	public void selectdates(String startdate, String returndate) throws ParseException
	{	
    	DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd-MM-yyyy");

		LocalDate today = LocalDate.now();
		LocalDate startdt= LocalDate.parse(startdate,formatter1);
		LocalDate startp2 = LocalDate.now().plusDays(2);
		
	    if (startdt.isAfter(startp2))
	    {
	    	selectDateFromCalender(startdate);
	    	selectDateFromCalender(returndate);
	    	System.out.println("start date" + startdate);
	    	System.out.println("start date + 2" + startp2);
	    	System.out.println("system date" + today);
	    }
	    else if (startdt.equals(today) || startdt.isAfter(today) )
	    {
	    	String tempdate = LocalDate.now().plusDays(4).format(DateTimeFormatter.ofPattern("dd-MM-yyyy")).toString();
	    	selectDateFromCalender(tempdate);
	    	selectDateFromCalender(startdate);
	    	selectDateFromCalender(returndate);
	    	System.out.println("start date" + startdate);
	    	System.out.println("start date + 2" + startp2);
	    	System.out.println("start date + 4"+ tempdate);
	    	System.out.println("system date" + today);
	    }
	    else if (startdt.isBefore(today))
	    {
	    	System.out.println("The start date is not valid");
	    	System.out.println("start date" + startdate);
	    	System.out.println("start date + 2" + startp2);
	    	System.out.println("system date" + today);
//	    	Assert.assertTrue(false);
	    }
	}
	
	public void selectdates(String startdate)
	{	
		selectDateFromCalender(startdate);
	}
	
	public void selectSourceDestinationCity(String sourcecity, String destinationcity) {
	
		clickElement(fromcity);
		enterText(entercitytxt, sourcecity);
		System.out.println("City selected is " + select1stcity.getText());
		if (select1stcity.getText().contains(sourcecity))
		clickElement(select1stcity);
		else
			System.out.println("The source city " + sourcecity + " Not found");
		
		clickElement(tocity);
		enterText(entercitytxt, destinationcity);
		System.out.println("City selected is " + select1stcity.getText());
		if (select1stcity.getText().contains(destinationcity))
		clickElement(select1stcity);
		else
			System.out.println("The destination city " + destinationcity + " Not found");
	}
	
	public void selectTripType(String triptype) {
		switch(triptype)
    	{
	    	case "One-way":
	    		if (oneway.getText().equals(triptype))
	    			clickElement(oneway);
	    		break;
	    	case "Round-trip":
	    		System.out.println("The Trip type is " + roundtrip.getText() + triptype);
	    		if (roundtrip.getText().equals(triptype))
	    			clickElement(roundtrip);
	    		break;
	    	case "Multi-city":
	    		if (multicity.getText().equals(triptype))
	    			clickElement(multicity);
	    		break;
	    	default:
				Log.error("Trip type is not a valid input");	
	    		break;
    	}
		
	}

	private void selectInfants(int numOfInfants) {
		System.out.println("Number of Infants" + infantss.getText());
		while(!(numOfInfants==Integer.parseInt(infantss.getText())))
		{
			infantsp.click();
			System.out.println("Number of Infants" + infantss.getText());	
		}
	
	}

	private void selectChildren(int numOfChildren) {
		System.out.println("Number of Children" + childrens.getText());
		while(!(numOfChildren==Integer.parseInt(childrens.getText())))
		{
			childrenp.click();
			System.out.println("Number of Children" + childrens.getText());	
		}
		
	}

	private void selectAdults(int numOfAdult) {
		
		System.out.println("Number of Adults" + adultss.getText());
		while(!(numOfAdult==Integer.parseInt(adultss.getText())))
		{
			adultsp.click();
			System.out.println("Number of Adults" + adultss.getText());	
		}
			
	}

	private void selectDateFromCalender(String datereq)
	{

		String[] reqDate = datereq.split("-");
		int rDate = Integer.parseInt(reqDate[0]);
		int rMonth = Integer.parseInt(reqDate[1]);
		int rYear = Integer.parseInt(reqDate[2]);

		String monthyear = display1stmonyr.getText();
		String[] monthyyyy = monthyear.split("\\s");
		int month = monthInNum(monthyyyy[0]);
		int year = Integer.parseInt(monthyyyy[1]);
		boolean dateSelected = false;

		while (!dateSelected) {
			if (rMonth == month & rYear == year) {
				for (WebElement Day : caldays1stM) {
					System.out.println("Date Day" + Day.getText() + "Req Day " + rDate );
					if (rDate == Integer.parseInt(Day.getText())) {
						Day.click();
						dateSelected = true;
						break;
					}
				}
			} else {
				nextmonth.click();
				monthyear = display1stmonyr.getText();
				monthyyyy = monthyear.split("\\s");
				month = monthInNum(monthyyyy[0]);
				year = Integer.parseInt(monthyyyy[1]);
				
			}
		}
	
	}

	public void selectclass(String classtype) {
		
		switch(classtype)
    	{
	    	case "Economy":
	    		if (classeco.getText().equals(classtype))
	    			clickElement(classeco);
	    		System.out.println("Class Selection is " + classtype);
	    		break;
	    	case "Premium Economy":
	    		if (classpeco.getText().equals(classtype))
	    			clickElement(classpeco);
	    		System.out.println("Class Selection is " + classtype);
	    		break;
	    	case "Business":
	    		if (classbuss.getText().equals(classtype))
	    			clickElement(classbuss);
	    		System.out.println("Class Selection is " + classtype);
	    		break;
	    	case "First Class":
	    		if (classfirst.getText().equals(classtype))
	    			clickElement(classfirst);
	    		System.out.println("Class Selection is " + classtype);
	    		break;
	    	default:
	    		Log.error("Class type is not a valid input");
	    		break;
    	}
		
	}
	
	public void selectpassengers(int adultno,int childrenno, int infantsno) {
		
		clickElement(travelnclass);
		
		if (adultno > 0 )
		selectAdults(adultno);
		else
    		System.out.println("No of Adults added is " + adultno);
		
		if (childrenno > 0 )
			selectChildren(childrenno);
			else
	    		System.out.println("No of Children added is " + childrenno);
			
		if (infantsno > 0 )
			selectInfants(infantsno);
			else
	    		System.out.println("No of Infants added is " + infantsno);

	}
	

}
