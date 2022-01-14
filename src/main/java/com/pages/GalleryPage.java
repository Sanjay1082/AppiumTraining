package com.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import com.base.base;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class GalleryPage extends base{
	
	DownloadPage download;

	public GalleryPage() {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		}
	
	@AndroidFindBy(className = "android.widget.TextView")
	 private List<WebElement> clickdownloads;	
	@AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc='Show roots']")
	 private WebElement btnexpandrecent;
	@AndroidFindBy(xpath = "//com.google.android.material.chip.Chip[@class='' and @index='0']")
	 private WebElement btnselectimages;
	@AndroidFindBy(xpath = "//com.google.android.material.chip.Chip[@class='' and @index='1']")
	 private WebElement btnselectvideos;
	@AndroidFindBy(xpath = "//com.google.android.material.chip.Chip[@class='' and @index='2']")
	 private WebElement btnselectlargefiles;
	@AndroidFindBy(xpath = "//com.google.android.material.chip.Chip[@class='' and @index='3']")
	 private WebElement btnselectthisweek;
	@AndroidFindBy(xpath = "//*[@content-desc='Drive']")
	 private WebElement btndrive;
	@AndroidFindBy(xpath = "//*[@content-desc='Photos']")
	 private WebElement btnphotos;
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.google.android.documentsui:id/item_root\")")
	 private List<WebElement> btnselectitems;
	@AndroidFindBy(xpath = "//android.widget.TextView[text()=\"Recent\"]")
	 private WebElement btnopenfromrecent;
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(text(),'Images')]")
	 private WebElement btnopenfromimages;
	@AndroidFindBy(xpath = "//android.widget.TextView[text()=\"Downloads\"]")
	 private WebElement btnopenfromdownloads;
	@AndroidFindBy(xpath = "//android.widget.TextView[text()=\"SDCARD\"]")
	 private WebElement btnopenfromsdcard;
	@AndroidFindBy(xpath = "//android.widget.TextView[text()=\"Drive\"]")
	 private WebElement btnopenfromdrive;
	@AndroidFindBy(xpath = "//android.widget.TextView[text()=\"Photos\"]")
	 private WebElement btnopenfromphotos;
	
	@AndroidFindBy(xpath = "//android.widget.LinearLayout[@class='android.widget.TextView']")
	 private List<WebElement> btnopenfrom;
	
	
	
	public void clickExpandSideOptions()
	{
		btnexpandrecent.click();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
	}
	
	public void clickOpenFromImages()
	{
		btnopenfromimages.click();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
	}
	
	public void clickOpenFrom()
	{
		for(int i=0;i<9;i++)
		{
			System.out.println("Print "+i+" : "+btnopenfrom.get(i).getText());
		}
	}
	
	public DownloadPage clickDownloads()
	{
		clickdownloads.get(1).click();
		driver.manage().timeouts().implicitlyWait(8000, TimeUnit.MILLISECONDS);
		return download = new DownloadPage();
	}
	

}