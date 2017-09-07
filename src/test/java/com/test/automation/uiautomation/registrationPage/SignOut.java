package com.test.automation.uiautomation.registrationPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.test.automation.uiautomation.testBase.testBase;
import com.test.automation.uiautomation.uiActions.SignOut1;

public class SignOut  extends testBase{

	SignOut1 sign;
WebDriver driver;
Actions action;
	
	@BeforeTest
	public void beforeTest(){
		init();
	}
	
	@Test
	public void signOutPage(){

		sign = new SignOut1(driver);
		

		sign.signout();
		
	}
	
	
	
}
