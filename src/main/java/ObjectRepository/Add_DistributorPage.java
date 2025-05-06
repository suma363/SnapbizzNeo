package ObjectRepository;

import org.openqa.selenium.WebElement;

import io.appium.java_client.windows.WindowsDriver;

public class Add_DistributorPage {
	
	private WindowsDriver<WebElement> driver;

    public Add_DistributorPage(WindowsDriver<WebElement> driver) {
        this.driver = driver;
    }
    
    public WebElement getClickAddDistributor() {
        return driver.findElementByName("Add Distributor");       
    }
    
    public WebElement getDistPhn() {
        return driver.findElementByAccessibilityId("DistributorPhone");       
    }
    
    public WebElement getDistAltPhn() {
        return driver.findElementByAccessibilityId("DistributorAlternatePhone");       
    }
    
    public WebElement getDistName() {
        return driver.findElementByAccessibilityId("DistributorName");       
    }
    
    public WebElement getDistEmail() {
        return driver.findElementByAccessibilityId("DistributorEmail");       
    }
    
    public WebElement getDistSalesPersonName() {
        return driver.findElementByAccessibilityId("SalesPersonName");       
    }
    
    public WebElement getDistSaveBtn() {
        return driver.findElementByAccessibilityId("SubmitButton");       
    }
    
    public WebElement getDistCancelBtn() {
        return driver.findElementByName("Cancel");       
    }
    
    //Business logic
    public void addDistributors(String phoneNo,String DistName) {
    	
    	getClickAddDistributor().click();
    	getDistPhn().clear();
    	getDistPhn().sendKeys(phoneNo);
    	
    	getDistName().clear();
    	getDistName().sendKeys(DistName);
    	
    	getDistSaveBtn().click();
    	
    }
}
