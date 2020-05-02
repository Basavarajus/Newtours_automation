package com.newtours.demoaut.pages;

import javax.xml.xpath.XPath;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.newtours.demoaut.base.TestBase;

public class FlightBookPage extends TestBase {
	@FindBy(xpath="//input[@value='oneway']")
	WebElement Onewaytrip_button;
	
	@FindBy(xpath="//img[@src='/images/masts/mast_lightfinder.gif']")
	WebElement flightFindertextlabel;
	
	@FindBy(xpath="//input[@value='roundtrip']")
	WebElement roundtrip_button;
	
	//service class type radio button
	@FindBy(xpath="//input[@value='Coach']")
	WebElement Economy_Class_radio;
	
	@FindBy(xpath="//input[@value='Business']")  
	WebElement Business_Class_radio;
	
	@FindBy(xpath="//input[@value='First']")  
	WebElement First_Class_radio;
	
	@FindBy(xpath="//select[@name='fromMonth']")
    WebElement From_date;
	
	@FindBy(xpath="//select[@name='toMonth']")
    WebElement to_date;
	
	@FindBy(xpath="//select[@name='fromDay']")
    WebElement From_day;
	
	@FindBy(xpath="//select[@name='toDay']")
    WebElement  to_day;
	
	@FindBy(xpath="//select[@name='fromPort']")
	WebElement From_place;   
	
	@FindBy(xpath="//select[@name='toPort']")
	WebElement To_place;   
	
	@FindBy(xpath="//select[@name='airline']")
	WebElement airline_type;   
	
	@FindBy(xpath="//select[@name='passCount']")   
	WebElement no_of_passangers;
	
	@FindBy(xpath="//input[@name='findFlights']")
	WebElement continue_link;
	
	@FindBy(xpath="//input[@name='reserveFlights']")
	WebElement confirm_booking;
	
	@FindBy(xpath="//select[@name='pass.0.meal']")
	WebElement Meal_type;
	
	@FindBy(xpath="//input[@name='passFirst0']")
	WebElement first_name;
	
	@FindBy(xpath="//input[@name='passLast0']")
	WebElement lastname;
	
	@FindBy(xpath="//input[@name='creditnumber']")
	WebElement card_number;
	
	@FindBy(xpath="//input[@src='/images/forms/purchase.gif']")
	WebElement secure_purchase;
	
	
	public FlightBookPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void verifyFlightbookProcess(String source,String Destination ,String airline,String Fname,String Lname,String Meal,String Number) {
//		flightFindertextlabel.isDisplayed();
		System.out.println(source+"------ "+Destination+"-----"+airline);
		Select FromPlace= new Select(From_place);
		FromPlace.selectByVisibleText(source);
		Select Toplace= new Select(To_place);
		Toplace.selectByVisibleText(Destination);
		Select airlines= new Select(airline_type);
		airlines.selectByVisibleText(airline);
		continue_link.click();
		confirm_booking.click();
		first_name.sendKeys(Fname);
		lastname.sendKeys(Lname);
		Select Meal_types= new Select(Meal_type);
		Meal_types.selectByVisibleText(Meal);
		card_number.sendKeys(Number);
		
		secure_purchase.click();
		
		
	}
	
	

}
