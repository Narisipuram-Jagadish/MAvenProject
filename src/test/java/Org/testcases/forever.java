package Org.testcases;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import library.Utility;

public class forever 
{
	WebDriver driver;

	@BeforeMethod
	public void BrowserLaunch() {
		System.setProperty("webdriver.chrome.driver", "B:\\Eclipse\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("SetUp done");
	}
	
	@Test(priority=1)
	public void LoginForever() throws InterruptedException {
	
		driver.get("https://fbosite.foreverliving.com/distribNew/Login.do?store=IND");
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		System.out.println("Login Successful");	
		Utility.captureScreenshot(driver,"Forever");
	}
	@Test(priority=2)
	
	public void LoginYouTube() throws InterruptedException {
		driver.get("https://www.youtube.com/");
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		System.out.println("Login Successful");	
		Utility.captureScreenshot(driver,"YouTube");
	}
	
	@AfterMethod
	public void closebrowser() {
		
		driver.manage().deleteAllCookies();
		driver.close();
		System.out.println("Close Browser");	
	}

	
}
