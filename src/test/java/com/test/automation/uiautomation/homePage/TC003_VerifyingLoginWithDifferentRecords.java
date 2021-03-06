package com.test.automation.uiautomation.homePage;

import static org.testng.Assert.assertEquals;

import org.testng.SkipException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.test.automation.uiautomation.testBase.testBase;
import com.test.automation.uiautomation.uiActions.RegistrationPage;

public class TC003_VerifyingLoginWithDifferentRecords  extends testBase{

	RegistrationPage reg;
	
	
	@DataProvider(name="loginData")
	public String[][] getTestData(){
		String[][] testRecords = getData("TestData.xlsx", "Sheet1");
		return testRecords;
	}
	
	
	
	@BeforeTest
	public void BeforeLogin(){
		init();
	}
	
	@Test(dataProvider="loginData")
	public void TestLogin(String email,String Password,String runmode){
		if(runmode.equalsIgnoreCase("n")){
			throw new SkipException("user marked n");
		}
	reg = new RegistrationPage(driver);
	reg.signUp(email, Password);
	//reg.LogoutClicked();
	//boolean status = reg.LogoutDisaplayed();
//assertEquals(status, true);
	//if(status){
		//reg.LogoutClicked();
	}
	
	
	@AfterTest
	public void AfterLogin(){
		
	}
	
}
