package com.ppr.lib.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginPage {
	
	WebDriver driver;
	public LoginPage(WebDriver driver ) {
		this.driver=driver;
		
		}
	
public WebElement GetUserNameTextbox()  {

	return (driver.findElement(By.id("email")));
	}
public WebElement GetPasswordTextbox()  {

	return (driver.findElement(By.id("pass")));
	}
public WebElement GetLoginbutton()  {

	return (driver.findElement(By.xpath("//input[@value='Log In']")));
	}
public WebElement GetincorrectPasswordMsg()  {

	return (driver.findElement(By.xpath("//div[contains(text(),'The password')]")));
	}
public void WaitForLoginPageToLoad() {
	
	WebDriverWait wait = new WebDriverWait(driver,30);

	wait.until(ExpectedConditions.visibilityOf(GetUserNameTextbox()));
	wait.until(ExpectedConditions.visibilityOf(GetPasswordTextbox()));
	wait.until(ExpectedConditions.visibilityOf(GetLoginbutton()));
	//wait.until(ExpectedConditions.visibilityOf(GetincorrectPasswordMsg()));
}
}



