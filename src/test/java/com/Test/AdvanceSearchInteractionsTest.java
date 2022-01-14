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


public class AdvanceSearchInteractionsTest extends base{
	
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
	
	AdvanceSearchInteractionsTest()
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
	public void selectValueOnSliderTest() throws Exception {
		
		search = recentpage.clickOnSearchfromRecent();
		chipinitial = search.getChipValue("ContentSize");
		search.selectChip("ContentSize");
		Thread.sleep(7000);
		search.applyChipValue("ContentSize", "Apply", "9");
		chipfinal = search.getChipValue("ContentSize");
		
		try {
		assertEquals(chipinitial, "Content Size");
		assertEquals(chipfinal, "9");
		}
		catch(Exception e)
		{
			throw new Exception("Unable to locate Content Size chip");
		} 
		search.clickCollapseSearch();
	}
	
	@Test(priority=2)
	public void swipeChipsHorizontallyTest() throws Exception {

		search = recentpage.clickOnSearchfromRecent();
		
		chipinitial = search.getChipValue("Name");
		
		try {assertEquals(chipinitial, "Name");
			}catch(Exception e)
			{throw new Exception("Unable to locate Name chip");
			}
		
        chipinitial = search.getChipValue("CheckList");
		
		try {assertEquals(chipinitial, "Check List");
			}catch(Exception e)
			{throw new Exception("Unable to locate CheckList chip");
			}
		
	   chipinitial = search.getChipValue("ContentSize");
		
		try {assertEquals(chipinitial, "Content Size");
			}catch(Exception e)
			{throw new Exception("Unable to locate Content Size chip");
			}
		
        chipinitial = search.getChipValue("ContentSizeRange");                                   
		
		try {assertEquals(chipinitial, "Content Size (range)");
			}catch(Exception e)
			{throw new Exception("Unable to locate Content Size(range) chip");
			}

		for(int i=0; i<3;i++) {
			search.swipeChipsTo("Right");
			Thread.sleep(2000);
	       }
        chipinitial = search.getChipValue("CreatedDate");
		
		try {assertEquals(chipinitial, "Created Date (range)");
			}catch(Exception e)
			{throw new Exception("Unable to locate Created Date(range) chip");
			}
		
        chipinitial = search.getChipValue("Type");
		
		try {assertEquals(chipinitial, "Type");
			}catch(Exception e)
			{throw new Exception("Unable to locate Type chip");
			}
		search.clickCollapseSearch();
	}
	
	@Test(priority=3)
	public void createdDateRangeTest() throws Exception {

	   search = recentpage.clickOnSearchfromRecent();
		
       for(int i=0; i<=2;i++) {
		search.swipeChipsTo("Right");
		Thread.sleep(2000);
       }
	    
        chipinitial = search.getChipValue("CreatedDate");
        try 
		{assertEquals(chipinitial, "Created Date (range)");
		}catch(Exception e)
		{throw new Exception("Unable to locate CreatedDate chip");
		}
        
 		search.selectChip("CreatedDate");
		Thread.sleep(2000);
		search.applyChipValue("CreatedDate", "Apply", "-60");
		chipfinal = search.getChipValue("CreatedDate");
		search.selectChip("CreatedDate");
		
		fromdate = search.getValueFromDrawer("CreatedDate", "From");
		todate = search.getValueFromDrawer("CreatedDate", "To");
		dateconcat = fromdate+" - "+todate;
		search.clickButton("Cancel");
		
		try 
		{assertEquals(true, dateconcat.contains(chipfinal));
		}catch(Exception e)
		{throw new Exception("Unable to locate CreatedDate chip");
		}
		
		search.selectChip("CreatedDate");
		Thread.sleep(7000);
		search.applyChipValue("CreatedDate", "Apply", "-11");
        chipfinal = search.getChipValue("CreatedDate");
        search.selectChip("CreatedDate");
		
		fromdate = search.getValueFromDrawer("CreatedDate", "From");
		todate = search.getValueFromDrawer("CreatedDate", "To");
		dateconcat = fromdate+" - "+todate;
		search.clickButton("Cancel");
		
		try 
		{assertEquals(chipfinal, dateconcat);
		}catch(Exception e)
		{throw new Exception("Unable to locate CreatedDate chip");
		}
		
		search.selectChip("CreatedDate");
		Thread.sleep(7000);
		search.applyChipValue("CreatedDate", "Reset", "-11");
		
        chipinitial = search.getChipValue("CreatedDate");
        try 
		{assertEquals(chipinitial, "Created Date (range)");
		}catch(Exception e)
		{throw new Exception("Unable to locate CreatedDate chip");
		}
		
		search.selectChip("CreatedDate");
		Thread.sleep(7000);
		search.applyChipValue("CreatedDate", "Cancel", "-11");
		
        chipinitial = search.getChipValue("CreatedDate");
        try 
		{assertEquals(chipinitial, "Created Date (range)");
		}catch(Exception e)
		{throw new Exception("Unable to locate CreatedDate chip");
		}	
        
        search.clickCollapseSearch();
		Thread.sleep(2000);
		search = recentpage.clickOnSearchfromRecent();
		Thread.sleep(2000);
		
		for(int i=0; i<=3;i++) {
			search.swipeChipsTo("Right");
			Thread.sleep(2000);
	       }
		
		chipfinal = search.getChipValue("CreatedDate");
		try 
		{assertEquals(chipfinal, "Created Date (range)");
		}catch(Exception e)
		{throw new Exception("Unable to locate CreatedDate chip");
		}
		search.clickCollapseSearch();
}
	
