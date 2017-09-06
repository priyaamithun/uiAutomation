package com.test.automation.uiautomation.uiActions;

import org.apache.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage {
	private static org.apache.log4j.Logger log = LogManager.getLogger(RegistrationPage.class.getName());


	@FindBy(By.xpath("html/body/div[6]/div[1]/div[1]/header/div/div[2]/nav/ul/li[6]/div/div[1]/a"))
    WebElement AccountSignUp;


	
}
