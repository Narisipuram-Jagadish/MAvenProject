import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Day4Q1 extends BaseClass {

	public static void main(String[] args) {
		launchBrowser();
		maximize();
		loadUrl("http://www.greenstechnologys.com");
		WebElement text =driver.findElement(By.xpath("//span[@class=\"blue_text\"]//u"));
		JSScrollIntoViewDown(text);
		System.out.println(text.getText());
		}

}
