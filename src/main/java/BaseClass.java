import java.awt.AWTException;
import java.awt.List;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {
      	
	    public static WebDriver driver;
	    static JavascriptExecutor js;
	    static Robot robot;
	    static Actions action;
	    static Select select;
	    static ChromeOptions opt;
	    static TakesScreenshot ts;
	    static WebElement element;
		//1
      	public static void launchBrowser() {
			System.setProperty("webdriver.chrome.driver", "B:\\Eclipse\\Selenium\\chromedriver.exe");
			 driver = new ChromeDriver();
		}
		//2
      	public static void maximize() {
			driver.manage().window().maximize();
		}
		//3
		public static void deleteCockies() {
			driver.manage().deleteAllCookies();
		}
		//4
		public static void pageLoadTime(int time) {
			driver.manage().timeouts().pageLoadTimeout(time, TimeUnit.SECONDS);
		}
		//5
		public static void loadUrl(String url) {
			driver.get(url);
		}
		//6
		public static void clickElement(WebElement element) {
			element.click();		
		}
		//7
		public static void sendDataByXpath(WebElement element,String text) {
			element.sendKeys(text);
		}
		//8
		public static void acceptAlert() {
			driver.switchTo().alert().accept();
		}
		//9
		public static void cancelAlert() {
			driver.switchTo().alert().dismiss();
		}
		//10
		public static String captureAlertMsg() {
			String	textalert=driver.switchTo().alert().getText();
			return textalert;
		}
		//11
		public static void sendTextToAlert(String text) {
			driver.switchTo().alert().sendKeys(text);
		}
		//12	
		public static String getParentWindow() {
			String parentWindowId=	driver.getWindowHandle();
			return parentWindowId;
		}
		//13
		public static void NavigateToParentWindow() {
			String parentWindowId=	driver.getWindowHandle();
			driver.switchTo().window(parentWindowId);

		}
		//14
		public static void navigateToChildWindow() {
			
			//After opening tab window
			Set<String> windowids = driver.getWindowHandles();
			//window handles provides the uniqueid's of whatever new window opens
			//we keep this unique window ids under hash set
			//in array list will accepts the duplicates as well.
			Iterator<String> iterate =  windowids.iterator();
			//System.out.println(iterate.next()); //first window (main window)
			String firstWindow = iterate.next();
			String tabWiindow = iterate.next();
			driver.switchTo().window(tabWiindow);
		}
		
		//15
		public static int getNoOfWindows() {
			
			Set<String> windowids = driver.getWindowHandles();
			int no =windowids.size();
			return no;	
		}
		
		//16
		public static String getPageTitle() {
			String title =driver.getTitle();
			return title;
		}
		
		//17
		public static void StaticWait(int sec) {
			
			try {
				Thread.sleep(sec);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		
		//18 -// now execute query which actually will scroll until that element is not appeared on page.

		public static void JSScrollIntoViewDown(WebElement element) {
			js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].scrollIntoView(true);", element);
			StaticWait(500);
		}
		//19 - 
		public static void JSScrollIntoViewUp(WebElement element) {
			js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].scrollIntoView(false);", element);
			StaticWait(500);
		}
		//20
		public static void ScrolldownWebpageToEnd() {
			
			js = (JavascriptExecutor)driver;
	        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	        //This will scroll the web page till end.		
	        //"document.body.scrollHeight" returns the complete height of the body i.e web page.
		}
		//21
		public static void ClickUsingJavaScript(WebElement element ) {
			js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].click();", element);
		}
		//22
		public static void sendTextusingJavaScript(WebElement webl, String text) {
			
			js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].value='"+text+"';", webl);
		}
		//23
		public static void PressEnter(String locator) {

			driver.findElement(By.xpath(locator)).sendKeys(Keys.ENTER);
		}
		
		//24
		public static void RobotPressEnter() {
						
			try {
				robot = new Robot();
				robot.keyPress(KeyEvent.VK_ENTER);
				robot.keyRelease(KeyEvent.VK_ENTER);
				
			} catch (AWTException e) {
				e.printStackTrace();
			}
		}
		
		//25 
		public static void ActionsEnter() {
			action = new Actions(driver);
			action.sendKeys(Keys.ENTER).build().perform();
		}
		
		//26
		public static void RobotPressTab() {
			
			try {
				robot = new Robot();
				robot.keyPress(KeyEvent.VK_TAB);
				robot.keyRelease(KeyEvent.VK_TAB);
				
			} catch (AWTException e) {
				e.printStackTrace();
			}
		}
		
		//27
		public static void RobotPressUpArrow() {
			
			try {
				robot = new Robot();
				robot.keyPress(KeyEvent.VK_UP);
				robot.keyRelease(KeyEvent.VK_UP);
				
			} catch (AWTException e) {
				e.printStackTrace();
			}
		}

		//28

		public static void RobotPressDownArrow() {
	
		try {
			robot = new Robot();
			robot.keyPress(KeyEvent.VK_DOWN);
			robot.keyRelease(KeyEvent.VK_DOWN);
			
		 } catch (AWTException e) {
			e.printStackTrace();
			}
		}
		
		//29
		public static void RobotPageDown() {
			
			try {
				robot = new Robot();
				robot.keyPress(KeyEvent.VK_PAGE_DOWN);
				robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
				
			 } catch (AWTException e) {
				e.printStackTrace();
				}
			}
		
		//30
		public static  void RobotPageUP() {
			
			try {
				robot = new Robot();
				robot.keyPress(KeyEvent.VK_PAGE_UP);
				robot.keyRelease(KeyEvent.VK_PAGE_UP);
				
			 } catch (AWTException e) {
				e.printStackTrace();
				}
			}
		//31
		public static void dragAndDrop(WebElement source,WebElement target) {
			action = new Actions(driver);
			action.clickAndHold(source).moveToElement(target).release().build().perform();
		}
		
		//32
		public static void RightClick(WebElement target) {
			action = new Actions(driver);
			action.contextClick(target).build().perform();
		}
		
		//33
		public static void NavigateFwd() {
			driver.navigate().forward();
		}
		
		
		//34
		public static void NavigateBack() {
			driver.navigate().back();
		}
		//35
		public static void closewindow() {
			driver.close();
		}
		
		//36
		public static void closebrowser() {
			driver.quit();
		}
		
		//37
		public static void SelectDropdown(WebElement locator ,String dropdownText) {
			select = new Select(locator);
			select.selectByVisibleText(dropdownText);	
		}
		//38
		public static void SelectDropdownIndex(WebElement locator ,int index) {
			select = new Select(locator);
			select.selectByIndex(index);
		}
		
		//39
		public static void SelectDropdownValue(WebElement locator ,String value) {
			select = new Select(locator);
			select.selectByValue(value);
		}
		
		//40
		public static List SelectAll(WebElement locator) {
			select = new Select(locator);
			List options =(List) select.getOptions();
			return options;
		}
		
		//41
		public static void VerfiyRadioButtonChecked(WebElement radiobutton) {

			radiobutton.getAttribute("checked");
			//it will print null if not checked
			//true if checked
		}
				
		//42
		public static WebElement findElementByText(String text) {
			WebElement elemenet = driver.findElement(By.xpath("//*[contains(text(),'"+text+"')]"));
			return elemenet;
		}
		
		//43
		public static int CheckNoOfFrames() {
			
			int size = driver.findElements(By.tagName("iframe")).size();
			return size;
		}
		
		//44
		public static void switchFrame() {
			driver.switchTo().frame(0);
		}
		//45
		public static void MoveToParentFrame() {
		    driver.switchTo().parentFrame();
		}
		//46
		public static void disableNotifications() {
			 opt = new ChromeOptions();
			 opt.addArguments("--disable-notifications");
			 System.setProperty("webdriver.chrome.driver", "B:\\Eclipse\\Selenium\\chromedriver.exe");
			 driver = new ChromeDriver(opt);
		}
		
		//47
		public static void highlightElement(WebElement element) {
			js = (JavascriptExecutor)driver;
			String bgcolor = element.getCssValue("backgroundColor");
			for (int i=0;i<10;i++) {
				changeColor("rgb(0,200,0)",element);
				changeColor(bgcolor,element);

			}
		}
		
		public static void changeColor(String color,WebElement element) {
			js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].style.backgroundColor='"+color+"'", element);
			
			try {
				Thread.sleep(100);
			}catch(InterruptedException e) {
				
			}
		}
		
				
		public static void userdir() {
			String dir =System.getProperty("user.dir");
			System.out.println(dir);	
		}
		
		//48
		public static void printPageTitle() {
			System.out.println(driver.getTitle());
		}
		
		//49
		public static void dynamicwait(int sec) {
			
			driver.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);
		}
		
		//50
		public static void explwait(WebElement element, int wait_time) {
			
			WebDriverWait wait = new WebDriverWait(driver,wait_time);
			wait.until(ExpectedConditions.visibilityOf(element));
		}
		
		//51
		 public static WebElement getElement(String xpath) {
			 element =driver.findElement(By.xpath(xpath));
			 return element;
		}
}



