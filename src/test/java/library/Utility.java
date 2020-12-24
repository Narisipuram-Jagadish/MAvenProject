package library;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Utility {

	public static void captureScreenshot(WebDriver driver , String screenShotName) {
		
		try {
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		
		File src = ts.getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(src, new File("./screenShots/"+screenShotName+".png"));
		
		System.out.println("ScreenShot taken");
		}
		catch (IOException e) {
			System.out.println("Exception while taking screen shot "+e.getMessage());
		}
	}
	
	
}
