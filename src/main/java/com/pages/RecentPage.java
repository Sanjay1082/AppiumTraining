package com.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.base.base;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class RecentPage extends base{
	
	SearchPage search;
	FavoritesPage favorites;
	OfflinePage offline;
	BrowserPage browser;
	AccountPage account;
	FavoritesPage favoritespage;
	
	public String EmptyRecent ="No recent files";
	public String EMptyRecentMessage="Files that you view and\r\n"
			+ "edit will show here.";
	
	public RecentPage() {
		
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.alfresco.content.app.debug:id/title\")")
	 WebElement clickimage;
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.alfresco.content.app.debug:id/nav_favorites\")")
	 WebElement clickfavorites;
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.alfresco.content.app.debug:id/nav_offline\")")
	 WebElement clickoffline;
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.alfresco.content.app.debug:id/nav_browse\")")
	 WebElement clickBrowser;
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.alfresco.content.app.debug:id/more_icon\")")
	 WebElement clickmore;
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.alfresco.content.app.debug:id/toolbar_back\")")
	WebElement clicksearch;
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.alfresco.content.app.debug:id/search\")")
	WebElement clickcontextualsearch;
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.alfresco.content.app.debug:id/search_src_text\")")
	WebElement txtsearch;
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.alfresco.content.app.debug:id/icon\")")
	WebElement linkaccount;
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.alfresco.content.app.debug:id/title\")")
	WebElement txtemptyrecent;
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.alfresco.content.app.debug:id/message\")")
	WebElement txtemptyrecentmessage;
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.alfresco.content.app.debug:id/nav_recents\")")
	WebElement txtrecenttitle;

	
	
	public String getEmptyRecent()
	{
		return txtemptyrecent.getText();
	}
	
	public String getEmptyRecentMessage()
	{
		return txtemptyrecentmessage.getText();
	}
	
	public String getRecentTitle()
	{
		return txtrecenttitle.getTagName().toString();
	}
	
	public boolean getSelectedPage()
	{
		return txtrecenttitle.isSelected();
	}
	
	public SearchPage clickOnSearchfromRecent()
	{
		clicksearch.click();
		driver.manage().timeouts().implicitlyWait(8000, TimeUnit.SECONDS);
		return search = new SearchPage();
	}
	
	public SearchPage clickOnContextualSearchfromRecent()
	{
		clickcontextualsearch.click();
		driver.manage().timeouts().implicitlyWait(8000, TimeUnit.SECONDS);
		return search = new SearchPage();
	}
	
	public SearchPage clickSearch(String value)
	{
		clicksearch.click();
		driver.manage().timeouts().implicitlyWait(8000, TimeUnit.SECONDS);
        txtsearch.sendKeys(value);
		return search;
	}
	
	public AccountPage clickAccount()
	{
		linkaccount.click();
		driver.manage().timeouts().implicitlyWait(8000, TimeUnit.SECONDS);
		return account =new AccountPage();
	}
	
	public BrowserPage clickBrowser()
	{
		clickBrowser.click();
		driver.manage().timeouts().implicitlyWait(8000, TimeUnit.SECONDS);
		return browser=new BrowserPage();
	}
	
	public FavoritesPage clickFavorites()
	{
		clickfavorites.click();
		driver.manage().timeouts().implicitlyWait(8000, TimeUnit.SECONDS);
		return favorites = new FavoritesPage();
	}
	
	public OfflinePage ClickOffline()
	{
		clickoffline.click();
		driver.manage().timeouts().implicitlyWait(8000, TimeUnit.SECONDS);
		return offline= new OfflinePage();
	}
	
}
