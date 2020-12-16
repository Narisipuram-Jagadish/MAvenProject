package Org.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestNGAssertions {

	@Test
	public void hardAssertions() {
		
		System.out.println("Open Browser");
		Assert.assertEquals(true, true); //passing assertion
		System.out.println("URL launched");
		Assert.assertEquals("expected", "actual","message validation failed");
		System.out.println("Login");
		Assert.assertEquals(true, true);
	}
	
	@Test
	public void hardAssertions2() {
		
		System.out.println("Open Browser");
		Assert.assertEquals(true, true); //passing assertion
		System.out.println("URL launched");
		Assert.assertEquals("expected", "expected","message validation failed");
		System.out.println("Login");
		Assert.assertEquals(true, true);
	}
	
	@Test
	public void softAssertions() {
		
		SoftAssert softAssert = new SoftAssert();
		System.out.println("Open Browser");
		softAssert.assertEquals(true, false); //passing assertion
		System.out.println("URL launched");
		softAssert.assertEquals("expected", "actual","message validation failed");
		System.out.println("Login");
		softAssert.assertEquals(true, false);
		System.out.println("Home page launched");
		
	}
	
	@Test
	public void softAssertions2() {
		
		SoftAssert softAssert1 = new SoftAssert();
		
		System.out.println("Open Browser");
		softAssert1.assertEquals(true, false); //passing assertion
		System.out.println("URL launched");
		softAssert1.assertEquals("expected", "actual","message validation failed");
		System.out.println("Login");
		softAssert1.assertEquals(true, false);
		System.out.println("Home page launched");
		softAssert1.assertAll();
		/*there are 3 assertion failures , but i want to fail with all the information,
		  then i need to assertAll
		 softAssert object will store all assertion failures and mark it as fail once it is 
		 written assertAll
		*/
	}
	


}









