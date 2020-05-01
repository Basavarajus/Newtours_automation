package com.newtours.demoaut.tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.newtours.demoaut.base.TestBase;
import com.newtours.demoaut.pages.HomePage;
import com.newtours.demoaut.pages.LoginPage;
import com.newtours.demoaut.pages.RegistrationPage;
import com.newtours.demoaut.utility.Utility;


public class LoginPageTest extends TestBase {

	Utility util;
	LoginPage loginpage;
	RegistrationPage registration;
	String Sheet="Registration";
	
	@BeforeTest
	public void setup() throws InterruptedException {
		initialization();
		util= new Utility();
		registration = new RegistrationPage();
		loginpage=registration.Registeruser(util.getDataFromXL(Sheet, 1, 0),(util.getDataFromXL(Sheet, 1, 1)),(util.getDataFromXL(Sheet, 1, 3)),(util.getDataFromXL(Sheet, 1, 10)),(util.getDataFromXL(Sheet, 1, 8)));	
	}

	@Test(priority = 1)
	public void verifyLoginpagetitle() {
		final String LoginPageTitle = loginpage.VerifyLoginPageTitle();
		assertEquals(LoginPageTitle, "Sign-on: Mercury Tours");
	}

	
	
	@Test(priority = 2)
	public void verifyloginpageLabel() {
		loginpage.VerifyloginPagelabel();
	}

	@Test(priority = 3)
	public void VerifyLoginFunctionality() {
		loginpage.VerifyLoginFunctionality((util.getDataFromXL(Sheet, 1, 3)),(util.getDataFromXL(Sheet, 1, 10)));
	}

	@AfterTest
	public void teardown() {
		driver.quit();
	}
}
