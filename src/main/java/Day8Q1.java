import org.openqa.selenium.WebElement;

public class Day8Q1 extends BaseClass {

	public static void main(String[] args) {
		
		launchBrowser();
		maximize();
		deleteCockies();
		loadUrl("http://demo.automationtesting.in/Alerts.html");
		pageLoadTime(20);
		WebElement alertbox =getElement("//button[contains(text(),'    click the button to display an  alert box:')]");
		clickElement(alertbox);
		String msg =captureAlertMsg();
		System.out.println(msg);
		acceptAlert();
		
		
		
				
	}

}
