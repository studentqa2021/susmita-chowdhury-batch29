package com.generic;



import org.openqa.selenium.WebDriver;

import org.testng.asserts.SoftAssert;

import com.drivermanager.DriverManager;
import com.selenium.pagefactory.SeleniumPgeFactory;
import com.util.Constants;
import com.util.HighLighter;
import com.util.SeleniumWait;


public class BaseLogin {
	
	public  void getLogin() {
		//open browser
		WebDriver driver =DriverManager.getBrowser("chrome");
		//WebDriverManager.chromedriver().setup();
		//WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		SeleniumWait.getImplicitWait(driver,3);
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get(Constants.URL);
		SeleniumPgeFactory pf=new SeleniumPgeFactory(driver);
		//explicit wait=WebDriver wait
		SeleniumWait.getExplicitWait(driver, pf.getSigninbtn().get(0), 3 );
		//WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(3));
		//wait.until(ExpectedConditions.elementToBeClickable(pf.getSigninbtn().get(0)));
		//click sign in
		HighLighter.getcolor(driver,pf.getSigninbtn().get(0),"red");
		pf.getSigninbtn().get(0).click();
		//put user
		HighLighter.getcolor(driver,pf.getEmail(),"green");
		pf.getEmail().click();
		pf.getEmail().sendKeys(Constants.user);
		//put pass
		HighLighter.getcolor(driver,pf.getPassword(),"green");
		pf.getPassword().click();
		pf.getPassword().sendKeys(Constants.password);
		//click second sign in
		HighLighter.getcolor(driver,pf.getSecondsigninbtn(),"green");
		pf.getSecondsigninbtn().click();
		//validation
		boolean status=pf.getWelcome().get(0).isDisplayed();
		SoftAssert sa =new SoftAssert();
		sa.assertTrue(status);
		
		
	}

}
