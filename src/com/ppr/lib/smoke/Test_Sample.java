package com.ppr.lib.smoke;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ppr.lib.ui.HomePage;
import com.ppr.lib.ui.LoginPage;
import com.ppr.lib.util.Create_Driver;
import com.ppr.lib.util.Data_Handlers;


public class Test_Sample {
	WebDriver driver;
	LoginPage Login;
	 HomePage Home;
  @ BeforeMethod
  public void Precondition() {
	  driver=Create_Driver.GetBrowserInstance();
	  Login=new LoginPage(driver);
	  Home=new HomePage(driver);
  }
  @ AfterMethod
  public void Postcondition() {
	  
	  driver.close();
  }
 
  @Test
  public void TestSample() throws InterruptedException {
	  String UN=Data_Handlers.GetDataFromExcel("Test_Data","Sheet1" ,1, 0);
	  String PW=Data_Handlers.GetDataFromExcel("Test_Data","Sheet1" ,1, 1);
	  String Exp=Data_Handlers.GetDataFromExcel("Test_Data","Sheet1" ,1, 2);
	  //System.out.println(UN);
	  //System.out.println(PW);
	  Login.WaitForLoginPageToLoad();
	  Login.GetUserNameTextbox().sendKeys(UN);
	  Login.GetPasswordTextbox().sendKeys(PW);
	  Login.GetLoginbutton().click();
	  Home.WaitForHomePageToLoad();
	  //String AT=driver.getTitle();
	  //Assert.assertEquals(AT, Exp);
	  Home.LogoutButtonDropDown().click();
	  Home.WaitForHomePageToLoad();
	  Home.LogoutButton().click();
	  Login.WaitForLoginPageToLoad();
  }
 
}
