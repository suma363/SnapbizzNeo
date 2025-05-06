package ObjectRepository;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.windows.WindowsDriver;

public class PurchaseReport_Page {
	
	private WindowsDriver<WebElement> driver;
    public PurchaseReport_Page(WindowsDriver<WebElement> driver) {
        this.driver = driver;
    }
    
    //purchase report
    public WebElement clickPurchaseReport() {
    	return driver.findElementByName("Purchase Report");
    }
    
    public WebElement previewBtn() {
    	return driver.findElementByName("Preview");
    }
    
    //business class
    public void purchaseReport() throws Throwable {
   		
    	WebElement reportBtn = clickPurchaseReport();
    	driver.executeScript("arguments[0].scrollIntoView(true);", reportBtn);
    	reportBtn.click();

        // Optionally wait and click Preview
        Thread.sleep(500);
        previewBtn().click();
    	
    }
  
}
