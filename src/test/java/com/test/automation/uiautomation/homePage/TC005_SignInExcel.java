package com.test.automation.uiautomation.homePage;

import static org.testng.Assert.assertEquals;

import org.apache.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.SkipException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.test.automation.uiautomation.testBase.testBase;
import com.test.automation.uiautomation.uiActions.SignIn;
import com.test.automation.uiautomation.uiActions.SignInExcel;

public class TC005_SignInExcel  extends testBase{
	private static org.apache.log4j.Logger log = LogManager.getLogger(TC005_SignInExcel.class.getName());

	
	SignInExcel sn;
	
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
	sn = new SignInExcel(driver);
	action = new Actions(driver);
	
	sn.loginMethod(email, Password);
	//assertEquals(driver.findElement(By.xpath("html/body/div[1]/div[2]/div/div[3]/div/h1")).getText(),"AUTHENTICATION");
	log.info("-------Finished test----");
	getScreenShot("TestLogin "+email);
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
