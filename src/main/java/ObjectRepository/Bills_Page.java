package ObjectRepository;

import org.openqa.selenium.WebElement;

import io.appium.java_client.windows.WindowsDriver;

public class Bills_Page {
	
	private WindowsDriver<WebElement> driver;
    public Bills_Page(WindowsDriver<WebElement> driver) {
        this.driver = driver;
    }

    // Locators
    public WebElement getProdAutoSugg() {
        return driver.findElementByName("SnapBilling.Services.AppServices.ProductPackCompact");
    }
    
    public WebElement getQty() {
        return driver.findElementByAccessibilityId("QuantityTextbox");
    }
    
    
}
