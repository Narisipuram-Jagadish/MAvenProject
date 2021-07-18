package Org.test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class findProducts {
	
	  public static WebDriver driver;    
		@BeforeMethod
		public void setUp(){
	    	
			System.setProperty("webdriver.chrome.driver","B:\\Eclipse\\Selenium\\chromedriver.exe");		
			driver = new ChromeDriver(); 
			driver.manage().deleteAllCookies();
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.get("https://www.amazon.in/");  

		}
		@Test(priority=1)
		public void printingproducts() throws InterruptedException{
			

			driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).click();
			driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Dell Laptop");
			Thread.sleep(20000);
			driver.findElement(By.xpath("//input[@type='submit'][@value='Go']")).click();
			
			List<WebElement> products= 
					driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
			
			List<WebElement> productCost= driver.findElements(By.xpath("//span[@class='a-price-whole']"));

			//HashMap<WebElement,WebElement> hm = new HashMap<WebElement,WebElement>();

			 Set<String> hSet = new HashSet<String>(); 
			 
			 System.out.println("Total Products : "+products.size()+"\n");
			
			 
			for (WebElement option : products) 
			{
				
				String productName=option.getText();
				
				hSet.add(productName);	
			}
			
			
			
			System.out.println("Products without duplicates : "+hSet.size()+"\n");
			
			Iterator<String> i=hSet.iterator();
			while(i.hasNext()) {
				System.out.println(i.next());
			}
			
			System.out.println("Costs of products greater than 50000\n");
			
			for (WebElement cost : productCost) {
				
				String Cost=cost.getText();
				
				Cost = Cost.replace(",","");
				//System.out.println(Cost);
				int productValue=Integer.parseInt(Cost);  
				//System.out.println(productValue);
				if (productValue>50000) {
					System.out.println(productValue);
				}
			}	
		
		}	
}
