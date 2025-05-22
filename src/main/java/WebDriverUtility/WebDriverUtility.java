package WebDriverUtility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	
public void waitForPageLoad(WebDriver driver) {
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
	}
	
	public void waitForElementPresent(WebDriver driver, WebElement element) {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
//	public void waitForElementTobeClickable(WebDriver driver, WebElement element){
//	WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
//	wait.until(ExpectedConditions.elementToBeClickable(element));
//	}

	public void waitForElementTobeClickable(WebDriver driver, WebElement element){
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(element));
		} catch (Exception e) {
			// try JavaScript click as fallback or log useful info
			System.out.println("Element not clickable immediately, retrying with JS...");
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", element);
		}
	}


	public void waitForElementTobeSelected(WebDriver driver, WebElement element) {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeSelected(element));
	}
   
   public void waitForElementTitleContains(WebDriver driver, String title) {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.titleContains(title));
	}
   public void waitForAlertPresent(WebDriver driver, String title) {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.alertIsPresent());
	}
   

	
	public void switchToTabOnURL(WebDriver driver, String partialURL) {
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();
		
		while(it.hasNext()) {
			String windowID = it.next();
			driver.switchTo().window(windowID);
			
			String actUrl = driver.getCurrentUrl();
			if(actUrl.contains("partialURL")){
				break;
			}
		}
	}
		
		public void switchToTabOnTitle(WebDriver driver, String partialTitle) {
			Set<String> set = driver.getWindowHandles();
			Iterator<String> it = set.iterator();
			
			while(it.hasNext()) {
				String windowID = it.next();
				driver.switchTo().window(windowID);
				
				String actUrl = driver.getTitle();
				if(actUrl.contains("partialURL")){
					break;
				}
			}
		}
		
		public void switchToFrame(WebDriver driver, int Index) {
			driver.switchTo().frame(Index);	
		}
		
		public void switchToFrame(WebDriver driver, String nameID) {
			driver.switchTo().frame(nameID);	
		}
		
		public void switchToFrame(WebDriver driver, WebElement element) {
			driver.switchTo().frame(element);	
		}
		
		public void switchToParentFrame(WebDriver driver, WebElement element) {
			driver.switchTo().parentFrame();	
		}
		public void switchToDefaultFrame(WebDriver driver, WebElement element) {
			driver.switchTo().defaultContent();	
		}
		
		
		public void switchToAlertAndAccept(WebDriver driver) {
			driver.switchTo().alert().accept();
		}
		
		public void switchToAlertAndCancel(WebDriver driver) {
			driver.switchTo().alert().dismiss();
		}
		
		public Select dropdown(WebElement element) {
			Select sel = new Select(element);
			return sel;
		}
		
		public void select(WebElement element , String text) {
			dropdown(element).selectByVisibleText(text);		
		}
		
		public void select(WebElement element , int index) {
			dropdown(element).selectByIndex(index);		
		}
		
		public void selectByValue(WebElement element , String value) {
			dropdown(element).selectByValue(value);	
		}
	
		public void maximizeWindow(WebDriver driver) {
			driver.manage().window().maximize();
		}
		public void minimizeWindow(WebDriver driver) {
			driver.manage().window().minimize();
		}
		
		public Actions action(WebDriver driver) {
			Actions act = new Actions(driver);
			return act;		
		}
		

		public void mouseMoveOnElement(WebDriver driver, WebElement element) {
			action(driver).moveToElement(element).perform();
		}
	
		public void doubleClick(WebDriver driver, WebElement element ){
			action(driver).doubleClick(element).perform();			
		}
		
		public void dragAndDrop(WebDriver driver, WebElement src , WebElement dest ){
			action(driver).dragAndDrop(src, dest).perform();		
		}
		
		public void rightClick(WebDriver driver, WebElement element ){
			action(driver).contextClick().perform();			
		}
		
		public void sendKeys(WebDriver driver, WebElement element , String text){
			action(driver).sendKeys(text).perform();
		}
		
		public void scrollToElement(WebDriver driver, WebElement element){
			action(driver).scrollToElement(element).perform();
		}
		
		public void scrollByAmount(WebDriver driver, int x , int y){
			action(driver).scrollByAmount(x, y).perform();
		}
		
		public void webElementScreenshot(WebElement element , String name) throws IOException {
			JavaUtility jLib = new JavaUtility();
			File src = element.getScreenshotAs(OutputType.FILE);
			File dest = new File("./Screenshot/" +name+ jLib.getSystemDateyyyyMMdd()+".png");
		    org.openqa.selenium.io.FileHandler.copy(src, dest);
			
			
		}
		
		public void webPageScreenshot(WebDriver driver ,WebElement element , String pagename) throws IOException {
			JavaUtility jLib = new JavaUtility();
			TakesScreenshot ts = (TakesScreenshot) driver;
			File src = ts.getScreenshotAs(OutputType.FILE);
			File dest = new File("./Screenshot/; "+pagename+ jLib.getSystemDateyyyyMMdd()+".png");
			org.openqa.selenium.io.FileHandler.copy(src, dest);
			
			
		}
		public void javaScriptScrollDown(WebDriver driver , int scrollamount) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0, "+ scrollamount+ ");");

		}
		
		public void scrollUntilEleToBeVisible(WebDriver driver, WebElement element) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			int y = element.getLocation().getY();
			js.executeScript("window.scrollBy(0,"+y+");");
		}

	public void slowType(WebElement element, String text, int delayInMillis) {
		element.clear();
		for (char ch : text.toCharArray()) {
			element.sendKeys(String.valueOf(ch));
			try {
				Thread.sleep(delayInMillis);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt(); // Best practice
				e.printStackTrace();
			}
		}
	}

}
