package com.Test;

import java.net.MalformedURLException;
import static org.testng.Assert.assertEquals;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
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
import com.pages.PreviewMediaPage;
import com.pages.PreviewPhotoAndVedioPage;
import com.pages.RecentPage;
import com.pages.SearchPage;
import com.pages.SharedPage;
import com.pages.TrashPage;
import com.pages.WebLoginPage;

public class CaptureMultipleMediaTest extends base{
	
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
	PreviewPhotoAndVedioPage previewphotoandvideo;
	PreviewMediaPage previewmedia;
	
	
	CaptureMultipleMediaTest()
	{
		
	}
	
	 @BeforeMethod
		public void Setup() throws MalformedURLException, InterruptedException
		{
		    //startServer();
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
			
			browser = recentpage.clickBrowser();
	    	Thread.sleep(5000);
	    	personalfiles = browser.clickPersonalFiles();
	    	Thread.sleep(5000);	
		}
	 
	 @Test(priority=1)
	    public void allowPerimissionToAccessCameraTest() throws Exception
	    {
		    try {
	    	personalfiles.clickAdd();
	    	
	    	assertEquals(true, false);
	    	
	    	allowpermission = personalfiles.clickTakeaPhotosOrVedio();
	    	allowrecordpermission = allowpermission.clickGrantPermission("Only this time","Pixel");
	    	camera = allowrecordpermission.clickGrantRecordPermission("Only this time","Pixel");
	    	personalfiles = camera.clickCloseCamera();
	    	Thread.sleep(5000);
	    	personalfiles.clickBack();
		    }catch(Exception e)
		    {
		    	System.out.println("Some unaccepted sitution occured while the execution");
		    }
	    	
	    }
	 
	 
	 @Test(priority=2)
	    public void thumbnailMediaCountAndDiscradWarningTest() throws Exception
	    {
	    	personalfiles.clickAdd();
	    	
	    	allowpermission = personalfiles.clickTakeaPhotosOrVedio();
	    	allowrecordpermission = allowpermission.clickGrantPermission("Only this time","Pixel");
	    	camera = allowrecordpermission.clickGrantRecordPermission("Only this time","Pixel");
	    	personalfiles = camera.clickCloseCamera();
	    	Thread.sleep(2000);
	    	
            personalfiles.clickAdd();
            Thread.sleep(5000);
	    	allowpermission = personalfiles.clickTakeaPhotosOrVedio();
	    	
	    	for(int i=0; i<3;i++)
	    	{
	    		camera.clickOnCameraModule("Shutter");
	    		Thread.sleep(5000);
	    	}
	    	
	    	boolean thumbnail = camera.isThumbnailPresent();
	        String count = camera.getCameraModuleText("MediaCount");
	    	
	        try {
		        assertEquals(thumbnail, true);
		        assertEquals(count, "3");
		        }catch(Exception e)
		        {
		        	System.out.println("Actual and Expected outcome are not same");
		        }
	        
	    	camera.clickCloseCamera();
	    	camera.clickOnCameraModule("Cancel");
	    	camera.clickCloseCamera();
	    	camera.clickOnCameraModule("Discard");
	    	Thread.sleep(5000);
	    	personalfiles.clickBack();
	    	
	    }
	 
	 @Test(priority=3)
	    public void previewMediaTest() throws Exception
	    {
	    	personalfiles.clickAdd();
	    	Thread.sleep(2000);
	    	allowpermission = personalfiles.clickTakeaPhotosOrVedio();
	    	allowrecordpermission = allowpermission.clickGrantPermission("Only this time","Pixel");
	    	camera = allowrecordpermission.clickGrantRecordPermission("Only this time","Pixel");
	    	camera.clickOnCameraModule("Shutter");
	    	Thread.sleep(3000);
	    	
	    	previewphotoandvideo =camera.clickPreviewMedia();
	    	String filename = previewphotoandvideo.getPreviewText("FileName");
	    	previewphotoandvideo.clickBackOnPreview();
	    	
	    	camera.clickOnCameraModule("Video");
	    	camera.clickRecoding("Start");
	    	camera.clickRecoding("Stop");
	    	
	    	previewphotoandvideo = camera.clickPreviewMedia();
	    	
	    	previewmedia = previewphotoandvideo.clickOnMediaFile();
	    	previewmedia.clickClosePreviewOfMedia();
	    	previewphotoandvideo.clickOnPreview("Delete");
	    	previewmedia = previewphotoandvideo.clickOnMediaFile();
	    	previewmedia.clickClosePreviewOfMedia();
	    	previewphotoandvideo.clickBackOnPreview();
	    	Thread.sleep(2000);
	    	
	    	camera.clickCloseCamera();
	    	
	    	camera.clickOnCameraModule("Cancel");
	    	camera.clickCloseCamera();
	    	camera.clickOnCameraModule("Discard");
	    	//Thread.sleep(5000);
	    	personalfiles.clickBack();
	    	
	    	
	    }
	 
