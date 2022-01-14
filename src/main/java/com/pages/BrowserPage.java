package com.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import com.base.base;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class BrowserPage extends base{
	 
    public PersonalFilesPage personalfiles;
    public MyLibrariesPage mylibrarires;
    public SharedPage shared;
    public TrashPage trash;
    public FavoritesPage favorite;
    public RecentPage recent;
    public OfflinePage offline;
	
	public BrowserPage() {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.alfresco.content.app.debug:id/title\")")
	private List<WebElement> linkpersonalfiles;
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.alfresco.content.app.debug:id/nav_favorites\")")
	private WebElement clickfavorites;
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.alfresco.content.app.debug:id/nav_offline\")")
	private WebElement clickoffline;
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.alfresco.content.app.debug:id/nav_recents\")")
	private WebElement clickrecent;
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.alfresco.content.app.debug:id/nav_browse\")")
	private WebElement txtbrowser;
	
	
	public boolean getSelectedPage(){
		return txtbrowser.isSelected();
    }
 
    public String getBrowserTitle(){
		return txtbrowser.getTagName().toString();
    }
	
	public String getPersonalFiles() {
		return linkpersonalfiles.get(0).getText();
	}
	
	public String getMyLibraries() {
		return linkpersonalfiles.get(1).getText();
	}
	
	public String getShared() {
		return linkpersonalfiles.get(2).getText();
	}
	
	public String getTrash() {
		return linkpersonalfiles.get(3).getText();
	}
	
	public PersonalFilesPage clickPersonalFiles() {
		tap(linkpersonalfiles.get(0));
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		return  personalfiles = new PersonalFilesPage();
	}
	
	public MyLibrariesPage clickMyLibraries() {
		tap(linkpersonalfiles.get(1));
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		return  mylibrarires = new MyLibrariesPage();
	}
	
	public SharedPage clickShared() {
		tap(linkpersonalfiles.get(2));
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		return  shared = new SharedPage();
	}
	
	public TrashPage clickTrash() {
		tap(linkpersonalfiles.get(3));
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		return  trash = new TrashPage();
	}
	
	public OfflinePage clickOffline() {
		tap(clickoffline);
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		return  offline = new OfflinePage();
	}
	
	public FavoritesPage clickFavorites() {
		tap(clickfavorites);
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		return  favorite = new FavoritesPage();
	}
	
	public RecentPage clickRecent() {
		tap(clickrecent);
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		return  recent = new RecentPage();
	}
	
}
