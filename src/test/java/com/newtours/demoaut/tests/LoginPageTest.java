package com.newtours.demoaut.tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.newtours.demoaut.base.TestBase;
import com.newtours.demoaut.pages.HomePage;
import com.newtours.demoaut.pages.LoginPage;

public class LoginPageTest extends TestBase {

	LoginPage loginpage;
	HomePage homepage;
	
	@BeforeMethod
	public void setup() {
		initialization();
		
	}
	
//	@Test(priority=1)
//	public void  verifyLoginpagetitle() {
//		final String LoginPageTitle=loginpage.VerifyLoginPageTitle();
//		assertEquals(LoginPageTitle,"Sign-on: Mercury Tours");
//	}
//	@Test(priority=2)
//	public void verifyloginpageLabel() {
//		loginpage.VerifyloginPagelabel();
//	}
	@Test(priority=1)
	public void VerifyLoginFunctionality() {
		System.out.println(prop.getProperty("username"));
				System.out.println(prop.getProperty("pass"));	
				loginpage=new LoginPage();
//				loginpage.VerifyLoginFunctionality();	
		loginpage.VerifyLoginFunctionality("automation@yopmail.com","Simpli@123");
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}