	 @Test(priority=4)
	    public void cameraSettingsTest() throws Exception
	    {
	    	personalfiles.clickAdd();
	    	
	    	allowpermission = personalfiles.clickTakeaPhotosOrVedio();
	    	allowrecordpermission = allowpermission.clickGrantPermission("Only this time","Pixel");
	    	camera = allowrecordpermission.clickGrantRecordPermission("Only this time","Pixel");

	    	camera.clickOnCameraModule("Shutter");
	    	Thread.sleep(3000);
	    	camera.clickOnCameraModule("SwitchCamera");
	    	camera.clickOnCameraModule("Shutter");
	    	Thread.sleep(3000);
	    	camera.clickOnCameraModule("Video");
	    	camera.clickRecoding("Start");
	    	camera.clickRecoding("Stop");
	    	Thread.sleep(3000);
	    	camera.clickOnCameraModule("SwitchCamera");
	    	camera.clickRecoding("Start");
	    	camera.clickRecoding("Stop");
	    	
	    	previewphotoandvideo =camera.clickPreviewMedia();
	    	Thread.sleep(3000);
	    	
	    	previewphotoandvideo.clickBackOnPreview();
	    	Thread.sleep(2000);

	    	camera.clickCloseCamera();
	    	camera.clickOnCameraModule("Discard");
	    	Thread.sleep(5000);
	    	personalfiles.clickBack();
	    	
	    	
	    }
	 
	 @Test(priority=5)
	    public void captureMorethan50MediaFilesTest() throws Exception
	    {
	    	personalfiles.clickAdd();
	    	
	    	allowpermission = personalfiles.clickTakeaPhotosOrVedio();
	    	allowrecordpermission = allowpermission.clickGrantPermission("Only this time","Pixel");
	    	camera = allowrecordpermission.clickGrantRecordPermission("Only this time","Pixel");
	    	
	    	for(int i=0; i<20;i++)
	    	{
	    		camera.clickOnCameraModule("Shutter");
	    		Thread.sleep(3000);
	    	}
	    	
	    	camera.clickOnCameraModule("SwitchCamera");
	    	for(int i=0; i<20;i++)
	    	{
	    		camera.clickOnCameraModule("Shutter");
	    		Thread.sleep(3000);
	    	}
	    	
	    	camera.clickOnCameraModule("Video");
	    	for(int i=0; i<20;i++)
	    	{
	    		camera.clickRecoding("Start");
	    		Thread.sleep(1000);
		    	camera.clickRecoding("Stop");
	    		Thread.sleep(3000);
	    	}
	    	
	    	camera.clickOnCameraModule("SwitchCamera");
	    	for(int i=0; i<20;i++)
	    	{
	    		camera.clickRecoding("Start");
	    		Thread.sleep(1000);
		    	camera.clickRecoding("Stop");
	    		Thread.sleep(3000);
	    	}
	    	
	    	previewphotoandvideo =camera.clickPreviewMedia();
	    	Thread.sleep(3000);
	    	
	    	previewphotoandvideo.clickBackOnPreview();
	    	Thread.sleep(2000);

	    	camera.clickCloseCamera();
	    	camera.clickOnCameraModule("Discard");
	    	Thread.sleep(5000);
	    	personalfiles.clickBack();
	    	
	    }
	 
