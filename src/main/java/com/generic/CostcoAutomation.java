package com.generic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.asserts.SoftAssert;

import com.drivermanager.DriverManager;
import com.selenium.pagefactory.SeleniumPgeFactory;
import com.util.Constants;
import com.util.HighLighter;
import com.util.ScreenShot;
import com.util.SeleniumWait;

public class CostcoAutomation {

	public static  void productHandle(){
		//1)	Go to https://www.costco.com/
	WebDriver driver=DriverManager.getBrowser("chrome");
		driver.manage().window().maximize();
		driver.navigate().to(Constants.COSTCO_URl);
		SeleniumWait.getImplicitWait(driver,5);
		//	2)	Get the page name
		System.out.println("Home page name="+driver.getTitle());
		ScreenShot.getScreenShot(driver, "Costco home welcome page");

//	3)	Check current URL is matched or not
		System.out.println("Current page URL="+driver.getCurrentUrl());
		SoftAssert sf = new SoftAssert();
		sf.assertEquals(driver.getCurrentUrl(),Constants.COSTCO_URl);
//		4)	Go to sign in page  
		SeleniumPgeFactory pf = new SeleniumPgeFactory(driver);
		SeleniumWait.getExplicitWait(driver,pf.getCostcoSingInBtn().get(0), 30);
		HighLighter.getcolor(driver,pf.getCostcoSingInBtn().get(0),"red");
		pf.getCostcoSingInBtn().get(0).click();
		System.out.println("Login page name="+driver.getTitle());		
		ScreenShot.getScreenShot(driver, "Costco Sign In page");
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
driver.navigate().back();

while(true) {//true==> infinite loop
	if(pf.getCostcoSingInBtn().size()>0) {
		break;
	}else {
		driver.navigate().back();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
	
  System.out.println("Menu coun t= " +pf.getCostcoMenuBtn().size());

  for(int i=0;i<pf.getCostcoMenuBtn().size();i++) {
		HighLighter.getcolor(driver,pf.getCostcoMenuBtn().get(i),"white" );
		System.out.println(pf.getCostcoMenuBtn().get(i).getText());
		
	}
  
//8 >If the deal was there, then mouse over it and read all options
		//mouse hover= Actions class= moveToElement()
		
		
		for(int i=0;i<pf.getCostcoMenuBtn().size();i++) {
			
			if(pf.getCostcoMenuBtn().get(i).getText().contains("Deals")) {//true
				HighLighter.getcolor(driver,pf.getCostcoMenuBtn().get(i),"red");
				Actions ac = new Actions(driver);
				ac.moveToElement(pf.getCostcoMenuBtn().get(i)).perform();
try {
	Thread.sleep(2000);
} catch (InterruptedException e) {
	
	e.printStackTrace();
}
				
				
				System.out.println("Deal options count = "+pf.getDealOptions().size());
				//Read name of All deal options==> loop
				for(int j=0;j<pf.getDealOptions().size();j++) {//2nd loop
					HighLighter.getcolor(driver,pf.getDealOptions().get(j),"red" );
					System.out.println(pf.getDealOptions().get(j).getText());
				}
				
			}
			
		}
				
				
				

  
		
		
		
  
  
  
  

		sf.assertAll();	
	}	
	
	
	public static void main(String[] args) {
		CostcoAutomation.productHandle();
		
		
	}
	
}
