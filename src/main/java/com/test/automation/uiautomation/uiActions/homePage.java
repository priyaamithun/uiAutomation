package com.test.automation.uiautomation.uiActions;

import org.apache.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.log4testng.Logger;

import com.test.automation.uiautomation.homePage.TC001_loginWithInvalidCredentials;

public class homePage {
	private static org.apache.log4j.Logger log = LogManager.getLogger(homePage.class.getName());

	@FindBy(xpath="html/body/div[1]/div[1]/header/div[2]/div/div/nav/div[1]/a")
	WebElement loginPage;
	
	@FindBy(xpath="html/body/div[1]/div[2]/div/div[3]/div/div/div[2]/form/div/div[1]/input")
	WebElement loginEmail;
	
	@FindBy(xpath="html/body/div[1]/div[2]/div/div[3]/div/div/div[2]/form/div/div[2]/span/input")
	WebElement loginpwd;
	
	@FindBy(xpath="html/body/div[1]/div[2]/div/div[3]/div/div/div[2]/form/div/p[2]/button")
	WebElement loginsubmit;
	
	@FindBy(xpath="html/body/div[1]/div[2]/div/div[3]/div/div[1]/ol/li")
	WebElement AuthenticationFailed;
	
	
	public void loginMethod(String email, String pwd){
		loginPage.click();
		log.info("redirecting to sign in page "+loginPage.toString());
		loginEmail.sendKeys(email);
		log.info("entering login email "+loginEmail.toString());
		loginpwd.sendKeys(pwd);
		log.info("entering login password "+loginpwd.toString());
		loginsubmit.click();
		log.info("clicking submit "+loginsubmit.toString());
		
	}
	
	public homePage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	
	public WebElement InValidCredentials(){
		log.error("invalid credentials "+AuthenticationFailed .getText());
		return AuthenticationFailed;
	}
	
}
