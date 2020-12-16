import org.openqa.selenium.WebElement;

public class Day8Q5 extends BaseClass{

	public static void main(String[] args) {

		launchBrowser();
		maximize();
		deleteCockies();
		pageLoadTime(20);
		loadUrl("https://netbanking.canarabank.in/entry/ENULogin.jsp");
		WebElement SignIn =getElement("//input[@type='submit'][@value='SIGN IN']");
		SignIn.click();
		String msg =captureAlertMsg();
		System.out.println(msg);
		acceptAlert();
	}
}
