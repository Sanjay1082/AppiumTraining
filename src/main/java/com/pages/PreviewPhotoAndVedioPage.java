package com.pages;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import com.base.base;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class PreviewPhotoAndVedioPage extends base{

	PreviewMediaPage previewmedia;
	CameraPage camera;

	public PreviewPhotoAndVedioPage()
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(className = "android.widget.TextView")
	 private List<WebElement> txtphotoandvedio;
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.alfresco.content.app.debug:id/preview\")")
	 private WebElement btnpreviewfile;
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.alfresco.content.app.debug:id/video_duration\")")
	 private WebElement txtvideoduration;
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.alfresco.content.app.debug:id/delete_photo_button\")")
	 private WebElement btndelete;
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.alfresco.content.app.debug:id/file_name_input\")")
	 private WebElement txtfilename;
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.alfresco.content.app.debug:id/description_input\")")
	 private WebElement txtfiledescription;
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.alfresco.content.app.debug:id/save_button\")")
	 private WebElement btnsave;
	@AndroidFindBy(xpath = "//*[@class='android.widget.ImageButton' and @index='0']")
	private WebElement btnback;
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.alfresco.content.app.debug:id/text_input_end_icon\")")
	 private WebElement btnendfilename;
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.alfresco.content.app.debug:id/text_input_error_icon\")")
	 private WebElement btntextinputerroricon;
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.alfresco.content.app.debug:id/textinput_error\")")
	 private WebElement btntextinputerror;
	@AndroidFindBy(xpath = "//*[text()='Preview']")
	private WebElement txtpreview;

	
	
	public void populateDataOnPreview(String label, String value) throws Exception
	{
		if(label.equalsIgnoreCase("FileName"))
		{
			driver.manage().timeouts().implicitlyWait(8000, TimeUnit.SECONDS);
			txtfilename.sendKeys(value);
		}else if(label.equalsIgnoreCase("AddDescription"))
		{
			driver.manage().timeouts().implicitlyWait(8000, TimeUnit.SECONDS);
			txtfiledescription.click();
			txtfiledescription.sendKeys(value);
		}
		
	}
	
	public void swipeCarouselCards(String direction) {

    	if(direction.equalsIgnoreCase("Right"))
    	{
    		List<AndroidElement> carouselelements=driver.findElements(MobileBy.AndroidUIAutomator("new UiSelector().resourceId(\"com.alfresco.content.app.debug:id/preview\")"));
        	AndroidElement firstelement=carouselelements.get(0);
        	AndroidElement secondElement=carouselelements.get(1);
        							
        	int midOfY =secondElement.getLocation().y +(secondElement.getSize().height/2);
        	int fromXLocation=secondElement.getLocation().x;
        	int toXLocation=firstelement.getLocation().x;
        	
        	TouchAction  action =new TouchAction(driver);
        	action.press(PointOption.point(fromXLocation, midOfY))
        	.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
        	.moveTo(PointOption.point(toXLocation, midOfY))
        	.release()
        	.perform();
    	}
    	else
    	{
        	List<AndroidElement> carouselelements=driver.findElements(MobileBy.AndroidUIAutomator("new UiSelector().resourceId(\"com.alfresco.content.app.debug:id/preview\")"));
        	AndroidElement firstelement=carouselelements.get(0);
        	AndroidElement secondElement=carouselelements.get(1);
        							
        	int midOfY =secondElement.getLocation().y +(secondElement.getSize().height/2);
        	int fromXLocation=secondElement.getLocation().x;
        	int toXLocation=firstelement.getLocation().x;
        	
        	TouchAction  action =new TouchAction(driver);
        	action.press(PointOption.point(toXLocation, midOfY))
        	.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
        	.moveTo(PointOption.point(fromXLocation, midOfY))
        	.release()
        	.perform();
    	}
    }
	
	public void clickOnPreview(String value) throws Exception
	{
		if(value.equalsIgnoreCase("Delete"))
		{
			driver.manage().timeouts().implicitlyWait(8000, TimeUnit.SECONDS);
			btndelete.click();
		}else if(value.equalsIgnoreCase("FileName"))
		{
			driver.manage().timeouts().implicitlyWait(8000, TimeUnit.SECONDS);
			txtfilename.click();
			
		}else if(value.equalsIgnoreCase("EraseFileNameUsingCrossButton"))
		{
			driver.manage().timeouts().implicitlyWait(8000, TimeUnit.SECONDS);
			txtfilename.click();
			Thread.sleep(2000);
			btnendfilename.click();
			
		}else if(value.equalsIgnoreCase("EraseFileName"))
		{
			driver.manage().timeouts().implicitlyWait(8000, TimeUnit.SECONDS);
			
			String filename = getPreviewText("FileName");
			while(!(filename.isEmpty()))
			{
				filename = getPreviewText("FileName");
				btnendfilename.sendKeys(Keys.BACK_SPACE);
			}
			
		}else if(value.equalsIgnoreCase("AddDescription"))
		{
			driver.manage().timeouts().implicitlyWait(8000, TimeUnit.SECONDS);
			txtfiledescription.click();
			
		}else if(value.equalsIgnoreCase("Save"))
		{
			driver.manage().timeouts().implicitlyWait(8000, TimeUnit.SECONDS);
			btnsave.click();
			
		}else if(value.equalsIgnoreCase("GoBackToCameraModule"))
		{
			driver.manage().timeouts().implicitlyWait(8000, TimeUnit.SECONDS);
			btnback.click();
			
		}else
		{
			throw new Exception("Unable to click");
		}
    }
	
	public String getPreviewText(String value) throws Exception
	{
		if(value.equalsIgnoreCase("Preview"))
		{
			driver.manage().timeouts().implicitlyWait(8000, TimeUnit.SECONDS);
			return txtpreview.getText();
		}else if(value.equalsIgnoreCase("VideoDuration"))
		{
			driver.manage().timeouts().implicitlyWait(8000, TimeUnit.SECONDS);
			return txtvideoduration.getText();
		}else if(value.equalsIgnoreCase("FileName"))
		{
			driver.manage().timeouts().implicitlyWait(8000, TimeUnit.SECONDS);
			return txtfilename.getText();
		}else if(value.equalsIgnoreCase("FileDescription"))
		{
			driver.manage().timeouts().implicitlyWait(8000, TimeUnit.SECONDS);
			return txtfiledescription.getText();
		}else if(value.equalsIgnoreCase("Save"))
		{
			driver.manage().timeouts().implicitlyWait(8000, TimeUnit.SECONDS);
			return btnsave.getText();
		}else if(value.equalsIgnoreCase("FileNameError"))
		{
			driver.manage().timeouts().implicitlyWait(8000, TimeUnit.SECONDS);
			return btntextinputerror.getText();
		}
		else
		{
			throw new Exception("No Discard Popup Found");
		}	
	}
	
	public CameraPage clickBackOnPreview() {
		btnback.click();
		driver.manage().timeouts().implicitlyWait(8000, TimeUnit.SECONDS);
		return camera = new CameraPage();
	}
	
	public PreviewMediaPage clickOnMediaFile() {
		btnpreviewfile.click();
		driver.manage().timeouts().implicitlyWait(8000, TimeUnit.SECONDS);
		return previewmedia = new PreviewMediaPage();
	}
}
