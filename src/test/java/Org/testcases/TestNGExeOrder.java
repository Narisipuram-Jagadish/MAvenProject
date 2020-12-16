package Org.testcases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGExeOrder {

	//Pre Conditions annotations -Starting with @Before
	@BeforeSuite
	public void setup() {
		System.out.println("SetUp system properties for chrome "+Thread.currentThread().getId());
	}
	
	@BeforeTest
	public void launchBrowser() {
		System.out.println("launch chrome browser "+Thread.currentThread().getId());
	}
	
	@BeforeClass
	public void enterURL() {
		System.out.println("enter URL "+Thread.currentThread().getId());
	}
	
	@BeforeMethod
	public void login() {
		System.out.println("login to app "+Thread.currentThread().getId());
	}
	
	//test cases -starting with @Test
	@Test
	public void googleTitleTest() {
		System.out.println("Google Title Test "+Thread.currentThread().getId());
	}
	
	@Test
	public void SearchBox() {
		System.out.println("Search box dispaled Test "+Thread.currentThread().getId());
	}
	
	@Test
	public void GoogleImg() {
		System.out.println("GoogleImg dispaled Test "+Thread.currentThread().getId());
	}
	
	//Post Conditions - starting with @After 
	@AfterMethod
	public void logout() {
		System.out.println("Logout from app "+Thread.currentThread().getId());
	}
	
	
	@AfterClass
	public void deleteAllCookies() {
		System.out.println("Delete all cookies "+Thread.currentThread().getId());
	}
	@AfterTest
	
	public void closeBrowser() {
		System.out.println("Close Browser "+Thread.currentThread().getId());
	}
	
	@AfterSuite
	public void CloseSetUP() {
		System.out.println("Close Complete SetUp "+Thread.currentThread().getId());
	}
}








