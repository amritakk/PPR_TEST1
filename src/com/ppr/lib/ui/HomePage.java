package com.ppr.lib.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	WebDriver driver;
		public HomePage(WebDriver driver) {
			this.driver=driver;
			}
		public WebElement LogoutHeader() {
			return driver.findElement(By.xpath("//span[text()='Facebook']"));
		}
		public WebElement LogoutButtonDropDown() {
			return driver.findElement(By.id("userNavigationLabel"));
			}
		public WebElement LogoutButton() {
			return driver.findElement(By.xpath("//Span[text()='Log Out']"));
			}
		public void WaitForHomePageToLoad() {
			WebDriverWait wait = new WebDriverWait(driver,30);
			wait.until(ExpectedConditions.visibilityOf(LogoutHeader()));
			}
		public void WaitForLogoutbuttonToLoad() {
			WebDriverWait wait = new WebDriverWait(driver,30);
			wait.until(ExpectedConditions.visibilityOf(LogoutButton()));
			}		
		
		}
	