	@Test(priority=4)
	public void radioListTest() throws Exception {

		search = recentpage.clickOnSearchfromRecent();
		
       for(int i=0; i<=3;i++) {
		search.swipeChipsTo("Right");
		Thread.sleep(2000);
       }
	    
        chipinitial = search.getChipValue("Type");
        try 
		{assertEquals(chipinitial, "Type");
		}catch(Exception e)
		{throw new Exception("Unable to locate Type chip");
		}
       
		search.selectChip("Type");
		Thread.sleep(7000);
		search.applyChipValue("Type", "Apply", "All");
		
		chipfinal = search.getChipValue("Type");
		try 
		{assertEquals(chipfinal, "All");
		}catch(Exception e)
		{throw new Exception("Unable to locate Type chip");
		}
		
		search = recentpage.clickOnSearchfromRecent();
		search.enterTextInSearchBox("Sample");
		Thread.sleep(3000);
		
		search.selectChipAtIndex(2);
		Thread.sleep(7000);
		search.applyChipValue("Type", "Apply", "Folder");
		
		chipfinal = search.getChipValue("Type");
		try 
		{assertEquals(chipfinal, "Folder");
		}catch(Exception e)
		{throw new Exception("Unable to locate Type chip");
		}
		
		search.selectChip("Type");
		Thread.sleep(7000);
		search.applyChipValue("Type", "Apply", "Document");
		
		chipfinal = search.getChipValue("Type");
		try 
		{assertEquals(chipfinal, "Document");
		}catch(Exception e)
		{throw new Exception("Unable to locate Type chip");
		}
		
		search.selectChip("Type");
		Thread.sleep(7000);
		search.applyChipValue("Type", "Apply", "None");
		
		chipfinal = search.getChipValue("Type");
		try 
		{assertEquals(chipfinal, "None");
		}catch(Exception e)
		{throw new Exception("Unable to locate Type chip");
		}
		
		search.selectChip("Type");
		Thread.sleep(7000);
		search.applyChipValue("Type", "Reset", "All");
		
		chipfinal = search.getChipValue("Type");
		try 
		{assertEquals(chipfinal, "Type");
		}catch(Exception e)
		{throw new Exception("Unable to locate Type chip");
		}
		
		search.selectChip("Type");
		Thread.sleep(7000);
		search.applyChipValue("Type", "Reset", "Folder");
		
		chipfinal = search.getChipValue("Type");
		try 
		{assertEquals(chipfinal, "Type");
		}catch(Exception e)
		{throw new Exception("Unable to locate Type chip");
		}
		
		search.selectChip("Type");
		Thread.sleep(7000);
		search.applyChipValue("Type", "Reset", "Document");
		
		chipfinal = search.getChipValue("Type");
		try 
		{assertEquals(chipfinal, "Type");
		}catch(Exception e)
		{throw new Exception("Unable to locate Type chip");
		}
		
		search.selectChip("Type");
		Thread.sleep(7000);
		search.applyChipValue("Type", "Reset", "None");
		
		chipfinal = search.getChipValue("Type");
		try 
		{assertEquals(chipfinal, "Type");
		}catch(Exception e)
		{throw new Exception("Unable to locate Type chip");
		}
		
		search.selectChip("Type");
		Thread.sleep(7000);
		search.applyChipValue("Type", "Cancel", "All");
		
		chipfinal = search.getChipValue("Type");
		try 
		{assertEquals(chipfinal, "Type");
		}catch(Exception e)
		{throw new Exception("Unable to locate Type chip");
		}
		
		search.selectChip("Type");
		Thread.sleep(7000);
		search.applyChipValue("Type", "Cancel", "Folder");
		
		chipfinal = search.getChipValue("Type");
		try 
		{assertEquals(chipfinal, "Type");
		}catch(Exception e)
		{throw new Exception("Unable to locate Type chip");
		}
		
		search.selectChip("Type");
		Thread.sleep(7000);
		search.applyChipValue("Type", "Cancel", "Document");
		
		chipfinal = search.getChipValue("Type");
		try 
		{assertEquals(chipfinal, "Type");
		}catch(Exception e)
		{throw new Exception("Unable to locate Type chip");
		}
		
		search.selectChip("Type");
		Thread.sleep(7000);
		search.applyChipValue("Type", "Cancel", "None");
		
		chipfinal = search.getChipValue("Type");
		try 
		{assertEquals(chipfinal, "Type");
		}catch(Exception e)
		{throw new Exception("Unable to locate Type chip");
		}
		
		search.clickCollapseSearch();
		Thread.sleep(2000);
		search = recentpage.clickOnSearchfromRecent();
		Thread.sleep(2000);
		
		for(int i=0; i<=3;i++) {
			search.swipeChipsTo("Right");
			Thread.sleep(2000);
	       }
		
		chipfinal = search.getChipValue("Type");
		try 
		{assertEquals(chipfinal, "Type");
		}catch(Exception e)
		{throw new Exception("Unable to locate Type chip");
		}
		search.clickCollapseSearch();
}

