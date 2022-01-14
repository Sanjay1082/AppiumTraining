package com.Test;

import static org.testng.Assert.assertEquals;
import java.net.MalformedURLException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
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


public class GlobalSearchInteractionsTest extends base{
	
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
	
	
	GlobalSearchInteractionsTest()
	{
		
	}
	
    @BeforeMethod
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
		recentpage = webloginpage.Signin("UserName");
	}
	
	@Test(priority=1)
	public void GlobalSearchFromRecentTabTest() throws Exception {
		
		search = recentpage.clickOnSearchfromRecent();
		search.enterTextInSearchBox("AutomationPhotos4");
		Thread.sleep(3000);
		
		boolean Name = search.getSearchRecordInformation("Name").startsWith("AutomationPhotos");
		boolean filechip = search.isFileChecked();
		boolean folderchip = search.isFileChecked();
		boolean librarieschip = search.isLibrariesChecked();
		
		try {
		assertEquals(filechip, true);
		assertEquals(folderchip, true);
		assertEquals(librarieschip, false);
		assertEquals(Name, true);
		}
		catch(Exception e)
		{
			throw new Exception("File, Folder and Libraries chips are not set to default value");
		}
		
		search.clickExitSearch();
		
	}
	
	@Test(priority=2)
	public void GlobalSearchFromFavoritesTabTest() throws Exception {

				favouritepage = recentpage.clickFavorites();
				search = recentpage.clickOnSearchfromRecent();
				search.enterTextInSearchBox("AutomationPhotos4");
				Thread.sleep(3000);
				
				boolean Name = search.getSearchRecordInformation("Name").startsWith("AutomationPhotos");
				boolean filechip = search.isFileChecked();
				boolean folderchip = search.isFileChecked();
				boolean librarieschip = search.isLibrariesChecked();
				 
				try {
					assertEquals(filechip, true);
					assertEquals(folderchip, true);
					assertEquals(librarieschip, false);
					assertEquals(Name, true);
				}
				catch(Exception e)
				{
					throw new Exception("File, Folder and Libraries chips are not set to default value");
				}
				
				search.clickExitSearch();
		
	}

	@Test(priority=3)
	public void GlobalSearchFromOfflineTabTest() throws Exception {

		        favouritepage = recentpage.clickFavorites();
				offline = favouritepage.clickOffline();
				search = recentpage.clickOnSearchfromRecent();
				Thread.sleep(3000);
				search.enterTextInSearchBox("AutomationPhotos4");
				Thread.sleep(3000);
				
				boolean Name = search.getSearchRecordInformation("Name").startsWith("AutomationPhotos");
				boolean filechip = search.isFileChecked();
				boolean folderchip = search.isFileChecked();
				boolean librarieschip = search.isLibrariesChecked();
				 
				try {
					assertEquals(filechip, true);
					assertEquals(folderchip, true);
					assertEquals(librarieschip, false);
					assertEquals(Name, true);
				}
				catch(Exception e)
				{
					throw new Exception("File, Folder and Libraries chips are not set to default value");
				}
				
				search.clickExitSearch();
		
	}
	
	@Test(priority=4)
	public void GlobalSearchFromBrowseTabTest() throws Exception {

		        favouritepage = recentpage.clickFavorites();
		        offline = favouritepage.clickOffline();
				offline.clickBrowser();
				search = recentpage.clickOnSearchfromRecent();
				search.enterTextInSearchBox("AutomationPhotos4");
				Thread.sleep(3000);

				boolean Name = search.getSearchRecordInformation("Name").startsWith("AutomationPhotos");
		
				boolean filechip = search.isFileChecked();
				boolean folderchip = search.isFileChecked();
				boolean librarieschip = search.isLibrariesChecked();
				 
				try {
					assertEquals(filechip, true);
					assertEquals(folderchip, true);
					assertEquals(librarieschip, false);
					assertEquals(Name, true);
				}
				catch(Exception e)
				{
					throw new Exception("File, Folder and Libraries chips are not set to default value");
				}
				
				search.clickExitSearch();
				
		
	}
	
	@Test(priority=5)
	public void PartialGlobalSearchTest() throws Exception {
		
		offline = recentpage.ClickOffline();
		search = recentpage.clickOnSearchfromRecent();
		search.enterTextInSearchBox("Aut");
		Thread.sleep(3000);
		
		String Name = search.getSearchRecordInformation("Name");
		boolean filechip = search.isFileChecked();
		boolean folderchip = search.isFileChecked();
		boolean librarieschip = search.isLibrariesChecked();
		
		boolean PartialSearchRecord = Name.startsWith("Aut");
		 
		try {
			assertEquals(filechip, true);
			assertEquals(folderchip, true);
			assertEquals(librarieschip, false);
			assertEquals(PartialSearchRecord, true);
		}
		catch(Exception e)
		{
			throw new Exception("File, Folder and Libraries chips are not set to default value");
		}
		
		search.clickExitSearch();
	}
	
	@Test(priority=6)
	public void SpecialCharacterGlobalSearchTest() throws Exception {
		
		search = recentpage.clickOnSearchfromRecent();
		search.enterTextInSearchBox("Au*");
		Thread.sleep(3000);
		
		String Name = search.getSearchRecordInformation("Name");
		boolean filechip = search.isFileChecked();
		boolean folderchip = search.isFileChecked();
		boolean librarieschip = search.isLibrariesChecked();
		
		boolean PartialSearchRecord = Name.startsWith("Aut");
		 
		try {
			assertEquals(filechip, true);
			assertEquals(folderchip, true);
			assertEquals(librarieschip, false);
			assertEquals(PartialSearchRecord, true);
		}
		catch(Exception e)
		{
			throw new Exception("File, Folder and Libraries chips are not set to default value");
		}
		
		search.clickExitSearch();
	}
	
	@Test(priority=7)
	public void LessThan2CharacterGlobalSearchTest() throws Exception {
		
		search = recentpage.clickOnSearchfromRecent();
		search.enterTextInSearchBox("Au");
		Thread.sleep(3000);
		
		boolean filechip = search.isFileChecked();
		boolean folderchip = search.isFileChecked();
		boolean librarieschip = search.isLibrariesChecked();
		String elementexits = search.getRecentSearches();

		try {
			assertEquals(filechip, true);
			assertEquals(folderchip, true);
			assertEquals(librarieschip, false);
			assertEquals(elementexits, "Recent searches");
		}
		catch(Exception e)
		{
			throw new Exception("No record avaialable in the search results");
		}
		
		search.clickExitSearch();
		
	}
	
	@Test(priority=8)
	public void FolderFilterSelectionGlobalSearchTest() throws Exception {
		
		search = recentpage.clickOnSearchfromRecent();
		search.enterTextInSearchBox("Auto");
		Thread.sleep(3000);
		
		search.selectFileChip(false);
		
		boolean filechip = search.isFileChecked();
		boolean folderchip = search.isFolderChecked();
		boolean librarieschip = search.isLibrariesChecked();
		
		String folderName = search.getSearchRecordInformation("Name");

		try {
			assertEquals(filechip, false);
			assertEquals(folderchip, true);
			assertEquals(librarieschip, false);
			assertEquals(folderName, "Automation");
		}
		catch(Exception e)
		{
			throw new Exception("No record avaialable in the search results");
		}
		
		search.clickExitSearch();

	}
	
	@Test(priority=9)
	public void FileFilterSelectionGlobalSearchTest() throws Exception {
		
		search = recentpage.clickOnSearchfromRecent();
		search.enterTextInSearchBox("Img");
		Thread.sleep(3000);
		
		search.selectFileChip(false);
		String nofolder = search.getNoFolderAvailable();
		
		search.selectFolderChip(false);
		search.selectFileChip(true);
		
		boolean filechip = search.isFileChecked();
		boolean folderchip = search.isFolderChecked();
		boolean librarieschip = search.isLibrariesChecked();
		boolean fileName = search.getSearchRecordInformation("Name").startsWith("IMG_2021");

		try {
			assertEquals(filechip, true);
			assertEquals(folderchip, false);
			assertEquals(librarieschip, false);
			assertEquals(fileName, true);
			assertEquals(nofolder, "Oops!");
		}
		catch(Exception e)
		{
			throw new Exception("No record avaialable in the search results");
		}
		
		search.clickExitSearch();
		
	}
	
	
	@Test(priority=10)
	public void LiabrraiesFilterSelectionGlobalSearchTest() throws Exception {
		
		search = recentpage.clickOnSearchfromRecent();
		search.enterTextInSearchBox("Aut");
		Thread.sleep(3000);

		
		search.selectLibrariesChip(true);
		
		boolean filechip = search.isFileChecked();
		boolean folderchip = search.isFolderChecked();
		boolean librarieschip = search.isLibrariesChecked();
		String libraryName = search.getSearchRecordInformation("Library");

		try {
			assertEquals(filechip, false);
			assertEquals(folderchip, false);
			assertEquals(librarieschip, true);
			assertEquals(libraryName, "AutomationLibrary");
		}
		catch(Exception e)
		{
			throw new Exception("No record avaialable in the search results");
		}
		
		search.clickExitSearch();
		
	}
	
	@Test(priority=11)
	public void FileDescriptionBasedGlobalSearchTest() throws Exception {
		
		search = recentpage.clickOnSearchfromRecent();
		search.enterTextInSearchBox("This is used as a test data for the Automation");
		Thread.sleep(3000);
		
		search.selectFileChip(true);
		boolean fileName = search.getSearchRecordInformation("Name").startsWith("AutomationPhoto".toLowerCase());
		
		search.selectFileChip(false);
		search.selectFolderChip(true);
		
		String nofolder = search.getNoFolderAvailable();
	
		
		boolean filechip = search.isFileChecked();
		boolean folderchip = search.isFolderChecked();
		boolean librarieschip = search.isLibrariesChecked();


		try {
			assertEquals(filechip, false);
			assertEquals(folderchip, true);
			assertEquals(librarieschip, false);
			assertEquals(fileName, true);
			assertEquals(nofolder, "Oops!");
		}
		catch(Exception e)
		{
			throw new Exception("No record avaialable in the search results");
		}
		
		search.clickExitSearch();
		
	}
	
	@Test(priority=12)
	public void FolderDescriptionBasedGlobalSearchTest() throws Exception {
		
		search = recentpage.clickOnSearchfromRecent();
		
		search.selectFileChip(true);
		search.selectFolderChip(true);
		
		search.enterTextInSearchBox("This is created as test data setup for the android app automation");
		Thread.sleep(3000);
		
		boolean filechip = search.isFileChecked();
		boolean folderchip = search.isFolderChecked();
		boolean librarieschip = search.isLibrariesChecked();
		
		String folderName = search.getSearchRecordInformation("Name");

		try {
			assertEquals(filechip, true);
			assertEquals(folderchip, true);
			assertEquals(librarieschip, false);
			assertEquals(folderName, "Automation");
		}
		catch(Exception e)
		{
			throw new Exception("No record avaialable in the search results");
		}
		search.clickExitSearch();
	}
	
	@Test(priority=13)
	public void LibrariesDescriptionBasedGlobalSearchTest() throws Exception {
		
		search = recentpage.clickOnSearchfromRecent();
		search.enterTextInSearchBox("This is created to enable automation of the app");
		Thread.sleep(3000);
		
		search.selectLibrariesChip(true);
		
		boolean filechip = search.isFileChecked();
		boolean folderchip = search.isFolderChecked();
		boolean librarieschip = search.isLibrariesChecked();
		String libraryName = search.getSearchRecordInformation("Library");

		try {
			assertEquals(filechip, false);
			assertEquals(folderchip, false);
			assertEquals(librarieschip, true);
			assertEquals(libraryName, "AutomationLibrary");
		}
		catch(Exception e)
		{
			throw new Exception("No record avaialable in the search results");
		}
		
		search.clickExitSearch();
		
	}
	
	
    @AfterMethod
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