	 @Test(priority=6)
	    public void sendAppInBackGroundDuringCaptureMediaTest() throws Exception
	    {
	    	personalfiles.clickAdd();
	    	
	    	allowpermission = personalfiles.clickTakeaPhotosOrVedio();
	    	allowrecordpermission = allowpermission.clickGrantPermission("Only this time","Pixel");
	    	camera = allowrecordpermission.clickGrantRecordPermission("Only this time","Pixel");
	    	
	    	camera.clickOnCameraModule("Shutter");
	    	Thread.sleep(3000);	
	    	camera.clickOnCameraModule("Video");
	    	Thread.sleep(2000);	
	    	camera.clickRecoding("Start");
	    	Thread.sleep(2000);	
	    	camera.clickOnCameraModule("Background");
	    	camera.clickOnCameraModule("Launch");
	    	
	    	String mediacount = camera.getCameraModuleText("MediaCount");
	    	try {
	    	assertEquals(mediacount, "2");
	    	}catch(Exception e) {
	    		System.out.println("Actual and expected values are not same");
	    	}
	    	
	    	previewphotoandvideo =camera.clickPreviewMedia();
	    	Thread.sleep(3000);
	    	
	    	previewphotoandvideo.clickBackOnPreview();
	    	Thread.sleep(2000);

	    	camera.clickCloseCamera();
	    	camera.clickOnCameraModule("Discard");
	    	Thread.sleep(5000);
	    	personalfiles.clickBack();
	    		
	    }
	 
	 @Test(priority=7)
	    public void mediaCountAndRemoveMediaTest() throws Exception
	    {
		    personalfiles.clickAdd();
	    	
	    	allowpermission = personalfiles.clickTakeaPhotosOrVedio();
	    	allowrecordpermission = allowpermission.clickGrantPermission("Only this time","Pixel");
	    	camera = allowrecordpermission.clickGrantRecordPermission("Only this time","Pixel");

	    	camera.clickOnCameraModule("Shutter");
	    	Thread.sleep(2000);
	    	camera.clickOnCameraModule("Zoom");
	    	camera.clickOnCameraModule("Shutter");
	    	Thread.sleep(2000);
	    	camera.clickOnCameraModule("SwitchCamera");
	    	camera.clickOnCameraModule("Shutter");
	    	Thread.sleep(2000);
	    	camera.clickOnCameraModule("Video");
	    	Thread.sleep(2000);
	    	camera.clickRecoding("Start");
	    	camera.clickRecoding("Stop");
	    	Thread.sleep(2000);
	    	camera.clickOnCameraModule("SwitchCamera");
	    	Thread.sleep(2000);
	    	camera.clickRecoding("Start");
	    	camera.clickRecoding("Stop");
	    	Thread.sleep(2000);
	    	
	    	String mediacount = camera.getCameraModuleText("MediaCount");
	    	try {
	    	assertEquals(mediacount, "5");
	    	}catch(Exception e) {
	    		System.out.println("Actual and expected values are not same");
	    	}
	    	
	    	previewphotoandvideo =camera.clickPreviewMedia();
	    	Thread.sleep(3000);
	    	previewphotoandvideo.clickOnPreview("Delete");
	    	previewphotoandvideo.clickBackOnPreview();
	    	Thread.sleep(2000);

	    	mediacount = camera.getCameraModuleText("MediaCount");
	    	try {
	    	assertEquals(mediacount, "4");
	    	}catch(Exception e) {
	    		System.out.println("Actual and expected values are not same");
	    	}
	    	
	    	previewphotoandvideo =camera.clickPreviewMedia();
	    	Thread.sleep(3000);
	    	previewphotoandvideo.clickOnPreview("Delete");
	    	previewphotoandvideo.clickBackOnPreview();
	    	Thread.sleep(2000);
	    	
	    	mediacount = camera.getCameraModuleText("MediaCount");
	    	try {
	    	assertEquals(mediacount, "3");
	    	}catch(Exception e) {
	    		System.out.println("Actual and expected values are not same");
	    	}
	    	
	    	previewphotoandvideo =camera.clickPreviewMedia();
	    	Thread.sleep(3000);
	    	previewphotoandvideo.clickOnPreview("Delete");
	    	previewphotoandvideo.clickBackOnPreview();
	    	Thread.sleep(2000);
	    	
	    	mediacount = camera.getCameraModuleText("MediaCount");
	    	try {
	    	assertEquals(mediacount, "2");
	    	}catch(Exception e) {
	    		System.out.println("Actual and expected values are not same");
	    	}
	    	
	    	previewphotoandvideo =camera.clickPreviewMedia();
	    	Thread.sleep(3000);
	    	previewphotoandvideo.clickOnPreview("Delete");
	    	previewphotoandvideo.clickBackOnPreview();
	    	Thread.sleep(2000);
	    	
	    	mediacount = camera.getCameraModuleText("MediaCount");
	    	try {
	    	assertEquals(mediacount, "1");
	    	}catch(Exception e) {
	    		System.out.println("Actual and expected values are not same");
	    	}
	    	
	    	previewphotoandvideo =camera.clickPreviewMedia();
	    	Thread.sleep(3000);
	    	previewphotoandvideo.clickOnPreview("Delete");
	    	
	    	camera.clickCloseCamera();
	    	Thread.sleep(5000);
	    	personalfiles.clickBack();
	    		
	    }
	 
