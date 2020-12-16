import org.openqa.selenium.WebElement;

public class Day8Q6 extends BaseClass {

	public static void main(String[] args) {
		
		launchBrowser();
		maximize();
		deleteCockies();
		pageLoadTime(20);
		loadUrl("https://retail.onlinesbi.com/retail/login.htm");
		WebElement Continue =getElement("//a[text()='CONTINUE TO LOGIN']");
		clickElement(Continue);
		
		WebElement Login =getElement("//input[@type='submit']");
		clickElement(Login);
		
		String msg =captureAlertMsg();
		System.out.println(msg);
		acceptAlert();

		
		
		
	}

}