	@Test(priority=5)
    public void numberRangeTest() throws Exception {
		
		search = recentpage.clickOnSearchfromRecent();
	    
		chipinitial = search.getChipValue("ContentSizeRange");
        try 
		{assertEquals(chipinitial, "Content Size (range)");
		}catch(Exception e)
		{throw new Exception("Unable to locate Content Size (range) chip");
		}
		
		search.selectChip("ContentSizeRange");
		Thread.sleep(7000);
		search.applyChipValue("ContentSizeRange", "Apply", "180");
		
		chipfinal = search.getChipValue("ContentSizeRange");
		try 
		{assertEquals(chipfinal, "0 - 180");
		}catch(Exception e)
		{throw new Exception("Unable to locate Content Size (range) chip");
		}
		
		search = recentpage.clickOnSearchfromRecent();
		search.enterTextInSearchBox("Sample");
		Thread.sleep(3000);
		
		search.selectChip("ContentSizeRange");
		Thread.sleep(7000);
		search.applyChipValue("ContentSizeRange", "Apply", "100000000");
		
		chipfinal = search.getChipValue("ContentSizeRange");
		try 
		{assertEquals(chipfinal, "0 - 100000000");
		}catch(Exception e)
		{throw new Exception("Unable to locate Content Size (range) chip");
		}
		
		search.selectChip("ContentSizeRange");
		Thread.sleep(7000);
		search.applyChipValue("ContentSizeRange", "Reset", "300");
		
		chipfinal = search.getChipValue("ContentSizeRange");
		try 
		{assertEquals(chipfinal, "Content Size (range)");
		}catch(Exception e)
		{throw new Exception("Unable to locate Content Size (range) chip");
		}
		
		search.selectChip("ContentSizeRange");
		Thread.sleep(7000);
		search.applyChipValue("ContentSizeRange", "Cancel", "400");
		
		chipfinal = search.getChipValue("ContentSizeRange");
		try 
		{assertEquals(chipfinal, "Content Size (range)");
		}catch(Exception e)
		{throw new Exception("Unable to locate Content Size (range) chip");
		}
		
		search.selectChip("ContentSizeRange");
		Thread.sleep(7000);
		search.applyChipValue("ContentSizeRange", "Apply", "9");
		
		chipfinal = search.getChipValue("ContentSizeRange");
		try 
		{assertEquals(chipfinal, "0 - 9");
		}catch(Exception e)
		{throw new Exception("Unable to locate Content Size (range) chip");
		}
		
		search.clickCollapseSearch();
		Thread.sleep(2000);
		search = recentpage.clickOnSearchfromRecent();
		Thread.sleep(2000);
		
		chipfinal = search.getChipValue("ContentSizeRange");
		try 
		{assertEquals(chipfinal, "Content Size (range)");
		}catch(Exception e)
		{throw new Exception("Unable to locate Content Size (range) chip");
		}
		search.clickCollapseSearch();
}
	
