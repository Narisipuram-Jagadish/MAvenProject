package Org.testcases;

import org.testng.annotations.Test;

public class TestNGFeatures2 {
	
	@Test(priority=3)
	public void TC5() {
		System.out.println("TC 8");
	}
	
	@Test(priority=1,timeOut=200)
	public void TC6() throws InterruptedException {
		System.out.println("TC 6");
		Thread.sleep(300);
	}
	
	@Test(invocationTimeOut=1)
	public void TC7() {
		int i=1;
		while(i==1) {
			System.out.println(i + "TC 7");
		}
	}
	
	@Test(priority=3)
	public void TC8() {
		System.out.println("TC 8");
	}
	
	@Test(priority=4, expectedExceptions=ArithmeticException.class)
	public void TC9() {
		
		System.out.println("TC 9");
		System.out.println(9/0); // this will fail the test case , but due to providing expected exception 
		//this Test case got passed
	}
}
