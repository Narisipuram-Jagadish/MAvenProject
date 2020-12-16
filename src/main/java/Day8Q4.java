
public class Day8Q4 extends BaseClass{

	public static void main(String[] args) {
		launchBrowser();
		maximize();
		deleteCockies();
		pageLoadTime(20);
		loadUrl("https://netbanking.hdfcbank.com/netbanking/?_ga=2.176378149.1819882415.1533883212-608727520.1532670997");
		StaticWait(2000) ;
		RobotPressTab();
		StaticWait(1500) ;
		RobotPressEnter();
		String msg =captureAlertMsg();
		System.out.println(msg);
		acceptAlert();
	}

}
