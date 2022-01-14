package com.pages;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import com.base.base;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.StartsActivity;

public class CameraPage extends base{

	PreviewPhotoAndVedioPage previewphotoandvedio; 
	VedioPage vedio;
	PersonalFilesPage personalfiles;
	
	
	public CameraPage()
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(className = "android.widget.TextView")
	 private List<WebElement> txtphotoandvedio;
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.alfresco.content.app.debug:id/close_button\")")
	 private WebElement btnclose;
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.alfresco.content.app.debug:id/shutter_button\")")
	 private WebElement btnshutter;
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.alfresco.content.app.debug:id/camera_switch_button\")")
	 private WebElement btnswitchcamera;
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.alfresco.content.app.debug:id/zoom_text\")")
	 private WebElement btnzoom;
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.alfresco.content.app.debug:id/preview\")")
	 private WebElement btnpreview;
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.alfresco.content.app.debug:id/alertTitle\")")
	 private WebElement txtdiscardcapture;
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"android:id/message\")")
	 private WebElement txtdiscardmessage;
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"android:id/button1\")")
	 private WebElement btndiscard;
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"android:id/button2\")")
	 private WebElement btncancel;
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.alfresco.content.app.debug:id/image_count\")")
	 private WebElement txtmediacounter;
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.alfresco.content.app.debug:id/preview\")")
	 private WebElement btnmediapreview;
	@AndroidFindBy(xpath = "//*[@class='android.widget.TextView' and @index='1']")
	private WebElement btnvideo;
	@AndroidFindBy(xpath = "//*[contains(@resource-id, 'flash_button')]")
	private WebElement btnflash;
	@AndroidFindBy(xpath = "//*[contains(@resource-id, 'flash_mode_auto')]")
	private WebElement btnflashauto;
	@AndroidFindBy(xpath = "//*[contains(@resource-id, 'flash_mode_on')]")
	private WebElement btnflashon;
	@AndroidFindBy(xpath = "//*[contains(@resource-id, 'flash_mode_off')]")
	private WebElement btnflashoff;
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.alfresco.content.app.debug:id/capture_duration\")")
	private WebElement txtvideoduration;
	
	
	public void clickOnCameraModule(String value) throws Exception
	{
		if(value.equalsIgnoreCase("Cancel"))
		{
			btncancel.click();
			driver.manage().timeouts().implicitlyWait(8000, TimeUnit.SECONDS);
		}else if(value.equalsIgnoreCase("Discard")) 
		{
			btndiscard.click();
			driver.manage().timeouts().implicitlyWait(8000, TimeUnit.SECONDS);
			Thread.sleep(2000);
		}else if(value.equalsIgnoreCase("Video")) 
		{
			btnvideo.click();
			driver.manage().timeouts().implicitlyWait(8000, TimeUnit.SECONDS);
			Thread.sleep(3000);	
		}else if(value.equalsIgnoreCase("Photo"))
		{
			txtphotoandvedio.get(0).click();
			driver.manage().timeouts().implicitlyWait(8000, TimeUnit.SECONDS);
		}else if(value.equalsIgnoreCase("SwitchCamera")) 
		{
			btnswitchcamera.click();
			driver.manage().timeouts().implicitlyWait(8000, TimeUnit.SECONDS);
			Thread.sleep(3000);	
		}else if(value.equalsIgnoreCase("Zoom")) 
		{
			btnzoom.click();
			btnzoom.click();
			driver.manage().timeouts().implicitlyWait(8000, TimeUnit.SECONDS);
		}else if(value.equalsIgnoreCase("Shutter")) 
		{
			tap(btnshutter);
			driver.manage().timeouts().implicitlyWait(8000, TimeUnit.SECONDS);
		}else if(value.equalsIgnoreCase("MediaPreview")) 
		{
			tap(btnmediapreview);
			driver.manage().timeouts().implicitlyWait(8000, TimeUnit.SECONDS);
		}else if(value.equalsIgnoreCase("BackGround")) 
		{
			driver.runAppInBackground(Duration.ofSeconds(10));
			driver.manage().timeouts().implicitlyWait(8000, TimeUnit.SECONDS);
		}else if(value.equalsIgnoreCase("Launch")) 
		{
			//driver.launchApp();
			((StartsActivity)driver).currentActivity();
			//driver.startActivity("appPackage","com.example.android.apis", null, null);
			driver.manage().timeouts().implicitlyWait(8000, TimeUnit.SECONDS);
		}else if(value.equalsIgnoreCase("FlashAuto")) 
		{
			try {
			tap(btnflash);
			driver.manage().timeouts().implicitlyWait(8000, TimeUnit.SECONDS);
			tap(btnflashauto);
			}
			catch(Exception e)
			{
				System.out.println("Device doesn't have flash");
			}
		}else if(value.equalsIgnoreCase("FlashOn")) 
		{
			try {
			tap(btnflash);
			driver.manage().timeouts().implicitlyWait(8000, TimeUnit.SECONDS);
			tap(btnflashon);
			}
			catch(Exception e)
			{
				System.out.println("Device doesn't have flash");
			}
		}else if(value.equalsIgnoreCase("FlashOff")) 
		{
			try {
			tap(btnflash);
			driver.manage().timeouts().implicitlyWait(8000, TimeUnit.SECONDS);
			tap(btnflashoff);
			}
			catch(Exception e)
			{
				System.out.println("Device doesn't have flash");
			}
		}else
		{
			throw new Exception("No Discard Popup Found");
		}
	}
	
	public boolean isThumbnailPresent() {
		try {
		if(btnmediapreview.isEnabled()==true) {
			return true;
		}
		}catch(Exception e) {
			return false;
		}
		return false;
	}
	
	public String getCameraModuleText(String value) throws Exception
	{
		if(value.equalsIgnoreCase("Cancel"))
		{
			driver.manage().timeouts().implicitlyWait(8000, TimeUnit.SECONDS);
			return btncancel.getText();
		}else if(value.equalsIgnoreCase("Discard")) 
		{
			driver.manage().timeouts().implicitlyWait(8000, TimeUnit.SECONDS);
			return btndiscard.getText();
		}else if(value.equalsIgnoreCase("Photo"))
		{
			driver.manage().timeouts().implicitlyWait(8000, TimeUnit.SECONDS);
			return txtphotoandvedio.get(0).getText();
		}else if(value.equalsIgnoreCase("Video"))
		{
			driver.manage().timeouts().implicitlyWait(8000, TimeUnit.SECONDS);
			return txtphotoandvedio.get(1).getText();
		}else if(value.equalsIgnoreCase("DiscardWarning"))
		{
			driver.manage().timeouts().implicitlyWait(8000, TimeUnit.SECONDS);
			return txtdiscardcapture.getText();
		}else if(value.equalsIgnoreCase("DiscardMessage"))
		{
			driver.manage().timeouts().implicitlyWait(8000, TimeUnit.SECONDS);
			return txtdiscardmessage.getText();
		}else if(value.equalsIgnoreCase("SwitchCamera")) 
		{
			driver.manage().timeouts().implicitlyWait(8000, TimeUnit.SECONDS);
			return btnswitchcamera.getText();
		}else if(value.equalsIgnoreCase("Zoom")) 
		{
			driver.manage().timeouts().implicitlyWait(8000, TimeUnit.SECONDS);
			return btnzoom.getText();
		}else if(value.equalsIgnoreCase("MediaCount")) 
		{
			driver.manage().timeouts().implicitlyWait(8000, TimeUnit.SECONDS);
			return txtmediacounter.getText();
		}else if(value.equalsIgnoreCase("VideoDuration")) 
		{
			driver.manage().timeouts().implicitlyWait(8000, TimeUnit.SECONDS);
			return txtvideoduration.getText();
		}
		else
		{
			throw new Exception("No Discard Popup Found");
		}	
	}
	
	
	public PreviewPhotoAndVedioPage clickSwitchCamera() {
		btnswitchcamera.click();
		driver.manage().timeouts().implicitlyWait(8000, TimeUnit.SECONDS);
		return previewphotoandvedio = new PreviewPhotoAndVedioPage();
	}
	
	public PreviewPhotoAndVedioPage clickPreviewMedia() {
		btnpreview.click();
		driver.manage().timeouts().implicitlyWait(8000, TimeUnit.SECONDS);
		return previewphotoandvedio = new PreviewPhotoAndVedioPage();
	}
	
	public VedioPage clickRecoding(String value) throws InterruptedException {
		if(value.equalsIgnoreCase("Start"))
		{
		btnshutter.click();
		driver.manage().timeouts().implicitlyWait(8000, TimeUnit.SECONDS);
		Thread.sleep(3000);	
		}else
		{
			btnshutter.click();
			driver.manage().timeouts().implicitlyWait(8000, TimeUnit.SECONDS);
			Thread.sleep(3000);	
		}
		return vedio = new VedioPage();
	}
	
	public PersonalFilesPage clickCloseCamera() throws InterruptedException {
		btnclose.click();
		Thread.sleep(5000);
		return personalfiles = new PersonalFilesPage();
	}
}
