package com.pages;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import com.base.base;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class DownloadPage extends base{
	
	public DownloadPage()
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	
	@AndroidFindBy(className = "android.widget.TextView")
	 List<WebElement> txtdownloads;
	@AndroidFindBy(className = "android.widget.TextView")
	 List<WebElement> clickimage;
	
	
	public String getTitle()
	{
		return txtdownloads.get(0).getText();
	}
	
	public void selectImage()
	{
		clickimage.get(0).click();
	}

}
