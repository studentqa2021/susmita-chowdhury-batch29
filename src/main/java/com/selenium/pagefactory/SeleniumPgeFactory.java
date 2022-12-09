  package com.selenium.pagefactory;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SeleniumPgeFactory {WebDriver driver;
public SeleniumPgeFactory(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver,this);
	
}

@FindBy(xpath="(//*[@//*[@class='authorization-link']")
private List<WebElement> signinbtn;
@FindBy(xpath="//*[@id='email']")
private WebElement email;
@FindBy(xpath="//*[@title=password'']")
private WebElement password;
@FindBy(xpath="//*[@class='action login primary']")
private WebElement secondsigninbtn;
@FindBy(xpath="//*[@class='greet welcome']")

private List<WebElement>welcome; 

//costo web page



@FindBy(xpath ="//*[text()='Sign In / Register']")
private List<WebElement> costcoSingInBtn;

public List<WebElement> getCostcoSingInBtn() {
	return costcoSingInBtn;
}
public List<WebElement> getSigninbtn() {
	return signinbtn;
}
@FindBy(xpath="//*[@id='navigation-widget']//a")
private List<WebElement>costcoMenuBtn;


public List<WebElement> getCostcoMenuBtn() {
	return costcoMenuBtn;
}
public void setCostcoMenuBtn(List<WebElement> costcoMenuBtn) {
	this.costcoMenuBtn = costcoMenuBtn;

}
public void setDealOptions(List<WebElement> dealOptions) {
	this.dealOptions = dealOptions;
}

@FindBy(xpath ="//*[@class='sub-item']")
private List<WebElement> dealOptions;

public List<WebElement> getDealOptions() {
	return dealOptions;
}





public WebElement getEmail() {
	return email;
}
public WebElement getPassword() {
	return password;
}
public WebElement getSecondsigninbtn() {
	return secondsigninbtn;
}
public WebDriver getDriver() {
	return driver;
}
public List<WebElement> getWelcome() {
	return welcome;

}
} 

	
