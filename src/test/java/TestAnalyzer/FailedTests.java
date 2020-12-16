package TestAnalyzer;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class FailedTests implements IRetryAnalyzer{

	int counter=0;
	int retryLimit =3;
		
	public boolean retry(ITestResult result) {
		
		if(counter < retryLimit) {
			counter++;
			return true;
		}	
		return false;
	}
}

/*if test case fails and if that test with retryAnalyzer method , 
  then this FailedTests which is implementing 
  IRetryAnalyzer interface will be called
  and retry() method will be auto called

*/

//retry() ---returns true --then test case re runs
//retry()---returns false -then control will go to next test case