package TestAnalyzer;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.ITestAnnotation;

public class AllFailedTests implements IAnnotationTransformer{
	
	public void transform(ITestAnnotation annotation, Class testclass,
			Constructor testConstructor,Method testMethod) {
		
		IRetryAnalyzer r = annotation.getRetryAnalyzer();
		
		if(r==null) {
			
			annotation.setRetryAnalyzer(TestAnalyzer.FailedTests.class);
		}
	}
}


/*

create a class implemeting IAnnotationTransformer interface and implement the unimplemented method transform()

this method will take that ITestAnnotation refernce and other arguments coming from java reflect API

most of the listners are developed using java reflection API

and this ITestAnnotation refernce points to class which implements IRetryAnalyzer

no where its provided how this works , its hidden code logic implemeted by testng for us.


*/