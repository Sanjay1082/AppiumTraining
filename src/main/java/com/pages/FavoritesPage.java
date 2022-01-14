package com.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import com.base.base;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;


public class FavoritesPage extends base{
   
	OfflinePage offline;
	BrowserPage browser;
	RecentPage recent;
	
	public FavoritesPage()
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	 @AndroidFindBy(className="android.widget.TextView")
	 List<WebElement> txtfilesandfolders;
	 @AndroidFindBy(xpath = "//*[text()=\"Libraries\"]")
	 WebElement txtlibraries;
	 @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.alfresco.content.app.debug:id/title\")")
	 WebElement emptyfavorites;
	 @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.alfresco.content.app.debug:id/message\")")
	 WebElement emptyfavoritesmessage;
	 @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.alfresco.content.app.debug:id/nav_offline\")")
	 WebElement clickoffline;
	 @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.alfresco.content.app.debug:id/nav_browse\")")
	 WebElement clickBrowser;
	 @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.alfresco.content.app.debug:id/nav_favorites\")")
	 WebElement txtfavoritestitle;
	 @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.alfresco.content.app.debug:id/nav_recents\")")
	 WebElement clickrecent;
	 
	 
	 
	 public boolean defaultSelection() {
		 return txtfilesandfolders.get(1).isSelected();
	 }
	 
	 public boolean getSelectedPage(){
			return txtfavoritestitle.isSelected();
	 }
	 
	 public String getFavoriteTitle(){
			return txtfavoritestitle.getTagName().toString();
	 }
	
	 public String getFilesandFolders() {
		 return txtfilesandfolders.get(1).getText();
	 }
	 
	 public String getLibraries() {
		 return txtfilesandfolders.get(2).getText();
	 }
	 
	 public String getEmptyFilesandFolders() {
		 return emptyfavorites.getText();
	 }
	 
	 public String getEmptyFilesandFoldersMessage() {
		 driver.manage().timeouts().implicitlyWait(8000, TimeUnit.SECONDS);
		 return emptyfavoritesmessage.getText();
	 }
	 
	 public String getEmptyLibraries() {
		 driver.manage().timeouts().implicitlyWait(8000, TimeUnit.SECONDS);
		 return emptyfavorites.getText();
	 }
	 
	 public void clickLibraries() {
		 txtfilesandfolders.get(2).click();
		 driver.manage().timeouts().implicitlyWait(8000, TimeUnit.SECONDS);
	 }
	 
	 public RecentPage clickRecent() {
		 clickrecent.click();
		 driver.manage().timeouts().implicitlyWait(8000, TimeUnit.SECONDS);
		 return recent= new RecentPage();
	 }
	 
	 public OfflinePage clickOffline() {
		 clickoffline.click();
		 driver.manage().timeouts().implicitlyWait(8000, TimeUnit.SECONDS);
		 return offline= new OfflinePage();
	 }
	 
	 public BrowserPage clickBrowser() {
		 clickBrowser.click();
		 driver.manage().timeouts().implicitlyWait(8000, TimeUnit.SECONDS);
		 return browser= new BrowserPage();
	 }
	 
}
