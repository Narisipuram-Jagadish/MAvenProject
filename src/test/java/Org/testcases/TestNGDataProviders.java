package Org.testcases;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Org.test.util.TestUtil;

public class TestNGDataProviders {
	
    public static WebDriver driver;
    
    @Parameters({"browser","username","password"})
	@BeforeMethod
	public void setUp(String browserName,String uname,String pass){
    	
      if (browserName.equalsIgnoreCase("chrome")) {
		
		System.setProperty("webdriver.chrome.driver", "B:\\Eclipse\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
      }
      else if(browserName.equalsIgnoreCase("ie")) {
    		
    	System.setProperty("webdriver.ie.driver", "B:\\Eclipse\\Selenium\\IEDriverServer.exe");
		driver = new InternetExplorerDriver();
     }
    	driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.get("http://adactinhotelapp.com/");	
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(uname);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(pass);
		driver.findElement(By.xpath("//input[@id='login']")).click();
	}
	    
    @DataProvider
    public Iterator<Object[]> getTestData() {
    	
    	ArrayList<Object[]> testdata = TestUtil.getDataFromExcel();
    	return testdata.iterator();
    }
    
	@Test(dataProvider="getTestData")
	public void SearchData(String Location, String Hotels, String RoomType, String NoOfRums,
			String CIDate,String CODate,String AdultsperRoom,String ChildperRoom){
		
		Select location=new Select(driver.findElement(By.xpath("//select[@id='location']")));
		location.selectByVisibleText(Location);
		
		Select hotel=new Select(driver.findElement(By.xpath("//select[@id='hotels']")));
		hotel.selectByVisibleText(Hotels);
		
		Select room=new Select(driver.findElement(By.xpath("//select[@id='room_type']")));//room_nos
		room.selectByVisibleText(RoomType);
		
		Select roomNo=new Select(driver.findElement(By.xpath("//select[@id='room_nos']")));
		roomNo.selectByVisibleText(NoOfRums);
		
		Select adultRoom=new Select(driver.findElement(By.xpath("//select[@id='adult_room']")));
		adultRoom.selectByVisibleText(AdultsperRoom);
		
		Select childRoom=new Select(driver.findElement(By.xpath("//select[@id='child_room']")));
		childRoom.selectByVisibleText(ChildperRoom);
		
		driver.findElement(By.xpath("//input[@id='datepick_in']")).sendKeys(CIDate);
		
		driver.findElement(By.xpath("//input[@id='datepick_out']")).sendKeys(CODate);
		
		driver.findElement(By.id("Submit")).click();
	}	

}

