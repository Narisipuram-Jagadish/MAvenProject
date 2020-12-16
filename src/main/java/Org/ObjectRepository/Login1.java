package Org.ObjectRepository;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import Org.Base.BaseClass;

public class Login1 extends BaseClass {
	
public Login1() {
		
		PageFactory.initElements(driver,this);
	}
	
	//To maintain a cache for the WebElement-To increase the performance-These cached webelements will be accessed faster
	@CacheLookup
	@FindBy(xpath="//input[@class='login_input']")
	private List<WebElement> login;
		
	//Acts like And operator.(All the locators must satisfy to uniquely identify)
	
	@FindBys({
		
		@FindBy(xpath="//input[@type='Submit']"),
		@FindBy(xpath ="//input[@name='login']"),
		@FindBy(xpath="//input[@id='login']")
		
	})
	private WebElement LoginButton;
	
	

	public List<WebElement> getLogin() {
		return login;
	}

	public WebElement getLoginButton() {	
		return LoginButton;
	}
	
}
