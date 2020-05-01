package com.newtours.demoaut.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.newtours.demoaut.base.TestBase;


public class HomePage extends TestBase {
	
	@FindBy(xpath="//img[@src='/images/masts/mast_lightfinder.gif']")
	WebElement flightFindertextlabel;
	
	@FindBy(xpath="//*[contains(text(),'SIGN-OFF')]")
	WebElement Sign_off_link;
	
	@FindBy(xpath="//a[contains(text(),'PROFILE')]")
	WebElement profile_link;
	
	
	@FindBy(xpath="//a[contains(text(),'ITINERARY')]")
	WebElement ITINERARY_link;
	
	@FindBy(xpath="//a[contains(text(),'Flights')]")
	WebElement flighbookpage_link;
	
	public HomePage() {
		PageFactory.initElements(driver,this);
	}
	
	
	public String verifyHomePageTitle() {
		return driver.getTitle();
	}
	
	public String getHomePageTitle() {
		return driver.getTitle();
	}
	public void verifyHomepageElements() {
		Sign_off_link.isDisplayed();
		ITINERARY_link.isDisplayed();
		profile_link.isDisplayed();
	}
	
	public FlightBookPage VerifyFlightBookPagelink() {
		flighbookpage_link.click();
//		flightFindertextlabel.isDisplayed();
		return new  FlightBookPage();
		
	}
	
}
