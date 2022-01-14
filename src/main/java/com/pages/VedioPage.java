package com.pages;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import com.base.base;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class VedioPage extends base{

	public PreviewPhotoAndVedioPage previewphotoandvedio;
	
	public VedioPage()
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	
	 @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.alfresco.content.app:id/etClientId\")")
	 WebElement btnshutter;
	 @AndroidFindBy(className = "android.widget.ImageButton")
	 WebElement btnback;
	
	public PreviewPhotoAndVedioPage clickStopRecoding() {
		btnshutter.click();
		driver.manage().timeouts().implicitlyWait(8000, TimeUnit.SECONDS);
		return previewphotoandvedio = new PreviewPhotoAndVedioPage();
	}
	
}
