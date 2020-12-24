package Org.testcases;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

public class TestNGRetry {
	
	@Test
	public void TC5() {
		System.out.println("TC 5");
	}
	
	@Test
	public void TC6() {
		System.out.println("TC 6");
	}
	
	@Test
	public void TC7() {
		System.out.println("TC 7");
		Assert.assertEquals("actual"
				, "expecting",
				"Assertion message");
	}

}
