package Org.testcases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class loadalllinks {

	WebDriver driver;
	
	@AfterMethod
	public void Logout() {
		
		driver.findElement(By.linkText("LOGOUT")).click();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		System.out.println("Logout Successful");
		
	}
	
	@Test(priority=1 ,expectedExceptions =java.lang.IndexOutOfBoundsException.class)
	public void  getAllLinks() {
		
				
		List<WebElement> allLinks =  driver.findElements(By.tagName("a"));
		
		System.out.println(allLinks.size());
		
		System.out.println("link "+allLinks.get(5).getAttribute("href"));
		
		for (WebElement q:allLinks ) {
			
			q.getText();
			
		}
		System.out.println(allLinks.get(108).getText());
		
		System.out.println("link "+allLinks.get(5).getAttribute("href"));
		
		
	}
	
	@BeforeTest
	public void BrowserLaunch() {
		System.setProperty("webdriver.chrome.driver", "B:\\Eclipse\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("SetUp done");
	}
	
	@BeforeMethod
	public void Login() throws InterruptedException {
		
		driver.get("https://fbosite.foreverliving.com/distribNew/Login.do?store=IND");
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.findElement(By.name("username")).click();
		driver.findElement(By.name("username")).sendKeys("910900015941");
		driver.findElement(By.name("password")).sendKeys("Seshu@123");
		driver.findElement(By.name("password")).submit();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		//driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		Thread.sleep(3500);
		System.out.println("Login Successful");

	}
	
	@AfterClass
	public void closebrowser() {
		
		driver.manage().deleteAllCookies();
		driver.close();
		System.out.println("Close Browser");
		
	}
}
