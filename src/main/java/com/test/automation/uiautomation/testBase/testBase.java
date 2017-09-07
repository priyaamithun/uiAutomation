package com.test.automation.uiautomation.testBase;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.LogManager;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.log4testng.Logger;

import com.test.automation.uiautomation.homePage.TC001_loginWithInvalidCredentials;

public class testBase {
	private static org.apache.log4j.Logger log = LogManager.getLogger(testBase.class.getName());
public WebDriver driver;
public Actions action;
String url="https://www.wayfair.com/?refid=YGX30301005589.Ebay~e&device=c";
String browser = "chrome";



	public void init(){
		selectBrowser(browser);
	getUrl();
UIActions();
	String log4jConfigPath = "log4j2.properties";
	PropertyConfigurator.configure(log4jConfigPath);
	}
	
	public void selectBrowser(String browser){
		if(browser.equalsIgnoreCase("chrome")){
			log.info("creating object of "+browser);
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/drivers/chromedriver.exe");
		driver = new ChromeDriver();	
		}
	}
	public void getUrl(){
		log.info("navigating to : "+url);
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}
	
	public void UIActions(){
	  
	  action = new Actions(driver);
	}
	
}
