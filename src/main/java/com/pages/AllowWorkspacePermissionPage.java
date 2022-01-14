package com.pages;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import com.base.base;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class AllowWorkspacePermissionPage extends base{

	AllowRecordPermissionPage allowpermission;
	
	public AllowWorkspacePermissionPage()
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.android.permissioncontroller:id/permission_message\")")
	private WebElement txtpermissionmessage;
	@AndroidFindBy(xpath = "//android.widget.Button[@class='android.widget.Button' and @index='0']")
	private WebElement btnwhileusingthisapp;
	@AndroidFindBy(xpath = "//android.widget.Button[@class='android.widget.Button' and @index='1']")
	private WebElement btnonlythistime;
	@AndroidFindBy(xpath = "//android.widget.Button[@class='android.widget.Button' and @index='2']")
	private WebElement btndeny;
	@AndroidFindBy(xpath = "//*[contains(@resource-id, 'permission_allow')]")
	private WebElement btnallowpixel;
	@AndroidFindBy(xpath = "//*[contains(@resource-id, 'permission_deny')]")
	private WebElement btndenypixel;
	
	public String getPermissionMessage()
	{
		return txtpermissionmessage.getText();
	}
	

	public String getPermissionText(String value)
	{
		switch(value)
		{
		case "While using the app":
		{
			driver.manage().timeouts().implicitlyWait(8000, TimeUnit.SECONDS);
			return btnwhileusingthisapp.getText();
			
		}
		case "Only this time":
		{
			driver.manage().timeouts().implicitlyWait(8000, TimeUnit.SECONDS);
			return btnonlythistime.getText();
			
		}
		case "Deny":
		{
			driver.manage().timeouts().implicitlyWait(8000, TimeUnit.SECONDS);
			return btndeny.getText();
			
		}
		default : 
			return null;
		}
	}
	
	public AllowRecordPermissionPage clickGrantPermission(String value,String device) throws Exception
	{
		switch(value)
		{
		case "While using the app":
		{
			if(device.equalsIgnoreCase(GetProperty("Device")))
			{
				tap(btnallowpixel);
				Thread.sleep(3000);
				
				driver.manage().timeouts().implicitlyWait(8000, TimeUnit.SECONDS);
				return allowpermission = new AllowRecordPermissionPage();
			}else
			{
			tap(btnwhileusingthisapp);
			Thread.sleep(3000);
			
			driver.manage().timeouts().implicitlyWait(8000, TimeUnit.SECONDS);
			return allowpermission = new AllowRecordPermissionPage();
			}
		}
		case "Only this time":
		{
			if(device.equalsIgnoreCase(GetProperty("Device")))
			{
				tap(btnallowpixel);
				Thread.sleep(3000);
				
				driver.manage().timeouts().implicitlyWait(8000, TimeUnit.SECONDS);
				return allowpermission = new AllowRecordPermissionPage();
			}else
			{
			tap(btnonlythistime);
			Thread.sleep(3000);
			
			driver.manage().timeouts().implicitlyWait(8000, TimeUnit.SECONDS);
			return allowpermission = new AllowRecordPermissionPage();
			}
			
		}
		case "Deny":
		{
			if(device.equalsIgnoreCase(GetProperty("Device")))
			{
				tap(btndenypixel);
				Thread.sleep(3000);
				
				driver.manage().timeouts().implicitlyWait(8000, TimeUnit.SECONDS);
				return allowpermission = new AllowRecordPermissionPage();
			}else
			{
			tap(btndeny);
			Thread.sleep(3000);
			
			driver.manage().timeouts().implicitlyWait(8000, TimeUnit.SECONDS);
			return allowpermission = new AllowRecordPermissionPage();
			}
			
		}
		default : 
			throw new Exception("No Permission is required");
		}
		
		
		
	}
	
}
