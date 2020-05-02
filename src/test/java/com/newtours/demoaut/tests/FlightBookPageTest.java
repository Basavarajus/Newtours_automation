package com.newtours.demoaut.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.newtours.demoaut.base.TestBase;
import com.newtours.demoaut.pages.FlightBookPage;
import com.newtours.demoaut.pages.HomePage;
import com.newtours.demoaut.pages.LoginPage;
import com.newtours.demoaut.pages.RegistrationPage;
import com.newtours.demoaut.utility.Utility;

public class FlightBookPageTest extends TestBase {

	HomePage home;
	Utility util;
	LoginPage loginpage;
	RegistrationPage registration;
	FlightBookPage flightbook;
	String Sheet="Registration";

	
	public FlightBookPageTest() {
		super();
	}
	@BeforeMethod
	public void setup() throws InterruptedException {
		initialization();
		registration= new RegistrationPage();
		loginpage= new LoginPage();
//		loginpage=registration.Registeruser(util.getDataFromXL(Sheet, 1, 0),(util.getDataFromXL(Sheet, 1, 1)),(util.getDataFromXL(Sheet, 1, 3)),(util.getDataFromXL(Sheet, 1, 10)),(util.getDataFromXL(Sheet, 1, 8)));
		home=loginpage.VerifyLoginFunctionality((util.getDataFromXL(Sheet, 1, 3)),(util.getDataFromXL(Sheet, 1, 10)));
//		home = new HomePage();
		flightbook = home.VerifyFlightBookPagelink();
	}
	
	@SuppressWarnings("static-access")
	@Test(priority=1)
	public void verifyflightBooking() {
		flightbook.verifyFlightbookProcess((util.getDataFromXL(Sheet, 5, 0)),(util.getDataFromXL(Sheet, 5, 1)),(util.getDataFromXL(Sheet, 5, 3)),(util.getDataFromXL(Sheet, 1, 0)),(util.getDataFromXL(Sheet, 1, 1)),(util.getDataFromXL(Sheet, 5, 4)),(util.getDataFromXL(Sheet, 5, 5)));
		System.out.println((util.getDataFromXL(Sheet, 5, 0))+"-----"+(util.getDataFromXL(Sheet, 5, 2))+"----"+(util.getDataFromXL(Sheet, 5, 3)));
	}
	
	
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
