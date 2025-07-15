package com.yatra.automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class YatraAutomationScript2 {

	public static void main(String[] args) {
		
		//Code to disable the notifications
		ChromeOptions chromeOptions=new ChromeOptions();
		chromeOptions.addArguments("--disable-notifications");
		
		//Step 1: Initialize the webdriver
		WebDriver wd=new ChromeDriver(chromeOptions);
		
		
		//Step 2: Navigate and load the Website
		wd.get("https://www.yatra.com");
		
		//Step 3: Maximize the window
		wd.manage().window().maximize();
		
		
	}

}
