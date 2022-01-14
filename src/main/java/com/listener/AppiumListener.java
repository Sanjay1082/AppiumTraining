package com.listener;

import java.net.MalformedURLException;

import org.testng.ITestListener;
import org.testng.ITestResult;
import com.base.base;

public class AppiumListener extends base implements ITestListener{

	public void onTestSuccess(ITestResult result) {
		
	}

	public void onTestFailure(ITestResult result) {
		driver.quit();
		try {
		}catch(Exception e) {	
		}
		finally{
			try {
				driver= capabilities();
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
