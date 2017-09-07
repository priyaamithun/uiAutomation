package com.test.automation.uiautomation.uiActions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.automation.uiautomation.testBase.testBase;

public class SignOut1 extends testBase {
	Actions action;

	@FindBy(xpath="html/body/div[6]/div[1]/div[1]/header/div/div[2]/nav/ul/li[6]/div/div[1]/a/span")
	WebElement move;
	
	
	
	public void signout(){
action = new Actions(driver);
		action.moveToElement(move).build().perform();
		
	}
	
	public SignOut1(WebDriver driver){

		PageFactory.initElements(driver, this);
	}








		
	}
	


