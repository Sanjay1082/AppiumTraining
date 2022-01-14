package com.Test;

import static org.testng.Assert.assertEquals;
import java.io.IOException;
import java.net.MalformedURLException;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.base.base;
import com.pages.WebLoginPage;
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
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;


public class EmptyAndriodScreenTest extends base{
   
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
	
	
	EmptyAndriodScreenTest()
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
	public void EmptyRecentTest() throws InterruptedException, IOException
	{
		
        String EmptyRecent = recentpage.getEmptyRecent();

		try {
		assertEquals( EmptyRecent, recentpage.EmptyRecent);
		}
		catch(Exception e) {
		}
		
	}
	
	@Test(priority=2)
	public void EmptyFavoritesTest() {
		favouritepage = recentpage.clickFavorites();
		favouritepage.defaultSelection();
		favouritepage.getFilesandFolders();
		favouritepage.getLibraries();
		String EmptyFilesandFolders = favouritepage.getEmptyFilesandFolders();
		
		try {
		assertEquals(EmptyFilesandFolders,"No favorite files or folders");
		}catch(Exception e)
		{
			
		}
	}
	
	@Test(priority=3)
	public void EmptyLibrariesTest() {
		favouritepage.clickLibraries();
		String EmptyLibraries = favouritepage.getEmptyLibraries();
		try 
		{
			assertEquals(EmptyLibraries,"No favorite libraries");
		}catch(Exception e)
		{
				
		}
	}
	
	@Test(priority=4)
	public void EmptyOfflineTest() {
		offline = favouritepage.clickOffline();
		String EmptyOffline = offline.getEmptyOffline();
		
		try 
		{
			assertEquals(EmptyOffline,"No offline content");
		}catch(Exception e)
		{
				
		}
	}
	
	@Test(priority=5)
	public void EmptySharedTest() {
		browser = offline.clickBrowser();
		shared = browser.clickShared();
		String EmptyShared = shared.getEmptyShared();
		
		try 
		{
			assertEquals(EmptyShared,"Folder is empty");
		}catch(Exception e)
		{
				
		}
		
		shared.clickBack();
	}
	
	@Test(priority=6)
	public void EmptyTrashTest() {
		trash = browser.clickTrash();
		String EmptyTrash = trash.getEmptyTrash();
		
		try 
		{
			assertEquals(EmptyTrash,"Folder is empty");
		}catch(Exception e)
		{
				
		}
		
		shared.clickBack();
	}
	
	@Test(priority=7)
	public void EmptyPersonalFilesTest() {
		personalfiles = browser.clickPersonalFiles();
		String EmptyPersonalFIles = personalfiles.getEmptyPersonalFiles();
		
		try 
		{
			assertEquals(EmptyPersonalFIles,"Folder is empty");
		}catch(Exception e)
		{
				
		}
		
		shared.clickBack();
	}
	
	@Test(priority=8)
	public void EmptyMyLibrariesTest() {
		mylibraries = browser.clickMyLibraries();
		String EmptyMyLibraries = mylibraries.getEmptyMyLibraries();
		
		try 
		{
			assertEquals(EmptyMyLibraries,"Folder is empty");
		}catch(Exception e)
		{
				
		}	
		shared.clickBack();
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
