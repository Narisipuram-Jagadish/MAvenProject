import org.openqa.selenium.WebElement;

public class Day8Q8 extends BaseClass{

	public static void main(String[] args) {

		launchBrowser();
		maximize();
		deleteCockies();
		pageLoadTime(20);
		loadUrl("https://infinity.icicibank.com/corp/AuthenticationController;jsessionid=0000VNBmASRYu_JzpDdc8YvQhKY:R29p12wmv?bwayparam=kTGRJrOsbb4KdyudaHsb0pj1%2Ff8opyPrV%2BpSi0eIN7A%3D");
		WebElement uname =getElement("//input[@type='text'][@title='User Id']");
		clickElement(uname);
		


	}

}
