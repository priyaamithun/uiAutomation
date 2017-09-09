package com.test.automation.uiautomation.testBase;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.log4testng.Logger;

import com.test.automation.uiautomation.excelReader.Excel_reader;
import com.test.automation.uiautomation.homePage.TC001_loginWithInvalidCredentials;

public class testBase {
	private static org.apache.log4j.Logger log = LogManager.getLogger(testBase.class.getName());
public WebDriver driver;
public Actions action;
String url="http://automationpractice.com/index.php";
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
	
	
	public String[][] getData(String excel_name,String sheetName){
		String path = System.getProperty("user.dir")+"/src/main/java/com/test/automation/uiautomation/data/"+excel_name;
		Excel_reader excel = new Excel_reader(path);
		String[][] data = excel.getDataFromSheet(sheetName, excel_name);
	return data;
	}
	
	public void WaitForElement(int time,WebElement element){
		Wait wait = new WebDriverWait(driver,time);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	public void UIActions(){ 

	}
public void getScreenShot(String name){
	Calendar calender = Calendar.getInstance();
	SimpleDateFormat formatter = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
	
	File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	try{
		String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath()+"/src/main/java/com/test/automation/uiautomation/screenShot/";
		File destFile = new File((String) reportDirectory + name +"_"+formatter. format(calender.getTime())+".png");
		FileUtils.copyFile(srcFile, destFile);
		Reporter.log("<a href= '" +destFile.getAbsolutePath()+"'> <img src='" + destFile.getAbsolutePath() +"' height = '100' width='100'/> </a>");
	}catch(Exception e){
		e.printStackTrace();
		
	}
	
	
}



}
