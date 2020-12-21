package Org.test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Org.Base.BaseClass;
import Org.ObjectRepository.Login1;
import Org.ObjectRepository.Search1;
import Org.testdata.ReadExcel;


public class AdactinTestTestNG extends BaseClass{

	Login1 login;
	Search1 searchPage ;
	
	@BeforeMethod
	public void setUp(){
		
		launchBrowser();
		maximize();
		deleteCockies();
		pageLoadTime(30);
		loadUrl(ReadExcel.ReadData("Login", 1, 0));
		
	}
	
	@Test(priority=1)
	public void loginTest(){
		
		login= new Login1();
		
		sendDataByXpath(login.getLogin().get(0), ReadExcel.ReadData("Login", 1, 1));
		sendDataByXpath(login.getLogin().get(1),ReadExcel.ReadData("Login", 1, 2));
		clickElement(login.getLoginButton());
		
	}
	
	@DataProvider
	public void getTestData() {
			
	}
	
	@Test(priority=2)
	public void validateAdactinImage(){
		
		searchPage = new Search1();
		
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
