package com.test.automation.uiautomation.registrationPage;

import static org.testng.Assert.assertEquals;

import org.apache.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.test.automation.uiautomation.homePage.TC001_loginWithInvalidCredentials;
import com.test.automation.uiautomation.testBase.testBase;
import com.test.automation.uiautomation.uiActions.RegistrationPage;
import com.test.automation.uiautomation.uiActions.homePage;

public class TC002_RegistrationPage extends testBase {

	private static org.apache.log4j.Logger log = LogManager.getLogger(TC002_RegistrationPage.class.getName());
 RegistrationPage reg;
	
	
	@BeforeTest
	public void BeforesignUp(){
	init();
	
		
	}
	@Test
	public void signUpCredentials(){
		log.info("creating object for registratin class");
  reg = new RegistrationPage(driver);
  log.info("entering signup credentials");
  reg.signUp("veerpriyaa@yahoo.com", "winter100#");
		
  log.info("creating object for action class");
		//action = new Actions(driver);
		log.info("checking the values assert");
		assertEquals(driver.findElement(By.xpath("html/body/div[6]/div[3]/main/header/section/header/h1")).getText(),"My Account");
		
		
		
	}
	@AfterTest
	public void endTest(){
		
		//driver.close();
	}
	
	
}
