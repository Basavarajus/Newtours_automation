package com.newtours.demoaut.pages;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.newtours.demoaut.base.TestBase;
public class RegistrationPage extends TestBase{

	@FindBy(xpath="//a[contains(text(),'REGISTER')] ")
	WebElement register_link;
	
	@FindBy(xpath="//a[contains(text(),'sign-in')]")
	WebElement sign_in_link;
	
	@FindBy(xpath="//img[@src='/images/masts/mast_register.gif']")
	WebElement Register_page_text_label;
	
	@FindBy(xpath="//input[@name='firstName']")
	WebElement firstname_field;
	
	@FindBy(xpath="//input[@name='lastName']")
	WebElement lastname_field;	
	
	@FindBy(xpath="//input[@name='phone']")
	WebElement  phoneno_field;
	
	@FindBy(xpath="//*[@id='userName']")
	WebElement  useremail_field;
	
	@FindBy(xpath="//input[@name='address1']")
	WebElement address_field;

	@FindBy(xpath="//input[@name='city']")
	WebElement city_field;
	
	@FindBy(xpath="//input[@name='state']")
	WebElement state_field;
	
	@FindBy(xpath="//input[@name='postalCode']")
	WebElement postalcode_field;
	
	@FindBy(xpath="//select[@name='country']")
	WebElement List_of_country;
	
	@FindBy(xpath="//*[@id='email']")
	WebElement username_field;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement password_field;
	
	@FindBy(xpath="//input[@name='confirmPassword']")
	WebElement Confirm_password_field;
	
	
	
	@FindBy(xpath="//select[@name='airline']")
	WebElement country_type;
	
	@FindBy(xpath="//input[@name='register']")
	WebElement register_form_submit_button;
	
	public RegistrationPage() {
		PageFactory.initElements(driver, this);
	}  
		
	public void verifyRegistrationPage_text() {
		register_link.click();
		Register_page_text_label.isDisplayed();	
	}
	
	public LoginPage Registeruser(String FirstName,String Lastname,String Email,String Password,String Country) throws InterruptedException {
		register_link.click();
		Select country = new Select(country_type);
		firstname_field.sendKeys(FirstName);
		lastname_field.sendKeys(Lastname);
		useremail_field.sendKeys(Email);
		country.selectByVisibleText(Country);
		username_field.sendKeys(Email);
		password_field.sendKeys(Password);
		Confirm_password_field.sendKeys(Password);
		register_form_submit_button.click();
		sign_in_link.click();
		return new LoginPage();		
	}
	
}
