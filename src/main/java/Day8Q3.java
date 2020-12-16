import org.openqa.selenium.WebElement;

public class Day8Q3 extends BaseClass {

	public static void main(String[] args) {
		launchBrowser();
		maximize();
		deleteCockies();
		loadUrl("http://demo.automationtesting.in/Alerts.html");
		pageLoadTime(20);
		WebElement AlertwithText =getElement("//a[(text()='Alert with Textbox ')]");
		clickElement(AlertwithText);
		WebElement promptbox =getElement("//button[contains(text(),'click the button to demonstrate the prompt box ')]");
		clickElement(promptbox);
		sendTextToAlert("Jagadeesh Automation Star");
		acceptAlert();
		WebElement displayMsg =getElement("//p[@id='demo1']");
		System.out.println(displayMsg.getText());
	
	}
}
