package com.drivermanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {
 static	WebDriver driver;

  public static WebDriver getBrowser(String BrowserName) {
	 if (BrowserName.contains("chrome")) {
	  WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		 }else if(BrowserName.contains("edge")) {
    WebDriverManager.chromedriver().setup();
	 driver = new ChromeDriver();
}
	 return driver;
}
  
}