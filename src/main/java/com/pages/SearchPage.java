package com.pages;

import java.text.ParseException;
import java.time.Duration;
//import static io.appium.java_client.touch.TapOptions.tapOptions;
//import static io.appium.java_client.touch.offset.ElementOption.element;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import com.base.base;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.StartsActivity;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class SearchPage extends base{

	RecentPage recent;
	JavascriptExecutor js;
	int searchresults=0;
	
	public SearchPage()
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	
	}
	
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.alfresco.content.app.debug:id/title\")")
	MobileElement clickimage;
	@AndroidFindBy(className = "android.widget.ImageButton")
	MobileElement clickimageback;
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.alfresco.content.app.debug:id/icon\")")
	MobileElement clickrecent;
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.alfresco.content.app.debug:id/chip_files\")")
	MobileElement clickfilechip;
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.alfresco.content.app.debug:id/chip_folders\")")
	MobileElement clickfolderchip;
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.alfresco.content.app.debug:id/chip_libraries\")")
	MobileElement clicklibrarieschip;
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.alfresco.content.app.debug:id/search_src_text\")")
	MobileElement txtsearch;
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.alfresco.content.app.debug:id/title\")")
	 List<MobileElement> txtsearchresultstitle;
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.alfresco.content.app.debug:id/subtitle\")")
	 List<MobileElement> txtsearchitemslocation;
	@AndroidFindBy(className = "android.widget.FrameLayout")
	 List<MobileElement> txtsearchitemsnumber;
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.alfresco.content.app.debug:id/title\")")
	MobileElement txtnosearchresult;
	@AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"Clear query\"]")
	MobileElement clickclearsearch;
	@AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Collapse\"]")
	MobileElement clickcollapsesearch;
	@AndroidFindBy(className = "android.widget.TextView")
	MobileElement txtrecentsearches;
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.alfresco.content.app.debug:id/title\")")
	MobileElement txtnofolder;
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.alfresco.content.app.debug:id/title\")")
	MobileElement txtlibraryname;
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.alfresco.content.app.debug:id/action_down\")")
	MobileElement btndropdownindicator;
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.alfresco.content.app.debug:id/chip\")")
	 List<MobileElement> btnchips;
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.alfresco.content.app.debug:id/title\")")
	MobileElement txtchiptype;
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.alfresco.content.app.debug:id/name_input\")")
	MobileElement txtinputname;
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.alfresco.content.app.debug:id/apply_button\")")
	MobileElement btnapply;
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.alfresco.content.app.debug:id/reset_button\")")
	MobileElement btnreset;
	@AndroidFindBy(xpath = ".//*[@resource-id='com.alfresco.content.app.debug:id/action_reset' and @index='1']")
	MobileElement btnreset1;
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.alfresco.content.app.debug:id/cancel_button\")")
	MobileElement btncancel;
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.alfresco.content.app.debug:id/checkBox\")")
	 List<MobileElement> chkfiletype;
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.alfresco.content.app.debug:id/slider\")")
	MobileElement btnslider;
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.alfresco.content.app.debug:id/from_input\")")
	MobileElement txtfrominput;
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.alfresco.content.app.debug:id/to_input\")")
	MobileElement txttoinput;
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.alfresco.content.app.debug:id/number_range_error\")")
	MobileElement txtnumberrangeerror;
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.alfresco.content.app.debug:id/radioButton\")")
	 List<MobileElement> btnfiletyperadio;
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.alfresco.content.app.debug:id/action_down\")")
	MobileElement btnexpandadvancedsearchdropdown;
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.alfresco.content.app.debug:id/chip\")")
	 List<MobileElement> txtadvancedsearchdropdownvalues;
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.alfresco.content.app.debug:id/mtrl_picker_header_toggle\")")
	MobileElement btneditcalenderdate;
	@AndroidFindBy(className = "android.widget.EditText")
	MobileElement txteditdate;
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.alfresco.content.app.debug:id/confirm_button\")")
	MobileElement btnokcalendar;
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.alfresco.content.app.debug:id/action_reset\")")
	MobileElement btnresetchipsvalues;
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.alfresco.content.app.debug:id/title\")")
	 List<MobileElement> txtsearchresults;
	
	
	
	public boolean isFileChecked() {
		 String checked = clickfilechip.getAttribute("checked");
		 return Boolean.parseBoolean(checked);
	}
	
	public boolean isFolderChecked() {
		String checked = clickfolderchip.getAttribute("checked");
		return Boolean.parseBoolean(checked);
	}
	
	public boolean isLibrariesChecked() {
		String checked = clicklibrarieschip.getAttribute("checked");
		return Boolean.parseBoolean(checked);
	}
	
	public boolean isElementExistInSearch() {
        try {
        	explicitWait(txtsearchresultstitle.get(0));
        	return txtsearchresultstitle.get(0).isDisplayed();
        } catch (Exception  e) {
            return false;
        }
    }
	
	//This is not giving expected result yet
    public int getRecordCount() throws InterruptedException 
    {
    	int length = txtsearchresults.size();
    	
    	if(length<8)
    	{
    		return searchresults = length;
    	}
    	else
    	{  
    		int size = txtsearchresults.size();
    		String lastrecord = txtsearchresults.get(size-1).getText();
        	String secondlast = null;
        	
    		searchresults=length;
    		
    		while(!lastrecord.equals(secondlast))
    		{
    			swipeUp();
    			secondlast=lastrecord;
    			lastrecord=txtsearchresults.get(txtsearchresults.size()-1).getText();
    			int j =0;
    			for(int i=0; i<txtsearchresults.size(); i++)
    			{
    				j=j+1;
    				if(secondlast.equals(txtsearchresults.get(i).getText()))
    				{
    					break;
    				}
    			}
    			searchresults=searchresults+txtsearchresults.size()-j;
    		}
    		return searchresults;
    	}
	}
	
    public String getChipTextAtIndex(int index)
	{
		explicitWait(btnchips.get(index));
		return btnchips.get(index).getText();	
	}
    
    public String getSearchRecordInformation(String value) {
		
		if(value.equalsIgnoreCase("Name"))
		{
			//driver.pressKey(new KeyEvent(AndroidKey.BACK));
			explicitWait(txtsearchresultstitle.get(0));
			
		    return txtsearchresultstitle.get(0).getText();
			
		}
		else if(value.equalsIgnoreCase("Location")) 
		{
			driver.pressKey(new KeyEvent(AndroidKey.BACK));
			return txtsearchitemslocation.get(0).getText();
		}
		else if(value.equalsIgnoreCase("Library"))
		{
			return txtlibraryname.getText();
		}
		   return null;
	}
    
    public String getSearchRecordInformation(String value, int recordindex) {
		
		if(value.equalsIgnoreCase("Name"))
		{
			//driver.pressKey(new KeyEvent(AndroidKey.BACK));
			explicitWait(txtsearchresultstitle.get(recordindex));
			
		    return txtsearchresultstitle.get(recordindex).getText();
			
		}
		else if(value.equalsIgnoreCase("Location")) 
		{
			driver.pressKey(new KeyEvent(AndroidKey.BACK));
			return txtsearchitemslocation.get(recordindex).getText();
		}
		else if(value.equalsIgnoreCase("Library"))
		{
			return txtlibraryname.getText();
		}
		   return null;
	}
    
    public String getRecentSearches() {
    	return txtrecentsearches.getText();
    }
    
    public String getNoFolderAvailable() {
    	return txtnofolder.getText();
    }
    
    public String getChipValue(String chip) throws Exception
	{
		switch(chip)
		{
		case "Name":
		{
			explicitWait(btnchips.get(0));
			return btnchips.get(0).getText();	
		}
		case "CheckList": 
		{
			explicitWait(btnchips.get(1));
			return btnchips.get(1).getText();
		}
		case "ContentSize": 
		{
			explicitWait(btnchips.get(2));
			return btnchips.get(2).getText();
		}
		case "ContentSizeRange": 
		{
			explicitWait(btnchips.get(3));
			return btnchips.get(3).getText(); 
		}
		case "CreatedDate":
		{
			explicitWait(btnchips.get(2));
			if(btnchips.size()>3)
			{
			return btnchips.get(2).getText();
			}
			else
			{
			return btnchips.get(1).getText();
			}
		}
		case "Type" 
		: {
			explicitWait(btnchips.get(2));
			if(btnchips.size()>3)
			{
			return btnchips.get(2).getText();
			
			}
			else
			{
			return btnchips.get(2).getText();
			}
		}
		}
		return null;
	}

	public String getValueFromDrawer(String chip, String value) throws Exception
	{
		switch(chip)
		{
		case "ContentSizeRange":
		{
			if(value.equalsIgnoreCase("From"))
			{
			explicitWait(txtfrominput);
			return txtfrominput.getText();	
			}
			else
			{
				explicitWait(txttoinput);
				return txttoinput.getText();	
			}
		}
		case "CreatedDate": 
		{
			if(value.equalsIgnoreCase("From"))
			{
			explicitWait(txtfrominput);
			return txtfrominput.getText();	
			}
			else
			{
				explicitWait(txttoinput);
				return txttoinput.getText();	
			}
		}	
		}
		return null;
	}

	public String getChipAtIndex(int index)
	{
		explicitWait(btnchips.get(index));
		return btnchips.get(index).getText();
	}
	
	public void swipeUp() throws InterruptedException
	{ 
		        Thread.sleep(3000);
		
			  	Dimension dimension = driver.manage().window().getSize();
		    	int start_x = (int)(dimension.width*.5);
		    	int start_y = (int)(dimension.height*.96);
		    	
		    	int end_x = (int)(dimension.width*.5);
		    	int end_y = (int)(dimension.height*.35);
		    			
		    	
		    	TouchAction  action =new TouchAction(driver);
		    	action.press(PointOption.point(start_x, start_y))
		    	.waitAction(WaitOptions.waitOptions(Duration.ofMillis(2200)))
		    	.moveTo(PointOption.point(end_x, end_y))
		    	.release()
		    	.perform();	    	
		    	
	}
	
	public void selectFileChip(boolean value)
	{
		if(!isFileChecked()==value) {
		clickfilechip.click();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
		}
	}
	
	public void sendAppInBackgroundOrForeground(String value) throws Exception
	{
		if(value.equalsIgnoreCase("BackGround")) 
		{
			driver.runAppInBackground(Duration.ofSeconds(10));
			driver.manage().timeouts().implicitlyWait(8000, TimeUnit.SECONDS);
		}else if(value.equalsIgnoreCase("ForeGround")) 
		{
			//driver.launchApp();
			((StartsActivity)driver).currentActivity();
			//driver.startActivity("appPackage","com.example.android.apis", null, null);
			driver.manage().timeouts().implicitlyWait(8000, TimeUnit.SECONDS);
		}
		else
		{
			throw new Exception("Unable to send app either in background or foreground");
		}
	}
	
	public void selectFolderChip(boolean value)
	{
		if(!isFolderChecked()==value) {
			clickfolderchip.click();
			driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
			}
	}
	
	public void selectLibrariesChip(boolean value)
	{
		if(!isLibrariesChecked()==value) {
			clicklibrarieschip.click();
			driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
			}
	}
	
	public void enterTextInSearchBox(String value) {
		explicitWait(txtsearch).sendKeys(value);
		driver.navigate().back();
		explicitWait(txtsearchresultstitle.get(0));
	}
	
	public void clickClearSearch() {
		clickclearsearch.click();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
	}
	
	public void clickCollapseSearch() {
		clickcollapsesearch.click();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
	}
	
	public void clickExitSearch() {
		clickclearsearch.click();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
		clickcollapsesearch.click();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
	}
	
	public void clickimage()
	{
		clickimage.click();
		driver.manage().timeouts().implicitlyWait(150000, TimeUnit.SECONDS);
	}
	
	public void imageback()
	{
		clickimageback.click();
		driver.manage().timeouts().implicitlyWait(15000, TimeUnit.SECONDS);
	}
	
	public void populateDataOnNameChipDrawer(String value)
	{
		explicitWait(txtchiptype);
		txtinputname.sendKeys(value);
		driver.navigate().back();
		btnapply.click();
		explicitWait(btnchips.get(0));
	}
	
	public void selectValueForCheckListDrawer(String value)
	{
		explicitWait(txtchiptype);
		
		if(value.equalsIgnoreCase("Folder"))
		{
			chkfiletype.get(0).click();
		}
		else if(value.equalsIgnoreCase("Document"))
		{
			chkfiletype.get(1).click();
		}
		else
		{
			chkfiletype.get(0).click();
			chkfiletype.get(1).click();
		}
		btnapply.click();
		explicitWait(btnchips.get(0));
	}
	
	public void selectValueForContentSizeDrawer(String value)
	{
		explicitWait(txtchiptype);
		btnslider.click();
        btnapply.click();
		explicitWait(btnchips.get(2));
	}
	
	public void populateDataOnContentSizeRangeChip(String fromvalue, String tovalue)
	{
		explicitWait(txtchiptype);
		txtfrominput.sendKeys(fromvalue);
		txttoinput.sendKeys(tovalue);
		driver.navigate().back();
        btnapply.click();
		explicitWait(btnchips.get(0));
	}
	
	public void populateDataOnCreatedDateRangeChip(String fromdate, String todate) throws InterruptedException, ParseException
	{
		explicitWait(txtchiptype);
		
		String fromdate1 = dateString(fromdate);
		String todate1 = dateString(todate);
		
		txtfrominput.click();
		btneditcalenderdate.click();
		txteditdate.sendKeys(fromdate1);
		btnokcalendar.click();
		explicitWait(txtchiptype);
		
		driver.navigate().back();
		
		txttoinput.click();
		btneditcalenderdate.click();
		txteditdate.sendKeys(todate1);
		btnokcalendar.click();
		explicitWait(txtchiptype);
		
		driver.navigate().back();
	
		btnapply.click();
		Thread.sleep(2000);
	}
	
	public void selectDataOnTypeChip(String value)
	{
		if(value.equalsIgnoreCase("All"))
		{
			//btnfiletyperadio.get(1).click();
			tap(btnfiletyperadio.get(1));
		}
		else if(value.equalsIgnoreCase("Folder"))
		{
			//btnfiletyperadio.get(2).click();
			tap(btnfiletyperadio.get(2));
		}
		else if(value.equalsIgnoreCase("Document"))
		{
			//btnfiletyperadio.get(3).click();
			tap(btnfiletyperadio.get(3));
		}
		else
		{
			//btnfiletyperadio.get(0).click();
			tap(btnfiletyperadio.get(0));
		}
		    //btnapply.click();
		    tap(btnapply);
			explicitWait(btnchips.get(2));
	}
	
	public void selectValueFromAdvancedSearchDropDown(String value) throws Exception
	{
		btnexpandadvancedsearchdropdown.click();
		if(value.equalsIgnoreCase("Folder"))
		{
			explicitWait(txtadvancedsearchdropdownvalues.get(1));
			txtadvancedsearchdropdownvalues.get(0).click();
			explicitWait(btnchips.get(0));
		}
		else if(value.equalsIgnoreCase("Document"))
		{
			explicitWait(txtadvancedsearchdropdownvalues.get(0));
			txtadvancedsearchdropdownvalues.get(0).click();
			explicitWait(btnchips.get(0));
		}
		else
		{
			throw new Exception("No such option available in the advanced search dropdown");
		}
		
	}
	
    public void selectRecordFromSearch(int value) throws Exception
	{
			explicitWait(txtsearchresultstitle.get(value));
			txtsearchresultstitle.get(value).click();
	}
	
	public void swipeChipsTo(String value) throws InterruptedException {

		AndroidElement firstelement= null;
		AndroidElement nextelement = null;
		
		List<AndroidElement> carouselelements=driver.findElements(MobileBy.AndroidUIAutomator("new UiSelector().resourceId(\"com.alfresco.content.app.debug:id/chip\")"));
    	if(value.equalsIgnoreCase("Right"))
    	{
		   firstelement=carouselelements.get(1);
    	   nextelement=carouselelements.get(2);
    	}else if(value.equalsIgnoreCase("Left"))
    	{
    		firstelement=carouselelements.get(1);
    		nextelement=carouselelements.get(0);	
    	}
    							
    	int midOfY =nextelement.getLocation().y +(nextelement.getSize().height/2);
    	int fromXLocation=nextelement.getLocation().x;
    	int toXLocation=firstelement.getLocation().x;
    	
    	TouchAction  action =new TouchAction(driver);
    	action.press(PointOption.point(fromXLocation, midOfY))
    	.waitAction(WaitOptions.waitOptions(Duration.ofMillis(3000)))
    	.moveTo(PointOption.point(toXLocation, midOfY))
    	.release()
    	.perform();
    	
    	Thread.sleep(2000);
	}
	
	public void swipeChipsTo() throws InterruptedException {

		AndroidElement firstelement= null;
		AndroidElement nextelement = null;
		
		List<AndroidElement> carouselelements=driver.findElements(MobileBy.AndroidUIAutomator("new UiSelector().resourceId(\"com.alfresco.content.app.debug:id/chip\")"));

		   firstelement=carouselelements.get(1);
    	   nextelement=carouselelements.get(carouselelements.size()-1);
    							
    	int midOfY =nextelement.getLocation().y +(nextelement.getSize().height/2);
    	int fromXLocation=nextelement.getLocation().x;
    	int toXLocation=firstelement.getLocation().x;
    	
    	TouchAction  action =new TouchAction(driver);
    	action.press(PointOption.point(fromXLocation, midOfY))
    	.waitAction(WaitOptions.waitOptions(Duration.ofMillis(3000)))
    	.moveTo(PointOption.point(toXLocation, midOfY))
    	.release()
    	.perform();
    	
    	Thread.sleep(2000);
	}
	
    public void clickButton(String button) throws Exception
	{
		switch(button)
		{
		case "Apply":
		{
			btnapply.click();
             //tap(btnapply);
			break;
		}
		case "Reset": 
		{
			tap(btnreset1);
			break;
		}
		case "ResetChipsValues": 
		{
			tap(btnresetchipsvalues);
			break;
		}
		case "Cancel": 
		{
			btncancel.click();
			//tap(btncancel);
			break;
		}
		}
	}
	
	public void selectChip(String chip) throws Exception
	{
		switch(chip)
		{
		case "Name":
		{
			explicitWait(btnchips.get(0));
			btnchips.get(0).click();	
			//tap(btnchips.get(0));
			break;
		}
		case "CheckList": 
		{
			explicitWait(btnchips.get(1));
			btnchips.get(1).click();
			//tap(btnchips.get(1));
			break;
		}
		case "ContentSize": 
		{
			explicitWait(btnchips.get(2));
			btnchips.get(2).click();
			//tap(btnchips.get(2));
			break;
		}
		case "ContentSizeRange": 
		{
			explicitWait(btnchips.get(3));
			btnchips.get(3).click();
			//tap(btnchips.get(3));
			break;
		}
		case "CreatedDate":
		{
			explicitWait(btnchips.get(2));
			if(btnchips.size()>3)
			{
				btnchips.get(2).click();
				//tap(btnchips.get(2));
			}
			else
			{
				btnchips.get(1).click();
				//tap(btnchips.get(1));
			}
			break;
		}
		case "Type" 
		: {
			if(btnchips.size()>3)
			{
				explicitWait(btnchips.get(3)).click();
				//btnchips.get(3).click();
				//tap(btnchips.get(3));
			}
			else
			{
				btnchips.get(2).click();
				//tap(btnchips.get(2));
			}
			break;
		}
		}
	}
	
	public void selectChipAtIndex(int index)
	{
		explicitWait(btnchips.get(index));
		btnchips.get(index).click();	
	}
	
	public void applyChipValue(String chip, String button, String value) throws Exception
	{
		switch(chip)
		{
		case "Name":
		{
			explicitWait(txtchiptype);
			txtinputname.sendKeys(value);
			driver.navigate().back();
			
			if(button.equalsIgnoreCase("Apply"))
			{
				btnapply.click();
				//tap(btnapply);
				explicitWait(btnchips.get(0));
			}
			else if(button.equalsIgnoreCase("Reset"))
			{
				btnreset.click();
				//tap(btnreset);
				explicitWait(btnchips.get(0));
			}
			else
			{
				btncancel.click();
				//tap(btncancel);
				explicitWait(btnchips.get(0));
			}
			break;
		}
		case "CheckList": 
		{
			// Select File or Document
			//explicitWait(txtchiptype);
			
			if(value.equalsIgnoreCase("Folder"))
			{
				chkfiletype.get(0).click();
				//tap(chkfiletype.get(0));
			}
			else if(value.equalsIgnoreCase("Document"))
			{
				chkfiletype.get(1).click();
				//tap(chkfiletype.get(1));
			}
			else
			{
				chkfiletype.get(0).click();
				chkfiletype.get(1).click();
				//tap(chkfiletype.get(0));
				//tap(chkfiletype.get(1));
			}
			//driver.hideKeyboard();
			
			//Click Apply, Reset or Cancel
			if(button.equalsIgnoreCase("Apply"))
			{
				btnapply.click();
				//tap(btnapply);
				explicitWait(btnchips.get(0));
			}
			else if(button.equalsIgnoreCase("Reset"))
			{
				btnreset.click();
				//tap(btnreset);
				explicitWait(btnchips.get(1));
			}
			else
			{
				btncancel.click();
				//tap(btncancel);
				explicitWait(btnchips.get(1));
			}
			break;
		}
		
		case "ContentSize": 
		{
			//explicitWait(txtchiptype);
			btnslider.click();
			//tap(btnslider);
			//driver.hideKeyboard();
			
			if(button.equalsIgnoreCase("Apply"))
			{
				btnapply.click();
				//tap(btnapply);
				explicitWait(btnchips.get(2));
			}
			else if(button.equalsIgnoreCase("Reset"))
			{
				btnreset.click();
				explicitWait(btnchips.get(2));
			}
			else
			{
				btncancel.click();
				explicitWait(btnchips.get(2));
			}
			break;
		}
		case "ContentSizeRange": 
		{
			//explicitWait(txtchiptype);
			txtfrominput.sendKeys("0");
			txttoinput.sendKeys(value);
			driver.navigate().back();
			
			if(button.equalsIgnoreCase("Apply"))
			{
				btnapply.click();
				explicitWait(btnchips.get(3));
			}
			else if(button.equalsIgnoreCase("Reset"))
			{
				btnreset.click();
				explicitWait(btnchips.get(3));
			}
			else
			{
				btncancel.click();
				explicitWait(btnchips.get(3));
			}
			break;
		}
		case "CreatedDate":
		{
			//explicitWait(txtchiptype);
			
			String fromdate = dateString(value);
			String todate = dateString("0");
			
			txtfrominput.click();
			btneditcalenderdate.click();
			txteditdate.sendKeys(fromdate);
			driver.navigate().back();
			Thread.sleep(2000);
			btnokcalendar.click();
			explicitWait(txtchiptype);
			
			
			txttoinput.click();
			btneditcalenderdate.click();
			txteditdate.sendKeys(todate);
			driver.navigate().back();
			Thread.sleep(2000);
			btnokcalendar.click();
			explicitWait(txtchiptype);
			
			if(button.equalsIgnoreCase("Apply")) 
			{	
				btnapply.click();
				Thread.sleep(2000);
			}
			else if(button.equalsIgnoreCase("Reset"))
			{
				btnreset.click();
				Thread.sleep(2000);
			}
			else
			{
				btncancel.click();
				Thread.sleep(2000);
			}
			break;
		}
		case "Type" :
		{   
			// Select file, folder or document
			if(value.equalsIgnoreCase("All"))
			{
				explicitWait(btnfiletyperadio.get(1)).click();
				//btnfiletyperadio.get(1).click();
				//tap(btnfiletyperadio.get(1));
			}
			else if(value.equalsIgnoreCase("Folder"))
			{
				explicitWait(btnfiletyperadio.get(2)).click();
				//btnfiletyperadio.get(2).click();
				//tap(btnfiletyperadio.get(2));
			}
			else if(value.equalsIgnoreCase("Document"))
			{
				explicitWait(btnfiletyperadio.get(3)).click();
				//btnfiletyperadio.get(3).click();
				//tap(btnfiletyperadio.get(3));
			}
			else
			{
				explicitWait(btnfiletyperadio.get(0)).click();
				//btnfiletyperadio.get(0).click();
				//tap(btnfiletyperadio.get(0));
			}
			
			// Click Apply, Reset or Cancel
			if(button.equalsIgnoreCase("Apply"))
			{
				explicitWait(btnapply).click();
				//btnapply.click();
				//tap(btnapply);
				explicitWait(btnchips.get(2));
			}
			else if(button.equalsIgnoreCase("Reset"))
			{
				explicitWait(btnreset).click();
				//btnreset.click();
				//tap(btnreset);
				explicitWait(btnchips.get(2));
			}
			else
			{
				btncancel.click();
				//tap(btncancel);
				explicitWait(btnchips.get(2));
			}
			break;
		}
		}
	}
		
	public RecentPage searchBack() throws InterruptedException
	{
		driver.hideKeyboard();
		Thread.sleep(5000);
		clickrecent.click();
		Thread.sleep(5000);
		driver.manage().timeouts().implicitlyWait(15000, TimeUnit.SECONDS);

		return recent= new RecentPage();
	}
}