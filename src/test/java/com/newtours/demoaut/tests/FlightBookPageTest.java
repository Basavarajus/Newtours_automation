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
import com.newtours.demoaut.utility.Utility;

public class FlightBookPageTest extends TestBase {

	HomePage home;
	Utility util;
	LoginPage loginpage;
	FlightBookPage flightbook;
	String Sheet="Registration";

	@BeforeMethod
	public void setup() {
		initialization();
		home=loginpage.VerifyLoginFunctionality((util.getDataFromXL(Sheet, 1, 3)),(util.getDataFromXL(Sheet, 1, 10)));
//		home = new HomePage();
		flightbook = home.VerifyFlightBookPagelink();
	}
	
	@Test(priority=1)
	public void verifyflightBooking() {
		flightbook.verifyFlightbookProcess((util.getDataFromXL(Sheet, 7, 1)),(util.getDataFromXL(Sheet, 7, 2)),(util.getDataFromXL(Sheet, 7, 4)));
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