	 @Test(priority=8)
	    public void videoDurationTest() throws Exception
	    {
	    	personalfiles.clickAdd();
	    	
	    	allowpermission = personalfiles.clickTakeaPhotosOrVedio();
	    	allowrecordpermission = allowpermission.clickGrantPermission("Only this time","Pixel");
	    	camera = allowrecordpermission.clickGrantRecordPermission("Only this time","Pixel");
	    	
	    	Thread.sleep(2000);
	    	camera.clickOnCameraModule("Video");
	    	Thread.sleep(2000);	
	    	camera.clickRecoding("Start");
	    	Thread.sleep(5000);	
	    	String captureduration = camera.getCameraModuleText("VideoDuration");
	    	camera.clickRecoding("Stop");
	    	
	    	previewphotoandvideo =camera.clickPreviewMedia();
	    	Thread.sleep(3000);
	    	String videoduration = previewphotoandvideo.getPreviewText("VideoDuration");
	    	boolean videolength = Double.parseDouble(captureduration) <= Double.parseDouble(videoduration);
	    	System.out.println("videolength :"+videolength);
	    	
	    	try {
		    	assertEquals(true, videolength);
		    	}catch(Exception e) {
		    		System.out.println("Actual and expected values are not same");
		    	}
	    	
	    	previewphotoandvideo.clickBackOnPreview();
	    	Thread.sleep(2000);

	    	camera.clickCloseCamera();
	    	camera.clickOnCameraModule("Discard");
	    	Thread.sleep(3000);
	    	personalfiles.clickBack();
	    		
	    }
	 
