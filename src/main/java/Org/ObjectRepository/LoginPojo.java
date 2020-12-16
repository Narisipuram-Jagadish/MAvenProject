package Org.ObjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import Org.Base.BaseClass;

public class LoginPojo extends BaseClass {

	//1. Default Constructor
	public LoginPojo() {
		
		PageFactory.initElements(driver,this);
	}
	
	//2.private WebElements
	
	 @FindBy(xpath="//input[@id='username']")
	 private WebElement username;
	 
	 
	 // we can also write using how 
	 @FindBy(how =How.XPATH, using="//input[@id='password']")
	 private WebElement password;
	 
	 
	 @FindBy(xpath="//input[@id='login']")
	 private WebElement LoginButton;

	 //3.Getters
	 
	 public WebElement getUsername() {
		return username;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getLoginButton() {
		return LoginButton;
	}
	 	
}


