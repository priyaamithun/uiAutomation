package com.test.automation.uiautomation.homePage;

import static org.testng.Assert.assertEquals;

import org.apache.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import com.test.automation.uiautomation.testBase.testBase;
import com.test.automation.uiautomation.uiActions.homePage;



public class TC001_loginWithInvalidCredentials extends testBase {
	private static org.apache.log4j.Logger log = LogManager.getLogger(TC001_loginWithInvalidCredentials.class.getName());

	homePage homepage;
	
	
	@BeforeTest
	public void BeforeLogin(){
	init();
	
		
	}
	@Test
	public void loginWithInvalidCredentials(){
		log.info("-------Starting test----");
	homepage = new homePage(driver);
		homepage.loginMethod("veerpriyaa@yahoo.com", "12345");
	assertEquals(driver.findElement(By.xpath("html/body/div[1]/div[2]/div/div[3]/div/div[1]/ol/li")).getText(),"Authentication failed.");
	log.info("-------Finished test----");
	}
	@AfterTest
	public void endTest(){
		driver.close();
	}
	
	
	
}
