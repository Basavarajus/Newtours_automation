package com.newtours.demoaut.tests;
import org.testng.annotations.Test;

import com.newtours.demoaut.base.TestBase;
import com.newtours.demoaut.pages.HomePage;

public class HomePageTest extends TestBase {
	
	HomePage home= new HomePage();
	
	@Test
	public void TestDropdwon() {
		home.selectSamples();
	}

}
