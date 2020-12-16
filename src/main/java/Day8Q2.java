import org.openqa.selenium.WebElement;

public class Day8Q2 extends BaseClass{

	public static void main(String[] args) {
		launchBrowser();
		maximize();
		deleteCockies();
		loadUrl("http://demo.automationtesting.in/Alerts.html");
		pageLoadTime(20);
		WebElement OKAndCancel =getElement("//a[(text()='Alert with OK & Cancel ')]");
		clickElement(OKAndCancel);
		WebElement confirmbox =getElement("//button[contains(text(),'click the button to display a confirm box ')]");
		clickElement(confirmbox);
		String msg =captureAlertMsg();
		System.out.println(msg);
		acceptAlert();
		
		WebElement displayMsg =getElement("//p[@id='demo']");
		System.out.println(displayMsg.getText());

		
	}

}
