package Org.test;

import Org.Base.BaseClass;
import Org.ObjectRepository.LoginPojo;
import Org.ObjectRepository.SearchPojo;
import Org.testdata.ReadExcel;

public class AdactinTest extends BaseClass{

	public static void main(String[] args) {

		launchBrowser();
		maximize();
		deleteCockies();
		pageLoadTime(30);
				
		loadUrl(ReadExcel.ReadData("Login", 1, 0));
		
		LoginPojo login= new LoginPojo();
		
		sendDataByXpath(login.getUsername(), ReadExcel.ReadData("Login", 1, 1));
		
		sendDataByXpath(login.getPassword(),ReadExcel.ReadData("Login", 1, 2));
		
		clickElement(login.getLoginButton());
		
		SearchPojo searchPage = new SearchPojo();
		
		SelectDropdown(searchPage.getLocation(), ReadExcel.ReadData("Search", 1, 0));
		
		SelectDropdownValue(searchPage.getHotel(),ReadExcel.ReadData("Search", 1, 1));
		
		SelectDropdown(searchPage.getRoom(),ReadExcel.ReadData("Search", 1, 2));
		
		SelectDropdownIndex(searchPage.getRoomNo(),Integer.parseInt(ReadExcel.ReadData("Search", 1, 3)));
		
		SelectDropdownIndex(searchPage.getAdultRoom(),Integer.parseInt(ReadExcel.ReadData("Search", 1, 4)));
		
		SelectDropdownIndex(searchPage.getChildRoom(),Integer.parseInt(ReadExcel.ReadData("Search", 1, 5)));
		
		sendDataByXpath(searchPage.getCheckinDate(),"29/11/2020");
		
		sendDataByXpath(searchPage.getCheckOutDate(),"30/12/2020");
		
		clickElement(searchPage.getSearchButton());

	}

}