	 @Test(priority=9)
	    public void fileNameValidationsTest() throws Exception
	    {
	    	personalfiles.clickAdd();
	    	
	    	allowpermission = personalfiles.clickTakeaPhotosOrVedio();
	    	allowrecordpermission = allowpermission.clickGrantPermission("Only this time","Pixel");
	    	camera = allowrecordpermission.clickGrantRecordPermission("Only this time","Pixel");
	    	
	    	camera.clickOnCameraModule("Shutter");
	    	Thread.sleep(2000);
	    	previewphotoandvideo =camera.clickPreviewMedia();
	    	Thread.sleep(3000);
	    	
	    	String filename = previewphotoandvideo.getPreviewText("FileName");
	    	previewphotoandvideo.clickOnPreview("EraseFileNameUsingCrossButton");
	    	String nameisempty = previewphotoandvideo.getPreviewText("FileNameError");
	    	String actualerror = "File name can't be empty.";
	    	
	    	try {
		    	assertEquals(actualerror, nameisempty);
		    	}catch(Exception e) {
		    		System.out.println("Actual and expected values are not same");
		    	}
	    	Thread.sleep(1000);
	    	
	    	previewphotoandvideo.clickOnPreview("FileName");
	    	previewphotoandvideo.populateDataOnPreview("FileName", "/<>");
	    	String specialcharerror = previewphotoandvideo.getPreviewText("FileNameError");
	    	String actualspecialcharerror = "File name can't contain any of the following characters: ?:*|/\\<>";
	    	
	    	try {
		    	assertEquals(specialcharerror, actualspecialcharerror);
		    	}catch(Exception e) {
		    		System.out.println("Actual and expected values are not same");
		    	}
	    	
	    	previewphotoandvideo.clickOnPreview("Delete");
	    	Thread.sleep(2000);
	    	
	    	camera.clickOnCameraModule("Video");
	    	camera.clickRecoding("Start");
	    	Thread.sleep(3000);	
	    	camera.clickRecoding("Stop");
	    	previewphotoandvideo =camera.clickPreviewMedia();
	    	Thread.sleep(3000);
	    	
	    	filename = previewphotoandvideo.getPreviewText("FileName");
	    	previewphotoandvideo.clickOnPreview("EraseFileNameUsingCrossButton");
	    	nameisempty = previewphotoandvideo.getPreviewText("FileNameError");
	    	actualerror = "File name can't be empty.";
	    	
	    	try {
		    	assertEquals(actualerror, nameisempty);
		    	}catch(Exception e) {
		    		System.out.println("Actual and expected values are not same");
		    	}
	    	Thread.sleep(1000);
	    	
	    	previewphotoandvideo.clickOnPreview("FileName");
	    	previewphotoandvideo.populateDataOnPreview("FileName", "/<>");
	    	specialcharerror = previewphotoandvideo.getPreviewText("FileNameError");
	    	actualspecialcharerror = "File name can't contain any of the following characters: ?:*|/\\<>";
	    	
	    	try {
		    	assertEquals(specialcharerror, actualspecialcharerror);
		    	}catch(Exception e) {
		    		System.out.println("Actual and expected values are not same");
		    	}
	    	
	    	previewphotoandvideo.clickOnPreview("Delete");
	    	Thread.sleep(2000);

	    	camera.clickCloseCamera();
	    	Thread.sleep(3000);
	    	personalfiles.clickBack();
	    		
	    }
	 
	 @Test(priority=10)
	    public void fileNameRetainTest() throws Exception
	    {
	    	personalfiles.clickAdd();
	    	
	    	allowpermission = personalfiles.clickTakeaPhotosOrVedio();
	    	allowrecordpermission = allowpermission.clickGrantPermission("Only this time","Pixel");
	    	camera = allowrecordpermission.clickGrantRecordPermission("Only this time","Pixel");
	    	
	    	camera.clickOnCameraModule("Shutter");
	    	Thread.sleep(2000);
	    	previewphotoandvideo =camera.clickPreviewMedia();
	    	Thread.sleep(3000);

	    	previewphotoandvideo.clickOnPreview("EraseFileNameUsingCrossButton");
	    	previewphotoandvideo.populateDataOnPreview("FileName", "UpdatedNameofthePhoto");
	    	previewphotoandvideo.clickBackOnPreview();
	    	Thread.sleep(2000);
	    	previewphotoandvideo =camera.clickPreviewMedia();
	    	Thread.sleep(3000);
	    	
	    	String filename = previewphotoandvideo.getPreviewText("FileName");

	    	
	    	try {
		    	assertEquals(filename, "UpdatedNameofthePhoto");
		    	}catch(Exception e) {
		    		System.out.println("Actual and expected values are not same");
		    	}
	    	
	    	previewphotoandvideo.clickOnPreview("Delete");
	    	Thread.sleep(2000);
	    	
	    	camera.clickOnCameraModule("Video");
	    	camera.clickRecoding("Start");
	    	Thread.sleep(3000);	
	    	camera.clickRecoding("Stop");
	    	previewphotoandvideo =camera.clickPreviewMedia();
	    	Thread.sleep(3000);
	    	
	    	previewphotoandvideo.clickOnPreview("EraseFileNameUsingCrossButton");
	    	previewphotoandvideo.populateDataOnPreview("FileName", "UpdatedNameoftheVideo");
	    	previewphotoandvideo.clickBackOnPreview();
	    	Thread.sleep(2000);
	    	previewphotoandvideo =camera.clickPreviewMedia();
	    	Thread.sleep(3000);
	    	
	    	filename = previewphotoandvideo.getPreviewText("FileName");

	    	
	    	try {
		    	assertEquals(filename, "UpdatedNameoftheVideo");
		    	}catch(Exception e) {
		    		System.out.println("Actual and expected values are not same");
		    	}

	    	
	    	previewphotoandvideo.clickBackOnPreview();
	    	Thread.sleep(2000);

	    	camera.clickCloseCamera();
	    	camera.clickOnCameraModule("Discard");
	    	Thread.sleep(3000);
	    	personalfiles.clickBack();
	    		
	    }
	 
	 
	 @Test(priority=11)
	    public void videoPlayerTest() throws Exception
	    {
	    	personalfiles.clickAdd();
	    	
	    	allowpermission = personalfiles.clickTakeaPhotosOrVedio();
	    	allowrecordpermission = allowpermission.clickGrantPermission("Only this time","Pixel");
	    	camera = allowrecordpermission.clickGrantRecordPermission("Only this time","Pixel");
	    	
	    	Thread.sleep(1000);
	    	camera.clickOnCameraModule("Video");
	    	Thread.sleep(1000);
	    	camera.clickRecoding("Start");
	    	Thread.sleep(20000);	
	    	camera.clickRecoding("Stop");
	    	previewphotoandvideo =camera.clickPreviewMedia();
	    	Thread.sleep(3000);
	    	
	    	previewmedia = previewphotoandvideo.clickOnMediaFile();
	    	previewmedia.clickSeekbar("Play");
	    	Thread.sleep(5000);
	    	previewmedia.clickSeekbar("SeekForward");
	    	previewmedia.clickSeekbar("SeekReverse");
	    	previewmedia.clickSeekbar("Pause");
	    	
	    	String seekbartext = previewmedia.getPlayerText();
	    	previewmedia.clickClosePreviewOfMedia();
	    	
	    	previewphotoandvideo.clickBackOnPreview();
	    	Thread.sleep(2000);
	    	
	    	camera.clickCloseCamera();
	    	camera.clickOnCameraModule("Discard");
	    	Thread.sleep(3000);
	    	personalfiles.clickBack();
	    		
	    }
	 
