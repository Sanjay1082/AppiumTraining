package com.pages;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import com.base.base;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class PreviewMediaPage extends base{

	PreviewPhotoAndVedioPage previewphotoandvideo;
	
	public PreviewMediaPage()
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.alfresco.content.app.debug:id/close_button\")")
	 private WebElement btnclose;
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.alfresco.content.app.debug:id/exo_rew\")")
	 private WebElement btnseekreverse;
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.alfresco.content.app.debug:id/exo_play\")")
	 private WebElement btnplay;
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.alfresco.content.app.debug:id/exo_ffwd\")")
	 private WebElement btnseekforword;
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.alfresco.content.app.debug:id/exo_progress\")")
	 private WebElement btnseekbar;
	
	public void clickSeekbar(String value)
	{
		if(value.equalsIgnoreCase("SeekReverse"))
		{
			driver.manage().timeouts().implicitlyWait(8000, TimeUnit.SECONDS);
			btnseekreverse.click();
		}else if(value.equalsIgnoreCase("SeekForward"))
		{
			driver.manage().timeouts().implicitlyWait(8000, TimeUnit.SECONDS);
			btnseekforword.click();
			
		}else if(value.equalsIgnoreCase("Play"))
		{
			driver.manage().timeouts().implicitlyWait(8000, TimeUnit.SECONDS);
			btnseekforword.click();
			
		}else if(value.equalsIgnoreCase("Pause"))
		{
			driver.manage().timeouts().implicitlyWait(8000, TimeUnit.SECONDS);
			btnseekforword.click();
			
		}else if(value.equalsIgnoreCase("SeekBar"))
		{
			driver.manage().timeouts().implicitlyWait(8000, TimeUnit.SECONDS);
			btnseekbar.click();
			
		}
	}
	
	public String getPlayerText()
	{
		return btnseekbar.getAttribute("content-desc");
	}
	
	public PreviewPhotoAndVedioPage clickClosePreviewOfMedia()
	{
		btnclose.click();
		driver.manage().timeouts().implicitlyWait(8000, TimeUnit.SECONDS);
		return previewphotoandvideo = new PreviewPhotoAndVedioPage();
	}
	
}