	@Test(priority=7)
    public void checkListTest() throws Exception {

		search = recentpage.clickOnSearchfromRecent();
	    
		chipinitial = search.getChipValue("CheckList");
        try 
		{assertEquals(chipinitial, "Check List");
		}catch(Exception e)
		{throw new Exception("Unable to locate Check List chip");
		}
		
		search.selectChip("CheckList");
		Thread.sleep(7000);
		search.applyChipValue("CheckList", "Apply", "Folder");
		
		chipfinal = search.getChipValue("CheckList");
        try 
		{assertEquals(chipfinal, "Folder");
		}catch(Exception e)
		{throw new Exception("Unable to locate Check List chip");
		}
        
        search = recentpage.clickOnSearchfromRecent();
		search.enterTextInSearchBox("Sample");
		Thread.sleep(3000);
		
		search.selectChip("CheckList");
		Thread.sleep(7000);
		search.applyChipValue("CheckList", "Cancel", "Document");
		
		chipfinal = search.getChipValue("CheckList");
        try 
		{assertEquals(chipfinal, "Folder");
		}catch(Exception e)
		{throw new Exception("Unable to locate Check List chip");
		}
		
		search.selectChip("CheckList");
		Thread.sleep(7000);
		search.applyChipValue("CheckList", "Reset", "Document");
		
		chipfinal = search.getChipValue("CheckList");
        try 
		{assertEquals(chipfinal, "Check List");
		}catch(Exception e)
		{throw new Exception("Unable to locate Check List chip");
		}
		
		search.selectChip("CheckList");
		Thread.sleep(7000);
		search.applyChipValue("CheckList", "Apply", "Document");
		
		chipfinal = search.getChipValue("CheckList");
        try 
		{assertEquals(chipfinal, "Document");
		}catch(Exception e)
		{throw new Exception("Unable to locate Check List chip");
		}
		
		search.selectChip("CheckList");
		Thread.sleep(7000);
		search.applyChipValue("CheckList", "Cancel", "Folder");
		
		chipfinal = search.getChipValue("CheckList");
        try 
		{assertEquals(chipfinal, "Document");
		}catch(Exception e)
		{throw new Exception("Unable to locate Check List chip");
		}
		
		search.selectChip("CheckList");
		Thread.sleep(7000);
		search.applyChipValue("CheckList", "Reset", "Folder");
		
		chipfinal = search.getChipValue("CheckList");
        try 
		{assertEquals(chipfinal, "Check List");
		}catch(Exception e)
		{throw new Exception("Unable to locate Check List chip");
		}
		
		search.selectChip("CheckList");
		Thread.sleep(7000);
		search.applyChipValue("CheckList", "Apply", "Both");
		
		chipfinal = search.getChipValue("CheckList");
        try 
		{assertEquals(chipfinal, "Folder,Document");
		}catch(Exception e)
		{throw new Exception("Unable to locate Check List chip");
		}
		
		search.selectChip("CheckList");
		Thread.sleep(7000);
		search.applyChipValue("CheckList", "Cancel", "Document");
		
		chipfinal = search.getChipValue("CheckList");
        try 
		{assertEquals(chipfinal, "Folder,Document");
		}catch(Exception e)
		{throw new Exception("Unable to locate Check List chip");
		}
		
		search.selectChip("CheckList");
		Thread.sleep(7000);
		search.applyChipValue("CheckList", "Reset", "Folder");	
		
		chipfinal = search.getChipValue("CheckList");
        try 
		{assertEquals(chipfinal, "Check List");
		}catch(Exception e)
		{throw new Exception("Unable to locate Check List chip");
		}
        
        search.clickCollapseSearch();
		Thread.sleep(2000);
		search = recentpage.clickOnSearchfromRecent();
		Thread.sleep(2000);
		
		chipfinal = search.getChipValue("CheckList");
		try 
		{assertEquals(chipfinal, "Check List");
		}catch(Exception e)
		{throw new Exception("Unable to locate Check List chip");
		}
		search.clickCollapseSearch();
}

