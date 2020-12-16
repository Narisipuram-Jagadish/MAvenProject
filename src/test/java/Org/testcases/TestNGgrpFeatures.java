package Org.testcases;

import org.testng.annotations.Test;

public class TestNGgrpFeatures {
	
	@Test(groups= {"SmokeTest"})
	public void login()  {
		System.out.println("Login");
	}
	
	@Test(priority=1, groups={"SmokeTest", "Sanitytest"})
	public void HomePage(){
		System.out.println("HomePage");
	}
	
	@Test(priority=2, groups= {"Sanitytest"})
	public void searchProduct() {	
		System.out.println("Search Product");	
	}
	
	@Test(priority=3 , groups= {"Sanitytest"})
	public void AddToCard() {
		System.out.println("Adding to cart");
	}
	
	@Test(priority=4, groups= {"SmokeTest"})
	public void Checkout() {
		System.out.println("Check out");	
	}
	
	@Test(priority=5, groups= {"RegressionTest"})
	public void payment() {
		System.out.println("payment");
	}
	
	@Test(priority=6, groups= {"RegressionTest"})
	public void placingOrder() {
		System.out.println("Order Placed");
	}	
}
