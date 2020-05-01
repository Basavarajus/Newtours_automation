package com.newtours.demoaut.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {
	 public static WebDriver driver;
	    public static Properties prop;
	    
	    //global text data excel files
//	    public static final String TestDataExcelFileName="C:\\Users\\basavaraju.s\\Desktop\\New SauceDemo\\newtours.demoaut_automation\\resource\\TestData.xlsx";
	    
	    public TestBase() {
	        try {
	            TestBase.prop = new Properties();
	            final FileInputStream ip = new FileInputStream(String.valueOf(System.getProperty("user.dir")) + "/resource/config.properties");
	            TestBase.prop.load(ip);
	        }
	        catch (FileNotFoundException e) {
	            e.printStackTrace();
	        }
	        catch (IOException e2) {
	            e2.printStackTrace();
	        }
	    }
	    
	    public static void initialization() {
	        final String BrowserName = TestBase.prop.getProperty("Browser");
	        if (BrowserName.equals("chrome")) {
	            System.setProperty("webdriver.chrome.driver", String.valueOf(System.getProperty("user.dir")) + "/resource/chromedriver.exe");
	            TestBase.driver = (WebDriver)new ChromeDriver();
	        }
	        else if (BrowserName.equals("FF")) {
	            System.setProperty("webdriver.gecko.driver", String.valueOf(System.getProperty("user.dir")) + "/resource/geckodriver.exe");
	            TestBase.driver = (WebDriver)new FirefoxDriver();
	        }
	      driver.manage().window().maximize();
	      driver.manage().deleteAllCookies();
	      driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	      driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	      driver.get(TestBase.prop.getProperty("url"));
	    }
	
	

}

