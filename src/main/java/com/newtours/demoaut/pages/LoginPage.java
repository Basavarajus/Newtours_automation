package com.newtours.demoaut.pages;

import java.util.concurrent.TimeUnit;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
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
	
	public  LoginPage() {
		  PageFactory.initElements(driver, this);
	}
	
	public String VerifyLoginPageTitle() {
		return driver.getTitle();
	}
	
	public void VerifyloginPagelabel() {
		Login_label_image.isDisplayed();
	}
	
	public void selectSamples()
	{
//		driver.get("http://newtours.demoaut.com/mercuryregister.php");
		WebElement element=driver.findElement(By.name("country"));
		org.openqa.selenium.support.ui.Select se=new org.openqa.selenium.support.ui.Select(element);
		se.selectByValue("AMERICAN SAMOA");
	}
	public HomePage VerifyLoginFunctionality(String username,String Password) {
		username_field.sendKeys(username);
		Password_field.sendKeys(Password);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", sign_in_button);
		return new HomePage();
	}
}
