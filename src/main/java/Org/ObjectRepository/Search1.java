package Org.ObjectRepository;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import Org.Base.BaseClass;

public class Search1 extends BaseClass{
	
		public Search1() {
			
			PageFactory.initElements(driver,this);
		}
		
	
		//this xpath identifying all select dropdowns, i can use list for these to identify uniquely
		//if i write only WebElement locatorname , it will identify the first matching.
		//I am using for 1st 2 elements
		@FindBy(xpath="//select[@class='search_combobox']")
		private List<WebElement> LocationHotel;
		
		
		
		//Acts like And operator.(All the locators must satisfy to uniquely identify)
		@FindBys({
			
			@FindBy(xpath="//select[@class='search_combobox']"),
			@FindBy(xpath="//select[@id='room_type']")
					
		})	
		private WebElement room;

		
		
		//Acts like OR operator , will identify if any of below locating methods identify element.
		@FindAll({
			@FindBy(xpath="//select[@id='room_nos']"),
			@FindBy(name="room_nos")
			
		})
		private WebElement roomNo;
		
		
		
		//we can use combined xpath like this also
		@FindBy(xpath="//select[@class='search_combobox'][@id='adult_room']")
		 private WebElement adultRoom;
		
		
		
		//we can identify using different locating strategies
		@FindBys({
			@FindBy(xpath="//select[@name='child_room']"),
			@FindBy(xpath="//select[@id='child_room']"),
		})
		private WebElement childRoom;
		
		
		
		@FindAll({
			@FindBy(name="datepick_in"),
			@FindBy(xpath="//input[@id='datepick_in']")
		})
		private WebElement checkinDate;
		
		
		
		//Even matching element is only one we can use like this with List
		@FindBy(xpath="//input[@id='datepick_out']")
		 private List<WebElement> checkOutDate;
		

		@FindBy(id="Submit")
		 private WebElement SearchButton;


		public List<WebElement> getLocationHotel() {
			return LocationHotel;
		}


		public WebElement getRoom() {
			return room;
		}


		public WebElement getRoomNo() {
			return roomNo;
		}


		public WebElement getAdultRoom() {
			return adultRoom;
		}


		public WebElement getChildRoom() {
			return childRoom;
		}


		public WebElement getCheckinDate() {
			return checkinDate;
		}


		public List<WebElement> getCheckOutDate() {
			return checkOutDate;
		}


		public WebElement getSearchButton() {
			return SearchButton;
		}
		
}
