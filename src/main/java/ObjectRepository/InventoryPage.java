package ObjectRepository;

import org.openqa.selenium.WebElement;
import io.appium.java_client.windows.WindowsDriver;

public class InventoryPage {
	
	private WindowsDriver<WebElement> driver;

    public InventoryPage(WindowsDriver<WebElement> driver) {
        this.driver = driver;
    }
	
    //click on add products
    public void clickAddProducts() {
    	driver.findElementByName("Add Product").click();
    }
    
  //click on purchases
    public void clickOnPurchases() {
    	driver.findElementByAccessibilityId("Purchases").click();
    }
    
    
	
}
