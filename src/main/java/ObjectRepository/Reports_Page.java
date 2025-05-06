package ObjectRepository;

import org.openqa.selenium.WebElement;

import io.appium.java_client.windows.WindowsDriver;

public class Reports_Page {

	private WindowsDriver<WebElement> driver;
    public Reports_Page(WindowsDriver<WebElement> driver) {
        this.driver = driver;
    }
    
    //stock report
    public WebElement stock() {
    	return driver.findElementByAccessibilityId("Stock");
        }
    
  //GST report
    public WebElement GST() {
    	return driver.findElementByAccessibilityId("GST");
        }
    
  //sales report
    public WebElement sales() {
    	return driver.findElementByAccessibilityId("Sales");
        }
    
  //purchases report
    public WebElement purchases() {
    	return driver.findElementByAccessibilityId("Purchases");
        }
    
  //Customer report
    public WebElement customer() {
    	return driver.findElementByAccessibilityId("Customer");
        }
    
}
