package com.gmail.test;


import java.io.PrintWriter;
import java.io.StringWriter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.gmail.pages.LoginPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;



public class LoginTest {

	ExtentReports report;
	ExtentTest logger;

	WebDriver driver;
	@BeforeClass
	public void setup() {
		String reportFile="./Reports/Current/results.html";
		report=new ExtentReports(reportFile);
		System.setProperty("webdriver.chrome.driver", "c:\\ChromeDriver\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://www.gmail.com");
	}
	
	@Test
	public void verifyValidLogin()
	{
		logger=report.startTest("TC001_VerifyValidLogin");
		logger.log(LogStatus.INFO, "Test Case Started");
		logger.log(LogStatus.INFO, "Input Condition: Valid Login Credentials provided");
		logger.log(LogStatus.INFO, "Expected output: 200 OK");
		LoginPage login=new LoginPage(driver);
		login.enterUserName("hp5jan@gmail.com");
		login.goNext();
		login.enterPassWord("!nnocuous");
		login.clickLogin();
		
		//login.loginToGmail("hp5jan@gmail.com", "!nnocuous");
		//String actual=driver.getTitle();
		//Assert.assertTrue(login.verifyTitle("Wordpress","Word"));
	}
	
	@Test(dependsOnMethods={"verifyValidLogin"})
	public void logoutTest() {
		logger=report.startTest("TC002_VerifyLogout");
		logger.log(LogStatus.INFO, "Test Case Started");
		logger.log(LogStatus.INFO, "Input Condition: Logout Button Clicked");
		logger.log(LogStatus.INFO, "Expected output: Logout with message");
		driver.findElement(By.cssSelector("span.gb_3a gbii")).click();
	}
	
		
	@AfterMethod
	public void afterEachTest(ITestResult result) 
	{
		String tName=result.getName();
		//String tCaseId=result.toString();
		if(result.getStatus() == ITestResult.FAILURE) {
			String thwomsg=result.getThrowable().getMessage();
		//	System.out.println("Test Case "+tName+" Failed !!");
			logger.log(LogStatus.FAIL, tName+" Failed");
			logger.log(LogStatus.FAIL, thwomsg);
		
		} else {
			//System.out.println("Test Case "+tName+" Passed !!");
			logger.log(LogStatus.PASS,tName+" Passed");
			
		}
		
	report.endTest(logger);
	report.flush();
	}


	
	@AfterClass
	public void tearDown() {
		//driver.close();
	}

	
	
}
