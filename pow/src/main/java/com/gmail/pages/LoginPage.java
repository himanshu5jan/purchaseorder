package com.gmail.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	
	/*
	 * driver.findElement(By.id("Email")).sendKeys("hp5jan@gmail.com");
		driver.findElement(By.id("next")).click();
		//driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		//driver.findElement(By.xpath(".//*[@id='Passwd']")).sendKeys("!nnocuous");
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("Passwd")));
		driver.findElement(By.id("Passwd")).sendKeys("!nnocuous");
		driver.findElement(By.id("signIn")).click();
		
	 */
	WebDriver driver;
	By unameInput=By.id("Email");
	By nextBtn=By.id("next");
	By passInput=By.id("Passwd");
	By LogBtn=By.id("signIn");
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void enterUserName(String uname)
	{
		driver.findElement(unameInput).sendKeys(uname);
		
	}
	
	public void goNext() {
		driver.findElement(nextBtn).click();
	}
	
	public void enterPassWord(String passwd)
	{
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(passInput));
		driver.findElement(passInput).sendKeys(passwd);
		
	}

	public void clickLogin()
	{
		driver.findElement(LogBtn).click();
	}
	
	
	public void loginToGmail(String uname, String passwd) {
		driver.findElement(unameInput).sendKeys(uname);
		driver.findElement(nextBtn).click();
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(passInput));
		driver.findElement(passInput).sendKeys(passwd);
		driver.findElement(LogBtn).click();
	}

}