	 @Test(priority=12)
	    public void scrollingInCarouselTest() throws Exception
	    {
	    	personalfiles.clickAdd();
	    	
	    	allowpermission = personalfiles.clickTakeaPhotosOrVedio();
	    	allowrecordpermission = allowpermission.clickGrantPermission("Only this time","Pixel");
	    	camera = allowrecordpermission.clickGrantRecordPermission("Only this time","Pixel");
	    	
	    	for(int i=0; i<3;i++)
	    	{
	    		camera.clickOnCameraModule("Shutter");
		    	Thread.sleep(3000);
	    	}
	    	
	    	previewphotoandvideo =camera.clickPreviewMedia();
	    	Thread.sleep(3000);
	    	
	    	previewphotoandvideo.swipeCarouselCards("Right");
	    	
	    	previewphotoandvideo.clickBackOnPreview();
	    	Thread.sleep(2000);
	    	
	    	camera.clickCloseCamera();
	    	camera.clickOnCameraModule("Discard");
	    	Thread.sleep(3000);
	    	personalfiles.clickBack();
	    		
	    }
	 
	 @Test(priority=13)
	    public void uploadMediaTest() throws Exception
	    {
	        personalfiles.clickAdd();
	    	
	    	allowpermission = personalfiles.clickTakeaPhotosOrVedio();
	    	allowrecordpermission = allowpermission.clickGrantPermission("Only this time","Pixel");
	    	camera = allowrecordpermission.clickGrantRecordPermission("Only this time","Pixel");

	    	camera.clickOnCameraModule("Shutter");
	    	Thread.sleep(3000);
	    	camera.clickOnCameraModule("SwitchCamera");
	    	camera.clickOnCameraModule("Shutter");
	    	Thread.sleep(3000);
	    	camera.clickOnCameraModule("Video");
	    	camera.clickRecoding("Start");
	    	camera.clickRecoding("Stop");
	    	Thread.sleep(3000);
	    	camera.clickOnCameraModule("SwitchCamera");
	    	camera.clickRecoding("Start");
	    	camera.clickRecoding("Stop");
	    	Thread.sleep(2000);
	    	previewphotoandvideo =camera.clickPreviewMedia();
	    	Thread.sleep(2000);
	    	
	    	previewphotoandvideo.clickOnPreview("Save");
	    	Thread.sleep(2000);
	    	
	    	personalfiles.clickBack();
	    		
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
