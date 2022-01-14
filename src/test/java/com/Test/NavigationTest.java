package com.Test;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.net.MalformedURLException;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.base.base;
import com.pages.AccountPage;
import com.pages.BrowserPage;
import com.pages.FavoritesPage;
import com.pages.LoginPage;
import com.pages.MyLibrariesPage;
import com.pages.OfflinePage;
import com.pages.PersonalFilesPage;
import com.pages.RecentPage;
import com.pages.SearchPage;
import com.pages.SharedPage;
import com.pages.TrashPage;
import com.pages.WebLoginPage;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class NavigationTest extends base{
	
	LoginPage loginpage;
	AndroidDriver<AndroidElement> driver;
	WebLoginPage webloginpage;
	RecentPage recentpage;
	SearchPage search;
	AccountPage account;
	FavoritesPage favouritepage;
	OfflinePage offline;
	BrowserPage browser;
	SharedPage shared;
	TrashPage trash;
	PersonalFilesPage personalfiles;
	MyLibrariesPage mylibraries;
	String RecentTitle;
	boolean CurrentPage;
	String FavoriteTitle;
	String OfflineTitle;
	String BrowserTitle;
	
	
	NavigationTest()
	{
		
	}
	
	
	@BeforeClass
	public void Setup() throws MalformedURLException, InterruptedException
	{
        driver= capabilities();
		
		loginpage = new LoginPage();
		try
		{
		loginpage.provideEnvURL();
		}
		catch(Exception e)
		{
			recentpage = new RecentPage();
			account = recentpage.clickAccount();
			account.Logout();
			account.Signout();
			loginpage.provideEnvURL();
		}
		webloginpage = loginpage.LoginToWebEnv();
		recentpage = webloginpage.Signin("UserName1");
	}
	
	@Test(priority=1)
	public void NavigationFromRecentTest() throws InterruptedException, IOException
	{


        RecentTitle = recentpage.getRecentTitle();
        CurrentPage = recentpage.getSelectedPage();

		try {
		assertEquals( RecentTitle, "Recent");
		assertEquals( CurrentPage, true);
		}
		catch(Exception e) {
		}
		
		favouritepage = recentpage.clickFavorites();
		FavoriteTitle = favouritepage.getFavoriteTitle();
		CurrentPage = favouritepage.getSelectedPage();
		
		try {
			assertEquals( FavoriteTitle, "Favorites");
			assertEquals( CurrentPage, true);
			}
			catch(Exception e) {
			}
		
		recentpage = favouritepage.clickRecent();
		offline = recentpage.ClickOffline();
		OfflineTitle = offline.getOfflineTitle();
		CurrentPage = offline.getSelectedPage();
		
		try {
			assertEquals( OfflineTitle, "Offline");
			assertEquals( CurrentPage, true);
			}
			catch(Exception e) {
			}
		
		recentpage = offline.clickRecent();
		browser = recentpage.clickBrowser();
		BrowserTitle = browser.getBrowserTitle();
		CurrentPage = browser.getSelectedPage();
		
		try {
			assertEquals( BrowserTitle, "Browse");
			assertEquals( CurrentPage, true);
			}
			catch(Exception e) {
			}
	}
	
	
	@Test(priority=2)
	public void NavigationFromFavroitesTest() throws InterruptedException, IOException
	{
		recentpage = favouritepage.clickRecent();
		RecentTitle = recentpage.getRecentTitle();
        CurrentPage = recentpage.getSelectedPage();

		try {
		assertEquals( RecentTitle, "Recent");
		assertEquals( CurrentPage, true);
		}
		catch(Exception e) {
		}
		
		
		favouritepage = recentpage.clickFavorites();
		
		offline = favouritepage.clickOffline();
		recentpage = favouritepage.clickRecent();
		offline = recentpage.ClickOffline();
		
		OfflineTitle = offline.getOfflineTitle();
		CurrentPage = offline.getSelectedPage();
		
		try {
			assertEquals( OfflineTitle, "Offline");
			assertEquals( CurrentPage, true);
			}
			catch(Exception e) {
			}
		
		favouritepage = offline.clickFavorite();
		
		browser = favouritepage.clickBrowser();
		BrowserTitle = browser.getBrowserTitle();
		CurrentPage = browser.getSelectedPage();
		
		try {
			assertEquals( BrowserTitle, "Browse");
			assertEquals( CurrentPage, true);
			}
			catch(Exception e) {
			}
		
		offline = browser.clickOffline();
	}
	
	
	@Test(priority=3)
	public void NavigationFromOfflineTest() throws InterruptedException, IOException
	{
		recentpage = offline.clickRecent();
		
		RecentTitle = recentpage.getRecentTitle();
        CurrentPage = recentpage.getSelectedPage();

		try {
		assertEquals( RecentTitle, "Recent");
		assertEquals( CurrentPage, true);
		}
		catch(Exception e) {
		}
		
		offline = recentpage.ClickOffline();
        favouritepage = offline.clickFavorite();
		
        FavoriteTitle = favouritepage.getFavoriteTitle();
		CurrentPage = favouritepage.getSelectedPage();
		
		try {
			assertEquals( FavoriteTitle, "Favorites");
			assertEquals( CurrentPage, true);
			}
			catch(Exception e) {
			}
		
		offline = favouritepage.clickOffline();
		browser = offline.clickBrowser();
		BrowserTitle = browser.getBrowserTitle();
		CurrentPage = browser.getSelectedPage();
		
		try {
			assertEquals( BrowserTitle, "Browse");
			assertEquals( CurrentPage, true);
			}
			catch(Exception e) {
			}
	}
	
	
	@Test(priority=4)
	public void NavigationFromBrowserTest() throws InterruptedException, IOException
	{
		recentpage = browser.clickRecent();
		RecentTitle = recentpage.getRecentTitle();
        CurrentPage = recentpage.getSelectedPage();

		try {
		assertEquals( RecentTitle, "Recent");
		assertEquals( CurrentPage, true);
		}
		catch(Exception e) {
		}
		
		
		browser = recentpage.clickBrowser();
		offline = browser.clickOffline();
		
		OfflineTitle = offline.getOfflineTitle();
		CurrentPage = offline.getSelectedPage();
		
		try {
			assertEquals( OfflineTitle, "Offline");
			assertEquals( CurrentPage, true);
			}
			catch(Exception e) {
			}
		
		browser = offline.clickBrowser();
		favouritepage = browser.clickFavorites();
			
	    FavoriteTitle = favouritepage.getFavoriteTitle();
		CurrentPage = favouritepage.getSelectedPage();
			
			try {
				assertEquals( FavoriteTitle, "Favorites");
				assertEquals( CurrentPage, true);
				}
				catch(Exception e) {
				}
		
		
	}
	
	
	@AfterClass
	public void teardown(ITestResult testResult) throws InterruptedException {

	       if (testResult.getStatus() == ITestResult.SUCCESS)
	       {
	    	    account = recentpage.clickAccount();
				account.getAccountText("User");
				account.Logout();
				account.Signout();
		        Thread.sleep(10000);
				driver.quit();
	       }if(testResult.getStatus() == ITestResult.FAILURE) {
	    	   driver.quit();
	       }
		}

}
