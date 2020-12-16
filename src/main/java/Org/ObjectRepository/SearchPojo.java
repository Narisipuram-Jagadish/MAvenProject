package Org.ObjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Org.Base.BaseClass;

public class SearchPojo extends BaseClass {
	
	public SearchPojo() {
		
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//select[@id='location']")
	 private WebElement location;
	
	@FindBy(xpath="//select[@id='hotels']")
	 private WebElement hotel;
	
	@FindBy(xpath="//select[@id='room_type']")
	 private WebElement room;
	
	@FindBy(xpath="//select[@id='room_nos']")
	 private WebElement roomNo;
	
	@FindBy(xpath="//select[@id='adult_room']")
	 private WebElement adultRoom;
	
	@FindBy(xpath="//select[@id='child_room']")
	 private WebElement childRoom;
	
	@FindBy(xpath="//input[@id='datepick_in']")
	 private WebElement checkinDate;
	
	@FindBy(xpath="//input[@id='datepick_out']")
	 private WebElement checkOutDate;
	
	@FindBy(id="Submit")
	 private WebElement SearchButton;

	
	
	
	public WebElement getLocation() {
		return location;
	}

	public WebElement getHotel() {
		return hotel;
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

	public WebElement getCheckOutDate() {
		return checkOutDate;
	}

	public WebElement getSearchButton() {
		return SearchButton;
	}
	
	
	

}