	@Test(priority=8)
	public void nameChipSelectionTest() throws Exception {

		search = recentpage.clickOnSearchfromRecent();
	    
		chipinitial = search.getChipValue("Name");
        try 
		{assertEquals(chipinitial, "Name");
		}catch(Exception e)
		{throw new Exception("Unable to locate Name chip");
		}
		
		search.selectChip("Name");
		Thread.sleep(2000);
		search.applyChipValue("Name", "Apply", "IMG");
		
		chipfinal = search.getChipValue("Name");
        try 
		{assertEquals(chipfinal, "IMG");
		}catch(Exception e)
		{throw new Exception("Unable to locate Name chip");
		}
        
        search = recentpage.clickOnSearchfromRecent();
		search.enterTextInSearchBox("Sample");
		Thread.sleep(3000);
		
		search.selectChip("Name");
		Thread.sleep(2000);
		search.applyChipValue("Name", "Apply", "IMGhajdgajhgdajshkjsdfjkd");
		
		chipfinal = search.getChipValue("Name");
        try 
		{assertEquals(chipfinal, "IMGhajdgajhgdajshkjs...");
		}catch(Exception e)
		{throw new Exception("Unable to locate Name chip");
		}
		
		search.selectChip("Name");
		Thread.sleep(2000);
		search.applyChipValue("Name", "Cancel", "IMGhads32442jdgajhgdajshkjsdfjksjdkfhsd93284923d");
		
		chipfinal = search.getChipValue("Name");
        try 
		{assertEquals(chipfinal, "IMGhajdgajhgdajshkjs...");
		}catch(Exception e)
		{throw new Exception("Unable to locate Name chip");
		}
		
		search.selectChip("Name");
		Thread.sleep(2000);
		search.applyChipValue("Name", "Reset", "IMGhajdgajhgdaj835384756873560shkjsdfjkd");
		
		chipfinal = search.getChipValue("Name");
        try 
		{assertEquals(chipfinal, "Name");
		}catch(Exception e)
		{throw new Exception("Unable to locate Name chip");
		}
        
        search.clickCollapseSearch();
		Thread.sleep(2000);
		search = recentpage.clickOnSearchfromRecent();
		Thread.sleep(2000);
		
		chipfinal = search.getChipValue("Name");
		try 
		{assertEquals(chipfinal, "Name");
		}catch(Exception e)
		{throw new Exception("Unable to locate Name chip");
		}
		search.clickCollapseSearch();
}
	
	@Test(priority=9)
	public void nameChipFilterWithGlobalSearchTest() throws Exception {

		search = recentpage.clickOnSearchfromRecent();
		 
		search.selectChip("Name");
		Thread.sleep(2000);
		search.applyChipValue("Name", "Apply", "Sample");
		
		chipfinal = search.getChipValue("Name");
        try 
		{assertEquals(chipfinal, "Sample");
		}catch(Exception e)
		{throw new Exception("Unable to locate Name chip");
		}
		
        search.enterTextInSearchBox("Sample");
        Thread.sleep(7000);
		
		for(int i=0; i<search.getRecordCount(); i++) 
		{ 
		try 
		{assertEquals(true, search.getSearchRecordInformation("Name",i%8).startsWith("Sample"));
		}catch(Exception e)
		{throw new Exception("Actual and expected value are not same");}
		}
		
		search.clickCollapseSearch();
		
		}
		
