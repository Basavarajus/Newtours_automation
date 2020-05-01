package com.newtours.demoaut.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.newtours.demoaut.base.TestBase;
import com.newtours.demoaut.pages.HomePage;
import com.newtours.demoaut.pages.LoginPage;
import com.newtours.demoaut.pages.RegistrationPage;
import com.newtours.demoaut.utility.Utility;

public class RegistrationPageTest extends TestBase {

	RegistrationPage register; 
	Utility util;
	LoginPage loginpage;
	
	String Sheet="Registration";
	@BeforeTest
	public void setup() {
		initialization();
		loginpage= new LoginPage();
		util=new Utility();
	}
	
//	@DataProvider
//	public Object[][] GetTestData() {
//		Object data[][]=Utility.getTestData(SheetName);
//		return data;
		
//	}
	
	@Test(priority=2)
	public void registeruser() throws InterruptedException {
		register.Registeruser(util.getDataFromXL(Sheet, 1, 0),(util.getDataFromXL(Sheet, 1, 1)),(util.getDataFromXL(Sheet, 1, 3)),(util.getDataFromXL(Sheet, 1, 10)),(util.getDataFromXL(Sheet, 1, 8)));	
	}
	@Test(priority=1)
	public void VerifyRegisterpageText() {
		register.verifyRegistrationPage_text();
	}
	
	@AfterTest
	public void Teardown() {
		driver.quit();
	}
	
}
