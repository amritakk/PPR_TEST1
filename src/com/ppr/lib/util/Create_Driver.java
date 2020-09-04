package com.ppr.lib.util;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Create_Driver {
	public static WebDriver GetBrowserInstance() {
		WebDriver driver;
		String Browser =Data_Handlers.GetDataFromProperties("Data","Browser" );
		String url=Data_Handlers.GetDataFromProperties("Data","URL" );
		if(Browser.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver","./Browser_Server/chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
            options.setExperimentalOption("useAutomationExtension", false);
            options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
            Map<String, Object> prefs = new HashMap<String, Object>();
            prefs.put("credentials_enable_service", false);
            prefs.put("profile.password_manager_enabled", false);
            options.addArguments("start-maximized"); 
            options.addArguments("--no-sandbox"); 
            options.addArguments("--disable-infobars"); 
            options.addArguments("--disable-dev-shm-usage"); 
            options.addArguments("--disable-browser-side-navigation"); 
            options.addArguments("--disable-gpu");
            options.addArguments("--disable-web-security");
            options.addArguments("--allow-running-insecure-content");
            options.addArguments("--disable-notifications");

            options.setExperimentalOption("prefs", prefs);   
            driver = new ChromeDriver(options);
		}
		else if(Browser.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.chrome.driver","./Browser_Server/geckodriver.exe");
			driver=new FirefoxDriver();
		}
		else {
			System.err.println(" Invalid Browser Information please check config_Folder/data.properties file");
			return null;
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.get(url);
		return driver;
	}

}



