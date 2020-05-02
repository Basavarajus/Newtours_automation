package com.newtours.demoaut.tests;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.newtours.demoaut.base.TestBase;
import com.newtours.demoaut.pages.HomePage;
import com.newtours.demoaut.pages.LoginPage;
import com.newtours.demoaut.pages.RegistrationPage;
import com.newtours.demoaut.utility.Utility;

public class HomePageTest extends TestBase {
	
	HomePage home;
	Utility util;
	LoginPage loginpage;
	RegistrationPage registration;
	String Sheet="Registration";
	
	@BeforeTest
	public void setup() throws InterruptedException {
		initialization();
		loginpage=new LoginPage();
		home=loginpage.VerifyLoginFunctionality((util.getDataFromXL(Sheet, 1, 3)),(util.getDataFromXL(Sheet, 1, 10)));
	}
	
	@Test(priority=1)
	public void verifHomePageTitle() {
		String HomePageTitle= home.verifyHomePageTitle();
		AssertJUnit.assertEquals(HomePageTitle, "Welcome: Mercury Tours");
	}
	
	@Test(priority=2)
	public void verifyhomepageElements() {
		home.verifyHomepageElements();
	}
	
	@Test(priority=3)
	public void verifyFlightBookingprocess() {
		home.VerifyFlightBookPagelink();
	}

	
	@AfterTest
	public void teardown() {
		driver.quit();
	}



}
