package Org.ObjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Org.Base.BaseClass;

public class BookingIternaryPage extends BaseClass {
	
public BookingIternaryPage() {
		
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//input[@name='order_id_text']")
	private WebElement SearchOrderID;
	
	@FindBy(xpath="//input[@type='submit'][@id='search_hotel_id']")
	private WebElement GoButton;
	
	@FindBy(xpath="//a[text()='Booked Itinerary']")
	private WebElement BookedIternaryLink;
	
	@FindBy(xpath="//a[text()='Search Hotel']")
	private WebElement SearchHotel;
	
	@FindBy(xpath="//a[text()='Change Password']")
	private WebElement ChangePwdLink;
	
	@FindBy(xpath="//a[text()='Logout']")
	private WebElement LogoutLink;

	public WebElement getSearchOrderID() {
		return SearchOrderID;
	}

	public WebElement getGoButton() {
		return GoButton;
	}

	public WebElement getBookedIternaryLink() {
		return BookedIternaryLink;
	}

	public WebElement getSearchHotel() {
		return SearchHotel;
	}

	public WebElement getChangePwdLink() {
		return ChangePwdLink;
	}

	public WebElement getLogoutLink() {
		return LogoutLink;
	}
	
	
	

}
