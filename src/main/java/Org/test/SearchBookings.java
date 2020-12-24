package Org.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Org.Base.BaseClass;
import Org.ObjectRepository.BookingIternaryPage;
import Org.ObjectRepository.Login1;
import Org.ObjectRepository.Search1;
import Org.test.util.Xls_Reader;
import Org.testdata.ReadExcel;

public class SearchBookings extends BaseClass{
	
	Login1 login;
	Search1 searchPage ;
	BookingIternaryPage booking;
	Xls_Reader reader;
	
	@BeforeMethod
	public void setUp(){
		
		launchBrowser();
		maximize();
		deleteCockies();
		pageLoadTime(30);
		loadUrl(ReadExcel.ReadData("Login", 1, 0));
		
		login= new Login1();
		
		sendDataByXpath(login.getLogin().get(0), ReadExcel.ReadData("Login", 1, 1));
		sendDataByXpath(login.getLogin().get(1),ReadExcel.ReadData("Login", 1, 2));
		clickElement(login.getLoginButton());
	}
	
	@Test(priority=1)
	public void SearchBooking(){
		
		booking= new BookingIternaryPage();
		StaticWait(1500);
		booking.getBookedIternaryLink().click();
		
		reader = new Xls_Reader("./src/main/java/Org/testdata/TestDataAdactin.xlsx");
		
		String sheetName ="BookingHistory";
		
		//Add Sheetname
		
		if(! reader.isSheetExist(sheetName)){
			
			reader.addSheet(sheetName);
			
			reader.addColumn(sheetName, "Order Id");
			reader.addColumn(sheetName, "Total Price");
			
			System.out.println("Sheet "+sheetName+" created" );
		}
				
	

		//table headers xpath - driver.findElement(By.xpath("//td[@align='right']/table/tbody/tr[1]/td"));
		
		List<WebElement> orderid = driver.findElements(By.xpath("//td[@align='right']/table/tbody/tr/td[2]/input"));
		System.out.println("No of orders : "+orderid.size());
		
		List<WebElement> cost =driver.findElements(By.xpath("//td[@align='right']/table/tbody/tr/td[14]/input"));

		System.out.println("No of rows : "+	reader.getRowCount(sheetName));

		for (int i=0;i<orderid.size();i++) {

			String orderNo=orderid.get(i).getAttribute("value");
			String Bookingcost =cost.get(i).getAttribute("value");
			System.out.println(orderNo +" "+ Bookingcost);
			reader.setCellData(sheetName, "Order Id", i+2, orderNo);
			reader.setCellData(sheetName, "Total Price", i+2, Bookingcost);

		}
		System.out.println("No of rows : "+	reader.getRowCount(sheetName));

			
	}

}
