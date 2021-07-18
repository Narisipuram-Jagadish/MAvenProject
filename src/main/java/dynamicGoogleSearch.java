import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class dynamicGoogleSearch extends BaseClass{

	public static void main(String[] args) {

		launchBrowser();
		maximize();
		deleteCockies();
		pageLoadTime(20);
		loadUrl("https://www.google.com/");
		
		WebElement searchBox =driver.findElement(By.xpath("//input[@type='text'][@name='q']"));
		searchBox.click();
		searchBox.sendKeys("testing");
		StaticWait(2500);
		
		List<WebElement> list =driver.findElements(By.xpath("//ul[@role='listbox']/li/descendant :: div[@class='sbl1']/span/b"));
		
		System.out.println("Total no of suggetions in search box is : "+list.size());
		
		for (int i=0;i<list.size();i++) {
			System.out.println(list.get(i).getText());
			if(list.get(i).getText().contains("hypothesis")) {
				list.get(i).click();
				break;
			}
		}
		
	}

}
