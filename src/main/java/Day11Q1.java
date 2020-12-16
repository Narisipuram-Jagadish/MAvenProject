import org.openqa.selenium.WebElement;

public class Day11Q1 extends BaseClass {

	public static void main(String[] args) {

		launchBrowser();
		maximize();
		deleteCockies();
		pageLoadTime(20);
		loadUrl("http://demo.guru99.com/test/write-xpath-table.html");
		
		StaticWait(6000) ;
		for (int row =0;row<=1;row++) {
			for (int column=0;column<=1;column++) {
				
				WebElement data =getElement("//tbody/tr["+row+"]["+column+"]");
				System.out.println(data.getText());
			}
		}
		
	}

}
