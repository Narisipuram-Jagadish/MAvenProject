package Org.testcases;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class amazonTest {

	WebDriver driver;
	
	@BeforeTest
	public void BrowserLaunch() {
		System.setProperty("webdriver.chrome.driver", "B:\\Eclipse\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("SetUp done");
	}
	
	@Test
	public void browser() throws InterruptedException, AWTException {
		System.out.println("open browser");
		driver.get("https://amazon.in");
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);

		
		driver.findElement(By.id("twotabsearchtextbox")).click();
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("JBL GO Speaker");
		
		Robot robot = new Robot();
		
		driver.findElement(By.xpath("//*[@id=\"nav-search\"]/form/div[2]/div/input")).click();
		
		driver.findElement(By.xpath("//*[@class='a-dropdown-prompt']")).click();
		Thread.sleep(1000);
		
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		Thread.sleep(1000);


		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);

		//*[@id='brandsRefinements']/ul/li[1]
		
		
		
		//*[@id='brandsRefinements']/ul/li[1]
		
		driver.findElement(By.xpath("//span[text()='JBL']")).click();
		
		WebElement brandSearch= driver.findElement(By.xpath("//a[@class=\"a-link-normal a-text-normal\"][1]"));
		String brandname=brandSearch.getText();
		System.out.println(brandname);
		Assert.assertEquals(brandname, "JBL");
		
		//Selecting first product in page:
		
		List<WebElement> products= driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
		System.out.println(products);
		
		String[] product = new String [products.size()];
		
		int i=0;
		
		for (WebElement alllinks :products)
		{
			
			//System.out.println(alllinks.getAttribute("href"));
			
			product[i]= alllinks.getText();
			System.out.println(product[i]);
	
			
			i++;
						 
			//Thread.sleep(100);
		
		}

		driver.findElement(By.linkText(product[1])).click();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		System.out.println(tabs);	
		
		driver.switchTo().window(tabs.get(1));

		int initialCartValue=0;
		
		WebElement productprice =driver.findElement(By.id("priceblock_ourprice"));
		System.out.println(productprice.getText());
		//String Productvalue=productprice.getText();
	//	initialCartValue=Integer.parseInt(Productvalue);
	//	System.out.println(initialCartValue);
		
		driver.findElement(By.id("add-to-cart-button")).click();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);

		
		driver.findElement(By.id("hlb-view-cart-announce")).click();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);

		
		
		String Cartvalue=driver.findElement(By.xpath("//span[@class='currencyINRFallback']")).getText();
		
		System.out.println(Cartvalue);
		
		//span[@class="currencyINRFallback"]
		System.out.println("Child title : "+driver.getTitle());

		

		driver.switchTo().window(tabs.get(0));
		System.out.println("Parent title : "+driver.getTitle());
		Thread.sleep(2500);
		
		driver.findElement(By.linkText(product[2])).click();
		
		ArrayList<String> tabs_new = new ArrayList<String>(driver.getWindowHandles());
		System.out.println(tabs_new);	
		
		
		
		
		driver.switchTo().window(tabs_new.get(2)); // blue
		System.out.println("Child2 title : "+driver.getTitle());

		
		Thread.sleep(3000);
		
		driver.switchTo().window(tabs_new.get(1)); //cart
		System.out.println("Child1 title : "+driver.getTitle());

		
		Thread.sleep(3000);
		
		driver.switchTo().window(tabs_new.get(0)); //parent

		System.out.println("Parent title : "+driver.getTitle());

		
	}
	
	@Test
	public void execute() {
		System.out.println("Execute");
	}
	
	@Test
	public void close() {
		System.out.println("close");
	}
	
}
