package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.base.base;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class AdvancedSettingsPage extends base{

	LoginPage loginpage;
	
	public AdvancedSettingsPage()
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	 @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.alfresco.content.app:id/etPort\")")
	 WebElement txtHttpsPort;
	 @AndroidFindBy(xpath = "//*[text()='alfresco']")
	 WebElement txtAlfrescoContentServicePath;
	 @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.alfresco.content.app:id/etRealm\")")
	 WebElement txtAuthenticationRealM;
	 @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.alfresco.content.app:id/etClientId\")")
	 WebElement txtAUthenticationCLientID;
	 @AndroidFindBy(className = "android.widget.ImageButton")
	 WebElement btnback;
	 @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.alfresco.content.app.debug:id/reset\")")
	 WebElement btnreset;
	 @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.alfresco.content.app.debug:id/btnHelp\")")
	 WebElement lnkneedhelp;
	 @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.alfresco.content.app.debug:id/save_button\")")
	 WebElement btnsave;
	 @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.alfresco.content.app.debug:id/tvProtocolSwitch\")")
	 WebElement btnprotocolswitch;
	 @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.alfresco.content.app.debug:id/tvProtocolTitle\")")
	 WebElement txtprotocoltitle;
	 @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.alfresco.content.app.debug:id/tvAuthentication\")")
	 WebElement txtauthentication;
	 @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.alfresco.content.app.debug:id/titleTxt\")")
	 WebElement txthelp;
	 @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.alfresco.content.app.debug:id/bodyTxt\")")
	 WebElement txthelpbody;
	 @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.alfresco.content.app.debug:id/btnClose\")")
	 WebElement btnclose;
	 
	 
	 public LoginPage gotoAlfrescoLoginPage()
	 {
		btnback.click();
		return loginpage= new LoginPage();
	 }
}
