package com.test.automation.uiautomation.testBase;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.LogManager;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.log4testng.Logger;

import com.test.automation.uiautomation.excelReader.Excel_reader;
import com.test.automation.uiautomation.homePage.TC001_loginWithInvalidCredentials;

public class testBase {
	private static org.apache.log4j.Logger log = LogManager.getLogger(testBase.class.getName());
public WebDriver driver;
public Actions action;
String url="https://www.wayfair.com/";
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
		else if(browser.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"/drivers/geckodriver.exe");
			driver = new FirefoxDriver();	

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
	public String[][] getData(String excel_name,String sheetName){
		String path = System.getProperty("user.dir")+excel_name;
		Excel_reader excel = new Excel_reader(path);
		String[][] data = excel.getDataFromSheet(sheetName, excel_name);
	return data;
	}
	
	
}
