package com.EmPower.TestScripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class Login{
	
	static WebDriver driver;

	@Test
	public void loginApp() throws Exception {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("chrome.switches","--disable-extensions");
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/browser-drivers/chromedriver.exe");
		driver = new ChromeDriver(options);
		
		driver.manage().window().maximize();

		Thread.sleep(1000);
		
		driver.get("https://wfms.kongsberg.master.int");
		
		driver.close();

    }   
}