	@Test(priority=10)
	public void nameAndCheckListFilterWithGlobalSearchTest() throws Exception {

		search = recentpage.clickOnSearchfromRecent();
		search.enterTextInSearchBox("Sample");
			 
		search.selectChip("Name");
		Thread.sleep(2000);
		search.applyChipValue("Name", "Apply", "Sample");
			
		chipfinal = search.getChipValue("Name");
	    try 
		{assertEquals(chipfinal, "Sample");
		for(int i=0;i<search.getRecordCount();i++) 
		{assertEquals(true, search.getSearchRecordInformation("Name",i).startsWith("Sample"));
		}}catch(Exception e)
		{throw new Exception("Actual and expected value are not same");
		}
	    
	    search.selectChip("CheckList");
		Thread.sleep(2000);
		search.applyChipValue("CheckList", "Apply", "Document");
		
		chipfinal = search.getChipValue("CheckList");
	    try 
		{assertEquals(chipfinal, "Document");
		for(int i=0;i<search.getRecordCount();i++) 
		{assertEquals(true, search.getSearchRecordInformation("Name",i).startsWith("Sample"));
		}}catch(Exception e)
		{throw new Exception("Actual and expected value are not same");
		}
		
	    search.selectChip("CheckList");
		Thread.sleep(2000);
		search.applyChipValue("CheckList", "Apply", "Folder");
		
		chipfinal = search.getChipValue("CheckList");
		try 
		{assertEquals(chipfinal, "Document,Folder");
		for(int i=0;i<search.getRecordCount();i++) 
		{assertEquals(true, search.getSearchRecordInformation("Name",i).isEmpty());
		}}catch(Exception e)
		{throw new Exception("Actual and expected value are not same");
		}
		
		int numberofcountwhenchipselected = search.getRecordCount();
		
		search.selectChip("CheckList");
		Thread.sleep(2000);
		search.applyChipValue("CheckList", "Apply", "Document");
		
		chipfinal = search.getChipValue("CheckList");
	    try 
		{assertEquals(chipfinal, "Document");
		for(int i=0;i<search.getRecordCount();i++) 
		{assertEquals(true, search.getSearchRecordInformation("Name",i).startsWith("Sample"));
		}}catch(Exception e)
		{throw new Exception("Actual and expected value are not same");
		}
	    
	    search.clickButton("Reset");
	    Thread.sleep(7000);
	    chipfinal = search.getChipValue("Name");
	    String chipfinal1 = search.getChipValue("CheckList");
	    
	    int numberofcountwhenchipisnotselected = search.getRecordCount();
	    
	    try 
		{assertEquals(chipfinal, "Name");
		 assertEquals(chipfinal1, "Check List");
		 assertEquals(numberofcountwhenchipisnotselected>numberofcountwhenchipselected, true);
		}catch(Exception e)
		{throw new Exception("Actual and expected value are not same");
		}
	    
	    search.clickCollapseSearch();
		Thread.sleep(2000);
		search = recentpage.clickOnSearchfromRecent();
		Thread.sleep(2000);
		
		chipfinal = search.getChipValue("CheckList");
		chipfinal1 = search.getChipValue("Name");
		try 
		{assertEquals(chipfinal, "Check List");
		assertEquals(chipfinal1, "Name");
		}catch(Exception e)
		{throw new Exception("Unable to locate Check List and Name chip");
		}
		search.clickCollapseSearch();
	   
		}
	
