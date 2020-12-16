package Org.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGRetryFeature {
	
	@Test(priority=-2)
	public void TC1() {
		System.out.println("TC 1");
	}
	
	@Test(priority=1)
	public void TC2() {
		System.out.println("TC 2");
		Assert.assertTrue(false);
	}
	
	@Test(priority=2)
	public void TC3() {
		System.out.println("TC 3");
	}
	
	@Test(priority=-3 )
	public void TC4() {
		System.out.println("TC 4");
	}

}
