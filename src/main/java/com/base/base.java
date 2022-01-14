package com.base;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import javax.imageio.ImageIO;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecuteResultHandler;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.io.FileUtils;

 public class base{
	 
	public static ITestResult result;
	public static AndroidDriver<AndroidElement>  driver;
	public static AppiumDriverLocalService service;
	public static AppiumServiceBuilder builder;
	public static DesiredCapabilities caps;
	
	/*
	public static  AndroidDriver<AndroidElement> capabilities() throws MalformedURLException
	{	
		  DesiredCapabilities caps = new DesiredCapabilities();
	     
		  caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Sam8");
		  caps.setCapability("platformName", "Android");
		  caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
	      caps.setCapability("appPackage", "com.alfresco.content.app.debug");
	      caps.setCapability("appActivity", "com.alfresco.content.app.activity.SplashActivity");
	     
	     driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
	     return driver;   
	}
	*/
	
	public static  AndroidDriver<AndroidElement> capabilities() throws MalformedURLException
	{	 
		DesiredCapabilities caps = new DesiredCapabilities();
	     
		    caps.setCapability("browserstack.user", "sanjaychoudhary_zGLA7a");
	    	caps.setCapability("browserstack.key", "atB7VfntyDAtPBgjNP2P");
	    	caps.setCapability("app", "bs://a6b1c55d8be01b352127efe495cde8007340a918");
	    	caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 10000);

	    	caps.setCapability("browserstack.idleTimeout", 30);
	        caps.setCapability("device", "Samsung Galaxy S21 Plus");
	        caps.setCapability("os_version", "11.0");
	        caps.setCapability("project", "First Java Project");
	    	caps.setCapability("build", "browserstack-build-17");
	    	caps.setCapability("name","TCS->1-13");    
	    	
	        driver = new AndroidDriver<AndroidElement>(new URL("http://hub.browserstack.com/wd/hub"), caps);
	        return driver;   
	}
	

	public AppiumDriverLocalService startServer1()
	{
		boolean isServerRunning = checkIfServerIsRunning(4723);
		if(!isServerRunning) {
		AppiumDriverLocalService.buildDefaultService();
		service.start();
		}
		return service;
	}
	
	public static boolean checkIfServerIsRunning(int port) {
		
		boolean isServerRunning = false;
		ServerSocket serverSocket;
		try {
			serverSocket = new ServerSocket(port);
			serverSocket.close();
		}catch(IOException e) {
			isServerRunning = true;
		}finally {
			serverSocket=null;
		}
		return isServerRunning;
	}
	
	public void appiumServerStart() {

        //Build the Appium service
                builder = new AppiumServiceBuilder();
                builder.withIPAddress("127.0.0.1"); 
                //127.0.0.1 is the  localhost normally resolves to the IPv4  127.0.0.1
                builder.usingPort(4723); //Appium default port
                builder.withCapabilities(caps);
                builder.withArgument(GeneralServerFlag.SESSION_OVERRIDE);
                builder.withArgument(GeneralServerFlag.LOG_LEVEL,"error");

                //Start the server with the builder
                service = AppiumDriverLocalService.buildService(builder);
                service.start();
                System.out.println("Appium Server Started via Java");
    }
	
	public void startServer() {
	    CommandLine cmd = new CommandLine("C:\\Program Files (x86)\\Appium\\node.exe");
	    cmd.addArgument("C:\\Program Files (x86)\\Appium\\node_modules\\appium\\bin\\Appium.js");
	    cmd.addArgument("--address");
	    cmd.addArgument("127.0.0.1");
	    cmd.addArgument("--port");
	    cmd.addArgument("4723");
	

	    DefaultExecuteResultHandler handler = new DefaultExecuteResultHandler();
	    DefaultExecutor executor = new DefaultExecutor();
	    executor.setExitValue(1);
	    try {
	        executor.execute(cmd, handler);
	        Thread.sleep(10000);
	    } catch (IOException | InterruptedException e) {
	        e.printStackTrace();
	    }
	}
	
	public static void startEmulator() throws IOException, InterruptedException {
		 
		Runtime.getRuntime().exec(System.getProperty("user.dir") + "\\src\\main\\java\\resources\\startEmulator.bat");
		Thread.sleep(6000);
	}
	
    public static void SwitchContext() throws InterruptedException
    {
    	Set<String> ids =driver.getContextHandles();
    	
    	for(String id : ids)
    	{
    		if(id.equalsIgnoreCase("WEBVIEW_com.androidsample.generalstore"))
    		{
               System.out.println(id);
    		
    		Thread.sleep(7000);
    		}
    	}
    	driver.context("NATIVE_APP");
    }

    public static String GetProperty(String Value)
    {		
    	File file = new File("C:\\Users\\Global\\eclipse-workspace\\MobileApss.AndriodFramework\\src\\main\\java\\com\\Config\\Property");
		FileInputStream fileInput = null;
		try {
			fileInput = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Properties prop = new Properties();
		
		//load properties file
		try {
			prop.load(fileInput);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop.getProperty(Value);
    }

    public static String dateString(String dateString, int day) throws ParseException 
       {
        DateFormat dateFormat = new SimpleDateFormat(dateString);
        Date myDate = new Date();

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(myDate);
        calendar.add(Calendar.DAY_OF_YEAR, day);

        Date manuplateddate = calendar.getTime();
        String result = dateFormat.format(manuplateddate);

        return result;
    }
    
    public static String dateString(String value) throws ParseException 
    {
     DateFormat dateFormat = new SimpleDateFormat("MM/dd/yy");
     Date myDate = new Date();

     Calendar calendar = Calendar.getInstance();
     calendar.setTime(myDate);
     int day = Integer.parseInt(value);
     calendar.add(Calendar.DAY_OF_YEAR, day);

     Date manuplateddate = calendar.getTime();
     String result = dateFormat.format(manuplateddate);

     return result;
 }
    
    public static String dateString(String value, String dateformat) throws ParseException 
    {
    	Date date = new SimpleDateFormat(dateformat).parse(value);
        String returndate = new SimpleDateFormat(dateformat).format(date);
        return returndate;
 }
    
    public static void verifyImage(String image1, String image2) throws IOException{
        File fileInput = new File(image1);
        File fileOutPut = new File(image2);

        BufferedImage bufileInput = ImageIO.read(fileInput);
        DataBuffer dafileInput = bufileInput.getData().getDataBuffer();
        int sizefileInput = dafileInput.getSize();  
        double sizefileInput1 = (double)sizefileInput;
        BufferedImage bufileOutPut = ImageIO.read(fileOutPut);
        DataBuffer dafileOutPut = bufileOutPut.getData().getDataBuffer();
        int sizefileOutPut = dafileOutPut.getSize();
        double sizefileOutPut1 = sizefileOutPut*.46;
        Boolean matchFlag = true;
        if(sizefileInput1 == sizefileOutPut1) {                         
           for(int j=0; j<sizefileInput1; j++) {
                 if(dafileInput.getElem(j) != dafileOutPut.getElem(j)) {
                       matchFlag = false;
                       break;
                 }
            }
        }
        else                            
           matchFlag = false;
        Assert.assertTrue(matchFlag, "Images are not same");    
     }
    
    public static void CaptureScreenShot() throws IOException {    

        File screen = ((TakesScreenshot) driver)
                            .getScreenshotAs(OutputType.FILE);
        WebElement  image = driver.findElementByClassName("android.widget.FrameLayout");
       
        
        Point point = image.getLocation();

        int width = image.getSize().getWidth();
        int height = image.getSize().getHeight();

        BufferedImage img = ImageIO.read(screen);
        BufferedImage dest = img.getSubimage(point.getX(), point.getY(), width,height);                                                                
        ImageIO.write(dest, "png", screen);
        File file = new File("Recent.png");
        FileUtils.copyFile(screen, file);

    }
    
    public static void testImageComparison() throws IOException, InterruptedException {         
        //File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        //Thread.sleep(3000);
        //FileUtils.copyFile(screenshot, new File("Menu2.png"));

         File fileInput = new File("sample");
         File fileOutPut = new File("Menu.png");

         BufferedImage bufferfileInput = ImageIO.read(fileInput);
         DataBuffer datafileInput = bufferfileInput.getData().getDataBuffer();
         int sizefileInput = datafileInput.getSize();     
         System.out.println(sizefileInput);
         BufferedImage bufferfileOutPut = ImageIO.read(fileOutPut);
         DataBuffer datafileOutPut = bufferfileOutPut.getData().getDataBuffer();
         int sizefileOutPut = datafileOutPut.getSize();
         System.out.println(sizefileOutPut);
         Boolean matchFlag = true;
         if(sizefileInput == sizefileOutPut) {                         
            for(int i=0; i<sizefileInput; i++) {
                  if(datafileInput.getElem(i) != datafileOutPut.getElem(i)) {
                        matchFlag = false;
                        break;
                  }
             }
         }
         else {                           
            matchFlag = false;
         Assert.assertTrue(matchFlag, "Images are not same");    
      }
 }

    public static void tap(WebElement ele)
    {
    	TouchAction action = new TouchAction(driver);
		action.tap(tapOptions().withElement(element(ele))).perform().release();
	}
    
    
    public static void scroll(String scrollableList, String elementClassName, String anytext,AndroidDriver<AndroidElement> driver)
	{
	try {
	    driver.findElement(MobileBy.AndroidUIAutomator(
	                    "new UiScrollable(new UiSelector().resourceId(\"" + scrollableList + "\")).getChildByText("
	                            + "new UiSelector().className(\"" + elementClassName + "\"), \"" + anytext + "\")"));
	    }catch (Exception e){
	            System.out.println("Cannot scroll further");
	    }
	}
 
    public MobileElement explicitWait(MobileElement element) {
    	WebDriverWait wait = new WebDriverWait(driver, 20);
        return (MobileElement)wait.until(ExpectedConditions.visibilityOf(element));
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
   }
