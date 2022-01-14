package com.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.base.base;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LoginPage extends base{

	WebLoginPage weblogin;
	
public LoginPage()
{
	PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	weblogin = new WebLoginPage ();
}
	
 @AndroidFindBy(className="android.widget.TextView")
 WebElement txtALfrescoMobileWorkspace;
 
 @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.alfresco.content.app:id/btnAdvancedSettings\")")
 WebElement linkAdavancedSettings;
 
 @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.alfresco.content.app.debug:id/etConnectUrl\")")
 WebElement txtConnectto;
 
 @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.alfresco.content.app.debug:id/btnConnect\")")
 WebElement btnConnect;
	
 public WebLoginPage LoginToWebEnv()
 {
	 //txtALfrescoMobileWorkspace.sendKeys("mobileapp.envalfresco.com");
	 btnConnect.click();
	 driver.manage().timeouts().implicitlyWait(8000, TimeUnit.SECONDS);
	 return weblogin;
 }
 
 public void provideEnvURL()
 {
	 txtConnectto.sendKeys(GetProperty("URL"));
	 driver.manage().timeouts().implicitlyWait(8000, TimeUnit.SECONDS);
	 
 }
}
