package Org.testcases;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class testTesseract {
	WebDriver driver;

	@Test
	public void Approve() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "B:\\Eclipse\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
		driver.get("http://qatesseract.shoresandbox.com/Login/Login/");
		WebElement loginEmail = driver.findElement(By.id("txtEmail"));
		loginEmail.clear();
		loginEmail.click();
		loginEmail.sendKeys("tesseract.automation@shoregrp.com");
		WebElement loginpwd = driver.findElement(By.id("Password_hash"));

		loginpwd.clear();
		loginpwd.click();
		loginpwd.sendKeys("Shore@123");
		WebElement loginbutton = driver.findElement(By.name("btnTesseractLogin"));
        loginbutton.click();
		Thread.sleep(3000);
		
	    Actions actions= new Actions(driver);
	    WebElement Taskmanagement1=driver.findElement(By.name("taskMgt"));
		actions.moveToElement(Taskmanagement1).perform();
		Thread.sleep(3000);
		WebElement project=driver.findElement(By.name("records"));
		Thread.sleep(9000);
		project.click();
		Thread.sleep(4000);
		Select drpSelectproject=new Select(driver.findElement(By.xpath("//*[@id=\"grid_hide\"]/div[2]/div/select")));
		List<WebElement> e=drpSelectproject.getOptions();
		
		Thread.sleep(4000);
		drpSelectproject.selectByVisibleText("Open Payments");
		Thread.sleep(4000);
		Actions actions1=new Actions(driver);
		WebElement EM=driver.findElement(By.xpath("//*[contains(@ng-disabled,'vm.entityMatchingBtn')]"));
		actions1.moveToElement(EM).perform();
		EM.click();
		Thread.sleep(20000);
		ArrayList<WebElement> no_of_rows = (ArrayList<WebElement>)driver.findElements(By.xpath("//div[@ref='eBodyContainer']/div"));
		int Rows=no_of_rows.size() - 1;
		
		Thread.sleep(15000);
		WebElement status=driver.findElement(By.xpath("//div[@row-id='0']/div[6]"));
		System.out.println(status.getText());
		WebElement no_of_pending_records=driver.findElement(By.xpath("//div[@row-id='0']/div[8]"));
		String no_of_pending_records_before= no_of_pending_records.getText();
		int no_of_pending_records_before_approved=Integer.parseInt(no_of_pending_records.getText());
		System.out.println(no_of_pending_records_before_approved);

		WebElement ApprovedQaBefore=driver.findElement(By.xpath("//div[@row-id='0']/div[9]"));
		
		int ApprovedQaPendingBefore=Integer.parseInt(ApprovedQaBefore.getText());
		
		System.out.println(ApprovedQaPendingBefore);
		
		// if (status.getText().equalsIgnoreCase("Active"))
		// {
		Thread.sleep(4000);
		driver.findElement(
		By.xpath("//div[@ref='eBodyContainer']/div[@row-id='0']/div[8]/child-cell/span/a"))
		.click();
		Thread.sleep(20000);
		
		ArrayList<WebElement> no_of_rows1= (ArrayList<WebElement>)
				
				driver.findElements(By.xpath("//div[@ref='eBodyContainer']/div"));
		
		Thread.sleep(20000);
		int no_of_row=no_of_rows1.size();
		System.out.println(no_of_row);
		Thread.sleep(20000);
		
		WebElement sourceid=driver.findElement(By.xpath("//div[@ref='eBodyContainer']/div[9]/div[@col-id='sourceid']"));
		Thread.sleep(9000);
		sourceid.click();
		System.out.println(sourceid.getText());
		Thread.sleep(20000);
		Actions actions9=new Actions(driver);
		WebElement back=driver.findElement(By.xpath("((//i[@class='fa fa-arrow-right'])[2]"));
		actions9.moveToElement(back).build().perform();
		Thread.sleep(20000);
		back.click();
		WebElement npi= driver.findElement(By.xpath("//div[@ref='eBodyContainer']/div[9]/div[@col-id='npi']"));
		Thread.sleep(9000);
		System.out.println(npi.getText());
		
		Actions actions8= new Actions(driver);
		WebElement back1=driver.findElement(By.xpath("(//i[@class='fa fa-arrow-right'])[3]"));
		actions8.moveToElement(back).build().perform();
		Thread.sleep(20000);
		back1.click();
		
		Thread.sleep(30000);
		
		driver.findElement(By.xpath("//div[@ref='eBodyContainer']/div[9]/div[@col-id='Approve']/span")).click();
		Thread.sleep(40000);
		
		Actions actions7=new Actions(driver);
		WebElement back2=driver.findElement(By.name("save"));
		actions8.moveToElement(back).build().perform();
		Thread.sleep(30000);
		back2.click();
		
		Thread.sleep(40000);
		
		driver.findElement(By.xpath("//textarea[@placeholder='Comments:']")).click();
		driver.findElement(By.xpath("//textarea[@placeholder='Comments:']")).sendKeys("Approved123");
		Thread.sleep(40000);
		driver.findElement(By.xpath("//button[@class='btn btn-success']")).click();
		
		Thread.sleep(60000);
		driver.findElement(By.xpath("//a[@title='Back to Previous']")).click();
		Thread.sleep(30000);
		
		WebElement no_of_pending_records1=driver.findElement(By.xpath("//div[@row-id='0']/div[8]"));
		
		int no_of_pending_records_after_approved=Integer.parseInt(no_of_pending_records1.getText());
		
		System.out.println(no_of_pending_records_after_approved);
		
		WebElement ApprovedQa=driver.findElement(By.xpath("//div[@row-id='0']/div[9]"));
		
		int ApprovedQaPending=Integer.parseInt(ApprovedQa.getText());
		
		System.out.println(ApprovedQaPending);
		
		Assert.assertEquals(no_of_pending_records_before_approved,no_of_pending_records_after_approved+1," pass");
		}
	
	}

