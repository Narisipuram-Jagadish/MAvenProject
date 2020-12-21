package TestAnalyzer;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import TestAnalyzer.RetryAnalyzer;

public class MyTransformer implements IAnnotationTransformer {

	public void transform(ITestAnnotation annotation, Class testClasses, Constructor testConstructor, Method testMethod) {
		
		annotation.setRetryAnalyzer(RetryAnalyzer.class);
	}

	
}
