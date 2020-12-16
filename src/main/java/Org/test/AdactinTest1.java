package Org.test;

import Org.Base.BaseClass;
import Org.ObjectRepository.Login1;
import Org.ObjectRepository.Search1;
import Org.testdata.ReadExcel;

public class AdactinTest1 extends BaseClass{

	public static void main(String[] args) {

		launchBrowser();
		maximize();
		deleteCockies();
		pageLoadTime(30);
				
		loadUrl(ReadExcel.ReadData("Login", 1, 0));
		
		Login1 login= new Login1();
		
		sendDataByXpath(login.getLogin().get(0), ReadExcel.ReadData("Login", 1, 1));
		
		sendDataByXpath(login.getLogin().get(1),ReadExcel.ReadData("Login", 1, 2));
		
		clickElement(login.getLoginButton());

		Search1 searchPage = new Search1();
		
		SelectDropdown(searchPage.getLocationHotel().get(0), ReadExcel.ReadData("Search", 1, 0));
		
		SelectDropdownValue(searchPage.getLocationHotel().get(1),ReadExcel.ReadData("Search", 1, 1));
		
		SelectDropdown(searchPage.getRoom(),ReadExcel.ReadData("Search", 1, 2));
		
		SelectDropdownIndex(searchPage.getRoomNo(),Integer.parseInt(ReadExcel.ReadData("Search", 1, 3)));
		
		SelectDropdownIndex(searchPage.getAdultRoom(),Integer.parseInt(ReadExcel.ReadData("Search", 1, 4)));
		
		SelectDropdownIndex(searchPage.getChildRoom(),Integer.parseInt(ReadExcel.ReadData("Search", 1, 5)));
		
		sendDataByXpath(searchPage.getCheckinDate(),"29/11/2020");
		
		sendDataByXpath(searchPage.getCheckOutDate().get(0),"30/12/2020");
		
		clickElement(searchPage.getSearchButton());
		
		
	}

}
