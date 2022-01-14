package com.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.base.base;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class MyLibrariesPage extends base{
	
	public BrowserPage browser;
	public OfflinePage offline;
	public RecentPage recent;
	public FavoritesPage favorite;
	
	public MyLibrariesPage() {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.alfresco.content.app.debug:id/title\")")
	 WebElement txtemptymylibraries;
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.alfresco.content.app.debug:id/nav_browse\")")
	 WebElement clickBrowser;
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.alfresco.content.app.debug:id/nav_offline\")")
	 WebElement clickoffline;
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.alfresco.content.app.debug:id/nav_recents\")")
	 WebElement clickrecent;
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.alfresco.content.app.debug:id/nav_favorites\")")
	 WebElement clickfavorites;
	
	public String getEmptyMyLibraries()
	{
		return txtemptymylibraries.getText();
	}
	
	public BrowserPage clickBack() {
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
	 
	 public OfflinePage clickOffline() {
			tap(clickoffline);
			driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
			return  offline = new OfflinePage();
	 }

}
