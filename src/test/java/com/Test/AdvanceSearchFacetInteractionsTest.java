package com.Test;

import static org.testng.Assert.assertEquals;
import java.net.MalformedURLException;
import java.util.SortedSet;
import java.util.TreeSet;
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


public class AdvanceSearchFacetInteractionsTest extends base{
	
	/*
	 Need to check below test data
	 Add AutomationAndroid, AutomationIOS files and folder 
	 Img001, Test file with description - Automation
	 Add Auto file with description "automation" in AutomationAndroid folder
	 */
	
	
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
	String chipinitial;
	String chipfinal;
	String fromdate;
	String todate;
	String dateconcat;
	
	AdvanceSearchFacetInteractionsTest()
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
	public void verifyTheVisibilityOfSearchFacetTest() throws Exception {
		
		search = recentpage.clickOnSearchfromRecent();
		// Chips on first unsuccessful search
		search.enterTextInSearchBox("ashdgasjhgdj"); 
		
		try {
			assertEquals("Name", search.getChipAtIndex(0));
			assertEquals("Check List", search.getChipAtIndex(1));
			assertEquals("Content Size", search.getChipAtIndex(2));
			assertEquals("Content Size (range)", search.getChipAtIndex(3));
	    }catch(Exception e)
	    {
		System.out.println("Actual and Expected values are not same");
	    }
	
		//Scrolling
	    for(int i=0; i<3;i++) {
		search.swipeChipsTo("Right");
		Thread.sleep(2000);
        }
	
	    try {
		assertEquals("Created Date (range)", search.getChipAtIndex(1));
		assertEquals("Type", search.getChipAtIndex(2));
        }catch(Exception e)
        {
	    System.out.println("Actual and Expected values are not same");
        }
		
	    //Chips on first successful search
	    search.clickClearSearch();
	    search.clickButton("ResetChipsValues");

	 	search.enterTextInSearchBox("Sample"); 
	 		
	 	String[] chipslabels = new String[]{"Check List","Content Size","Content Size (range)","Created","Created Date (range)","Creator","Modifier","Name","Size","Size facet queries","The Created","The Modified","Type","Type facet queries"};
	 	SortedSet<String> chipsname = new TreeSet<String>();
	 	    
	 	for(int i=0; i<7;i++) 
	 	{
	 			chipsname.add(search.getChipAtIndex(0));
	 			chipsname.add(search.getChipAtIndex(1));
	 			chipsname.add(search.getChipAtIndex(2));
	 		    search.swipeChipsTo();
	 		    Thread.sleep(2000);
	    }
	    chipsname.add(search.getChipAtIndex(3));
	 	    
	    try 
	    {
	 	    	int i = 0; 
	 	    	for(String chiplabel : chipsname)
	 	    	{
	 			assertEquals(chipslabels[i], chiplabel);
	 			i++;
	 	}
	 	}catch(Exception e)
	    {
	 		   System.out.println("Actual and Expected values are not same");
	    }
	 	 
		
		search.clickButton("ResetChipsValues");
		//Chips on second unsuccessful search
	    search.clickClearSearch();
		search.enterTextInSearchBox("jsdhgsjjhsfg");

        
		SortedSet<String> chipsname1 = new TreeSet<String>();
			    
		for(int i=0; i<7;i++) 
		{
			   chipsname1.add(search.getChipAtIndex(0));
			   chipsname1.add(search.getChipAtIndex(1));
			   chipsname1.add(search.getChipAtIndex(2));
			   search.swipeChipsTo();
			   Thread.sleep(2000);
		}
		chipsname1.add(search.getChipAtIndex(3));
			    
	    try {
			   int i = 0; 
			   for(String chiplabel : chipsname)
			   {
			    assertEquals(chipslabels[i], chiplabel);
				i++;
	           }
		}catch(Exception e)
		{
			   System.out.println("Actual and Expected values are not same");
		}
			 
		
		search.clickButton("ResetChipsValues");
		//Chips on First Folder successful search
	    //I will implement this one accessibility id available for the Advanced Search Dropdown
		
		search.clickCollapseSearch();
	}
	
	
	@Test(priority=2)
	public void verifyTheVisibilityOfSearchBoxInsideTheFacetTest() throws Exception {
		
		search = recentpage.clickOnSearchfromRecent();
		// Verify the visibility/ non-visibility of local search box for the search facet
		search.enterTextInSearchBox("Sample");
		
		//Scrolling
		for(int i=7; i<4;i++) {
			search.swipeChipsTo("Right");
			Thread.sleep(2000);
	       }
		
		try {
			assertEquals("Created Date (range)", search.getChipAtIndex(0));
			assertEquals("Type", search.getChipAtIndex(1));
			assertEquals("Type facet queries", search.getChipAtIndex(2));
			assertEquals("Size facet queries", search.getChipAtIndex(3));
	    }catch(Exception e)
        {
		   System.out.println("Actual and Expected values are not same");
        }
		
		//Scrolling
		for(int i=0; i<6;i++) {
			search.swipeChipsTo("Right");
			Thread.sleep(2000);
	       }
		try {
			assertEquals("Size", search.getChipAtIndex(0));
			assertEquals("Created", search.getChipAtIndex(1));
			assertEquals("Type", search.getChipAtIndex(2));
			assertEquals("Modifier", search.getChipAtIndex(3));
			assertEquals("Creator", search.getChipAtIndex(4));
			assertEquals("The Created", search.getChipAtIndex(5));
	    }catch(Exception e)
        {
		   System.out.println("Actual and Expected values are not same");
        }
		
		//Scrolling
		for(int i=0; i<3;i++) {
			search.swipeChipsTo("Right");
			Thread.sleep(2000);
	       }
		try {
			assertEquals("The Modified", search.getChipAtIndex(3));
	    }catch(Exception e)
        {
		   System.out.println("Actual and Expected values are not same");
        }
		
		search.clickButton("ResetChipsValues");
		//Chips on second unsuccessful search
	    search.clickClearSearch();
		search.enterTextInSearchBox("jsdhgsjjhsfg");
		
		try {
				assertEquals("Name", search.getChipAtIndex(0));
				assertEquals("Check List", search.getChipAtIndex(1));
				assertEquals("Content Size", search.getChipAtIndex(2));
				assertEquals("Content Size (range)", search.getChipAtIndex(3));
		}catch(Exception e)
		{
			System.out.println("Actual and Expected values are not same");
		}
		
		//Scrolling
		for(int i=0; i<4;i++) {
			search.swipeChipsTo("Right");
			Thread.sleep(2000);
	       }
		
		try {
			assertEquals("Created Date (range)", search.getChipAtIndex(0));
			assertEquals("Type", search.getChipAtIndex(1));
			assertEquals("Type facet queries", search.getChipAtIndex(2));
			assertEquals("Size facet queries", search.getChipAtIndex(3));
	    }catch(Exception e)
        {
		   System.out.println("Actual and Expected values are not same");
        }
		
		//Scrolling
		for(int i=0; i<6;i++) {
			search.swipeChipsTo("Right");
			Thread.sleep(2000);
	       }
		try {
			assertEquals("Size", search.getChipAtIndex(0));
			assertEquals("Created", search.getChipAtIndex(1));
			assertEquals("Type", search.getChipAtIndex(2));
			assertEquals("Modifier", search.getChipAtIndex(3));
			assertEquals("Creator", search.getChipAtIndex(4));
			assertEquals("The Created", search.getChipAtIndex(5));
	    }catch(Exception e)
        {
		   System.out.println("Actual and Expected values are not same");
        }
		
		//Scrolling
		for(int i=0; i<3;i++) {
			search.swipeChipsTo("Right");
			Thread.sleep(2000);
	       }
		try {
			assertEquals("The Modified", search.getChipAtIndex(3));
	    }catch(Exception e)
        {
		   System.out.println("Actual and Expected values are not same");
        }
		
		search.clickButton("ResetChipsValues");
		//Chips on First Folder successful search
	    //I will implement this one accessibility id available for the Advanced Search Dropdown
		
		search.clickCollapseSearch();
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
