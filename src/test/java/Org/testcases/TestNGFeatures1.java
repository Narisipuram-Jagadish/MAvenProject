package Org.testcases;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGFeatures1 {

	@BeforeMethod
	public void LaunchApp() {
		System.out.println("launch  app"+ Thread.currentThread().getId());
	}
	
	@Test(priority=-2)
	public void TC5() {
		System.out.println("TC 5 "+Thread.currentThread().getId() );
	}
	
	@Test(priority=1, enabled=false)
	public void TC3() {
		System.out.println("TC 3 "+Thread.currentThread().getId());
	}
	
	@Test(priority=2, enabled = true)
	public void TC2() {
		System.out.println("TC 2 "+Thread.currentThread().getId());
	}
	
	@Test(priority=-3 )
	public void TC4() {
		System.out.println("TC 4 "+Thread.currentThread().getId());
	}
	 
	//No priority considered as 0 priority
	@Test
	public void TC1() {
		System.out.println("TC 1 "+Thread.currentThread().getId());
	}
	
	@AfterMethod
	public void logout() {
		System.out.println("Logout from app "+Thread.currentThread().getId());
	}	
}
