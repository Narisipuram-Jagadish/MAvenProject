package Org.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class Comtestngpractice2
{
	
		WebDriver driver;
		SoftAssert softAssert = new SoftAssert ();
	
		@BeforeMethod
		public void setup() {
		
			System.setProperty("webdriver.chrome.driver", "B:\\Eclipse\\Selenium\\chromedriver.exe");
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
			String URL="https://www.facebook.com/login.php";
			driver.get(URL);
		}
	
		@Test(priority=1)
		public void checktheloginpage() 
		{
		String expected="Log in to Facebook | Facebook";
		String Actual=driver.getTitle();
		Assert.assertEquals(Actual,expected);
		}
		
		@Test(priority=2 , retryAnalyzer=TestAnalyzer.FailedTests.class)
		public void verfyinglink() throws InterruptedException
		{
			driver.findElement(By.id("forgot-password-link")).click();
			Thread.sleep(3000);
			WebElement driv=driver.findElement(By.className("uiHeaderTitle"));
			
			boolean b	=driv.isDisplayed();
			softAssert.assertEquals(false, b,"forgot-password-link is not found");
			System.out.println(b);		
		}
		
		@Test(priority=3 ,invocationCount=2)
		public void Facebooklink() 
		{
			WebElement Fblink=driver.findElement(By.xpath("//*[@id=\"blueBarDOMInspector\"]/div/div[1]/div/div/h1/a/i"));
			Fblink.click();
			WebElement u=driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div/div[2]/div[1]/div[1]/span"));
			boolean a=u.isDisplayed();
			System.out.println(a);
		
		}
		
		@Test(priority=4 ,retryAnalyzer=TestAnalyzer.FailedTests.class)
		public void  SignupforFacebook()
		{
		driver.findElement(By.xpath("//*[@id=\"reg-link\"]")).click();
		WebElement f=driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div[1]/div[1]"));
		boolean j=f.isDisplayed();
		System.out.println(j);
		}
		
		@Test(priority=5)
		public void buttoncheck()
		{
			driver.findElement(By.id("loginbutton")).click();
			WebElement k=driver.findElement(By.xpath("//*[@id=\"login_link\"]/div[1]/a"));
			System.out.println(k);
			System.out.println(k.isDisplayed());
			softAssert.assertEquals(false, k);
			
			System.out.println(k);
			System.out.println(k);
			softAssert.assertAll();
			
		}
		
		@Test(priority=6)
		public void CreateNewAccountButtonCheck()
		{
		driver.findElement(By.xpath("//*[@id=\"blueBarDOMInspector\"]/div/div[2]/div/div/span/a")).click();
		
		WebElement w=driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div[1]/div[2]"));
		boolean r=w.isDisplayed();
		System.out.println(r);
		
		}
		
		@AfterMethod
		public void CloseBrowser() 
		{
			driver.close();
		}
		
					
}