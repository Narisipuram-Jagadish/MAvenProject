package Org.testcases;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNGParameters {
	
    public static WebDriver driver;
    @Parameters({"browser"})
	@BeforeMethod
	public void setUp(String browserName){
    	
    	if (browserName.equalsIgnoreCase("chrome")) {
		
			System.setProperty("webdriver.chrome.driver", "B:\\Eclipse\\Selenium\\chromedriver.exe");
			driver = new ChromeDriver();
    	}
    	else if(browserName.equalsIgnoreCase("ie")) {
    		
    		System.setProperty("webdriver.ie.driver", "B:\\Eclipse\\Selenium\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
    	}
    	/*
       	else {
    		System.setProperty("webdriver.gecko.driver", "B:\\Eclipse\\Selenium\\chromedriver.exe");
			driver = new ChromeDriver();
    	}
    	*/ 	
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.get("http://adactinhotelapp.com/");	
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@Parameters({"username","password"})
	@Test(priority=1)
	public void loginTest( String uname,String pass){
		
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(uname);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(pass);
		driver.findElement(By.xpath("//input[@id='login']")).click();
	}	
}