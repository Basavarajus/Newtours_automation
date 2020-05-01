package com.newtours.demoaut.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.newtours.demoaut.base.TestBase;


public class HomePage extends TestBase {
	@FindBy(xpath="//input[@value='oneway']")
	WebElement Onewaytrip_button;
	
	@FindBy(xpath="//input[@value='roundtrip']")
	WebElement roundtrip_button;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public void selectSamples()
	{
		driver.get("http://newtours.demoaut.com/mercuryregister.php");
		WebElement element=driver.findElement(By.name("country"));
		org.openqa.selenium.support.ui.Select se=new org.openqa.selenium.support.ui.Select(element);
		se.selectByValue("AMERICAN SAMOA ");
	}

}
