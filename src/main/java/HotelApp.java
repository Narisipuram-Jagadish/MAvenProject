import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class HotelApp {

public static void main(String[] args) {
    /*
		WebDriver driver = null;
		WebDriverManager.chromedriver().setup();
		
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		    driver = new ChromeDriver(options);    
		driver.get("https://www.google.com/");
	*/
		//way 2
	
		System.setProperty("webdriver.chrome.driver", "B:\\Eclipse\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30000, TimeUnit.SECONDS);
		
		driver.get("http://adactinhotelapp.com/");
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("jagadish93");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("8143895200");
		
		driver.findElement(By.xpath("//input[@id='login']")).click();
	
		Select location=new Select(driver.findElement(By.xpath("//select[@id='location']")));
		location.selectByVisibleText("Melbourne");
		Select hotel=new Select(driver.findElement(By.xpath("//select[@id='hotels']")));
		hotel.selectByValue("Hotel Hervey");
		Select room=new Select(driver.findElement(By.xpath("//select[@id='room_type']")));//room_nos
		room.selectByVisibleText("Deluxe");
		Select roomNo=new Select(driver.findElement(By.xpath("//select[@id='room_nos']")));
		roomNo.selectByIndex(4);
		Select adultRoom=new Select(driver.findElement(By.xpath("//select[@id='adult_room']")));
		adultRoom.selectByIndex(1);
		Select childRoom=new Select(driver.findElement(By.xpath("//select[@id='child_room']")));
		childRoom.selectByIndex(4);
		driver.findElement(By.xpath("//input[@id='datepick_in']")).sendKeys("29/11/2020");
		driver.findElement(By.xpath("//input[@id='datepick_out']")).sendKeys("30/11/2020");
		driver.findElement(By.id("Submit")).click();
}

}
