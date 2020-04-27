package com.newtours.demoaut.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.newtours.demoaut.base.TestBase;

public class LoginPage extends TestBase {
	
	@FindBy(xpath="//input[@name='login']")
	WebElement sign_in_button;
	
	@FindBy(xpath="//input[@name='userName']")
	WebElement username_field;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement Password_field;
	
	@FindBy(xpath="//input[@name='login']")
	WebElement login_button;
	
	@FindBy(xpath="//img[@src='/images/masts/mast_signon.gif']")
	WebElement Login_label_image;
	
	public void Loginpage() {
		PageFactory.initElements(driver,this);
	}
	
	public String VerifyLoginPageTitle() {
		return driver.getTitle();
	}
	
	public void VerifyloginPagelabel() {
		Login_label_image.isDisplayed();
	}
	public HomePage VerifyLoginFunctionality(String username,String Password) {
		username_field.sendKeys(username);
		Password_field.sendKeys(Password);
//		JavascriptExecutor js = (JavascriptExecutor)driver;
//		js.executeScript("arguments[0].click();", sign_in_button);
		sign_in_button.click();
		return new HomePage();
		
	}
}
