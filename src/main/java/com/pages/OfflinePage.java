package com.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import com.base.base;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class OfflinePage extends base{

	FavoritesPage favorite;
	BrowserPage browser;
    RecentPage recent;
	
	public OfflinePage()
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	

	 @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.alfresco.content.app.debug:id/title\")")
	 WebElement emptyoffline;
	 @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.alfresco.content.app.debug:id/message\")")
	 WebElement emptyofflinemessage;
	 @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.alfresco.content.app.debug:id/nav_favorites\")")
	 WebElement clickfavorites;
	 @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.alfresco.content.app.debug:id/nav_browse\")")
	 WebElement clickBrowser;
	 @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.alfresco.content.app.debug:id/nav_recents\")")
	 WebElement clickrecent;
	 @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.alfresco.content.app.debug:id/nav_offline\")")
	 WebElement txtofflinetitle;
	 
	 
	 public boolean getSelectedPage(){
			return txtofflinetitle.isSelected();
	 }
	 
	 public String getOfflineTitle(){
			return txtofflinetitle.getTagName().toString();
	 }
	 
	 public String getEmptyOffline() {
		 return emptyoffline.getText();
	 }
	 
	 public BrowserPage clickBrowser() {
		 clickBrowser.click();
		 driver.manage().timeouts().implicitlyWait(8000, TimeUnit.SECONDS);
		 return browser = new BrowserPage();
	 }
	 
	 public FavoritesPage clickFavorite() {
		 clickfavorites.click();
		 driver.manage().timeouts().implicitlyWait(8000, TimeUnit.SECONDS);
		 return favorite = new FavoritesPage();
	 }
	 
	 public RecentPage clickRecent() {
		 clickrecent.click();
		 driver.manage().timeouts().implicitlyWait(8000, TimeUnit.SECONDS);
		 return recent= new RecentPage();
	 }
	
}
