package com.actitime.GenericLibrary;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.actitime.ObjectRepository.Loginpage;

public class BaseClass {
	FileLibrary fl=new FileLibrary();
	public WebDriver driver;
	@BeforeSuite
	public void databaseconnection() {
		Reporter.log("database connected",true);
	}
	
	@BeforeClass
	public void launchBrowser() throws IOException {
	     driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String actitimeurl = fl.readdataFromPropertyFile("url");
		driver.get("actitimeurl");
		Reporter.log("browser launched",true);
	}
	
	@BeforeMethod
	public void login() throws IOException { 
	Loginpage lp=new Loginpage(driver);
	String Un = fl.readdataFromPropertyFile("username");
	String Pw = fl.readdataFromPropertyFile("password");
	lp.getUntbx().sendKeys(Un);
	lp.getPwtbx().sendKeys(Pw);
	lp.getLgbtn().click();
		Reporter.log("Logged in to actitime",true);
	}
	
	@AfterMethod() 
	public void logout() {
	driver.findElement(By.id("logoutLink")).click();
		Reporter.log("Logged out",true);
	}
	
	@AfterClass() 
	public void ClosedBrowser() {
	driver.close();
		Reporter.log("Browser Closed",true);
	}

	@AfterSuite() 
	public void databasedisconnection() {
		Reporter.log("Database Disconnected",true);
	}
	
}
