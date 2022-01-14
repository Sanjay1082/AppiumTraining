package com.Test;

import java.net.MalformedURLException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.base.base;
import com.pages.AccountPage;
import com.pages.AllowRecordPermissionPage;
import com.pages.AllowWorkspacePermissionPage;
import com.pages.BrowserPage;
import com.pages.CameraPage;
import com.pages.FavoritesPage;
import com.pages.GalleryPage;
import com.pages.LoginPage;
import com.pages.MyLibrariesPage;
import com.pages.OfflinePage;
import com.pages.PersonalFilesPage;
import com.pages.RecentPage;
import com.pages.SearchPage;
import com.pages.SharedPage;
import com.pages.TrashPage;
import com.pages.WebLoginPage;

public class TestE extends base{

	LoginPage loginpage;
	WebDriver driver;
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
	AllowWorkspacePermissionPage allowpermission;
	AllowRecordPermissionPage allowrecordpermission;
	CameraPage camera;
	GalleryPage gallery;
	
	
	TestE()
	{
		
	}
	
    @BeforeClass
	public void Setup() throws MalformedURLException, InterruptedException
	{
    	startServer();	
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
  /*  
    @Test
    public void login() throws Exception
    {
    	browser = recentpage.clickBrowser();
    	Thread.sleep(5000);
    	personalfiles = browser.clickPersonalFiles();
    	Thread.sleep(5000);
    	personalfiles.clickAdd();
    	
    	gallery = personalfiles.clickUploadPhotosOrVedios();
    	
    	gallery.clickExpandSideOptions();
    	Thread.sleep(5000);
    	gallery.clickOpenFrom();
    	gallery.clickOpenFromImages();
    	
    }
    */
    
    @Test
    public void login1() throws Exception
    {
    	browser = recentpage.clickBrowser();
    	Thread.sleep(5000);
    	personalfiles = browser.clickPersonalFiles();
    	Thread.sleep(5000);
    	personalfiles.clickAdd();
    	
    	allowpermission = personalfiles.clickTakeaPhotosOrVedio();
    	allowrecordpermission = allowpermission.clickGrantPermission("Only this time","Pixel");
    	camera = allowrecordpermission.clickGrantRecordPermission("Only this time","Pixel");
    	personalfiles = camera.clickCloseCamera();
    	
    	Thread.sleep(5000);
    	
        personalfiles.clickAdd();
    	allowpermission = personalfiles.clickTakeaPhotosOrVedio();
    	
    	for(int i=0; i<7;i++)
    	{
    		camera.clickOnCameraModule("Shutter");
    		Thread.sleep(3000);
    	}
    	
    	String MediaCount = camera.getCameraModuleText("MediaCount");
    	System.out.println("MediaCount : "+MediaCount);
    	
    	camera.clickCloseCamera();
    	String DiscardCaptureTitle  = camera.getCameraModuleText("DiscardWarning");
    	String DiscardCaptureMessage = camera.getCameraModuleText("DiscardMessage");
    	String Cancel = camera.getCameraModuleText("Cancel");
    	String Discard = camera.getCameraModuleText("Discard");
    	
    	camera.clickOnCameraModule("Cancel");
    	camera.clickPreviewMedia();
    	
    	for(int i=0; i<(7/2);i++)
    	{
    	swipeCarouselCards("Right");
    	//swipeCarouselCards("Left");
    	}
    }
    
    @AfterClass
    public void teardown() {
    	System.out.println("Logout");
    }
}
