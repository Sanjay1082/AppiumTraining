package com.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.base.base;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class PersonalFilesPage extends base{
	public GalleryPage gallery;
	public PersonalFilesPage personalfiles;
    public MyLibrariesPage mylibrarires;
    public SharedPage shared;
    public TrashPage trash;
    public BrowserPage browser;
	public OfflinePage offline;
	public RecentPage recent;
	public FavoritesPage favorite;
	public AllowRecordPermissionPage allowpermission;
	public AllowWorkspacePermissionPage allowworkspacepermission;

	public PersonalFilesPage() {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		mylibrarires = new MyLibrariesPage();
		shared = new SharedPage();
		trash = new TrashPage();
	}

	@AndroidFindBy(xpath = ".//*[text()='Personal files']")
	private WebElement txtpersonalfiles;
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.alfresco.content.app.debug:id/more_button\")")
	private WebElement clickmoreoptions;
	@AndroidFindBy(xpath = "//android.widget.ImageButton[@class='android.widget.ImageButton' and @index='1']")
	private WebElement btnadd;
	@AndroidFindBy(className = "android.widget.TextView")
	private List<WebElement> fileoptions;
	@AndroidFindBy(className = "android.widget.TextView")
	private List<WebElement> captureoruploadfile;
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.alfresco.content.app.debug:id/title\")")
	private WebElement txtemptypersonalfiles;
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.alfresco.content.app.debug:id/nav_browse\")")
	private WebElement clickBrowser;
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.alfresco.content.app.debug:id/nav_offline\")")
	private WebElement clickoffline;
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.alfresco.content.app.debug:id/nav_recents\")")
	private WebElement clickrecent;
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.alfresco.content.app.debug:id/nav_favorites\")")
	private WebElement clickfavorites;
	
	public String getPersonalFilesPage()
	{
		return  txtpersonalfiles.getText();
	}
	
	public String getEmptyPersonalFiles()
	{
		return txtemptypersonalfiles.getText();
	}
	
	public void clickMoreOptions()
	{
		clickmoreoptions.click();
		driver.manage().timeouts().implicitlyWait(8000, TimeUnit.SECONDS);
		
	}
	
	public void clickMakeAvialableOffline()
	{
		fileoptions.get(1).click();
		driver.manage().timeouts().implicitlyWait(8000, TimeUnit.SECONDS);
	}
	
	public void clickAddToFavorites()
	{
		fileoptions.get(2).click();
		driver.manage().timeouts().implicitlyWait(8000, TimeUnit.SECONDS);
	}
	
	public void clickMoveToTrash()
	{
		fileoptions.get(3).click();
		driver.manage().timeouts().implicitlyWait(8000, TimeUnit.SECONDS);
	}
	
	public void clickAdd()
	{
		btnadd.click();
		driver.manage().timeouts().implicitlyWait(8000, TimeUnit.SECONDS);
	}
	
	public GalleryPage clickUploadPhotosOrVedios()
	{
		captureoruploadfile.get(0).click();
		driver.manage().timeouts().implicitlyWait(8000, TimeUnit.SECONDS);
		return gallery =new GalleryPage();
	}

	public AllowWorkspacePermissionPage clickTakeaPhotosOrVedio()
	{
		driver.manage().timeouts().implicitlyWait(8000, TimeUnit.SECONDS);
		System.out.println(captureoruploadfile.get(2));
		captureoruploadfile.get(2).click();
		return allowworkspacepermission = new AllowWorkspacePermissionPage();
	}
	
	public BrowserPage clickBack() throws InterruptedException {
		Thread.sleep(3000);
		clickBrowser.click();
		driver.manage().timeouts().implicitlyWait(8000, TimeUnit.SECONDS);
		return browser = new BrowserPage();
	}
	
	public FavoritesPage clickFavorite() {
		 clickfavorites.click();
		 driver.manage().timeouts().implicitlyWait(8000, TimeUnit.SECONDS);
		 return favorite = new FavoritesPage();
	 }
	 
	 public RecentPage clickRecent() {
		 clickrecent.click();
		 driver.manage().timeouts().implicitlyWait(8000, TimeUnit.SECONDS);
		 return recent= new RecentPage();
	 }
	 
	 public OfflinePage clickOffline() {
			tap(clickoffline);
			driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
			return  offline = new OfflinePage();
	 }
}