	@Test(priority=11)
	public void contentSizeRangeandTypeFilterWithGlobalSearchTest() throws Exception {

		search = recentpage.clickOnSearchfromRecent();
		search.enterTextInSearchBox("Automation");
		search.selectChip("Name");
		Thread.sleep(2000);
		search.applyChipValue("Name", "Apply", "Automation");
		
		
		search.selectChip("ContentSizeRange");
		Thread.sleep(2000);
		search.applyChipValue("ContentSizeRange", "Apply", "10000000");
		chipfinal = search.getChipValue("ContentSizeRange");
		
	    try 
		{assertEquals(chipfinal, "0 - 10000000");
		for(int i=0;i<search.getRecordCount();i++) 
		{assertEquals(true, search.getSearchRecordInformation("Name",i).startsWith("Automation"));
		}}catch(Exception e)
		{throw new Exception("Actual and expected value are not same");
		}
	    
	    search.selectChip("ContentSizeRange");
		Thread.sleep(2000);
		search.applyChipValue("ContentSizeRange", "Apply", "100000000");
		chipfinal = search.getChipValue("ContentSizeRange");
		
	    try 
		{assertEquals(chipfinal, "0 - 100000000");
		for(int i=0;i<search.getRecordCount();i++) 
		{assertEquals(true, search.getSearchRecordInformation("Name",i).startsWith("Auto"));
		}}catch(Exception e)
		{throw new Exception("Actual and expected value are not same");
		}
		
	    int numberofcountwhenchipselected = search.getRecordCount();
	    search.clickButton("Reset");
	    Thread.sleep(7000);
	    chipfinal = search.getChipValue("ContentSizeRange");
	    int numberofcountwhenchipisnotselected = search.getRecordCount();
	    
	    try 
		{assertEquals(chipfinal, "Content Size (range)");
		 assertEquals(numberofcountwhenchipisnotselected > numberofcountwhenchipselected, true);
		}catch(Exception e)
		{throw new Exception("Actual and expected value are not same");
		}
	    
	    search.selectChip("Name");
		Thread.sleep(2000);
		search.applyChipValue("Name", "Apply", "Automation");
		
	    for(int i=0;i<=3;i++)
		{
		search.swipeChipsTo("Right");
        }
		
	    search.selectChip("Type");
		Thread.sleep(2000);
		search.applyChipValue("Type", "Apply", "All");
		chipfinal = search.getChipValue("Type");
		
		try 
		{assertEquals(chipfinal, "All");
		for(int i=0;i<search.getRecordCount();i++) 
		{assertEquals(true, search.getSearchRecordInformation("Name",i).startsWith("Automation"));
		}}catch(Exception e)
		{throw new Exception("Actual and expected value are not same");
		}
		
		search.selectChip("Type");
		Thread.sleep(2000);
		search.applyChipValue("Type", "Apply", "Document");
		chipfinal = search.getChipValue("Type");
		
	    try 
		{assertEquals(chipfinal, "Document");
		for(int i=0;i<search.getRecordCount();i++) 
		{assertEquals(true, search.getSearchRecordInformation("Name",i).startsWith("Auto"));
		}}catch(Exception e)
		{throw new Exception("Actual and expected value are not same");
		}
	    
	    numberofcountwhenchipselected = search.getRecordCount();
	    
	    search.clickButton("Reset");
	    Thread.sleep(7000);
	    for(int i=0;i<=2;i++)
		{
		search.swipeChipsTo("Right");
        }
	    String chipfinal = search.getChipValue("Type");
	    numberofcountwhenchipisnotselected = search.getRecordCount();
	    
	    try 
		{assertEquals(chipfinal, "Type");
		 assertEquals(numberofcountwhenchipisnotselected>numberofcountwhenchipselected, true);
		}catch(Exception e)
		{throw new Exception("Actual and expected value are not same");
		}
	    search.clickCollapseSearch();    
		}


