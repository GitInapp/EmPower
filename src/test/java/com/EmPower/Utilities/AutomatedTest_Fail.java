package com.EmPower.Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import testlink.api.java.client.TestLinkAPIResults;

import com.EmPower.BaseUtility.Testlink_Integration;


public class AutomatedTest_Fail extends Testlink_Integration{

	 static WebDriver driver;
	 
	 
	 @BeforeTest
	 public void setup() throws Exception
	 {
		 ChromeOptions options = new ChromeOptions();
			options.addArguments("chrome.switches","--disable-extensions");
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/browser-drivers/chromedriver.exe");
			driver = new ChromeDriver(options);
			
			driver.manage().window().maximize();
	  
	    
	     
	     Thread.sleep(1000);
			
			driver.get("https://accounts.google.com");

	     
	 }
	 
	 @AfterTest
	 public void closeBrowser()
	 {
	  System.out.println("Check Results");
	  driver.close();
	 }
	 
	 @Test
	 public void testFail () throws Exception{
	  
	  String result=null;
	  String msg=null;
	  
	  try{
	  
	   
	  
	   WebElement message = driver.findElement(By.cssSelector("r2.hidden-small"));
		  
	   if(message.isDisplayed()==false){
		   
		   System.out.println("Failed: Text do not match");
		   result = TestLinkAPIResults.TEST_FAILED;		   
	   } else{
		   System.out.println("Passed");
		   result = TestLinkAPIResults.TEST_PASSED;
	    }}
	  catch(Exception e){
	   result = TestLinkAPIResults.TEST_FAILED;
	   msg = e.getMessage();
	   e.printStackTrace();
	  }
	  
	  finally{
		  Testlink_Integration.reportTestCaseResult(PROJECTNAME, TESTPLANNAME,TESTCASENAME, BUILDNAME, msg, result);
	  } 
	 } 
	}