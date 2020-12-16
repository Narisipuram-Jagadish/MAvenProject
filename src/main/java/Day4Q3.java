import org.openqa.selenium.WebElement;

public class Day4Q3 extends BaseClass {

	public static void main(String[] args) {
		launchBrowser();
		maximize();
		loadUrl("http://greenstech.in/selenium-course-content.html");
		String addr ="Adyar";
		WebElement address = getElement("//span[contains(text(),'"+addr+"')][@class='sub-title']//parent::h6//following-sibling::ul");
		JSScrollIntoViewDown(address);
		//JSScrollIntoViewUp(address);
		System.out.println(address.getText());
		}

	

}
