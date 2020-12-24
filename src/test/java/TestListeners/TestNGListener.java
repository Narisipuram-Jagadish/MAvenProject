package TestListeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import Org.Base.BaseClass;

public class TestNGListener extends BaseClass implements ITestListener{

	public void onFinish(ITestContext result) {
	}

	public void onStart(ITestContext result) {
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onTestFailure(ITestResult result) {
		
		System.out.println("Test Cases failed and details are : "+result.getName());
		captureScreenshot(result.getName());
		System.out.println(result.getMethod().getMethodName());//prints current test method		
	}

	public void onTestSkipped(ITestResult result) {
		
	}

	public void onTestStart(ITestResult result) {
		
	}

	public void onTestSuccess(ITestResult result) {
		
	}
}
