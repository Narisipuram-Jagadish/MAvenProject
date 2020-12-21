package Org.testcases;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class forever 
{
	WebDriver driver;
	
	
	@BeforeTest
	public void BrowserLaunch() {
		System.setProperty("webdriver.chrome.driver", "B:\\Eclipse\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("SetUp done");
	}
	
	@BeforeMethod
	//@Parameters({"url"})
	//public void Login(String url) throws InterruptedException {
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
	
	@Test(priority=1)
	public void MyBusiness() {
		
		
		driver.findElement(By.linkText("MY BUSINESS")).click();
		WebElement businesstext=driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/h1[2]"));
		String chk1=businesstext.getText();
		System.out.println(chk1);
		Assert.assertEquals(chk1, "My Business");
		
		
	}
	
	@Test(priority=2 )
	public void MyShopping() {
		
		driver.findElement(By.linkText("SHOP NOW")).click();
		WebElement shop=driver.findElement(By.xpath("//*[@id=\"content\"]/div/h1"));
		String chk3=shop.getText();
		System.out.println(chk3);
		Assert.assertEquals(chk3, "Shop Now");
		
	}
	
	@Test(priority=3,invocationCount=2)
	public void MyTraining() {
		
		driver.findElement(By.linkText("TRAINING")).click();
		WebElement training=driver.findElement(By.xpath("//*[@id=\"main_text\"]/h1"));
		String chk2=training.getText();
		System.out.println(chk2);
		Assert.assertEquals(chk2, "Training");
		
	}
	
	@Test(priority=4, dependsOnMethods="MyShopping")
	public void OpenShopping() throws InterruptedException {
		
		driver.findElement(By.linkText("SHOP NOW")).click();
		
		driver.findElement(By.linkText("CLICK HERE TO SHOP ONLINE")).click();
		
		Thread.sleep(5000);
		
		WebElement shoppingopened=driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/h1"));
		Assert.assertEquals("Aloe Store India", shoppingopened.getText());
				
	}
		
	@AfterMethod
	public void Logout() {
		
		driver.findElement(By.linkText("LOGOUT")).click();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		System.out.println("Logout Successful");
		
	}
	
	@AfterClass
	public void closebrowser() {
		
		driver.manage().deleteAllCookies();
		driver.close();
		System.out.println("Close Browser");
		
	}

	
}
