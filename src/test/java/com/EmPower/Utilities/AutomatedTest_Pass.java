package com.EmPower.Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import testlink.api.java.client.TestLinkAPIResults;

import com.EmPower.BaseUtility.Testlink_Integration;


public class AutomatedTest_Pass extends Testlink_Integration{

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
	 public void testPass () throws Exception{
	  
	  String result=null;
	  String msg=null;
	  
	  try{
	  
		  driver.findElement(By.id("Email")).sendKeys("visitemail4");
			
			driver.findElement(By.id("next")).click();
			
			WebDriverWait wait1=new WebDriverWait(driver, 600);
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("Passwd")));

			driver.findElement(By.id("Passwd")).sendKeys("visitemail");

			driver.findElement(By.id("signIn")).click();

			driver.switchTo().defaultContent();			
	  
	   WebElement message = driver.findElement(By.cssSelector("div.Ll1RQb"));
	   
	  
	   if(message.isDisplayed()==true){
	   
		   System.out.println("Passed");
		   result = TestLinkAPIResults.TEST_PASSED;
	   } else{
	    	System.out.println("Failed: Text do not match");
		     result = TestLinkAPIResults.TEST_FAILED;
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