	@Test(priority=12, enabled=false)
	public void createdDateRangeFilterWithGlobalSearchTest() throws Exception {

		search = recentpage.clickOnSearchfromRecent();
		search.enterTextInSearchBox("Automation");
		search.selectChip("ContentSizeRange");
		Thread.sleep(2000);
		search.applyChipValue("ContentSizeRange", "Apply", "10000000");
			
		chipfinal = search.getChipValue("ContentSizeRange");
	    try 
		{assertEquals(chipfinal, "0 - 10000000");
		for(int i=0;i<2;i++) 
		{assertEquals(true, search.getSearchRecordInformation("Name",i).startsWith("Automation"));
		}}catch(Exception e)
		{throw new Exception("Actual and expected value are not same");
		}
	    
	    search.selectChip("ContentSizeRange");
		Thread.sleep(2000);
		search.applyChipValue("ContentSizeRange", "Apply", "100000000");
		
		chipfinal = search.getChipValue("ContentSizeRange");
	    try 
		{assertEquals(chipfinal, "0 - 100000000");
		/*for(int i=0;i<3;i++) 
		{assertEquals(true, search.getSearchRecordInformation("Name",i).startsWith("Automation"));
		}*/}catch(Exception e)
		{throw new Exception("Actual and expected value are not same");
		}
		
	    for(int i=0;i<=3;i++)
		{
		search.swipeChipsTo("Right");
        }
	    
	    search.selectChip("Type");
		Thread.sleep(2000);
		search.applyChipValue("Type", "Apply", "All");
		
		chipfinal = search.getChipValue("Type");
		try 
		{assertEquals(chipfinal, "All");
		for(int i=0;i<3;i++) 
		{assertEquals(true, search.getSearchRecordInformation("Name",i).startsWith("Automation"));
		}}catch(Exception e)
		{throw new Exception("Actual and expected value are not same");
		}
		
		int numberofcountwhenchipselected = search.getRecordCount();
		
		search.selectChip("Type");
		Thread.sleep(2000);
		search.applyChipValue("Type", "Apply", "Document");
		
		chipfinal = search.getChipValue("Type");
	    try 
		{assertEquals(chipfinal, "Document");
		for(int i=0;i<3;i++) 
		{assertEquals(true, search.getSearchRecordInformation("Name",i).startsWith("Automation"));
		}}catch(Exception e)
		{throw new Exception("Actual and expected value are not same");
		}
	    
	    search.clickButton("Reset");
	    Thread.sleep(7000);
	    chipfinal = search.getChipValue("ContentSizeRange");
	    String chipfinal1 = search.getChipValue("Type");
	    
	    int numberofcountwhenchipisnotselected = search.getRecordCount();
	    
	    try 
		{assertEquals(chipfinal, "Content Size (range)");
		 assertEquals(chipfinal1, "Type");
		 assertEquals(numberofcountwhenchipisnotselected>numberofcountwhenchipselected, true);
		}catch(Exception e)
		{throw new Exception("Actual and expected value are not same");
		}
	    search.clickCollapseSearch();
	   
		}

	
	@Test(priority=13)
	public void chipsWithContextualSearchTest() throws Exception {

		search = recentpage.clickOnSearchfromRecent();
		search.enterTextInSearchBox("Automation");	
		
	    search.selectRecordFromSearch(0);
	    
	    search = recentpage.clickOnContextualSearchfromRecent();
		search.enterTextInSearchBox("Auto");
		search.selectChipAtIndex(1);
		search.populateDataOnNameChipDrawer("Auto");
		
		boolean contextual = search.getChipTextAtIndex(0).contains("Auto");
		int searchresultswhencontextualchipisselected = search.getRecordCount();
		String textonnamechip = search.getChipTextAtIndex(1);
		
		try 
		{assertEquals(contextual, true);
		 assertEquals(textonnamechip, "Auto");
		}catch(Exception e)
		{throw new Exception("Actual and expected value are not same");
		}
		
		search.sendAppInBackgroundOrForeground("Background");
		search.sendAppInBackgroundOrForeground("ForeGround");
		
		try 
		{assertEquals(contextual, true);
		 assertEquals(textonnamechip, "Auto");
		}catch(Exception e)
		{throw new Exception("Actual and expected value are not same");
		}
		
		search.selectChipAtIndex(0);
		Thread.sleep(10000);
		int searchresultswhencontextualchipisnotselected = search.getRecordCount();
		
		try 
		{assertEquals(searchresultswhencontextualchipisnotselected>searchresultswhencontextualchipisselected, true);
		}catch(Exception e)
		{throw new Exception("Actual and expected value are not same");
		}
		
		
		
		
		search.clickCollapseSearch();
		recentpage.clickBrowser();
		
	
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
