package Org.ObjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Org.Base.BaseClass;

public class HomePage extends BaseClass {
	
	public HomePage() {
		
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//a[text()='Booked Itinerary']")
	private WebElement BookedIternaryLink;
	
	@FindBy(xpath="//a[text()='Search Hotel']")
	private WebElement SearchHotel;
	
	@FindBy(xpath="//a[text()='Change Password']")
	private WebElement ChangePwdLink;
	
	@FindBy(xpath="//a[text()='Logout']")
	private WebElement LogoutLink;

	
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
