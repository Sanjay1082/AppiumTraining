package com.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import com.base.base;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class AccountPage extends base{
	
	RecentPage recent;
	
	public AccountPage()
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(className = "android.widget.TextView")
	List<WebElement> txtaccount;
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"android:id/title\")")
    WebElement txtusername;
	@AndroidFindBy(className = "android.widget.TextView")
	List<WebElement> txtuseremail;
	@AndroidFindBy(className = "android.widget.TextView")
	List<WebElement> txttheme;
	@AndroidFindBy(className = "android.widget.TextView")
	List<WebElement> txtupdatesusingonly;
	@AndroidFindBy(className = "android.widget.TextView")
	List<WebElement> txtappversion;
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.alfresco.content.app:id/alertTitle\")")
	WebElement txtsignout;
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"android:id/message\")")
	WebElement txtmessage;
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"android:id/button2\")")
	WebElement btncancel;
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"android:id/button1\")")
	WebElement btnyes;
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.alfresco.content.app.debug:id/sign_out_button\")")
    WebElement btnlogout;
	
	
	public void Logout()
	{
		btnlogout.click();	
		driver.manage().timeouts().implicitlyWait(8000, TimeUnit.SECONDS);
	}
	
	public RecentPage Signout()
	{
		btnyes.click();	
		driver.manage().timeouts().implicitlyWait(8000, TimeUnit.SECONDS);
		return recent = new RecentPage();
	}
	
	
	
	public String getAccountText(String Value)
	{
		switch(Value)
		{
			case "Account" :
				return txtaccount.get(0).getText();
			case "User" :
				return txtusername.getText();
			case "UserEmail" :
				return txtuseremail.get(2).getText();
			case "Theme" :
				return txttheme.get(4).getText();	
			case "UpdatedOnly" :
				return txtupdatesusingonly.get(7).getText();	
			case "btnlogout" :
				return btnlogout.getText();	
			case "AppVersion" :
				return txtappversion.get(8).getText();	
			case "Sign Out" :
				return txtsignout.getText();	
			case "Signout Message" :
				return txtmessage.getText();	
			case "Cancel" :
				return btncancel.getText();	
			case "Yes" :
				return btnyes.getText();		
		}
		return null;
	}
}
