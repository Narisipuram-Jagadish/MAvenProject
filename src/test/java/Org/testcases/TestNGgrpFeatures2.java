package Org.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGgrpFeatures2 {
	
	@BeforeMethod
	public void LaunchApp() {
		System.out.println("launch  app");
	}
		
	@Test(groups= {"SmokeTest"})
	public void Googlelogin()  {
		System.out.println("Login");
	}
	
	@Test(priority=1, groups={"SmokeTest", "Sanitytest"})
	public void GoogleHomePage(){
		System.out.println("HomePage");
	}
	
	@Test(groups={"SmokeTest", "Sanitytest"})
	public void GoogleImgTest() {
		System.out.println("Google Image Test");
	}
	
	@Test(groups= {"Sanitytest"})
	public void SearchBoxTest() {
		System.out.println("Search Box Test");
	}
	
	@Test(groups= {"Sanitytest"},
			invocationCount=3)
	public void SearchResultTest() {
		System.out.println("Search Result Test");
	}
			
	@Test(priority=2, groups= {"Sanitytest"})
	public void searchProduct() {	
		System.out.println("Search Product");	
	}
	
	@Test(priority=3 , groups= {"Sanitytest"})
	public void CartValue() {
		System.out.println("increasing cart value");
	}
	
	@Test(priority=4, groups= {"SmokeTest"})
	public void Checkout() {
		System.out.println("Check out");	
	}
	
	@Test(priority=5, groups= {"RegressionTest"})
	public void Googlepayment() {
		System.out.println("Gpay");
	}
	
	@Test(priority=6, groups= {"RegressionTest"})
	public void PayingBill() {
		System.out.println("Bll payed");
	}
	
	@AfterMethod
	public void logout() {
		System.out.println("Logout from app");
	}
}
