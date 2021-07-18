package Org.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Org.Base.BaseClass;

@Listeners(TestListeners.TestNGListener.class)
public class screenShotOnFailure extends BaseClass{
	
	@BeforeMethod
	public void initialization() {
		launchBrowser();
		maximize();
		deleteCockies();
		pageLoadTime(20);
		loadUrl("https://amazon.in");
	}
	
	@AfterMethod
	public void teardown() {
		driver.close();
	}

	@Test
	public void searchTVS() {
		driver.findElement(By.id("twotabsearchtextbox")).click();
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Samsung TV");
		Assert.assertEquals("Expected some product", "Actual", "exact match not found");
	}
	@Test
	public void searchFurniture() {
		driver.findElement(By.id("twotabsearchtextbox")).click();
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nilkamal chairs");
		Assert.assertEquals("Expected chair", "Actual", "exact match not found");
	}
}
