package com.test;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Logintest {

	
	WebDriver driver;
	Logger logger=Logger.getLogger(Logintest.class);
	
	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver","C:/Users/Bigyandutt Panda/Desktop/Chromedriver/Chromedriver.exe");		
		driver = new ChromeDriver(); 
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
		
		driver.get("https://classic.crmpro.com/index.html");
	}

	@Test(priority=1)
	public void freeCrmTitleTest(){
		
		String title = driver.getTitle();
		System.out.println(title);
		
		Assert.assertEquals(title,"CRMPRO  - CRM software for customer relationship management, sales, and support.");
	}
	
	@Test(priority=2)
	public void freemCRMLogoTest(){
		boolean b = driver.findElement(By.xpath("//img[@class='img-responsive']")).isDisplayed();
		Assert.assertTrue(b);
	}

	
	
	
	
	
	
	
	
	
	
	
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}


}