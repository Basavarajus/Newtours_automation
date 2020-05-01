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

public class LoginPageTest extends TestBase {

	LoginPage loginpage;
	HomePage homepage;
	@BeforeTest
	public void setup() {
		initialization();
		loginpage = new LoginPage();
	}

	@Test(priority = 1)
	public void verifyLoginpagetitle() {
		final String LoginPageTitle = loginpage.VerifyLoginPageTitle();
		assertEquals(LoginPageTitle, "Register: Mercury Tours");
	}

	
	
	@Test(priority = 2)
	public void verifyloginpageLabel() {
		loginpage.VerifyloginPagelabel();
	}

	@Test(priority = 2)
	public void VerifyLoginFunctionality() {
		loginpage.VerifyLoginFunctionality(prop.getProperty("username"), prop.getProperty("pass"));
	}

	@AfterTest
	public void teardown() {
		driver.quit();
	}
}
