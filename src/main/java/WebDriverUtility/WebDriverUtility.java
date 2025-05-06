package WebDriverUtility;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import io.appium.java_client.windows.WindowsDriver;

public class WebDriverUtility {
	
	 private WindowsDriver<WebElement> driver;
	
   public void waitForPageLoad(WindowsDriver<WebElement> driver) {
	  // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
		
}
