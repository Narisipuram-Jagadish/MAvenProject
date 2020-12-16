package Org.testcases;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGFeatures {
	
	@BeforeMethod
	public void LaunchApp() {
		System.out.println("launch  app");
	}
	
	@Test
	public void Login() {
		System.out.println("Login Test");
	}
	
	@Test(dependsOnMethods= {"Login"})
	public void GoogleImgTest() {
		System.out.println("Google Image Test");
	}
	
		
	@Test(invocationCount=4)
	public void SearchBoxTest() {
		System.out.println("Search Box Test");
	}
	
	@Test(dependsOnMethods= {"Login","SearchBoxTest"},invocationCount=3)
	public void SearchResultTest() {
		System.out.println("Search Result Test");
	}
	
	@AfterMethod
	public void logout() {
		System.out.println("Logout from app");
	}	
}
