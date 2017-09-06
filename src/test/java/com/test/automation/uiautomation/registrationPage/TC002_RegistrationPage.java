package com.test.automation.uiautomation.registrationPage;

import static org.testng.Assert.assertEquals;

import org.apache.log4j.LogManager;
import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.test.automation.uiautomation.homePage.TC001_loginWithInvalidCredentials;
import com.test.automation.uiautomation.testBase.testBase;
import com.test.automation.uiautomation.uiActions.homePage;

public class TC002_RegistrationPage extends testBase {

	private static org.apache.log4j.Logger log = LogManager.getLogger(TC002_RegistrationPage.class.getName());

	
	@BeforeTest
	public void BeforesignUp(){
	init();
	
		
	}
	@Test
	public void signUpCredentials(){

		
		
		
		
	}
	@AfterTest
	public void endTest(){
		driver.close();
	}
	
	
}
