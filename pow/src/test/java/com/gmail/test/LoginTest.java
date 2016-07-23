package com.gmail.test;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.gmail.pages.LoginPage;



public class LoginTest {


	WebDriver driver;
	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "c:\\ChromeDriver\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://www.gmail.com");
	}
	
	@Test
	public void verifyValidLogin()
	{
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
		driver.findElement(By.cssSelector("span.gb_3a gbii")).click();
	}
	
		
	@AfterMethod
	public void afterTest(ITestResult result) {
		if(result.isSuccess())
			System.out.println("TEST CASE PASS"+result.getName());
		else
			System.out.println("TEST CASE FAIL"+result.getName());
	}
	
	@AfterClass
	public void tearDown() {
		//driver.close();
	}

	
	
}
