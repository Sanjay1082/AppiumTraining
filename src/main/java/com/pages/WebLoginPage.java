package com.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.base.base;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class WebLoginPage extends base{

	RecentPage recent;
	
	
	public WebLoginPage()
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		recent = new RecentPage();
	}
	
	 @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"username\")")
	 WebElement txtUserName;
	 
	 @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"password\")")
	 WebElement txtPassword;
	 
	 @AndroidFindBy(className = "android.widget.Button")
	 WebElement btnSignIn;
	
	 
	 public RecentPage Signin(String UserName) throws InterruptedException
	 {
		 txtUserName.sendKeys(GetProperty(UserName));
		 txtPassword.sendKeys(GetProperty("Password"));
		 btnSignIn.click();
		 
		 driver.manage().timeouts().implicitlyWait(8000, TimeUnit.SECONDS);
		 return recent;
	 }
	 
	 
	
}
