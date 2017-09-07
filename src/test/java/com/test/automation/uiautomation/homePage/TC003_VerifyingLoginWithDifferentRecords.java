package com.test.automation.uiautomation.homePage;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.test.automation.uiautomation.testBase.testBase;
import com.test.automation.uiautomation.uiActions.RegistrationPage;

public class TC003_VerifyingLoginWithDifferentRecords  extends testBase{

	RegistrationPage reg;
	String email = "automation@gmail.com";
	String password = "password1";
	
	
	@BeforeTest
	public void BeforeLogin(){
		init();
	}
	
	@Test
	public void TestLogin(){
	reg = new RegistrationPage(driver);
	reg.signUp(email, password);
	}
	
	@AfterTest
	public void AfterLogin(){
		
	}
	
}
