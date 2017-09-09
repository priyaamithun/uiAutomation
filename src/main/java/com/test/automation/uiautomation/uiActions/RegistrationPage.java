package com.test.automation.uiautomation.uiActions;

import org.apache.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.automation.uiautomation.testBase.testBase;

public class RegistrationPage extends testBase {
	private static org.apache.log4j.Logger log = LogManager.getLogger(RegistrationPage.class.getName());


	@FindBy(xpath="html/body/div[6]/div[1]/div[1]/header/div/div[2]/nav/ul/li[6]/div/div[1]/a")
    WebElement AccountSignUp;
	              
	
	
	//@FindBy(xpath="html/body/div[6]/div[1]/div[1]/header/div/div[2]/nav/ul/li[6]/div/div[1]/div/ul/li[2]/a")
	//WebElement AccountClick;
	
	@FindBy(xpath="//input[@id='login-email-input']")
	WebElement Email;
	
	@FindBy(xpath="html/body/div[6]/div[2]/section/div/form/button")
	WebElement continueButton;
	
	
	
	@FindBy(id="login-password-input")
	WebElement Password;
	
	@FindBy(xpath="html/body/div[6]/div[2]/section/div/form/button")
	WebElement CreateLogin;
	
	@FindBy(xpath="html/body/div[6]/div[3]/main/header/section/header/h1")
	WebElement PageTitle;
	
	
	@FindBy(xpath="html/body/div[6]/div[1]/div[1]/header/div/div[2]/nav/ul/li[6]/div/div[1]/div/ul/li[4]/div/a")
	WebElement Logout;
	

	public void signUp(String SignUpEmail,String SignUppassword){
	//log.info("using action object for mouseover");
	//	action.moveToElement(AccountSignUp).build().perform();
	AccountSignUp.click();
		log.info("navigating to Account page");
	//	AccountClick.click();
		log.info("entering email credentials");
		Email.sendKeys(SignUpEmail);
		
		
	    continueButton.click();
		Password.sendKeys(SignUppassword);
		log.info("entering password  credentials");
		CreateLogin.click();
		log.info("clicking submit button");
		
		AccountSignUp.click();

		AccountSignUp.sendKeys(Keys.ARROW_DOWN);
		AccountSignUp.sendKeys(Keys.ARROW_DOWN);
		AccountSignUp.sendKeys(Keys.ARROW_DOWN);
		
		Logout.sendKeys(Keys.ENTER);
		
	}
	
	
	
	
	public RegistrationPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}

public WebElement AccountCreated(){
log.info("confirming with page title");
	return PageTitle;
}

public boolean LogoutDisaplayed(){
	try{
		//
		WaitForElement(300, Logout);
	Logout.isDisplayed();
	log.info("logout is displayed "+Logout.toString());

return true;
	}
	catch(Exception e){
		return false;
	}

}

public void LogoutClicked(){
	//WaitForElement(300, Logout);
	Logout.click();
	log.info("logout id clicked "+Logout.toString());
}



}